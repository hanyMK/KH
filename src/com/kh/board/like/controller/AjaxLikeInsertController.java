package com.kh.board.like.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.board.like.model.service.LikeService;
import com.kh.board.like.model.vo.Like;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class LikeInsertController
 */
@WebServlet("/insertLike.by")
public class AjaxLikeInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxLikeInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		int memberNo = ((Member)request.getSession().getAttribute("loginUser")).getMemberNo();
		//  int likeMemberNo = Integer.parseInt(request.getParameter("likeMemberNo"));
		
	//	System.out.println("memberNo : " + memberNo);
	//	System.out.println("likeMemberNo : " + likeMemberNo);
		
		//ArrayList<Like> likeMemberNo = new LikeService().selectMemberNo(boardNo);
		
		
		//int likeNo = likeMemberNo.get(0).getMemberNo();
		
		
		//for(int i = 0; i <= likeMemberNo.size(); i++) {
			
			
			//System.out.println(likeMemberNo.size());
			
			//if(likeMemberNo.get(i).getMemberNo() != memberNo) {	//좋아요 기록이 없는사람 
				
				
				int insertLikeResult = new LikeService().insertLike(boardNo, memberNo);
				
				//response.setContentType("text/html; charset=UTF-8");
				//response.getWriter().print(insertLikeResult);break;
				
				response.setContentType("application/json; charset=UTF-8");
				
				new Gson().toJson(insertLikeResult, response.getWriter());
				
				
				
				
			}		// 좋아요 기록이 있는 사람
				
				

	
	
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
