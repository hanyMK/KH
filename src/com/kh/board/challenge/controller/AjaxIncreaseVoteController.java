package com.kh.board.challenge.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.challenge.model.service.ChallengeService;

/**
 * Servlet implementation class AjaxIncreaseVoteController
 */
@WebServlet("/increaseVote.cl")
public class AjaxIncreaseVoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxIncreaseVoteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		int voteNo = Integer.parseInt(request.getParameter("voteNo"));
		String voteType = request.getParameter("voteType");
		
		//System.out.println(voteType);
		/* 데이터 가공...
		 * voteNo : 투표테이블
		 * voteType : 투표항목테이블
		 * memberNo : member테이블
		 * 각각 다른 테이블의 값을 들고가기 때문에 가공하지않고 가져감
		 */
		
		int result =new ChallengeService().increaseChallengeVote(memberNo, voteNo, voteType);
		
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().print(result);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
