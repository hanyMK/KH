package com.kh.common.model.vo;

public class Vote {
	
	private int voteNo;//VOTE_NO	NUMBER
	private int boardNo;//BOARD_NO	NUMBER
	private String voteTitle;//VOTE_TITLE	VARCHAR2(300 BYTE)
	private String dupli;//VOTE_DUPLI	CHAR(3 BYTE) 중복체크 가능 여부
	private String voteType;//VOTE_TYPE	CHAR(3 BYTE) A,B,C,D
	private String question;// QUESTION	VARCHAR2(300 BYTE)
	private int  voteCount;//VOTE_COUNT	NUMBER
	private String voteYN; //VOTE_YN	CHAR(3 BYTE)
	
	
	
	public Vote() {
		super();
	}
	public Vote(int voteNo, int boardNo, String voteTitle, String dupli, String voteType, String question,
			int voteCount, String voteYN) {
		super();
		this.voteNo = voteNo;
		this.boardNo = boardNo;
		this.voteTitle = voteTitle;
		this.dupli = dupli;
		this.voteType = voteType;
		this.question = question;
		this.voteCount = voteCount;
		this.voteYN = voteYN;
	}
	public int getVoteNo() {
		return voteNo;
	}
	public void setVoteNo(int voteNo) {
		this.voteNo = voteNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getVoteTitle() {
		return voteTitle;
	}
	public void setVoteTitle(String voteTitle) {
		this.voteTitle = voteTitle;
	}
	public String getDupli() {
		return dupli;
	}
	public void setDupli(String dupli) {
		this.dupli = dupli;
	}
	public String getVoteType() {
		return voteType;
	}
	public void setVoteType(String voteType) {
		this.voteType = voteType;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public int getVoteCount() {
		return voteCount;
	}
	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}
	public String getVoteYN() {
		return voteYN;
	}
	public void setVoteYN(String voteYN) {
		this.voteYN = voteYN;
	}
	@Override
	public String toString() {
		return "Vote [voteNo=" + voteNo + ", boardNo=" + boardNo + ", voteTitle=" + voteTitle + ", dupli=" + dupli
				+ ", voteType=" + voteType + ", question=" + question + ", voteCount=" + voteCount + ", voteYN="
				+ voteYN + "]";
	}
	
	
	
	
	
	

}
