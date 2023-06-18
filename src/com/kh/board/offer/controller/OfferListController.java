package com.kh.board.offer.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.offer.model.service.OfferService;
import com.kh.board.offer.model.vo.OfferBoard;
import com.kh.common.model.vo.PageInfo;

/**
 * Servlet implementation class OfferListController
 */
@WebServlet("/offerList.oo")
public class OfferListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OfferListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// -- 페이징 처리 --
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		
		int maxPage;
		int startPage;
		int endPage;
		
		listCount = new OfferService().selectListCount(); // 조회된 게시글의 개수
		
		currentPage = Integer.parseInt(request.getParameter("opage"));
		
		pageLimit = 10;
		
		boardLimit = 15; // 조회될 게시글 갯수
		
		maxPage = (int)Math.ceil((double)listCount/boardLimit);
		
		startPage = (currentPage -1)/pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		// Service단으로 SELECT요청
		
		ArrayList<OfferBoard> list = new OfferService().selectOfferList(pi);
		//ArrayList<OfferBoard> list = new OfferService().selectOfferList();
		
		// 응답 결과 화면
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		
		request.getRequestDispatcher("views/board/offer/offerBoardList.jsp").forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
