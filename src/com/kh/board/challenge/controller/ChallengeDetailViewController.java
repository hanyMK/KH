package com.kh.board.challenge.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.challenge.model.service.ChallengeService;
import com.kh.board.challenge.model.vo.ChallengeAttachment;
import com.kh.board.challenge.model.vo.ChallengeBoard;
import com.kh.board.challenge.model.vo.ChallengeVoteQuery;
import com.kh.board.challenge.model.vo.ChallengeVoteTitle;

/**
 * Servlet implementation class ChallengeDetailViewController
 */
@WebServlet("/challengedetail.cl")
public class ChallengeDetailViewController extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChallengeDetailViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      request.setCharacterEncoding("UTF-8");
   
      int boardNo = Integer.parseInt(request.getParameter("cpage"));
      //System.out.println(boardNo);
      
      ChallengeService challengeService = new ChallengeService();
      // 조회수 증가
      int result = challengeService.ChallengeIncreaseCount(boardNo);
      
      if(result > 0) {
         // select board 게시글 (board) 조회
         ChallengeBoard cB = challengeService.ChallengeDetailView(boardNo);
         System.out.println((cB.getVoteYN()) + "게시판 컬럼에 VOTE_YN이 있다면 Y");
         
         // select board 게시글 (attachthment) 조회)
         ArrayList<ChallengeAttachment> clList = challengeService.ChallengeAttachmentDetailView(boardNo);
         if(cB.getVoteYN().equals("N  ")) {
            
            ChallengeVoteTitle cvt = new ChallengeVoteTitle();
            ArrayList<ChallengeVoteQuery> queryList = new ArrayList();
            
            request.setAttribute("cB", cB);
            request.setAttribute("clList", clList);
            request.setAttribute("cvt", cvt);
            request.setAttribute("queryList", queryList);
         
         
         } else if(cB.getVoteYN().equals("Y  ")) { // 게시판 객체 필드 voteYN에 값이 Y라면 투표가 있다.
            
            // select voteTitle 게시글 (vote Title) 조회
            ChallengeVoteTitle cvt = challengeService.ChallengeVoteTitleDetatilView(boardNo);
            
            System.out.println((cvt.getVoteNo()) + "voteTitle의 voteNo 투표번호");
            if(cvt.getVoteNo() != 0) { // 투표가 있을때 외래키가 걸려있는 투표번호를 가지고 가야하기때문에 확인
               
               // select voteQuery 게시글(vote Query) 조회
               ArrayList<ChallengeVoteQuery> queryList = challengeService.ChallengeVoteQueryDetailView(cvt.getVoteNo());
               
               // 투표가 있을때 투표, 투표항목을 가진 게시판, 파일첨부, 투표, 투표항목을 서버에 담아서 보낸다
               request.setAttribute("cvt", cvt);
               request.setAttribute("queryList", queryList);
               request.setAttribute("cB", cB);
               request.setAttribute("clList", clList);
            }
         }
         
         //System.out.println(oAList.get(1));
      }
      
      
      request.getRequestDispatcher("views/board/challenge/challengeDetailview.jsp").forward(request, response);
   
   
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}