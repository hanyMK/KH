package com.kh.board.hashtag.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.anonymous.model.dao.AnonymousDao;
import com.kh.board.anonymous.model.vo.SelectAll;
import com.kh.board.hashtag.model.dao.HashtagDao;
import com.kh.board.hashtag.model.vo.Hashtag;
import com.kh.common.model.vo.PageInfo;

public class HashtagService {
	
	
	
	public int selectHashtagListCount(String hashContent) {
		Connection conn = getConnection ();
		
		int result = new HashtagDao().selectHashtagListCount(conn, hashContent);
		
		close(conn);
		return result;
		
	}
	
	public ArrayList<Hashtag> selectHashtag(){
		Connection conn = getConnection ();
		ArrayList<Hashtag> hList = new HashtagDao().selectHashtag(conn);
		
		close(conn);
		
		
		return hList;
		
	}
	
	public  int selectLastBoardNo() {
		Connection conn = getConnection();
		
		int boardNo = new HashtagDao().selectLastBoardNo(conn);
		
		close(conn);
		
		
		return boardNo;
	}
	
	
	public int insertHashtag(String hashtag) {
		Connection conn = getConnection();
		
		int result = new HashtagDao().insertHashtag(conn, hashtag);
		
		if(result>0) {
			commit(conn);
			
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
		
	}
	
	
	public  int insertBoardHashtag(int boardNo, String[] hashtag) {
		
		Connection conn = getConnection();
		
		int result= new HashtagDao().insertBoardHashtag(conn, boardNo, hashtag);
		
		System.out.println("서비스 해시ㅐ"+String.join(",", hashtag));
		
		if(result  > 0) {
			commit(conn);
		}else {
			rollback(conn);
			
		}
		
		close(conn);
		return result;
	
	}
	public ArrayList<Hashtag> selectHashtagByBoardNo(int boardNo){
		Connection conn = getConnection ();
		ArrayList<Hashtag> hList = new HashtagDao().selectHashtagByBoardNo(conn, boardNo);
		
		close(conn);
		
		
		return hList;
		
	}
	
	public ArrayList<SelectAll> searchTag(String hashContent, PageInfo pi){
		Connection conn = getConnection();
		
		ArrayList<SelectAll> tagSerchList = new HashtagDao().searchTag(conn, hashContent, pi);
		
		close(conn);
		return tagSerchList;
		
	}
	
	public ArrayList<Hashtag> selectHashtagList(String keyword){
		Connection conn = getConnection();
		
		ArrayList<Hashtag> hashtag = new HashtagDao().selectHashtagList(conn, keyword);
		
		close(conn);
		return hashtag;
		
	}
	
//	public ArrayList<Hashtag> selectHashList(){
//		Connection conn = getConnection ();
//		ArrayList<Hashtag> hList = new HashtagDao().selectHashList(conn);
//		
//		close(conn);
//		
//		
//		return hList;
//		
//	}
	
	
	public ArrayList<Hashtag> selectHashtagForupdate(int boardNo){
		Connection conn = getConnection ();
		ArrayList<Hashtag> hList = new HashtagDao().selectHashtagForupdate(conn, boardNo);
		
		close(conn);
		
		
		return hList;
		
	}
	
	
	public  int deleteHashtagForUpdate(int boardNo, String target) {
			
			Connection conn = getConnection();
			
			int result= new HashtagDao().deleteHashtagForUpdate(conn, boardNo, target);
			
			System.out.println("target"+ target);
			System.out.println(result);
			
			if(result  > 0) {
				commit(conn);
			}else {
				rollback(conn);
				
			}
			
			close(conn);
			return result;
		
		}
	
	
	

}
