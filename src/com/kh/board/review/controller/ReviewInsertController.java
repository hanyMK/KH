package com.kh.board.review.controller;

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

import com.kh.board.hashtag.model.service.HashtagService;
import com.kh.board.hashtag.model.vo.Hashtag;
import com.kh.board.review.model.service.ReviewService;
import com.kh.board.review.model.vo.Review;
import com.kh.common.MyFileRenamePolicy;
import com.kh.common.model.vo.BoardAttachment;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class ReviewInsertController
 */
@WebServlet("/insertReview.re")
public class ReviewInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩
				request.setCharacterEncoding("UTF-8");
			
				// 파일첨부 경로 지정
				if(ServletFileUpload.isMultipartContent(request)) {
					
					int maxSize = 1024 * 1024 * 10; // 10MBtye
					
					HttpSession session = request.getSession();
					
					ServletContext application = session.getServletContext();
					
					String savePath = application.getRealPath("/resources/thumbnail_upFiles/");
					
					//System.out.println(maxSize);
					//System.out.println(savePath);
					
					MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
					
					// 값뽑기 hidden input으로 유저번호 값 받았음
					int memberNo = Integer.parseInt(multiRequest.getParameter("userNo")); // 작성자
					 System.out.println(memberNo);
					String title = multiRequest.getParameter("title"); // 글 제목
					String content = multiRequest.getParameter("content"); // 글 내용
					String category = multiRequest.getParameter("category"); // 말머리
					System.out.println("?");
					String closingDate = multiRequest.getParameter("closingDate"); // 마감일자
					Review oB = new Review();
					oB.setMemberNo(memberNo);
					oB.setBoardTitle(title);
					oB.setBoardContent(content);
					oB.setCategory(category);
					oB.setClosingDate(closingDate);
					
					System.out.println("서비스 넘기기 전ㄴㄴㄴㄴㄴㄴㄴ");
					
					
					ArrayList<BoardAttachment> oAList = new ArrayList();
					
					for(int i = 0; i <= 4; i++) {
						
						String key = "file" + i; // 파일번호
						
						if(multiRequest.getOriginalFileName(key) != null) {
							
							BoardAttachment oA = new BoardAttachment();
							oA.setOriginName(multiRequest.getOriginalFileName(key));
							oA.setChangeName(multiRequest.getFilesystemName(key));
							oA.setFilePath("resources/thumbnail_upFiles");
							
							
							if(i == 1) {
								oA.setFileLevel(0);
							} else {
								oA.setFileLevel(1);
							} // else문
							oAList.add(oA);
						} // if문
					} // for문
					
					int result = new ReviewService().insertReview(oB, oAList);
					
					String tagState = multiRequest.getParameter("tagState");
					

					int hastagResult = 1;
		//------------해시태그가 존재한다면 insert-----------------------
					
					if(tagState.equals("yes")) {
						String[] hashtag = multiRequest.getParameterValues("hashT");
						ArrayList <Hashtag> hList = new HashtagService().selectHashtag();
						
						
						int count = 1;
						for(int i = 0; i< hashtag.length; i++) {
							for(int j = 0; j <hList.size(); j++ ) {
								if((hList.get(j).getHashtag()).equals(hashtag[i])){
									//							System.out.println(hList.get(j).getHashtag());
									//							System.out.println(hashtag[i]);
									count *= 0;
									//							System.out.println(count);
								}
							}
							if(count > 0) {
								//						System.out.println(hashtag[i]);
								new HashtagService().insertHashtag(hashtag[i]);
								count = 1;
							}
						}
						
						int boardNo = new HashtagService().selectLastBoardNo();
						if(boardNo != 0 ) {
							hastagResult = new HashtagService().insertBoardHashtag(boardNo, hashtag); 
							
						}
						//System.out.println(result + " 투표가 없는 결과 result");
						if(result > 0) { // insert 결과 화면
							request.getSession().setAttribute("alertMsg", "게시글 등록 성공");
							response.sendRedirect(request.getContextPath() + "reviewList.re?page=1");
						} else {
							request.setAttribute("errorMsg", "게시글 등록 실패");
							response.sendRedirect(request.getContextPath() + "reviewList.re?page=1");
						}
						
						
					}else {
						
			            //System.out.println(result + " 투표가 없는 결과 result");
			            if(result > 0) { // insert 결과 화면
			               request.getSession().setAttribute("alertMsg", "게시글 등록 성공");
			               response.sendRedirect(request.getContextPath() + "reviewList.re?page=1");
			            } else {
			               request.setAttribute("errorMsg", "게시글 등록 실패");
			               response.sendRedirect(request.getContextPath() + "reviewList.re?page=1");
			            }
			           
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
