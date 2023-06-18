package com.kh.board.handOver.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.handOver.model.service.HandOverService;
import com.kh.board.handOver.model.vo.HandOver;
import com.kh.board.offer.model.service.OfferService;
import com.kh.board.offer.model.vo.OfferAttachment;
import com.kh.board.offer.model.vo.OfferBoard;
import com.kh.common.model.vo.BoardAttachment;

/**
 * Servlet implementation class HandOverDetailController
 */
@WebServlet("/detail.ho")
public class HandOverDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandOverDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		int boardNo = Integer.parseInt(request.getParameter("hno"));
		System.out.println(boardNo);
		
		HandOverService ho = new HandOverService();
		// 조회수 증가
		int result = ho.HandOverIncreaseCount(boardNo);
		
		if(result > 0) {
			// select board 게시글 (board) 조회
			HandOver handover  = ho.selectHandOverBoard(boardNo);
			
			// select board 게시글 (attachthment) 조회)
			ArrayList<BoardAttachment> att = ho.selectHandOverAtt(boardNo);
			
			request.setAttribute("handover", handover);
			request.setAttribute("att", att);
			//System.out.println(oAList.get(1));
		}
		
		
		request.getRequestDispatcher("views/board/handOver/handOverDetailView.jsp").forward(request, response);
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
