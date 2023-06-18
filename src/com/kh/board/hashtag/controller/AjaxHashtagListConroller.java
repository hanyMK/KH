package com.kh.board.hashtag.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.board.hashtag.model.service.HashtagService;
import com.kh.board.hashtag.model.vo.Hashtag;

/**
 * Servlet implementation class AjaxHashtagListConroller
 */
@WebServlet("/hashtag.list")
public class AjaxHashtagListConroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxHashtagListConroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//모든 해시태그 리스트 가져와서 뿌려주기
		//해시태그가 입력될때마다 sql문 전달하기
		
//		String keyword = request.getParameter("tag").trim().substring(1);
//		System.out.println(keyword);
//		
//		
//		ArrayList<Hashtag> hashtag = new HashtagService().selectHashtagList(keyword);
//		if(!hashtag.isEmpty()) {
//			response.setContentType("application/json; charset=UTF-8");
//			new Gson().toJson(hashtag, response.getWriter());
//			System.out.println(hashtag);
//			
//		}
		
		//검색 입력폼 시  이거 불러오기(
		String keyword = request.getParameter("tag").trim();
		System.out.println(keyword);
		
		
		ArrayList<Hashtag> hashtag = new HashtagService().selectHashtagList(keyword);
		if(!hashtag.isEmpty()) {
			response.setContentType("application/json; charset=UTF-8");
			new Gson().toJson(hashtag, response.getWriter());
			
			
		}
			
			
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
