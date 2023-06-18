package com.kh.member.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.model.vo.PageInfo;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Alarm;
import com.kh.member.model.vo.AttendanceCheck;
import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.MemberAttach;
import com.kh.member.model.vo.MemberMessage;
import com.kh.member.model.vo.MemberQnA;
import com.kh.member.model.vo.MemberQnAAnswer;
import com.kh.member.model.vo.MyPoint;

public class MemberService {
	
	
	public Member loginMember_1(String userId, String userPwd) {
		
		Connection conn = getConnection();
		
		Member m = new MemberDao().loginMember_1(conn, userId, userPwd);
		
		close(conn);
		
		return m;
		
		
	}
	
	public int idCheck_1(String checkId){
		
		Connection conn = getConnection();
		int result = new MemberDao().idCheck_1(conn, checkId);
		
		close(conn);
		
		return result;

	}
	
	public int nicknameCheck_1(String nicknameCheck) {

		Connection conn = getConnection();
		int result = new MemberDao().nicknameCheck_1(conn, nicknameCheck);
		
		close(conn);
		
		return result;

	}
	
	public int emailCheck_1(String emailCheck) {
		Connection conn = getConnection();
		
		int result = new MemberDao().emailCheck_1(conn, emailCheck);
		
		close(conn);
		
		return result;
		
	}
	
	public int insertMember_1(Member m, MemberAttach at) {
		
		Connection conn = getConnection();
		
		int result1 = new MemberDao().insertMember_1(conn, m);
		
		int result2 = 1;
		if(at != null) {
			result2 = new MemberDao().insertMemberAttach_1(conn, at);
		}
		
		if((result1 * result2) > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return (result1 * result2);
	}
	
	public ArrayList<Alarm> newAlarmReply_1(Member m) {
		
		Connection conn = getConnection();
		ArrayList<Alarm> list1 = new MemberDao().newAlarmReply_1(conn, m);
		
		close(conn);
		
		return list1;

	}
	
	public ArrayList<Alarm> newAlarmRereply_1(Member m){
		
		Connection conn = getConnection();
		ArrayList<Alarm> list2 = new MemberDao().newAlarmRereply_1(conn, m);
		
		close(conn);
		
		return list2;
	}

	public ArrayList<Alarm> myBoardList_1(Member m){
		
		Connection conn = getConnection();
		ArrayList<Alarm> blist = new MemberDao().myBoardList_1(conn,m);
		
		close(conn);
		
		return blist;
		
	}
	
	public ArrayList<Alarm> myReplyList_1(Member m){
		
		Connection conn = getConnection();
		ArrayList<Alarm> rlist = new MemberDao().myReplyList_1(conn,m);
		
		close(conn);
		
		return rlist;
	}
	

	
	public ArrayList<Alarm> myReReplyList_1(Member m){
		
		Connection conn = getConnection();
		ArrayList<Alarm> rrlist = new MemberDao().myReReplyList_1(conn,m);
		
		close(conn);
		
		return rrlist;
	}
	
	public ArrayList<Alarm> myLikeList_1 (Member m){
		
		Connection conn = getConnection();
		ArrayList<Alarm> llist = new MemberDao().myLikeList_1(conn,m);
		
		close(conn);
		
		return llist;
		
	}
	
	public int myAlarmCheckR_1 (int boardNo) {
		
		Connection conn = getConnection();
		int result1 = new MemberDao().myAlarmCheckR_1(conn, boardNo);
		
		if(result1 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result1;
	}
	
	public int myAlarmCheckRr_1 (int replyNo) {
		
		Connection conn = getConnection();
		int result2 = new MemberDao().myAlarmCheckRr_1(conn, replyNo);
		
		if(result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result2;
	}
	
	public ArrayList<MyPoint> myPoint_1 (int memberNo) {
		
		Connection conn = getConnection();
		ArrayList<MyPoint> pointList = new MemberDao().myPoint_1(conn, memberNo);
		
		close(conn);
		return pointList;
	}
	
	
	public ArrayList<AttendanceCheck> attCheck_1 (int memberNo) {
		
		Connection conn = getConnection();
		ArrayList<AttendanceCheck> attList = new MemberDao().attCheck_1(conn, memberNo);
		
		close(conn);
		return attList;
	}
	
	public int todayAttCheck_1 (int memberNo) {
		
		Connection conn = getConnection();
		int result = new MemberDao().todayAttcheck(conn, memberNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int todayAttcheckchk_1(int memberNo) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().todayAttcheckchk_1(conn, memberNo);
		
		close(conn);
		
		return result;
		
	}
	
	public int attCheckPoint_1 (int memberNo) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().attCheckPoint_1(conn, memberNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public ArrayList<Alarm> selectMyBoardList_1(int memberNo, PageInfo pib){
		
		Connection conn = getConnection();
		
		ArrayList<Alarm> myBList = new MemberDao().selectMyBoardList_1(conn, memberNo, pib);
		
		close(conn);
		
		return myBList;
		
	}
	
	public ArrayList<Alarm> selectMyReplyList_1(int memberNo, PageInfo pir){
		
		Connection conn = getConnection();
		
		ArrayList<Alarm> myRList = new MemberDao().selectMyReplyList_1(conn, memberNo, pir);
		
		close(conn);
		
		return myRList;
		
	}
	
	public ArrayList<Alarm> selectMyReReplyList_1(int memberNo, PageInfo pirr){
		
		Connection conn = getConnection();
		
		ArrayList<Alarm> myRrList = new MemberDao().selectMyReReplyList_1(conn, memberNo, pirr);
		
		close(conn);
		
		return myRrList;
		
	}
	
	public ArrayList<Alarm> selectMyLikeList_1(int memberNo, PageInfo pil){
		
		Connection conn = getConnection();
		
		ArrayList<Alarm> myLList = new MemberDao().selectMyLikeList_1(conn, memberNo, pil);
		
		close(conn);
		
		return myLList;	
	}
	
	public ArrayList<MyPoint> selectMyPoint_1(int memberNo, PageInfo pip){
		
		Connection conn = getConnection();
		ArrayList<MyPoint> pgPointList = new MemberDao().selectMyPoint_1(conn, memberNo, pip);
		
		close(conn);
		return pgPointList;
		
	}
	
	//유진님꺼 
	public int deleteMember_2(String userId, String userPwd) {
		Connection conn = getConnection();
		
		int result = new MemberDao().deleteMember_2(conn, userId, userPwd);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public Member updatePwdMember_2(Member m, String updatePwd) {
		Connection conn = getConnection();
		
		int result = new MemberDao().updatePwdMember_2(conn, m, updatePwd);
		
		Member updatePwdMem = null;
		
		if(result > 0) {
			commit(conn);
			updatePwdMem = new MemberDao().selectMember_1(conn, m);
		} else {
			rollback(conn);
		}
		close(conn);
		return updatePwdMem;
	}
	
	public Member updateMember_2(Member m) {
		Connection conn = getConnection();
		
		int result = new MemberDao().updateMember_2(conn, m);
		// System.out.println(result);
		Member updateMem = null;
		
		if(result > 0) {
			commit(conn);
			updateMem = new MemberDao().selectMember_1(conn, m);
		} else {
			rollback(conn);
		}
		close(conn);
		return updateMem;
	}

	public int selectQnACount_A() {
		Connection conn = getConnection();
		
		int result = new MemberDao().selectQnACount_A(conn);
		
		close(conn);
		
		return result;
	}
	
	
	public int selectQnACount(int userNo) {
		Connection conn = getConnection();
		
		int result = new MemberDao().selectQnACount(conn, userNo);
		
		close(conn);
		
		return result;
	}
	
	public ArrayList<MemberQnA> selectQnAList_A(PageInfo pi, int userNo){
		Connection conn = getConnection();
		
		ArrayList<MemberQnA> list = new MemberDao().selectQnAList_A(conn, pi, userNo);
		
		close(conn);
		
		return list;
	}
	
	public ArrayList<MemberQnA> selectQnAList(PageInfo pi, int userNo){
		Connection conn = getConnection();
		
		ArrayList<MemberQnA> list = new MemberDao().selectQnAList(conn, pi, userNo);
		
		close(conn);
		
		return list;
	}
	
	
	public int InsertMemberQnA_2(MemberQnA qna) {
		Connection conn = getConnection();
		
		int result = new MemberDao().InsertMemberQnA_2(conn, qna);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);			
		return result;
	}
	
	public MemberQnA selectQnA_2(int qnaNo) {
		Connection conn = getConnection();
		
		MemberQnA q = new MemberDao().selectQnA_2(conn, qnaNo);
		
		close(conn);
		
		return q;
	}
	
	public ArrayList<MemberQnAAnswer> selectAnswerList(int qnaNo) {
		Connection conn = getConnection();
		
		ArrayList<MemberQnAAnswer> list = new MemberDao().selectAnswerList(conn, qnaNo);
		
		close(conn);
		
		return list;
	}
	
	public int insertAnswer_2(int qnaNo, String aContent) {
		Connection conn = getConnection();
		
		int result = new MemberDao().insertAnswer_2(conn, qnaNo, aContent);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int updateAnswer_2(int qnaNo) {
		Connection conn = getConnection();
		
		int result = new MemberDao().updateAnswer_2(conn, qnaNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public String selectFindId_2(String email1) {
		Connection conn = getConnection();
		
		String result = new MemberDao().selectFindId_2(conn, email1);
		
		close(conn);
		return result;
	}
	
	public int selectFindPwd_2(String id, String email) {
		Connection conn = getConnection();
		
		int result = new MemberDao().selectFindPwd_2(conn, id, email);
		
		close(conn);
		return result;
	}
	
	public Member updateFindPwd(String userId, String updatePwd1, String chkPwd) {
		Connection conn = getConnection();
		
		int result = new MemberDao().updateFindPwd(conn, userId, updatePwd1, chkPwd);

		Member updateFindPwd = null;

		if(result > 0) {
			commit(conn);
			updateFindPwd = new MemberDao().selectFindMember_2(conn, userId, updatePwd1, chkPwd);
		} else {
			rollback(conn);
		}
		close(conn);
		return updateFindPwd;
	}
	
	public ArrayList<Member> nickSearch(String key){
		Connection conn = getConnection();
		
		ArrayList<Member> list = new MemberDao().nickSearch(conn, key);
		
		close(conn);
		
		return list;
	}
	
	public int selectMsgListCount(String nickname) {
		Connection conn = getConnection();
		
		int result = new MemberDao().selectMsgListCount(conn, nickname);
		
		close(conn);
		
		return result;
	}
	
	public ArrayList<MemberMessage> selectMsgList(PageInfo pi, String nickname){
		Connection conn = getConnection();
		
		ArrayList<MemberMessage> list = new MemberDao().selectMsgList(conn, pi, nickname);
		
		close(conn);
		
		return list;
		
	}
	
	public int selectMsgSandListCount(String nickname) {
		Connection conn = getConnection();
		
		int result = new MemberDao().selectMsgSandListCount(conn, nickname);
		
		close(conn);
		
		return result;

	}
	
	public ArrayList<MemberMessage> selectMsgSandList(PageInfo pi, String nickname){
		Connection conn = getConnection();
		
		ArrayList<MemberMessage> list = new MemberDao().selectMsgSandList(conn, pi, nickname);
		
		close(conn);
		
		return list;
	}
	
	public MemberMessage selectDetailMsg(int msgNo) {
		Connection conn = getConnection();
		
		MemberMessage msg = new MemberDao().selectDetailMsg(conn, msgNo);
		
		close(conn);
		
		return msg;
	}
	
	public int updateMessage(int msgNo) {
		Connection conn = getConnection();
		
		int result = new MemberDao().updateMessage(conn, msgNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	public MemberMessage selectDetailSandMsg(int msgSNo) {
		Connection conn = getConnection();
		
		MemberMessage msg = new MemberDao().selectDetailSandMsg(conn, msgSNo);
		
		close(conn);
		return msg;
	}
	
	public int insertMessage(MemberMessage msg) {
		Connection conn = getConnection();
		
		int result = new MemberDao().insertMessage(conn, msg);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	public int deleteMessage(int msgNo) {
		Connection conn = getConnection();
		
		int result = new MemberDao().deleteMessage(conn, msgNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int reportMessage() {
		Connection conn = getConnection();
		
		int result = new MemberDao().reportMessage(conn);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
}
	