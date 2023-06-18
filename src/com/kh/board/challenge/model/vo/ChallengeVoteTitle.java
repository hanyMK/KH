package com.kh.board.challenge.model.vo;

public class ChallengeVoteTitle {
	
	private int voteNo;//VOTE_NO	NUMBER
	private int boardNo;//BOARD_NO	NUMBER
	private String voteTitle;//VOTE_TITLE	VARCHAR2(300 BYTE)
	private String voteYN;//VOTE_YN	CHAR(3 BYTE)
	private String voteDupli;//VOTE_DUPLI	CHAR(3 BYTE)
	
	public ChallengeVoteTitle() {
		super();
	}

	public ChallengeVoteTitle(int voteNo, int boardNo, String voteTitle, String voteYN, String voteDupli) {
		super();
		this.voteNo = voteNo;
		this.boardNo = boardNo;
		this.voteTitle = voteTitle;
		this.voteYN = voteYN;
		this.voteDupli = voteDupli;
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

	public String getVoteYN() {
		return voteYN;
	}

	public void setVoteYN(String voteYN) {
		this.voteYN = voteYN;
	}

	public String getVoteDupli() {
		return voteDupli;
	}

	public void setVoteDupli(String voteDupli) {
		this.voteDupli = voteDupli;
	}

	@Override
	public String toString() {
		return "ChallengeVoteTitle [voteNo=" + voteNo + ", boardNo=" + boardNo + ", voteTitle=" + voteTitle
				+ ", voteYN=" + voteYN + ", voteDupli=" + voteDupli + "]";
	}

	
}
