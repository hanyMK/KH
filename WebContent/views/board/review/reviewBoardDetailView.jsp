<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList, com.kh.board.review.model.vo.* ,com.kh.common.model.vo.*" %>
    
 <%
    ArrayList<BoardAttachment> oAList = (ArrayList<BoardAttachment>)request.getAttribute("oAList");    
        
 	Review oB = (Review)request.getAttribute("oB");
 	
 	
 %>  
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>offer detail</title>


<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>  
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>  
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <style>

    .outer{
        width: 800px;  
        margin: auto;
        margin-top: 5px;
    }
    #listTag>a{
        text-decoration: none;
        font-size:large;
    }
    #title{
        font-size: 30px;
    }
    .userImg{
        display:inline-block;
        width:50px;
        height:50px;
    }
    #userNickname{
        display:inline-block;
        font-size: 15px;
        font-weight: 1000;
    }
    #createDate{
        display: inline-block;
    }
    #boardCount{
        display : inline-block;
    }
    .button-area{
        width : 110px;
        height  : 30px;
        display: inline-block;
    }
    #button-area{
        margin-left: 350px;
        padding-right: 0;
    }
    #boardContent{
        padding-left: 20px;
        padding-right: 20px;
        padding-bottom: 20px;
    }
    .actBtn{
        color:#052159 ;
        background-color: #C2E5F2;
        border: 1px #C2E5F2;
        height: 30px;
        border-radius: 5px;
    }
    .actBtn:hover{
        background-color: #8db7ee;
    }
    .actBtn1{
        background-color: rgb(54, 54, 71);
        color: white;
        height: 30px;
        border-radius: 5px;
    }
    #report{
        margin-left: 300px;
        display: inline-block;
    }
    #like-area{
        margin-left: 370px;
        display : inline-block;
    }

    /* =============== reply ========================================== */
    
    p{
        text-align: left;
        margin-left: 7px;
    }
    .textarea{
        width: 750px;
        margin: auto;
        margin-left: 7px;
        border: none;
    }
    #reply_btn{
        margin-left: 90%;
    }

    #input-file{
        display: none;
    }
    .modal_form{
        margin: auto;
        margin-bottom: 20px;
        border: none;
    }
    .poto_zone{
        background-color: skyblue;
        display: inline-block;
        width: 180px;
        height: 180px;
    }
    .poto-area{
        margin-top: 20px;
        display : none;
    }
    .poto-area{
        margin-top: 20px;
        display : none;
    }
    .poto-area>div{
        margin-top: 5px;
        border-radius: 10px;
        display:inline-table;
    }
    .hiddenReplyNo{
        display : none;
    }
    #reply_btn{
        margin-left: 90%;
    }
    #reply-area{
        border: 1px solid gray;
        width: 770px;
        height: 140px;
        margin: auto;
        margin-top: 20px;
        border-radius: 10px;
    }
    #reply-area-all{
        width: 800px;
        height: auto;
        margin: auto;
        border-bottom-left-radius: 2%;
        border-bottom-right-radius: 2%;
    }
    p{
        text-align: left;
        margin-left: 7px;
    }
    .textarea{
        width: 750px;
        margin: auto;
        margin-left: 7px;
        border: none;
    }
    .reportImg{
        width: 20px;
        height: 30px;
        padding: 0;
    }
    .title>input{
        border: 1px solid black;
    }
    #textarea{
        border : 1px solid black;
    }
    
        .rereplyggg{
        background-color:#f2f2f3;
    }

	.rereply_textarea{
		width: 700px;
		display : none;
	}

    /*============ 좋아요 싫어요 =============*/

    .btn-like .heart-shape {
        display: inline;
        color: red;
        font-size: 30px;
    }
    .btn-like {
        border: none;
        background-color: inherit;
    
    }

    .like_disLike_poto{
    width: 50px;
    height: 50px;
    }

    .turnIMG{
        transform: rotate(180deg);
    }

    #plus_btn:hover{
        cursor: pointer;
    }

    #hashtagShow{
        margin-left: 300px;
    }



</style>


</head>
<body>

   <%@include file="../../common/menubar.jsp"%>

    
      
    <% if(loginUser == null){ 
        loginUser = new Member();
        loginUser.setNickname("");
    } %>
       

   
   
<!---- 컨텐츠 사진 없을때개 ---->

<div class="outer">
    <br>
    <div id="listTag">
        <a href="<%=contextPath%>/reviewList.re?opage=1">리뷰 게시판 ></a>
    </div>
    <hr>
    <div id="title">
        <%= oB.getBoardTitle() %>
    </div>
        <div id="userNickname">
        <%= oB.getNickName() %>
    </div>
    <br>
    <div id="createDate"><%= oB.getCreateDate() %></div> |
    <div id="boardCount">조회수 <%= oB.getBoardCount() %></div>

    <hr>
    <div align="center" class="imgContent">
        <% if(!oAList.isEmpty()){ %>
            <% for(int i = 0; i < oAList.size(); i++) {%>
                <img src="<%=contextPath%>/<%=oAList.get(i).getFilePath()%>/<%=oAList.get(i).getChangeName()%>" alt="게시글 파일레벨" width="300px;" height="300px;" class="imgContent">
            <% } %>
        <% } %>
    </div>
    <br>
    <div id="boardContent">
        <%= oB.getBoardContent() %>
    </div>

    <div id="button-area" align="left">
        <button class="actBtn button-area" onclick="location.href='<%=contextPath%>/reviewList.re?opage=1'">목록으로</button>
        <% if(loginUser != null && loginUser.getNickname().equals(oB.getMemberNo())) { %> 
                <button type="button" class="actBtn button-area" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo"
                         data-bs-target="#exampleModal" >게시글 수정</button>
                <form action="<%=contextPath%>/delete.re" method="get" class="button-area">
                    <input type="hidden" name="boardNo" value="<%= oB.getBoardNo()%>">
                    <button type="submit" class="actBtn1 button-area">게시글 삭제</button>
                </form>
        <% } %>
    </div>
    <br>
    <div id="hashtagShow" colspan="6" style="color: #1d9bf0;">
        <!-- <form name="searchTag" action="searchTag.hs" me all.get(0)d="post" > -->
        <ul>
                
        </ul>
    </div> 
    <div id="like-area">
        <button type="button" class="btn-like" id="like_poto">
                <span class="heart-shape"></span> 
                <span class="like-count"></span> 
        </button> 
    </div>
    <%if(loginUser != null && loginUser.getMemberNo() > 0){%>
        <div id="report">
            <img  class="reportImg" src="resources/thumbnail_upFiles/NoSweat_20230504052307_33605.png">
        </div>
    <% } %>
</div>
<br>


<br><br><br><br>



<!-- modal -->

<div class="modal fade" id="exampleModal" tabindex="-1" data-bs-backdrop="static" data-bs-keyboard="false" aria-labelledby="exampleModalLabel" aria-hidden="true" >
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">리뷰 게시판 글수정</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
          
            <div class="modal-body" >
                <form action="<%= contextPath %>/updateReview.re" method="post" enctype="multipart/form-data">
                    <% if(loginUser != null) { %>
                        <input type="hidden" name="userNo" value="<%= loginUser.getMemberNo() %>">
                    <% } %>
                        <input type="hidden" name="boardNo" value="<%= oB.getBoardNo()%>">

                    <div class="category">
                      <!-- 카테고리(주제를 선택해주세요) -->
                        <select name="category" id="category" class="modal_form">
                            <option value="" >주제를 선택해주세요</option>
                            <option value="아르바이트">아르바이트</option>
                            <option value="사원모집">사원모집</option>
                            <option value="광고">광고</option>
                        </select>
                      <!-- 바디프로필과 익명은 카테고리를 hidden에 담아서 들구감 -->
                    </div>
                    
                    <br>
                <div class="title">
                  
                    <input type="text" id="title_div" placeholder="글 제목" maxlength=20 style="width:100%" 
                           name="title" class="modal_form" required value="<%= oB.getBoardTitle()%>">
  
                </div>
  
                <div class="content" >
                    <textarea style="resize: none; width: 100%; height: 100%"  placeholder="주제에 맞지 않는 글로 판단되어 다른 유저로부터 일정수 이상 신고를 받는 경우 자동으로 숨김처리 될 수 있습니다."
                              id="textarea" name="content" class="modal_form" required><%= oB.getBoardContent()%></textarea>
                </div>
                  
                <div>
                    <hr>
                    <input type="button" name="poto" value="사진첨부" class="btn btn-sm btn-primary" id="poto-none" onclick="onOff();">
                    <input type="button" name="hashTag" value="해시태그" class="btn btn-sm btn-primary">
                    
                </div>
              
                <!-- 사진첨부수정시 미리보기해주는 곳 -->
                <!-- 만약 첨부파일이 비어있다면 -->
                <% if(oAList.isEmpty()){ %>
                    <div class="poto-area" align="center">
                        <div class="poto_zone" id="poto1">대표 이미지
                          <input type="file" name="reUpfile1" required>
                        </div>
                        <div class="poto_zone" id="poto2">2번 이미지
                          <input type="file" name="reUpfile2">
                        </div>
                        <div class="poto_zone" id="poto3">3번 이미지
                          <input type="file" name="reUpfile3">
                        </div>
                        <div class="poto_zone" id="poto4">4번 이미지
                          <input type="file" name="reUpfile4">
                        </div>
                    </div>
                <% } else if(oAList != null){%> <!-- 비어있지 않다면 -->
                    <!-- 대표이미지만 있다면 1장 첨부되었을 경우-->
                    <% if(oAList.size() == 1){ %>
                    <div class="poto-area" align="center">
                        <div class="poto_zone" id="poto1">대표 이미지 
                        <input type="hidden" name="originFileNo1" value="<%= oAList.get(0).getFileNo()%>">
                        <input type="hidden" name="originBoardNo1" value="<%= oAList.get(0).getBoardNo()%>">
                        <input type="hidden" name="originFileName1" value="<%= oAList.get(0).getOriginName()%>">
                        <img src="<%=contextPath%>/<%=oAList.get(0).getFilePath()%>/<%= oAList.get(0).getChangeName()%>" width="70px;" height="70px;">
                        <input type="file" name="reUpfile1" required value="<%= oAList.get(0).getOriginName()%>">
                        </div>
                        <div class="poto_zone" id="poto2">2번 이미지
                        <input type="file" name="reUpfile2">
                        </div>
                        <div class="poto_zone" id="poto3">3번 이미지
                        <input type="file" name="reUpfile3">
                        </div>
                        <div class="poto_zone" id="poto4">4번 이미지
                        <input type="file" name="reUpfile4">
                        </div>
                    </div> 
                    <% } else if(oAList.size() == 2) { %> <!--대표이미지한장 + 사진 한장이 있다면-->
                    <div class="poto-area" align="center">
                    <div class="poto_zone" id="poto1">대표 이미지 
                    <input type="hidden" name="originFileNo1" value="<%= oAList.get(0).getFileNo()%>">
                    <input type="hidden" name="originBoardNo1" value="<%= oAList.get(0).getBoardNo()%>">
                    <input type="hidden" name="originFileName1" value="<%= oAList.get(0).getOriginName()%>">
                    <img src="<%=contextPath%>/<%=oAList.get(0).getFilePath()%>/<%= oAList.get(0).getChangeName()%>" width="70px;" height="70px;">
                    <input type="file" name="reUpfile1" required>
                    </div>
                        <% for(int i = 1; i < oAList.size(); i++) { %>
                            <div class="poto_zone" id="poto<%= i+1%>"><%= i + 1 %>번 이미지 
                            <input type="hidden" name="originFileNo<%=i+1%>" value="<%= oAList.get(i).getFileNo()%>">
                            <input type="hidden" name="originBoardNo<%=i+1%>" value="<%= oAList.get(i).getBoardNo()%>">
                            <input type="hidden" name="originFileName<%=i+1%>" value="<%= oAList.get(i).getOriginName()%>">
                            <img src="<%=contextPath%>/<%=oAList.get(i).getFilePath()%>/<%= oAList.get(i).getChangeName()%>" width="70px;" height="70px;">
                            <input type="file" name="reUpfile<%= i + 1 %>">
                            </div>
                            <% } %>
                            <div class="poto_zone" id="poto3">3번 이미지
                            <input type="file" name="reUpfile3">
                            </div>
                            <div class="poto_zone" id="poto4">4번 이미지
                            <input type="file" name="reUpfile4">
                            </div>
                    </div>
                    <% } else if(oAList.size() == 3) { %> <!-- 대표이미지 한장 + 사진 2장이 있다면-->
                        <div class="poto-area" align="center">
                            <div class="poto_zone" id="poto1">대표 이미지 
                            <input type="hidden" name="originFileNo1" value="<%= oAList.get(0).getFileNo()%>">
                            <input type="hidden" name="originBoardNo1" value="<%= oAList.get(0).getBoardNo()%>">
                            <input type="hidden" name="originFileName1" value="<%= oAList.get(0).getOriginName()%>">
                            <img src="<%=contextPath%>/<%=oAList.get(0).getFilePath()%>/<%= oAList.get(0).getChangeName()%>" width="70px;" height="70px;">
                            <input type="file" name="reUpfile1" required>
                            </div>
                            <% for(int i = 1; i < oAList.size(); i++) { %>
                                <div class="poto_zone" id="poto<%= i+1%>"><%= i + 1 %>번 이미지 
                                <input type="hidden" name="originFileNo<%=i+1%>" value="<%= oAList.get(i).getFileNo()%>">
                                <input type="hidden" name="originBoardNo<%=i+1%>" value="<%= oAList.get(i).getBoardNo()%>">
                                <input type="hidden" name="originFileName<%=i+1%>" value="<%= oAList.get(i).getOriginName()%>">
                                <img src="<%=contextPath%>/<%=oAList.get(i).getFilePath()%>/<%= oAList.get(i).getChangeName()%>" width="70px;" height="70px;">
                                <input type="file" name="reUpfile<%= i + 1 %>">
                                </div>
                            <% } %>
                            <div class="poto_zone" id="poto4">4번 이미지
                            <input type="file" name="reUpfile4">
                            </div> 
                        </div>
                    <% } else if(oAList.size() == 4) { %> <!-- 대표이미지 한장 + 사진 3장이 있다면 -->   
                        <div class="poto-area" align="center">
                            <div class="poto_zone" id="poto1">대표 이미지 
                            <input type="hidden" name="originFileNo1" value="<%= oAList.get(0).getFileNo()%>">
                            <input type="hidden" name="originBoardNo1" value="<%= oAList.get(0).getBoardNo()%>">
                            <input type="hidden" name="originFileName1" value="<%= oAList.get(0).getOriginName()%>">
                            <img src="<%=contextPath%>/<%=oAList.get(0).getFilePath()%>/<%= oAList.get(0).getChangeName()%>" width="70px;" height="70px;">
                            <input type="file" name="reUpfile1" required>
                            </div>
                            <% for(int i = 1; i < oAList.size(); i++) { %>
                                <div class="poto_zone" id="poto<%= i+1%>"><%= i + 1 %>번 이미지 
                                <input type="hidden" name="originFileNo<%=i+1%>" value="<%= oAList.get(i).getFileNo()%>">
                                <input type="hidden" name="originBoardNo<%=i+1%>" value="<%= oAList.get(i).getBoardNo()%>">
                                <input type="hidden" name="originFileName<%=i+1%>" value="<%= oAList.get(i).getOriginName()%>">
                                <img src="<%=contextPath%>/<%=oAList.get(i).getFilePath()%>/<%= oAList.get(i).getChangeName()%>" width="70px;" height="70px;">
                                <input type="file" name="reUpfile<%= i + 1 %>">
                                </div>
                            <% } %>
                        </div>    
                    <% } %>             
                <% } %>       
                    
                
                <!-- 2번 부터 이미지가 비어있다면 새롭게 받을 수 있는 첨부파일 input을 만들어 준다-->




                <hr>
  
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" id="submit">등록</button>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
                </div>

                </form>
  
            </div>

        </div>

    </div>

</div>

<script>
    function onOff(){
                            
        var $onOff = $('.poto-area');
                            
        if($onOff.css('display') == 'none'){
        $onOff.css('display','inline');
        }
        else{
            $onOff.css('display','none');
        }
    }
    
  //---------------------------------------------------------------------------------
    //------------------------- 해시태그 불러 오기  ------------------------------------
    //---------------------------------------------------------------------------------  


        $(function(){

            $.ajax({
                url: 'hashtag.hs',
                data:{boardNo : <%=oB.getBoardNo()%>},
                type: 'post',
                success:function(hList){
                    console.log(hList);

                    var hashtag = '';
                    

                    for(var i in hList){
                        hashtag = 
                                '<li class="ht" style="display: inline-block; margin=auto">' 
                            
                                +hList[i].hashtag
                                +'</li>';
                                
                                
                    //$('#hashtag').on('load', 'ul', 'li',function(){
                        $('#hashtagShow').append(hashtag);     
                        //})
                    }       
                },
                error: function(){
                    console.log('실패!!')
                }

            });

       
       
        
        
        $('#hashtagShow').on('click', 'li', 'button', function(event){
            var hashtag = $(this).text().slice(1).trim();
            console.log(hashtag);
            //document.hashtag.submit();
            location.href='<%=contextPath%>/searchTag.hs?cpage=1&hashtag='+hashtag;
            
           
                
          });
      

        });

  
        $(function(){
            if('<%=loginUser%>' != 'null'&& '<%=loginUser.getMemberNo()%>' >0) {
                $('#report').on('click',function(){
                    $('#boardModal').modal('show');
                    //---------------------게시글 신고하기---------------
                    //여기는 게시판마다 각자 설정하면 넣을 수 있습니다 반드시 설정 바랍니다
                    var userNo = '<%=oB.getMemberNo()%>';
                    var boardNo = '<%=oB.getBoardNo()%>';
                    var boardTitle = '<%=oB.getBoardTitle()%>';
                    var boardType = 'F';
                    var boardWriter = '<%=oB.getNickName()%>';
                    
                    console.log('회원번호' +userNo + ',  게시글 번호'+ boardNo);
                    //게시글 제목
                    $('.board-report-modal-body .title').children().text(boardTitle);
                    //작성자입력
                    $('.board-report-modal-body .writer').children().text(boardWriter);
                    console.log(boardWriter);
                    //신고할 게시글 번호
                    $('.board-report-modal-body .writer').children('input[name=boardNo]').val(boardNo);
                    //신고대상자 멤버번호 전달
                    $('.board-report-modal-body .writer').children('input[name=attacker]').val(userNo);
                    //신고된 게시글타입전달
                    $('.board-report-modal-body .writer').children('input[name=boardType]').val(boardType);
                    console.log($('.board-report-modal-body .writer').children('input[name=boardType]').val());
               
               
                });
            };
            
        });

    

        $(function(){
            
            selectLike();

        })    
        

        function selectLike(){

            $.ajax({
                url : 'selectLike.by',
                data : {
                    
                    boardNo :  <%= oB.getBoardNo() %>
                },
                success : function(likeCount){

                    $('#like_poto').children().eq(0).html('♡');
                 $('.like-count').html(likeCount[0].boardLikeCount);         // 좋아요 수 
                 // $('.dislike-count').html(likeCount[0].boardDislikeCount);  // 싫어요 수
                

                
                        
                <% if(loginUser.getMemberNo() != 0){ %>
                  var userNo = <%= loginUser.getMemberNo() %>
                    
                    for(var i in likeCount){
                        if(userNo == likeCount[i].memberNo){
                            
                            // alert('좋아요 기록있음')
                            $('#like_poto').children().eq(0).html('♥');break; // 좋아요 기록이있는 유저는 하트채우기
                            
                         }else{
                            
                            $('#like_poto').children().eq(0).html('♡');
                            
                        }
                        
                    }
                    
                            $('#like_poto').one("click", function(){
                                if($('#like_poto').children().eq(0).html()=='♥'){

                                // alert('좋아요 기록이 있는 사람')

                                    deleteLike()


                                } else  if($('#like_poto').children().eq(0).html()=='♡') {

                                    insertLike()

                                }
                            })

                <% } %>
                },
                error : function(){
                    alert('좋아요 select 실패')
                }
                
            });
        };
        
            // ====================== INSERT ========================
        function insertLike(){
        
            //$('#like_poto').on("click", function(event){
                $.ajax({
                    url : 'insertLike.by',
                    data : {
                        boardNo : <%= oB.getBoardNo() %>
                    },
                    success : function(insertLikeResult){
            
                        //alert('좋아요 insert 성공!')
                        
                    $('#like_poto').children().eq(0).html('♥');    // 하트채우고
                    //$('#like_poto').attr("disabled", true)       // 버튼 비활성화
                    
                        selectLike();
                    
                    },
                    error : function(){
                        alert('좋아요 insert 실패 ')
                    }
                })
            
             //  })  
        
        
        }
        
        // ======================= DELETE =========================
        
        function deleteLike(){
        
            $.ajax({
                url : 'deleteLike.by',
                data : {
                    boardNo : <%= oB.getBoardNo() %>
        
                },
                success : function(deleteResult){
                    //alert('삭제성공');
        
                    $('#like_poto').children().eq(0).html('♡');
        
                    selectLike();
                },
                error : function(){
                        alert('좋아요 delete 실패 ')
                    }
            })
        
        
        
        }
   
</script>


<div id="reply-area-all">

    <% if(loginUser.getMemberNo() != 0){ %> 
    <!-- 로그인 했을 경우 -->

    <div id="reply-area" >
        <div style="margin-top: 7px;">
            <p>
                닉네임 : <%= loginUser.getNickname() %>
            </p>
        
        </div>
        <div >
            <textarea id="textarea_content" class="textarea" cols="50" style="resize: none;" placeholder="댓글을 남겨보세요"></textarea>
        </div>
        <div id="reply_btn" >
            <span >
                <button class="actBtn" style="border: none;" onclick="insertReply();">등록</button>
            </span>
        
        </div>

    </div>
                                                            
    <% } else  { %>

   
        <!-- 로그인 안했을 경우 -->



        <div id="reply-area" >
            <div style="margin-top: 7px;">
                <p>
                    
                </p>
            
            </div>
            <div>
                <textarea readonly class="textarea" placeholder="로그인 후 이용가능 합니다"></textarea>
            </div>
            <div id="reply_btn" >
                <span >
                    <button style="border: none;">등록</button>
                </span>
            
            </div>
    
        </div>       
        
        
    <% } %> 




			 <!--================= 여기서부터는 댓글 내용 LIST ============================-->

            <div>
                <table  align="center" width="800" id="replyList_table">
                    <tbody id="replyList_area">


                       <!-- 여기가 댓글LIST자리 -->

                       
                       
                    </tbody>
                </table>        
            </div>       

    </div>



    <script>
        function insertReply(){
            if($('.textarea').val() == " "){
                alert('내용을 입력해주세요!')
            }
        }

        // 댓글 기능 넘겨줘야할 것들 : 게시글 번호, 회원아이디, 댓글내용
        // 아이디는 여기서 안넘겨도 session에 담아놨으므로 controller에서 뽑아오면 된다.
      
        function insertReply(){
            if($('.textarea').val() == ""){
                alert('내용을 입력해주세요!')
            }else{

                $.ajax({
                    url : 'replyInsert.by',
                    data : {
                        boardNo : <%= oB.getBoardNo() %>,
                       replyContent : $('#textarea_content').val()
                    },
                    type : 'post',
                    success : function(result){
                        alert('댓글작성완료')
                        //.log(result);
                        
                        // result값이 0 이상이면 댓글이 성공적으로 등록되었다는 뜻
                        if(result > 0){
                            
                            
                            $('#textarea_content').val('');
                            selectReplyList();
                            
                        }
    
                    },
                    error : function(){
                        alert('댓글작성실패 관리자에게 문의하지마시고 혼자해결하세요')
                    }
                })
            }
        }


        
    	function selectReplyList(){
            $.ajax({
                url : 'listReply.by',
                data : {
                    boardNo : <%= oB.getBoardNo() %>
                },
                success : function(replyList){
                    
                    //console.log(replyList);
                    //console.log(listAll);
                    
                    // 댓글 개수만큼 반복을 해준다
                   //console.log(replyList)
                    
                    let result = '';
                   // var num = replyList.length();
                    for(var i in replyList){
                        result +=   '<tr class="reply_area3" >'
                                    + '<td>'
                                        +'<span class="reply_header" style="font-size:20px; padding-left: 10px; ">'
                                            //+ 'No : ' + replyList[i].replyNo  +  
                                            + replyList[i].nickName + ' : ' 
                                            +'</span>'
                                            +'<span class="reply_header " style="font-size:20px; padding-left: 10px;">'
                                            +  replyList[i].replyContent 
                                            +'</span>'
                                        +'<br>'
                                        
                                        
                                        +'<span class="span_class" style="font-size:small; padding-left:20px; color:grey;" >'
                                            + '작성일 :'+ replyList[i].replyDate    + ' | ' 
                                            
                                            + '<button class="rereply_btn actBtn" style="border:none;"> 답글 </button>'+ ' | ' + '신고'
                                            + '<input class="hidden_3" id="hidden_3" type="hidden" value="'+ replyList[i].replyNo + '" ></input>'
                                        +'</span>'
                                    +'</td>'
                                    +'</tr>'  



                                       + '<tr class="rereplyggg">'
                                        
                                        

                                       + '</tr>'     
                                   
                                // 답글 버튼 눌렀을때 구역
                               + '<tr class="rereply_textarea">'  
                                                            + '<td>'
                                                            + '<div>'
                                                                    + '<div style="margin-top: 7px;">'
                                                                        + '<p>'
                                                                            + '닉네임 :'+ '<%= loginUser.getNickname() %>'
                                                                        +'</p>'
                                                                    +'</div>'

                                                            +' <div>'
                                                                    +'<textarea style="resize:none;" class="textarea_submit" cols="50" placeholder="댓글을 남겨보세요">' + '</textarea>'
                                                            +' </div>'

                                                            +'<div >'

                                                                    +'<span >'
                                                                        +'<button class="rereply_cancel actBtn1" style="border: none;">'+'취소'+'</button>'
                                                                        +'<button class="rereply_submit actBtn" style="border: none;">'+'등록'+'</button>'
                                                                        + '<input type="hidden" value="'+ replyList[i].replyNo + '" ></input>'
                                                                    + '</span>'
                                                                
                                                            +'</div>'

                                                        + '</div>'
                                                        + '</td>'
                                                    + '</tr>';



                               // 대댓글 구역
                               // 만약 대댓글이 있다면 여기에 보여줘(if문)
                                //  result += 
                                //  (function(i){
                                //    $.ajax({
                                //         url : 'selectReReply.by',
                                //         data : {
                                //             replyNo : replyList[i].replyNo
                                //         },
                                //         success : function(rereplyList){
                                            
                                //             alert('대댓글 LIST 불러오기 성공')

                                //             console.log(rereplyList)
                                //             var ww = rereplyList[1].rereplyContent
                                            
                                            
                                            
                                            
                                            
                                //         },
                                //         error : function(){
                                //             alert('대댓글 불러오기 실패')
                                //         }
                                //     })
                                
                                //  })(i);
                        
                    };//for문 닫힘
                    
                    $('#replyList_table>tbody').html(result);


                   // console.log(replyList)
                   // each이용해서 순서대로 접근???
                    // $.each(replyList,function(index,item){

                    //     console.log(index , item.replyNo);

                    //     $.ajax({
                    //         url : 'selectReReply.by',
                    //         data : {
                    //             replyNo : item[0].replyNo
                    //         },
                    //         success : function(){
                                
                    //             alert('대댓글 LIST 불러오기 성공')
                                
                                
                                
                                
                                
                    //         },
                    //         error : function(){
                    //             alert('대댓글 불러오기 실패')
                    //         }
                    //         })

                   // })
                   
               
                },
                error : function(){
                    alert('댓글읽어오기에 실패하였습니다')
                                }
            })
                        
                        
                        
        }
        
        // 댓글List는 detailView에 들어오면 바로 보여줘야 한다
        // 그래서 window.onload 
        // 제이쿼리는 $(function(){})
        $(function(){
            selectReplyList();

        });

// ============================ ++++++ REREPLY(대댓글) +++++++++++++ ========================================
        

            // 답글쓰기 버튼을 눌렀을 때 대댓글 창 나오기


           //var cc = $(this).parents('tr').next().toggle('fast');

            // var $pp = $(this).parents('tr').next() // '열려서 나타날 요소'를 변수에 넣어준다
            // if($pp.css('display') == 'none'){

            //    $pp.siblings('tr').prev().fadeOut();
            //    $pp.fadeIn();
            // }else{

            // $pp.fadeOut();
            //}
    
                    
                            // 답글 버튼을 누르면 해당 게시글 번호 가지고 select!!

<% if(loginUser.getMemberNo() != 0){ %>

    $('#replyList_table').on('click', '.rereply_btn', function(e){
        // 대댓글이 들어갈 공간이 빈공간이면 a.jax실행해주고
        // 아니면 다시 빈공간으로 만들어주기
        var cc = $(this).parents('tr').next().next().toggle('fast');
        var $temp =  $(this);
        //rere($temp);
        //var $space = $temp.parent().parent().parent().next();

          // if(빈공간이면 실행)
                        // else()
                        if($temp.parent().parent().parent().next().html() == ""){
                            rere($temp);
                        }else{
                            $temp.parent().parent().parent().next().html("");
                        }



    })
function rere($temp){
 


    //console.log($temp)
    $.ajax({
        url : 'selectReReply.by',
        data : {
            replyNo : $temp.next().val()
        },
        success : function(rereplyList){

            
            //console.log(rereplyList);
            
             //alert('대댓글 LIST 불러오기 성공');

            let rere = '';
            for(let i in rereplyList){
                var reply11 = rereplyList[i].replyNo;
                //console.log(rereplyList[i])
                if ($temp.next().val() == reply11){
                    // console.log($temp.next().val() == reply11);
                    //console.log($('.span_class').children().eq(2).val());
                    rere +=     
                    '<tr>'
                           
                           + '<td >'
                                + '<span width="400px"  class="reply_header" style="font-size:20px; padding-left: 50px; ">'

                                     + rereplyList[i].nickName + ' : ' +  rereplyList[i].reReplyContent 
                                +'</span>'
                         
                                    + '<br>'
                                
                                +'<span style="font-size:small; padding-left: 50px; color:grey; ">'
                                    + '작성일 :'+ rereplyList[i].reReplyDate + ' | ' + '신고'
                                +'</span>'
                            +'</td>'
                     
                    +'</tr>'
                

                }// if문 끝
                //console.log($temp.parent().parent().parent().next())
                
            }// for문끝
           //console.log(rereplyList)

                                
                    $temp.parent().parent().parent().next().append(rere).fadeIn();
                    //console.log( $temp.parent().parent().parent().next())
                   

                        },
                        error : function(){
                            alert('대댓글 불러오기 실패')
                        }
        })
    }
  

// 예외처리
// 1. 댓글에 대댓글 내용이 없으면 에러뜨는 문제
// 2. 대댓글이 중복됨
// 3. 공백문제


        // 대댓글 취소 버튼 누르면 들어가기
        $('#replyList_table').on('click', '.rereply_cancel', function(){
           // console.log($(this).parents('tr'))
            $(this).parents('tr').toggle('fast');
        })

        // 다른 답글쓰기를 눌렀을 때 이 전 대댓글 창은 닫히기!




        // =========================== REREPLY INSERT ==============================
        // 등록버튼 누르면 INSERT ajax보내기

        $('#replyList_table').on('click', '.rereply_submit', function(e){

            if($(this).parent().parent().prev().children().val() == ""){
                        alert('내용을 입력해주세요!')
                }else{

                
                    
            
            var $temp2 = $(this);
            
           // console.log($(this).next().val())

                $.ajax({
                    url : 'insertReReply.by',
                    data : {

                         boardNo : <%= oB.getBoardNo() %>
                        ,replyNo : $(this).next().val()
                        ,rereplyContent : $(e.target).parent().parent().prev().children().val()
                        
                        
    
                    },
                    type : 'POST',

                    success : function(rereplyResult){
                        //alert('insert 성공')
                       // console.log($temp)
                        //rere($temp2);






                        $.ajax({
        url : 'selectReReply.by',
        data : {
            replyNo : $temp2.next().val()
        },
        success : function(rereplyList){

            
            //console.log(rereplyList);
            

            let rere = '';
            for(let i in rereplyList){
                var reply11 = rereplyList[i].replyNo;
                //console.log(rereplyList[i])
                if ($temp2.next().val() == reply11){
                    // console.log($temp.next().val() == reply11);
                    //console.log($('.span_class').children().eq(2).val());
                    rere +=     
                    '<tr>'
                           
                           + '<td >'
                                + '<span width="400px"  class="reply_header" style="font-size:20px; padding-left: 50px; ">'

                                     + rereplyList[i].nickName + ' : ' +  rereplyList[i].reReplyContent 
                                +'</span>'
                         
                                    + '<br>'
                                
                                +'<span style="font-size:small; padding-left: 50px; color:grey; ">'
                                    + '작성일 :'+ rereplyList[i].reReplyDate + ' | ' + '신고'
                                +'</span>'
                            +'</td>'
                     
                    +'</tr>'
                                                        
                }// if문 끝
                //console.log($temp.parent().parent().parent().next())
                
            }// for문끝
           //console.log(rereplyList)

                                
                    //console.log( $temp2.parent().parent().parent().parent().parent().prev().html())

                    $temp2.parent().parent().parent().parent().parent().prev().html(rere);

                    //console.log($temp2.parent().parent().prev().children())
                    $temp2.parent().parent().prev().children().val("");


                        },
                        error : function(){
                            alert('대댓글 불러오기 실패')
                        }
                            })
                        // 여기까지
                    },
                    error : function(){
                        alert('대댓글 실패 다시보세용')
                    }
                
                })

                }
        })

        <% }else{ %>
            $('#replyList_table').on('click', '.rereply_btn', function(e){
                alert('로그인 후 이용해주세요')
            })

        
            <% } %>
       
   
        </script>


	<script>

        //댓글 삭제
    $(function(){
        var nickName = '<%=loginUser.getNickname()%>';
        
        if($('.nickname') == nickName){
            $('.nickname').css('display', 'inline');
        }
        $('#reply-area tbody').on('click', $("#reply-area tbody button"), function(){
            $.ajax({
                url : 'deleteReply.cl',
                data : { 
                    cno : '<%= oB.getBoardNo() %>',
                    replyNo : $(event.target).parent().prev().text(),
                    <% if(loginUser != null){ %>
                        memberNo : '<%= loginUser.getMemberNo() %>'
                    <% } %>
                },
                type : 'post',
                success : function(result){
                    console.log(cno);
                    console.log(replyNo);
                    console.log(memberNo);
                    if(result > 0){
                        selectReplyList();
                    }
                },
                error : function(){
                    console.log('댓글 삭제 실패');
                }
            });
        })
    })
    

        
        </script>
   

          


          
<script>


    //---------------------댓글 신고하기---------------
    $(function(){

        if('<%=loginUser%>' != 'null' && '<%=loginUser.getMemberNo()%>' > 0 ) {
            $('#replyList_table>tbody').on('click','.reportImg', function(e){
                

                    $('#replyModal').modal('show');
                    
                    
                //여기는 게시판마다 각자 설정하면 넣을 수 있습니다 반드시 설정 바랍니다
                var userNo = $(this).siblings('input[name=userNo]').val();
                console.log( $(this).siblings('input[name=memberNo]').children());
                var boardNo = '<%=oB.getBoardNo()%>';
                var replyNo = $(this).siblings('input[name=replyNo]').val();
                var boardType = 'F';
                console.log("리플번호"+replyNo);
                console.log("사용자 번호"+userNo);
                //신고할 게시글 번호
                $('.reply-report-modal-body .writer').children('input[name=boardNo]').val(boardNo);
                //신고할 덧글 번호 전달
                $('.reply-report-modal-body .writer').children('input[name=replyNo]').val(replyNo);
                //신고대상자 멤버번호 전달
                $('.reply-report-modal-body .writer').children('input[name=attacker]').val(userNo);
                //신고 게시글 주소
                $('.reply-report-modal-body .writer').children('input[name=boardType]').val(boardType);
                            
            })
        }
    });

</script>
   
<%@ include file="../../common/footer.jsp" %>

<br><br>
</body>
</html>