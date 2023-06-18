package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;

/**
 * Servlet implementation class AjaxMyAlarmCheckController
 */
@WebServlet("/myalarmchk.me")
public class MyAlarmCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyAlarmCheckController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		
		String rereplyalarm = request.getParameter("rereplyalarm");
		String replyalarm = request.getParameter("replyalarm");
		
		
		int result1 = 0;
		int result2 = 0;
		//System.out.println(rereplyalarm);
		//System.out.println(replyalarm);
		//System.out.println(replyNo);
		//System.out.println(boardNo);
		
		//라디오버튼을 선택했을때 => 'on' 
		//선택 안했을때 => 'null' -> 히든값도 'null'
		
		//게시글에 댓글 달린것만 선택 시 
		/*null
			on
			0
			null
		 */
		
		if(replyalarm != null && replyalarm.equals("on")) {
			int boardNo = Integer.parseInt(request.getParameter("boardNo"));
			result1 = new MemberService().myAlarmCheckR_1(boardNo);
			if(result1 > 0) {
				session.setAttribute("alertMsg", "알람 확인 처리가 완료 되었습니다.");
			} else {
				session.setAttribute("alertMsg", "알람 확인 처리가 실패 하였습니다.");
				}
		}
		
		if(rereplyalarm != null && rereplyalarm.equals("on")) {
			int replyNo = Integer.parseInt(request.getParameter("replyNo"));
			result2 = new MemberService().myAlarmCheckRr_1(replyNo);
			if(result2 > 0) {
				session.setAttribute("alertMsg", "알람 확인 처리가 완료 되었습니다.");
			} else {
				session.setAttribute("alertMsg", "알람 확인 처리가 실패 하였습니다.");
			}
		}
	
		response.sendRedirect("/nosweat/mypage.me");
		
		// System.out.println("result1 : " + result1 + "result2 : " + result2);
	
	}			

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
