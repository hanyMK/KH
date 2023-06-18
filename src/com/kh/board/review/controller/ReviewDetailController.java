package com.kh.board.review.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.offer.model.vo.OfferAttachment;
import com.kh.board.review.model.service.ReviewService;
import com.kh.board.review.model.vo.Review;
import com.kh.common.model.vo.BoardAttachment;

/**
 * Servlet implementation class ReviewDetailViewController
 */
@WebServlet("/detailView.re")
public class ReviewDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	
	
		request.setCharacterEncoding("UTF-8");
		
		int boardNo = Integer.parseInt(request.getParameter("opage"));
		//System.out.println(boardNo);
		
		ReviewService ReviewService = new ReviewService();
		// 조회수 증가
		int result = ReviewService.reviewIncreaseCount(boardNo);
		
		if(result > 0) {
			// select board 게시글 (board) 조회
			Review oB = ReviewService.reviewDetailView(boardNo);
			
			// select board 게시글 (attachthment) 조회)
			ArrayList<BoardAttachment> oAList = ReviewService.reviewAttachmentDetailView(boardNo);
			
			request.setAttribute("oB", oB);
			request.setAttribute("oAList", oAList);
			//System.out.println(oAList.get(1));
		}
		
		
		request.getRequestDispatcher("views/board/review/reviewBoardDetailView.jsp").forward(request, response);
	
	
	
	
	
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}