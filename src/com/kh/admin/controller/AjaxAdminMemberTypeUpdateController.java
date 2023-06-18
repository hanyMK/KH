package com.kh.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.model.service.AdminService;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class AdminMemberTypeUpdateController
 */
@WebServlet("/adminMemTypeUpdate")
public class AjaxAdminMemberTypeUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxAdminMemberTypeUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Member m = new Member();
		
		String memberType = request.getParameter("memberType");
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		
		System.out.println(memberType);
		System.out.println(memberNo);
		
		m.setMemberType(memberType);
		m.setMemberNo(memberNo);
		
		int result = new AdminService().adminMemTypeUpdate_1(m);
		
		if(result > 0) {
			
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().print("S");
			System.out.println("성공!!");
	
		} else {
			response.getWriter().print("F");
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
