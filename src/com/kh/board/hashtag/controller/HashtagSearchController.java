package com.kh.board.hashtag.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.board.anonymous.model.service.AnonymousService;
import com.kh.board.anonymous.model.vo.SelectAll;
import com.kh.board.hashtag.model.service.HashtagService;
import com.kh.common.model.vo.PageInfo;

/**
 * Servlet implementation class HashtagSearchController
 */
@WebServlet("/searchTag.hs")
public class HashtagSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HashtagSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩
		request.setCharacterEncoding("UTF-8");
		
		String hashContent = request.getParameter("hashtag");
		
		request.setAttribute("hashContent", hashContent);
		
		
		System.out.println("해시태그 " + hashContent);
		
		
		//게시판 게시글 조회
		AnonymousService as = new AnonymousService();
		
		//페이징 처리
		int listCount  = new HashtagService().selectHashtagListCount(hashContent);
		
		int currentPage = Integer.parseInt(request.getParameter("cpage"));
		System.out.println("패이지" +currentPage);
		
		int pageLimit = 10;
		int boardLimit =10;
		
		int maxPage = (int)Math.ceil((double)listCount/pageLimit);
		int startPage = (currentPage-1)/pageLimit * pageLimit+1;
		int endPage = startPage +pageLimit-1;
		
		if(endPage>maxPage) {
			endPage = maxPage;
		}

		PageInfo pi = new PageInfo();
		
		pi.setCurrentPage(currentPage);
		pi.setBoardLimit(boardLimit);
		pi.setEndPage(endPage);
		pi.setMaxPage(maxPage);
		pi.setListCount(listCount);
		pi.setStartPage(startPage);
		pi.setPageLimit(pageLimit);
		
		request.setAttribute("pi", pi);
		
		ArrayList <SelectAll> tagSerchList = new HashtagService().searchTag(hashContent, pi);
		
		request.setAttribute("tagSerchList", tagSerchList);
		System.out.println("해시태그 검색 결과 "+tagSerchList);
		
		
		
		
			
			//전달
//			response.setContentType("applicateion/json; charset=UTF-8");
//			new Gson().toJson(tagSerchList, response.getWriter());
			//System.out.println(request.getRequestURI());
			
			
			request.getRequestDispatcher("views/common/searchTagView.jsp").forward(request, response);
			

	
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
