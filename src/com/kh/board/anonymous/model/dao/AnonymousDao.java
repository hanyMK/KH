package com.kh.board.anonymous.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.board.anonymous.model.vo.Anonymous;
import com.kh.board.anonymous.model.vo.SelectAll;
import com.kh.common.model.vo.BoardAttachment;
import com.kh.common.model.vo.BoardLikePost;
import com.kh.board.hashtag.model.vo.Hashtag;
import com.kh.common.model.vo.PageInfo;
import com.kh.board.reply.model.vo.Reply;

public class AnonymousDao {

	private Properties prop = new Properties();
	
	public AnonymousDao() {
		String fileName = AnonymousDao.class.getResource("/sql/board/anonymous/anonymous-mapper.xml").getPath();
		//System.out.println(fileName);
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	public int selectListCount(Connection conn ) {
		int result =0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListCount");
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			
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
	
	
	public ArrayList<SelectAll> selectAllList(Connection conn,  PageInfo pi){
		ArrayList<SelectAll> list  = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAllList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() -1)* pi.getPageLimit() + 1;
			int endRow = startRow +pi.getBoardLimit() -1;
			
			System.out.println(startRow +",  "+endRow);
	
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
		
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				
				SelectAll a = new SelectAll();
				
				a.setBoardNo(rset.getInt("BOARD_NO"));
				a.setMemberNo(rset.getInt("MEMBER_NO"));
				a.setBoardType(rset.getString("BOARD_TYPE"));
				a.setCategory(rset.getString("CATEGORY"));
				a.setBoardTitle(rset.getString("BOARD_TITLE"));
				a.setBoardContent(rset.getString("BOARD_CONTENT"));
				a.setCreateDate(rset.getString("CREATE_DATE"));
				a.setBoardCount(rset.getInt("BOARD_COUNT"));
				a.setVoteTitle(rset.getString("VOTE_TITLE"));
				a.setFileNo(rset.getInt("FILE_NO"));
				
				a.setFilePath(rset.getString("FILE_PATH"));
				a.setFileLevel(rset.getInt("FILE_LEVEL"));
				a.setFileStatus(rset.getString("FILE_STATUS"));
				a.setOriginName(rset.getString("ORIGIN_NAME"));
				a.setPostLike(rset.getInt("POST_LIKE"));
				a.setPostDisLike(rset.getInt("POST_DISLIKE"));
				a.setReplyCount(rset.getInt("REPLY_COUNT"));
				
				
				
				list.add(a);
				
		
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		//System.out.println(list);
		
		return list;
	}
	
	public  ArrayList<SelectAll> selectAllBoard(Connection conn,  int boardNo){
		 ArrayList<SelectAll> all  =new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAllBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				 SelectAll a = new SelectAll();
				
				a.setBoardNo(rset.getInt("BOARD_NO"));
				a.setMemberNo(rset.getInt("MEMBER_NO"));
				a.setBoardType(rset.getString("BOARD_TYPE"));
				a.setCategory(rset.getString("CATEGORY"));
				a.setBoardTitle(rset.getString("BOARD_TITLE"));
				a.setBoardContent(rset.getString("BOARD_CONTENT"));
				a.setCreateDate(rset.getString("CREATE_DATE"));
				a.setBoardCount(rset.getInt("BOARD_COUNT"));
				a.setVoteTitle(rset.getString("VOTE_TITLE"));
				a.setFileNo(rset.getInt("FILE_NO"));
				
				a.setFilePath(rset.getString("FILE_PATH"));
				a.setFileLevel(rset.getInt("FILE_LEVEL"));
				a.setFileStatus(rset.getString("FILE_STATUS"));
				a.setOriginName(rset.getString("ORIGIN_NAME"));
				a.setPostLike(rset.getInt("POST_LIKE"));
				a.setPostDisLike(rset.getInt("POST_DISLIKE"));
				a.setReplyCount(rset.getInt("REPLY_COUNT"));
				all.add(a);
				System.out.println(all);
				
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		//System.out.println(all);
		
		return all;
	}
	
	
	
	
//	public ArrayList<Vote> selectVoteList(Connection conn){
//		
//		ArrayList<Vote> vList = new ArrayList();
//		
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		
//		String sql = prop.getProperty("selectVoteList");
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			
//			rset = pstmt.executeQuery();
//			while(rset.next()) {
//				Vote v = new Vote();
//				v.
//				
//				
//			}
//			
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			close(rset);
//			close(pstmt);
//			
//		}
//		
//		return vList;
//	
//	}
	
	public ArrayList<BoardLikePost>  selectBoardLike(Connection conn) {
		
		ArrayList<BoardLikePost> bLike = new ArrayList();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectBoardLike");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				BoardLikePost bk = new BoardLikePost();
				bk.setBoardNo(rset.getInt("BOARD_NO"));
				bk.setDisLike(rset.getInt("POST_DISLIKE"));
				bk.setLike(rset.getInt("POST_LIKE"));
				bLike.add(bk);

			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return bLike;
	}
	
//	public ArrayList<Reply> replyCount(Connection conn) {
//		ArrayList<Reply> rList = new ArrayList<Reply>();
//		ResultSet rset = null;
//		String sql = prop.getProperty("replyCount");
//		
//		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
//			rset = pstmt.executeQuery();
//			if(rset.next()) {
//				Reply r = new Reply();
//				r.setBoardNo(rset.getInt("BOARD_NO"));
//				r.setReplyCount(rset.getInt("REPLY_COUNT"));
//				rList.add(r);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			
//		close(rset);
//		}
//		
//		
//		return rList;
//	}
	

	
	
	public int inserAnonymous(Connection conn, Anonymous a) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("inserAnonymous");
		

		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, a.getMemberNo());
			pstmt.setString(2, a.getCategory());
			pstmt.setString(3, a.getBoardTitle());
			pstmt.setString(4, a.getBoardContent());
			
			result = pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
					
		
		return result;
	}



	public int insertAnAttachment(Connection conn, ArrayList<BoardAttachment> list) {
		
		int result = 1;
		PreparedStatement pstmt  = null;
		String sql = prop.getProperty("insertAnAttachment");
		
		
		try {
			
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
	

	
	
	
	
	
	public int increasBoard(Connection conn, int boardNo) {
		
		int result = 0;
		PreparedStatement pstmt  = null;
		String sql = prop.getProperty("increasBoard");
		
		
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
	
	
	
	public ArrayList<BoardAttachment> selectAttach(Connection conn, int boardNo){
		ArrayList<BoardAttachment> attach = new ArrayList();
		ResultSet rset = null;
		String sql = prop.getProperty("selectAttach");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1,boardNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				BoardAttachment b = new BoardAttachment();
				
				b.setFileNo(rset.getInt("FILE_NO"));
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setFileLevel(rset.getInt("FILE_LEVEL"));
				b.setOriginName(rset.getNString("ORIGIN_NAME"));

				b.setFilePath(rset.getString("FILE_PATH"));
				attach.add(b);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
		}
		
		return attach;
	}
	
	public int deleteBoard(Connection conn, int boardNo) {
		int result = 0;
		String sql = prop.getProperty("deleteBoard");
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		
		return result;
	}
	
	
	public int deleteAtt(Connection conn, int boardNo) {
		int result = 0;
		String sql = prop.getProperty("deleteAtt");
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		
		return result;
	}
	
//	public ArrayList<Reply>  selectReply(Connection conn, PageInfo pi,int boardNo) {
//		
//		ArrayList<Reply> rList = new ArrayList();
//		
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		String sql = prop.getProperty("selectReply");
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			int startRow = (pi.getCurrentPage() -1)* pi.getPageLimit() + 1;
//			int endRow = startRow +pi.getBoardLimit() -1;
//			
//			
//			rset = pstmt.executeQuery();
//			while(rset.next()) {
//				Reply r = new Reply();
//				r.setBoardNo(rset.getInt("BOARD_NO"));
//				r.setNickName(rset.getString("NICKNAME"));
//				r.setReplyContent(rset.getString("REPLY_CONTENT"));
//				r.setReplyDate(rset.getString("REPLY_DATE"));
//				
//				r.set(rset.getInt("RE_LIKE"));
//				r.setDisLikeCount(rset.getInt("RE_DISLIKE"));
//				rList.add(r);
//
//			}
//			
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			close(rset);
//			close(pstmt);
//		}
//		
//		
//		return rList;
//	}
	
	
	public ArrayList<BoardAttachment> selectAttachAll(Connection conn){
		ResultSet rset = null;
		 ArrayList<BoardAttachment> pList= new ArrayList();
		 String sql = prop.getProperty("selectAttachAll");
		 
		 try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			 rset= pstmt.executeQuery();
			 while(rset.next()) {
				 BoardAttachment b = new BoardAttachment();
				b.setFileNo(rset.getInt("FILE_NO"));
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setFileLevel(rset.getInt("FILE_LEVEL"));
				b.setOriginName(rset.getNString("ORIGIN_NAME"));

				b.setFilePath(rset.getString("FILE_PATH"));
				pList.add(b);
			 
				 
			 }
			 
			 
		 } catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
		}
		 
		return pList;
		
		
		
	}
	
	
	
	
	
	
	
}	
	
	
	

