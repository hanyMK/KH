package com.kh.board.anonymous.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.kh.board.anonymous.model.service.AnonymousService;
import com.kh.board.anonymous.model.vo.SelectAll;
import com.kh.common.model.vo.BoardLikePost;
import com.kh.board.hashtag.model.vo.Hashtag;
import com.kh.common.model.vo.PageInfo;
import com.kh.board.reply.model.vo.Reply;

/**
 * Servlet implementation class AjaxScrollerPageController
 */
@WebServlet("/scroll.an")
public class AjaxScrollerPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxScrollerPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//게시판 게시글 조회
				AnonymousService as = new AnonymousService();
				
				//인코딩
				//request.setCharacterEncoding("UTF-8");
				
				//페이징 처리
				int listCount  = new AnonymousService().selectListCount();
				int currentPage = Integer.parseInt(request.getParameter("cpage"));
				System.out.println("현재"+currentPage);
				
				
				int pageLimit = 10;
				int boardLimit =10;
				
				int maxPage = (int)Math.ceil((double)listCount/pageLimit);
				int startPage = (currentPage-1)/pageLimit * pageLimit+1;
				System.out.println("시작"+startPage);
				int endPage = startPage +pageLimit-1;
				
				if(endPage>maxPage) {
					endPage = maxPage;
				}
				 SelectAll  all= new SelectAll();
				 all.setCpage(currentPage);
				 
			
				PageInfo pi = new PageInfo();
				
				pi.setCurrentPage(currentPage);
				pi.setBoardLimit(boardLimit);
				pi.setEndPage(endPage);
				pi.setMaxPage(maxPage);
				pi.setListCount(listCount);
				pi.setStartPage(startPage);
				pi.setPageLimit(pageLimit);
				
				request.setAttribute("pi", pi);
								
				
//				JSONObject jobj = new JSONObject();
//				jobj.put("currentPage", currentPage);
//				jobj.put("listCount", listCount);
//				jobj.put("pageLimit", pageLimit);
//				jobj.put("boardLimit", boardLimit);
//				jobj.put("maxPage", maxPage);
//				jobj.put("endPage", endPage);
//				
//				response.setContentType("application/json; chsrset=UTF-8");
//				
//				response.getWriter().print(jobj);
				
				
				ArrayList<SelectAll> list = as.selectAllList(pi);
				
			
				
				//---------------------페이징 처리 끝---------------
				if(!list.isEmpty()) {
					
					
					//ArrayList<Hashtag> hList = as.selectHashList();
					//System.out.println(hList);
					
					//투표 는 나중에 해봏자!!!
					//ArrayList<Vote> vList = as.selectVoteList();
					
//					ArrayList<BoardLikePost> bLike = as.selectBoardLike();
//					ArrayList<Reply> rList = as.replyCount();
//					request.setAttribute("replyCount", rList);
					
					
//					request.setAttribute("bLike", bLike);
//					request.setAttribute("hList", hList);
					//request.setAttribute("pi2", pi);
					
					
					//request.getRequestDispatcher("views/board/anonymous/anonymousDetailView.jsp").forward(request, response);
					
					
				
				}
				
				request.setAttribute("all", list);
				System.out.println(list);
				response.setContentType("application/json; charset=UTF-8"); 
				new Gson().toJson(list, response.getWriter());
				
				
				
				
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
