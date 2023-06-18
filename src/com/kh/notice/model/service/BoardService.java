package com.kh.notice.model.service;

import static com.kh.common.JDBCTemplate.*;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.notice.model.vo.Board;
import com.kh.notice.model.vo.BoardAttach;
import com.kh.notice.model.dao.BoardDao;
import com.kh.common.model.vo.PageInfo;
import com.kh.member.model.dao.MemberDao;

public class BoardService {
	
	
	public ArrayList<Board> noticeList_1(PageInfo pin){
		
		Connection conn = getConnection();
		ArrayList<Board> noticeList = new BoardDao().noticeList_1(conn, pin);
		
		close(conn);
		return noticeList;
		
		
	}
	
	public int noticeListCount_1() {
		
		Connection conn = getConnection();
		int countList = new BoardDao().noticeListCount_1(conn);
		
		close(conn);
		return countList;
		
	}
	
	public int increaseCount_1(int boardNo) {
		
		Connection conn = getConnection();
		int result = new BoardDao().increaseCount_1(conn, boardNo);
		
		close(conn);
		return result;

	}
	
	public Board selectBoard_1(int boardNo) {
		
		Connection conn = getConnection();
		Board nb = new BoardDao().selectBoard_1(conn, boardNo);
		
		close(conn);
		return nb;
		
	}
	
	public ArrayList<BoardAttach> selectAttachment_1(int boardNo){
		
		Connection conn = getConnection();
		ArrayList<BoardAttach> nAList = new BoardDao().selectAttachment_1(conn, boardNo);
		
		close(conn);
		return nAList;
		
	}
	
	public int insertNoticeBoard_1(Board b, ArrayList<BoardAttach> nAList) {
		
		Connection conn = getConnection();
		
		int result1 = new BoardDao().insertNoticeBoard_1(conn, b);
		
		int result2 = new BoardDao().insertNoticeAttachList_1(conn, nAList);
		
		if((result1 * result2) > 0 ) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		System.out.println("게시판 결과"+result1);
		System.out.println("파일첨부 결과"+result2);
		
		return (result1 * result2);
		
	}
	
	

}
