package com.kh.board.reply.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.reply.model.service.ReplyService;
import com.kh.board.reply.model.vo.Reply;
import com.kh.board.bodyProfileBoard.model.service.BodyService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class ReplyInsertController
 */
@WebServlet("/replyInsert.by")
public class ReplyInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		// post방식 이므로 인코딩 작업
		request.setCharacterEncoding("UTF-8");
		
		// 넘겨준 값을 뽑아오자
		// 댓글 기능 넘겨받아야할 것 : 게시글 번호, 댓글내용, 회원아이디
		
		//System.out.println("dddd");
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String replyContent = request.getParameter("replyContent");
		int memberNo = ((Member)request.getSession().getAttribute("loginUser")).getMemberNo();
		
		
		
		
		// VO로 가공해준다
		Reply r = new Reply();
		
		r.setBoardNo(boardNo);
		r.setReplyContent(replyContent);
		r.setMemberNo(memberNo);
		
		System.out.println("댓글등록버튼을 누르면 들어오는 게시글번호 : " + r);
				
		int result = new ReplyService().insertReply(r);
		
		// Gson, Json 으로 넘겨야 할 값이 여러개일때 사용하자!!
		
		// 값이 0 인지 1인지 확인해주면 된다.
		
		// 넘겨야 할 값이 result뿐이므로 그냥 넘겨준다
		
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
