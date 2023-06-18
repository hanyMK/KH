package com.kh.admin.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.admin.model.dao.AdminDao;
import com.kh.common.model.vo.PageInfo;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Alarm;
import com.kh.member.model.vo.AttendanceCheck;
import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.MemberAttach;
import com.kh.member.model.vo.MyPoint;

public class AdminService {
	
	
	
	
	public ArrayList<Member> memberList_1 (PageInfo pim){
		
		Connection conn = getConnection();
		ArrayList<Member> memberList = new AdminDao().memberList_1(conn, pim);
		
		close(conn);
		return memberList;
	}
	
	public int memberListCount_1 () {
		
		Connection conn = getConnection();
		int countList = new AdminDao().memberListCount_1(conn);
		
		close(conn);
		return countList;

	}
	
	public int adminMemTypeUpdate_1(Member m) {
		
		Connection conn = getConnection();
		int result = new AdminDao().adminMemTypeUpdate_1(conn, m);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result;
		
	}
	
	public int businessMemberListCount_1(){
		
		Connection conn = getConnection();
		int countList = new AdminDao().businessMemberListCount_1(conn);
		
		close(conn);
		return countList;
	}
	
	public ArrayList<MemberAttach> bmemberList_1(PageInfo pibm){
		
		Connection conn = getConnection();
		ArrayList<MemberAttach> atList = new AdminDao().bmemberList_1(conn, pibm);
		
		close(conn);
		return atList;
	}
	
	public ArrayList<Member> adminMemSearchId_1(String keyword){
		
		Connection conn = getConnection();
		ArrayList<Member> idmemberList = new AdminDao().adminMemSearchId_1(conn, keyword);
		
		close(conn);
		return idmemberList;
		
	}
	
	
	public ArrayList<Member> adminMemSearchnick_1(String keyword){
		
		Connection conn = getConnection();
		ArrayList<Member> nickmemberList = new AdminDao().adminMemSearchnick_1(conn, keyword);
		
		close(conn);
		return nickmemberList;
		
	}
	
	public ArrayList<Member> reportmemberList_1 (){
		
		Connection conn = getConnection();
		ArrayList<Member> reportmemberList = new AdminDao().reportmemberList_1(conn);
		
		close(conn);
		return reportmemberList;
	}
	

}
	