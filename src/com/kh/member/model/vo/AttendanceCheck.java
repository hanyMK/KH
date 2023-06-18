package com.kh.member.model.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AttendanceCheck implements Serializable {
	
	private int memberNo;//MEMBER_NO	NUMBER
	private String attendanceDate;//ATTENDANCE_DATE	DATE
	private String attendanceCheck;//ATTENDANCE_CHECK	CHAR(3 BYTE)
	private String nowDate;//
	public AttendanceCheck() {
		super();
	}
	
	public AttendanceCheck(int memberNo, String attendanceDate, String attendanceCheck) {
		super();
		this.memberNo = memberNo;
		this.attendanceDate = attendanceDate;
		this.attendanceCheck = attendanceCheck;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getAttendanceDate() {
		return attendanceDate;
	}
	public void setAttendanceDate(String attendanceDate) {
		this.attendanceDate = attendanceDate;
	}
	public String getAttendanceCheck() {
		return attendanceCheck;
	}
	public void setAttendanceCheck(String attendanceCheck) {
		this.attendanceCheck = attendanceCheck;
	}
	@Override
	public String toString() {
		return "AttendanceCheck [memberNo=" + memberNo + ", attendanceDate=" + attendanceDate + ", attendanceCheck="
				+ attendanceCheck + "]";
	}
	
		}

