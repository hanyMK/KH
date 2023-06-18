<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.member.model.vo.*, com.kh.common.model.vo.*, com.kh.notice.model.vo.*" %>
<%
	
	Board nB = (Board)request.getAttribute("nb");
	ArrayList<BoardAttach> nAList = (ArrayList<BoardAttach>)request.getAttribute("nAList");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항/이벤트 게시글 상세 화면</title>
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
    .list-area{
        text-align: center;
        border: 1px solid white;
    }

    .list-area > tbody >tr:hover{
        cursor: pointer;
    }

    .outer table{
        padding-bottom: 500px;

    }

    .outer table, tr, th, td{

        /* border : 1px solid black; */
            height: 50px;
        }
     button{
     
     	color:#052159 ;
        background-color: #C2E5F2;
        border: 1px #C2E5F2;
     
     }



    .an_3 tr{
        border-bottom: 1px solid gray;
        border-right: 1px solid gray;
        border-left: 1px solid gray;
        border-top : 1px solid gray;
    }
    
    .an_3{
    	margin-top: 20px;
        padding-left: 5px;
        border-left: 1px solid gray;
        border-right: 1px solid gray;
    }
    .content{
        height: 200px;
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
        border: 1px solid black;
        display: inline-block;
        width: 180px;
        height: 180px;
        
       
    }
    .poto-area{
        margin-top: 20px;
        display : none;
    }
    
    #backlist{
    	margin-left: 320px;
    }
    
</style>


</head>
<body>

<%@ include file="../common/menubar.jsp" %>


<div class="outer">
   
    <!---- 컨텐츠 사진 1개 시작 ---->
    
    <table class="an_3" width="100%">
        <thead>
            <tr colspan="6">
                <th style="padding-left: 20px; font-size: 25px;">공지사항/이벤트 게시판</th>
            </tr>
            <tr>
                <td colspan="6" style="padding-left: 20px;">카테고리  : <%= nB.getCategory() %></td>
            </tr>    
            <tr>
                <th colspan="6" style="padding-left: 20px;">제목 :  <%= nB.getBoardTitle() %></th>
            </tr>
            <tr id="nickName_area" style="padding-left: 20px;">
                <td style="padding-left: 20px; ">작성자 : No Sweat</td>
                <td colspan="4"></td>
            </tr>
            <tr>
                <td colspan="6" style="padding-left: 20px;">작성일 : <%= nB.getCreateDate() %> | 조회수 : <%= nB.getBoardCount() %></td>
                <% if(loginUser != null && loginUser.getMemberType().equals("D ")) { %> 
                    <td width="500">
                        <button style="margin-left:75%;" type="button" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo"
                    data-bs-target="#exampleModal" >게시글 수정</button>
                    </td>
                    <td>
                        <form action="<%=contextPath%>/delete.oo" method="get">
                            <button type="submit">게시글 삭제</button>
                        </form>
                    </td>
                <% } %>
            </tr>
        </thead>
        <tbody>
            
            <tr>
                <td class="content" colspan="6" align="center" >
                    <% if(nAList.isEmpty()){ %>
                        	등록된 사진이 없습니다.
                    <% } else { %>
                    <% for(int i = 0; i < nAList.size(); i++) {%>
                        <img src="<%=contextPath%>/<%=nAList.get(i).getFilePath()%>/<%=nAList.get(i).getChangeName()%>" alt="" width="200px;">
                    <% } %>
                </td>
            </tr>
                    <% } %>
            <tr>
                <td class="content" colspan="6"  height="200" align="center">
                    <%= nB.getBoardContent() %>
                </td>
            </tr>
           
            </tbody>
    </table>
    <br><br>
    <div id="backlist"> <button onclick="location.href='<%=contextPath%>/noticeblist?nbpage=1'">목록으로</button> </div>
   
    <!---- 컨텐츠 사진 4개 끝 ---->
    
  

</div>

<br><br><br><br>

<%@ include file="../common/footer.jsp" %>

<!-- modal -->

<div class="modal fade" id="exampleModal" tabindex="-1" data-bs-backdrop="static" data-bs-keyboard="false" aria-labelledby="exampleModalLabel" aria-hidden="true" >
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">공지사항 / 이벤트 게시글 수정</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
          
            <div class="modal-body" >
                <form action="<%= contextPath %>/updateNotice" method="post" enctype="multipart/form-data">
                        <input type="hidden" name="boardNo" value="<%= nB.getBoardNo()%>">
                    <div class="category">
                      <!-- 카테고리(주제를 선택해주세요) -->
                        <select name="category" id="category" class="modal_form">
                            <option value="" >주제를 선택해주세요</option>
                            <option value="notice">공지사항</option>
                            <option value="event">이벤트</option>
                        </select>
                    </div>
                    <br>
                <div class="title">
                    <input type="text" id="title_div" placeholder="글 제목" maxlength=20 style="width:100%" 
                           name="title" class="modal_form" required value="<%= nB.getBoardTitle()%>">
  
                </div>
  
                <div class="content" >
                    <textarea style="resize: none; width: 100%; height: 100%"
                              id="textarea" name="content" class="modal_form" required><%= nB.getBoardContent()%></textarea>
                </div>
                  
                <div>
                    <hr>
                    <input type="button" name="poto" value="사진첨부" class="btn btn-sm btn-primary" id="poto-none" onclick="onOff();">
                    <input type="button" name="vote" value="투표" class="btn btn-sm btn-primary">
                    <input type="button" name="hashTag" value="해시태그" class="btn btn-sm btn-primary">
                    
                </div>
              
                <!-- 사진첨부수정시 미리보기해주는 곳 -->
                <!-- 만약 첨부파일이 비어있다면 -->
                <% if(nAList.isEmpty()){ %>
                    <div class="poto-area" align="center">
                        <div class="poto_zone" id="poto1">대표 이미지
                          <input type="file" name="reUpfile1">
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
                <% } else if(nAList != null){%> <!-- 비어있지 않다면 -->
                    <!-- 대표이미지만 있다면 1장 첨부되었을 경우-->
                    <% if(nAList.size() == 1){ %>
                    <div class="poto-area" align="center">
                        <div class="poto_zone" id="poto1">
                        <input type="hidden" name="originFileNo1" value="<%= nAList.get(0).getFileNo()%>">
                        <input type="hidden" name="originBoardNo1" value="<%= nAList.get(0).getBoardNo()%>">
                        <input type="hidden" name="originFileName1" value="<%= nAList.get(0).getOriginName()%>">
                        <img src="<%=contextPath%>/<%=nAList.get(0).getFilePath()%>/<%= nAList.get(0).getChangeName()%>" width="70px;" height="70px;">
                        <input type="file" name="reUpfile1" value="<%= nAList.get(0).getOriginName()%>">
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
                    <% } else if(nAList.size() == 2) { %> <!--대표이미지한장 + 사진 한장이 있다면-->
                    <div class="poto-area" align="center">
                    <div class="poto_zone" id="poto1">대표 이미지 
                    <input type="hidden" name="originFileNo1" value="<%= nAList.get(0).getFileNo()%>">
                    <input type="hidden" name="originBoardNo1" value="<%= nAList.get(0).getBoardNo()%>">
                    <input type="hidden" name="originFileName1" value="<%= nAList.get(0).getOriginName()%>">
                    <img src="<%=contextPath%>/<%=nAList.get(0).getFilePath()%>/<%= nAList.get(0).getChangeName()%>" width="70px;" height="70px;">
                    <input type="file" name="reUpfile1" required>
                    </div>
                        <% for(int i = 1; i < nAList.size(); i++) { %>
                            <div class="poto_zone" id="poto<%= i+1%>"><%= i + 1 %>번 이미지 
                            <input type="hidden" name="originFileNo<%=i+1%>" value="<%= nAList.get(i).getFileNo()%>">
                            <input type="hidden" name="originBoardNo<%=i+1%>" value="<%= nAList.get(i).getBoardNo()%>">
                            <input type="hidden" name="originFileName<%=i+1%>" value="<%= nAList.get(i).getOriginName()%>">
                            <img src="<%=contextPath%>/<%=nAList.get(i).getFilePath()%>/<%= nAList.get(i).getChangeName()%>" width="70px;" height="70px;">
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
                    <% } else if(nAList.size() == 3) { %> <!-- 대표이미지 한장 + 사진 2장이 있다면-->
                        <div class="poto-area" align="center">
                            <div class="poto_zone" id="poto1">대표 이미지 
                            <input type="hidden" name="originFileNo1" value="<%= nAList.get(0).getFileNo()%>">
                            <input type="hidden" name="originBoardNo1" value="<%= nAList.get(0).getBoardNo()%>">
                            <input type="hidden" name="originFileName1" value="<%= nAList.get(0).getOriginName()%>">
                            <img src="<%=contextPath%>/<%=nAList.get(0).getFilePath()%>/<%= nAList.get(0).getChangeName()%>" width="70px;" height="70px;">
                            <input type="file" name="reUpfile1" required>
                            </div>
                            <% for(int i = 1; i < nAList.size(); i++) { %>
                                <div class="poto_zone" id="poto<%= i+1%>"><%= i + 1 %>번 이미지 
                                <input type="hidden" name="originFileNo<%=i+1%>" value="<%= nAList.get(i).getFileNo()%>">
                                <input type="hidden" name="originBoardNo<%=i+1%>" value="<%= nAList.get(i).getBoardNo()%>">
                                <input type="hidden" name="originFileName<%=i+1%>" value="<%= nAList.get(i).getOriginName()%>">
                                <img src="<%=contextPath%>/<%=nAList.get(i).getFilePath()%>/<%= nAList.get(i).getChangeName()%>" width="70px;" height="70px;">
                                <input type="file" name="reUpfile<%= i + 1 %>">
                                </div>
                            <% } %>
                            <div class="poto_zone" id="poto4">4번 이미지
                            <input type="file" name="reUpfile4">
                            </div> 
                        </div>
                    <% } else if(nAList.size() == 4) { %> <!-- 대표이미지 한장 + 사진 3장이 있다면 -->   
                        <div class="poto-area" align="center">
                            <div class="poto_zone" id="poto1">대표 이미지 
                            <input type="hidden" name="originFileNo1" value="<%= nAList.get(0).getFileNo()%>">
                            <input type="hidden" name="originBoardNo1" value="<%= nAList.get(0).getBoardNo()%>">
                            <input type="hidden" name="originFileName1" value="<%= nAList.get(0).getOriginName()%>">
                            <img src="<%=contextPath%>/<%=nAList.get(0).getFilePath()%>/<%= nAList.get(0).getChangeName()%>" width="70px;" height="70px;">
                            <input type="file" name="reUpfile1" required>
                            </div>
                            <% for(int i = 1; i < nAList.size(); i++) { %>
                                <div class="poto_zone" id="poto<%= i+1%>"><%= i + 1 %>번 이미지 
                                <input type="hidden" name="originFileNo<%=i+1%>" value="<%= nAList.get(i).getFileNo()%>">
                                <input type="hidden" name="originBoardNo<%=i+1%>" value="<%= nAList.get(i).getBoardNo()%>">
                                <input type="hidden" name="originFileName<%=i+1%>" value="<%= nAList.get(i).getOriginName()%>">
                                <img src="<%=contextPath%>/<%=nAList.get(i).getFilePath()%>/<%= nAList.get(i).getChangeName()%>" width="70px;" height="70px;">
                                <input type="file" name="reUpfile<%= i + 1 %>">
                                </div>
                            <% } %>
                        </div>    
                    <% } %>             
                <% } %>       
                    
                
                <!-- 2번 부터 이미지가 비어있다면 새롭게 받을 수 있는 첨부파일 input을 만들어 준다-->




                <hr>
  
                <div class="modal-footer">
                    <button type="text" class="btn btn-primary">임시저장</button>
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
    
</script>

</body>
</html>