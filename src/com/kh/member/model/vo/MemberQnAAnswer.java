package com.kh.member.model.vo;

import java.sql.Date;

public class MemberQnAAnswer {
	
	private int qnaAno; //QNA_ANO	NUMBER
	private int qnaNo; // QNA_NO	NUMBER
	private String qnaAnswerContent; //QNA_ANSWER_CONTENT	VARCHAR2(1000 BYTE)
	private String qnaAnswerDate; // QNA_ANSWER_DATE	DATE
	
	public MemberQnAAnswer() {
		super();
	}

	public MemberQnAAnswer(int qnaAno, String qnaAnswerContent, String qnaAnswerDate) {
		super();
		this.qnaAno = qnaAno;
		this.qnaAnswerContent = qnaAnswerContent;
		this.qnaAnswerDate = qnaAnswerDate;
	}		 
			 
			 
	public MemberQnAAnswer(int qnaAno, int qnaNo, String qnaAnswerContent, String qnaAnswerDate) {
		super();
		this.qnaAno = qnaAno;
		this.qnaNo = qnaNo;
		this.qnaAnswerContent = qnaAnswerContent;
		this.qnaAnswerDate = qnaAnswerDate;
	}

	public int getQnaAno() {
		return qnaAno;
	}

	public void setQnaAno(int qnaAno) {
		this.qnaAno = qnaAno;
	}

	public int getQnaNo() {
		return qnaNo;
	}

	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}

	public String getQnaAnswerContent() {
		return qnaAnswerContent;
	}

	public void setQnaAnswerContent(String qnaAnswerContent) {
		this.qnaAnswerContent = qnaAnswerContent;
	}

	public String getQnaAnswerDate() {
		return qnaAnswerDate;
	}

	public void setQnaAnswerDate(String qnaAnswerDate) {
		this.qnaAnswerDate = qnaAnswerDate;
	}

	@Override
	public String toString() {
		return "MemberQnAAnswer [qnaAno=" + qnaAno + ", qnaNo=" + qnaNo + ", qnaAnswerContent=" + qnaAnswerContent
				+ ", qnaAnswerDate=" + qnaAnswerDate + "]";
	}
	
	
	
	

}
