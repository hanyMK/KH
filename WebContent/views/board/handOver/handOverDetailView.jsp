<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ page import="java.util.ArrayList,com.kh.common.model.vo.*, com.kh.board.handOver.model.vo.*" %>
    
    <%
       HandOver ho = (HandOver)request.getAttribute("handover"); 
           
        ArrayList<BoardAttachment> att = (ArrayList<BoardAttachment>)request.getAttribute("att");
    %>     
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>양도 게시판 게시글</title>


<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
<title>Bootstrap Example</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
   <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

   

    <style>

    .outer{
        width: 800px;  
        margin: auto;
        margin-top: 5px;
    }
    .list-area{
        text-align: center;
    }

    .list-area > tbody >tr:hover{
        cursor: pointer;
        background-color: crimson;
    }

    .outer table{
        padding-bottom: 500px;

    }

    .outer table, tr, th, td{

        /* border : 1px solid black; */
            height: 50px;
        }

        #text11{
            height: 500px;
        }


   
    .content{
        height: 100px;
    }
 
    
    /* =============== reply ========================================== */


    #reply-area-all{
        border: 1px solid gray;
        width: 800px;
        height: auto;
        margin: auto;
        border-bottom-left-radius: 2%;
        border-bottom-right-radius: 2%;

        
    }
    #reply-area{
        border: 1px solid gray;
        width: 770px;
        height: 140px;
        margin: auto;
        margin-top: 20px;
        border-radius: 10px;
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
    #reply_btn{
        margin-left: 90%;
    }

    .upload_poto{
        width: 30px;
        height: 30px;
    }


    .rereply_textarea{
        width: 700px;
        
    }
    .nickname{
        display: none;
    }
    #returnList{
        margin: 20px;
    }

        /* 댓글 */

        .reply_header{
        margin-top: 20px;
    }
    .reply_footer{
        margin-bottom: 20px;
    }

    .span_class{
        margin-top: 20px;
       
        
    }

    .reply_area3{
        height: 30px;
    }

    #replyList_table{
        height: 500px;
    }
    
    
    .rereply_textarea{
    	width: 400px;
    	display: none;
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


    .an_3{
        margin-top: 20px;
        padding-left: 5px;
    }

    /* 대댓글 대댓글 */

    .rereply_area_2{
        margin-left: 20%;
      
    }


   
    #date_area{
        height: 5px;
        margin-bottom: 20px;
    }
    #content_area1{
        height: 500px;
    }

      
/*게시글 수정 삭제, 모달버튼*/
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


      #returnList, #deleteAn{
    margin: 15px;
   }


         /* ---------------------------------------------------------------------------------
      ------------------------- 모달창(게시글 작성시)-------------------------------------
      --------------------------------------------------------------------------------- */
/*  모달창    */


        
    #modal{
        background-color: skyblue;
    }

       
        .content{
        margin-bottom: 20px;
        height: 200px;
       }
       #input-file{
        display: none;
       }



    /* --------해시태그 style---------------------------------------- */


    #div-tag> ul {
    padding: 16px 0;
    }

    #div-tag> ul li {
    display: inline-block;
    margin: 0 5px;
    font-size: 14px;
    letter-spacing: -.5px;
    }

    #div-tag> form {
    padding-top: 16px;
    }

    #div-tag> ul li.tag-item {
    padding: 4px 8px;
    background-color: #C2E5F2;
    color: #052159;
    }

    .tag-item:hover {
    background-color: #8db7ee;
    color: #fff;
    }

    .del-btn {
    font-size: 12px;
    font-weight: bold;
    cursor: pointer;
    margin-left: 8px;
    }
    
 	#hashtagShow{
        margin-left: 300px;
    }
        

    


     /*---신고 이미지 크기 ---*/
     .reportImg{
        width: 20px;
        height: 30px;
        padding: 0;
    }
    
   /*---------사진첨부 스타일--------*/
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
        border: 1px solid black;
        display: inline-block;
        width: 180px;
        height: 180px;
        
       
    }
    #poto1{
        margin: autos;
    }
    .poto-area{
        margin-top: 20px;
  
    }
 
    #hashtagShow{
        margin-left: 300px;
    }
 
    .poto-area>div{
        margin-top: 5px;
        border-radius: 10px;
        display: inline-table;
    }
    
   
</style>


</head>
<body>

    <%@include file="../../admin/report/reportModal.jsp"%>
    
    <% if(loginUser == null){ 
        loginUser = new Member();
        loginUser.setNickname("");
    } %>
       
    
    
    
    
  
	

<div class="outer">
   
    
    
    <!---- 컨텐츠 사진 1개 시작 ---->
    
    
    <table  class="an_3"  width="100%"  >
        <thead>
            <tr colspan="6">
                <th style="padding-left: 20px; font-size: 25px;" >
                    <a href="<%= contextPath %>/handOver.list?hpage=1" style="text-decoration: none; color: #052159;"> 양도 게시판 ></a>
                   
                </th>
            </tr>
            <tr>
                <td colspan="6">카테고리 : <%= ho.getCategory() %></td>
            </tr> 

            <tr>
                <th colspan="6" style="padding-left: 20px;">
                  
                        게시글 제목 :  <%= ho.getBoardTitle() %>| 게시글 번호 <%= ho.getBoardNo()%>
                </th>
                    
            </tr>
            <tr id="nickName_area" style="padding-left: 20px;">
               
                <td style="padding-left: 20px; ">
                        닉네임 : <%= ho.getNickName() %><br>
                       <span style="font-size: 12px;"><%= ho.getCreateDate() %> | 조회수 <%= ho.getBoardCount() %></span> 
                </td>
            </tr>
        </thead>
        <tbody>
            
            <% if(!att.isEmpty()){ %>
            <tr>
                <td class="content" colspan="5" align="center" >
                    <table>
                    <tr class="upload_poto" >
                        <% for(int i = 0; i < att.size(); i++) {%>
                        <td>
                        <%if(att.get(i).getFileLevel() ==0){ %>
                        <img src="<%=contextPath%>/<%=att.get(i).getFilePath() %>" width="180" height="200"  >
                        <% } else{%>
                       
                        <img src="<%=contextPath%>/<%=att.get(i).getFilePath() %>" width="180" height="200">
                        <% } %>
                        </td>
                    <%}%> 
                    </tr>
                    </table>
                    
                    
                    
                </td>
                <%}%> 
            </tr>
            <tr id="content_area1">
                <td class="content" colspan="6" align="center">

                    <%= ho.getBoardContent() %>

                </td>
            <tr>

                

                <td colspan="6" id="hashtagShow"  style="color: #1d9bf0;">
                </td>
            </tr>

            
            </tr>

            <tr>
                <td colspan="2"></td>
                <td width="200">
                    
                    
                    <button type="button" class="btn-like" id="like_poto">


                            <span class="heart-shape"></span> 
                            <span class="like-count"></span> 


                    </button> 


                </td>

               
                <td >공유 이모지</td>
            </td>
         
            <%if(loginUser != null){%>
                <td id="report">
                         <img  class="reportImg" src="resources/thumbnail_upFiles/NoSweat_20230504052307_33605.png">
                </td>
                <%}else { %>
                    <td>
                        <img  class="reportImg" src="resources/thumbnail_upFiles/NoSweat_20230504052307_33605.png">
                        
                    </td>
                
            </tr>
            <%}%>
          
                
            </tr>
        </tbody>
    </table>
    
  

</div>
<div align="center">
    
    <button id="returnList"  class="actBtn" onclick="location.href='<%=contextPath%>/handOver.list?hpage=1'">목록으로 돌아가기</button>
    <!-- 로그인한 사용자고 현재 게시글이 작성자일 경우 수정하기 버튼을 보이게끔 -->
    <table class="bottom_bnt">

        <% if(loginUser != null && loginUser.getNickname().equals(ho.getNickName())) { %> 
            <tr aling="center" >
                <td colspan="6" aling="center">
                    <button id="update" type="button"  class="actBtn" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo"
                    data-bs-target="#exampleModal" >게시글 수정</button>
                </td>
                <td>
                    <form action="<%=contextPath%>/delete.ho" method="get">
                        <input type="hidden" name="boardNo" value="<%= ho.getBoardNo()%>">
                        <button  id="deleteAn" type="submit" class="actBtn1">게시글 삭제</button>
                    </form>
                </td>
            </tr>
        </table>
    <% } %>
        
</div>




<script>

    //---------------------------------------------------------------------------------
    //------------------------- 해시태그 불러 오기  ------------------------------------
    //---------------------------------------------------------------------------------  


        $(function(){

            $.ajax({
                url: 'hashtag.hs',
                data:{boardNo : <%=ho.getBoardNo()%>},
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



    </script>


<script>
    $(function(){
        if('<%=loginUser%>' != 'null'&& '<%=loginUser.getMemberNo()%>' >0) {
            $('#report').on('click',function(){
                $('#boardModal').modal('show');
                //---------------------게시글 신고하기---------------
                //여기는 게시판마다 각자 설정하면 넣을 수 있습니다 반드시 설정 바랍니다
                var userNo = '<%=ho.getMemberNo()%>';
                var boardNo = '<%=ho.getBoardNo()%>';
                var boardTitle = '<%=ho.getBoardTitle()%>';
                var boardType = 'F';
                var boardWriter = '<%=ho.getNickName()%>';
                
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

</script>
<!-- ♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡ 좋아요  기능 ♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡ -->
<!-- ♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡ 좋아요  기능 ♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡ -->
<!-- ♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡ 좋아요  기능 ♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡ -->

<script >



    // 처음 페이지 들어왔을때 loginUser.memberNo 와 
    // 페이지 로딩될때 BOARD_LIKE_POST에서 select해온 memberNo가 일치해하면 여기 좋아요를 했다는 뜻

    // 그러면 우선 select 문에 BOARD_LIKE_POST에서 select해온 memberNo를 추가해야함

    // 추가해서 두개 값 비교 후 같으면 체크되어있는 하트페이지로 아니면 반대로
    
    
  // =================== SELECT ===================================

    $(function(){
        
        selectLike();

    })    
    

    function selectLike(){

        $.ajax({
            url : 'selectLike.by',
            data : {
                
                boardNo :  <%= ho.getBoardNo() %>
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
                    boardNo : <%= ho.getBoardNo() %>
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
                boardNo : <%= ho.getBoardNo() %>
    
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

    

    <!-- -------------------------  댓글 역역      댓글 역역       댓글 역역      -------------------------- -->
    <!-- -------------------------  댓글 역역      댓글 역역       댓글 역역      -------------------------- -->
    
  <div id="reply-area-all">

      <% if(loginUser.getMemberNo() != 0){ %> 
    <!-- 로그인 했을 경우 -->

    <div id="reply-area" >
        <div style="margin-top: 7px;">
            <p>
                닉네임 : <%=loginUser.getNickname()%>
            </p>
        
        </div>
        <div >
            <textarea id="textarea_content" class="textarea" cols="50" placeholder="댓글을 남겨보세요"  style="resize: none;"></textarea>
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
                <textarea style="resize: none;" readonly class="textarea" placeholder="로그인 후 이용가능 합니다"></textarea>
            </div>
            <div id="reply_btn" >
                <span >
                    <button  class="actBtn" style="border: none;">등록</button>
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

function insertReply(){
        if($('.textarea').val() == ""){
            alert('내용을 입력해주세요!')
        }else{

            $.ajax({
                url : 'replyInsert.by',
                data : {
                    boardNo : <%= ho.getBoardNo() %>,
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
                boardNo : <%= ho.getBoardNo() %>
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
                                        +'<span class="reply_header" style="font-size:20px; padding-left: 10px;">'
                                        +  replyList[i].replyContent 
                                        +'</span>'
                                    +'<br>'
                                    
                                    
                                    +'<span class="span_class" style=" font-size:small; padding-left:5%; color:grey;" >'
                                        + '작성일 :'+ replyList[i].replyDate    + ' | ' 
                                        
                                        + '<button class="rereply_btn" style="border:none;"> 답글 </button>'+ ' | ' 
                                        + ' <img  class="reportImg" src="resources/thumbnail_upFiles/NoSweat_20230504052307_33605.png">'
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
                                                                    +'<button class="rereply_submit ancBtn" style="border: none;">'+'등록'+'</button>'
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

    $(function(){
        selectReplyList();

    });
//--------------------대댓글 스크립트--------------------
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

$('#replyList_table').on('click', '.rereply_cancel', function(){
       // console.log($(this).parents('tr'))
        $(this).parents('tr').toggle('fast');
    })

$('#replyList_table').on('click', '.rereply_submit', function(e){

if($(this).parent().parent().prev().children().val() == ""){
            alert('내용을 입력해주세요!')
}else{

    var $temp2 = $(this);

    // console.log($(this).next().val())

    $.ajax({
        url : 'insertReReply.by',
        data : {
             boardNo : <%= ho.getBoardNo() %>
            ,replyNo : $(this).next().val()
            ,rereplyContent : $(e.target).parent().parent().prev().children().val()
        
        

        },
        type : 'POST',
        success : function(rereplyResult){
        //alert('insert 성공')
        //console.log($temp)
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
                    cno : '<%= ho.getBoardNo() %>',
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
                var boardNo = '<%=ho.getBoardNo()%>';
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
   
<!-- modal -->

<div class="modal fade" id="exampleModal" tabindex="-1" data-bs-backdrop="static" data-bs-keyboard="false" aria-labelledby="exampleModalLabel" aria-hidden="true" >
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">양도 게시판 글수정</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
          
            <div class="modal-body" >
                <form action="<%= contextPath %>/update.ho" method="post" enctype="multipart/form-data">
                    <% if(loginUser != null) { %>
                        <input type="hidden" name="userNo" value="<%= loginUser.getMemberNo() %>">
                    <% } %>
                        <input type="hidden" name="boardNo" value="<%= ho.getBoardNo()%>">

                    <div class="category">
                      <!-- 카테고리(주제를 선택해주세요) -->
                         <select name="category" id="category" class="modal_form">
                                <option value="" ><%=ho.getCategory()%></option>
                                <option value="회원권">회원권</option>
                                <option value="운동기구">운동기구</option>
                                <option value="식품">식품</option>
                            </select>
                      <!-- 바디프로필과 익명은 카테고리를 hidden에 담아서 들구감 -->
                    </div>
                   
                <div class="title">
                  
                    <input type="text" id="title_div" placeholder="글 제목" maxlength=20 style="width:100%" 
                           name="title" class="modal_form" required value="<%= ho.getBoardTitle()%>">
  
                </div>
                <div id="div-tag">   
                    <div id="div-tag" style="display: flex;">
                      <input type="text" id="tag" size="20" placeholder="태그를 입력후 스페이스바를 눌러주세요" style="width:100%; margin: 10px;">
                    </div>
                    <ul id="tag-list">
                      <input type="hidden" name="tagState" value="no">
                    </ul>
                </div>
                <script>

                </script>


  
                <div class="content" >
                    <textarea style="resize: none; width: 100%; height: 500px"  placeholder="주제에 맞지 않는 글로 판단되어 다른 유저로부터 일정수 이상 신고를 받는 경우 자동으로 숨김처리 될 수 있습니다."
                              id="text11" name="content" class="modal_form" required><%= ho.getBoardContent()%></textarea>
                </div>
                <div>
                	<p>*양도하실 물건의 사진을 반드시 1장이상 첨부해주세요	</p>
                </div>
                  
                <div>
                    <hr>
                    <input type="button" name="poto" value="사진첨부" class="actBtn" id="poto-none" onclick="onOff();">
                    <input type="button" name="hashTag" value="해시태그" class="actBtn">
                    
                </div>
              
                <!-- 사진첨부수정시 미리보기해주는 곳 -->
                <!-- 만약 첨부파일이 비어있다면 -->
                <% if(att.isEmpty()){ %>
                    <div class="poto-area" align="center">
                        <div class="poto_zone" id="poto1">대표 이미지
                          <input type="file" name="reUpfile1" >
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
                <% } else if(att != null){%> <!-- 비어있지 않다면 -->
                    <!-- 대표이미지만 있다면 1장 첨부되었을 경우-->
                    <% if(att.size() == 1){ %>
                    <div class="poto-area" align="center">
                        <div class="poto_zone" id="poto1">대표 이미지 
                        <input type="hidden" name="originFileNo1" value="<%= att.get(0).getFileNo()%>">
                        <input type="hidden" name="originBoardNo1" value="<%= att.get(0).getBoardNo()%>">
                        <input type="hidden" name="originFileName1" value="<%= att.get(0).getOriginName()%>">
                        <img src="<%=contextPath%>/<%=att.get(0).getFilePath()%>" width="70px;" height="70px;">
                        <input type="file" name="reUpfile1"  value="<%= att.get(0).getOriginName()%>">
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
                    <% } else if(att.size() == 2) { %> <!--대표이미지한장 + 사진 한장이 있다면-->
                    <div class="poto-area" align="center">
                    <div class="poto_zone" id="poto1">대표 이미지 
                    <input type="hidden" name="originFileNo1" value="<%= att.get(0).getFileNo()%>">
                    <input type="hidden" name="originBoardNo1" value="<%= att.get(0).getBoardNo()%>">
                    <input type="hidden" name="originFileName1" value="<%= att.get(0).getOriginName()%>">
                    <img src="<%=contextPath%>/<%=att.get(0).getFilePath()%>" width="70px;" height="70px;">
                    <input type="file" name="reUpfile1" >
                    </div>
                        <% for(int i = 1; i < att.size(); i++) { %>
                            <div class="poto_zone" id="poto<%= i+1%>"><%= i + 1 %>번 이미지 
                            <input type="hidden" name="originFileNo<%=i+1%>" value="<%= att.get(i).getFileNo()%>">
                            <input type="hidden" name="originBoardNo<%=i+1%>" value="<%= att.get(i).getBoardNo()%>">
                            <input type="hidden" name="originFileName<%=i+1%>" value="<%= att.get(i).getOriginName()%>">
                            <img src="<%=contextPath%>/<%=att.get(i).getFilePath()%>" width="70px;" height="70px;">
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
                    <% } else if(att.size() == 3) { %> <!-- 대표이미지 한장 + 사진 2장이 있다면-->
                        <div class="poto-area" align="center">
                            <div class="poto_zone" id="poto1">대표 이미지 
                            <input type="hidden" name="originFileNo1" value="<%= att.get(0).getFileNo()%>">
                            <input type="hidden" name="originBoardNo1" value="<%= att.get(0).getBoardNo()%>">
                            <input type="hidden" name="originFileName1" value="<%= att.get(0).getOriginName()%>">
                            <img src="<%=contextPath%>/<%=att.get(0).getFilePath()%>" width="70px;" height="70px;">
                            <input type="file" name="reUpfile1" >
                            </div>
                            <% for(int i = 1; i < att.size(); i++) { %>
                                <div class="poto_zone" id="poto<%= i+1%>"><%= i + 1 %>번 이미지 
                                <input type="hidden" name="originFileNo<%=i+1%>" value="<%= att.get(i).getFileNo()%>">
                                <input type="hidden" name="originBoardNo<%=i+1%>" value="<%= att.get(i).getBoardNo()%>">
                                <input type="hidden" name="originFileName<%=i+1%>" value="<%= att.get(i).getOriginName()%>">
                                <img src="<%=contextPath%>/<%=att.get(i).getFilePath()%>" width="70px;" height="70px;">
                                <input type="file" name="reUpfile<%= i + 1 %>">
                                </div>
                            <% } %>
                            <div class="poto_zone" id="poto4">4번 이미지
                            <input type="file" name="reUpfile4">
                            </div> 
                        </div>
                    <% } else if(att.size() == 4) { %> <!-- 대표이미지 한장 + 사진 3장이 있다면 -->   
                        <div class="poto-area" align="center">
                            <div class="poto_zone" id="poto1">대표 이미지 
                            <input type="hidden" name="originFileNo1" value="<%= att.get(0).getFileNo()%>">
                            <input type="hidden" name="originBoardNo1" value="<%= att.get(0).getBoardNo()%>">
                            <input type="hidden" name="originFileName1" value="<%= att.get(0).getOriginName()%>">
                            <img src="<%=contextPath%>/<%=att.get(0).getFilePath()%>" width="70px;" height="70px;">
                            <input type="file" name="reUpfile1" >
                            </div>
                            <% for(int i = 1; i < att.size(); i++) { %>
                                <div class="poto_zone" id="poto<%= i+1%>"><%= i + 1 %>번 이미지 
                                <input type="hidden" name="originFileNo<%=i+1%>" value="<%= att.get(i).getFileNo()%>">
                                <input type="hidden" name="originBoardNo<%=i+1%>" value="<%= att.get(i).getBoardNo()%>">
                                <input type="hidden" name="originFileName<%=i+1%>" value="<%= att.get(i).getOriginName()%>">
                                <img src="<%=contextPath%>/<%=att.get(i).getFilePath()%>" width="70px;" height="70px;">
                                <input type="file" name="reUpfile<%= i + 1 %>">
                                </div>
                            <% } %>
                        </div>    
                    <% } %>             
                <% } %>       
                    
                
                <!-- 2번 부터 이미지가 비어있다면 새롭게 받을 수 있는 첨부파일 input을 만들어 준다-->




                <hr>
  
                <div class="modal-footer">
                 
                    <button type="submit" class="actBtn" id="submit">등록</button>
                    <button type="button" class="actBtn1" data-bs-dismiss="modal">닫기</button>
                </div>

                </form>
  
            </div>

        </div>

    </div>

</div>

<script>
  




    
</script>


<script>
    //---------------------------------------------------------------------------------
    //------------------------- 해시태그 등록 부분------------------------------------
    //---------------------------------------------------------------------------------
    
          
            $(function(){
                
               // const selectTag = [];
            
                $.ajax({
                    url: 'hashtag.hs',
                    data:{boardNo : <%=ho.getBoardNo()%>},
                    type: 'post',
                    success:function(hList){
                        console.log(hList);

                        var hashtag = '';
                       

                        for(var i in hList){

                            hashtag = 
                                    '<li class="tag-item"> <input type="hidden" name="hashT" value="'
                                        + (hList[i].hashtag.slice(1).trim()) +'">' + hList[i].hashtag.slice(1).trim() + '<span class="del-btn" idx="">x</span></li>'
                                    +'<li class="ht" style="display: inline-block; margin=auto">' ;
                                
                                        var tag = (hList[i].hashtag.slice(1).trim());
                                        console.log(tag);
                                        console.log("어디보자"+(hList[i].hashtag.slice(1).trim()) );
                                        addTag(tag);
                            
                            $('#tag-list').append(hashtag);     
                            //})
                        }       
                    },
                    error: function(){
                        console.log('실패!!')
                    }

                });
                
               
               var tag = {};
               var counter = 0;

              // 태그를 추가한다.
              function addTag(value) {
                tag[counter] = value; // 태그를 Object 안에 추가
                counter++; // counter 증가 삭제를 위한 del-btn 의 고유 id 가 된다.
              }

              //input태그 안에 값을 넣어서 넘긴다
              var $tagBtn = $('#tag-btn');
              
              $('#tag')
                .on('keyup', function (e) {
                  var self = $(this);
                  console.log('keypress');
                  
                  
                  // input 에 focus 되있을 때 엔터 및 스페이스바 입력시 구동
                  if ( e.keyCode == 32) {
                    //console.log($('#tag-btn').click );
                    
                    var tagValue = self.val().trim(); // 값 가져오기

                    // 값이 없으면 동작 안합니다.
                    if (tagValue !== "") {

                      // 같은 태그가 있는지 검사한다. 있다면 해당값이 array 로 return 된다.
                        var result = Object.values(tag).filter(function (word) {
                            return word === tagValue;
                        })
            
                      // 해시태그가 중복되었는지 확인
                            if (result.length == 0) { 
                             
                              $("#tag-list").append('<li class="tag-item"> <input type="hidden" name="hashT" value="'+ (tagValue.trim()) +'">' + tagValue + '<span class="del-btn" idx="'+counter+'">x</span></li>');
                              addTag(tagValue);
                              $.ajax({
                                url:'realTime.insertTag',
                                data:{'boardNo':<%=ho.getBoardNo()%>,
                                       'tagValue': tagValue.trim()},
                                success: function(result){
                                    console.log(result);
                                },
                                error:function(){
                                    console.log('실패');
                                }


                              });

                              self.val("");
                              $("#tag-list").children('input[name=tagState]').val('yes');
                              console.log($("#tag-list").children('input[name=tagState]').val());
                            } else {
                                  swal({
                                      title: "태그값 중복",
                                      text: "태그값이 중복되었습니다.",
                                      icon: "error" //"info,success,warning,error" 중 택1
                                  });
                            }
                      }
                         e.preventDefault(); // SpaceBar 시 빈공간이 생기지 않도록 방지
                  }
              });

                
              // 삭제 버튼
              // 삭제 버튼은 비동기적 생성이므로 document 최초 생성시가 아닌 검색을 통해 이벤트를 구현시킨다.
              $(document)
              .on("click", ".del-btn", function (e) {
                
                console.log($(this).parent().text().slice(0,-1));
                var target =  $(this).parent().text().slice(0,-1).trim();
               

                $.ajax({
                    url: 'update.hashtag',
                    data:{'target' :target,
                          'boardNo': <%=ho.getBoardNo()%>},
                    success: function(result){
                        console.log(result);
                    },
                    error: function(){
                        console.log('실패');
                    }

                });

                var index = $(this).attr("idx");
                tag[index] = "";
                    $(this)
                    .parent()
                    .remove();

               
            });
            
                    //enter키 입력 방지
                    $('input[type="text"]').keydown(function() {
                            if (event.keyCode === 13) {
                                event.preventDefault();
                            }
                        }); 
                })

          

        </script> 
   
   <br><br>
   <%@ include file="../../common/footer.jsp" %>
   
   <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>