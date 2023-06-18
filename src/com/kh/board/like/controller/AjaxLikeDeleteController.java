package com.kh.board.like.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.like.model.service.LikeService;
import com.kh.board.like.model.vo.Like;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class AjaxLikeDeleteController
 */
@WebServlet("/deleteLike.by")
public class AjaxLikeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxLikeDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		int memberNo = ((Member)request.getSession().getAttribute("loginUser")).getMemberNo();
		
		//ArrayList<Like> list = new LikeService().selectMemberNo(boardNo);
		
		
		int deleteResult = new LikeService().deleteLike(boardNo, memberNo);
		
		
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().print(deleteResult);
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
