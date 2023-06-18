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
import com.kh.member.model.vo.MemberQnA;

/**
 * Servlet implementation class MemberNoticeController
 */
@WebServlet("/qna.me")
public class MemberQnAController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberQnAController() {
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
		
			int listCount;
			int currentPage;
			int pageLimit;
			int boardLimit;
			
			int maxPage;
			int startPage;
			int endPage;
			
			int userNo = ((Member)session.getAttribute("loginUser")).getMemberNo();
	
			currentPage = Integer.parseInt(request.getParameter("cpage"));		
			pageLimit = 10;
			boardLimit = 10;
			startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
			
			
	
			ArrayList list = new ArrayList();
			PageInfo pi = new PageInfo();
			
			if(userNo == 1) {
				listCount = new MemberService().selectQnACount_A();
				maxPage = (int)Math.ceil((double)listCount/boardLimit);
				endPage = startPage + pageLimit - 1;
				if(endPage > maxPage) {
					endPage = maxPage;
				}
				
				pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);			
				list = new MemberService().selectQnAList_A(pi, userNo);
				
			} else {
				listCount = new MemberService().selectQnACount(userNo);
				maxPage = (int)Math.ceil((double)listCount/boardLimit);
				endPage = startPage + pageLimit - 1;
				if(endPage > maxPage) {
					endPage = maxPage;
				}
				
				pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);		
				list = new MemberService().selectQnAList(pi, userNo);
				
			}
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			
					
			request.getRequestDispatcher("views/member/memberQnA.jsp").forward(request, response);
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
