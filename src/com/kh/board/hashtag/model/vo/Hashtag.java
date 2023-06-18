package com.kh.board.hashtag.model.vo;

public class Hashtag {
	
	private int boardNo;//BOARD_NO	NUMBER
	private String hashtag;//HASHTAG	VARCHAR2(100 BYTE)
	private String hashContent;//HASH_CONTENT	VARCHAR2(100 BYTE)
	
	public Hashtag() {
		super();
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getHashtag() {
		return hashtag;
	}
	public void setHashtag(String hastag) {
		this.hashtag = hastag;
	}
	public String getHashContent() {
		return hashContent;
	}
	public void setHashContent(String hsasContent) {
		this.hashContent = hsasContent;
	}
	@Override
	public String toString() {
		return "Hashtag [boardNo=" + boardNo + ", hastag=" + hashtag + ", hsasContent=" + hashContent + "]";
	}
	
	
	
	

}
