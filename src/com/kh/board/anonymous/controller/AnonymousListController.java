package com.kh.board.anonymous.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.anonymous.model.service.AnonymousService;
import com.kh.board.anonymous.model.vo.Anonymous;
import com.kh.board.anonymous.model.vo.SelectAll;
import com.kh.common.model.vo.BoardLikePost;
import com.kh.board.hashtag.model.vo.Hashtag;
import com.kh.common.model.vo.PageInfo;
import com.kh.board.reply.model.vo.Reply;

/**
 * Servlet implementation class AnonymousListController
 */
@WebServlet("/list.an")
public class AnonymousListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnonymousListController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
//		//게시판 게시글 조회
//		AnonymousService as = new AnonymousService();
//		
//		//페이징 처리
//		int listCount  = new AnonymousService().selectListCount();
//		
//		int currentPage = Integer.parseInt(request.getParameter("cpage"));
//		
//		int pageLimit = 10;
//		int boardLimit =10;
//		
//		int maxPage = (int)Math.ceil((double)listCount/pageLimit);
//		int startPage = (currentPage-1)/pageLimit * pageLimit+1;
//		int endPage = startPage +pageLimit-1;
//		
//		if(endPage>maxPage) {
//			endPage = maxPage;
//		}
//
//		PageInfo pi = new PageInfo();
//		
//		pi.setCurrentPage(currentPage);
//		pi.setBoardLimit(boardLimit);
//		pi.setEndPage(endPage);
//		pi.setMaxPage(maxPage);
//		pi.setListCount(listCount);
//		pi.setStartPage(startPage);
//		pi.setPageLimit(pageLimit);
//		
//		request.getSession().setAttribute("pi", pi);
//		
//		ArrayList<SelectAll> list = as.selectAllList(pi);
//		
//		
//		
//		//---------------익명 게시판 리스트
//		
//		
//		if(!list.isEmpty()) {
//			
//			
//			
//			ArrayList<Hashtag> hList = as.selectHashList();
//			//System.out.println(hList);
//			
//			//투표 는 나중에 해봏자!!!
//			//ArrayList<Vote> vList = as.selectVoteList();
//			
//			ArrayList<BoardLikePost> bLike = as.selectBoardLike();
//			ArrayList<Reply> rList = as.replyCount();
//			request.setAttribute("replyCount", rList);
//			
//			
//			request.setAttribute("bLike", bLike);
//			request.setAttribute("hList", hList);
//			request.getSession().setAttribute("list", list);
//			request.setAttribute("pi", pi);
					
			request.getRequestDispatcher("views/board/anonymous/anonymousListView.jsp").forward(request, response);
			
			
		
		
		
		//}
	}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
