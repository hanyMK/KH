package com.kh.board.challenge.model.vo;

public class ChallengeVoteQuery {
	
	private int voteNo;//VOTE_NO	NUMBER
	private String voteType;//VOTE_TYPE	CHAR(3 BYTE)
	private String question;//QUESTION	VARCHAR2(300 BYTE)
	private int voteCount;//VOTE_COUNT	NUMBER
	
	public ChallengeVoteQuery() {
		super();
	}
	
	public ChallengeVoteQuery(int voteNo, String voteType, String question, int voteCount) {
		super();
		this.voteNo = voteNo;
		this.voteType = voteType;
		this.question = question;
		this.voteCount = voteCount;
	}
	
	public int getVoteNo() {
		return voteNo;
	}
	public void setVoteNo(int voteNo) {
		this.voteNo = voteNo;
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
	
	@Override
	public String toString() {
		return "ChallengeVoteQuery [voteNo=" + voteNo + ", voteType=" + voteType + ", question=" + question
				+ ", voteCount=" + voteCount + "]";
	}
	
	

}
