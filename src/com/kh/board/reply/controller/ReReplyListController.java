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
import com.kh.board.reply.model.vo.ReReply;

/**
 * Servlet implementation class ReReplyListController
 */
@WebServlet("/selectReReply.by")
public class ReReplyListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReReplyListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		
		int replyNo = Integer.parseInt(request.getParameter("replyNo"));
		
		
		System.out.println("반복돌린replyNo : " + replyNo);
		
		
		
		//if(replyNo)
		
		
		
		
		
		ArrayList<ReReply> rereplyList = new ReplyService().selectReReply(replyNo);
	
		
		response.setContentType("application/json; charset=UTF-8");
		
		new Gson().toJson(rereplyList, response.getWriter());
		
		System.out.println(rereplyList);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
