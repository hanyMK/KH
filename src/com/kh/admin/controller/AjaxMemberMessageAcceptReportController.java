package com.kh.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.model.service.ReportManagerService;

/**
 * Servlet implementation class AjaxMemberMessageAcceptReportController
 */
@WebServlet("/acceptMessageReport.ms")
public class AjaxMemberMessageAcceptReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxMemberMessageAcceptReportController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int msgNo = Integer.parseInt(request.getParameter("bno"));
		String nic =  request.getParameter("mno");
		
		int result = new ReportManagerService().updateMessageReport_2(msgNo);

		if(result >0) {
		//이미 삭제된 게시물을 보여줘야함 삭제된 게시물 가지고 오자
			int result1 = new ReportManagerService().updateMemeberReport_2(nic);
			if(result > 0) {
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().print("신고가 처리가 완료되었습니다");
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
