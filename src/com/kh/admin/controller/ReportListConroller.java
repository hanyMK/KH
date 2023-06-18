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
import com.kh.admin.model.vo.Report;
import com.kh.common.model.vo.PageInfo;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class ReportListConroller
 */
@WebServlet("/report.list")
public class ReportListConroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportListConroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		int bPage = Integer.parseInt(request.getParameter("bPage"));
		HttpSession session = request.getSession();
		
		Member admin = (Member)session.getAttribute("loginUser");
		if(admin == null || admin.getMemberNo() > 1) {
			session.setAttribute("alertMsg", "관리자 페이지 입니다. 다시 로그인해 주세요");
			request.getRequestDispatcher("views/common/menubar.jsp").forward(request, response);
			return;
		}
		
		
		
		int pageLimit = 10;
		int boardLimit = 10;
		
		int listCount  = new ReportManagerService().selectListCount();
		int maxPage = (int)Math.ceil((double)listCount/pageLimit);
		int startPage = (bPage -1)/pageLimit* pageLimit+1;
		int endPage = startPage + pageLimit -1;
		
			if(endPage >maxPage){
				endPage = maxPage;
			}
			PageInfo pi= new PageInfo();
			
			
			pi.setCurrentPage(bPage);
			pi.setBoardLimit(boardLimit);
			pi.setEndPage(endPage);
			pi.setMaxPage(maxPage);
			pi.setListCount(listCount);
			pi.setStartPage(startPage);
			pi.setPageLimit(pageLimit);
			
			request.setAttribute("pi", pi);
			
			ArrayList<Report> bList = new ReportManagerService().selectBoardReportList(pi);
			request.setAttribute("list",bList);
			System.out.println(bList);
			
			
			
			request.getRequestDispatcher("views/admin/report/BoardReportView.jsp").forward(request, response);		
		
			
	
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
