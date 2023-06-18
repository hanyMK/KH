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
 * Servlet implementation class InfoUpdateController
 */
@WebServlet("/updateNick.me")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateController() {
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

			int userNo = ((Member)session.getAttribute("loginUser")).getMemberNo();
			String userId = ((Member)session.getAttribute("loginUser")).getMemberId();
			String userPwd = ((Member)session.getAttribute("loginUser")).getMemberPwd();
			String nickName = request.getParameter("nicknameCheck");
			
			Member m = new Member();
			m.setMemberNo(userNo);
			m.setMemberId(userId);
			m.setMemberPwd(userPwd);
			m.setNickname(nickName);
	
			Member updateMem = new MemberService().updateMember_2(m);
			
			if(updateMem != null) {
				
				session.setAttribute("loginUser", updateMem);
				response.sendRedirect(request.getContextPath() + "/update.me");
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
