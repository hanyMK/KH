package com.kh.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.admin.model.service.ReportManagerService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class AjaxCancellReportController
 */
@WebServlet("/cancellReport.re")
public class AjaxReplyCancellReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxReplyCancellReportController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//보드번호를 가지고 게시글 신고 취소하기//DELETE문
		int replyNo = Integer.parseInt(request.getParameter("rno"));
		
		int result = new ReportManagerService().deleteReplyReport(replyNo);
		
		if(result>0) {
			
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().print("신고가 처리가 취소되었습니다");
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
