package com.kh.board.reply.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.model.service.ReportManagerService;
import com.kh.board.reply.model.service.ReplyService;
import com.kh.board.reply.model.vo.Reply;

/**
 * Servlet implementation class AjaxReplyDeleteController
 */
@WebServlet("/deleteReply.cl")
public class AjaxReplyDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxReplyDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		int boardNo = Integer.parseInt(request.getParameter("cno"));
		int replyNo = Integer.parseInt(request.getParameter("replyNo"));
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		System.out.println(boardNo + "게시글번호");
		System.out.println(replyNo + "댓글번호");
		System.out.println(memberNo + "유저번호");
		Reply r = new Reply();
		r.setBoardNo(boardNo);
		r.setReplyNo(replyNo);
		r.setMemberNo(memberNo);
		
		int result = new ReplyService().deleteReply(r);
		int result2 =  new ReportManagerService().deleteReplyReport(replyNo);
		
		
		
		response.setContentType("text/html charset=UTF-8"); 
		response.getWriter().print((result*result2));
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
