package com.kh.board.reply.model.vo;

public class ReReply {
	
	private int reReplyNo;
	private int replyNo;
	private int memberNo;
	private String reReplyContent;
	private String reReplyDate;
	private String reReplyUpdateDate;
	private String reReplyYN;
	private int reReplyReportNo;
	private String reReplyAlertStatus;
	
	private String nickName;

	public ReReply() {
		super();
	}

	public ReReply(int reReplyNo, int replyNo, int memberNo, String reReplyContent, String reReplyDate,
			String reReplyUpdateDate, String reReplyYN, int reReplyReportNo, String reReplyAlertStatus,
			String nickName) {
		super();
		this.reReplyNo = reReplyNo;
		this.replyNo = replyNo;
		this.memberNo = memberNo;
		this.reReplyContent = reReplyContent;
		this.reReplyDate = reReplyDate;
		this.reReplyUpdateDate = reReplyUpdateDate;
		this.reReplyYN = reReplyYN;
		this.reReplyReportNo = reReplyReportNo;
		this.reReplyAlertStatus = reReplyAlertStatus;
		this.nickName = nickName;
	}

	public int getReReplyNo() {
		return reReplyNo;
	}

	public void setReReplyNo(int reReplyNo) {
		this.reReplyNo = reReplyNo;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getReReplyContent() {
		return reReplyContent;
	}

	public void setReReplyContent(String reReplyContent) {
		this.reReplyContent = reReplyContent;
	}

	public String getReReplyDate() {
		return reReplyDate;
	}

	public void setReReplyDate(String reReplyDate) {
		this.reReplyDate = reReplyDate;
	}

	public String getReReplyUpdateDate() {
		return reReplyUpdateDate;
	}

	public void setReReplyUpdateDate(String reReplyUpdateDate) {
		this.reReplyUpdateDate = reReplyUpdateDate;
	}

	public String getReReplyYN() {
		return reReplyYN;
	}

	public void setReReplyYN(String reReplyYN) {
		this.reReplyYN = reReplyYN;
	}

	public int getReReplyReportNo() {
		return reReplyReportNo;
	}

	public void setReReplyReportNo(int reReplyReportNo) {
		this.reReplyReportNo = reReplyReportNo;
	}

	public String getReReplyAlertStatus() {
		return reReplyAlertStatus;
	}

	public void setReReplyAlertStatus(String reReplyAlertStatus) {
		this.reReplyAlertStatus = reReplyAlertStatus;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "ReReply [reReplyNo=" + reReplyNo + ", replyNo=" + replyNo + ", memberNo=" + memberNo
				+ ", reReplyContent=" + reReplyContent + ", reReplyDate=" + reReplyDate + ", reReplyUpdateDate="
				+ reReplyUpdateDate + ", reReplyYN=" + reReplyYN + ", reReplyReportNo=" + reReplyReportNo
				+ ", reReplyAlertStatus=" + reReplyAlertStatus + ", nickName=" + nickName + "]";
	}
	
	
	
	
	
	
	
	
	
	
	

}
