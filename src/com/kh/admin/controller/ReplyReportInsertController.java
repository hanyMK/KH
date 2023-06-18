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
 * Servlet implementation class ReplyReportInsertController
 */
@WebServlet("/replyReport.insert")
public class ReplyReportInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyReportInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		

		//post
		
		//리플 번호, 사용자 번호, 보드번호 , 신고이유
		//인코딩
		request.setCharacterEncoding("UTF-8");
		//int userNo = Integer.parseInt(request.getParameter("userNo"));
		int attacker = Integer.parseInt(request.getParameter("attacker"));
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		int replyNo = Integer.parseInt(request.getParameter("replyNo"));
		String boardType = request.getParameter("boardType");
		System.out.println(boardType);
		//System.out.println(attacker +" 가해자, "+ boardNo + "   게시글    "+replyNo+"덧글 번허");
		
		String reportReason = request.getParameter("report"); 
	
		Report r = new Report();
		r.setBoardNo(boardNo);
		r.setMemberNo(attacker);
		r.setReportReason(reportReason);
		r.setReplyNo(replyNo);
		System.out.println("report" + r);
		
		int result = new ReportManagerService().insertReplyReport(r);
		
		
		
request.getSession().setAttribute("alertMsg", "신고가 완료 되었습니다");
response.sendRedirect(request.getContextPath());
			
//			switch(boardType) {
//			case "B" : response.sendRedirect(request.getContextPath() + "/detail.an?bno="+ boardNo); break;
//			case "C" : response.sendRedirect(request.getContextPath() + "/bodyDetail.by?boardNo=" +boardNo); break;
//			case "D" : response.sendRedirect(request.getContextPath() + "/challengedetail.cl?cpage="+ boardNo); break;
//			case "E" : response.sendRedirect(request.getContextPath() + "/reviewList.re?opage=1"); break;
//			case "F" : response.sendRedirect(request.getContextPath() + "/detail.ho?hno="+boardNo); break;
//			case "G" : response.sendRedirect(request.getContextPath() + "/offerList.oo?opage=1"); break;
////			}
		
	
	
	}
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
