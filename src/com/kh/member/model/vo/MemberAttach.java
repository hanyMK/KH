package com.kh.member.model.vo;

public class MemberAttach {
	
	private int fileNo; //FILE_NO	NUMBER
	private int memberNo;//MEMBER_NO	NUMBER
	private String originName; //ORIGIN_FNAME	VARCHAR2(255 BYTE)
	private String changeName;//CHANGE_NAME	VARCHAR2(255 BYTE)
	private String filePath;// FILE_PATH	VARCHAR2(100 BYTE)
	private String fileStatus;// FILE_STATUS	CHAR(3 BYTE)
	
	public MemberAttach() {
		super();
	}

	public MemberAttach(int fileNo, int memberNo, String originName, String changeName, String filePath,
			String fileStatus) {
		super();
		this.fileNo = fileNo;
		this.memberNo = memberNo;
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

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
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
		return "Member_Attach [fileNo=" + fileNo + ", memberNo=" + memberNo + ", originName=" + originName
				+ ", changeName=" + changeName + ", filePath=" + filePath + ", fileStatus=" + fileStatus + "]";
	}
	
}