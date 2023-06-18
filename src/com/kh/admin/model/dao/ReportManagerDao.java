package com.kh.admin.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.admin.model.vo.MessageReport;
import com.kh.admin.model.vo.Report;
import com.kh.board.anonymous.model.vo.SelectAll;
import com.kh.board.reply.model.vo.Reply;
import com.kh.common.model.vo.PageInfo;
import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.MemberMessage;

public class ReportManagerDao {
	private Properties prop = new Properties();
		
	public ReportManagerDao() {
		String fileName = ReportManagerDao.class.getResource("/sql/report/report-mapper.xml").getPath();
		//System.out.println(fileName);
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	
	}
		
		public int insertReport(Connection conn, Report r) {
			int result=0;
			String sql = prop.getProperty("insertReport");
			try(PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setInt(1, r.getBoardNo());
				pstmt.setInt(2, r.getMemberNo());
				pstmt.setString(3, r.getReportReason());
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return result;
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
	
	
//	public int selectListCount(Connection conn, String reportMenu ) {
//		int result =0;
//		Statement stmt = null;
//		ResultSet rset = null;
//		StringBuilder sb = new StringBuilder("SELECT COUNT(*) " ); 
//		sb.append("FROM ").append(reportMenu);
//		String sql = sb.toString();
//		System.out.println(sql);
//		
//		try {
//			stmt = conn.createStatement();
//			rset = stmt.executeQuery(sql);
//			
//			if( rset.next()) {
//				result = rset.getInt("COUNT(*)");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			close(rset);
//			close(stmt);
//		}
//		return result;
//		
//		
//	}
	
	
	public ArrayList<Report> selectBoardReportList(Connection conn, PageInfo pi ){
		ArrayList<Report> list = new ArrayList();
		ResultSet rset = null;
		String sql = prop.getProperty("selectBoardReportList");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			int startRow =(pi.getCurrentPage() -1) *pi.getPageLimit() +1;
			int endRow = startRow +pi.getPageLimit() -1;
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Report b = new  Report();
				
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setMemberNo(rset.getInt("MEMBER_NO"));
				b.setMemberId(rset.getString("NICKNAME"));
				b.setReportDate(rset.getString("BOARD_REPORT_DATE"));
				b.setReportReason(rset.getString("REPORT_REASON"));
				b.setBoardStatus(rset.getString("BOARD_STATUS_R"));
				b.setReportCount(rset.getInt("CNT"));
				
				list.add(b);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
		}
		System.out.println(list);
				
		return list;
		
	}
	
	public int selectReplyListCount(Connection conn ) {
		int result =0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReplyListCount");
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
	
	
	public ArrayList<Report> selectReplyReportList(Connection conn, PageInfo pi ){
		ArrayList<Report> list = new ArrayList();
		ResultSet rset = null;
		String sql = prop.getProperty("selectReplyReportList");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			int startRow =(pi.getCurrentPage() -1) *pi.getPageLimit() +1;
			int endRow = startRow +pi.getPageLimit() -1;
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Report b = new  Report();
				
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setReplyNo(rset.getInt("REPLY_NO"));
				b.setMemberNo(rset.getInt("MEMBER_NO"));
				b.setMemberId(rset.getString("NICKNAME"));
				b.setReportDate(rset.getString("REPLY_REPORT_DATE"));
				b.setReportReason(rset.getString("REPORT_REASON"));
				b.setBoardStatus(rset.getString("REPLY_STATUS_R"));
				b.setReportCount(rset.getInt("CNT"));
				
				list.add(b);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
		}
		System.out.println(list);
				
		return list;
		
	}
	
	
	public Report selectBoardReport(Connection conn, int boardNo ){
		Report b = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectBoardReport");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			
			pstmt.setInt(1,boardNo );
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				 b = new  Report();
				
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setMemberNo(rset.getInt("MEMBER_NO"));
				b.setMemberId(rset.getString("NICKNAME"));
				b.setBoardType(rset.getString("BOARD_TYPE"));
				b.setReportDate(rset.getString("BOARD_REPORT_DATE"));
				b.setBoardStatus(rset.getString("BOARD_STATUS_R"));
				b.setReportCount(rset.getInt("CNT"));
				
				
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
		}
		System.out.println(b);
				
		return b;
		
	}
	
	
	public int deleteBoardReport(Connection conn, int boardNo) {
		int result = 0;
		
		String sql = prop.getProperty("deleteBoardReport");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	public int updateBoardStatus(Connection conn, int boardNo) {
		int result = 0;
		
		String sql = prop.getProperty("updateBoardStatus");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	
	public int updateBoardReport(Connection conn, int boardNo) {
		int result = 0;
		
		String sql = prop.getProperty("updateBoardReport");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	public int updateMemberReport(Connection conn, int memberNo) {
		int result = 0;
		
		String sql = prop.getProperty("updateMemberReport");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setInt(1, memberNo);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	
	
	public int insertReplyReport(Connection conn, Report r) {
		int result=0;
		String sql = prop.getProperty("insertReplyReport");
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, r.getBoardNo());
			pstmt.setInt(2, r.getReplyNo());
			pstmt.setInt(3, r.getMemberNo());
			pstmt.setString(4, r.getReportReason());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	
	
	public  ArrayList<SelectAll> selectBoard(Connection conn,  int boardNo){
		ArrayList<SelectAll> all  = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectBoard");
		
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
				System.out.println(a);
				
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		System.out.println(all);
		
		return all;
	}
	
	
	public Report selectReplyReport(Connection conn, int replyNo ){
		Report b = new  Report();
		ResultSet rset = null;
		String sql = prop.getProperty("selectReplyReport");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, replyNo);
				
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setReplyNo(rset.getInt("REPLY_NO"));
				b.setMemberNo(rset.getInt("MEMBER_NO"));
				b.setMemberId(rset.getString("NICKNAME"));
				b.setReportDate(rset.getString("REPLY_REPORT_DATE"));
				b.setReportReason(rset.getString("REPORT_REASON"));
				b.setBoardStatus(rset.getString("REPLY_STATUS_R"));
				b.setReportCount(rset.getInt("CNT"));
				
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
		}
		System.out.println(b);
				
		return b;
		
	}
	
	
	
	public Reply selectReply(Connection conn, int replyNo) {
		
		Reply r = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReply");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setInt(1,replyNo);
			
			rset = pstmt.executeQuery();
			
			
			if(rset.next()) {
				
				r = new Reply();
				r.setReplyNo(rset.getInt("REPLY_NO"));
				r.setBoardNo(rset.getInt("BOARD_NO"));
				r.setMemberNo(rset.getInt("MEMBER_NO"));
				r.setReplyContent(rset.getString("REPLY_CONTENT"));
				r.setReplyDate(rset.getString("REPLY_DATE"));
				r.setReplyYN(rset.getString("REPLY_YN"));
				r.setReplyReportNo(rset.getInt("REPLY_REPORT_NO"));
				
				r.setNickName(rset.getString("NICKNAME"));
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			
		}
		
		
		return r;
	}
	
	
	
	//덧글 신고처리 완료
	
	public int deleteReplyReport(Connection conn, int replyNo) {
		int result = 0;
		
		String sql = prop.getProperty("deleteReplyReport");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setInt(1, replyNo);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	public int updateReplyStatus(Connection conn, int replyNo) {
		int result = 0;
		
		String sql = prop.getProperty("updateReplyStatus");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setInt(1, replyNo);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	
	public int updateReplyReport(Connection conn, int replyNo) {
		int result = 0;
		
		String sql = prop.getProperty("updateReplyReport");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setInt(1, replyNo);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	
// 유진 
	
	public int selectMsgListCount(Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMsgListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}
	
	public ArrayList<MessageReport> selectMsgList(Connection conn, PageInfo pi){
		ArrayList<MessageReport> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMsgList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();

			while(rset.next()) {
				MessageReport mr = new MessageReport();
				
				mr.setMessageNo(rset.getInt("MESSAGE_NO"));
				mr.setMemberNo(rset.getString("NICKNAME"));
				mr.setMessageReport(rset.getDate("MESSAGE_REPORT_DATE"));
				mr.setMessageStatusR(rset.getString("MESSAGE_STATUS_R"));
				mr.setMessageReason(rset.getString("REPORT_REASON"));
				
				
				list.add(mr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public int updateMessageReport(Connection conn, int msgNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateMessageReport");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, msgNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}		
		return result;
	}
	
	public int insertMessageReport(Connection conn, MessageReport mr) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertMessageReport");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
		  	pstmt.setInt(1, mr.getMessageNo());
			pstmt.setString(2, mr.getMemberNo());
			pstmt.setString(3, mr.getMessageReason());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public ArrayList<MemberMessage> selectMessage(Connection conn, int msgNo){
		ArrayList<MemberMessage> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMessage");
		

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, msgNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {

				  MemberMessage mmsg = new MemberMessage();
				  
				  mmsg.setMessageNo(rset.getInt("MESSAGE_NO"));
				  mmsg.setFromNic(rset.getString("FROM_NIC"));
				  mmsg.setMessageTitle(rset.getString("MESSAGE_TITLE"));
				  mmsg.setMessageContent(rset.getString("MESSAGE_CONTENT"));
				  mmsg.setMessageAlertStatus(rset.getString("MESSAGE_ALERT_STATUS"));
				  mmsg.setMessageReport(rset.getString("MESSAGE_REPORT"));
				  mmsg.setMessageDate(rset.getDate("MESSAGE_DATE"));
				  mmsg.setMessageYn(rset.getString("MESSAGE_YN"));

				  list.add(mmsg);
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public MessageReport selectMessageReport(Connection conn, int msgNo) {
		MessageReport mr = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMessageReport");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, msgNo);
			
			rset = pstmt.executeQuery();
				
			if(rset.next()) {
				mr = new MessageReport(
										rset.getInt("MESSAGE_NO")
									   ,rset.getString("NICKNAME")
									   ,rset.getDate("MESSAGE_REPORT_DATE")
									   ,rset.getString("MESSAGE_STATUS_R")
									   ,rset.getString("REPORT_REASON"));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return mr;
	}
	
	public int deleteMessageReport(Connection conn, int msgNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteMessageReport");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, msgNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int updateMessageReport_2(Connection conn, int msgNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateMessageReport_2");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, msgNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int updateMemeberReport_2(Connection conn, String nic) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateMemeberReport_2");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, nic);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
}
