package com.kh.member.model.vo;

public class Alarm {
	
	private int boardNo;
	private String boardTitle;
	private int replyNo;
	private int reReplyNo;
	private String replyContent;
	private String reReplyContent;
	private int countNewReply;
	private int countNewRereply;
	private String createDateb;
	private String createDater;
	private String createDaterr;
	private int countBoard;
	private int countAllReply;
	private String boardType;
	
	
	public Alarm() {
		super();
	}


	public Alarm(int boardNo, String boardTitle, int replyNo, int reReplyNo, String replyContent, String reReplyContent,
			int countNewReply, int countNewRereply, String createDateb, String createDater, String createDaterr,
			int countBoard, int countAllReply, String boardType) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.replyNo = replyNo;
		this.reReplyNo = reReplyNo;
		this.replyContent = replyContent;
		this.reReplyContent = reReplyContent;
		this.countNewReply = countNewReply;
		this.countNewRereply = countNewRereply;
		this.createDateb = createDateb;
		this.createDater = createDater;
		this.createDaterr = createDaterr;
		this.countBoard = countBoard;
		this.countAllReply = countAllReply;
		this.boardType = boardType;
	}


	public int getBoardNo() {
		return boardNo;
	}


	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}


	public String getBoardTitle() {
		return boardTitle;
	}


	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}


	public int getReplyNo() {
		return replyNo;
	}


	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}


	public int getReReplyNo() {
		return reReplyNo;
	}


	public void setReReplyNo(int reReplyNo) {
		this.reReplyNo = reReplyNo;
	}


	public String getReplyContent() {
		return replyContent;
	}


	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}


	public String getReReplyContent() {
		return reReplyContent;
	}


	public void setReReplyContent(String reReplyContent) {
		this.reReplyContent = reReplyContent;
	}


	public int getCountNewReply() {
		return countNewReply;
	}


	public void setCountNewReply(int countNewReply) {
		this.countNewReply = countNewReply;
	}


	public int getCountNewRereply() {
		return countNewRereply;
	}


	public void setCountNewRereply(int countNewRereply) {
		this.countNewRereply = countNewRereply;
	}


	public String getCreateDateb() {
		return createDateb;
	}


	public void setCreateDateb(String createDateb) {
		this.createDateb = createDateb;
	}


	public String getCreateDater() {
		return createDater;
	}


	public void setCreateDater(String createDater) {
		this.createDater = createDater;
	}


	public String getCreateDaterr() {
		return createDaterr;
	}


	public void setCreateDaterr(String createDaterr) {
		this.createDaterr = createDaterr;
	}


	public int getCountBoard() {
		return countBoard;
	}


	public void setCountBoard(int countBoard) {
		this.countBoard = countBoard;
	}


	public int getCountAllReply() {
		return countAllReply;
	}


	public void setCountAllReply(int countAllReply) {
		this.countAllReply = countAllReply;
	}


	public String getBoardType() {
		return boardType;
	}


	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}


	@Override
	public String toString() {
		return "Alarm [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", replyNo=" + replyNo + ", reReplyNo="
				+ reReplyNo + ", replyContent=" + replyContent + ", reReplyContent=" + reReplyContent
				+ ", countNewReply=" + countNewReply + ", countNewRereply=" + countNewRereply + ", createDateb="
				+ createDateb + ", createDater=" + createDater + ", createDaterr=" + createDaterr + ", countBoard="
				+ countBoard + ", countAllReply=" + countAllReply + ", boardType=" + boardType + "]";
	}


}

	