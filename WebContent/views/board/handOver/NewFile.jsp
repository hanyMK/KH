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
<title>양도게시판 게시글</title>


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



    /* 대댓글 대댓글 */

    .rereply_area_2{
        margin-left: 20%;
        width: 700px;
      
    }


    .an_3{
        margin-top: 20px;
        padding-left: 5px;
        border-left: 1px solid gray;
        border-right: 1px solid gray;
        
    }
    #date_area{
        height: 5px;
    }
    #content_area1{
        height: 500px;
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

    #div-tag{
        display: none;
        
    }


     /*---신고 이미지 크기 ---*/
     .reportImg{
        width: 20px;
        height: 30px;
        padding: 0;
    }
    
/*------사진 첨부----------------*/
    .poto_zone{
        background-color: skyblue;
        border: 1px solid black;
        display: inline-block;
        width: 180px;
        height: 180px;
       
       }
       #poto-area{
        margin-top: 20px;
       }
       #poto-area{
        margin-top: 20px;
        display : none;
    }

   
   
</style>


</head>
<body>

    <%@include file="../../admin/report/reportModal.jsp"%>

    
   

   
   
<!---- 컨텐츠 사진 없을때개 ---->

<div class="outer">
   
    <!---- 컨텐츠 사진 1개 시작 ---->
    
    <table class="an_3" cellspacing="1" style="width:100%; background-color:#fff; font-family:Verdana, Geneva, '나눔고딕', NanumGothic, ng, '맑은 고딕', 'Malgun Gothic', '돋움', Dotum, AppleGothic, sans-serif;font-size:11px; padding:10px; border-spacing:0; letter-spacing:-1px; text-align:left; border-top:1px solid #eee; font-size: 12px;">
        <thead>
            <tr>
                <th colspan="6">양도게시판</th>
            </tr>
            <tr>
                <td colspan="6">카테고리 : <%= ho.getCategory() %></td>
            </tr>    
            <tr>
                <th colspan="6">제목 <%= ho.getBoardTitle() %> | 게시글 번호 <%= ho.getBoardNo()%></th>
            </tr>
            <tr>
                <td colspan="2">간단이미지/캐릭터</td>
                <td colspan="4"><%= ho.getNickName() %></td>
            </tr>
            <tr>
                <td colspan="6"><%= ho.getCreateDate() %> | 조회수 <%= ho.getBoardCount() %></td>
               
            </tr>
            
            
        </thead>
        <tbody>
            
  			 <% if(!att.isEmpty()){ %>
               
             <tr>
                   <td colspan="6">
                <% for(int i = 0; i < att.size(); i++) {%>
                           
                 <img src="<%=contextPath%>/<%=att.get(i).getFilePath()%>" alt="" width="200px;">
                           
                  <% } %>
	                </td>
	            </tr>
              <% } %>
            <tr>
                <td class="content" colspan="6"  height="200" align="center">
                    <%= ho.getBoardContent() %>
                </td>
            
            </tr>
            <tr>
                <td id="hashtagShow" colspan="6" style="color: #1d9bf0;">
                  <!-- <form name="searchTag" action="searchTag.hs" method="post" > -->

                      <ul>
                          
                    </ul>
                <!-- </form> -->
                
                </td>
              
            <a href="<%=contextPath%>/list.an?cpage=1">목록으로</a>
            </tr>
            <%if(loginUser != null){%>
                <td id="report">
                        <img class="reportImg" src="resources/thumnail_upFiles/NoSweat_20230429203510_27544.png">'
                </td>
                <%}else { %>
                    <td>
                        <img class="reportImg" src="resources/thumnail_upFiles/NoSweat_20230429203510_27544.png">'
                        
                    </td>
                
            </tr>
            <%}%>
            
             <% if(loginUser != null && loginUser.getNickname().equals(ho.getNickName())) { %> 
                    <tr aling="center" >
                    <td colspan="3" aling="center">
                        <button  type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo"
                    data-bs-target="#exampleModal" >게시글 수정</button>
                    </td>
                    <td colspan="3" aling="center">
                        <form action="<%=contextPath%>/delete.ho" method="get">
                            <input type="hidden" name="boardNo" value="<%= ho.getBoardNo()%>">
                            <button type="submit" class="btn btn-sm btn-danger">게시글 삭제</button>
                        </form>
                    </td>
                    </tr>
                <% } %>
            </tbody>
    </table>
    <!---- 컨텐츠 사진 4개 끝 ---->


    <script>
        $(function(){
            $('.reportImg').on('click',function(){
                $('#boardModal').modal('show');
                //---------------------게시글 신고하기---------------
                //여기는 게시판마다 각자 설정하면 넣을 수 있습니다 반드시 설정 바랍니다
                var userNo = '<%=ho.getMemberNo()%>';
                var boardNo = '<%=ho.getBoardNo()%>';
                var boardTitle = '<%=ho.getBoardTitle()%>';
                var boardType = 'F';
                var boardWriter = '익명';
                
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
            
        });

</script>



<br><br><br><br>


             <!-- -------------------------댓글 역역 -------------------------- -->
    
             <div id="reply-area-all">

                <% if(loginUser != null) { %>
                <!-- 로그인 했을 경우 -->
            
                <div id="reply-area" >
                    <div style="margin-top: 7px;">
                       
                    </div>
                    <div>
                        <textarea width="300" id="textarea_content" class="textarea" cols="50" placeholder="댓글을 남겨보세요"></textarea>
                    </div>
                    <div id="reply_btn" >
                        <span >
                            <button style="border: none;" onclick="insertReply();">등록</button>
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
                                                <!-- 여기서부터는 댓글 내용 LIST -->
            
                        <div>
                            <table border="1" align="center" width="800" id="replyList_table">
                                <tbody>
            
            
                                   <!-- 여기가 댓글LIST자리 -->
            
                                   
                                   <tr>
                                       <td align="center" colspan="3">
                                               여기는 플러스버튼 누르면 10개댓글이 더 보이게
                                       </td>
                                   </tr>
                                </tbody>
                            </table>        
                        </div>       
            
                </div>
            
            
            
            
                
                <script>
                    // 댓글 기능 넘겨줘야할 것들 : 게시글 번호, 회원아이디, 댓글내용
                    // 아이디는 여기서 안넘겨도 session에 담아놨으므로 controller에서 뽑아오면 된다.
                  
                    function insertReply(){
                        $.ajax({
                            url : 'replyInsert.re',
                            data : {
                                boardNo : <%= ho.getBoardNo() %>,
                                replyContent : $('#textarea_content').val()
                            },
                            type : 'post',
                            success : function(result){
                                alert('댓글작성완료')
                                console.log(result);
                                
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
            
                    
                    function selectReplyList(){
                        $.ajax({
                            url : 'listReply.re',
                            data : {
                                boardNo : <%= ho.getBoardNo() %>
                            },
                            success : function(replyList){
                                
                                //console.log(replyList);
                                //console.log(listAll);
                                
                                // 댓글 개수만큼 반복을 해준다
                             
                                
                                let result = '';
                                for(let i in replyList){
                                    result +='<tr>'
                                        + '<td width="400px">'
                                            
                                            
                                            + '[닉네임 : '+ replyList[i].nickName + ' ] :' +  replyList[i].replyContent     
                                            +'</td>'
                                            +'<td  style="font-size: small;">'
                                                + '작성일 :'+ replyList[i].replyDate + ' | ' +  '좋아요' + replyList[i].replyLikeCount + '|' +' 싫어요' + replyList[i].replyDislikeCount + '|' + '답글'+ '|' 
                                                +'</td>'
                                                +'<td class="reply-report" style="font-size: small;">'
                                                +'<input type="hidden" name="replyNo" value="'+replyList[i].replyNo+'">'
                                                +'<input type="hidden" name="userNo" value="'+replyList[i].memberNo+'">'
                                                +'<img class="reprotImg" src="resources/thumnail_upFiles/NoSweat_20230429203510_27544.png">'
                                                +'</td>'
                                                + '</tr>';
                                                
                                            };
                                            
                                            $('#replyList_table>tbody').html(result);
                                            //덧글 번호는 여기서 넣어주세요
                                            
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
                                
                                </script>
                                    
                       <script>
            
            
                        //---------------------댓글 신고하기---------------
                        $(function(){
                            $('#replyList_table>tbody').on('click','.reply-report', function(e){
                                
            
                                    $('#replyModal').modal('show');
                                    
                                    
                                //여기는 게시판마다 각자 설정하면 넣을 수 있습니다 반드시 설정 바랍니다
                                var userNo = $(e.target).children().eq(1).val();
                                //console.log( $(e.target).children().children());
                                var boardNo = '<%=ho.getBoardNo()%>';
                                var replyNo = $(e.target).children().eq(0).val();
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
                        });
            
                </script>


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
                        $('#hashtagShow').children().append(hashtag);     
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

<%@ include file="../../common/footerbar.jsp" %>




<br><br>
</body>
</html>