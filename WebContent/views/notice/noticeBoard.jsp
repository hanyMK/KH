<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.member.model.vo.*, com.kh.common.model.vo.*, com.kh.notice.model.vo.*" %>
<%
	
	ArrayList<Board> noticeList = (ArrayList<Board>)request.getAttribute("noticeList");

	PageInfo pin = (PageInfo)request.getAttribute("pin");
	
	int currentPage = pin.getCurrentPage();
    int startPage = pin.getStartPage();
    int endPage = pin.getEndPage();
    int maxPage = pin.getMaxPage();
   
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 / 이벤트 게시판</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">  
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>  
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>  
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>



<style>
    #outer_010{
        width: 1200px;
        text-align: center;
        margin: auto;
    }
    #wrap{
        margin : auto;
        width : 800px;
        height : 100%;
    }
    button{
        color:#052159 ;
        background-color: #C2E5F2;
        border: 1px #C2E5F2;
    }

    table{
        text-align: center;
    }
    
    #noticelist>tbody>tr :hover{
        cursor: pointer;
        background-color: #C2E5F2;
    }
    .actBtn{
        border-radius: 5px;
        color: #052159;
    }
    #actH2{
        text-align: center;
	    font-weight: 1000;
	    margin-bottom: 40px;
	    margin-top: 40px;
	    color:#052159 ;
    }
	
	#nomenu{
		margin : auto;
		margin-left : 900px;
	}

</style>
</head>
<body>

<%@ include file="../common/menubar.jsp" %>
<div id="outer_010">

    <br>
    <hr>

    <h2 id="actH2" align="center">공지사항 / 이벤트 게시판</h2>
    
    <hr>
    
    <div>
        <div id="nomenu">
            <% if(loginUser != null && loginUser.getMemberType().equals("D ")) {  %>
                <button type="button" class="actBtn" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo"
                data-bs-target="#exampleModal" >글쓰기</button>
                <% } else { %>
                    
                    <button onclick="goPoint();" class="actBtn" align="center">내 포인트 확인</button>
                    
                    <% } %>
                    <br>
                </div>
                <div>
                    <br>
                    <table id="noticelist" align="center">
                        <thead>
                            <tr>
                                <th width="70">번호</th>
                                <th width="100">구분</th>
                <th width="200">제목</th>
                <th width="130">작성일</th>
                <th width="100">조회수</th>
            </tr>
        </thead>
        <tbody>
            <% if(noticeList.isEmpty()){ %>
				<tr><td colspan="3">게시글 내역이 없습니다.</td></tr>
				<% } else { %>
					<% for(Board b : noticeList) { %>
                        <tr>
                            <td><%= b.getBoardNo() %></td>
                            <td><%= b.getCategory() %></td>
                            <td><%= b.getBoardTitle() %></td>
                            <td><%= b.getCreateDate() %></td>
                            <td><%= b.getBoardCount() %></td>
                        </tr>
                        <% } %>
                        <% } %>
                    </tbody>
                </table>
                <br>
            </div>
            <div align="center" id="noticelistPage">
                <% if(currentPage != 1) { %>
                    <button onclick="location.href='<%= contextPath %>/noticeblist?nbpage=<%= currentPage - 1 %>'" class="actBtn">&lt;</button>
                    <% } %>
                    <% for(int i = startPage; i <= endPage; i++) { %>
                        <% if(currentPage != i) { %>
                            <button onclick="location.href='<%= contextPath %>/noticeblist?nbpage=<%= i %>'" class="actBtn"><%= i %></button>
                            <% } else { %>
                                <button class="actBtn" disabled><%= i %></button>
                                <% } %>
                                <% } %>
                                
                                <% if(currentPage != maxPage) { %>
                                    <button onclick="location.href='<%= contextPath %>/noticeblist?nbpage=<%=currentPage + 1%>'" class="actBtn">&gt;</button>
                <% } %>
       	 </div>
        </div>
        <script>
            
            function goPoint(){
                
                location.href="<%=contextPath%>/mypoint.me?pcpage=1"
       		 
       	 }
       	 
            $(function(){
                
                $('#noticelist>tbody>tr').click(function(){
                    
                    
                    var bno = $(this).children().eq(0).text();
                    location.href = "<%=contextPath%>/detail.noticeList?bno=" + bno;
                    
                });
            });
            
       	 </script>
       	 
            <!-- modal -->
            
       	 <div class="modal fade" id="exampleModal" tabindex="-1" data-bs-backdrop="static" data-bs-keyboard="false" aria-labelledby="exampleModalLabel" aria-hidden="true" >
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="exampleModalLabel"> 게시판 글쓰기</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        
                        <div class="modal-body" >
                            <form action="<%= contextPath %>/noticelistinsert" method="post" enctype="multipart/form-data">
                                <div class="category">
                                    <% if(loginUser!= null){ %>
                                        <input type="hidden" name="userNo" value="<%= loginUser.getMemberNo()%>">
                        <% } %>
                        <!-- 카테고리(주제를 선택해주세요) -->
                        <select name="category" id="category" class="modal_form">
                            <option value="" >주제를 선택해주세요</option>
                            <option value="공지사항">공지사항</option>
                            <option value="이벤트">이벤트</option>
                        </select>
                    </div>
                    <br>
                    <div class="title">
                        
                        <input type="text" id="title_div" placeholder="글 제목" maxlength=20 style="width:100%" 
                        name="title" class="modal_form" required>
                        
                    </div>
                    
                    <div class="content" >
                        <textarea style="resize: none; width: 100%; height: 100%"  placeholder="주제에 맞지 않는 글로 판단되어 다른 유저로부터 일정수 이상 신고를 받는 경우 자동으로 숨김처리 될 수 있습니다."
                        id="textarea" name="content" class="modal_form" required></textarea>
                    </div>
                    
                    <div>
                        <hr>
                        <input type="button" name="poto" value="사진첨부" class="btn btn-sm btn-primary" id="poto-none" onclick="onOff();">
                        
                    </div>
                    
                    <!-- 여기는 사진첨부하면 미리보기해주는 곳 -->
                    
                    <div class="poto-area" align="center">
                        <div class="poto_zone" id="poto1">대표 이미지
                            <input type="file" name="file1">
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
                    
                    <hr>
                    
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary" id="submit">등록</button>
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
                    </div>

                  
                    
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
        $('#offer>tbody>tr').click(function(){
            var $ono = $(this).children().eq(0).text();

           
            location.href = '<%=contextPath%>/detail.oo?opage=' + $ono;
        })
        
    })
    
    
    $(function(){
                            $('#offer>tbody>tr').click(function(){
                                var $ono = $(this).children().eq(0).text();

                               
                                location.href = '<%=contextPath%>/detail.oo?opage=' + $ono;
                            })
                        })
   
    </script>

        <br><br><br>

<%@ include file="../common/footer.jsp" %>

</body>
</html>