package com.kh.board.bodyProfileBoard.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.anonymous.model.dao.AnonymousDao;
import com.kh.board.anonymous.model.vo.Anonymous;
import com.kh.board.bodyProfileBoard.model.dao. BodyDao;
import com.kh.board.bodyProfileBoard.model.vo.BoardAttachment;
import com.kh.board.bodyProfileBoard.model.vo.BodyBoard;
import com.kh.board.challenge.model.dao.ChallengeDao;
import com.kh.board.challenge.model.vo.ChallengeVoteQuery;
import com.kh.board.challenge.model.vo.ChallengeVoteTitle;

public class BodyService {

//	public ArrayList<BodyBoard> selectBodyList() {
//		
//		Connection conn = getConnection();
//		
//		ArrayList<BodyBoard> list = new  BodyDao().selectBodyList(conn);
//		
//		
//		
//		
//		
//		
//		return null;
//	}


	public ArrayList<BodyBoard> selectBodyList() {
		
		Connection conn = getConnection();
		
		ArrayList<BodyBoard> list = new BodyDao().selectBodyList(conn);
		System.out.println("list_service");
		
		close(conn);
		
		
		return list;
	}

	public int increaseCount(int boardNo) {
		
		Connection conn = getConnection();
		
		int result = new BodyDao().increaseCount(conn, boardNo);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	public ArrayList<BodyBoard> selectDetail(int boardNo) {
		
		
		Connection conn = getConnection();
		
		ArrayList<BodyBoard> listAll = new BodyDao().selectDetail(conn, boardNo);
		
		
		close(conn);
		
		return listAll;
	}

	public ArrayList<BoardAttachment> detailAttachment(int boardNo) {
		
		Connection conn = getConnection();
		
		ArrayList<BoardAttachment> list = new BodyDao().detailAttachment(conn, boardNo);
		return list;
	}



	public int updateBoardLike(int boardNo, int memberNo) {
		
		Connection conn = getConnection();
		
		int result = new BodyDao().updateBoardLike(conn, boardNo, memberNo);
		
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		
		return result;
	}

	public int selectBoardLike(int boardNo, int memberNo) {
		
		Connection conn = getConnection();
		
		int result = new BodyDao().selectBoardLike(conn, boardNo, memberNo);
		
		System.out.println("여기가null? : " + result);
		
		
		close(conn);
		
		return result;
	}

	public int insertBodyWithVote(BodyBoard bb, ArrayList<BoardAttachment> list, ChallengeVoteTitle cvt,
			ArrayList<ChallengeVoteQuery> queryList) {
		
		
		Connection conn = getConnection();
		
		System.out.println(cvt + "투표가 있을때의 객체, " + queryList + " 항목이 있을때의 리스트");
		
		// 게시글, 첨부파일, 투표를 받았을때의 insert
		
		int result2 = 1;
		int result3 = 1;
		int result4 = 1;
		
		int result1 = new BodyDao().insertBody(conn, bb);
		
		result2 = new BodyDao().insertBodyAttachment(conn, list);
		
		result3 = new ChallengeDao().insertChallengeVoteTitle(conn, cvt);
		
		result4 = new ChallengeDao().insertChallengeVoteQuery(conn, queryList);
		
	
		// 결과 확인후 controller로 보내주기
		if((result1 * result2 * result3 * result4) > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return (result1 * result2 * result3 * result4);
		
		
	}

	public int insertBody(BodyBoard bb, ArrayList<BoardAttachment> list) {
		
		
		Connection conn = getConnection();
		
		int result1 = new BodyDao().insertBody(conn, bb);
		//System.out.println("result1");
		
		int result2= 1;
		
		
		 result2 = new BodyDao().insertBodyAttachment(conn, list);
		//System.out.println("result2");
		 
		
		if((result1 * result2) > 0) {
			commit(conn);
		}else {
			rollback(conn);
			
		}
		
		close(conn);
		
		
		return (result1* result2);
	}

	public int deleteBoard(int boardNo) {
			
			Connection conn = getConnection();
			
			int result = new BodyDao().deleteBoard(conn, boardNo);
			
			if(result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
			
			close(conn);
			
			return result;
		}



}










