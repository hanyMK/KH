package com.kh.board.reply.model.dao;
import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.board.reply.model.vo.ReReply;
import com.kh.board.reply.model.vo.Reply;

public class  ReplyDao {
	
	private Properties prop = new Properties();
	
	
	public  ReplyDao() {
		
		String fileName =  ReplyDao.class.getResource("/sql/board/reply/reply-mapper.xml").getPath();
		
		try {
			
			prop.loadFromXML(new FileInputStream(fileName));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	

	
	
	
public ArrayList<Reply> selectReplyList(Connection conn, int boardNo) {
		
		ArrayList<Reply> list = new ArrayList();
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReplyList");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setInt(1,boardNo);
			
			rset = pstmt.executeQuery();
			
			
			while(rset.next()) {
				
				list.add(new Reply(
						rset.getInt("REPLY_NO"),
						rset.getInt("BOARD_NO"),
						rset.getInt("MEMBER_NO"),
						rset.getString("REPLY_CONTENT"),
						rset.getString("REPLY_DATE"),
						rset.getString("REPLY_UPDATE_DATE"),
						rset.getString("REPLY_YN"),
						rset.getInt("REPLY_REPORT_NO"),
						rset.getString("REPLY_ALERT_STATUS"),
						rset.getString("NICKNAME"),
						rset.getInt("REPLY_COUNT")));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			
		}
		
		
		
		
		return list;
	}


// ===================== INSERT =====================================

public int insertReply(Connection conn, Reply r) {
		
		int result = 0;
		
		String sql = prop.getProperty("insertReply");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setInt(1, r.getBoardNo());
			pstmt.setInt(2, r.getMemberNo());
			pstmt.setString(3, r.getReplyContent());
			
			result = pstmt.executeUpdate();
			
			
			System.out.println("댓글dao갓다나오니?");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}






public int rereplyInsert(Connection conn ,ReReply rere) {
	
	int result = 0;
	
	String sql = prop.getProperty("rereplyInsert");
	
	try(PreparedStatement pstmt = conn.prepareStatement(sql)){
		
		pstmt.setInt(1, rere.getReplyNo());
		pstmt.setInt(2, rere.getMemberNo());
		pstmt.setString(3, rere.getReReplyContent());
		
		result = pstmt.executeUpdate();
		
		
		System.out.println("여기가문제야?3333ㄴㅇ");
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	
	
	return result;
}






	public ArrayList<ReReply> selectReReplyList(Connection conn, int replyNo) {
		
		ArrayList<ReReply> rereplyList = new ArrayList();
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReReplyList");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setInt(1, replyNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				rereplyList.add(new ReReply(
						rset.getInt("RE_REPLY_NO"),
						rset.getInt("REPLY_NO"),
						rset.getInt("MEMBER_NO"),
						rset.getString("RE_REPLY_CONTENT"),
						rset.getString("RE_REPLY_DATE"),
						rset.getString("RE_REPLY_UPDATE_DATE"),
						rset.getString("RE_REPLY_YN"),
						rset.getInt("RE_REPLY_REPORT_NO"),
						rset.getString("RE_REPLY_ALERT_STATUS"),
						rset.getString("NICKNAME")));
			}
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}close(rset);
		
		
		
		
		return rereplyList;
	}
	
	
	public int deleteReply(Connection conn, Reply r) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteReply");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, r.getReplyNo());
			pstmt.setInt(2, r.getBoardNo());
			pstmt.setInt(3, r.getMemberNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}

}













