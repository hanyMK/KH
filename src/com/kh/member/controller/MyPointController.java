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
import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.MyPoint;

/**
 * Servlet implementation class MyPointController
 */
@WebServlet("/mypoint.me")
public class MyPointController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPointController() {
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
			ArrayList<MyPoint> pointList = new MemberService().myPoint_1(memberNo);
			
			int listCount;
			int currentPage;
			int pageLimit;
			int boardLimit;
			int maxPage;
			int startPage;
			int endPage;
			listCount = pointList.size();
			
			currentPage = Integer.parseInt(request.getParameter("pcpage"));
			
			pageLimit = 10;
			boardLimit = 15;
			maxPage = (int)Math.ceil((double)listCount / boardLimit);
			startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
			endPage = startPage + pageLimit - 1;
			
			if(endPage > maxPage) {
				endPage = maxPage;
			}
			
			PageInfo pip = new PageInfo(listCount , currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
			
			ArrayList<MyPoint> pgPointList = new MemberService().selectMyPoint_1(memberNo, pip);
			
			session.setAttribute("pgPointList", pgPointList);
			session.setAttribute("pip", pip);
			session.setAttribute("pointList", pointList);
			
			request.getRequestDispatcher("views/member/myPoint.jsp").forward(request, response);
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
