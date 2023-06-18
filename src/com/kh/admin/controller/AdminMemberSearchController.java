package com.kh.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.admin.model.service.AdminService;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class AdminMemberSearchController
 */
@WebServlet("/adminMemSearch")
public class AdminMemberSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser") == null) {
			session.setAttribute("alertMsg", "로그인 후 이용 가능 합니다.");
			response.sendRedirect(request.getContextPath());
			
		} else {
		
		
		String search = request.getParameter("search");
		String keyword = request.getParameter("Skeyword");
		//System.out.println(search);
		//System.out.println(keyword);
		
		ArrayList<Member> idmemberList = new AdminService().adminMemSearchId_1(keyword); 
		ArrayList<Member> nickmemberList = new AdminService().adminMemSearchnick_1(keyword); 
		ArrayList<Member> reportmemberList = new AdminService().reportmemberList_1(); 
		
		for(Member m : idmemberList) {
			
			switch(m.getMemberType()) {
			
			case "A " : m.setMemberType("일반 회원");
			break;
			case "B " : m.setMemberType("사업자 회원");
			break;
			case "C " : m.setMemberType("정지 회원");
			break;
			case "D " : m.setMemberType("관리자 회원");
			break;		
			}
		}
		
		for(Member m : nickmemberList) {
			
			switch(m.getMemberType()) {
			
			case "A " : m.setMemberType("일반 회원");
			break;
			case "B " : m.setMemberType("사업자 회원");
			break;
			case "C " : m.setMemberType("정지 회원");
			break;
			case "D " : m.setMemberType("관리자 회원");
			break;		
			}
		}
		
		for(Member m : reportmemberList) {
			
			switch(m.getMemberType()) {
			
			case "A " : m.setMemberType("일반 회원");
			break;
			case "B " : m.setMemberType("사업자 회원");
			break;
			case "C " : m.setMemberType("정지 회원");
			break;
			case "D " : m.setMemberType("관리자 회원");
			break;		
			}
		}
		
		
			if(search.equals("report")) {
				
					request.setAttribute("reportmemberList", reportmemberList);
					request.setAttribute("idmemberList", idmemberList);
					request.setAttribute("nickmemberList", nickmemberList);
					request.getRequestDispatcher("views/admin/adminReportMemberList.jsp").forward(request, response);
				
				
			} else {
				
				request.setAttribute("idmemberList", idmemberList);
				request.setAttribute("nickmemberList", nickmemberList);
				request.setAttribute("reportmemberList", reportmemberList);
				request.getRequestDispatcher("views/admin/adminSearchMemberList.jsp").forward(request, response);
				
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
