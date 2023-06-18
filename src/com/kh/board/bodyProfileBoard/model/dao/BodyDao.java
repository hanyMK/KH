package com.kh.board.bodyProfileBoard.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.board.reply.model.vo.Reply;
import com.kh.board.bodyProfileBoard.model.vo.BoardAttachment;
import com.kh.board.bodyProfileBoard.model.vo.BodyBoard;
import com.kh.board.bodyProfileBoard.model.vo.SelectAll;

public class  BodyDao {
	
	private Properties prop = new Properties();
	
	
	public  BodyDao() {
		
		String fileName =  BodyDao.class.getResource("/sql/board/body/body-mapper.xml").getPath();
		
		try {
			
			prop.loadFromXML(new FileInputStream(fileName));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	

//	public ArrayList<BodyBoard> selectBodyList(Connection conn) {
//		
//		ArrayList<BodyBoard> list = new ArrayList();
//		
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		
//		return list;
//		
//		
//		
//		
//	}



	public int insertBody(Connection conn, BodyBoard bb) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertBody");
		

		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bb.getMemberNo());
			pstmt.setString(2, bb.getCategory());
			pstmt.setString(3, bb.getBoardTitle());
			pstmt.setString(4, bb.getBoardContent());
			pstmt.setString(5, bb.getVoteYN());
			
			result = pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
					
		
		return result;
	}



	public int insertBodyAttachment(Connection conn, ArrayList<BoardAttachment> list) {
		
		int result = 1;
		PreparedStatement pstmt  = null;
		String sql = prop.getProperty("insertBodyAttachment");
		
		
		try {
			System.out.println("?");
			for(BoardAttachment at : list) {
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, at.getFileLevel());
				pstmt.setString(2, at.getOriginName());
				pstmt.setString(3, at.getChangeName());
				pstmt.setString(4, at.getFilePath());
				
				result *= pstmt.executeUpdate();
				
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}



	public ArrayList<BodyBoard> selectBodyList(Connection conn) {
		
		ArrayList<BodyBoard> list = new ArrayList();
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectBodyList");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql) ){
			
			System.out.println("list_Dao");
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					
					BodyBoard bb = new BodyBoard();
					
					bb.setBoardNo(rset.getInt("BOARD_NO"));
					bb.setMemberNo(String.valueOf(rset.getInt("MEMBER_NO")));
					bb.setBoardTitle(rset.getString("BOARD_TITLE"));
					bb.setNickName(rset.getString("NICKNAME"));
					bb.setCreateDate(rset.getString("CREATE_DATE"));
					bb.setBoardCount(rset.getInt("BOARD_COUNT"));
					bb.setTitleImg(rset.getString("TITLEIMG"));
					bb.setReplyCount(rset.getInt("REPLY_COUNT"));
					
					list.add(bb);
					
				}
			
				System.out.println("list_Dao2");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			close(rset);
		}
		
		return list;
	}



	public int increaseCount(Connection conn, int boardNo) {
		
		int result = 0;
		
		String sql = prop.getProperty("increaseCount");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return result;
	}



	public ArrayList<BodyBoard> selectDetail(Connection conn, int boardNo) {
		
		ArrayList<BodyBoard> listAll = new ArrayList();
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectDetail");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			
			while(rset.next()) {
				
				BodyBoard bb = new BodyBoard();
				
				bb.setBoardNo(rset.getInt("BOARD_NO"));
				bb.setMemberNo(String.valueOf(rset.getInt("MEMBER_NO")));
				bb.setBoardTitle(rset.getString("BOARD_TITLE"));
				bb.setBoardContent(rset.getString("BOARD_CONTENT"));
				bb.setNickName(rset.getString("NICKNAME"));
				bb.setCreateDate(rset.getString("CREATE_DATE"));
				bb.setBoardCount(rset.getInt("BOARD_COUNT"));
				bb.setTitleImg(rset.getString("TITLEIMG"));
				bb.setVoteYN(rset.getString("VOTE_YN"));
				
				
				listAll.add(bb);
				
			}
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
		}
		
		
		
		return listAll;
	}



	public ArrayList<BoardAttachment> detailAttachment(Connection conn, int boardNo) {
		
		ArrayList<BoardAttachment> list = new ArrayList();
		ResultSet rset = null;
		
		String sql = prop.getProperty("detailAttachment");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				BoardAttachment ba = new BoardAttachment();
				
				ba.setFileNo(rset.getInt("FILE_NO"));
				ba.setBoardNo(rset.getInt("BOARD_NO"));
				ba.setFileLevel(rset.getInt("FILE_LEVEL"));
				ba.setOriginName(rset.getString("ORIGIN_NAME"));
				ba.setChangeName(rset.getString("CHANGE_NAME"));
				ba.setFilePath(rset.getString("FILE_PATH"));
				
				list.add(ba);
				
				
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
		}
		return list;
	}







	public int updateBoardLike(Connection conn, int boardNo, int memberNo) {
		
		
		int result = 0;
		String sql = prop.getProperty("updateBoardLike");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate(); // executeUpdate를 호출하는 시점이 트랜잭션이 생기는 시점
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return result;
	}



	public int selectBoardLike(Connection conn, int boardNo, int memberNo) {
		
		int result = 0; 
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectBoardLike");
		
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("BOARD_LIKE_COUNT");
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
		}
		
		
		
		return result;
	}



	public int deleteBoard(Connection conn, int boardNo) {
		
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteBoard");
		
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






}

















