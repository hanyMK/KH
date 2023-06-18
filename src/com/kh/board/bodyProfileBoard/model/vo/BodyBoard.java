package com.kh.board.bodyProfileBoard.model.vo;

import java.util.Date;

public class BodyBoard {

   private int boardNo;
   private String memberNo;//11
   private String boardType;
   private String category;
   private String boardTitle;
   private String boardContent;
   private String createDate;
   private String updateDate;
   private int boardCount;
   private String voteYN;
   private String boardStatus;
   private int boardReportNo;
   private String alertStatus;
   
   // =========== 추가 ==================
   
   private String titleImg;
   
   private String nickName;
   
   private int boardLikeCount;
   
   private int replyCount;
   
   private int boardDislikeCount;

public BodyBoard() {
	super();
}

public BodyBoard(int boardNo, String memberNo, String boardType, String category, String boardTitle,
		String boardContent, String createDate, String updateDate, int boardCount, String voteYN, String boardStatus,
		int boardReportNo, String alertStatus, String titleImg, String nickName, int boardLikeCount, int replyCount,
		int boardDislikeCount) {
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
	this.voteYN = voteYN;
	this.boardStatus = boardStatus;
	this.boardReportNo = boardReportNo;
	this.alertStatus = alertStatus;
	this.titleImg = titleImg;
	this.nickName = nickName;
	this.boardLikeCount = boardLikeCount;
	this.replyCount = replyCount;
	this.boardDislikeCount = boardDislikeCount;
}

public int getBoardNo() {
	return boardNo;
}

public void setBoardNo(int boardNo) {
	this.boardNo = boardNo;
}

public String getMemberNo() {
	return memberNo;
}

public void setMemberNo(String memberNo) {
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

public void setBoardContent(String boardContent) {
	this.boardContent = boardContent;
}

public String getCreateDate() {
	return createDate;
}

public void setCreateDate(String createDate) {
	this.createDate = createDate;
}

public String getUpdateDate() {
	return updateDate;
}

public void setUpdateDate(String updateDate) {
	this.updateDate = updateDate;
}

public int getBoardCount() {
	return boardCount;
}

public void setBoardCount(int boardCount) {
	this.boardCount = boardCount;
}

public String getVoteYN() {
	return voteYN;
}

public void setVoteYN(String voteYN) {
	this.voteYN = voteYN;
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

public String getAlertStatus() {
	return alertStatus;
}

public void setAlertStatus(String alertStatus) {
	this.alertStatus = alertStatus;
}

public String getTitleImg() {
	return titleImg;
}

public void setTitleImg(String titleImg) {
	this.titleImg = titleImg;
}

public String getNickName() {
	return nickName;
}

public void setNickName(String nickName) {
	this.nickName = nickName;
}

public int getBoardLikeCount() {
	return boardLikeCount;
}

public void setBoardLikeCount(int boardLikeCount) {
	this.boardLikeCount = boardLikeCount;
}

public int getReplyCount() {
	return replyCount;
}

public void setReplyCount(int replyCount) {
	this.replyCount = replyCount;
}

public int getBoardDislikeCount() {
	return boardDislikeCount;
}

public void setBoardDislikeCount(int boardDislikeCount) {
	this.boardDislikeCount = boardDislikeCount;
}

@Override
public String toString() {
	return "BodyBoard [boardNo=" + boardNo + ", memberNo=" + memberNo + ", boardType=" + boardType + ", category="
			+ category + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", createDate=" + createDate
			+ ", updateDate=" + updateDate + ", boardCount=" + boardCount + ", voteYN=" + voteYN + ", boardStatus="
			+ boardStatus + ", boardReportNo=" + boardReportNo + ", alertStatus=" + alertStatus + ", titleImg="
			+ titleImg + ", nickName=" + nickName + ", boardLikeCount=" + boardLikeCount + ", replyCount=" + replyCount
			+ ", boardDislikeCount=" + boardDislikeCount + "]";
}


	



}
