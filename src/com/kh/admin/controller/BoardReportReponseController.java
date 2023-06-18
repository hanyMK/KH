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
import com.kh.board.anonymous.model.service.AnonymousService;
import com.kh.board.anonymous.model.vo.SelectAll;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class BoardReportReponesController
 */
@WebServlet("/boardReport.response")
public class BoardReportReponseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardReportReponseController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		Member admin = (Member)session.getAttribute("loginUser");
		if(admin == null || admin.getMemberNo() > 1) {
			session.setAttribute("alertMsg", "관리자 페이지 입니다. 다시 로그인해 주세요");
			request.getRequestDispatcher("views/common/menubar.jsp").forward(request, response);
			return;
		}
		//신고받은 게시판 정보를 불러야함 게시판이름, 번호, 제목, 작성자, 신고당한 수 등등 디테일 보드 가져오기
		int boardNo = Integer.parseInt(request.getParameter("bno"));
		
		ArrayList<SelectAll> a= new ReportManagerService().selectBoard(boardNo);
		
		if(a != null) {
			
			Report b = new ReportManagerService().selectBoardReport(boardNo);
			request.setAttribute("a", a);
			request.setAttribute("b", b);
			
			// System.out.println("b ="+ b);
			// System.out.println("a=" + a);
			request.getRequestDispatcher("views/admin/report/boardReportResponseView.jsp").forward(request, response);
			
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
