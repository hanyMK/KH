package com.kh.board.like.model.vo;

public class Like {

	
	private int boardNo; //BOARD_NO
	private int boardLikeCount; // BOARD_LIKE_COUNT
	private int boardDislikeCount; //BOARD_DISLIKE_COUNT
	private int memberNo;
	public Like() {
		super();
	}
	public Like(int boardNo, int boardLikeCount, int boardDislikeCount, int memberNo) {
		super();
		this.boardNo = boardNo;
		this.boardLikeCount = boardLikeCount;
		this.boardDislikeCount = boardDislikeCount;
		this.memberNo = memberNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getBoardLikeCount() {
		return boardLikeCount;
	}
	public void setBoardLikeCount(int boardLikeCount) {
		this.boardLikeCount = boardLikeCount;
	}
	public int getBoardDislikeCount() {
		return boardDislikeCount;
	}
	public void setBoardDislikeCount(int boardDislikeCount) {
		this.boardDislikeCount = boardDislikeCount;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	@Override
	public String toString() {
		return "Like [boardNo=" + boardNo + ", boardLikeCount=" + boardLikeCount + ", boardDislikeCount="
				+ boardDislikeCount + ", memberNo=" + memberNo + "]";
	}
	
	
	
	
	
	
	
	
	
}
