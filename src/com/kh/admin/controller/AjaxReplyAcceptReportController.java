package com.kh.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.model.service.ReportManagerService;

/**
 * Servlet implementation class AjaxAcceptReportController
 */
@WebServlet("/acceptReport.re")
public class AjaxReplyAcceptReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxReplyAcceptReportController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//신고처리 완료 => boardStatus => Y /memberNo를 이용해서 사용자 고수 없데이트?
		int replyNo = Integer.parseInt(request.getParameter("rno"));
		int memberNo =  Integer.parseInt(request.getParameter("mno"));
		
		int result = new ReportManagerService().updateReplyReport(replyNo, memberNo);
		
		//int result2 = new ReportManagerService().updateMemberReport(memberNo);
		if(result >0) {
		//이미 삭제된 게시물을 보여줘야함 삭제된 게시물 가지고 오자
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().print("신고가 처리가 완료되었습니다");
			
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
