package com.kh.board.challenge.controller;

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

import com.kh.board.challenge.model.service.ChallengeService;
import com.kh.board.challenge.model.vo.ChallengeAttachment;
import com.kh.board.challenge.model.vo.ChallengeBoard;
import com.kh.board.challenge.model.vo.ChallengeVoteQuery;
import com.kh.board.challenge.model.vo.ChallengeVoteTitle;
import com.kh.board.hashtag.model.service.HashtagService;
import com.kh.board.hashtag.model.vo.Hashtag;
import com.kh.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class ChallengeInsertController
 */
@WebServlet("/insertChallenge.cl")
public class ChallengeInsertController extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChallengeInsertController() {
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
         // 객체 생성 순서 투표 -> 투표항목list -> 게시판객체 -> 파일첨부list
         // 코드가 밑으로 온다는 전제하 투표객체 순서로 값이 있는지 구분하기위함
         if(!multiRequest.getParameter("voteTitle").equals("")) {
            // 투표 input에 값이 담겨진다면 타이틀 빈문자열로 오기에 비교(빈문자열이 아닐때 if문 실행)
            // vote insert 투표 자체의 insert
            String voteTitle = multiRequest.getParameter("voteTitle"); // 투표제목
            String dupliYN = multiRequest.getParameter("dupliYN"); // 다중선택 가능여부 (checked 속성이 on 이거나 null로 나옴)
            //System.out.println(dupliYN);
            ChallengeVoteTitle cvt = new ChallengeVoteTitle();
            cvt.setVoteTitle(voteTitle);
            if(dupliYN != null) { // checked가 적용됬을땐 on이기때문에 Y를 대입
               cvt.setVoteDupli("Y"); 
            } else { // null일땐 N을 대입
               cvt.setVoteDupli("N");
            }
            
            //System.out.println(cvt + "voteTitle객체의 정보");
            //System.out.println((cvt.getVoteDupli()) + " dupli의 값");
            
            // vote query 객체 insert
            ArrayList<ChallengeVoteQuery> queryList = new ArrayList();
            for(int i = 1; i <= 5; i++) { // 투표의 개수만큼 (지정된 개수이기때문에 5를 기준으로 반복)
               
               String key = "query" + i;
               ChallengeVoteQuery cvq = new ChallengeVoteQuery();
               
               cvq.setQuestion(multiRequest.getParameter(key)); // '투표항목'의 input에 각각 query1 ~ 5반복되는 key값에 맞춰 input value값이 대입
               // 무조건 5번 반복하면서 객체에 항목을 담기때문에 sql문 오류가 발생함 ""빈문자열이 들어올땐 값을 담지 않게 해야함
               if(!multiRequest.getParameter(key).equals("")) { // 항목에 빈문자열이 아닌 값이 들어왔을때 항목에 타입을 대입
                  
                  switch(i) { // 각각 key값에 들어가는 값(반복문의 순서에 맞춰 타입이 대입)
                  case 1 : cvq.setVoteType("A"); break;
                  case 2 : cvq.setVoteType("B"); break;
                  case 3 : cvq.setVoteType("C"); break;
                  case 4 : cvq.setVoteType("D"); break;
                  case 5 : cvq.setVoteType("E"); break;
                  }
                  queryList.add(cvq); // 필요한 대입값은 항목의 question, type
               }
            }
            //System.out.println(queryList);
            
            // Board insert
            // 값뽑기 hidden input으로 유저번호 값 받았음
          	int memberNo = Integer.parseInt(multiRequest.getParameter("userNo")); // 작성자
            // System.out.println(memberNo);
            String title = multiRequest.getParameter("title"); // 글 제목
            String content = multiRequest.getParameter("content"); // 글 내용
            String category = multiRequest.getParameter("category"); // 말머리
            
            ChallengeBoard cB = new ChallengeBoard();
            cB.setMemberNo(memberNo);
            cB.setBoardTitle(title);
            cB.setBoardContent(content);
            cB.setCategory(category);
            if(cvt.getVoteTitle() != null && !cvt.getVoteTitle().equals("")) { // 위에서 값이 대입되있는 투표제목이 비어있을때 또는 빈문자열일때 == 게시판 내에 투표가 없다
               cB.setVoteYN("Y"); // 게시판 테이블 VOTE_YN 컬럼에 투표가 있다는 값을 대입
            } else {
               cB.setVoteYN("N"); // 게시판 테이블 VOTE_YN 컬럼에 투표가 없다는 값을 대입
            }
            //System.out.println(cB.getVoteYN() + "투표여부값");
            //System.out.println(cB + "투표 여부 확인하는 Board객체");
            
            ArrayList<ChallengeAttachment> clList = new ArrayList();
            
            for(int i = 0; i <= 4; i++) { // 챌린지게시판에 들어갈 파일첨부 
               
               String key = "file" + i; // 파일번호
               
               if(multiRequest.getOriginalFileName(key) != null) {
                  
                  ChallengeAttachment cA = new ChallengeAttachment();
                  cA.setOriginName(multiRequest.getOriginalFileName(key));
                  cA.setChangeName(multiRequest.getFilesystemName(key));
                  cA.setFilePath("resources/thumbnail_upFiles");
                  
                  
                  if(i == 1) { // 키값이 1번째에 돌때는 썸네일, 기본사진 구분을 위한 파일레벨 설정
                     cA.setFileLevel(0); // 반복문의 지역변수가 1일때 썸네일로 판단하여 레벨값 0을 대입
                  } else {
                     cA.setFileLevel(1); // 나머지 지역변수들은 파일레벨 1을 대입하도록
                  } // else문
                  clList.add(cA); // 첨부파일 list에 담기
               } // if문
            } // for문
            //System.out.println(clList + "값이 담긴 clList");
            int result = new ChallengeService().insertChallenge(cB, clList, cvt, queryList); // 투표가 있을때의 데이터 가공 완료 후 서비스 전달
            
            String tagState = multiRequest.getParameter("tagState");
            
            
            int hashtagResult = 1;
   //------------해시태그가 존재한다면 insert-----------------------
            
            if(tagState.equals("yes")) {
               String[] hashtag = multiRequest.getParameterValues("hashT");
               ArrayList <Hashtag> hList = new HashtagService().selectHashtag();
               
               
               int count = 1;
               for(int i = 0; i< hashtag.length; i++) {
                  for(int j = 0; j <hList.size(); j++ ) {
                     if((hList.get(j).getHashtag()).equals(hashtag[i])){
                        //                     System.out.println(hList.get(j).getHashtag());
                        //                     System.out.println(hashtag[i]);
                        count *= 0;
                        //                     System.out.println(count);
                     }
                  }
                  if(count > 0) {
                     //                  System.out.println(hashtag[i]);
                     new HashtagService().insertHashtag(hashtag[i]);
                     count = 1;
                  }
               }
               
               int boardNo = new HashtagService().selectLastBoardNo();
               if(boardNo != 0 ) {
                  hashtagResult = new HashtagService().insertBoardHashtag(boardNo, hashtag); 
                  
               }
            }
            
            //System.out.println(result + " 투표가 있는 결과 result");
            if(result > 0) { // 결과 실행
               request.getSession().setAttribute("alertMsg", "게시글 등록 성공");
               response.sendRedirect(request.getContextPath() + "/challengeList.cl?cpage=1");
            } else {
               request.setAttribute("errorMsg", "게시글 등록 실패");
               response.sendRedirect(request.getContextPath() + "/challengeList.cl?cpage=1");
            }
            
         } else { // 투표 input에 값이 비어있다면 비어있는 객체로 투표여부를 확인
            
            // 비어있는 투표객체, 투표항목리스트생성
            ChallengeVoteTitle cvt = new ChallengeVoteTitle();
            ArrayList<ChallengeVoteQuery> queryList = new ArrayList();
            // Board insert
            // 값뽑기 hidden input으로 유저번호 값 받았음
            int memberNo = Integer.parseInt(multiRequest.getParameter("userNo")); // 작성자
            // System.out.println(memberNo);
            String title = multiRequest.getParameter("title"); // 글 제목
            String content = multiRequest.getParameter("content"); // 글 내용
            String category = multiRequest.getParameter("category"); // 말머리
            //System.out.println("??");
            //String closingDate = multiRequest.getParameter("closingDate"); // 마감일자
            ChallengeBoard cB = new ChallengeBoard();
            cB.setMemberNo(memberNo);
            cB.setBoardTitle(title);
            cB.setBoardContent(content);
            cB.setCategory(category);
            if(cvt.getVoteTitle() != null && !cvt.getVoteTitle().equals("")) { // 투표, 투표항목 생성자에 값이 비어있으므로
               cB.setVoteYN("Y"); // 투표가 있을때 Y값
            } else {
               cB.setVoteYN("N"); // 투표가 없을때 N값
            }
            //System.out.println(cB.getVoteYN() + "투표여부값");
            //System.out.println(cB + "투표 여부 확인하는 Board객체");
            // attachment insert      
            ArrayList<ChallengeAttachment> clList = new ArrayList();
            
            for(int i = 0; i <= 4; i++) {
               
               String key = "file" + i; // 파일번호
               
               if(multiRequest.getOriginalFileName(key) != null) {
                  
                  ChallengeAttachment cA = new ChallengeAttachment();
                  cA.setOriginName(multiRequest.getOriginalFileName(key));
                  cA.setChangeName(multiRequest.getFilesystemName(key));
                  cA.setFilePath("resources/thumbnail_upFiles");
                  
                  
                  if(i == 1) {
                     cA.setFileLevel(0);
                  } else {
                     cA.setFileLevel(1);
                  } // else문
                  clList.add(cA);
               } // if문
            } // for문
            //System.out.println(clList + "값이 담긴 clList");
            int result = new ChallengeService().insertChallengeNoVote(cB, clList); // 투표가 없을때의 데이터 가공처리 후 서비스로 전달
            System.out.println(result + "게시판, 파일첨부 결과");
            String tagState = multiRequest.getParameter("tagState");
            
            
            int hastagResult = 1;
   //------------해시태그가 존재한다면 insert-----------------------
            
            if(tagState.equals("yes")) {
               System.out.println("뭐라도");
               String[] hashtag = multiRequest.getParameterValues("hashT");
               ArrayList <Hashtag> hList = new HashtagService().selectHashtag();
               
               
               int count = 1;
               for(int i = 0; i< hashtag.length; i++) {
                  for(int j = 0; j <hList.size(); j++ ) {
                     if((hList.get(j).getHashtag()).equals(hashtag[i])){
                        //                     System.out.println(hList.get(j).getHashtag());
                        //                     System.out.println(hashtag[i]);
                        count *= 0;
                        //                     System.out.println(count);
                     }
                  }
                  if(count > 0) {
                     //                  System.out.println(hashtag[i]);
                     new HashtagService().insertHashtag(hashtag[i]);
                     count = 1;
                  }
               }
               
               int boardNo = new HashtagService().selectLastBoardNo();
               if(boardNo != 0 ) {
                  hastagResult = new HashtagService().insertBoardHashtag(boardNo, hashtag); 
                  System.out.println(hastagResult + "해시태그 결과");
                  
               }
            
            //System.out.println(result + " 투표가 없는 결과 result");
            if(result > 0) { // insert 결과 화면
               request.getSession().setAttribute("alertMsg", "게시글 등록 성공");
               response.sendRedirect(request.getContextPath() + "/challengeList.cl?cpage=1");
            } else {
               request.setAttribute("errorMsg", "게시글 등록 실패");
               response.sendRedirect(request.getContextPath() + "/challengeList.cl?cpage=1");
            }
         } else {
            //System.out.println(result + " 투표가 없는 결과 result");
            if(result > 0) { // insert 결과 화면
               request.getSession().setAttribute("alertMsg", "게시글 등록 성공");
               response.sendRedirect(request.getContextPath() + "/challengeList.cl?cpage=1");
            } else {
               request.setAttribute("errorMsg", "게시글 등록 실패");
               response.sendRedirect(request.getContextPath() + "/challengeList.cl?cpage=1");
            }
         }
         
      }
         // 투표가 없는 else구문
         
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