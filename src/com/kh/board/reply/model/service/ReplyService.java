package com.kh.board.reply.model.service;
import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.reply.model.dao.ReplyDao;
import com.kh.board.reply.model.vo.ReReply;
import com.kh.board.reply.model.vo.Reply;
public class ReplyService {


	
public ArrayList<Reply> selectReplyList(int boardNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Reply> list = new ReplyDao().selectReplyList(conn, boardNo);
		
		
		
		close(conn);
		return list;
	}

// ============================ INSERT ========================================


public int insertReply(Reply r) {
		
		//System.out.println("댓글 서비스");
		Connection conn = getConnection();
		
		int result = new ReplyDao().insertReply(conn,r);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	
}

public int rereplyInsert(ReReply rere) {
	
		
	Connection conn = getConnection();
	
	
	int rereplyResult = new ReplyDao().rereplyInsert(conn, rere);
	
	System.out.println("여기가문제야????");
	
	if(rereplyResult > 0) {
		commit(conn);
	}else {
		rollback(conn);
	}
	
	close(conn);
	
	
	
	
	return rereplyResult;
}

	public ArrayList<ReReply> selectReReply(int replyNo) {
		
		Connection conn = getConnection();
		
		ArrayList<ReReply> rereplyList = new ReplyDao().selectReReplyList(conn, replyNo);
		
		close(conn);
		
		return rereplyList;
	}
	
	public int deleteReply(Reply r) {
		
		Connection conn = getConnection();
		
		int result = new ReplyDao().deleteReply(conn, r);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	
	
}











