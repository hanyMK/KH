package com.kh.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.admin.model.service.ReportManagerService;
import com.kh.admin.model.vo.MessageReport;
import com.kh.common.model.vo.PageInfo;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MemberMessageListController
 */
@WebServlet("/messageReport.list")
public class MemberMessageListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberMessageListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		
		int maxPage;
		int startPage;
		int endPage;
		
		if((Member)session.getAttribute("loginUser") == null || ((Member)session.getAttribute("loginUser")).getMemberNo() != 1 ) {
			session.setAttribute("alertMsg", "접근권한이 없습니다.");
			request.getRequestDispatcher("views/common/menubar.jsp").forward(request, response);
			return;
		} else if(((Member)session.getAttribute("loginUser")).getMemberNo() == 1) {
			currentPage = Integer.parseInt(request.getParameter("mPage"));		
			pageLimit = 10;
			boardLimit = 10;
			startPage = (currentPage - 1) / pageLimit * pageLimit + 1;		
			
			ArrayList list = new ArrayList();
			PageInfo pi = new PageInfo();
			listCount = new ReportManagerService().selectMsgListCount();
			maxPage = (int)Math.ceil((double)listCount/boardLimit);
			endPage = startPage + pageLimit - 1;
			
			if(endPage > maxPage) {
				endPage = maxPage;
			}
			
			
			pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);			
			list = new ReportManagerService().selectMsgList(pi);
			
			request.setAttribute("pi", pi);
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("views/admin/report/messageReportView.jsp").forward(request, response);
		}
			// System.out.println("pi");
			// System.out.println("list");

		
				
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
