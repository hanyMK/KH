<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.board.challenge.model.vo.*, com.kh.common.model.vo.PageInfo" %>
<%
    ArrayList<ChallengeBoard> clList = (ArrayList<ChallengeBoard>)request.getAttribute("clList");
    PageInfo pi = (PageInfo)request.getAttribute("pi");
   
    int currentPage = pi.getCurrentPage();
    int startPage = pi.getStartPage();
    int endPage = pi.getEndPage();
    int maxPage = pi.getMaxPage();
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>챌린지 게시판 리스트</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>  
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>  
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<style>
  #wrap{
        margin : auto;
        width : 800px;
        height : 100%;
    }
    .list{
        padding : 6px;
    }
    .category{
        padding : 3px;
        width : 10px;
    }
    .categoryTag{
        font-size: 5px;
    }
    
    .content{
        margin-bottom: 20px;
        height: 500px;
    }
    .title>input{
        border: 1px solid black;
    }
    #textarea{
        border : 1px solid black;
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
    #div-tag{
        display: none;
        
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
    #div-tag> ul li {
    display: inline-block;
    margin: 0 5px;
    font-size: 14px;
    letter-spacing: -.5px;
    }
    #div-tag> ul {
    padding: 16px 0;
    }
    #div-tag> form {
    padding-top: 16px;
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

    #textMsg{
      pointer-events: none;
   }
   
  #chName{
      text-align: center;
      font-weight: 1000;
      margin-bottom: 40px;
      margin-top: 40px;
      color:#052159 ;
    }
</style>
</head>
<body>
    <%@ include file="../../common/menubar.jsp" %>

    
    <div align="center"  id="wrap">
    <br>
    <h2 id="chName" style="color:#052159">챌린지 게시판</h2>
    <br>
    <!-- 타입에 빈문자열 들어가있는 상태이므로 equals()메소드 사용시 빈문자열 추가 -->
    <% if(loginUser != null){ %>
        <button style="margin-left:700px;" type="button" class="actBtn" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo"
        data-bs-target="#exampleModal" >글쓰기</button>
    <% } %>   
        <% if(clList.isEmpty()) { %>
            <div class="boardContent" id="textMsg">
                <img class="contentimg" src="" alt="게시글이 존재하지 않습니다.">
                <div class="textcontent">
                    게시글이 존재하지 않습니다.
                </div>
            </div>

            <% } else { %>
                <% for(ChallengeBoard cB : clList) { %>
                    <div class="boardContent">
                        <img class="contentimg" src="<%=contextPath%>/<%= cB.getTitleImg()%>" alt="게시글 썸네일 이미지" width="300px;" height="200px;">
                        <div style="display:none;"><%= cB.getBoardNo()%></div>
                        <div class="contentTitle"><%= cB.getBoardTitle()%></div>
                        <div class="textcontent">
                            <%= cB.getBoardContent()%>
                        </div>
                        <div style="font-size:15px;">
                            작성일 <%= cB.getCreateDate()%> | 작성자 <%= cB.getMemberNo()%>
                        </div>
                    </div>
                <% } %>
        <% } %>        
        

    
        <hr>

        <div align="center" class="page-area">
            <% if(currentPage != 1) {%>
                <button onclick="location.href='<%=contextPath%>/challengeList.cl?cpage=<%=currentPage - 1%>'" class="actBtn">&gt;</button>
            <%} %>
            <% for(int i = startPage; i <= endPage; i++) { %>
               <% if(currentPage != i) { %>
               <button class="actBtn" onclick="location.href='<%=contextPath%>/challengeList.cl?cpage=<%= i %>'"><%= i%></button>
               <% } else { %>
                  <button class="actBtn" disabled><%= i%></button>
                <% } %>   
            <% } %>
            <% if(currentPage != maxPage &&maxPage !=0 ){ %>
                <button onclick="location.href='<%=contextPath%>/challengeList.cl?cpage=<%=currentPage + 1%>'" class="actBtn">&gt;</button>
            <%} %>
        </div>

        <br>
        <br>
        
        <br><br>
    </div>
    <!-- modal -->

    <div class="modal fade" id="exampleModal" tabindex="-1" data-bs-backdrop="static" data-bs-keyboard="false" aria-labelledby="exampleModalLabel" aria-hidden="true" >
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">챌린지 게시판 글쓰기</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
              
                <div class="modal-body" >
                    <form action="<%= contextPath %>/insertChallenge.cl" method="post" enctype="multipart/form-data">
                        <% if(loginUser != null) { %>

                        <input type="hidden" name="userNo" value="<%= loginUser.getMemberNo() %>">

                        <% } %>

                        <div class="category">
                          <!-- 카테고리(주제를 선택해주세요) -->
                            <select name="category" id="category" class="modal_form">
                                <option value="기본" >주제를 선택해주세요</option>
                                <option value="맨몸운동">맨몸운동</option>
                                <option value="다이어트">다이어트</option>
                                <option value="기타">기타</option>
                            </select>
                          <!-- 바디프로필과 익명은 카테고리를 hidden에 담아서 들구감 -->
                        </div>
                       
                    <div class="title">
                      
                        <input type="text" id="title_div" placeholder="글 제목" maxlength=20 style="width:100%" 
                               name="title" class="modal_form" required>
      
                    </div>

                    <div id="div-tag">   
                        <div id="div-tag" style="display: flex;">
                          <input type="text" id="tag" size="20" placeholder="태그를 입력후 스페이스바를 눌러주세요" style="width:100%; margin: 10px;">
                        </div>
                        <ul id="tag-list">
                          <input type="hidden" name="tagState" value="no">
                        </ul>
                    </div>
      
                    <div class="content" >
                        <textarea style="resize: none; width: 100%; height: 100%"  placeholder="주제에 맞지 않는 글로 판단되어 다른 유저로부터 일정수 이상 신고를 받는 경우 자동으로 숨김처리 될 수 있습니다."
                                  id="textarea" name="content" class="modal_form" required></textarea>
                    </div>

                    <div>
                        <p>* 사진을 반드시 1장이상 첨부해주세요   </p>
                    </div>
                      
                    <div>
                        <hr>
                        <input type="button" name="poto" value="사진첨부" class="actBtn" id="poto-none" onclick="onOff();">
                        <input type="button" name="vote" value="투표" class="actBtn" id="vote-none" onclick="voteOnOff();">
                        <input type="button" name="hashTag" value="해시태그" class="actBtn">
                        
                    </div>
                     
                  
                    <!-- 여기는 사진첨부하면 미리보기해주는 곳 -->
                 
                    <div class="poto-area" align="center">
                        <div class="poto_zone" id="poto1">대표 이미지
                          <input type="file" name="file1" required>
                        </div>
                        <div class="poto_zone" id="poto2">2번 이미지
                          <input type="file" name="file2">
                        </div>
                        <div class="poto_zone" id="poto3">3번 이미지
                          <input type="file" name="file3">
                        </div>
                        <div class="poto_zone" id="poto4">4번 이미지
                          <input type="file" name="file4">
                        </div>
                    </div>

                 <div class="vote-area">
                        <div style="font-weight:1000;">
                            투표제목 > <input type="text" name="voteTitle" placeholder="투표 제목을 입력해주세요." style="width:300px;">
                        </div>
                        <hr>
                        <div>
                            투표항목 > <input type="text" name="query1" placeholder="1. 항목을 입력해주세요" style="width:300px;">
                        </div>
                        <hr>
                        <div>
                            투표항목 > <input type="text" name="query2" placeholder="2. 항목을 입력해주세요" style="width:300px;">
                        </div>
                        <hr>
                        <div>
                            투표항목 > <input type="text" name="query3" placeholder="3. 항목을 입력해주세요" style="width:300px;">
                        </div>
                        <hr>
                        <div>
                            투표항목 > <input type="text" name="query4" placeholder="4. 항목을 입력해주세요" style="width:300px;">
                        </div>
                        <hr>
                        <div>
                            투표항목 > <input type="text" name="query5" placeholder="5. 항목을 입력해주세요" style="width:300px;">
                        </div>
                        <hr>
                        <div>
                            복수선택  <input type="checkbox" name="dupliYN">
                        </div>
                    </div>


                    <hr>
      
                    <div class="modal-footer">
                        <button type="submit" class="actBtn" onclick="return ask();" id="submit">등록</button>
                        <button type="button" class="actBtn1" data-bs-dismiss="modal">닫기</button>
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

        $(function(){
            $('.boardContent').click(function(){
                    var $cno = $(this).children().eq(1).text();
                    //console.log($cno); 글번호
                               
                    location.href = '<%=contextPath%>/challengedetail.cl?cpage=' + $cno;
                })
            })

        function voteOnOff(){

            var $vote = $('.vote-area');

            if($vote.css('display') == 'none'){
                $vote.css('display', 'inline');
            }
            else{
                $vote.css('display', 'none');
            }
        };

        $(function(){
                 
                   
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
                                self.val("");
                                $("#tag-list").children('input[name=tagState]').val('yes');
                                console.log($("#tag-list").children('input[name=tagState]').val());
                            } 
                            else {
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
                    var index = $(this)
                    .attr("idx");
                    tag[index] = "";
                    $(this).parent().remove();
                    });

                    //input[type=text] enter입력키 막기
                    $('input[type="text"]').keydown(function() {
                        if (event.keyCode === 13) {
                            event.preventDefault();
                        }
                    });

                  })

        $(function(){
            $('[name=hashTag]').click(function(){
                if($('#div-tag').css('display')== 'none'){

                $('#div-tag').css('display', 'inline');
                }
                else{
                $('#div-tag').css('display', 'none')
                }
                        
            });

        });
        function ask(){
            return confirm('게시판 작성을 마무리 하시겠습니까?');
        
        };    
    </script>

    
    <%@ include file="../../common/footer.jsp" %>
</body>
</html>