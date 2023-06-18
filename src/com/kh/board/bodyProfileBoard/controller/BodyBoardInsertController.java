package  com.kh.board.bodyProfileBoard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.board.anonymous.model.service.AnonymousService;
import com.kh.board.bodyProfileBoard.model.service.BodyService;
import com.kh.board.bodyProfileBoard.model.vo.BoardAttachment;
import com.kh.board.bodyProfileBoard.model.vo.BodyBoard;
import com.kh.board.challenge.model.vo.ChallengeVoteQuery;
import com.kh.board.challenge.model.vo.ChallengeVoteTitle;
import com.kh.board.hashtag.model.service.HashtagService;
import com.kh.board.hashtag.model.vo.Hashtag;
import com.kh.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class BodyBoardInsertController
 */
@WebServlet("/insertBody.by")
public class BodyBoardInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BodyBoardInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// POST방식 => 인코딩 설정을 해준다
		request.setCharacterEncoding("UTF-8");
		
		// 첨부파일 이 넘어왔음으로 조건을 제시한 후 서버로 파일을 올려주자
		// 조건으로는 전송용량제한, 저장할 서버의 물리적 경로 제시
		
		if(ServletFileUpload.isMultipartContent(request)) {		// 만약 from태그에서 가져와서 보내준파일... ~~
			
			
			// 1) 전송용량제한을 해준다
			int maxSize = 1024 * 1024 * 10;
			
			// 1_1) 저장할 서버의 물리적 경로를 제시해준다
			String savePath = request.getServletContext().getRealPath("/resources/thumbnail_upFiles/");
							// 내가 jsp에서 requset응답받은 경로니깐 jsp영역의 최상위 폴더인 WebContent에서부터 시작한다
			
			
			// 1_2) 파일 업로드를 위한 라이브러리가 필요하다 (http://www.servlets.com)
			// 파일 업로드를 위한 라이브러리 명 : cos.jar(com.oreilly.servlet 의 약자)
			// 다운 후 lib폴더에 붙여넣기 해준다
			
			// 2) cos.jar에서 제공해준 MultipartRequset 객체를 생성해서 담아서 보내줄 객체를 생성해준다
			// 객체 생성후 실행만으로 첨부파일이 바로 업로드 된다.
			
			// 사용자가 첨부한 파일명을 수정하여 업로드하는것이 일반적이기 때문에 파일명을 수정해주는 객체를 생성해준다
			// 기본적으로 파일명을 수정해주는 객체 역시 cos.jar에서 제공해준다 => FileRenamePolicy
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			
			// MultiReaquset로 값을 뽑아준다 (requset가 아니고  여기서 뽑는이유는 form태그로 요청할때에 multi/form-data방식으로 전송하였기 때문)
			
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
							
			
			
				
			
			// 가져와야 할 것들 : 글제목, 글내용, 카테고리, 
			
			String boardTitle = multiRequest.getParameter("title");			// 글제목
			String boardContent = multiRequest.getParameter("content");		// 글내용
			String category = multiRequest.getParameter("category");		// 카테고리
			
			//String voteYN = multiRequest.getParameter("voteYN");
			//String hashTag = multiRequest.getParameter("hashTag");
			
			String memberNo = multiRequest.getParameter("userNo");	//작성자 번호(식별기준)
			
			//String hidden = multiRequest.getParameter("hidden");
			
			//String category_hidden = category + hidden;
			
		
			// VO로 가공해준다
			BodyBoard bb = new BodyBoard();
			
			bb.setBoardTitle(boardTitle);
			bb.setBoardContent(boardContent);
			bb.setCategory(category);
			bb.setMemberNo(memberNo);
			
			
			
			if(cvt.getVoteTitle() != null && !cvt.getVoteTitle().equals("")) { // 위에서 값이 대입되있는 투표제목이 비어있을때 또는 빈문자열일때 == 게시판 내에 투표가 없다
				bb.setVoteYN("Y"); // 게시판 테이블 VOTE_YN 컬럼에 투표가 있다는 값을 대입
			} else {
				bb.setVoteYN("N"); // 게시판 테이블 VOTE_YN 컬럼에 투표가 없다는 값을 대입
			}
			
			
			// 여러개의 VO를 묶어서 오기 떄문에 ArrayList를 사용한다
			ArrayList<BoardAttachment> list = new ArrayList();
			
			
			// file의 키값이 4개이이다 (최대 사진 4개까지만 등록가능이므로)
			for(int i = 1; i <= 4; i++	) {
				
				// 먼저 미리 키값을 변수에 담는다
				String key = "file" + i;	// 파일명에 번호를 붙여준다
				
				
				// 현재 반복하고 있는 키값으로 파일을 업로드 했는지 파악을 해준다 (파일 존재유무)
				if(multiRequest.getOriginalFileName(key) != null) {	// 파일이 존재한다면 ~
					
					BoardAttachment at = new BoardAttachment();
					at.setOriginName(multiRequest.getOriginalFileName(key));
					at.setChangeName(multiRequest.getFilesystemName(key));
					at.setFilePath("resources/thumbnail_upFiles");
					
					// 파일 레벨에따라 
					if(i == 1) {
						at.setFileLevel(0);
					}else {
						at.setFileLevel(1);
						
					}
					
					
					list.add(at);
				}
				
			}
			
			
			//해시태그 존재 유무판단
			int result = new BodyService().insertBodyWithVote(bb, list, cvt, queryList); // 투표가 있을때의 데이터 가공 완료 후 서비스 전달
			String tagState = multiRequest.getParameter("tagState");
			//int result1 = as.insertAnonymous(a,list);
			
			
			int hashtagResult = 1;
//------------해시태그가 존재한다면 insert-----------------------
			
			if(tagState.equals("yes")) {
				String[] hashtag = multiRequest.getParameterValues("hashT");
				ArrayList <Hashtag> hList = new HashtagService().selectHashtag();
				
				
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
					hashtagResult = new HashtagService().insertBoardHashtag(boardNo, hashtag); 
					
				}
			}
			
			
			
			
			//System.out.println(clList + "값이 담긴 clList");
			
			//System.out.println(result + " 투표가 있는 결과 result");
			if((result) > 0) { // 결과 실행
				request.getSession().setAttribute("alertMsg", "게시글 등록 성공");
				response.sendRedirect(request.getContextPath() + "/list.by");
			} else {
				request.setAttribute("errorMsg", "게시글 등록 실패");
				response.sendRedirect(request.getContextPath() + "/list.by");
			}
			
		} else { // 투표 input에 값이 비어있다면 비어있는 객체로 투표여부를 확인
			
			// 비어있는 투표객체, 투표항목리스트생성
			ChallengeVoteTitle cvt = new ChallengeVoteTitle();
			ArrayList<ChallengeVoteQuery> queryList = new ArrayList();
			// Board insert
			// 값뽑기 hidden input으로 유저번호 값 받았음
			String boardTitle = multiRequest.getParameter("title");			// 글제목
			String boardContent = multiRequest.getParameter("content");		// 글내용
			String category = multiRequest.getParameter("category");		// 카테고리
			System.out.println(category);
			
			//String voteYN = multiRequest.getParameter("voteYN");
			
			
			String memberNo = multiRequest.getParameter("userNo");	//작성자 번호(식별기준)
			//System.out.println(memberNo);
			//String hidden = multiRequest.getParameter("hidden");
			
			//String category_hidden = category + hidden;
			
			
			
			//------------------------객체 가공 및 insert 시작-------------------------------
			
			// VO로 가공해준다
			BodyBoard bb = new BodyBoard();
			
			bb.setBoardTitle(boardTitle);
			bb.setBoardContent(boardContent);
			bb.setCategory(category);
			bb.setMemberNo(memberNo);
			
			
			
			if(cvt.getVoteTitle() != null && !cvt.getVoteTitle().equals("")) { // 투표, 투표항목 생성자에 값이 비어있으므로
				bb.setVoteYN("Y"); // 투표가 있을때 Y값
			} else {
				bb.setVoteYN("N"); // 투표가 없을때 N값
			}
		
			
			// 여러개의 VO를 묶어서 오기 떄문에 ArrayList를 사용한다
			ArrayList<BoardAttachment> list = new ArrayList();
			
			
			// file의 키값이 4개이이다 (최대 사진 4개까지만 등록가능이므로)
			for(int i = 1; i <= 4; i++	) {
				
				// 먼저 미리 키값을 변수에 담는다
				String key = "file" + i;	// 파일명에 번호를 붙여준다
			
				
				// 현재 반복하고 있는 키값으로 파일을 업로드 했는지 파악을 해준다 (파일 존재유무)
				if(multiRequest.getOriginalFileName(key) != null) {	// 파일이 존재한다면 ~
					
					BoardAttachment bt = new BoardAttachment();
					bt.setOriginName(multiRequest.getOriginalFileName(key));
					bt.setChangeName(multiRequest.getFilesystemName(key));
					bt.setFilePath("resources/thumbnail_upFiles");
					
					// 파일 레벨에따라 
					if(i == 1) {
						bt.setFileLevel(0);
					}else {
						bt.setFileLevel(1);
						
					}
					
					
					list.add(bt);
				}
				
			}
			
			
			
			String tagState = multiRequest.getParameter("tagState");
			
			int result = new BodyService().insertBody(bb, list);// 투표가 없을때의 데이터 가공처리 후 서비스로 전달
			
			int hastagResult = 1;
//------------해시태그가 존재한다면 insert-----------------------
			
			if(tagState.equals("yes")) {
				String[] hashtag = multiRequest.getParameterValues("hashT");
				ArrayList <Hashtag> hList = new HashtagService().selectHashtag();
				
				
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
					hastagResult = new HashtagService().insertBoardHashtag(boardNo, hashtag); 
					
				}
				//System.out.println(clList + "값이 담긴 clList");
				
				
				//System.out.println(result + " 투표가 없는 결과 result");
				if(result * hastagResult> 0) { // insert 결과 화면
					request.getSession().setAttribute("alertMsg", "게시글 등록 성공");
					response.sendRedirect(request.getContextPath() + "/list.by"); // 성공메세지 후 다시 리스트페이지로 이동시켜줌
				} else {
					request.setAttribute("errorMsg", "실패");
				}
			}else {
				
				if(result * hastagResult> 0) { // insert 결과 화면
					request.getSession().setAttribute("alertMsg", "게시글 등록 성공");
					response.sendRedirect(request.getContextPath() + "/list.by"); // 성공메세지 후 다시 리스트페이지로 이동시켜줌
				} else {
					request.setAttribute("errorMsg", "실패");
				}
				
				
				
				
			}
			
			
			
			
			
		} // 투표가 없는 else구문

		
		
		
		
				
	}//멀티끝



}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
