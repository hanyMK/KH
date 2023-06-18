package com.kh.admin.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.admin.model.dao.ReportManagerDao;
import com.kh.admin.model.vo.MessageReport;
import com.kh.admin.model.vo.Report;
import com.kh.board.anonymous.model.vo.SelectAll;
import com.kh.board.reply.model.vo.Reply;
import com.kh.common.model.vo.PageInfo;
import com.kh.member.model.vo.MemberMessage;


public class ReportManagerService {
	

		
	public int insertReport(Report r) {
		
		Connection conn = getConnection();
		
		int result = new ReportManagerDao().insertReport(conn, r);
		if(result>0) {
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int selectListCount() {
		Connection conn = getConnection ();
		
		int result = new ReportManagerDao().selectListCount(conn);
		
		close(conn);
		return result;
		
	}
	
	
	
	public ArrayList<Report> selectBoardReportList( PageInfo pi){
		Connection conn = getConnection();
		
		ArrayList<Report> list  = new ReportManagerDao().selectBoardReportList(conn, pi);
		//System.out.println(list);
		
		close(conn);
		
		return list;
		
	}
	
	public Report selectBoardReport( int boardNo){
		Connection conn = getConnection();
		
		Report b  = new ReportManagerDao().selectBoardReport(conn, boardNo);
		//System.out.println(list);
		
		close(conn);
		
		return b;
		
	}
	
	
	//신고 테이블으 게시글 삭제
	public int deleteBoardReport(int boardNo) {
		Connection conn = getConnection();
		int result = new ReportManagerDao().deleteBoardReport(conn, boardNo);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	
	public int updateBoardReport(int boardNo, int memberNo) {
		Connection conn = getConnection();
		//메인게시판 처리 업데이트
		int result1 = new ReportManagerDao().updateBoardStatus(conn, boardNo);
		int result2 = 1;
		int result3 = 1;
		//신고게시판 처리 업데이트
		result2 = new ReportManagerDao().updateBoardReport(conn, boardNo);
		//멤버테이블 업데이트
		result3 = new ReportManagerDao().updateMemberReport(conn, memberNo);
		if(result1 *result2*result3>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return (result1* result2*result3);
	}
	
	
	public int insertReplyReport(Report r) {
		
		Connection conn = getConnection();
		
		int result = new ReportManagerDao().insertReplyReport(conn, r);
		
		if(result >0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
		
		
	}

	public ArrayList<SelectAll> selectBoard(int boardNo) {
		
		Connection conn = getConnection();
		
		ArrayList<SelectAll> a  = new ReportManagerDao().selectBoard(conn, boardNo);
		//System.out.println(list);
		
		close(conn);
		
		return a;
		
		
		
		
	}
	public int selectReplyListCount() {
		Connection conn = getConnection ();
		
		int result = new ReportManagerDao().selectReplyListCount(conn);
		
		close(conn);
		return result;
		
	}
	
	
	public ArrayList<Report> selectReplyReportList( PageInfo pi){
		Connection conn = getConnection();
		
		ArrayList<Report> list  = new ReportManagerDao().selectReplyReportList(conn, pi);
		//System.out.println(list);
		
		close(conn);
		
		return list;
		
	}
	
	
	public Report selectReplyReport(int replyNo){
		Connection conn = getConnection();
		
		Report list  = new ReportManagerDao().selectReplyReport(conn, replyNo);
		//System.out.println(list);
		
		close(conn);
		
		return list;
	}
	
	public Reply selectReply(int replyNo) {
		
		Connection conn = getConnection();
		
		Reply r = new ReportManagerDao().selectReply(conn, replyNo);
		
		
		close(conn);
		return r;
	}
	
	
	public int deleteReplyReport(int replyNo) {
		Connection conn = getConnection();
		int result = new ReportManagerDao().deleteReplyReport(conn, replyNo);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	
	public int updateReplyReport(int replyNo, int memberNo) {
		Connection conn = getConnection();
		//덧글처리 업데이트
		int result1 = new ReportManagerDao().updateReplyStatus(conn, replyNo);
		int result2 = 1;
		int result3 = 1;
		//덧글 신고게시판 처리 업데이트
		result2 = new ReportManagerDao().updateReplyReport(conn, replyNo);
		//멤버테이블 업데이트
		result3 = new ReportManagerDao().updateMemberReport(conn, memberNo);
		if(result1 *result2*result3>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return (result1* result2*result3);
	}
// 유진 /////////////////////////////////////////////////////////////////
	public int selectMsgListCount() {
		Connection conn = getConnection();
		
		int result = new ReportManagerDao().selectMsgListCount(conn);
		
		close(conn);
		return result;
	}
	
	public ArrayList<MessageReport> selectMsgList(PageInfo pi){
		Connection conn = getConnection();
		
		ArrayList<MessageReport> list = new ReportManagerDao().selectMsgList(conn, pi);
		
		close(conn);
		return list;
	}
	
	public int updateMessageReport(int msgNo) {
		
		Connection conn = getConnection();
		int result = new ReportManagerDao().updateMessageReport(conn, msgNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
		
	}
	
	public int insertMessageReport(MessageReport mr) {
		Connection conn = getConnection();
		
		int result = new ReportManagerDao().insertMessageReport(conn, mr);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public ArrayList<MemberMessage> selectMessage(int msgNo){
		Connection conn = getConnection();
		
		ArrayList<MemberMessage> list = new ReportManagerDao().selectMessage(conn, msgNo);
		
		close(conn);
		return list;
	}
	
	public MessageReport selectMessageReport(int msgNo) {
		Connection conn = getConnection();
		
		MessageReport mr = new ReportManagerDao().selectMessageReport(conn, msgNo);
		
		close(conn);
		return mr;
	}
	
	public int deleteMessageReport(int msgNo) {
		Connection conn = getConnection();
		
		int result = new ReportManagerDao().deleteMessageReport(conn, msgNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}
	public int updateMessageReport_2(int msgNo) {
		Connection conn = getConnection();
		
		int result = new ReportManagerDao().updateMessageReport_2(conn, msgNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int updateMemeberReport_2(String nic) {
		Connection conn = getConnection();
		
		int result = new ReportManagerDao().updateMemeberReport_2(conn, nic);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

}
	
