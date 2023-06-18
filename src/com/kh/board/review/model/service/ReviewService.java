package com.kh.board.review.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.offer.model.dao.OfferDao;
import com.kh.board.offer.model.vo.OfferAttachment;
import com.kh.board.offer.model.vo.OfferBoard;
import com.kh.board.review.model.dao.ReviewDao;
import com.kh.board.review.model.vo.Review;
import com.kh.common.model.vo.BoardAttachment;
import com.kh.common.model.vo.PageInfo;


public class ReviewService {

	public int selectListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new ReviewDao().selectListCount(conn);
		
		close(conn);
		
		return listCount;
		
	}
	
	// 게시판 리스트 조회
		public ArrayList<Review> selectReviewList(PageInfo pi){
			
			// Connection 객체 생성
			Connection conn = getConnection();
			
			// 받은 데이터없으니 바로 OfferDao로 넘겨줌
			ArrayList<Review> list = new ReviewDao().selectReviewList(conn, pi);
			
			
			close(conn);
			
			return list;
		}
		
		
		
		
		
		
		
		// 게시글 작성
		public int insertReview(Review oB, ArrayList<BoardAttachment> oAList) {
			
			Connection conn = getConnection();
			
			int result1 = new ReviewDao().insertReviewBoard(conn, oB);
			System.out.println("result1 : " + result1);
			int result2 = new ReviewDao().insertReviewAttachment(conn, oAList);
			System.out.println("result2 : " + result2);
			
			
			if((result1 + result2) > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
			close(conn);
			
			return (result1 * result2);
		}
		
		// 게시글 상세조회 (게시판)
		public Review reviewDetailView(int boardNo) {
			
			Connection conn = getConnection();
			
			Review oB = new ReviewDao().reviewDetailView(conn, boardNo);
			
			close(conn);
			
			return oB;
		}
		
		// 게시글 상세조회 (첨부파일)
		public ArrayList<BoardAttachment> reviewAttachmentDetailView(int boardNo){
			
			Connection conn = getConnection();
			
			ArrayList<BoardAttachment> oAList = new ReviewDao().reviewAttachmentDetailView(conn, boardNo);
			
			close(conn);
			
			return oAList;
		}
		
		// 조회수 증가
		public int reviewIncreaseCount(int boardNo) {
			
			Connection conn = getConnection();
			
			int result = new ReviewDao().reviewIncreaseCount(conn, boardNo);
			
			if(result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
			
			close(conn);
			
			return result;
		}
		
		public int updateReviewBoard(Review oB, ArrayList<BoardAttachment> oAList) {
			
			Connection conn = getConnection();
			
			int result1 = new ReviewDao().updateReviewBoard(conn, oB);
			
			int result2 = 1;
			
			for(BoardAttachment oA : oAList) {
				
				if(oA.getFileNo() != 0) {
					//System.out.println((oA.getFileNo()) + "업데이트할때의 file번호");
					//System.out.println(oA + "업데이할때의 oA객체");
					result2 = new ReviewDao().updateReviewAttachment(conn, oAList);
					//System.out.println(result2 + "업데이트한 결과값");
				} else {
					result2 = new ReviewDao().newInsertReviewAttachment(conn, oAList);
					//System.out.println(result2 + "새롭게 insert되는 첨부파일 결과값");
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
			
			if((result1 * result2) > 0) {
				commit(conn);
				System.out.println("커밋성공");
			} else {
				rollback(conn);
				System.out.println("응 롤백");
			}
			
			close(conn);
			
			// System.out.println(result1 * result2);
			
			return (result1 * result2);
		}
		
		public int deleteReviewBoard(int boardNo) {
			
			Connection conn = getConnection();
			
			int result = new ReviewDao().deleteReviewBoard(conn, boardNo);
			
			if(result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
			
			close(conn);
			
			return result;
		}
}
