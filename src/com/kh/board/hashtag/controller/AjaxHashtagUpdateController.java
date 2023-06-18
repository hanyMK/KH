package com.kh.board.hashtag.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.hashtag.model.service.HashtagService;

/**
 * Servlet implementation class AjaxHashtagUpdateController
 */
@WebServlet("/update.hashtag")
public class AjaxHashtagUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxHashtagUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			//받아온 해시태그와 보드번호를 가지고 해시태그를 실시간으로 삭제한다
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String target = request.getParameter("target");
		System.out.println("target"+ target);
		System.out.println(boardNo);
		
		//그냥 전달
		int result = new HashtagService().deleteHashtagForUpdate(boardNo, target);
		System.out.println(result);
		
		if(result >0) {
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print("해시태그 삭제성공");
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
