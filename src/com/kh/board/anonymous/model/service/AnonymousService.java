package com.kh.board.anonymous.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.anonymous.model.dao.AnonymousDao;
import com.kh.board.anonymous.model.vo.Anonymous;
import com.kh.board.anonymous.model.vo.SelectAll;
import com.kh.board.challenge.model.dao.ChallengeDao;
import com.kh.board.challenge.model.vo.ChallengeAttachment;
import com.kh.board.challenge.model.vo.ChallengeBoard;
import com.kh.board.challenge.model.vo.ChallengeVoteQuery;
import com.kh.board.challenge.model.vo.ChallengeVoteTitle;
import com.kh.board.hashtag.model.dao.HashtagDao;
import com.kh.common.model.vo.BoardAttachment;
import com.kh.common.model.vo.BoardLikePost;
import com.kh.common.model.vo.PageInfo;



public class AnonymousService {
	
	public int selectListCount() {
		Connection conn = getConnection ();
		
		int result = new AnonymousDao().selectListCount(conn);
		
		close(conn);
		return result;
		
	}
	
	
	
	public ArrayList<SelectAll> selectAllList( PageInfo pi){
		Connection conn = getConnection();
		
		ArrayList<SelectAll> list  = new AnonymousDao().selectAllList(conn, pi);
		//System.out.println(list);
		
		close(conn);
		
		return list;
		
	}
	
	public ArrayList<SelectAll> selectAllBoard(int boardNo) {
		
		Connection conn = getConnection();
		
		ArrayList<SelectAll> all  = new AnonymousDao().selectAllBoard(conn, boardNo);
		//System.out.println(list);
		
		close(conn);
		
		return all;
		
		
		
	}
	


	
	

//	
//	public ArrayList<Vote> selectVoteList(){
//		Connection conn = getConnection();
//		
//		ArrayList<Vote> vList = new Anonymous().selectVoteList(conn);
//		
//		close(conn);
//		
//		return vList;
//		
//		
//		
//	}
	
	
	public ArrayList<BoardLikePost> selectBoardLike() {
		Connection conn = getConnection();
		
		ArrayList<BoardLikePost>bLike = new AnonymousDao().selectBoardLike(conn);
		
		close(conn);
		
		return bLike;
		
	}
	
//	public ArrayList<Reply> replyCount() {
//		Connection conn = getConnection ();
//		
//		ArrayList<Reply> rList = new AnonymousDao().replyCount(conn);
//		
//		close(conn);
//		return rList;
//		
//	}

	
	public int insertAnonymous(Anonymous a, ArrayList<BoardAttachment> list) {
		
		Connection conn = getConnection();
		
		int result1 = new AnonymousDao().inserAnonymous(conn, a);
		//System.out.println("result1");
		
		
		
		int result2 = new AnonymousDao().insertAnAttachment(conn, list);
		result2= 1;
		//System.out.println("result2");
		//System.out.println("결과" +result1 +"결과2"+ result2);
		 
		
		if((result1 * result2) > 0) {
			commit(conn);
		}else {
			rollback(conn);
			
		}
		
		close(conn);
		
		
		return (result1* result2);
	}

	
	public int insertAnonymousWithVote(Anonymous a, ArrayList<BoardAttachment> list, ChallengeVoteTitle cvt, ArrayList<ChallengeVoteQuery> queryList) {
		
		Connection conn = getConnection();
	
		System.out.println(cvt + "투표가 있을때의 객체, " + queryList + " 항목이 있을때의 리스트");
		
		// 게시글, 첨부파일, 투표를 받았을때의 insert
		
		
		int result1 = new AnonymousDao().inserAnonymous(conn, a);
		
		 int result2 = new AnonymousDao().insertAnAttachment(conn, list);
		
		 int result3 = new ChallengeDao().insertChallengeVoteTitle(conn, cvt);
		
		 int result4 = new ChallengeDao().insertChallengeVoteQuery(conn, queryList);
		
		  result2 = 1;
		  result3 = 1;
		 result4 = 1;
	
		// 결과 확인후 controller로 보내주기
		if((result1 * result2 * result3 * result4) > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return (result1 * result2 * result3 * result4);
		
		
	}

	
	public int increasBoard(int boardNo) {
		Connection conn = getConnection ();
		
		int result = new AnonymousDao().increasBoard(conn, boardNo);
		
		close(conn);
		return result;
		
		
	}
	

	
	public ArrayList<BoardAttachment> selectAttach(int boardNo){
		
		Connection conn = getConnection();
		
		ArrayList<BoardAttachment> attach = new AnonymousDao().selectAttach(conn, boardNo);
		
		close(conn);
		
		return attach;
	}
	
	
	public int deleteBoard(int boardNo) {
		Connection conn = getConnection();
		int result1 = new AnonymousDao().deleteBoard(conn, boardNo);
		//System.out.println("게시물 삭제"+result1);
		
		int result2 = new HashtagDao().deleteHashtag(conn, boardNo);
		//System.out.println("해시태그 삭제"+result1);
		int result3 = new AnonymousDao().deleteAtt(conn, boardNo);
		 result2 = 1;
		 result3 = 1; 
		System.out.println(result1+", 2= "+result2+", 3="+result3);
		if((result1* result2 * result3)>0) {
			commit(conn);
			
		}else {
			rollback(conn);
		}
		close(conn);
		
		return (result1 * result2*result3);
	}

	
//	public ArrayList<Reply> selectReply(PageInfo pi,int boardNo){
//		Connection conn = getConnection();
//		
//		ArrayList<Reply> rList = new AnonymousDao().selectReply(conn,pi, boardNo);
//		
//		close(conn);
//		
//		return rList;
//	}
//	
	
	public ArrayList<BoardAttachment> selectAttachAll(){
		
		Connection conn = getConnection();
		
		ArrayList<BoardAttachment> pList = new AnonymousDao().selectAttachAll(conn);
		
		close(conn);
		return pList;
		
		
	}
}
