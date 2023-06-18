package com.kh.board.anonymous.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.anonymous.model.service.AnonymousService;
import com.kh.board.anonymous.model.vo.SelectAll;
import com.kh.board.challenge.model.service.ChallengeService;
import com.kh.board.challenge.model.vo.ChallengeVoteQuery;
import com.kh.board.challenge.model.vo.ChallengeVoteTitle;
import com.kh.common.model.vo.BoardAttachment;

/**
 * Servlet implementation class AnonymousDetailController
 */
@WebServlet("/detail.an")
public class AnonymousDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnonymousDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AnonymousService as = new AnonymousService();
		int boardNo = Integer.parseInt(request.getParameter("bno"));
		System.out.println(boardNo);
		
		//선언
		 ChallengeVoteTitle cvt = new ChallengeVoteTitle();
		 ArrayList<ChallengeVoteQuery> queryList =  new ArrayList();
		
		int result = as.increasBoard(boardNo);
		if(result >0) {
			ArrayList<SelectAll> all = as.selectAllBoard(boardNo);
			for(int i = 0; i <all.size(); i++) {
				
			
				if(!all.get(i).getVoteTitle().equals(" ")) { // 게시판 객체 필드 voteYN에 값이 Y라면 투표가 있다.
		            
		            // select voteTitle 게시글 (vote Title) 조회
		            cvt = new ChallengeService().ChallengeVoteTitleDetatilView(boardNo);
		            
		            System.out.println((cvt.getVoteNo()) + "voteTitle의 voteNo 투표번호");
		            if(cvt.getVoteNo() > 0) { // 투표가 있을때 외래키가 걸려있는 투표번호를 가지고 가야하기때문에 확인
		               
		               // select voteQuery 게시글(vote Query) 조회
		               queryList =  new ChallengeService().ChallengeVoteQueryDetailView(cvt.getVoteNo());
		               
		               // 투표가 있을때 투표, 투표항목을 가진 게시판, 파일첨부, 투표, 투표항목을 서버에 담아서 보낸다
		         
		            }
				}
			}
				
			ArrayList<BoardAttachment> attach = new AnonymousService().selectAttach(boardNo);
			
			
		
			request.setAttribute("cvt", cvt);
			request.setAttribute("queryList", queryList);
			System.out.println("cvt  "+ cvt);
			System.out.println("queryList  "+ queryList);
			
			request.setAttribute("att", attach);
			//System.out.println("attach"+attach);
			request.setAttribute("all", all );
		
			request.getRequestDispatcher("views/board/anonymous/anonymousDetailView.jsp").forward(request, response);;
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
