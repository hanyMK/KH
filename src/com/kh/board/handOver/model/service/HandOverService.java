package com.kh.board.handOver.model.service;
import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.handOver.model.dao.HandOverDao;
import com.kh.board.handOver.model.vo.HandOver;
import com.kh.common.model.vo.BoardAttachment;
import com.kh.common.model.vo.PageInfo;




public class HandOverService {
public int selectListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new HandOverDao().selectListCount(conn);
		
		close(conn);
		
		return listCount;
		
	}
	
	// 게시판 리스트 조회
	public ArrayList<HandOver> selectHandOverList(PageInfo pi){
		
		// Connection 객체 생성
		Connection conn = getConnection();
		
		// 받은 데이터없으니 바로 HandOverDao로 넘겨줌
		ArrayList<HandOver> list = new HandOverDao().selectHandOverList(conn, pi);
		
		
		close(conn);
		
		return list;
	}
	
	
	// 게시글 작성
	public int insertHandOver(HandOver ho, ArrayList<BoardAttachment> attList) {
		
		Connection conn = getConnection();
		
		int result1 = new HandOverDao().insertHandOverBoard(conn, ho);
		System.out.println("result1 : " + result1);
		int result2 = new HandOverDao().insertHandOverAttachment(conn, attList);
		System.out.println("result2 : " + result2);
		if((result1 * result2) > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return (result1 * result2);
	}
	
	// 게시글 상세조회 (게시판)
	public HandOver selectHandOverBoard(int boardNo) {
		
		Connection conn = getConnection();
		
		HandOver oB = new HandOverDao().selectHandOverBoard(conn, boardNo);
		
		close(conn);
		
		return oB;
	}
	
	// 게시글 상세조회 (첨부파일)
	public ArrayList<BoardAttachment> selectHandOverAtt(int boardNo){
		
		Connection conn = getConnection();
		
		ArrayList<BoardAttachment> att = new HandOverDao().selectHandOverAtt(conn, boardNo);
		
		close(conn);
		
		return att;
	}
	
	// 조회수 증가
	public int HandOverIncreaseCount(int boardNo) {
		
		Connection conn = getConnection();
		
		int result = new HandOverDao().HandOverIncreaseCount(conn, boardNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
//	
	public int updateHandOverBoard(HandOver ho, ArrayList<BoardAttachment> attList) {
		
		Connection conn = getConnection();
		
		int result1 = new HandOverDao().updateHandOverBoard(conn, ho);
		
		int result2 = 1;
		
		for(BoardAttachment att : attList) {
			
			if(att.getFileNo() != 0) {
				System.out.println((att.getFileNo()) + "업데이트할때의 file번호");
				System.out.println(att + "업데이할때의 oA객체");
				result2 = new HandOverDao().updateHandOverAttachment(conn, attList);
				System.out.println(result2 + "업데이트한 결과값");
			} else {
				result2 = new HandOverDao().newInsertHandOverAttachment(conn, attList);
				System.out.println(result2 + "새롭게 insert되는 첨부파일 결과값");
			}
			
		}
			/*
			for(int i = 0; i < 4; i++) {
				
				if(oAList.get(i).getFileNo() != 0) {
					// 기존에 첨부파일이 있었을 경우 => update
					result2 = new HandOverDao().updateHandOverAttachment(conn, oAList);
					System.out.println(result2 + "업데이트한 결과값");
				} else {
					//기존에 첨부파일이 없었을 경우 => insert
					result2 = new HandOverDao().newInsertHandOverAttachment(conn, oAList);
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
		
		System.out.println(result1 * result2);
		
		return (result1 * result2);
	}
//	
	public int deleteHandOverBoard(int boardNo) {
		
		Connection conn = getConnection();
		
		int result1 = new HandOverDao().deleteHandOverBoard(conn, boardNo);
		int result2 =1;
		
		if(result1 * result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result1* result2;
	}
	
	

}
