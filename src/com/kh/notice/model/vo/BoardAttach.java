package com.kh.notice.model.vo;

public class BoardAttach {
	
	
	private int fileNo;//FILE_NO	NUMBER
	private int boardNo;//BOARD_NO	NUMBER
	private int fileLevel;//FILE_LEVEL	NUMBER
	private String originName;//ORIGIN_NAME	VARCHAR2(225 BYTE)
	private String changeName;//CHANGE_NAME	VARCHAR2(255 BYTE)
	private String filePath;//FILE_PATH	VARCHAR2(1000 BYTE)
	private String fileStatus;//FILE_STATUS	CHAR(3 BYTE)
	public BoardAttach() {
		super();
	}
	public BoardAttach(int fileNo, int boardNo, int fileLevel, String originName, String changeName, String filePath,
			String fileStatus) {
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
		return "BoardAttach [fileNo=" + fileNo + ", boardNo=" + boardNo + ", fileLevel=" + fileLevel + ", originName="
				+ originName + ", changeName=" + changeName + ", filePath=" + filePath + ", fileStatus=" + fileStatus
				+ "]";
	}
	
}
