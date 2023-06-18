package com.kh.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notice.model.service.BoardService;
import com.kh.notice.model.vo.Board;
import com.kh.notice.model.vo.BoardAttach;

/**
 * Servlet implementation class NoticeBoardDetailController
 */
@WebServlet("/detail.noticeList")
public class NoticeBoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeBoardDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		int boardNo = Integer.parseInt(request.getParameter("bno"));

		BoardService bService = new BoardService();
	
		int result = bService.increaseCount_1(boardNo);
		
		if(result > 0) {
			
			Board nb = bService.selectBoard_1(boardNo);
			
			ArrayList<BoardAttach> nAList = bService.selectAttachment_1(boardNo);
			
			request.setAttribute("nb",nb);
			request.setAttribute("nAList", nAList);

			request.getRequestDispatcher("views/notice/noticeBoardDetail.jsp").forward(request, response);
			
		} else {
			request.setAttribute("errorMsg", "게시글 조회가 실패하였습니다. 다시 시도해주세요.");
			response.sendRedirect("contextPath/noticeblist?nbpage=1");
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
