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
 * Servlet implementation class AjaxHashtagController
 */
@WebServlet("/hashtag.hs")
public class AjaxSelectHashtagByBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxSelectHashtagByBoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//인코딩
		request.setCharacterEncoding("UTF-8");
	
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		System.out.println(boardNo);
		
		ArrayList<Hashtag> hList = new HashtagService().selectHashtagByBoardNo( boardNo);
		System.out.println(hList);
		
		
		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(hList,response.getWriter());
		
		
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
