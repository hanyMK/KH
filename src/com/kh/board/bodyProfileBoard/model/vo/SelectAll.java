package com.kh.board.bodyProfileBoard.model.vo;

public class SelectAll {
	
	   private int boardNo;
	   private int memberNo;
	   private String boardType;
	   private String category;
	   private String boardTitle;
	   private String boardContent;
	   private String createDate;
	   private String updateDate;
	   private int boardCount;
	   private String voteTitle;
	   private int fileNo;
	   private int fileLevel;
	   private String filePath;
	   private String fileStatus;
	   private String originName;
	   private String changeName;
	   private int postLike;
	   private int postDisLike;
	   private int replyCount;	   
	   private String boardStatus;
	   private int boardReportNo;
	   
	   private String nickName;
	   private String replyContent;
	   private String replyDate;
	   private int replyLikeCount;
	   private int replyDislikeCount;
	   
	   
	public SelectAll() {
		super();
	}


	public SelectAll(int boardNo, int memberNo, String boardType, String category, String boardTitle,
			String boardContent, String createDate, String updateDate, int boardCount, String voteTitle, int fileNo,
			int fileLevel, String filePath, String fileStatus, String originName, String changeName, int postLike,
			int postDisLike, int replyCount, String boardStatus, int boardReportNo, String nickName,
			String replyContent, String replyDate, int replyLikeCount, int replyDislikeCount) {
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
		this.voteTitle = voteTitle;
		this.fileNo = fileNo;
		this.fileLevel = fileLevel;
		this.filePath = filePath;
		this.fileStatus = fileStatus;
		this.originName = originName;
		this.changeName = changeName;
		this.postLike = postLike;
		this.postDisLike = postDisLike;
		this.replyCount = replyCount;
		this.boardStatus = boardStatus;
		this.boardReportNo = boardReportNo;
		this.nickName = nickName;
		this.replyContent = replyContent;
		this.replyDate = replyDate;
		this.replyLikeCount = replyLikeCount;
		this.replyDislikeCount = replyDislikeCount;
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


	public String getVoteTitle() {
		return voteTitle;
	}


	public void setVoteTitle(String voteTitle) {
		this.voteTitle = voteTitle;
	}


	public int getFileNo() {
		return fileNo;
	}


	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}


	public int getFileLevel() {
		return fileLevel;
	}


	public void setFileLevel(int fileLevel) {
		this.fileLevel = fileLevel;
	}


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	public String getFileStatus() {
		return fileStatus;
	}


	public void setFileStatus(String fileStatus) {
		this.fileStatus = fileStatus;
	}


	public String getOriginName() {
		return originName;
	}


	public void setOriginName(String originName) {
		this.originName = originName;
	}


	public String getChangeName() {
		return changeName;
	}


	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}


	public int getPostLike() {
		return postLike;
	}


	public void setPostLike(int postLike) {
		this.postLike = postLike;
	}


	public int getPostDisLike() {
		return postDisLike;
	}


	public void setPostDisLike(int postDisLike) {
		this.postDisLike = postDisLike;
	}


	public int getReplyCount() {
		return replyCount;
	}


	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
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


	public String getNickName() {
		return nickName;
	}


	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	public String getReplyContent() {
		return replyContent;
	}


	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}


	public String getReplyDate() {
		return replyDate;
	}


	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}


	public int getReplyLikeCount() {
		return replyLikeCount;
	}


	public void setReplyLikeCount(int replyLikeCount) {
		this.replyLikeCount = replyLikeCount;
	}


	public int getReplyDislikeCount() {
		return replyDislikeCount;
	}


	public void setReplyDislikeCount(int replyDislikeCount) {
		this.replyDislikeCount = replyDislikeCount;
	}


	@Override
	public String toString() {
		return "SelectAll [boardNo=" + boardNo + ", memberNo=" + memberNo + ", boardType=" + boardType + ", category="
				+ category + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", createDate="
				+ createDate + ", updateDate=" + updateDate + ", boardCount=" + boardCount + ", voteTitle=" + voteTitle
				+ ", fileNo=" + fileNo + ", fileLevel=" + fileLevel + ", filePath=" + filePath + ", fileStatus="
				+ fileStatus + ", originName=" + originName + ", changeName=" + changeName + ", postLike=" + postLike
				+ ", postDisLike=" + postDisLike + ", replyCount=" + replyCount + ", boardStatus=" + boardStatus
				+ ", boardReportNo=" + boardReportNo + ", nickName=" + nickName + ", replyContent=" + replyContent
				+ ", replyDate=" + replyDate + ", replyLikeCount=" + replyLikeCount + ", replyDislikeCount="
				+ replyDislikeCount + "]";
	}
	   
	   
	
	
	   
	
	   
  
	
	

}
