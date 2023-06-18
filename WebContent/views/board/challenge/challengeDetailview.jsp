<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.board.challenge.model.vo.*" %>
    
 <%
    ArrayList<ChallengeAttachment> clList = (ArrayList<ChallengeAttachment>)request.getAttribute("clList");    
        
    ChallengeBoard cB = (ChallengeBoard)request.getAttribute("cB");
    
    ChallengeVoteTitle cvt = (ChallengeVoteTitle)request.getAttribute("cvt");
    
    ArrayList<ChallengeVoteQuery> queryList = (ArrayList<ChallengeVoteQuery>)request.getAttribute("queryList");
 %>  
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>challenge detail</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>  
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>  
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
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
        .vote-area{
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
        margin-left: 1200px;
    }
    
    /*listsArea*/
    #listsArea{
    margin-left:500px;
    }
        
        
    </style>
    

</head>
<body>

    
    <%@include file="../../admin/report/reportModal.jsp"%>

    
    <% if(loginUser == null){ 
        loginUser = new Member();
        loginUser.setNickname("");
    } %>
   
   

   
   
<!---- 컨텐츠 사진 없을때개 ---->



   
<div class="outer">
    <br>
    <div id="listTag">
        <a href="<%=contextPath%>/challengeList.cl?cpage=1">챌린지 게시판 ></a>
    </div>
    <hr>
    <div id="title">
        <%= cB.getBoardTitle() %>
    </div>
    <div id="userNickname">
        <%= cB.getNickName() %>
    </div>
    <br>
    <div id="createDate"><%= cB.getCreateDate() %></div> |
    <div id="boardCount">조회수 <%= cB.getBoardCount() %></div>

    <div align="center" class="imgContent">
        <% if(!clList.isEmpty()){ %>
            <% for(int i = 0; i < clList.size(); i++) {%>
                <img src="<%=contextPath%>/<%=clList.get(i).getFilePath()%>/<%=clList.get(i).getChangeName()%>" alt="게시글 파일레벨" width="300px;" height="300px;" class="imgContent">
            <% } %>
        <% } %>
    </div>
    <br>
    <div id="boardContent">
    <pre>
        <%= cB.getBoardContent() %>
    </pre>
    </div>
    <% if(cB.getVoteYN().equals("N  ")){ %>
        <div class="vote-area"></div>
    <% } else { %>
        <% if(cvt != null) { %>
        <div class="vote-area">
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
                            <% if(!loginUser.getNickname().equals("") && loginUser != null) { %> 
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
                    <% if(!loginUser.getNickname().equals("") && loginUser != null) { %> 
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
        <div id="listsArea">
       
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
    
        <hr>
    <div id="button-area" align="left">
        <button class="actBtn button-area" onclick="location.href='<%=contextPath%>/challengeList.cl?cpage=1'">목록으로</button>
        <% if(loginUser != null && loginUser.getNickname().equals(cB.getNickName())) { %> 
                <button type="button" class="actBtn button-area" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo"
                         data-bs-target="#exampleModal" >게시글 수정</button>
                <form action="<%=contextPath%>/challengeDelete.cl" method="get" class="button-area">
                    <input type="hidden" name="boardNo" value="<%= cB.getBoardNo()%>">
                    <button type="submit" class="actBtn1 button-area">게시글 삭제</button>
                </form>
        <% } %>
    </div>
     </div>
    <hr>
</div>
   <br>
     
    <!---- 컨텐츠 사진 4개 끝 ---->
</div>

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
            <textarea style="resize: none;" id="textarea_content" class="textarea" cols="50" placeholder="댓글을 남겨보세요"></textarea>
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
                <button class="actBtn" style="border: none;">등록</button>
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
    $(function(){
        if('<%=loginUser%>' != 'null' && '<%=loginUser.getMemberNo()%>' >0) {
            $('#report').on('click',function(){
                $('#boardModal').modal('show');
                //---------------------게시글 신고하기---------------
                //여기는 게시판마다 각자 설정하면 넣을 수 있습니다 반드시 설정 바랍니다
                var userNo = '<%= cB.getMemberNo()%>';
                var boardNo = '<%= cB.getBoardNo()%>';
                var boardTitle = '<%= cB.getBoardTitle()%>';
                var boardWriter = '<%= cB.getMemberNo()%>';
                var boardType = 'D';
                
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


<script>
    //---------------------댓글 스크립트-------------------------
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
                        boardNo : <%= cB.getBoardNo() %>,
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
                    boardNo : <%= cB.getBoardNo() %>
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
                                            
                                            + '<button class="rereply_btn ancBtn" style="border:none;"> 답글 </button>'+ ' | ' 
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
                                                                    +'<textarea class="textarea_submit" cols="50" placeholder="댓글을 남겨보세요">' + '</textarea>'
                                                            +' </div>'

                                                            +'<div >'

                                                                    +'<span >'
                                                                        +'<button class="rereply_cancel" style="border: none;">'+'취소'+'</button>'
                                                                        +'<button class="rereply_submit" style="border: none;">'+'등록'+'</button>'
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
                                    + '작성일 :'+ rereplyList[i].reReplyDate + ' | ' 
                                    + ' <img  class="reportImg" src="resources/thumbnail_upFiles/NoSweat_20230504052307_33605.png">'
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
                 boardNo : <%= cB.getBoardNo() %>
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
                                    + '작성일 :'+ rereplyList[i].reReplyDate + ' | ' + 
										+' <img  class="reportImg" src="resources/thumbnail_upFiles/NoSweat_20230504052307_33605.png">'
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

    //---------------------댓글 신고하기---------------
    $(function(){

        if('<%=loginUser%>' != 'null' && '<%=loginUser.getMemberNo()%>' > 0) {
            $('#replyList_table>tbody').on('click','.reportImg', function(e){
                

                    $('#replyModal').modal('show');
                    
                    
                //여기는 게시판마다 각자 설정하면 넣을 수 있습니다 반드시 설정 바랍니다
                var userNo = $(this).siblings('input[name=userNo]').val();
                console.log( $(this).siblings('input[name=memberNo]').children());
                var boardNo = '<%= cB.getBoardNo()%>';
                var replyNo = $(this).siblings('input[name=replyNo]').val();
                var boardType = 'D';
                console.log("리플번호"+replyNo);
                console.log("사용자 번호"+userNo);
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

    // -------------------------- 좋아요 -------------------------
    $(function(){
        
        selectLike();

    })    
     // =================== SELECT ===================================
    function selectLike(){

        $.ajax({
            url : 'selectLike.by',
            data : {
            boardNo :  <%= cB.getBoardNo() %>
            },
            success : function(likeCount){
            $('#like_poto').children().eq(0).html('♡');
            $('.like-count').html(likeCount[0].boardLikeCount);         // 좋아요 수 
        <% if(loginUser.getMemberNo() != 0){ %>
            var userNo = <%= loginUser.getMemberNo() %>
            for(var i in likeCount){
                if(userNo == likeCount[i].memberNo){
                    // alert('좋아요 기록있음')
                    $('#like_poto').children().eq(0).html('♥');break; // 좋아요 기록이있는 유저는 하트채우기
                }
                else{
                    $('#like_poto').children().eq(0).html('♡');
                }
            }
                $('#like_poto').one("click", function(){
                    if($('#like_poto').children().eq(0).html()=='♥'){
                        deleteLike()
                    }
                    else  if($('#like_poto').children().eq(0).html()=='♡') {
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
    
        $.ajax({
            url : 'insertLike.by',
            data : {
                boardNo : <%= cB.getBoardNo() %>
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
    }
    // ======================= DELETE =========================
    function deleteLike(){
    
        $.ajax({
            url : 'deleteLike.by',
            data : {
            boardNo : <%= cB.getBoardNo() %>
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
   




<br><br><br><br>

<%@ include file="../../common/footer.jsp" %>

<!-- modal -->

<div class="modal fade" id="exampleModal" tabindex="-1" data-bs-backdrop="static" data-bs-keyboard="false" aria-labelledby="exampleModalLabel" aria-hidden="true" >
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">챌린지 게시판 글수정</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
          
            <div class="modal-body" >
                <form action="<%= contextPath %>/updateChallenge.cl" method="post" enctype="multipart/form-data">
                    <% if(loginUser != null) { %>
                        <input type="hidden" name="userNo" value="<%= loginUser.getMemberNo() %>">
                    <% } %>
                        <input type="hidden" name="boardNo" value="<%= cB.getBoardNo()%>">

                    <div class="category">
                      <!-- 카테고리(주제를 선택해주세요) -->
                        <select name="category" id="category" class="modal_form" >
                            <option value="기본" >주제를 선택해주세요</option>
                            <option value="맨몸운동">맨몸운동</option>
                            <option value="다이어트">다이어트</option>
                            <option value="기타">기타</option>
                        </select>
                      <!-- 바디프로필과 익명은 카테고리를 hidden에 담아서 들구감 -->
                    </div>
                    <br>
                <div class="title">
                  
                    <input type="text" id="title_div" placeholder="글 제목" maxlength=20 style="width:100%" 
                           name="title" class="modal_form" required value="<%= cB.getBoardTitle()%>">
  
                </div>
  
                <div class="content" >
                
                    <textarea style="resize: none; width: 100%; height: 100%"  placeholder="주제에 맞지 않는 글로 판단되어 다른 유저로부터 일정수 이상 신고를 받는 경우 자동으로 숨김처리 될 수 있습니다."
                              id="textarea" name="content" class="modal_form" required><%= cB.getBoardContent()%></textarea>
                </div>
                  
                <div>
                    <hr>
                    <input type="button" name="poto" value="사진첨부" class="actBtn" id="poto-none" onclick="onOff();">
                    <input type="button" name="hashTag" value="해시태그" class="actBtn">
                    
                </div>
              
                <!-- 사진첨부수정시 미리보기해주는 곳 -->
                <!-- 만약 첨부파일이 비어있다면 -->
                <% if(clList.isEmpty()){ %>
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
                <% } else if(clList != null){%> <!-- 비어있지 않다면 -->
                    <!-- 대표이미지만 있다면 1장 첨부되었을 경우-->
                    <% if(clList.size() == 1){ %>
                    <div class="poto-area" align="center">
                        <div class="poto_zone" id="poto1">대표 이미지 
                        <input type="hidden" name="originFileNo1" value="<%= clList.get(0).getFileNo()%>">
                        <input type="hidden" name="originBoardNo1" value="<%= clList.get(0).getBoardNo()%>">
                        <input type="hidden" name="originFileName1" value="<%= clList.get(0).getOriginName()%>">
                        <img src="<%=contextPath%>/<%=clList.get(0).getFilePath()%>/<%= clList.get(0).getChangeName()%>" width="70px;" height="70px;">
                        <input type="file" name="reUpfile1" required value="<%= clList.get(0).getOriginName()%>">
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
                    <% } else if(clList.size() == 2) { %> <!--대표이미지한장 + 사진 한장이 있다면-->
                    <div class="poto-area" align="center">
                    <div class="poto_zone" id="poto1">대표 이미지 
                    <input type="hidden" name="originFileNo1" value="<%= clList.get(0).getFileNo()%>">
                    <input type="hidden" name="originBoardNo1" value="<%= clList.get(0).getBoardNo()%>">
                    <input type="hidden" name="originFileName1" value="<%= clList.get(0).getOriginName()%>">
                    <img src="<%=contextPath%>/<%=clList.get(0).getFilePath()%>/<%= clList.get(0).getChangeName()%>" width="70px;" height="70px;">
                    <input type="file" name="reUpfile1" required>
                    </div>
                        <% for(int i = 1; i < clList.size(); i++) { %>
                            <div class="poto_zone" id="poto<%= i+1%>"><%= i + 1 %>번 이미지 
                            <input type="hidden" name="originFileNo<%=i+1%>" value="<%= clList.get(i).getFileNo()%>">
                            <input type="hidden" name="originBoardNo<%=i+1%>" value="<%= clList.get(i).getBoardNo()%>">
                            <input type="hidden" name="originFileName<%=i+1%>" value="<%= clList.get(i).getOriginName()%>">
                            <img src="<%=contextPath%>/<%=clList.get(i).getFilePath()%>/<%= clList.get(i).getChangeName()%>" width="70px;" height="70px;">
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
                    <% } else if(clList.size() == 3) { %> <!-- 대표이미지 한장 + 사진 2장이 있다면-->
                        <div class="poto-area" align="center">
                            <div class="poto_zone" id="poto1">대표 이미지 
                            <input type="hidden" name="originFileNo1" value="<%= clList.get(0).getFileNo()%>">
                            <input type="hidden" name="originBoardNo1" value="<%= clList.get(0).getBoardNo()%>">
                            <input type="hidden" name="originFileName1" value="<%= clList.get(0).getOriginName()%>">
                            <img src="<%=contextPath%>/<%=clList.get(0).getFilePath()%>/<%= clList.get(0).getChangeName()%>" width="70px;" height="70px;">
                            <input type="file" name="reUpfile1" required>
                            </div>
                            <% for(int i = 1; i < clList.size(); i++) { %>
                                <div class="poto_zone" id="poto<%= i+1%>"><%= i + 1 %>번 이미지 
                                <input type="hidden" name="originFileNo<%=i+1%>" value="<%= clList.get(i).getFileNo()%>">
                                <input type="hidden" name="originBoardNo<%=i+1%>" value="<%= clList.get(i).getBoardNo()%>">
                                <input type="hidden" name="originFileName<%=i+1%>" value="<%= clList.get(i).getOriginName()%>">
                                <img src="<%=contextPath%>/<%=clList.get(i).getFilePath()%>/<%= clList.get(i).getChangeName()%>" width="70px;" height="70px;">
                                <input type="file" name="reUpfile<%= i + 1 %>">
                                </div>
                            <% } %>
                            <div class="poto_zone" id="poto4">4번 이미지
                            <input type="file" name="reUpfile4">
                            </div> 
                        </div>
                    <% } else if(clList.size() == 4) { %> <!-- 대표이미지 한장 + 사진 3장이 있다면 -->   
                        <div class="poto-area" align="center">
                            <div class="poto_zone" id="poto1">대표 이미지 
                            <input type="hidden" name="originFileNo1" value="<%= clList.get(0).getFileNo()%>">
                            <input type="hidden" name="originBoardNo1" value="<%= clList.get(0).getBoardNo()%>">
                            <input type="hidden" name="originFileName1" value="<%= clList.get(0).getOriginName()%>">
                            <img src="<%=contextPath%>/<%=clList.get(0).getFilePath()%>/<%= clList.get(0).getChangeName()%>" width="70px;" height="70px;">
                            <input type="file" name="reUpfile1" required>
                            </div>
                            <% for(int i = 1; i < clList.size(); i++) { %>
                                <div class="poto_zone" id="poto<%= i+1%>"><%= i + 1 %>번 이미지 
                                <input type="hidden" name="originFileNo<%=i+1%>" value="<%= clList.get(i).getFileNo()%>">
                                <input type="hidden" name="originBoardNo<%=i+1%>" value="<%= clList.get(i).getBoardNo()%>">
                                <input type="hidden" name="originFileName<%=i+1%>" value="<%= clList.get(i).getOriginName()%>">
                                <img src="<%=contextPath%>/<%=clList.get(i).getFilePath()%>/<%= clList.get(i).getChangeName()%>" width="70px;" height="70px;">
                                <input type="file" name="reUpfile<%= i + 1 %>">
                                </div>
                            <% } %>
                        </div>    
                    <% } %>             
                <% } %>       
                    
                <% if(loginUser == null) { %>
                <% loginUser.setNickname(""); %>
                <% } %>
                <!-- 2번 부터 이미지가 비어있다면 새롭게 받을 수 있는 첨부파일 input을 만들어 준다-->

                <hr>
  
                <div class="modal-footer">
                    <button type="submit" class="acbtn" id="submit">등록</button>
                    <button type="button" class="acbtn1" data-bs-dismiss="modal">닫기</button>
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
    };
    
    

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
    
    //input[type=text] enter입력키 막기
    $('input[type="text"]').keydown(function() {
        if (event.keyCode === 13) {
            event.preventDefault();
        }
    });

    $(function(){

        $.ajax({
            url: 'hashtag.hs',
            data:{boardNo : '<%= cB.getBoardNo()%>'},
            type: 'post',
            success:function(hList){
                console.log(hList);

                var hashtag = '';
                

                for(var i in hList){
                    hashtag += 
                            '<li class="ht" style="display: inline-block; margin=auto">' 
                        
                            + hList[i].hashtag
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
        location.href='<%=contextPath%>/searchTag.hs?cpage=1&hashtag=' + hashtag;


            
            });


        });
</script>

<br><br>
</body>
</html>