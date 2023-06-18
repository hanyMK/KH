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
import com.kh.member.model.vo.Alarm;
import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.MyPoint;

/**
 * Servlet implementation class AjaxMainMyInfo2Controller
 */
@WebServlet("/myinfo2")
public class AjaxMainMyInfo2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxMainMyInfo2Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("loginUser");
		int memberNo = m.getMemberNo();
		
		ArrayList<Alarm> blist = new MemberService().myBoardList_1(m);
		ArrayList<Alarm> rlist = new MemberService().myReplyList_1(m);
		ArrayList<Alarm> rrlist = new MemberService().myReReplyList_1(m);
		ArrayList<MyPoint> pointlist = new MemberService().myPoint_1(memberNo);
		
		int myInfo1 = blist.size();
		int myInfo2 = rlist.size() + rrlist.size();
		 
				
		int sum = 0;
		for(MyPoint a : pointlist){
			sum += a.getPoint();
		}
		
		int myInfo3 = sum;
		
		
		JSONObject jObj = new JSONObject();
		jObj.put("myInfo1", myInfo1);
		jObj.put("myInfo2", myInfo2);
		jObj.put("myInfo3", myInfo3);
		
		response.setContentType("application/json; charset=UTF-8");
		
		response.getWriter().print(jObj);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
