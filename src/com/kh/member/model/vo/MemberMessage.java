package com.kh.member.model.vo;

import java.sql.Date;

public class MemberMessage {
	
	private int messageNo; //MESSAGE_NO NUMBER
	private String fromNic; // FROM_NO NUMBER
	private String toNic; // TO_NO NUMBER
	private String messageTitle; // MESSAGE_TITLE VARCHAR2(100 BYTE)
	private String messageContent; // MESSAGE_CONTENT VARCHAR2(500 BYTE)
	private String messageAlertStatus; // MESSAGE_ALERT_STATUS CHAR(5 BYTE)
	private String messageReport; // MESSAGE_REPORT CHAR(2 BYTE)
	private Date messageDate; //  MESSAGE_DATE DATE
	private String messageYn; // MESSAGE_YN CHAR(3 BYTE)
	
	public MemberMessage() {
		super();
	}

	public MemberMessage(int messageNo, String fromNo, String toNo, String messageTitle, String messageContent,
			String messageAlertStatus, String messageReport, Date messageDate, String messageYn) {
		super();
		this.messageNo = messageNo;
		this.fromNic = fromNic;
		this.toNic = toNic;
		this.messageTitle = messageTitle;
		this.messageContent = messageContent;
		this.messageAlertStatus = messageAlertStatus;
		this.messageReport = messageReport;
		this.messageDate = messageDate;
		this.messageYn = messageYn;
	}

	public int getMessageNo() {
		return messageNo;
	}

	public void setMessageNo(int messageNo) {
		this.messageNo = messageNo;
	}

	public String getFromNic() {
		return fromNic;
	}

	public void setFromNic(String fromNic) {
		this.fromNic = fromNic;
	}

	public String getToNic() {
		return toNic;
	}

	public void setToNic(String toNic) {
		this.toNic = toNic;
	}

	public String getMessageTitle() {
		return messageTitle;
	}

	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public String getMessageAlertStatus() {
		return messageAlertStatus;
	}

	public void setMessageAlertStatus(String messageAlertStatus) {
		this.messageAlertStatus = messageAlertStatus;
	}

	public String getMessageReport() {
		return messageReport;
	}

	public void setMessageReport(String messageReport) {
		this.messageReport = messageReport;
	}

	public Date getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}

	public String getMessageYn() {
		return messageYn;
	}

	public void setMessageYn(String messageYn) {
		this.messageYn = messageYn;
	}

	@Override
	public String toString() {
		return "MemberMessage [messageNo=" + messageNo + ", fromNic=" + fromNic + ", toNic=" + toNic + ", messageTitle="
				+ messageTitle + ", messageContent=" + messageContent + ", messageAlertStatus=" + messageAlertStatus
				+ ", messageReport=" + messageReport + ", messageDate=" + messageDate + ", messageYn=" + messageYn
				+ "]";
	}
	
	
	
	

}