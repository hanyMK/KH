<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.member.model.vo.*, com.kh.common.model.vo.PageInfo" %>
<%
	
	ArrayList<Alarm> rlist = (ArrayList<Alarm>)session.getAttribute("rlist");
	ArrayList<Alarm> myRList = (ArrayList<Alarm>)session.getAttribute("myRList");
	PageInfo pir =(PageInfo)session.getAttribute("pir");

    int currentPage = pir.getCurrentPage();
    int startPage = pir.getStartPage();
    int endPage = pir.getEndPage();
    int maxPage = pir.getMaxPage();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 댓글 확인 페이지</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>  
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>  
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
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
        color: #052159;
    }
    #login>thead tr, td{
        padding : 8px;
    }
    button{
        color:#052159 ;
        background-color: #C2E5F2;
        border: 1px #C2E5F2;
    }
    #replylist>tbody>tr :hover{
        cursor: pointer;
        background-color: #C2E5F2;
    }
    .actBtn{
        border-radius: 5px;
        color: #052159;
    }
    #actH2{
        color: #052159;
    }
    .actTh{
        text-align: center;
	    font-weight: 1000;
	    margin-bottom: 40px;
	    margin-top: 40px;
	    color:#052159 ;
    }
   
</style>

</head>
<body>

<%@ include file="../common/menubar.jsp" %>
<br>
<div id="outer_010">

    <hr>
      
        <h2 align="center" id="actH2"><b>내가 작성한 댓글 </b></h2>
        <hr>
    <div align="center"  id="wrap">
        
    <div id="myalarm">

        
        
    </div>
    
    <div id="mylist">
        
       
		<div id="replylistdiv">

            <div id="replylistdiv">
                
                <table id="replylist" align="center">
                    <thead>
                        <tr>
            	<th></th>
                <th></th>
                <th width="80">No</th>
                <th width="300">내용</th>
                <th width="200">작성일</th>
            </tr>
            <% if(myRList.isEmpty()) { %>
                <tr><td colspan="3">작성한 댓글이 없습니다.</td></tr>
			</thead>
			<% } else { %>
				<% for(Alarm a : myRList) { %>
			<tbody>
            <tr>
            	<td><input type="hidden" value="<%= a.getBoardType() %>"></td>
            	<td><input type="hidden" value="<%= a.getBoardNo() %>"></td>
                <td><%= a.getReplyNo() %></td>
                <td><%= a.getReplyContent() %></td>
                <td><%= a.getCreateDater() %></td>
            </tr>
            </tbody>
            	<% } %>
            <% } %>
        </table>
        <%  if(myRList.isEmpty()){} else { %>
            <br>
          <div class="paging-area" id="rereplyPage">
            <% if(currentPage != 1) { %>
                <button onclick="location.href='<%= contextPath %>/myreplyList?rcpage=<%= currentPage - 1 %>'" class="actBtn">&lt;</button>
                <% } %>
                <% for(int i = startPage; i <= endPage; i++) { %>
                    <% if(currentPage != i) { %>
                        <button onclick="location.href='<%= contextPath %>/myreplyList?rcpage=<%= i %>'" class="actBtn"><%= i %></button>
                        <% } else { %>
                        <button disabled class="actBtn"><%= i %></button>
                        <% } %>
                        <% } %>
                        
                        <% if(currentPage != maxPage) { %>
                            <button onclick="location.href='<%= contextPath %>/myreplyList?rcpage=<%=currentPage + 1%>'" class="actBtn">&gt;</button>
                <% } %>
           <% } %>
        </div>
        </div>
        
        <br><br>
        
        <button class="actBtn" id="gomypage" onclick="gomypage();">내 활동정보로 돌아가기</button>
    	<button class="actBtn" id="gomyrereply" onclick="gomyrereply();">내가 쓴 대댓글 보기</button>
        
        
		<script>
		function gomypage(){
			
			location.href="<%=contextPath%>/mypage.me"
	
		}
		
		function gomyrereply(){
            
			location.href="<%=contextPath%>/myrereplyList?rrcpage=1"
			
		}
		
		$(function(){
            $('#replylist>tbody>tr').click(function(){
                var $ono = $(this).children().eq(1).children().val();
                var $type = $(this).children().eq(0).children().val();
                
                if($type ==  'A    '){
                    location.href = '<%=contextPath%>/detail.noticeList?bno=' + $ono;
                } else if($type == 'B    '){
                    location.href = '<%=contextPath%>/detail.an?bno=' + $ono;
                } else if($type == 'C    '){
                    location.href = '<%=contextPath%>/bodyDetail.by?boardNo=' + $ono;
                } else if($type == 'D    '){
                    location.href = '<%=contextPath%>/challengedetail.cl?cpage=' + $ono;
                } else if($type == 'E    '){
                    location.href = '<%=contextPath%>/detailView.re?opage=' + $ono;
                } else if($type == 'F    '){
                    location.href = '<%=contextPath%>/detail.ho?hno=' + $ono;
                } else if($type == 'G    '){
                    location.href = '<%=contextPath%>/detail.oo?opage=' + $ono;
                }
            })
            
        })
		</script>
    

</div>

</div>

</div>

</div>

<br><br><br><br><br>

    <%@ include file="../common/footer.jsp" %>

</body>
</html>