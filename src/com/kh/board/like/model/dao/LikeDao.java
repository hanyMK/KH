package com.kh.board.like.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.board.like.model.vo.Like;
import com.kh.common.JDBCTemplate;

public class LikeDao {
	
	
	private Properties prop = new Properties();
	
	public LikeDao() {
		
		String fileName = LikeDao.class.getResource("/sql/board/like/like-mapper.xml").getPath();
		
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	



	public int insertLike(Connection conn, int boardNo, int memberNo) {
		
		
		int result = 0;
		String sql = prop.getProperty("insertLike");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			
			pstmt.setInt(1, boardNo);
			pstmt.setInt(2, memberNo);
			
			result = pstmt.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return result;
	}




	public ArrayList<Like>  selectLike(Connection conn, int boardNo) {
		
		ArrayList<Like> list = new ArrayList();
		String sql = prop.getProperty("selectLike");
		ResultSet rset = null;
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			//System.out.println(rset);
			
			
				while(rset.next()) {
				
				
				Like l = new Like();
				
				l.setBoardNo(rset.getInt("BOARD_NO"));
				l.setBoardLikeCount(rset.getInt("BOARD_LIKE_COUNT"));
				l.setBoardDislikeCount(rset.getInt("BOARD_DISLIKE_COUNT"));
				
				
				list.add(l);
				
				
					
				}
				if(list.isEmpty()) {
					
					
					
					Like l = new Like();
					
					l.setBoardNo(0);
					l.setMemberNo(0);
					l.setBoardLikeCount(0);
					l.setBoardDislikeCount(0);
					
					list.add(l);
					
					
					
				}
			 
				
				
			
			//System.out.println("sdffffff" + list);
			
			
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(rset);
			}
			
		
		return list;

}




	public ArrayList<Like> selectMemberNo(Connection conn, int boardNo) {
		
		
		ArrayList<Like> list = new ArrayList();
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMemberNo");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
		
		
			
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Like m = new Like();
				
				m.setMemberNo(rset.getInt("MEMBER_NO"));
				
				list.add(m);
				
				
			}
			
			//System.out.println(list);
					
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);

		}
		
		
		
		
		
		return list;
	}




	public int deleteLike(Connection conn, int boardNo, int memberNo) {
		
		
		int result = 0;
		
		String sql = prop.getProperty("deleteLike");
		
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setInt(1, boardNo);
			pstmt.setInt(2, memberNo);
			
			result = pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return result;
	}




	public ArrayList<Like> selectLikeCount(Connection conn) {
		
		
		
		ArrayList<Like> likeCount = new ArrayList();
		ResultSet rset = null;
		
		try(PreparedStatement pstmt = conn.prepareStatement("selectLikeCount")){
			
			
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return null;
	}







}



