package com.kh.board.reply.model.vo;

public class Reply {
	
	private int replyNo; 				//REPLY_NO	NUMBER
	private int boardNo;			 	//BOARD_NO	NUMBER
	private int memberNo; 				// MEMBER_NO	NUMBER
	private String replyContent; 		// REPLY_CONTENT	VARCHAR2(1000 BYTE)
	private String replyDate; 			// REPLY_DATE	DATE
	private String replyUpdateDate; 	// REPLY_UPDATE_DATE	DATE
	private String replyYN; 			// REPLY_YN	CHAR(3 BYTE)
	private int replyReportNo; 			//REPLY_REPORT_NO	NUMBER
	private String replyAlertStatus; 	// REPLY_ALERT_STATUS	CHAR(5 BYTE)
	
	private String nickName;

	private int replyCount;

	public Reply() {
		super();
	}

	public Reply(int replyNo, int boardNo, int memberNo, String replyContent, String replyDate, String replyUpdateDate,
			String replyYN, int replyReportNo, String replyAlertStatus, String nickName, int replyCount) {
		super();
		this.replyNo = replyNo;
		this.boardNo = boardNo;
		this.memberNo = memberNo;
		this.replyContent = replyContent;
		this.replyDate = replyDate;
		this.replyUpdateDate = replyUpdateDate;
		this.replyYN = replyYN;
		this.replyReportNo = replyReportNo;
		this.replyAlertStatus = replyAlertStatus;
		this.nickName = nickName;
		this.replyCount = replyCount;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
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

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}

	public String getReplyUpdateDate() {
		return replyUpdateDate;
	}

	public void setReplyUpdateDate(String replyUpdateDate) {
		this.replyUpdateDate = replyUpdateDate;
	}

	public String getReplyYN() {
		return replyYN;
	}

	public void setReplyYN(String replyYN) {
		this.replyYN = replyYN;
	}

	public int getReplyReportNo() {
		return replyReportNo;
	}

	public void setReplyReportNo(int replyReportNo) {
		this.replyReportNo = replyReportNo;
	}

	public String getReplyAlertStatus() {
		return replyAlertStatus;
	}

	public void setReplyAlertStatus(String replyAlertStatus) {
		this.replyAlertStatus = replyAlertStatus;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	@Override
	public String toString() {
		return "Reply [replyNo=" + replyNo + ", boardNo=" + boardNo + ", memberNo=" + memberNo + ", replyContent="
				+ replyContent + ", replyDate=" + replyDate + ", replyUpdateDate=" + replyUpdateDate + ", replyYN="
				+ replyYN + ", replyReportNo=" + replyReportNo + ", replyAlertStatus=" + replyAlertStatus
				+ ", nickName=" + nickName + ", replyCount=" + replyCount + "]";
	}
	

	
	
}
