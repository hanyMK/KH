<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.board.offer.model.vo.*" %>
    
 <%
    ArrayList<OfferAttachment> oAList = (ArrayList<OfferAttachment>)request.getAttribute("oAList");    
        
    OfferBoard oB = (OfferBoard)request.getAttribute("oB");
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
        #offerTag{
            width:800px;
        }
        #offerImg{
            display: inline-block;
        }
        #offerProfile{
            display:inline-block;
        }
        .title>input{
            border: 1px solid black;
        }
        #textarea{
            border : 1px solid black;
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

        #hashtagShow{
        margin-left: 300px;
    }
    </style>

</head>
<body>

    <%@ include file="../../admin/report/reportModal.jsp" %>

    
   

   
   

   
<!---- 컨텐츠 사진 없을때개 ---->
<div>
<div class="outer">
    <div class="outer">
        <br>
        <div id="listTag">
            <a href="<%=contextPath%>/offerList.oo?opage=1">구인 게시판 ></a>
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
        <div id="button-area" align="right">
            <button class="actBtn button-area" onclick="location.href='<%=contextPath%>/offerList.oo?opage=1'">목록으로</button>
            <% if(loginUser != null && loginUser.getNickname().equals(oB.getNickName())) { %> 
                    <button type="button" class="actBtn button-area" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo"
                             data-bs-target="#exampleModal" >게시글 수정</button>
                    <form action="<%=contextPath%>/delete.oo" method="get" class="button-area">
                        <input type="hidden" name="boardNo" value="<%= oB.getBoardNo()%>">
                        <button type="submit" class="actBtn1 button-area">게시글 삭제</button>
                    </form>
            <% } %>
        </div>
        <hr>
        <div align="center" class="imgContent">
            <% if(!oAList.isEmpty()){ %>
                <% for(int i = 1; i < oAList.size(); i++) {%>
                    <img src="<%=contextPath%>/<%=oAList.get(i).getFilePath()%>/<%=oAList.get(i).getChangeName()%>" alt="게시글 파일레벨" width="300px;" height="300px;" class="imgContent">
                <% } %>
            <% } %>
        </div>
        <br>
        <div id="boardContent">
            <%= oB.getBoardContent() %>
        </div>
        <hr>
        <div if="offerTag">
            <div id="offerImg">
                <% if(oAList.isEmpty()){ %>
                    등록된 사진이 없습니다.
                <% } else { %>
                <img src="<%=contextPath%>/<%=oAList.get(0).getFilePath()%>/<%=oAList.get(0).getChangeName()%>" alt="" width="200px;">
                <% } %>
            </div>
            <div id="offerProfile">
                <p style="font-size:large;">
                    회사 정보 :                 <br>
                    회원 이메일 : <%= oB.getEmail()%> <br>
                    기타 url :
                </p> 
            </div>
        </div>
</div>
</div>
</div>
<br><br><br><br>

<%@ include file="../../common/footer.jsp" %>

<!-- modal -->

<div class="modal fade" id="exampleModal" tabindex="-1" data-bs-backdrop="static" data-bs-keyboard="false" aria-labelledby="exampleModalLabel" aria-hidden="true" >
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">구인 게시판 글수정</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
          
            <div class="modal-body" >
                <form action="<%= contextPath %>/updateOffer.oo" method="post" enctype="multipart/form-data">
                    <% if(loginUser != null) { %>
                        <input type="hidden" name="userNo" value="<%= loginUser.getMemberNo() %>">
                    <% } %>
                        <input type="hidden" name="boardNo" value="<%= oB.getBoardNo()%>">

                    <div class="category">
                      <!-- 카테고리(주제를 선택해주세요) -->
                        <select name="category" id="category" class="modal_form" required>
                            <option value="" >주제를 선택해주세요</option>
                            <option value="아르바이트">아르바이트</option>
                            <option value="사원모집">사원모집</option>
                            <option value="광고">광고</option>
                        </select>
                      <!-- 바디프로필과 익명은 카테고리를 hidden에 담아서 들구감 -->
                    </div>
                    <div class="closingDate">
                        마감일자<input type="text" name="closingDate" class="modal-form" required placeholder="(-, ., / 특수문자를 제외하여 숫자만 입력해주세요 예시- 20231230)" style="width:100%;">
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
                    <input type="button" name="poto" value="사진첨부" class="actBtn" id="poto-none" onclick="onOff();">
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
                        <input type="file" name="reUpfile1" value="<%= oAList.get(0).getOriginName()%>">
                        <img src="<%=contextPath%>/<%=oAList.get(0).getFilePath()%>/<%= oAList.get(0).getChangeName()%>" width="70px;" height="70px;">
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
                    <input type="file" name="reUpfile1">
                    <img src="<%=contextPath%>/<%=oAList.get(0).getFilePath()%>/<%= oAList.get(0).getChangeName()%>" width="70px;" height="70px;">
                    </div>
                        <% for(int i = 1; i < oAList.size(); i++) { %>
                            <div class="poto_zone" id="poto<%= i+1%>"><%= i + 1 %>번 이미지 
                            <input type="hidden" name="originFileNo<%=i+1%>" value="<%= oAList.get(i).getFileNo()%>">
                            <input type="hidden" name="originBoardNo<%=i+1%>" value="<%= oAList.get(i).getBoardNo()%>">
                            <input type="hidden" name="originFileName<%=i+1%>" value="<%= oAList.get(i).getOriginName()%>">
                            <input type="file" name="reUpfile<%= i + 1 %>">
                            <img src="<%=contextPath%>/<%=oAList.get(i).getFilePath()%>/<%= oAList.get(i).getChangeName()%>" width="70px;" height="70px;">
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
                            <input type="file" name="reUpfile1">
                            <img src="<%=contextPath%>/<%=oAList.get(0).getFilePath()%>/<%= oAList.get(0).getChangeName()%>" width="70px;" height="70px;">
                            </div>
                            <% for(int i = 1; i < oAList.size(); i++) { %>
                                <div class="poto_zone" id="poto<%= i+1%>"><%= i + 1 %>번 이미지 
                                <input type="hidden" name="originFileNo<%=i+1%>" value="<%= oAList.get(i).getFileNo()%>">
                                <input type="hidden" name="originBoardNo<%=i+1%>" value="<%= oAList.get(i).getBoardNo()%>">
                                <input type="hidden" name="originFileName<%=i+1%>" value="<%= oAList.get(i).getOriginName()%>">
                                <input type="file" name="reUpfile<%= i + 1 %>">
                                <img src="<%=contextPath%>/<%=oAList.get(i).getFilePath()%>/<%= oAList.get(i).getChangeName()%>" width="70px;" height="70px;">
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
                            <input type="file" name="reUpfile1">
                            <img src="<%=contextPath%>/<%=oAList.get(0).getFilePath()%>/<%= oAList.get(0).getChangeName()%>" width="70px;" height="70px;">
                            </div>
                            <% for(int i = 1; i < oAList.size(); i++) { %>
                                <div class="poto_zone" id="poto<%= i+1%>"><%= i + 1 %>번 이미지 
                                <input type="hidden" name="originFileNo<%=i+1%>" value="<%= oAList.get(i).getFileNo()%>">
                                <input type="hidden" name="originBoardNo<%=i+1%>" value="<%= oAList.get(i).getBoardNo()%>">
                                <input type="hidden" name="originFileName<%=i+1%>" value="<%= oAList.get(i).getOriginName()%>">
                                <input type="file" name="reUpfile<%= i + 1 %>">
                                <img src="<%=contextPath%>/<%=oAList.get(i).getFilePath()%>/<%= oAList.get(i).getChangeName()%>" width="70px;" height="70px;">
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
    function onOff(){
                            
        var $onOff = $('.poto-area');
                            
        if($onOff.css('display') == 'none'){
        $onOff.css('display','inline');
        }
        else{
            $onOff.css('display','none');
        }
    }
    
</script>



<script>
  //input[type=text] enter입력키 막기
  $('input[type="text"]').keydown(function() {
    if (event.keyCode === 13) {
        event.preventDefault();
    }
});
</script>

<br><br>
</body>
</html>