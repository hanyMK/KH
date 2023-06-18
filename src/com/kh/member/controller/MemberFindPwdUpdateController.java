package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MemberFindPwdUpdateController
 */
@WebServlet("/pwdFindUpdate.me")
public class MemberFindPwdUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFindPwdUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String userId = request.getParameter("id11");
		String updatePwd1 = request.getParameter("updatePwdMember");
		String chkPwd = request.getParameter("checkPwdMember"); 
		
		
		
		
		Member updateFindPwd = new MemberService().updateFindPwd(userId, updatePwd1, chkPwd);

		if(updateFindPwd != null) {
			session.setAttribute("loginUser", updateFindPwd);
			session.removeAttribute("loginUser");
			response.sendRedirect(request.getContextPath() + "/findPwd.do");
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
