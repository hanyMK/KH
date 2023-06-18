package com.kh.member.model.vo;

import java.util.Date;

public class MyPoint {
	
	private int memberNo;//MEMBER_NO	NUMBER
	private int point;//POINT	NUMBER
	private Date pointDate;//POINT_DATE	DATE
	public MyPoint() {
		super();
	}
	public MyPoint(int memberNo, int point, Date pointDate, int sumPoint) {
		super();
		this.memberNo = memberNo;
		this.point = point;
		this.pointDate = pointDate;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public Date getPointDate() {
		return pointDate;
	}
	public void setPointDate(Date pointDate) {
		this.pointDate = pointDate;
	}

	
	@Override
	public String toString() {
		return "MyPoint [memberNo=" + memberNo + ", point=" + point + ", pointDate=" + pointDate + "]";
	}
}
