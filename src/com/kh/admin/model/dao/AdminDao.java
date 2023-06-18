package com.kh.admin.model.dao;

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
import com.kh.member.model.vo.MyPoint;

public class AdminDao{
	
	private Properties prop = new Properties();
	
	public AdminDao() {
		
		String file = AdminDao.class.getResource("/sql/admin/admin-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public int memberListCount_1(Connection conn) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("memberListCount");
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return listCount;
		
	}
	
	
	public ArrayList<Member> memberList_1(Connection conn, PageInfo pim){
		
		Member m = null;
		ArrayList<Member> memberList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("memberList");
		
		try {
			
			
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pim.getCurrentPage() -1) * pim.getBoardLimit() + 1;
			int endRow = startRow + pim.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				m = new Member();
				m.setMemberNo(rset.getInt("MEMBER_NO"));
				m.setMemberId(rset.getString("MEMBER_ID"));
				m.setNickname(rset.getString("NICKNAME"));
				m.setEnrollDate(rset.getDate("ENROLL_DATE"));
				m.setMemberType(rset.getString("MEMBER_TYPE"));
				m.setReportNo(rset.getInt("REPORT_NO"));
				m.setBoardCount(rset.getInt("BOARD_COUNT"));
				m.setReplyCount(rset.getInt("REPLY_COUNT"));
				m.setReReplyCount(rset.getInt("RE_REPLY_COUNT"));
				m.setPointSum(rset.getInt("POINT_SUM"));
				
				memberList.add(m);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return memberList;
	}
	
	public int adminMemTypeUpdate_1(Connection conn, Member m) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("adminMemTypeUpdate");
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getMemberType());
			pstmt.setInt(2, m.getMemberNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
		
		}
	
	
	
	public int businessMemberListCount_1(Connection conn){
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("businessMemberListCount");
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return listCount;
		}
	
	public ArrayList<MemberAttach> bmemberList_1(Connection conn, PageInfo pibm){
		
		
		ArrayList<MemberAttach> atList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("businessMemberList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pibm.getCurrentPage() -1) * pibm.getBoardLimit() + 1;
			int endRow = startRow + pibm.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				MemberAttach at = new MemberAttach();
				at.setFileNo(rset.getInt("FILE_NO"));
				at.setMemberNo(rset.getInt("MEMBER_NO"));
				at.setOriginName(rset.getString("ORIGIN_NAME"));
				at.setChangeName(rset.getString("CHANGE_NAME"));
				at.setFilePath(rset.getString("FILE_PATH"));
				
				atList.add(at);
				
				//System.out.println(at);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return atList;
		
		}
	
	public ArrayList<Member> adminMemSearchId_1(Connection conn, String keyword){
		
		Member m = null;
		ArrayList<Member> idmemberList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("idmemberList");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				m = new Member();
				m.setMemberNo(rset.getInt("MEMBER_NO"));
				m.setMemberId(rset.getString("MEMBER_ID"));
				m.setNickname(rset.getString("NICKNAME"));
				m.setEnrollDate(rset.getDate("ENROLL_DATE"));
				m.setMemberType(rset.getString("MEMBER_TYPE"));
				m.setReportNo(rset.getInt("REPORT_NO"));
				m.setBoardCount(rset.getInt("BOARD_COUNT"));
				m.setReplyCount(rset.getInt("REPLY_COUNT"));
				m.setReReplyCount(rset.getInt("RE_REPLY_COUNT"));
				m.setPointSum(rset.getInt("POINT_SUM"));
				
				idmemberList.add(m);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return idmemberList;
	}
	
	
	
	public ArrayList<Member> adminMemSearchnick_1(Connection conn, String keyword){
		
		Member m = null;
		ArrayList<Member> nickmemberList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("nickmemberList");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				m = new Member();
				m.setMemberNo(rset.getInt("MEMBER_NO"));
				m.setMemberId(rset.getString("MEMBER_ID"));
				m.setNickname(rset.getString("NICKNAME"));
				m.setEnrollDate(rset.getDate("ENROLL_DATE"));
				m.setMemberType(rset.getString("MEMBER_TYPE"));
				m.setReportNo(rset.getInt("REPORT_NO"));
				m.setBoardCount(rset.getInt("BOARD_COUNT"));
				m.setReplyCount(rset.getInt("REPLY_COUNT"));
				m.setReReplyCount(rset.getInt("RE_REPLY_COUNT"));
				m.setPointSum(rset.getInt("POINT_SUM"));
				
				nickmemberList.add(m);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return nickmemberList;
	}
	
	
	
	
	public ArrayList<Member> reportmemberList_1(Connection conn){
		
		Member m = null;
		ArrayList<Member> reportmemberList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("reportmemberList");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				m = new Member();
				m.setMemberNo(rset.getInt("MEMBER_NO"));
				m.setMemberId(rset.getString("MEMBER_ID"));
				m.setNickname(rset.getString("NICKNAME"));
				m.setEnrollDate(rset.getDate("ENROLL_DATE"));
				m.setMemberType(rset.getString("MEMBER_TYPE"));
				m.setReportNo(rset.getInt("REPORT_NO"));
				m.setBoardCount(rset.getInt("BOARD_COUNT"));
				m.setReplyCount(rset.getInt("REPLY_COUNT"));
				m.setReReplyCount(rset.getInt("RE_REPLY_COUNT"));
				m.setPointSum(rset.getInt("POINT_SUM"));
				
				reportmemberList.add(m);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return reportmemberList;
	
	}
	
}
