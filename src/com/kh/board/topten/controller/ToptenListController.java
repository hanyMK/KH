package com.kh.board.topten.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.offer.model.service.OfferService;
import com.kh.board.topten.model.service.TopTenService;
import com.kh.board.topten.model.vo.SelectAll;
import com.kh.common.model.vo.PageInfo;

/**
 * Servlet implementation class ToptenListController
 */
@WebServlet("/toptenList.li")
public class ToptenListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToptenListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


				ArrayList<SelectAll> list = new TopTenService().selectTopTenList();
			
				request.setAttribute("list", list);

				request.getRequestDispatcher("views/board/topTen/topTenList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
