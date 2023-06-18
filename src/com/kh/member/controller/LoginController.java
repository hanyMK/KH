package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login.me")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		//System.out.println(userId + userPwd);
		
		Member loginUser = new MemberService().loginMember_1(userId, userPwd);
		// System.out.println(loginUser);
		HttpSession session  = request.getSession();
		
		
		if(loginUser == null) {
			
			session.setAttribute("alertMsg", "로그인에 실패하였습니다. 아이디와 비밀번호를 다시 확인해주세요.");
			response.sendRedirect("/nosweat/loginForm.do");
			
			
		} else {
			
			session.setAttribute("loginUser", loginUser);
			session.setAttribute("alertMsg", loginUser.getNickname() + " 님, No Sweat에 오신 것을 환영합니다!");
			response.sendRedirect("/nosweat");
			
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