package com.kh.board.totalSearch.model.dao;


import static com.kh.common.JDBCTemplate.close;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.board.topten.model.dao.TopTenDao;
import com.kh.board.totalSearch.model.vo.TotalAll;

public class TotalDao {
	
private Properties prop = new Properties();
	
	public TotalDao() {
		String fileName = TopTenDao.class.getResource("/sql/board/total/total-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<TotalAll> totalSearch(Connection conn, String key){
		
		ArrayList<TotalAll> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("totalSearch");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, key);
			pstmt.setString(2, key);
			pstmt.setString(3, key);
			pstmt.setString(4, key);
			pstmt.setString(5, key);
			pstmt.setString(6, key);
			pstmt.setString(7, key);
			

			rset = pstmt.executeQuery();
			
			
			while(rset.next()) {

				TotalAll ta = new TotalAll();
				
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
				
				
				ta.setBoardNo(rset.getInt("BOARD_NO"));
				ta.setBoardTitle(rset.getString("BOARD_TITLE"));
				ta.setBoardContent(rset.getString("BOARD_CONTENT"));
				ta.setCategory(rset.getString("CATEGORY"));
				ta.setBoardType(type);
				ta.setNickName(rset.getString("NICKNAME"));
				ta.setReplyContent(rset.getString("REPLY_CONTENT"));
				ta.setReReplyContent(rset.getString("RE_REPLY_CONTENT"));
				
				list.add(ta);
				
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
