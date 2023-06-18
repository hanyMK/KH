package com.kh.board.anonymous.model.vo;

import java.sql.Date;

public class Anonymous {


   private int boardNo;
   private int memberNo;
   private String boardType;
   private String category;
   private String boardTitle;
   private String boardContent;
   private String createDate;
   private String updateDate;
   private int boardCount;
   private String voteYN;
   private String hashtagYN;
   private String boardStatus;
   private int boardReportNo;
   private Date closeDate;
public Anonymous() {
	super();
}
public Anonymous(int boardNo, int memberNo, String boardType, String category, String boardTitle, String boardContent,
		String createDate, String updateDate, int boardCount, String voteYN, String hashtagYN, String boardStatus,
		int boardReportNo, Date closeDate) {
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
	this.hashtagYN = hashtagYN;
	this.boardStatus = boardStatus;
	this.boardReportNo = boardReportNo;
	this.closeDate = closeDate;
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
public String getHashtagYN() {
	return hashtagYN;
}
public void setHashtagYN(String hashtagYN) {
	this.hashtagYN = hashtagYN;
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
public Date getCloseDate() {
	return closeDate;
}
public void setCloseDate(Date closeDate) {
	this.closeDate = closeDate;
}
@Override
public String toString() {
	return "Anonymous [boardNo=" + boardNo + ", memberNo=" + memberNo + ", boardType=" + boardType + ", category="
			+ category + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", createDate=" + createDate
			+ ", updateDate=" + updateDate + ", boardCount=" + boardCount + ", voteYN=" + voteYN + ", hashtagYN="
			+ hashtagYN + ", boardStatus=" + boardStatus + ", boardReportNo=" + boardReportNo + ", closeDate="
			+ closeDate + "]";
}
   
  




}
