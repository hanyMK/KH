package com.kh.board.like.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.like.model.dao.LikeDao;
import com.kh.board.like.model.vo.Like;

public class LikeService {

	public int insertLike(int boardNo, int memberNo) {
		
		Connection conn = getConnection();
		
		int result = new LikeDao().insertLike(conn, boardNo, memberNo);
		
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
			
		}
		
		close(conn);
		
		
		return result;
	}

	public ArrayList<Like>  selectLike(int boardNo) {
		
		
		Connection conn = getConnection();
		
		ArrayList<Like>  likeCount = new LikeDao().selectLike(conn, boardNo);
		
		close(conn);
		
		
		
		return likeCount;
	}

	public ArrayList<Like> selectMemberNo(int boardNo) {
		
		
		Connection conn = getConnection();
		
		ArrayList<Like> list = new LikeDao().selectMemberNo(conn, boardNo);
		
		close(conn);
		
		
		
		return list;
	}

	public int deleteLike(int boardNo, int memberNo) {
		
		
		Connection conn = getConnection();
		
		int delete = new LikeDao().deleteLike(conn, boardNo, memberNo);
		
		if(delete > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		
		return delete;
	}

	public ArrayList<Like> selectLikeCount() {
		
		Connection conn = getConnection();
		
		ArrayList<Like>  likeCount = new LikeDao().selectLikeCount(conn);
		
		close(conn);
		
		
		return likeCount;
	}
	
	
	
	

}
