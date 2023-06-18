package com.kh.board.review.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.offer.model.service.OfferService;
import com.kh.board.offer.model.vo.OfferAttachment;
import com.kh.board.review.model.service.ReviewService;
import com.kh.board.review.model.vo.Review;

/**
 * Servlet implementation class ReviewDeleteController
 */
@WebServlet("/delete.re")
public class ReviewDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		// get방식
				int boardNo = Integer.parseInt(request.getParameter("boardNo"));
				
				int result = new ReviewService().deleteReviewBoard(boardNo);
				
				if(result > 0) {
					request.getSession().setAttribute("alertMsg", "게시글이 삭제되었습니다");
					response.sendRedirect(request.getContextPath() + "/reviewList.re?opage=1");
				} else {
					request.setAttribute("errorMsg", "게시글삭제 실패");
					response.sendRedirect(request.getContextPath() + "/reviewList.re?opage=1");
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