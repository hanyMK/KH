package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;

/**
 * Servlet implementation class MemberMessageDeleteController
 */
@WebServlet("/deleteMessage.me")
public class MemberMessageDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberMessageDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int msgNo = Integer.parseInt(request.getParameter("messageNoo"));
		
		HttpSession session = request.getSession();

		if(session.getAttribute("loginUser") == null) {
			session.setAttribute("alertMsg", "로그인 후 이용 가능 합니다.");
			response.sendRedirect(request.getContextPath());
		} else {
			// System.out.println(msgNo);
			
			int result = new MemberService().deleteMessage(msgNo);
			
			if(result > 0) {
				
				request.getSession().setAttribute("alertMsg", "쪽지가 삭제되었습니다.");
				response.sendRedirect(request.getContextPath() + "/message.me?msgpage=1");
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
