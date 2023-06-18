package com.kh.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.common.model.vo.PageInfo;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Alarm;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MyReReplyListController
 */
@WebServlet("/myrereplyList")
public class MyReReplyListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyReReplyListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("loginUser");

		if(session.getAttribute("loginUser") == null) {
			session.setAttribute("alertMsg", "로그인 후 이용 가능 합니다.");
			response.sendRedirect(request.getContextPath());
		} else {

		int memberNo = m.getMemberNo();

		ArrayList<Alarm> rrlist = new MemberService().myReReplyList_1(m);
		
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		int maxPage;
		int startPage;
		int endPage;
		listCount = rrlist.size();
		
		currentPage = Integer.parseInt(request.getParameter("rrcpage"));
		
		pageLimit = 10;
		boardLimit = 15;
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pirr = new PageInfo(listCount , currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		ArrayList<Alarm> myRrList = new MemberService().selectMyReReplyList_1(memberNo, pirr);
		
		session.setAttribute("myRrList", myRrList);
		session.setAttribute("pirr", pirr);
		session.setAttribute("rrlist", rrlist);
		
		request.getRequestDispatcher("views/member/myReReplyList.jsp").forward(request, response);
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
