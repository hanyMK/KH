package com.kh.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.model.service.ReportManagerService;
import com.kh.admin.model.vo.MessageReport;
import com.kh.admin.model.vo.Report;

/**
 * Servlet implementation class MemberMessageInsertController
 */
@WebServlet("/msgInsert.me")
public class MemberMessageInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /** 
     * @see HttpServlet#HttpServlet()
     */
    public MemberMessageInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int msgNo = Integer.parseInt(request.getParameter("msgNo"));
		String attacker = request.getParameter("attacker");
		String reportContent = request.getParameter("report"); 
		
		MessageReport mr = new MessageReport();
		mr.setMessageNo(msgNo);
		mr.setMemberNo(attacker);
		mr.setMessageReason(reportContent);

		int updateMsg = new ReportManagerService().updateMessageReport(msgNo);
		
		if(updateMsg > 0) {
			
			int result = new ReportManagerService().insertMessageReport(mr);
			// request.getRequestDispatcher("views/member/memberMessageEnrollForm.jsp").forward(request, response);
			if(result > 0) {
				request.getSession().setAttribute("alertMsg", "신고가 완료 되었습니다");
				response.sendRedirect(request.getContextPath() + "/message.me?msgpage=1");
				System.out.println(result);
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
