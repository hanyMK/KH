package com.kh.member.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import com.kh.common.model.vo.PageInfo;
import com.kh.member.model.vo.Alarm;
import com.kh.member.model.vo.AttendanceCheck;
import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.MemberAttach;
import com.kh.member.model.vo.MemberMessage;
import com.kh.member.model.vo.MemberQnA;
import com.kh.member.model.vo.MemberQnAAnswer;
import com.kh.member.model.vo.MyPoint;

public class MemberDao {
	
	private Properties prop = new Properties();
	
	public MemberDao() {
		
		String file = MemberDao.class.getResource("/sql/member/member-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Member loginMember_1(Connection conn, String userId, String userPwd) {
		
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("loginMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				m = new Member(rset.getInt("MEMBER_NO"),
						       rset.getString("MEMBER_ID"),
						       rset.getString("NICKNAME"),
						       rset.getString("MEMBER_PWD"),
						       rset.getString("EMAIL"),
						       rset.getString("MEMBER_TYPE"),
						       rset.getDate("ENROLL_DATE"),
						       rset.getString("MEMBER_STATUS"),
						       rset.getInt("VISIT_COUNT"),
						       rset.getInt("REPORT_NO")
						       );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			 
			close(rset);
			close(pstmt);
		}
		return m;
		
		
	}
	
	public int idCheck_1(Connection conn, String checkId) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("idCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, checkId);
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
	
	public int nicknameCheck_1(Connection conn, String nicknameCheck) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("nicknameCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, nicknameCheck);
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
	
	public int emailCheck_1(Connection conn, String emailCheck) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("emailCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, emailCheck);
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
	
	public int insertMember_1 (Connection conn, Member m) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("inserMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getNickname());
			pstmt.setString(3, m.getMemberPwd());
			pstmt.setString(4, m.getEmail());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int insertMemberAttach_1 (Connection conn, MemberAttach at) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertMemberAttach");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, at.getOriginName());
			pstmt.setString(2, at.getChangeName());
			pstmt.setString(3, at.getFilePath());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public ArrayList<Alarm> newAlarmReply_1 (Connection conn, Member m) {
		
		ArrayList<Alarm> list1 = new ArrayList<Alarm>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("newAlarmReply");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, m.getMemberNo());
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Alarm a = new Alarm();
				a.setBoardNo(rset.getInt("BOARD_NO"));
				a.setBoardTitle(rset.getString("BOARD_TITLE"));
				a.setCountNewReply(rset.getInt("COUNT(REPLY)"));
				a.setBoardType(rset.getString("BOARD_TYPE"));
				
				list1.add(a);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list1;
	}
	
	public ArrayList<Alarm> newAlarmRereply_1 (Connection conn, Member m){
		
		ArrayList<Alarm> list2 = new ArrayList<Alarm>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("newAlarmRereply");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, m.getMemberNo());
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Alarm a = new Alarm();
				a.setBoardNo(rset.getInt("BOARD_NO"));
				a.setReplyNo(rset.getInt("REPLY_NO"));
				a.setReplyContent(rset.getString("REPLY_CONTENT"));
				a.setCountNewRereply(rset.getInt("COUNT(RE_REPLY)"));
				a.setBoardType(rset.getString("BOARD_TYPE"));
				
				list2.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list2;
	}
	
	public ArrayList<Alarm> myBoardList_1 (Connection conn, Member m){
		
		ArrayList<Alarm> blist = new ArrayList<Alarm>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("myBoardList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, m.getMemberNo());
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Alarm a = new Alarm(); 
				a.setBoardNo(rset.getInt("BOARD_NO"));
				a.setBoardTitle(rset.getString("BOARD_TITLE"));
				a.setCreateDateb(rset.getString("CREATE_DATE"));
				a.setBoardType(rset.getString("BOARD_TYPE"));
				
				blist.add(a);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return blist;
	}
	
	public ArrayList<Alarm> myReplyList_1(Connection conn, Member m){
		
		ArrayList<Alarm> rlist = new ArrayList<Alarm>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("myReplyList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, m.getMemberNo());
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Alarm a = new Alarm(); 
				a.setBoardNo(rset.getInt("BOARD_NO"));
				a.setReplyNo(rset.getInt("REPLY_NO"));
				a.setReplyContent(rset.getString("REPLY_CONTENT"));
				a.setCreateDater(rset.getString("REPLY_DATE"));
				a.setBoardType(rset.getString("BOARD_TYPE"));
				
				rlist.add(a);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return rlist;
		
	}
	
	
	
	public ArrayList<Alarm> myReReplyList_1(Connection conn, Member m){
		
		ArrayList<Alarm> rrlist = new ArrayList<Alarm>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("myReReplyList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, m.getMemberNo());
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Alarm a = new Alarm(); 
				a.setBoardNo(rset.getInt("BOARD_NO"));
				a.setReReplyNo(rset.getInt("RE_REPLY_NO"));
				a.setReReplyContent(rset.getString("RE_REPLY_CONTENT"));
				a.setCreateDaterr(rset.getString("RE_REPLY_DATE"));
				a.setBoardType(rset.getString("BOARD_TYPE"));
				
				rrlist.add(a);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return rrlist;
		
	}
	
	public ArrayList<Alarm> myLikeList_1 (Connection conn, Member m){
		
		ArrayList<Alarm> llist = new ArrayList<Alarm>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("myLikeList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, m.getMemberNo());
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Alarm a = new Alarm(); 
				a.setBoardNo(rset.getInt("BOARD_NO"));
				a.setBoardTitle(rset.getString("BOARD_TITLE"));
				a.setCreateDateb(rset.getString("CREATE_DATE"));
				a.setBoardType(rset.getString("BOARD_TYPE"));
				
				llist.add(a);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return llist;
	}
	
	public int myAlarmCheckR_1(Connection conn, int boardNo) {
		
		int result1 = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("myAlarmCheckR");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			result1 = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result1;	
	}

	
	public int myAlarmCheckRr_1(Connection conn, int replyNo) {
		
		int result2 = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("myAlarmCheckRr");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, replyNo);
			result2 = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result2;
	}
	
	public ArrayList<MyPoint> myPoint_1(Connection conn, int memberNo){
		
		ArrayList<MyPoint> pointList = new ArrayList<MyPoint>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("myPoint");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				MyPoint point = new MyPoint();
				point.setPoint(rset.getInt("POINT"));
				point.setPointDate(rset.getDate("POINT_DATE"));
				
				pointList.add(point);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		} return pointList;
	}
	
	public ArrayList<AttendanceCheck> attCheck_1(Connection conn, int memberNo){
		
		ArrayList<AttendanceCheck> attList = new ArrayList<AttendanceCheck>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("attCheck");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				AttendanceCheck atCheck = new AttendanceCheck();
				atCheck.setAttendanceDate("ATTENDANCE_DATE");
				
				attList.add(atCheck);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return attList;
	}
	
	public int todayAttcheck(Connection conn, int memberNo) {
		
		int result=0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("todayAttcheck");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,memberNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int todayAttcheckchk_1(Connection conn, int memberNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("todayAttcheckchk");
		
		Date date = new Date();
		SimpleDateFormat format1 = new SimpleDateFormat("YY/MM/dd");	
		String today = format1.format(date);
		//System.out.println(today);
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, today);
			pstmt.setInt(2, memberNo);
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
	
	public int attCheckPoint_1(Connection conn, int memberNo) {
		
		int result=0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("attCheckPoint");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,memberNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public ArrayList<Alarm> selectMyBoardList_1(Connection conn, int memberNo, PageInfo pib){
		
		ArrayList<Alarm> myBList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMyBoardList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pib.getCurrentPage() -1) * pib.getBoardLimit() + 1;
			int endRow = startRow + pib.getBoardLimit() - 1;
			
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Alarm a = new Alarm();
				a.setBoardNo(rset.getInt("BOARD_NO"));
				a.setBoardType(rset.getString("BOARD_TYPE"));
				a.setBoardTitle(rset.getString("BOARD_TITLE"));
				a.setCreateDateb(rset.getString("CREATE_DATE"));
				
				myBList.add(a);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return myBList;

	}
	

	
	public ArrayList<Alarm> selectMyReplyList_1(Connection conn, int memberNo, PageInfo pir){
		
		ArrayList<Alarm> myRList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMyReplyList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pir.getCurrentPage() -1) * pir.getBoardLimit() + 1;
			int endRow = startRow + pir.getBoardLimit() - 1;
			
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Alarm a = new Alarm();
				
				a.setBoardNo(rset.getInt("BOARD_NO"));
				a.setBoardType(rset.getString("BOARD_TYPE"));
				a.setReplyNo(rset.getInt("REPLY_NO"));
				a.setReplyContent(rset.getString("REPLY_CONTENT"));
				a.setCreateDater(rset.getString("REPLY_DATE"));
				
				myRList.add(a);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return myRList;

	}
	
	public ArrayList<Alarm> selectMyReReplyList_1(Connection conn, int memberNo, PageInfo pirr){
		
		ArrayList<Alarm> myRrList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMyReReplyList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pirr.getCurrentPage() -1) * pirr.getBoardLimit() + 1;
			int endRow = startRow + pirr.getBoardLimit() - 1;
			
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Alarm a = new Alarm();
				
				a.setBoardNo(rset.getInt("BOARD_NO"));
				a.setBoardType(rset.getString("BOARD_TYPE"));
				a.setReReplyNo(rset.getInt("RE_REPLY_NO"));
				a.setReReplyContent(rset.getString("RE_REPLY_CONTENT"));
				a.setCreateDaterr(rset.getString("RE_REPLY_DATE"));
				
				myRrList.add(a);
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return myRrList;
		}
	
	public ArrayList<Alarm> selectMyLikeList_1(Connection conn, int memberNo, PageInfo pil){
		
		ArrayList<Alarm> myLList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMyLikeList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pil.getCurrentPage() -1) * pil.getBoardLimit() + 1;
			int endRow = startRow + pil.getBoardLimit() - 1;
			
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Alarm a = new Alarm();
				a.setBoardNo(rset.getInt("BOARD_NO"));
				a.setBoardType(rset.getString("BOARD_TYPE"));
				a.setBoardTitle(rset.getString("BOARD_TITLE"));
				a.setCreateDateb(rset.getString("CREATE_DATE"));
				
				myLList.add(a);
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return myLList;
		}



	public ArrayList<MyPoint> selectMyPoint_1(Connection conn, int memberNo, PageInfo pip){
	
	ArrayList<MyPoint> pgPointList = new ArrayList();
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	String sql = prop.getProperty("selectMyPoint");
	
	try {
		pstmt = conn.prepareStatement(sql);
		
		int startRow = (pip.getCurrentPage() -1) * pip.getBoardLimit() + 1;
		int endRow = startRow + pip.getBoardLimit() - 1;
		
		pstmt.setInt(1, memberNo);
		pstmt.setInt(2, startRow);
		pstmt.setInt(3, endRow);
		
		rset = pstmt.executeQuery();
		
		while(rset.next()) {
			
			MyPoint p = new MyPoint();
			p.setPoint(rset.getInt("POINT"));
			p.setPointDate(rset.getDate("POINT_DATE"));
			
			pgPointList.add(p);
		}

	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	return pgPointList;
	}
	
	//유진님꺼 
	public int deleteMember_2(Connection conn, String userId, String userPwd) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userPwd);
			pstmt.setString(2, userId);
			
			result = pstmt.executeUpdate();
			// System.out.println(result);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		} 
		return result;
	}
	
	public int updatePwdMember_2(Connection conn, Member m, String updatePwd) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updatePwdMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, updatePwd);
			pstmt.setInt(2, m.getMemberNo());
			pstmt.setString(3, m.getMemberPwd());
			
			result = pstmt.executeUpdate();
			// System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public Member selectMember_1(Connection conn, Member m) {
		Member updatePwdMem = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMember_1");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getMemberId());
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				updatePwdMem = new Member(
											rset.getInt("MEMBER_NO")
										   ,rset.getString("MEMBER_ID")
										   ,rset.getString("NICKNAME")
										   ,rset.getString("MEMBER_PWD")
										   ,rset.getString("EMAIL")
										   ,rset.getString("MEMBER_TYPE")
										   ,rset.getDate("ENROLL_DATE")
										   ,rset.getString("MEMBER_STATUS")
										   ,rset.getInt("VISIT_COUNT")
										   ,rset.getInt("REPORT_NO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return updatePwdMem;
	}
	
	public int updateMember_2(Connection conn, Member m) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateMember_2");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getNickname());
			pstmt.setString(2, m.getMemberId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int selectQnACount_A(Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectQnACount_A2");
		
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
	
	public int selectQnACount(Connection conn, int userNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectQnACount_2");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
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
	
	public ArrayList<MemberQnA> selectQnAList_A(Connection conn, PageInfo pi, int userNo){
		ArrayList<MemberQnA> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectQnAList_A");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();

			while(rset.next()) {
				MemberQnA q = new MemberQnA();
				q.setQuaNo(rset.getInt("QNA_NO"));
				q.setMemberNo(rset.getString("MEMBER_ID"));
				q.setQnaTitle(rset.getString("QNA_TITLE"));
				q.setQnaContent(rset.getString("QNA_CONTENT"));
				q.setQnaDate(rset.getDate("QNA_DATE"));
				q.setQnaCheck(rset.getString("QNA_CHECK"));
				
				list.add(q);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
	}
	
	public ArrayList<MemberQnA> selectQnAList(Connection conn, PageInfo pi, int userNo){
		ArrayList<MemberQnA> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectQnAList_2");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();

			while(rset.next()) {
				MemberQnA q = new MemberQnA();
				q.setQuaNo(rset.getInt("QNA_NO"));
				q.setMemberNo(rset.getString("MEMBER_ID"));
				q.setQnaTitle(rset.getString("QNA_TITLE"));
				q.setQnaContent(rset.getString("QNA_CONTENT"));
				q.setQnaDate(rset.getDate("QNA_DATE"));
				q.setQnaCheck(rset.getString("QNA_CHECK"));
				
				list.add(q);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;

	}
	
	public int InsertMemberQnA_2(Connection conn, MemberQnA qna) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("InsertMemberQnA_2");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, qna.getMemberNo());
			pstmt.setString(2, qna.getQnaTitle());
			pstmt.setString(3, qna.getQnaContent());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public MemberQnA selectQnA_2(Connection conn, int qnaNo) {
		
		MemberQnA q = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectQnA_2");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, qnaNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				q = new MemberQnA();
				q.setQuaNo(rset.getInt("QNA_NO"));
				q.setMemberNo(rset.getString("MEMBER_ID"));
				q.setQnaTitle(rset.getString("QNA_TITLE"));
				q.setQnaContent(rset.getString("QNA_CONTENT"));
				q.setQnaDate(rset.getDate("QNA_DATE"));
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return q;
	}
	
	
	public ArrayList<MemberQnAAnswer> selectAnswerList(Connection conn, int qnaNo) {
		ArrayList<MemberQnAAnswer> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAnswerList_2");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, qnaNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {

				list.add(new MemberQnAAnswer(rset.getInt("QNA_ANO"),
											 rset.getString("QNA_ANSWER_CONTENT"),
											 rset.getString("QNA_ANSWER_DATE")));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public int insertAnswer_2(Connection conn, int qnaNo, String aContent) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertAnswer_2");
				
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, qnaNo);
			pstmt.setString(2, aContent);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result; 
	}
	
	public int updateAnswer_2(Connection conn, int qnaNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateAnswer_2");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, qnaNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}		
		return result;
	}
	
	public String selectFindId_2(Connection conn, String email1) {
		
		String result = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectFindId_2");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email1);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getString("MEMBER_ID");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}
	
	public int selectFindPwd_2(Connection conn, String id, String email) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectFindPwd_2");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, email);
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
	
	public int updateFindPwd(Connection conn, String userId, String updatePwd1, String chkPwd) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateFindPwd");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, updatePwd1);
			pstmt.setString(2, userId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public Member selectFindMember_2(Connection conn, String userId, String updatePwd, String chkPwd) {
		Member updateFindPwd = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMember_1");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				updateFindPwd = new Member(
											rset.getInt("MEMBER_NO")
										   ,rset.getString("MEMBER_ID")
										   ,rset.getString("NICKNAME")
										   ,rset.getString("MEMBER_PWD")
										   ,rset.getString("EMAIL")
										   ,rset.getString("MEMBER_TYPE")
										   ,rset.getDate("ENROLL_DATE")
										   ,rset.getString("MEMBER_STATUS")
										   ,rset.getInt("VISIT_COUNT")
										   ,rset.getInt("REPORT_NO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return updateFindPwd;
	}
	
	public ArrayList<Member> nickSearch(Connection conn, String key){
		
		ArrayList<Member> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("nickSearch_2");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, key);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {

				Member m = new Member();
				m.setNickname(rset.getString("NICKNAME"));
				
				list.add(m);	
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
	}
	
	public int selectMsgListCount(Connection conn, String nickname) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMsgListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickname);
			
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
	
	public ArrayList<MemberMessage> selectMsgList(Connection conn, PageInfo pi, String nickname){
		ArrayList<MemberMessage> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMsgList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setString(1, nickname);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {

				MemberMessage msg = new MemberMessage();
					msg.setMessageNo(rset.getInt("MESSAGE_NO"));
					msg.setFromNic(rset.getString("FROM_NIC"));
					msg.setToNic(rset.getString("TO_NIC"));
					msg.setMessageTitle(rset.getString("MESSAGE_TITLE"));
					msg.setMessageContent(rset.getString("MESSAGE_CONTENT"));
					msg.setMessageAlertStatus(rset.getString("MESSAGE_ALERT_STATUS"));
					msg.setMessageReport(rset.getString("MESSAGE_REPORT"));
					msg.setMessageDate(rset.getDate("MESSAGE_DATE"));
					msg.setMessageYn(rset.getString("MESSAGE_YN"));
				
				list.add(msg);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
	}
	
	public int selectMsgSandListCount(Connection conn, String nickname) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMsgSandListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, nickname);
			
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
	
	public ArrayList<MemberMessage> selectMsgSandList(Connection conn, PageInfo pi, String nickname){
		ArrayList<MemberMessage> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMsgSandList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setString(1, nickname);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {

				MemberMessage msg = new MemberMessage();
					msg.setMessageNo(rset.getInt("MESSAGE_NO"));
					msg.setFromNic(rset.getString("FROM_NIC"));
					msg.setToNic(rset.getString("TO_NIC"));
					msg.setMessageTitle(rset.getString("MESSAGE_TITLE"));
					msg.setMessageContent(rset.getString("MESSAGE_CONTENT"));
					msg.setMessageAlertStatus(rset.getString("MESSAGE_ALERT_STATUS"));
					msg.setMessageReport(rset.getString("MESSAGE_REPORT"));
					msg.setMessageDate(rset.getDate("MESSAGE_DATE"));
					msg.setMessageYn(rset.getString("MESSAGE_YN"));
				
				list.add(msg);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public int updateMessage(Connection conn, int msgNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateMessage");
		
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
	
	public MemberMessage selectDetailMsg(Connection conn, int msgNo) {
		MemberMessage msg = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectDetailMsg");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, msgNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				msg = new MemberMessage();
				msg.setMessageNo(rset.getInt("MESSAGE_NO"));
				msg.setFromNic(rset.getString("FROM_NIC"));
				msg.setToNic(rset.getString("TO_NIC"));
				msg.setMessageTitle(rset.getString("MESSAGE_TITLE"));
				msg.setMessageContent(rset.getString("MESSAGE_CONTENT"));
				msg.setMessageAlertStatus(rset.getString("MESSAGE_ALERT_STATUS"));
				msg.setMessageReport(rset.getString("MESSAGE_REPORT"));
				msg.setMessageDate(rset.getDate("MESSAGE_DATE"));
				msg.setMessageYn(rset.getString("MESSAGE_YN"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return msg;
	}
	
	public MemberMessage selectDetailSandMsg(Connection conn,int msgSNo) {
		MemberMessage msg = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectDetailSandMsg");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, msgSNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				msg = new MemberMessage();
				msg.setMessageNo(rset.getInt("MESSAGE_NO"));
				msg.setFromNic(rset.getString("FROM_NIC"));
				msg.setToNic(rset.getString("TO_NIC"));
				msg.setMessageTitle(rset.getString("MESSAGE_TITLE"));
				msg.setMessageContent(rset.getString("MESSAGE_CONTENT"));
				msg.setMessageAlertStatus(rset.getString("MESSAGE_ALERT_STATUS"));
				msg.setMessageReport(rset.getString("MESSAGE_REPORT"));
				msg.setMessageDate(rset.getDate("MESSAGE_DATE"));
				msg.setMessageYn(rset.getString("MESSAGE_YN"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return msg;
	}
	
	public int insertMessage(Connection conn, MemberMessage msg) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertMessage");
		
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, msg.getFromNic());
			pstmt.setString(2, msg.getToNic());
			pstmt.setString(3, msg.getMessageTitle());
			pstmt.setString(4, msg.getMessageContent());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
	}
	
	public int deleteMessage(Connection conn, int msgNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteMessage");
		
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
	
	public int reportMessage(Connection conn) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("reportMessage");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
	}

}
