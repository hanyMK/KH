package com.kh.board.topten.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.topten.model.dao.TopTenDao;
import com.kh.board.topten.model.vo.SelectAll;

public class TopTenService {
	
	public ArrayList<SelectAll> selectTopTenList(){
		
		Connection conn = getConnection();
		
		ArrayList<SelectAll> list = new TopTenDao().selectTopTenList(conn);
		
		
		close(conn);
		
		return list;
	}
	
	
	public ArrayList<SelectAll> selectTopTenTenList(){
		
		Connection conn = getConnection();
		
		ArrayList<SelectAll> list = new TopTenDao().selectTopTenTenList(conn);
		
		
		close(conn);
		
		return list;
	}

}

