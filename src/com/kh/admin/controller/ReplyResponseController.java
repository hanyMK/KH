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
import com.kh.board.anonymous.model.vo.SelectAll;
import com.kh.board.reply.model.service.ReplyService;
import com.kh.board.reply.model.vo.Reply;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class ReplyResponseController
 */
@WebServlet("/replyReport.response")
public class ReplyResponseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyResponseController() {
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
			int replyNo = Integer.parseInt(request.getParameter("rno"));
			System.out.println(replyNo);
			
			
			ArrayList<SelectAll> a= new ReportManagerService().selectBoard(boardNo);
			
			
				
			Report r = new ReportManagerService().selectReplyReport(replyNo);
			Reply reply =  new ReportManagerService().selectReply(replyNo);
			
			request.setAttribute("reply", reply);
			request.setAttribute("a", a);
			request.setAttribute("r", r);
			
			System.out.println("r ="+ r);
			System.out.println("a=" + a);
			System.out.println("reply"+ reply);
			request.getRequestDispatcher("views/admin/report/replyReportResponseView.jsp").forward(request, response);
			
				
			
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
