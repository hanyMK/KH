package com.kh.board.bodyProfileBoard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.bodyProfileBoard.model.service.BodyService;
import com.kh.board.bodyProfileBoard.model.vo.BoardAttachment;
import com.kh.board.bodyProfileBoard.model.vo.BodyBoard;
import com.kh.board.challenge.model.service.ChallengeService;
import com.kh.board.challenge.model.vo.ChallengeVoteQuery;
import com.kh.board.challenge.model.vo.ChallengeVoteTitle;
import com.kh.board.like.model.service.LikeService;
import com.kh.board.like.model.vo.Like;

/**
 * Servlet implementation class BodyBoadrDetailController
 */
@WebServlet("/bodyDetail.by")
public class BodyBoadrDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BodyBoadrDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// select해서 뽑아와야할 값
		// 게시글 제목, 닉네임, 작성일, 조회수, 댓글수
		
		request.setCharacterEncoding("UTF-8");
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		
		int increase_result = new BodyService().increaseCount(boardNo);
		ChallengeService challengeService = new ChallengeService();
		
	

		
		//System.out.println(likeMemberNo);
		
		//System.out.println(listAll);
		
		
		
		if(increase_result > 0) {
			
			
			
			
			
			ArrayList<Like> likeMemberNo = new LikeService().selectMemberNo(boardNo);
			
			ArrayList<BoardAttachment> list = new BodyService().detailAttachment(boardNo);
			ArrayList<BodyBoard> listAll = new BodyService().selectDetail(boardNo);
			
			//ArrayList<Like>  likeCount = new LikeService().selectLike(boardNo);
			
			//request.setAttribute("likeConut", likeCount);
			request.setAttribute("likeMemberNo", likeMemberNo);
			request.setAttribute("listAll", listAll);
			request.setAttribute("list", list);
			
			System.out.println(listAll.get(0));
			
			//System.out.println("여기니" + likeCount.get(0).getMemberNo());
			
			System.out.println("???");
				
			
				if(listAll.get(0).getVoteYN().equals("N  ")) {
				
				ChallengeVoteTitle cvt = new ChallengeVoteTitle();
				ArrayList<ChallengeVoteQuery> queryList = new ArrayList();
				
				request.setAttribute("listAll", listAll);
				request.setAttribute("list", list);
				request.setAttribute("cvt", cvt);
				request.setAttribute("queryList", queryList);
			
			
			} else if(listAll.get(0).getVoteYN().equals("Y  ")) { // 게시판 객체 필드 voteYN에 값이 Y라면 투표가 있다.
				
				// select voteTitle 게시글 (vote Title) 조회
				ChallengeVoteTitle cvt = challengeService.ChallengeVoteTitleDetatilView(boardNo);
				
				System.out.println((cvt.getVoteNo()) + "voteTitle의 voteNo 투표번호");
				if(cvt.getVoteNo() != 0) { // 투표가 있을때 외래키가 걸려있는 투표번호를 가지고 가야하기때문에 확인
					
					// select voteQuery 게시글(vote Query) 조회
					ArrayList<ChallengeVoteQuery> queryList = challengeService.ChallengeVoteQueryDetailView(cvt.getVoteNo());
					
					// 투표가 있을때 투표, 투표항목을 가진 게시판, 파일첨부, 투표, 투표항목을 서버에 담아서 보낸다
					request.setAttribute("cvt", cvt);
					request.setAttribute("queryList", queryList);
					request.setAttribute("listAll", listAll);
					request.setAttribute("clList", list);
				}
			}
			
			
			
		}
		request.getRequestDispatcher("views/board/bodyProfile/bodyDetailView.jsp").forward(request, response);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
