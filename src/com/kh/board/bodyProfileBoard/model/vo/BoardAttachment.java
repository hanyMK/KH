package com.kh.board.bodyProfileBoard.model.vo;

public class BoardAttachment {
	
	private int fileNo;
	private int boardNo;
	private int fileLevel;	
	private String originName;
	private String changeName;	
	private String filePath;
	private String fileStatus;
	
	
	public BoardAttachment() {
		super();
	}


	public BoardAttachment(int fileNo, int boardNo, int fileLevel, String originName, String changeName,
			String filePath, String fileStatus) {
		super();
		this.fileNo = fileNo;
		this.boardNo = boardNo;
		this.fileLevel = fileLevel;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.fileStatus = fileStatus;
	}


	public int getFileNo() {
		return fileNo;
	}


	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}


	public int getBoardNo() {
		return boardNo;
	}


	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}


	public int getFileLevel() {
		return fileLevel;
	}


	public void setFileLevel(int fileLevel) {
		this.fileLevel = fileLevel;
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


	@Override
	public String toString() {
		return "BoardAttachment [fileNo=" + fileNo + ", boardNo=" + boardNo + ", fileLevel=" + fileLevel
				+ ", originName=" + originName + ", changeName=" + changeName + ", filePath=" + filePath
				+ ", fileStatus=" + fileStatus + "]";
	}
	
	
	
	
	
	

}
