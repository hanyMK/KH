package com.kh.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.notice.model.service.BoardService;
import com.kh.notice.model.vo.Board;
import com.kh.notice.model.vo.BoardAttach;
import com.kh.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;
import com.sun.xml.internal.ws.api.message.Attachment;

/**
 * Servlet implementation class NoticeBoardInsertController
 */
@WebServlet("/noticelistinsert")
public class NoticeBoardInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeBoardInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				request.setCharacterEncoding("UTF-8");
				HttpSession session = request.getSession();
				
				
				if(ServletFileUpload.isMultipartContent(request)) {

					int maxSize = 1024 * 1024 * 10;
					String savePath = request.getServletContext().getRealPath("/resources/board_upFiles");
					
					MultipartRequest multiRequest = 
				    new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
					
					String boardTitle = multiRequest.getParameter("title");
					String boardContent = multiRequest.getParameter("content");
					int memberNo = Integer.parseInt(multiRequest.getParameter("userNo"));
					String category = multiRequest.getParameter("category");

					Board b = new Board();
					b.setBoardTitle(boardTitle);
					b.setBoardContent(boardContent);
					b.setMemberNo(memberNo);
					b.setCategory(category);
					
					System.out.println(b);
					
					ArrayList<BoardAttach> nAList = new ArrayList();
		
					for(int i = 0; i <= 4; i++) {
		
						String key = "file" + i;
						if(multiRequest.getOriginalFileName(key) != null) { 
							
							BoardAttach at = new BoardAttach();
							at.setOriginName(multiRequest.getOriginalFileName(key));
							at.setChangeName(multiRequest.getFilesystemName(key));
							at.setFilePath("resources/board_upfiles");
							at.setFileLevel(0);
							
							nAList.add(at);
							
						}
						System.out.println(nAList);
					}
					
					int result = new BoardService().insertNoticeBoard_1(b, nAList);
					
					if(result > 0) { 
						request.getSession().setAttribute("alertMsg", "게시글 작성이 완료 되었습니다.");
						response.sendRedirect("noticeblist?nbpage=1");
					} else {
						request.getSession().setAttribute("alertMsg", "게시글 작성에 실패했습니다. 다시 시도해 주세요.");
						response.sendRedirect("noticeblist?nbpage=1");
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
