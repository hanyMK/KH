package com.kh.admin.model.vo;

import java.sql.Date;

public class MessageReport {
	
	private int messageNo; // MESSAGE_NO	NUMBER
	private String memberNo; //MEMBER_NO	NUMBER
	private Date messageReport; // MESSAGE_REPORT_DATE	DATE
	private String messageStatusR; // MESSAGE_STATUS_R	CHAR(3 BYTE)
	private String messageReason; // MESSAGE_REASON	VARCHAR2(1000 BYTE)
	
	public MessageReport() {
		super();
	}

	public MessageReport(int messageNo, String memberNo, Date messageReport, String messageStatusR,
			String messageReason) {
		super();
		this.messageNo = messageNo;
		this.memberNo = memberNo;
		this.messageReport = messageReport;
		this.messageStatusR = messageStatusR;
		this.messageReason = messageReason;
	}

	public int getMessageNo() {
		return messageNo;
	}

	public void setMessageNo(int messageNo) {
		this.messageNo = messageNo;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public Date getMessageReport() {
		return messageReport;
	}

	public void setMessageReport(Date messageReport) {
		this.messageReport = messageReport;
	}

	public String getMessageStatusR() {
		return messageStatusR;
	}

	public void setMessageStatusR(String messageStatusR) {
		this.messageStatusR = messageStatusR;
	}

	public String getMessageReason() {
		return messageReason;
	}

	public void setMessageReason(String messageReason) {
		this.messageReason = messageReason;
	}

	@Override
	public String toString() {
		return "MessageReport [messageNo=" + messageNo + ", memberNo=" + memberNo + ", messageReport=" + messageReport
				+ ", messageStatusR=" + messageStatusR + ", messageReason=" + messageReason + "]";
	}
	
	

	
}
