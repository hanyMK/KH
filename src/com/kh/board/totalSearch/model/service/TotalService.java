package com.kh.board.totalSearch.model.service;

import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.close;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.totalSearch.model.dao.TotalDao;
import com.kh.board.totalSearch.model.vo.TotalAll;

public class TotalService {
	
	public ArrayList<TotalAll> totalSearch(String key){
		
		Connection conn = getConnection();
		
		ArrayList<TotalAll> list = new TotalDao().totalSearch(conn, key);
		
		close(conn);
		
		return list;
		
		
	}

}
