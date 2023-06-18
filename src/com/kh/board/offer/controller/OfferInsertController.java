package com.kh.board.offer.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.board.offer.model.service.OfferService;
import com.kh.board.offer.model.vo.OfferAttachment;
import com.kh.board.offer.model.vo.OfferBoard;
import com.kh.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class OfferInsertController2
 */
@WebServlet("/insertOffer.oo")
public class OfferInsertController extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OfferInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //System.out.println("??");
      // 인코딩
      request.setCharacterEncoding("UTF-8");
   
      // 파일첨부 경로 지정
      if(ServletFileUpload.isMultipartContent(request)) {
         
         int maxSize = 1024 * 1024 * 10; // 10MBtye
         
         HttpSession session = request.getSession();
         
         ServletContext application = session.getServletContext();
         
         String savePath = application.getRealPath("/resources/board/offer/offer_thumbnail_upfiles/");
         
         //System.out.println(maxSize);
         //System.out.println(savePath);
         
         MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
         
         // 값뽑기 hidden input으로 유저번호 값 받았음
         String memberNo = multiRequest.getParameter("userNo"); // 작성자
         // System.out.println(memberNo);
         String title = multiRequest.getParameter("title"); // 글 제목
         String content = multiRequest.getParameter("content"); // 글 내용
         String category = multiRequest.getParameter("category"); // 말머리
         //System.out.println("??");
         String closingDate = multiRequest.getParameter("closingDate"); // 마감일자
         OfferBoard oB = new OfferBoard();
         oB.setNickName(memberNo);
         oB.setBoardTitle(title);
         oB.setBoardContent(content);
         oB.setCategory(category);
         oB.setClosingDate(closingDate);
         
         
         ArrayList<OfferAttachment> oAList = new ArrayList();
         
         for(int i = 0; i <= 4; i++) {
            
            String key = "file" + i; // 파일번호
            
            if(multiRequest.getOriginalFileName(key) != null) {
               
               OfferAttachment oA = new OfferAttachment();
               oA.setOriginName(multiRequest.getOriginalFileName(key));
               oA.setChangeName(multiRequest.getFilesystemName(key));
               oA.setFilePath("resources/board/offer/offer_thumbnail_upfiles");
               
               
               if(i == 1) {
                  oA.setFileLevel(0);
               } else {
                  oA.setFileLevel(1);
               } // else문
               oAList.add(oA);
            } // if문
         } // for문
         
         int result = new OfferService().insertOffer(oB, oAList);
         //System.out.println("결과 보고까지왔음");
         if(result > 0) {
            request.getSession().setAttribute("alertMsg", "게시글 등록 성공");
            response.sendRedirect(request.getContextPath() + "/offerList.oo?opage=1");
         } else {
            request.setAttribute("errorMsg", "게시글 등록 실패");
            response.sendRedirect(request.getContextPath() + "/offerList.oo?opage=1");
         }
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