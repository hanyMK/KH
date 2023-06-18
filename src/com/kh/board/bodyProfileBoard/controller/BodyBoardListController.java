package  com.kh.board.bodyProfileBoard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.bodyProfileBoard.model.service.BodyService;
import com.kh.board.bodyProfileBoard.model.vo.BodyBoard;
import com.kh.board.like.model.service.LikeService;
import com.kh.board.like.model.vo.Like;

/**
 * Servlet implementation class BodyBoardController
 */
@WebServlet("/list.by")
public class BodyBoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BodyBoardListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		
		ArrayList<BodyBoard> list = new  BodyService().selectBodyList();
		ArrayList<Like>  likeCount = new LikeService().selectLikeCount();
		//HttpSession BodyListSession = request.getSession();\
		
		
		
		
	
		request.setAttribute("list", list);
		//response.sendRedirect("views/board/bodyListView.jsp");
		
		request.getRequestDispatcher("views/board/bodyProfile/bodyListView.jsp").forward(request, response);
		

		
		
		
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
