package com.kh.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.model.service.ReportManagerService;

/**
 * Servlet implementation class AjaxCancellReportController
 */
@WebServlet("/cancellReport.bo")
public class AjaxBoardCancellReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxBoardCancellReportController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//보드번호를 가지고 게시글 신고 취소하기//DELETE문
		int boardNo = Integer.parseInt(request.getParameter("bno"));
		
		int result = new ReportManagerService().deleteBoardReport(boardNo);
		
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
