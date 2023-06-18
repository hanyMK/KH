package com.kh.board.reply.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.reply.model.service.ReplyService;
import com.kh.board.reply.model.vo.ReReply;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class ReReplyInsertController
 */
@WebServlet("/insertReReply.by")
public class ReReplyInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReReplyInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		// POST방식 이니 인코딩작업!!
		request.setCharacterEncoding("UTF-8");
		
		// 대댓글 INSERT할때필요한 해당 게시물번호, 댓글번호, 사용자번호(session) 을 값을 뽑는
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		int replyNo = Integer.parseInt(request.getParameter("replyNo"));
		String rereplyContent = request.getParameter("rereplyContent");
		int memberNo = ((Member)request.getSession().getAttribute("loginUser")).getMemberNo();
		
		// VO객체로 가공
		ReReply rere = new ReReply();
		rere.setMemberNo(memberNo);
		rere.setReplyNo(replyNo);
		rere.setReReplyContent(rereplyContent);
		
		
		System.out.println("rereply 2222" + rere);
		
		int rereplyResult = new ReplyService().rereplyInsert(rere);
		
	
	
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().print(rereplyResult);
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
