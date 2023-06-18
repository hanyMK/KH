package com.kh.board.topten.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.board.offer.model.vo.OfferBoard;
import com.kh.board.topten.model.vo.SelectAll;
import com.kh.common.model.vo.PageInfo;

public class TopTenDao {
	private Properties prop = new Properties();
	
	public TopTenDao() {
		String fileName = TopTenDao.class.getResource("/sql/board/topTen/topTen-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<SelectAll> selectTopTenList(Connection conn){
		
		ArrayList<SelectAll> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectTopTenList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				SelectAll tt = new SelectAll();
				
				
				tt.setBoardNo(rset.getInt("BOARD_NO"));
				tt.setBoardType(rset.getString("BOARD_TYPE"));
				tt.setBoardTitle(rset.getString("BOARD_TITLE"));
				tt.setNickName(rset.getString("NICKNAME"));
				tt.setCreateDate(rset.getString("CREATE_DATE"));
				tt.setBoardCount(rset.getInt("BOARD_COUNT"));
				
				
				list.add(tt);

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;

	}
	
	
	public ArrayList<SelectAll> selectTopTenTenList(Connection conn){
		
		ArrayList<SelectAll> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectTopTenTenList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				SelectAll tt = new SelectAll();
				
				String type = "";
				
				switch(rset.getString("BOARD_TYPE")) {
				case "A    " : type = "공지사항"; break;
				case "B    " : type = "익명"; break;
				case "C    " : type = "바프"; break;
				case "D    " : type = "챌린지"; break;
				case "E    " : type = "리뷰"; break;
				case "F    " : type = "양도"; break;
				case "G    " : type = "구인"; break;
				}
				
				tt.setBoardNo(rset.getInt("BOARD_NO"));
				tt.setBoardType(type);
				tt.setBoardTitle(rset.getString("BOARD_TITLE"));
				tt.setNickName(rset.getString("NICKNAME"));
				tt.setCreateDate(rset.getString("CREATE_DATE"));
				tt.setBoardCount(rset.getInt("BOARD_COUNT"));
				
				
				list.add(tt);
				
				// System.out.println(rset.getString("BOARD_TYPE"));
				// System.out.println(list);
				// System.out.println(type);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;

	}

}
