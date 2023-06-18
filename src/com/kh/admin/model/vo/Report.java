package com.kh.admin.model.vo;

public class Report {
	
	private int boardNo;//BOARD_NO	NUMBER
	private int memberNo;//BOARD_REPORT_DATE	DATE
	private int replyNo;//
	private int messageNo;
	private String memberId;// MEMBER_NO	NUMBER
	private String reportReason;//
	private String boardStatus;//BOARD_STATUS_R	CHAR(3 BYTE)
	private String reportDate;// REPORT_DETAIL	VARCHAR2(1000 BYTE)
	private int reportCount;//
	
	private String boardType;
	
	
	
	public Report() {
		super();
	}



	public Report(int boardNo, int memberNo, int replyNo, int messageNo, String memberId, String reportReason,
			String boardStatus, String reportDate, int reportCount, String boardType) {
		super();
		this.boardNo = boardNo;
		this.memberNo = memberNo;
		this.replyNo = replyNo;
		this.messageNo = messageNo;
		this.memberId = memberId;
		this.reportReason = reportReason;
		this.boardStatus = boardStatus;
		this.reportDate = reportDate;
		this.reportCount = reportCount;
		this.boardType = boardType;
	}



	public int getBoardNo() {
		return boardNo;
	}



	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}



	public int getMemberNo() {
		return memberNo;
	}



	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}



	public int getReplyNo() {
		return replyNo;
	}



	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}



	public int getMessageNo() {
		return messageNo;
	}



	public void setMessageNo(int messageNo) {
		this.messageNo = messageNo;
	}



	public String getMemberId() {
		return memberId;
	}



	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}



	public String getReportReason() {
		return reportReason;
	}



	public void setReportReason(String reportReason) {
		this.reportReason = reportReason;
	}



	public String getBoardStatus() {
		return boardStatus;
	}



	public void setBoardStatus(String boardStatus) {
		this.boardStatus = boardStatus;
	}



	public String getReportDate() {
		return reportDate;
	}



	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}



	public int getReportCount() {
		return reportCount;
	}



	public void setReportCount(int reportCount) {
		this.reportCount = reportCount;
	}



	public String getBoardType() {
		return boardType;
	}



	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}



	@Override
	public String toString() {
		return "Report [boardNo=" + boardNo + ", memberNo=" + memberNo + ", replyNo=" + replyNo + ", messageNo="
				+ messageNo + ", memberId=" + memberId + ", reportReason=" + reportReason + ", boardStatus="
				+ boardStatus + ", reportDate=" + reportDate + ", reportCount=" + reportCount + ", boardType="
				+ boardType + "]";
	}



	
	

}
