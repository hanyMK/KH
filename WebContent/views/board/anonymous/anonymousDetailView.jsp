<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.ArrayList, com.kh.board.anonymous.model.vo.SelectAll,com.kh.common.model.vo.*, com.kh.board.challenge.model.vo.*" %>
    
    
  <%
  
    ArrayList<SelectAll> all = (ArrayList<SelectAll>)request.getAttribute("all");
   
    	ChallengeVoteTitle cvt = (ChallengeVoteTitle)request.getAttribute("cvt");
 	
 	ArrayList<ChallengeVoteQuery> queryList = (ArrayList<ChallengeVoteQuery>)request.getAttribute("queryList");
  	
  	
  %>  
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>익명게시판 게시글</title>


<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
<title>Bootstrap Example</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
   <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
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
            width:1200px;
            margin-left:500px;
           
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
        /*게시글 없을때*/
        #textMsg{
        pointer-events: none;
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
            padding:0;
            margin:5px;
        }
        .title>input{
            border: 1px solid black;
        }
        #textarea{
            border : 1px solid black;
        }
        
        
        
        .rereply_textarea{
	        width: 400px;
	        display: none;
  
	    }
	    .reply_area3{
	        height: 30px;
	        border-bottom: 1px solid gray;
	    }
	    .rereplyggg{
	        background-color: #f2f2f3;
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
    
        /*============투표 ==============*/
        .vote-area_1{
           width:500px;
           margin-left: 150px;
        }
        #vote-title{
            font-size: 20px;
            color: #052159;
            background-color: #C2E5F2;
        }
        .voteType{
            padding-bottom: 5px;
            padding-top: 5px;
        }
        .voteType>div{
            display:inline;
            padding-left: 10px;
        }
        .vote-count222{
            text-align: right;
        }

        #hashtagShow{
        margin-left: 300px;
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
    .poto-area>div{
        margin-top: 5px;
        border-radius: 10px;
        display: inline-table;
    }
    
    .vote-area{
        display : none;
    }
    .boardContent{
        background-color: #B3DAF2;
        border-radius: 10px;
        width:790px;
        height:200px;
        margin:10px;
        box-shadow: 2px 2px 2px 2px grey;
    }
    .boardContent:hover{
        background-color: #8db7ee;
    }
    .contentimg{
        background-color:#8db7ee;
        text-align: center; 
        float :left; 
        display:inline-block;
    }
    .textcontent{
        background-color: #fff;
        border-radius: 10px;
        border-style: groove;
        display : inline-block;
        width : 450px;
        height : 120px;
        overflow: hidden;
        text-overflow: ellipsis; /* 넘어가는 건 … 처리 */
        white-space  : normal; 
    }
   
    table{
        margin-left:auto;
        margin-right:auto;
        vertical-align: middle;
        margin-top:15px;
        margin-bottom: auto;
    }
    .contentTitle{
        display:flex;
        font-size: 25px;
        color: #052159;
        padding-left:10px ;
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
    
    
    <div class="listTag" >
        <br>
            <div id="listTag">
                 <a href="<%= contextPath %>" style="text-decoration: none; color: #052159;"> 익명게시판 ></a>
            </div>
                   
            <hr>

           
            <div id="title">
                <%=all.get(0).getBoardTitle() %>
            </div>
            <div id="userNickname">
                 익명
            </div>
            <br>
            <div id="createDate"><%=all.get(0).getCreateDate() %> </div> |
            <div id="boardCount">조회수 <%=all.get(0).getBoardCount()%></div>
            <hr>
            <div align="center" class="imgContent">
                <%if(all.get(0).getFileNo()>0){%>
                <%for(int i = 0; i <all.size(); i++){%> 
                        <img src="<%=contextPath%>/<%=all.get(i).getFilePath() %>"  alt="게시글 파일레벨" width="300px;" height="300px;" class="imgContent">
                    <% } %>
                <% } %>
            </div>
            <br>
            <div id="boardContent">
                <%=all.get(0).getBoardContent() %>
            </div>
          
            <% if(cvt.getVoteTitle() == null) { %>
                <div class="vote-area_1"></div>
            <% } else { %>
                <% if(cvt != null) { %>
                <div class="vote-area_1">
                    <div id="vote-title">
                        <%= cvt.getVoteTitle() %>
                    </div>
                    <% if(queryList.isEmpty()) { %>
                        <div id="vote-title">
                            투표 항목없음
                        </div>
                        <% } else if(cvt.getVoteDupli().equals("N  ")){ %>
                            <div>
                                <% for(ChallengeVoteQuery cvq : queryList) { %>
                                    <div class="voteType">
                                        <div class="vote-button">
                                            <input type="radio" name="vote" value="<%= cvq.getVoteType()%>">
                                        </div>
                                        <div class="vote-question">
                                            <%= cvq.getQuestion() %>
                                        </div>
                                        <div class="vote-count">
                                            <div class="vote-count222">
                                                <%= cvq.getVoteCount() %>
                                            </div>
                                        </div>
                                    </div>
                                <% } %>
                                    <% if(loginUser.getMemberNo()>0 && loginUser != null) { %> 
                                        <div class="vote-button">
                                            <button onclick="increaseVote();" class="actBtn">투표하기</button>
                                        </div>
                            <% } %>    
                            </div>
                        <% } else if(cvt.getVoteDupli().equals("Y  ")) { %>   
                        <div>
                            <% for(ChallengeVoteQuery cvq : queryList) { %>    
                                    <div class="voteType">
                                        <div class="vote-button">
                                            <input type="checkbox" name="vote" class="dupli" value="<%= cvq.getVoteType()%>">
                                        </div>
                                        <div class="vote-question">
                                            <%= cvq.getQuestion() %>
                                        </div>
                                        <div class="vote-count">
                                            <div class="vote-count222">
                                                <%= cvq.getVoteCount() %>
                                            </div>
                                        </div>
                                    </div>
                            <% } %>  
                            <% if(loginUser.getMemberNo()>0  && loginUser != null) { %> 
                                    <div class="vote-button">
                                        <button onclick="dupliIncrease();" class="actBtn">투표하기</button>
                                    </div> 
                            <% } %>    
                        </div>
                        <% } %>    
                    <% } %> 
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
</div>
          
             <br>
             

    <div id="button-area" align="center">
        <button id="returnList" class="actBtn" onclick="location.href='<%=contextPath%>'">목록으로 돌아가기</button>
    <!-- 로그인한 사용자고 현재 게시글이 작성자일 경우 수정하기 버튼을 보이게끔 -->

        <% if(loginUser != null && loginUser.getMemberNo() == all.get(0).getMemberNo()) { %> 
                
        
            <button id="deleteAn" class="actBtn1" onclick="location.href='<%=contextPath%>/delete.an?bno=<%=all.get(0).getBoardNo()%>'" >게시글 삭제</button>
        
        <% } %>
        
    </div>





<script>

    //---------------------------------------------------------------------------------
    //------------------------- 해시태그 불러 오기  ------------------------------------
    //---------------------------------------------------------------------------------  


        $(function(){

            $.ajax({
                url: 'hashtag.hs',
                data:{boardNo : <%=all.get(0).getBoardNo()%>},
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

//========투표 insertAjax==========
        function temporarySave(){

$.ajax({
    url : 'temporarySave.cl',
    data : {
        title : $('#title_div').val(),
        content : $('#textarea').val(),
        voteTitle : $('input[name=voteTitle]').val(),
        voteQuery1 : $('input[name=query1]').val(),
        voteQuery2 : $('input[name=query2]').val(),
        voteQuery3 : $('input[name=query3]').val(),
        voteQuery4 : $('input[name=query4]').val(),
        voteQuery5 : $('input[name=query5]').val(),
        file1 : $('#poto1').val(),
        file2 : $('#poto2').val(),
        file3 : $('#poto3').val(),
        file4 : $('#poto4').val()
    },
    type : 'post',
    success : function(result){
        if(result > 0){

            window.alert('임시저장 성공!!!!');
        }
    },
    error : function(){
        window.alert('임시저장 실패 ㅠㅠ');
    }
});
}
function saveLoad(){

}

function increaseVote(){

var radio = $('input[name=vote]:checked');
var voteType = radio.val();

$.ajax({
    url : 'increaseVote.cl',
    data : {
        memberNo : '<%= loginUser.getMemberNo() %>',
        voteType : voteType,
        voteNo : '<%= cvt.getVoteNo() %>'
    },
    type : 'get',
    success : function(result){
        if(result > 0){
            window.alert('투표 성공~~');
            location.reload();
        }
    },
    error : function(){
        window.alert('투표 실패 ㅠㅠ');
    }
});
}
function dupliIncrease(){

var checkboxArr = new Array();

var checkboxArr = $('.dupli:checked');

var voteTypes = []; 
for(var i = 0;  i < checkboxArr.length; i++){
    if( checkboxArr[i].checked == true) {
        voteTypes.push(checkboxArr[i].value);
    }
}

console.log(voteTypes);
$.ajax({
    url : 'dupliIncrease.cl',
    data : {
        memberNo : '<%= loginUser.getMemberNo() %>',
        voteNo : '<%= cvt.getVoteNo() %>',
        voteType : voteTypes.join(',')
    },
    type : 'get',
    success : function(result){
        if(result > 0){
            window.alert('투표 성공~~');
            location.reload();
        }
    },
    error : function(){
        window.alert('투표 실패 ㅠㅠ');
    }
});
}
       



    </script>


<script>
    $(function(){
        if('<%=loginUser%>' != 'null'&& '<%=loginUser.getMemberNo()%>' >0) {
            $('#report').on('click',function(){
                $('#boardModal').modal('show');
                //---------------------게시글 신고하기---------------
                //여기는 게시판마다 각자 설정하면 넣을 수 있습니다 반드시 설정 바랍니다
                var userNo = '<%=all.get(0).getMemberNo()%>';
                var boardNo = '<%=all.get(0).getBoardNo()%>';
                var boardTitle = '<%=all.get(0).getBoardTitle()%>';
                var boardWriter = '익명';
                var boardType = 'B';
                
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
                //신고보드 타입전달
                $('.board-report-modal-body .writer').children('input[name=boardType]').val(boardType);
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
                
                boardNo :  <%= all.get(0).getBoardNo() %>
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
                    boardNo : <%= all.get(0).getBoardNo() %>
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
                boardNo : <%= all.get(0).getBoardNo() %>
    
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

    <% if(loginUser != null) { %>
    <!-- 로그인 했을 경우 -->

    <div id="reply-area" >
        <div style="margin-top: 7px;">
            <p>
                닉네임 : 익명
            </p>
        
        </div>
        <div >
            <textarea id="textarea_content" class="textarea" cols="50" placeholder="댓글을 남겨보세요" style="resize: none;"></textarea>
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
                    <button  calss="actBtn" style="border: none;">등록</button>
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
                        boardNo : <%= all.get(0).getBoardNo() %>,
                       replyContent : $('#textarea_content').val()
                    },
                    type : 'post',
                    success : function(result){
                        alert('댓글작성완료')
                        //console.log(result);
                        
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
                    boardNo : <%= all.get(0).getBoardNo() %>
                },
                success : function(replyList){
                    
                    //console.log(replyList);
                    //console.log(listAll);
                    
                    // 댓글 개수만큼 반복을 해준다
                   //console.log(replyList)
                   var memberNo = '<%= loginUser.getMemberNo() %>';
                    let result = '';
                    var str='';
                    for(let i in replyList){
                        var memberNo = '<%=loginUser.getMemberNo()%>';
                        result +=   '<tr class="reply_area3">'
                                    + '<td>'
                                        +'<span class="reply_header" style="font-size:20px; padding-left: 15px; ">'
                                            //+ 'No : ' + replyList[i].replyNo  +  
                                            + '익명' + ' : ' 
                                         +'</span>'
                                         +'<span class="reply_header" style="font-size:20px; padding-left: 15px;">'
                                            +  replyList[i].replyContent 
                                         +'</span>'
                                        +'<br>'
                                        
                                        
                                        +'<span class="span_class" style=" font-size:small; padding-left:5%" >'
                                            + '작성일 :'+ replyList[i].replyDate    + ' | ' 
                                            
                                            + '<button  class="rereply_btn actBtn" style="border:none;">답글</button>'+ ' | '
                                            + '<input class="hidden_3"  type="hidden" value="'+ replyList[i].replyNo + '" >'
                                         +'</span>'
                                            +'<input type="hidden" name="replyNo" value="'+replyList[i].replyNo+'">'
                                            +'<input type="hidden" name="userNo" value="'+replyList[i].memberNo+'">'
                                            +' <img  class="reportImg" src="resources/thumbnail_upFiles/NoSweat_20230504052307_33605.png">'
                                           
                                        +'</td>'
                                    +'</tr>'  



                                       + '<tr class="rereplyggg">'
                                        
                                        

                                       + '</tr>'     
                                   


                                  
                        // 답글 버튼 눌렀을때 구역
                           +  '<tr class="rereply_textarea">'  
                                        + '<td>'
                                        + '<div>'
                                            + '<div style="margin-top: 7px;">'
                                               + '<p>'
                                                   + '닉네임 :'+ '익명'
                                                +'</p>'
                                            +'</div>'

                                           +' <div>'
                                                +'<textarea style="resize:none;" class="textarea_submit" cols="50" placeholder="댓글을 남겨보세요">' + '</textarea>'
                                           +' </div>'
                                            +'<div >'

                                                +'<span >'
                                                    +'<button  class="rereply_cancel actBtn1" style="border: none;">'+'취소'+'</button>'
                                                    +'<button  class="rereply_submit actBtn1" style="border: none;">'+'등록'+'</button>'
                                                    +'<input type="hidden" value="'+ replyList[i].replyNo + '"></input>'
                                                + '</span>'
                                            
                                            +'</div>'

                                       + '</div>'
                                       + '</td>'
                                   + '</tr>';


            

                        
                    };//for문 닫힘
                    
                    $('#replyList_table>tbody').html(result);


                   
               
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

    console.log('제발')
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
                            + '<span width="400px"  class="reply_header" style="font-size:20px; padding-left: 10px; ">'
                                + '[ ' + rereplyList[i].nickName + ' ] : ' +  rereplyList[i].reReplyContent 
                            +'</span>'
                        +'</td>'
                        
                        
                        +'<td >'
                            +'<span>'
                                + '작성일 :'+ rereplyList[i].reReplyDate + ' | ' 
                                +'</span>'
                                +' <img  class="reportImg" src="resources/thumbnail_upFiles/NoSweat_20230504052307_33605.png">'
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

                     boardNo : <%= all.get(0).getBoardNo() %>
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
                                + '<span width="400px"  class="reply_header" style="font-size:20px; padding-left: 10px; ">'
                                    + '[ ' + rereplyList[i].nickName + ' ] : ' +  rereplyList[i].reReplyContent 
                                +'</span>'
                            +'</td>'
                            
                            
                            +'<td >'
                                +'<span>'
                                    + '작성일 :'+ rereplyList[i].reReplyDate + ' | ' 
                                +'</span>'
                                +' <img  class="reportImg" src="resources/thumbnail_upFiles/NoSweat_20230504052307_33605.png">'
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


    //---------------------댓글 신고하기---------------
    $(function(){

        if('<%=loginUser%>' != 'null' && '<%=loginUser.getMemberNo()%>' >0) {
            $('#replyList_table>tbody').on('click','.reportImg', function(e){
                

                    $('#replyModal').modal('show');
                    
                    
                //여기는 게시판마다 각자 설정하면 넣을 수 있습니다 반드시 설정 바랍니다
                var userNo = $(this).siblings('input[name=userNo]').val();
                console.log( $(this).siblings('input[name=memberNo]').children());
                var boardNo = '<%=all.get(0).getBoardNo()%>';
                var replyNo = $(this).siblings('input[name=replyNo]').val();
                var boardType = 'B';
                console.log("리플번호"+replyNo);
                console.log("사용자 번호"+userNo);
                console.log(boardType);
                //신고할 게시글 번호
                $('.reply-report-modal-body .writer').children('input[name=boardNo]').val(boardNo);
                //신고할 덧글 번호 전달
                $('.reply-report-modal-body .writer').children('input[name=replyNo]').val(replyNo);
                //신고대상자 멤버번호 전달
                $('.reply-report-modal-body .writer').children('input[name=attacker]').val(userNo);
                //신고보드 타입전달
                $('.board-report-modal-body .writer').children('input[name=boardType]').val(boardType);
            
            })
        }
    });

</script>
   
  </div>
  <div></div>
   <br><br>
   <%@ include file="../../common/footer.jsp" %>
   
   <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>