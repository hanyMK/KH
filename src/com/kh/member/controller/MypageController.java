package com.kh.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Alarm;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MypageController
 */
@WebServlet("/mypage.me")
public class MypageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser") == null) {
			session.setAttribute("alertMsg", "로그인 후 이용 가능 합니다.");
			response.sendRedirect(request.getContextPath());
		} else {
			
			Member m = (Member)session.getAttribute("loginUser");
			int memberNo = m.getMemberNo();
			
			// System.out.println(memberNo);
			
			ArrayList<Alarm> list1 = new MemberService().newAlarmReply_1(m);
			ArrayList<Alarm> list2 = new MemberService().newAlarmRereply_1(m);
			ArrayList<Alarm> blist = new MemberService().myBoardList_1(m);
			ArrayList<Alarm> rlist = new MemberService().myReplyList_1(m);
			ArrayList<Alarm> rrlist = new MemberService().myReReplyList_1(m);
			ArrayList<Alarm> llist = new MemberService().myLikeList_1(m);
			
			session.setAttribute("list1", list1);
			session.setAttribute("list2", list2);
			session.setAttribute("blist", blist);
			session.setAttribute("rlist", rlist);
			session.setAttribute("rrlist", rrlist);
			session.setAttribute("llist", llist);
			
	
			request.getRequestDispatcher("views/member/myPage.jsp").forward(request, response);
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
