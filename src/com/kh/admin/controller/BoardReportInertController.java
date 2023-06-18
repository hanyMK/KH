package com.kh.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.admin.model.service.ReportManagerService;
import com.kh.admin.model.vo.Report;
import com.kh.member.model.vo.Member;


/**
 * Servlet implementation class ReportInertController
 */
@WebServlet("/report.insert")
public class BoardReportInertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardReportInertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		HttpSession session = request.getSession();
		

		//인코딩
		request.setCharacterEncoding("UTF-8");
		//int userNo = Integer.parseInt(request.getParameter("userNo"));
		int attacker = Integer.parseInt(request.getParameter("attacker"));
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String reportReason = request.getParameter("report"); 
		String boardType = request.getParameter("boardType");
		System.out.println("type"+ boardType);
		
		
		Report r = new Report();
		r.setBoardNo(boardNo);
		r.setMemberNo(attacker);
		r.setReportReason(reportReason);
		
		int result = new ReportManagerService().insertReport(r);
		
		if(result>0) {
			
			request.getSession().setAttribute("alertMsg", "신고가 완료 되었습니다");
			
			switch(boardType) {
			case "B" : response.sendRedirect(request.getContextPath()); break;
			case "C" : response.sendRedirect(request.getContextPath() + "/list.by"); break;
			case "D" : response.sendRedirect(request.getContextPath() + "/challengeList.cl?cpage=1"); break;
			case "E" : response.sendRedirect(request.getContextPath() + "/detailView.re?opage=1"); break;
			case "F" : response.sendRedirect(request.getContextPath() + "/handOver.list?hpage=1"); break;
			case "G" : response.sendRedirect(request.getContextPath() + "/offerList.oo?opage=1"); break;
			
			}
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
