package com.kh.board.offer.controller;

import java.io.File;
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
 * Servlet implementation class OfferUpdateController
 */
@WebServlet("/updateOffer.oo")
public class OfferUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OfferUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			int maxSize = 1024 * 1024 * 10;
			
			HttpSession session = request.getSession();
			
			ServletContext application = session.getServletContext();
			
			String savePath = application.getRealPath("/resources/board/offer/offer_thumbnail_upfiles/");
			
			
			MultipartRequest multiRequest
			= new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			int boardNo = Integer.parseInt(multiRequest.getParameter("boardNo"));
			String boardTitle = multiRequest.getParameter("title");
			String boardContent = multiRequest.getParameter("content");
			String category = multiRequest.getParameter("category");
			String closingDate = multiRequest.getParameter("closingDate");
			
			// 수정될 board테이블
			OfferBoard oB = new OfferBoard();
			oB.setBoardNo(boardNo);
			oB.setBoardTitle(boardTitle);
			oB.setBoardContent(boardContent);
			oB.setCategory(category);
			oB.setClosingDate(closingDate);
			//System.out.println(oB + "offer객체");
			
			// 수정될 board attachment 반복문으로 넣어준다
			ArrayList<OfferAttachment> oAList = new ArrayList();
			
			for(int i = 1; i <= 4; i++) {
				
				String reUpFileKey = "reUpfile" + i;
				
				if(multiRequest.getOriginalFileName(reUpFileKey) != null) {
					
					OfferAttachment oA = new OfferAttachment();
					
					oA.setOriginName(multiRequest.getOriginalFileName(reUpFileKey));
					// reUpfile 1 ~ 4 input에 넣어지는 파일의 원본명
					//System.out.println((oA.getOriginName()) + "새롭게 저장될 파일 원본명");
					oA.setChangeName(multiRequest.getFilesystemName(reUpFileKey));
					// reUpfile 1 ~ 4 input에 넣어지는 변경된 파일명
					//System.out.println((oA.getChangeName()) + "새롭게 저장될 파일 변경명 ");
					oA.setFilePath("resources/board/offer/offer_thumbnail_upfiles");
					// reUpfile 1 ~ 4 input에 넣어지는 저장경로
					//oA.setFileNo(Integer.parseInt(multiRequest.getParameter("originFileNo1")));
					//System.out.println((oA.getFileNo()) + "기존에 존재했었던 파일번호");
					//System.out.println(oA + "새로운 저장경로를 받을 oA객체");
					
					if(multiRequest.getParameter("originFileNo" + i) != null) {
						
						oA.setFileNo(Integer.parseInt(multiRequest.getParameter("originFileNo" + i)));
						// 기존에 첨부된 파일이 있었다면 hidden input에 파일번호 값을 빼옴
						//System.out.println((oA.getFileNo()) + "기존에 존재했던 파일번호를 덧씌움");
						//System.out.println(oA + "덧씌워진 파일번호를 가진 oA객체");
						oA.setBoardNo(Integer.parseInt(multiRequest.getParameter("originBoardNo" + i)));
						// 기존에 첨부된 파일이 있었다면 hidden input에 게시글번호값을 빼옴
						//System.out.println(oA + "덧씌워진 게시글번호를 가진 oA객체");
						//oA.setFileLevel(Integer.parseInt(multiRequest.getParameter(reUpFileKey)));
						//System.out.println(oA + "파일레밸 부여받은 oA객체");
						new File(savePath + multiRequest.getParameter("originFileName" + i)).delete();
						
						
						if(i == 1) {
							oA.setFileLevel(0);
						} else {
							oA.setFileLevel(1);
						}
						
						//System.out.println(oA + "파일레밸을 부여받은 oA객체");
					} else {
						
						oA.setBoardNo(boardNo);
						
						//System.out.println((oA.getBoardNo()) + "기존첨부파일없는 첨부파일이 저장될 게시글 번호");
					}
					
					oAList.add(oA);
				}
				
			}
			System.out.println(oAList + "서비스로 넘기기 전 oAList");
			
			int result = new OfferService().updateOfferBoard(oB, oAList);
			
			if(result > 0) {
				request.getSession().setAttribute("alertMsg", "게시글 수정이 성공했어요!");
				response.sendRedirect(request.getContextPath() + "/detail.oo?opage=" + boardNo);
			} else {
				request.setAttribute("errorMsg", "수정 진짜 어렵다");
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
