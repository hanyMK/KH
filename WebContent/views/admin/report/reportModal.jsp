<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신고하기 모달창</title>
</head>
<body>

	<%@include file="../../common/menubar.jsp"%>
	
	
<!-- 게시글 신고 모달 -->

<div class="modal fade" id="boardModal" tabindex="-1" data-bs-backdrop="static" data-bs-keyboard="false" aria-labelledby="exampleModalLabel" aria-hidden="true" >
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
          <div class="modal-header">
              <h1 class="modal-title fs-5" id="exampleModalLabel">게시글 신고하기</h1>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          
          
        <div class="board-report-modal-body" >                   
         <form action="report.insert" method="post">
              <div class="title">
                	제목  :  <strong> </strong>
             </div>
              <div class="writer">
                	작성자 :  <strong></strong>
                 <input type="hidden" name="attacker" value="">
                 <input type="hidden" name="boardNo" value="">
                 <input type="hidden" name="boardType" value="">
                 
               
              </div>
                <hr>
             
                <table id="reprot-form" align="center" style="margin-left: auto; margin-right: auto;">
                    <tr>
                        <td>
                            <input class="form-check-input" type="radio" name="report" id="report1" value="주제와 맞지 않는 글" checked>
                            <label class="form-check-label" for="report1">
                            주제와 맞지 않는 글
                            </label>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            <input class="form-check-input" type="radio" name="report" id="report2" value="욕설/ 비히발언">
                            <label class="form-check-label" for="report2">
                                욕설/ 비하발언
                            </label>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            <input class="form-check-input" type="radio" name="report" id="report3" value="특정인 비방">
                            <label class="form-check-label" for="report3">
                                특정인 비방
                            </label>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            <input class="form-check-input" type="radio" name="report" id="report4" value="개인 사생활 침해">
                            <label class="form-check-label" for="report4">
                                개인 사생활 침해
                            </label>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            <input class="form-check-input" type="radio" name="report" id="report5" value="19+ 만남/ 유도">
                            <label class="form-check-label" for="report5">
                                19+ 만남/ 유도
                            </label>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            <input class="form-check-input" type="radio" name="report" id="report6" value="음란성">
                            <label class="form-check-label" for="report6">
                                음란성
                            </label>
                        </td>

                    </tr>
                 
                    <tr>
                        <td>
                            <input class="form-check-input" type="radio" name="report" id="report8" value="게시글 / 댓글 도배">
                            <label class="form-check-label" for="report8">
                                게시글 / 댓글 도배
                            </label>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            <input class="form-check-input" type="radio" name="report" id="report9" value="홍보성 컨텐츠">
                            <label class="form-check-label" for="report9">
                                홍보성 컨텐츠
                            </label>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            <input class="form-check-input" type="radio" name="report" id="report10" value="기타">
                            <label class="form-check-label" for="report10">
                                기타
                            </label>
                        </td>

                    </tr>

                    <!-- <tr>
                        <td>
                            <textarea name="reason" style="resize: none; width: 200;" cols="40" rows="2" placeholder="신고사유 설명이 필요하신 경우 작성해주세요"></textarea>
                        </td>
                    </tr> -->
                </table>
               <hr style="clear:both">

              
                  
              
  
              <div class="modal-footer">
                  <button type="submit" class="btn btn-primary" id="submit">등록</button>
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
              </div>
          </form>
  
  
  
  
        </div>
      </div>
    </div>
  </div>
  
  
  <!-- 덧 글 신고모달 -->

<div class="modal fade" id="replyModal" tabindex="-1" data-bs-backdrop="static" data-bs-keyboard="false" aria-labelledby="exampleModalLabel" aria-hidden="true" >
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
          <div class="modal-header">
              <h1 class="modal-title fs-5" id="exampleModalLabel">덧글신고하기</h1>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          
          
        <div class="reply-report-modal-body" >                   
         <form action="replyReport.insert" method="post">
                 
             
              <div class="writer">
                	
                 <input type="hidden" name="attacker" value="">
                 <input type="hidden" name="boardNo" value="">
                 <input type="hidden" name="replyNo" value="">
                 <input type="hidden" name="boardType" value="">
                 
               
              </div>
                <hr>
             
                <table id="reprot-form" align="center" style="margin-left: auto; margin-right: auto;">
                    <tr>
                        <td>
                            <input class="form-check-input" type="radio" name="report" id="report1" value="주제와 맞지 않는 글" checked>
                            <label class="form-check-label" for="report1">
                            주제와 맞지 않는 글
                            </label>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            <input class="form-check-input" type="radio" name="report" id="report2" value="욕설/ 비히발언">
                            <label class="form-check-label" for="report2">
                                욕설/ 비하발언
                            </label>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            <input class="form-check-input" type="radio" name="report" id="report3" value="특정인 비방">
                            <label class="form-check-label" for="report3">
                                특정인 비방
                            </label>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            <input class="form-check-input" type="radio" name="report" id="report4" value="개인 사생활 침해">
                            <label class="form-check-label" for="report4">
                                개인 사생활 침해
                            </label>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            <input class="form-check-input" type="radio" name="report" id="report5" value="19+ 만남/ 유도">
                            <label class="form-check-label" for="report5">
                                19+ 만남/ 유도
                            </label>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            <input class="form-check-input" type="radio" name="report" id="report6" value="음란성">
                            <label class="form-check-label" for="report6">
                                음란성
                            </label>
                        </td>

                    </tr>
                    
                    <tr>
                        <td>
                            <input class="form-check-input" type="radio" name="report" id="report8" value="게시글 / 댓글 도배">
                            <label class="form-check-label" for="report8">
                                게시글 / 댓글 도배
                            </label>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            <input class="form-check-input" type="radio" name="report" id="report9" value="홍보성 컨텐츠">
                            <label class="form-check-label" for="report9">
                                홍보성 컨텐츠
                            </label>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            <input class="form-check-input" type="radio" name="report" id="report10" value="기타">
                            <label class="form-check-label" for="report10">
                                기타
                            </label>
                        </td>

                    </tr>

                    <!-- <tr>
                        <td>
                            <textarea name="reason" style="resize: none; width: 200;" cols="40" rows="2" placeholder="신고사유 설명이 필요하신 경우 작성해주세요"></textarea>
                        </td>
                    </tr> -->
                </table>
               <hr style="clear:both">

              
                  
              
  
              <div class="modal-footer">
                  <button type="submit" class="btn btn-primary" id="submit">등록</button>
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
              </div>
          </form>
  
  
  
  
        </div>
      </div>
    </div>
  </div>
  
  
  
</body>
</html>