package com.kh.board.hashtag.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.hashtag.model.service.HashtagService;
import com.kh.board.hashtag.model.vo.Hashtag;

/**
 * Servlet implementation class AjaxHasatagInsertController
 */
@WebServlet("/realTime.insertTag")
public class AjaxHasatagInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxHasatagInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//보드번호와 tagValue를 받아서 insert
		
		String[] hashtag = request.getParameterValues("tagValue");
		int boardNo = Integer.parseInt( request.getParameter("boardNo"));
		
		//해시태그 불러오기
		ArrayList <Hashtag> hList = new HashtagService().selectHashtag();
		
		//값비교
		int count = 1;
		for(int i = 0; i< hashtag.length; i++) {
			for(int j = 0; j <hList.size(); j++ ) {
				if((hList.get(j).getHashtag()).equals(hashtag[i])){
					//							System.out.println(hList.get(j).getHashtag());
					//							System.out.println(hashtag[i]);
					count *= 0;
					//							System.out.println(count);
				}
			}
			if(count > 0) {
				//						System.out.println(hashtag[i]);
				new HashtagService().insertHashtag(hashtag[i]);
				count = 1;
			}
		}
		int result = new HashtagService().insertBoardHashtag(boardNo, hashtag);
		if(result>0) {
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().println("해시태그 수정 insert 성공!");
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
