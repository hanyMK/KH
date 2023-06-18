package com.kh.board.reply.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.board.reply.model.service.ReplyService;
import com.kh.board.reply.model.vo.Reply;
import com.kh.board.bodyProfileBoard.model.service.BodyService;
import com.kh.board.bodyProfileBoard.model.vo.SelectAll;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class ReplyListController
 */
@WebServlet("/listReply.by")
public class ReplyListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// ajax보낼때 생략해주면 get방식 !!
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
	//	int loginUserMemberNo = ((Member)request.getSession().getAttribute("loginUser")).getMemberNo();
		
		
	
		// 가공할껀 없다
		// 서비스로 가쟈
		// 받아올 댓글들이 많을것 같으므로 ArrayList
		
		ArrayList<Reply> replyList = new ReplyService().selectReplyList(boardNo);	
		
		
		//replyList.add(loginUserMemberNo);
		
		
		//ArrayList<SelectAll> listAll = new BodyService().selectDetail(boardNo);
		// list는 자바의 데이터타입이므로 보내줄 수가 없다
		// GSON을 이용하여 ArrayList를 자바스크립트 객체배열형태로 변환하여 주자
		
		//System.out.println(replyList);
		
		response.setContentType("application/json; charset=UTF-8");
		
		new Gson().toJson(replyList, response.getWriter());
		//new Gson().toJson(listAll, response.getWriter());
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
