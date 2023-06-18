package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.MemberMessage;

/**
 * Servlet implementation class MemberMessageAnswerController
 */
@WebServlet("/messageAnswer.do")
public class MemberMessageAnswerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberMessageAnswerController() {
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
			String nicName = request.getParameter("msgSand");
			String nicSandName = request.getParameter("msgSendAnswer");
			String msgTitle = request.getParameter("msgTitle");
			String msgContent = request.getParameter("magContent");
			
			
			MemberMessage msg = new MemberMessage();
				msg.setFromNic(nicName);
				msg.setToNic(nicSandName);
				msg.setMessageTitle(msgTitle);
				msg.setMessageContent(msgContent);
				
				int result = new MemberService().insertMessage(msg);
				
				if(result > 0) {
					request.getSession().setAttribute("alertMsg", "쪽지 전송에 성공했습니다.");
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
