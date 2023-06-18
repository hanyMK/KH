package com.kh.common.model.vo;

public class BoardLikePost {
	
	
	private String memberNo;// MEMBER_No
	private int boardNo;//BOARD_NO
	private int like;// BORAD_LIKE_COUNT
	private int disLike;//BOARD_DISLIKE_COUNT
	public BoardLikePost() {
		super();
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public int getDisLike() {
		return disLike;
	}
	public void setDisLike(int disLike) {
		this.disLike = disLike;
	}
	@Override
	public String toString() {
		return "BoardLikePost [memberNo=" + memberNo + ", boardNo=" + boardNo + ", like=" + like + ", disLike="
				+ disLike + "]";
	}
	
	
	
	

}