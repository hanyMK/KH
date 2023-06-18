package com.kh.notice.model.dao;

import static com.kh.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.notice.model.vo.Board;
import com.kh.notice.model.vo.BoardAttach;
import com.kh.common.model.vo.PageInfo;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Alarm;

public class BoardDao {
	
	
	private Properties prop = new Properties();
	
	public BoardDao() {
		
		String file = MemberDao.class.getResource("/sql/notice/notice-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Board> noticeList_1(Connection conn, PageInfo pin){
		
		ArrayList<Board> noticeList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("noticeList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pin.getCurrentPage() -1) * pin.getBoardLimit() + 1;
			int endRow = startRow + pin.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setCategory(rset.getString("CATEGORY"));
				b.setBoardTitle(rset.getString("BOARD_TITLE"));
				b.setBoardContent(rset.getString("BOARD_CONTENT"));
				b.setCreateDate(rset.getDate("CREATE_DATE"));
				b.setBoardCount(rset.getInt("BOARD_COUNT"));
				
				noticeList.add(b);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return noticeList;
	
	}
	
	public int noticeListCount_1(Connection conn) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("noticeListCount");
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT(BOARD_NO)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
		
	}
	
	public int increaseCount_1(Connection conn, int boardNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = prop.getProperty("increaseCount");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public Board selectBoard_1(Connection conn, int boardNo) {
		
		Board nb = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				nb = new Board();
				nb.setBoardNo(rset.getInt("BOARD_NO"));
				nb.setBoardTitle(rset.getString("BOARD_TITLE"));
				nb.setCategory(rset.getString("CATEGORY"));
				nb.setBoardContent(rset.getString("BOARD_CONTENT"));
				nb.setCreateDate(rset.getDate("CREATE_DATE"));
				nb.setBoardCount(rset.getInt("BOARD_COUNT"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return nb;
		
	}
	
	public ArrayList<BoardAttach> selectAttachment_1(Connection conn,int boardNo){
		

		ArrayList<BoardAttach> nAList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				BoardAttach ba = new BoardAttach();
				ba.setFileNo(rset.getInt("FILE_NO"));
				ba.setBoardNo(rset.getInt("BOARD_NO"));
				ba.setOriginName(rset.getString("ORIGIN_NAME"));
				ba.setChangeName(rset.getString("CHANGE_NAME"));
				ba.setFilePath(rset.getString("FILE_PATH"));
				ba.setBoardNo(boardNo);
				
				nAList.add(ba);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return nAList;

	}
	
	
	public int insertNoticeBoard_1 (Connection conn, Board b) {
		
		
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = prop.getProperty("insertNoticeBoard");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b.getMemberNo());
			pstmt.setString(2, b.getCategory());
			pstmt.setString(3, b.getBoardTitle());
			pstmt.setString(4, b.getBoardContent());	
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int insertNoticeAttachList_1(Connection conn, ArrayList<BoardAttach> nAList) {
		

		int result = 1;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertNoticeAttachList");
		
		try {
			
			for(BoardAttach at : nAList) {
				
				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, at.getOriginName());
				pstmt.setString(2, at.getChangeName());
				pstmt.setString(3, at.getFilePath());

				result *= pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
			
	}
	
}
