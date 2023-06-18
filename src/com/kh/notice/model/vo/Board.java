package com.kh.notice.model.vo;

import java.util.Date;

public class Board {
	
	int boardNo;//BOARD_NO	NUMBER
	int memberNo; //MEMBER_NO	NUMBER
	String boardType;//BOARD_TYPE	CHAR(5 BYTE)
	String category;//CATEGORY	VARCHAR2(20 BYTE)
	String boardTitle;//BOARD_TITLE	VARCHAR2(500 BYTE)
	String boardContent;//BOARD_CONTENT	VARCHAR2(3000 BYTE)
	Date createDate;//CREATE_DATE	DATE
	Date updateDate;//UPDATE_DATE	DATE
	int boardCount;//BOARD_COUNT	NUMBER
	String voteYn;//VOTE_YN	CHAR(3 BYTE)
	String hashtagYn;//HASHTAG_YN	CHAR(3 BYTE)
	String boardStatus;//BOARD_STATUS	CHAR(3 BYTE)
	int boardReportNo;//BOARD_REPORT_NO	NUMBER
	Date closingDate;//CLOSING_DATE	DATE
	public Board() {
		super();
	}
	public Board(int boardNo, int memberNo, String boardType, String category, String boardTitle, String boardContent,
			Date createDate, Date updateDate, int boardCount, String voteYn, String hashtagYn, String boardStatus,
			int boardReportNo, Date closingDate) {
		super();
		this.boardNo = boardNo;
		this.memberNo = memberNo;
		this.boardType = boardType;
		this.category = category;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.boardCount = boardCount;
		this.voteYn = voteYn;
		this.hashtagYn = hashtagYn;
		this.boardStatus = boardStatus;
		this.boardReportNo = boardReportNo;
		this.closingDate = closingDate;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getBoardType() {
		return boardType;
	}
	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String board_content) {
		this.boardContent = board_content;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public int getBoardCount() {
		return boardCount;
	}
	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}
	public String getVoteYn() {
		return voteYn;
	}
	public void setVoteYn(String voteYn) {
		this.voteYn = voteYn;
	}
	public String getHashtagYn() {
		return hashtagYn;
	}
	public void setHashtagYn(String hashtagYn) {
		this.hashtagYn = hashtagYn;
	}
	public String getBoardStatus() {
		return boardStatus;
	}
	public void setBoardStatus(String boardStatus) {
		this.boardStatus = boardStatus;
	}
	public int getBoardReportNo() {
		return boardReportNo;
	}
	public void setBoardReportNo(int boardReportNo) {
		this.boardReportNo = boardReportNo;
	}
	public Date getClosingDate() {
		return closingDate;
	}
	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}
	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", memberNo=" + memberNo + ", boardType=" + boardType + ", category="
				+ category + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", createDate="
				+ createDate + ", updateDate=" + updateDate + ", boardCount=" + boardCount + ", voteYn=" + voteYn
				+ ", hashtagYn=" + hashtagYn + ", boardStatus=" + boardStatus + ", boardReportNo=" + boardReportNo
				+ ", closingDate=" + closingDate + "]";
	}
	
}
