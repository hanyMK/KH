package com.kh.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.AttendanceCheck;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class AjaxAttendanceCountController
 */
@WebServlet("/attcheckcount.me")
public class AjaxAttendanceCountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxAttendanceCountController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser") == null) {
			session.setAttribute("alertMsg", "로그인 후 이용 가능 합니다.");
			response.sendRedirect(request.getContextPath());
		} else {
			
			Member m = (Member)session.getAttribute("loginUser");
			int memberNo = m.getMemberNo();
			ArrayList<AttendanceCheck> attList = new MemberService().attCheck_1(memberNo);
			int count = attList.size();
			int todaychk = new MemberService().todayAttcheckchk_1(memberNo);	
			
			JSONObject jObj = new JSONObject();
			jObj.put("count", count);
			jObj.put("todaychk", todaychk);
			
			response.setContentType("application/json; charset=UTF-8");
			
			response.getWriter().print(jObj);
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
