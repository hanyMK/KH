package com.kh.board.anonymous.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.anonymous.model.service.AnonymousService;

/**
 * Servlet implementation class AnonymousDeleteController
 */
@WebServlet("/delete.an")
public class AnonymousDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnonymousDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//get방식
		
		int boardNo = Integer.parseInt(request.getParameter("bno"));
		//System.out.println(boardNo);
		
		int result = new AnonymousService().deleteBoard(boardNo);
		
		
		request.getSession().setAttribute("alertMsg", "게시물이 삭제 되었습니다");
		response.sendRedirect(request.getContextPath());
		
		
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
