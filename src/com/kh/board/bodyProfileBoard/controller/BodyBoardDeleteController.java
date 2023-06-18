package com.kh.board.bodyProfileBoard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.bodyProfileBoard.model.service.BodyService;

/**
 * Servlet implementation class BodyBoardDeleteController
 */
@WebServlet("/bodyDelete.by")
public class BodyBoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BodyBoardDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		// get방식
				int boardNo = Integer.parseInt(request.getParameter("boardNo"));
						
				int result = new BodyService().deleteBoard(boardNo);
						
				if(result > 0) {
					request.getSession().setAttribute("alertMsg", "게시글이 삭제되었습니다");
					response.sendRedirect(request.getContextPath() + "/list.by");
				} else {
					request.setAttribute("errorMsg", "게시글삭제 실패");
					response.sendRedirect(request.getContextPath() + "/list.by");
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
