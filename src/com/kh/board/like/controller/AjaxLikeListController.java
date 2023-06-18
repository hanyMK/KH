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
 * Servlet implementation class AjaxLikeListController
 */
@WebServlet("/selectLike.by")
public class AjaxLikeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxLikeListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		//int memberNo = ((Member)request.getSession().getAttribute("loginUser")).getMemberNo();
	
		
		
		
		ArrayList<Like>  likeCount = new LikeService().selectLike(boardNo);
		
		ArrayList<Like> likeMemberNo = new LikeService().selectMemberNo(boardNo);
		
			
		likeCount.addAll(likeMemberNo);
		
		System.out.println(likeCount);
		// request.setAttribute("likeCount", likeCountResult);
		
		
		
		
		//ArrayList<BodyBoard> listAll = new BodyService().selectDetail(boardNo);
		
		//ArrayList<BoardAttachment> list = new BodyService().detailAttachment(boardNo);
		
		
		
		//request.setAttribute("listAll", listAll);
		//request.setAttribute("list", list);
		
		
		//System.out.println(likeCount);
		
		
		//System.out.println(likeCount);
		//request.getRequestDispatcher("views/board/bodyDetailView.jsp").forward(request, response);
		
		
		response.setContentType("application/json; charset=UTF-8");
		
		new Gson().toJson(likeCount, response.getWriter());
		
		
	
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}














