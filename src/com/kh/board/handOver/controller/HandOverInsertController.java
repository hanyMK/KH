package com.kh.board.handOver.controller;

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

import com.kh.board.handOver.model.service.HandOverService;
import com.kh.board.handOver.model.vo.HandOver;
import com.kh.board.hashtag.model.service.HashtagService;
import com.kh.board.hashtag.model.vo.Hashtag;
import com.kh.common.MyFileRenamePolicy;
import com.kh.common.model.vo.BoardAttachment;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class HandOverInsertController
 */
@WebServlet("/handover.insert")
public class HandOverInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandOverInsertController() {
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
			
			String savePath = application.getRealPath("/resources/board_upFiles/");
			
			//System.out.println(maxSize);
			//System.out.println(savePath);
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			// 값뽑기 hidden input으로 유저번호 값 받았음
			int memberNo = Integer.parseInt(multiRequest.getParameter("userNo")); // 작성자
			// System.out.println(memberNo);
			String title = multiRequest.getParameter("title"); // 글 제목
			String content = multiRequest.getParameter("content"); // 글 내용
			String category = multiRequest.getParameter("category"); // 말머리
			//System.out.println("??");
			HandOver ho = new HandOver();
			ho.setMemberNo(memberNo);
			ho.setBoardTitle(title);
			ho.setBoardContent(content);
			ho.setCategory(category);
			
			
			ArrayList<BoardAttachment> attList = new ArrayList();
			
			for(int i = 0; i <= 4; i++) {
				
				String key = "file" + i; // 파일번호
				
				if(multiRequest.getOriginalFileName(key) != null) {
					
					BoardAttachment att = new BoardAttachment();
					att.setOriginName(multiRequest.getOriginalFileName(key));
					att.setChangeName(multiRequest.getFilesystemName(key));
					att.setFilePath("resources/board_upFiles");
					
					
					if(i == 1) {
						att.setFileLevel(0);
					} else {
						att.setFileLevel(1);
					} // else문
					attList.add(att);
				} // if문
			} // for문
			
			int result1 = new HandOverService().insertHandOver(ho, attList);
			
			
			
			
			//해시태그 존재 유무판단
			String tagState = multiRequest.getParameter("tagState");
			
			
//------------해시태그가 존재한다면 insert-----------------------
			
			int result2 = 1;
			if(tagState.equals("yes")) {
				String[] hashtag = multiRequest.getParameterValues("hashT");
				ArrayList <Hashtag> hList =  new HashtagService().selectHashtag();
				
				
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
					result2 = new HashtagService().insertBoardHashtag(boardNo, hashtag); 
					
				}
			
			
			
			//System.out.println("결과 보고까지왔음");
			if(result1*result2 > 0) {
				request.getSession().setAttribute("alertMsg", "게시글 등록 성공");
				response.sendRedirect(request.getContextPath() + "/handOver.list?hpage=1");
			} else {
				request.setAttribute("errorMsg", "게시글 등록 실패");
				response.sendRedirect(request.getContextPath() + "/handOver.list?hpage=1");
			}
		}else {
			
			if(result1*result2 > 0) {
				request.getSession().setAttribute("alertMsg", "게시글 등록 성공");
				response.sendRedirect(request.getContextPath() + "/handOver.list?hpage=1");
			} else {
				request.setAttribute("errorMsg", "게시글 등록 실패");
				response.sendRedirect(request.getContextPath() + "/handOver.list?hpage=1");
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
