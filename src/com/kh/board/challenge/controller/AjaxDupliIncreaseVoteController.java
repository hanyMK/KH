package com.kh.board.challenge.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.challenge.model.service.ChallengeService;
import com.kh.board.challenge.model.vo.ChallengeVoteQuery;

/**
 * Servlet implementation class AjaxDupliIncreaseVoteController
 */
@WebServlet("/dupliIncrease.cl")
public class AjaxDupliIncreaseVoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxDupliIncreaseVoteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<ChallengeVoteQuery> queryList = new ArrayList();
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		int voteNo = Integer.parseInt(request.getParameter("voteNo"));
		String voteType = request.getParameter("voteType");
		System.out.println(voteType);
		
		String voteTypes[] = voteType.split(",");
		/*
		System.out.println(voteTypes[0]);
		System.out.println(voteTypes[1]);
		System.out.println(voteTypes[2]);
		*/
		for(int i = 0; i < voteTypes.length; i++) {
			ChallengeVoteQuery cvq = new ChallengeVoteQuery();
			cvq.setVoteType(voteTypes[i]);
			
			queryList.add(cvq);
		}
		
		System.out.println(queryList);
		
		int result = new ChallengeService().dupliIncreaseVote(memberNo, voteNo, queryList);
		
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
