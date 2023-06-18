<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.member.model.vo.*, com.kh.common.model.vo.*" %>
<%
	ArrayList<MyPoint> pointList = (ArrayList<MyPoint>)session.getAttribute("pointList");
	ArrayList<MyPoint> pgPointList = (ArrayList<MyPoint>)session.getAttribute("pgPointList");
	PageInfo pip = (PageInfo)session.getAttribute("pip");
	
	int currentPage = pip.getCurrentPage();
    int startPage = pip.getStartPage();
    int endPage = pip.getEndPage();
    int maxPage = pip.getMaxPage();
	
	int sum = 0;
	for(MyPoint a : pointList){
		sum += a.getPoint();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포인트 조회 화면</title>
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
    }
    button{
        color:#052159 ;
        background-color: #C2E5F2;
        border: 1px #C2E5F2;
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

</style>
</head>
<body>

<%@ include file="../common/menubar.jsp" %>
<div id="outer_010">

    <br>
    <hr>
    
    <h2 id="actH2" align="center">내 포인트</h2>
    
    <hr>
    <br><br>
    <table id="pointlist" align="center">
        
        <tr>
            <td colspan="3" height="80"><button class="actBtn" onclick="goNotice();">포인트 쓸 수 있는 이벤트 보러 가기!</button></td>
            
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td><button class="actBtn">총 포인트 <%= sum %></button></td>
        </tr>
        <tr><th colspan="3" style="color:#052159;"><b>상세내역</b></th></tr>
        <tr height="20"></tr>
        <tr>
            <th width="80"></th>
            <th width="300">날짜</th>
            <th width="200">포인트</th>
        </tr>
        <% if(pgPointList.isEmpty()){ %>
            <tr><td colspan="3">포인트 내역이 없습니다.</td></tr>
            <% } else { %>
                <% for(MyPoint p : pgPointList) { %>
                    <tr>
                        <td></td>
                        <td><%= p.getPointDate() %></td>
                        <td><%= p.getPoint() %></td>
                    </tr>
                    <% } %>
                    <% } %>
                </table>
                <div align="center" id="boardlistPage">
                    <% if(currentPage != 1) { %>
                        <button onclick="location.href='<%= contextPath %>/mypoint.me?pcpage=<%= currentPage - 1 %>'">&lt;</button>
                        <% } %>
                        <% for(int i = startPage; i <= endPage; i++) { %>
                            <% if(currentPage != i) { %>
                                <button onclick="location.href='<%= contextPath %>/mypoint.me?pcpage=<%= i %>'"><%= i %></button>
                                <% } else { %>
                                    <button class="btn btn-sm btn-info" disabled><%= i %></button>
                                    <% } %>
                                    <% } %>
                                    
                                    <% if(currentPage != maxPage) { %>
                                        <button onclick="location.href='<%= contextPath %>/mypoint.me?pcpage=<%=currentPage + 1%>'">&gt;</button>
                                        <% } %>
                                    </div>
                                    
                                    <br><br><br>
                                    
                                    <script>
                                        function goNotice(){
                                            
                                            location.href="<%=contextPath%>/noticeblist?nbpage=1";
                                            
                                        }
                                        
                                        
                                        
                                        </script>
</div>

<%@ include file="../common/footer.jsp" %>

</body>
</html>