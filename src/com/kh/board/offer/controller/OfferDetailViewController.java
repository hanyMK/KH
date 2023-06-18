package com.kh.board.offer.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.offer.model.service.OfferService;
import com.kh.board.offer.model.vo.OfferAttachment;
import com.kh.board.offer.model.vo.OfferBoard;

/**
 * Servlet implementation class OfferDetailViewController
 */
@WebServlet("/detail.oo")
public class OfferDetailViewController extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OfferDetailViewController() {
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
      
      OfferService offerService = new OfferService();
      // 조회수 증가
      int result = offerService.offerIncreaseCount(boardNo);
      
      if(result > 0) {
         // select board 게시글 (board) 조회
         OfferBoard oB = offerService.offerDetailView(boardNo);
         
         // select board 게시글 (attachthment) 조회)
         ArrayList<OfferAttachment> oAList = offerService.offerAttachmentDetailView(boardNo);
         
         request.setAttribute("oB", oB);
         request.setAttribute("oAList", oAList);
         //System.out.println(oAList.get(1));
      }
      
      
      request.getRequestDispatcher("views/board/offer/offerBoardDetailview.jsp").forward(request, response);
   
   
   
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}