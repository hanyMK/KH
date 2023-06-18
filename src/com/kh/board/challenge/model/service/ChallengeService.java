package com.kh.board.challenge.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.challenge.model.dao.ChallengeDao;
import com.kh.board.challenge.model.vo.ChallengeAttachment;
import com.kh.board.challenge.model.vo.ChallengeBoard;
import com.kh.board.challenge.model.vo.ChallengeVoteQuery;
import com.kh.board.challenge.model.vo.ChallengeVoteTitle;
import com.kh.board.offer.model.dao.OfferDao;
import com.kh.board.offer.model.vo.OfferAttachment;
import com.kh.common.model.vo.PageInfo;

public class ChallengeService {
	
	public ArrayList<ChallengeBoard> selectChallengeList(PageInfo pi){
		
		Connection conn = getConnection();
		
		ArrayList<ChallengeBoard> clList = new ChallengeDao().selectChallengeList(conn, pi);
		
		return clList;
	}

	public int selectListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new ChallengeDao().selectListCount(conn);
		
		close(conn);
		
		return listCount;
		
	}
	
	public int insertChallenge(ChallengeBoard cB, ArrayList<ChallengeAttachment> clList, ChallengeVoteTitle cvt, ArrayList<ChallengeVoteQuery> queryList) {
		
			Connection conn = getConnection();
		
			System.out.println(cvt + "투표가 있을때의 객체, " + queryList + " 항목이 있을때의 리스트");
			
			// 게시글, 첨부파일, 투표를 받았을때의 insert
			int result1 = new ChallengeDao().insertChallengeBoard(conn, cB);
			
			int result2 = new ChallengeDao().insertChallengeAttachment(conn, clList);
			
			int result3 = new ChallengeDao().insertChallengeVoteTitle(conn, cvt);
			
			int result4 = new ChallengeDao().insertChallengeVoteQuery(conn, queryList);
			
		
			// 결과 확인후 controller로 보내주기
			if((result1 * result2 * result3 * result4) > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
			close(conn);
			
			return (result1 * result2 * result3 * result4);
			
			
	}
	
	public int insertChallengeNoVote(ChallengeBoard cB, ArrayList<ChallengeAttachment> clList) {
		
		Connection conn = getConnection();
		
		int result1 = new ChallengeDao().insertChallengeBoard(conn, cB);
		System.out.println("result1 : " + result1);
		int result2 = new ChallengeDao().insertChallengeAttachment(conn, clList);
		System.out.println("result2 : " + result2);
		if((result1 +result2) > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return (result1 * result2);
	}
	
	// 게시글 상세조회 (게시판)
	public ChallengeBoard ChallengeDetailView(int boardNo) {
			
		Connection conn = getConnection();
			
		ChallengeBoard cB = new ChallengeDao().ChallengeDetailView(conn, boardNo);
			
		close(conn);
			
		return cB;
	}
		
	// 게시글 상세조회 (첨부파일)
	public ArrayList<ChallengeAttachment> ChallengeAttachmentDetailView(int boardNo){
			
		Connection conn = getConnection();
		
		ArrayList<ChallengeAttachment> clList = new ChallengeDao().ChallengeAttachmentDetailView(conn, boardNo);
			
		close(conn);
			
		return clList;
	}
	
	// 조회수 증가
	public int ChallengeIncreaseCount(int boardNo) {
			
		Connection conn = getConnection();
			
		int result = new ChallengeDao().ChallengeIncreaseCount(conn, boardNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
			
		close(conn);
			
		return result;
	}
		
	public ChallengeVoteTitle ChallengeVoteTitleDetatilView(int boardNo) {
		
		Connection conn = getConnection();
		
		ChallengeVoteTitle cvt = new ChallengeDao().ChallengeVoteTitleDetatilView(conn, boardNo);
		
		close(conn);
		
		return cvt;
		
	}
	
	public ArrayList<ChallengeVoteQuery> ChallengeVoteQueryDetailView(int voteNo){
		
		Connection conn = getConnection();
		
		ArrayList<ChallengeVoteQuery> queryList = new ChallengeDao().ChallengeVoteQueryDetailView(conn, voteNo);
		
		close(conn);
		
		return queryList;
		
	}
	
	// 임시저장 메소드
	public int temporayInsertChallenge(ChallengeBoard cB, ArrayList<ChallengeAttachment> clList, ChallengeVoteTitle cvt, ArrayList<ChallengeVoteQuery> queryList) {
		
		Connection conn = getConnection();
		
		System.out.println(cvt + "투표가 있을때의 객체, " + queryList + " 항목이 있을때의 리스트");
		
		// 게시글, 첨부파일, 투표를 받았을때의 insert
//		int result1 = new ChallengeDao().temporayInsertChallengeBoard(conn, cB);
		
		int result2 = new ChallengeDao().insertChallengeAttachment(conn, clList);
		
		int result3 = new ChallengeDao().insertChallengeVoteTitle(conn, cvt);
		
		int result4 = new ChallengeDao().insertChallengeVoteQuery(conn, queryList);
		
	
		// 결과 확인후 controller로 보내주기
		if(( result2 + result3 + result4) > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return ( result2 + result3 + result4);
	}
	
	// 임시저장
	
	
	public int increaseChallengeVote(int memberNo, int voteNo, String voteType) {
		
		Connection conn = getConnection();
		
		int result1 = new ChallengeDao().increaseChallengeVote(conn, voteNo, voteType);
		
		int result2 = new ChallengeDao().enrollChallengeVote(conn, memberNo, voteNo);
		
		if((result1 * result2) > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return (result1 * result2);
	}
	
	public int dupliIncreaseVote(int memberNo, int voteNo, ArrayList<ChallengeVoteQuery> queryList) {
		
		Connection conn = getConnection();
		
		int result1 = new ChallengeDao().dupliIncreaseVote(conn, voteNo, queryList);
		System.out.println(queryList.size());
		int result2 = new ChallengeDao().enrollChallengeVote(conn, memberNo, voteNo);
		
		if((result1 + result2) > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return (result1 * result2);
	}
	
public int updateChallengeBoard(ChallengeBoard cB, ArrayList<ChallengeAttachment> clList) {
		
		Connection conn = getConnection();
		
		int result1 = new ChallengeDao().updateChallengeBoard(conn, cB);
		
		int result2 = 1;
		
		for(ChallengeAttachment cA : clList) {
			
			if(cA.getFileNo() != 0) {
				System.out.println((cA.getFileNo()) + "업데이트할때의 file번호");
				System.out.println(cA + "업데이할때의 oA객체");
				result2 = new ChallengeDao().updateChallengeAttachment(conn, clList);
				System.out.println(result2 + "업데이트한 결과값");
			} else {
				result2 = new ChallengeDao().newInsertChallengeAttachment(conn, clList);
				System.out.println(result2 + "새롭게 insert되는 첨부파일 결과값");
			}
			
		}
			/*
			for(int i = 0; i < 4; i++) {
				
				if(oAList.get(i).getFileNo() != 0) {
					// 기존에 첨부파일이 있었을 경우 => update
					result2 = new OfferDao().updateOfferAttachment(conn, oAList);
					System.out.println(result2 + "업데이트한 결과값");
				} else {
					//기존에 첨부파일이 없었을 경우 => insert
					result2 = new OfferDao().newInsertOfferAttachment(conn, oAList);
					System.out.println(result2 + "새롭게 insert되는 첨부파일 결과값");
				}
			}  // 첨부파일이 있었을 경우 for
		*/
			
		 // 새롭게 첨부파일이 있었을 경우 if문
		
		if((result1 + result2) > 0) {
			commit(conn);
			// System.out.println("커밋성공");
		} else {
			rollback(conn);
			// System.out.println("응 롤백");
		}
		
		close(conn);
		
		System.out.println(result1 * result2);
		
		return (result1 * result2);
	}

	public int deleteChallengeBoard(int boardNo) {
	
	Connection conn = getConnection();
	
	int result = new ChallengeDao().deleteChallengeBoard(conn, boardNo);
	
	if(result > 0) {
		commit(conn);
	} else {
		rollback(conn);
	}
	
	close(conn);
	
	return result;
}
}
