package com.kh.member.model.vo;

import java.sql.Date;

public class MemberQnA {
	
	private int quaNo; // QNA_NO	NUMBER
	private String memberNo; // MEMBER_NO	NUMBER
	private String qnaTitle; // QNA_TITLE	VARCHAR2(500 BYTE)
	private String qnaContent; // QNA_CONTENT	VARCHAR2(3000 BYTE)
	private Date qnaDate; // QNA_DATE	DATE
	private String qnaCheck; // QNA_CHECK	CHAR(3 BYTE)
	private String qnaAnswer; // QNA_ANSWER	VARCHAR2(1000 BYTE)
	
	public MemberQnA() {
		super();
	}

	public MemberQnA(int quaNo, String memberNo, String qnaTitle, String qnaContent, Date qnaDate, String qnaCheck,
			String qnaAnswer) {
		super();
		this.quaNo = quaNo;
		this.memberNo = memberNo;
		this.qnaTitle = qnaTitle;
		this.qnaContent = qnaContent;
		this.qnaDate = qnaDate;
		this.qnaCheck = qnaCheck;
		this.qnaAnswer = qnaAnswer;
	}

	public int getQuaNo() {
		return quaNo;
	}

	public void setQuaNo(int quaNo) {
		this.quaNo = quaNo;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getQnaTitle() {
		return qnaTitle;
	}

	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}

	public String getQnaContent() {
		return qnaContent;
	}

	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}

	public Date getQnaDate() {
		return qnaDate;
	}

	public void setQnaDate(Date qnaDate) {
		this.qnaDate = qnaDate;
	}

	public String getQnaCheck() {
		return qnaCheck;
	}

	public void setQnaCheck(String qnaCheck) {
		this.qnaCheck = qnaCheck;
	}

	public String getQnaAnswer() {
		return qnaAnswer;
	}

	public void setQnaAnswer(String qnaAnswer) {
		this.qnaAnswer = qnaAnswer;
	}

	@Override
	public String toString() {
		return "MemberQnA [quaNo=" + quaNo + ", memberNo=" + memberNo + ", qnaTitle=" + qnaTitle + ", qnaContent="
				+ qnaContent + ", qnaDate=" + qnaDate + ", qnaCheck=" + qnaCheck + ", qnaAnswer=" + qnaAnswer + "]";
	}

	

}