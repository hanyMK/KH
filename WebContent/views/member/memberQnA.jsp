<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList, com.kh.member.model.vo.MemberQnA, com.kh.common.model.vo.PageInfo" %>
<%
	ArrayList<MemberQnA> list = (ArrayList<MemberQnA>)request.getAttribute("list");
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
<title>문의사항</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script> 
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed&display=swap" rel="stylesheet">

<!--모달 링크-->
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <title>Bootstrap Example</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

<style>
    *{
       list-style: none;
       text-decoration: none;
    }
    #wrap_12{
        width: 1200px;
    	height: 600px;
        text-align: center;
        margin: auto;
    }
    #myQnA{
        width: 800px;
        height: 600px;
        /*border: 1px solid black;*/
        margin: auto;
    }
    #thName{
	    text-align: center;
	    font-weight: 1000;
	    margin-bottom: 40px;
	    margin-top: 40px;
	    color:#052159 ;
    }
    #writerBtn{
        float: right;
        margin-right: 20px;
        color:#052159 ;
        background-color: #C2E5F2;
        border: 1px #C2E5F2;
    }
    button{
        color:#052159 ;
        background-color: #C2E5F2;
        border: 1px #C2E5F2;
    }
    .actBtn{
        color:#052159 ;
        background-color: #C2E5F2;
        border: 1px #C2E5F2;
		border-radius: 5px;
		height: 30px;
    }
    .actBtn1{
        background-color: rgb(54, 54, 71);
        color: white;
        height: 30px;
        border-radius: 5px;
   }
    #tableQnA{
        width: 800px;
        border-left: none;
        border-right: none;
    }
    #thTitle{
        text-align: center;
    }
    .tableQnA>tbody>tr:hover{
        cursor: pointer;
        background-color: #C2E5F2;;
    }
    #textMsg{
		pointer-events: none;
	}

</style>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>
	<br>
	<div id="wrap_12">
    <hr>    
        <h2 id="thName">문의사항</h2>
    <hr>    
        <div id="myQnA">
            <br>
            <% if(loginUser != null) { %>
                <button type="button" class="btn btn-sm btn-info" data-bs-toggle="modal" data-bs-target="#writerQnA" data-bs-whatever="@mdo"
                data-bs-target="#writerQnA" id="writerBtn">글쓰기</button>
                <br>
            <% } %>
            <br>
            <table class="tableQnA" border="1" id="tableQnA">
                <thead>
                    <tr>
                    	<th width="50" id="thTitle">글번호</th>
                        <th width="400" id="thTitle">제목</th>
                        <th width="100" id="thTitle">작성자</th> 
                        <th width="200" id="thTitle">작성일</th>
                        <th width="50" id="thTitle">댓글</th>
                    </tr>
                </thead>
                <tbody>
                    <% if(list.isEmpty()) { %>
                        <tr>
                            <td colspan="6" id="textMsg">조회된 게시글이 없습니다.</td>
                        </tr>
                    <% } else { %>
                        <% for(MemberQnA q : list) { %>
                        <tr>
                        	<td><%=q.getQuaNo() %></td>
                            <td><%=q.getQnaTitle() %></td>
                            <td><%=q.getMemberNo() %></td>
                            <td><%=q.getQnaDate() %></td>
                            <td><%=q.getQnaCheck() %></td>
                        </tr>
                        <% } %>
                    <% } %>
                </tbody>
            </table>
        <script>
	    	$(function(){
	    		$('.tableQnA>tbody>tr').click(function(){
	    			location.href = '<%=contextPath%>/detail.QnA?qno=' + $(this).children().eq(0).text();
	    		});
	    	});
        </script>

        <br><br>
            
            <div align="center" class="paging-area">
        
        	<% if(currentPage != 1) {%>
               <button onclick="location.href='<%= contextPath %>/qna.me?cpage=<%= currentPage - 1 %>'" class="actBtn">&lt;</button>
         	<% } %>

			<% for(int i = startPage; i <= endPage; i++) {%>
				<% if(currentPage != i){ %>
					<button onclick="location.href='<%=contextPath %>/qna.me?cpage=<%=i %>'" class="actBtn"><%=i %></button>
				<%} else { %>
            		<button disabled class="actBtn"><%=i %></button>
           		 <%} %>
            <%} %>
            
            <% if(currentPage != maxPage) { %>
            	<button onclick="location.href='<%=contextPath%>/qna.me?cpage=<%=currentPage + 1%>'" class="actBtn" >&gt;</button>
            <%} %>
        </div>
            
        </div>	
	</div>

    <!--모달 글쓰기 -->
    <!-- ================================== modal글쓰기 작성란 ========================================================================================================= -->


<div class="modal fade" id="writerQnA" tabindex="-1" data-bs-backdrop="static" data-bs-keyboard="false" aria-labelledby="exampleModalLabel" aria-hidden="true" >
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
          <div class="modal-header">
              <h2 class="modal-title fs-5" id="exampleModalLabel">문의사항 글쓰기</h2>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
                   
            <div class="modal-body" >
                <form action="<%=contextPath%>/insert.QnA" method="post">
                    
                    <input type="hidden" name="userNo" value="<%= loginUser.getMemberNo() %>">
                    <input type="hidden" name="userId" value="<%= loginUser.getMemberId() %>">

                <div class="title">   
                    <input type="text" id="title_div" placeholder="글 제목" maxlength=20 style="width: 670px; margin-left: 60px;" 
                    name="qnaTitle" class="modal_form" required>
                </div>
    
                <div class="content" >
                    <textarea style="resize: none; width: 670px; height: 200px; margin-left: 60px;"  placeholder="문의하고싶은 내용을 자유롭게 입력해주세요. 문의사항은 수정이 불가능합니다."
                    id="textarea" name="qnaContent" class="modal_form" required></textarea>
                </div>
                    
                <div class="modal-footer">
                    <button type="submit" class="actBtn" id="submit">등록</button>
                    <button type="button" class="actBtn1" data-bs-dismiss="modal">닫기</button>
                </div>
                </form>
            </div>
        </div>
    </div>
</div>

<%@ include file="../common/footer.jsp" %>

</body>
</html>