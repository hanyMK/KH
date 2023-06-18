package com.kh.board.challenge.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.challenge.model.service.ChallengeService;

/**
 * Servlet implementation class ChallengeDeleteController
 */
@WebServlet("/challengeDelete.cl")
public class ChallengeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChallengeDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// get방식
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
				
		int result = new ChallengeService().deleteChallengeBoard(boardNo);
				
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "게시글이 삭제되었습니다");
			response.sendRedirect(request.getContextPath() + "/challengeList.cl?cpage=1");
		} else {
			request.setAttribute("errorMsg", "게시글삭제 실패");
			response.sendRedirect(request.getContextPath() + "/challengeList.cl?cpage=1");
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
