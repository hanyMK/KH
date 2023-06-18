package com.kh.member.model.vo;

import java.sql.Date;

public class Member {
	
	private int memberNo;//MEMBER_NO	NUMBER
	private String memberId; //MEMBER_ID	VARCHAR2(20 BYTE)
	private String nickname; //NICKNAME	VARCHAR2(70 BYTE)
	private String memberPwd;//MEMBER_PWD	VARCHAR2(40 BYTE)
	private String email;//EMAIL	VARCHAR2(80 BYTE)
	private String memberType;//MEMBER_TYPE	CHAR(2 BYTE)
	private Date enrollDate;//ENROLL_DATE	DATE
	private String memberStatus;//MEMBER_STATUS	CHAR(2 BYTE)
	private int visitCount;// VISIT_COUNT	NUMBER
	private int reportNo;// REPORT_NO	NUMBER
	private int pointSum;
	private int boardCount;
	private int replyCount;
	private int reReplyCount;
	
	public Member() {
		super();
	}
	
	
	
	
	public Member(int memberNo, String memberId, String nickname, String memberPwd, String email, String memberType,
			Date enrollDate, String memberStatus, int visitCount, int reportNo) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.nickname = nickname;
		this.memberPwd = memberPwd;
		this.email = email;
		this.memberType = memberType;
		this.enrollDate = enrollDate;
		this.memberStatus = memberStatus;
		this.visitCount = visitCount;
		this.reportNo = reportNo;
	}




	public Member(int memberNo, String memberId, String nickname, String memberPwd, String email, String memberType,
			Date enrollDate, String memberStatus, int visitCount, int reportNo, int pointSum, int boardCount,
			int replyCount, int reReplyCount) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.nickname = nickname;
		this.memberPwd = memberPwd;
		this.email = email;
		this.memberType = memberType;
		this.enrollDate = enrollDate;
		this.memberStatus = memberStatus;
		this.visitCount = visitCount;
		this.reportNo = reportNo;
		this.pointSum = pointSum;
		this.boardCount = boardCount;
		this.replyCount = replyCount;
		this.reReplyCount = reReplyCount;
	}


	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}

	public int getVisitCount() {
		return visitCount;
	}

	public void setVisitCount(int visitCount) {
		this.visitCount = visitCount;
	}

	public int getReportNo() {
		return reportNo;
	}

	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}
	
	
	

	public int getPointSum() {
		return pointSum;
	}


	public void setPointSum(int pointSum) {
		this.pointSum = pointSum;
	}


	public int getBoardCount() {
		return boardCount;
	}


	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}


	public int getReplyCount() {
		return replyCount;
	}


	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}


	public int getReReplyCount() {
		return reReplyCount;
	}


	public void setReReplyCount(int reReplyCount) {
		this.reReplyCount = reReplyCount;
	}


	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberId=" + memberId + ", nickname=" + nickname + ", memberPwd="
				+ memberPwd + ", email=" + email + ", memberType=" + memberType + ", enrollDate=" + enrollDate
				+ ", memberStatus=" + memberStatus + ", visitCount=" + visitCount + ", reportNo=" + reportNo
				+ ", pointSum=" + pointSum + ", boardCount=" + boardCount + ", replyCount=" + replyCount
				+ ", reReplyCount=" + reReplyCount + "]";
	}
	

}
