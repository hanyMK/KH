package com.kh.board.hashtag.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.board.anonymous.model.vo.SelectAll;
import com.kh.board.hashtag.model.vo.Hashtag;
import com.kh.common.model.vo.PageInfo;

	
	public class HashtagDao {
		private Properties prop = new Properties();
		
		public HashtagDao() {
			String fileName = HashtagDao.class.getResource("/sql/board/hashtag/hashtag-mapper.xml").getPath();
			//System.out.println(fileName);
			
			try {
				prop.loadFromXML(new FileInputStream(fileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		
		}
		
		public ArrayList<Hashtag> selectHashtag(Connection conn){
			
			ArrayList<Hashtag> hList = new ArrayList();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
					
			String sql = prop.getProperty("selectHashtag");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					Hashtag h = new Hashtag();
					
					h.setHashtag(rset.getString("HASHTAG"));
					h.setHashContent(rset.getString("HASH_CONTENT"));
					
					hList.add(h);
					
				}
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			return hList;
			
			
		}
		
		public int insertBoardHashtag(Connection conn,int boardNo, String[] hashtag) {
			
			
			int result = 1;
			PreparedStatement pstmt  = null;
			String sql = prop.getProperty("insertBoardHashtag");
			System.out.println("dao해시 배열"+ hashtag[0]);
			
			
			
			try {
				
				for(int i = 0; i< hashtag.length; i++) {
					
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setInt(1, boardNo);
					pstmt.setString(2, hashtag[i]);
					
					result *= pstmt.executeUpdate();
					
				}
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			
			
			return result;
		}
		
		
		public int selectLastBoardNo(Connection conn) {
			int boardNo =0;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String sql = prop.getProperty("selectLastBoardNo");
			
			try {
				pstmt = conn.prepareStatement(sql);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					boardNo = rset.getInt("BOARD_NO");
					
				}
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
			System.out.println(boardNo);
			return boardNo;
			
		}
		
		public int selectHashtagListCount(Connection conn, String hashContent ) {
			int result =0;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("selectHashtagListCount");
			try {
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, hashContent);
				
				rset = pstmt.executeQuery();
				
				if( rset.next()) {
					result = rset.getInt("COUNT(*)");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			return result;
			
			
		}
		
		
		
		
		public ArrayList<Hashtag> selectHashtagByBoardNo(Connection conn, int boardNo){
			
			ArrayList<Hashtag> hList = new ArrayList();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
					
			String sql = prop.getProperty("selectHashtagByBoardNo");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, boardNo);
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					Hashtag h = new Hashtag();
					
					h.setBoardNo(rset.getInt("BOARD_NO"));
					h.setHashtag(rset.getString("HASH_CONTENT"));
					
					hList.add(h);
					
				}
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			return hList;
			
			
		}
		
		
		public ArrayList<SelectAll> searchTag(Connection conn, String hashContent, PageInfo pi){
			ArrayList<SelectAll> tagSerchList = new ArrayList();
			
			ResultSet rset = null;
			String sql = prop.getProperty("searchTag");
			
			try(PreparedStatement pstmt =conn.prepareStatement(sql)){
				
				int startRow = (pi.getCurrentPage()-1)*pi.getPageLimit() +1;
				int endRow = startRow + pi.getPageLimit() -1;
				pstmt.setString(1, hashContent);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				
					rset = pstmt.executeQuery();
					
					while(rset.next()) {
						
						 SelectAll all = new SelectAll();
						
						all.setBoardNo(rset.getInt("BOARD_NO"));
						all.setMemberNo(rset.getInt("MEMBER_NO"));
						all.setNickName(rset.getString("NICKNAME"));
						all.setBoardType(rset.getString("BOARD_TYPE"));
						all.setCategory(rset.getString("CATEGORY"));
						all.setBoardTitle(rset.getString("BOARD_TITLE"));
						all.setBoardContent(rset.getString("BOARD_CONTENT"));
						all.setCreateDate(rset.getString("CREATE_DATE"));
						all.setBoardCount(rset.getInt("BOARD_COUNT"));
						all.setVoteTitle(rset.getString("VOTE_TITLE"));
						all.setFileNo(rset.getInt("FILE_NO"));
						all.setChangeName(rset.getString("CHANGE_NAME"));
						all.setFilePath(rset.getString("FILE_PATH"));
						all.setFileLevel(rset.getInt("FILE_LEVEL"));
						all.setFileStatus(rset.getString("FILE_STATUS"));
						all.setOriginName(rset.getString("ORIGIN_NAME"));
						all.setPostLike(rset.getInt("POST_LIKE"));
						all.setPostDisLike(rset.getInt("POST_DISLIKE"));
						all.setReplyCount(rset.getInt("REPLY_COUNT"));
						tagSerchList.add(all);
						
					}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				
			}
			
				return tagSerchList;
			
		}
		
		
		public ArrayList<Hashtag> selectHashtagList(Connection conn, String keyword){
			ArrayList<Hashtag> hashtag = new ArrayList();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String tagContent = "%"+keyword +"%";
			System.out.println("tagContent" +tagContent);
					
			String sql = prop.getProperty("selectHashtagList");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, tagContent);
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					Hashtag h = new Hashtag();
					
				
					h.setHashContent(rset.getString("HASH_CONTENT"));
					
					hashtag.add(h);
					
				}
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			System.out.println(hashtag);
			return hashtag;
			

		}
		
		
		public int insertHashtag(Connection conn, String hashtag) {
			int result = 0;
			String content = "#"+hashtag;
			String sql = prop.getProperty("insertHashtag");
			try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			
				pstmt.setString(1, hashtag);
				pstmt.setString(2, content);
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			return result;
		}
		
		
//		public ArrayList<Hashtag> selectHashList(Connection conn){
//			
//			ArrayList<Hashtag> hList = new ArrayList();
//			PreparedStatement pstmt = null;
//			ResultSet rset = null;
//					
//			String sql = prop.getProperty("selectHashList");
//			
//			try {
//				pstmt = conn.prepareStatement(sql);
//				
//				rset = pstmt.executeQuery();
//				
//				while(rset.next()) {
//					Hashtag h = new Hashtag();
//					
//					h.setBoardNo(rset.getInt("BOARD_NO"));
//					h.setHashtag(rset.getString("HASH_CONTENT"));
//					
//					hList.add(h);
//					
//				}
//				
//				
//				
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}finally {
//				close(rset);
//				close(pstmt);
//			}
//			return hList;
//			
//			
//		}
//	
		
		
	public ArrayList<Hashtag> selectHashtagForupdate(Connection conn, int boardNo){
			
			ArrayList<Hashtag> hList = new ArrayList();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
					
			String sql = prop.getProperty("selectHashtagForupdate");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, boardNo);
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					Hashtag h = new Hashtag();
					
					h.setHashtag(rset.getString("HASHTAG"));
					
					
					hList.add(h);
					
				}
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			return hList;
			
			
		}
	
	public int deleteHashtag(Connection conn, int boardNo ) {
		int result =0;
		PreparedStatement pstmt = null;
		
		
		String sql = prop.getProperty("deleteHashtag");
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			close(pstmt);
		}
		return result;
		
		
	}
	
	
	public int deleteHashtagForUpdate(Connection conn, int boardNo, String target ) {
		int result =0;
		PreparedStatement pstmt = null;
		
		
		String sql = prop.getProperty("deleteHashtagForUpdate");
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			pstmt.setString(2, target);
			
			result = pstmt.executeUpdate();
			System.out.println("dao"+result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			close(pstmt);
		}
		return result;
		
		
	}
		

}
