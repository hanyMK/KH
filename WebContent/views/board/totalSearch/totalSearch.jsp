<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.board.totalSearch.model.vo.TotalAll" %>
<%
	ArrayList<TotalAll> list = (ArrayList<TotalAll>)request.getAttribute("list");
%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색 디테일</title>

<!--
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
-->
   

<style>

    .outer{
        margin-top: 10px;
        width: 800px;  
        height: 800px;
        margin: auto;
        margin-top: 15px;
        /*border: 1px solid black;*/
    }

    #div1, #div3, #div5{
        margin-top: 20px;
        float: left;
        height: 200px;
        width: 385px;
        margin-right: 20px;
        /*border: 1px solid black;*/
    }
    #div2, #div4, #div6{
        margin-top: 20px;
        float: left;
        height: 200px;
        width: 385px;
        /*border: 1px solid black;*/
    }
    .tableQnA{
        border-radius: 2px;
        border-color: white;
        border-top: 1px black;
        border-bottom: 1px black;
    }
    .h04{
        color: #052159;
        font-weight: 600;
    }
    .tableQnA>tbody>tr:hover{
        cursor: pointer;
        background-color: #C2E5F2;;
    }
    #textMsg{
		pointer-events: none;
	}
    .plusdiv{
        margin-left: 300px;
        cursor: pointer;
    }
</style>


</head>
<body>

	<%@ include file="../../common/menubar.jsp" %>
 

<div class="outer">
    <div id="div1">
        <h4 class="h04">익명</h4>
        <table class="tableQnA" border="1" id="tableQnA">
                <thead>
                    <tr>
                    	<th width="60" id="thTitle">글번호</th>
                    	<th width="60" id="thTitle">게시판</th>
                        <th width="250" id="thTitle">제목</th>
                    </tr>
                </thead>
                <tbody>
                        <% if(list.isEmpty()) { %>
                            <tr>
                                <td colspan="3" id="textMsg">조회된 게시글이 없습니다.</td>
                            </tr>
                        <% } else { %>
                            <% for(TotalAll ta : list) { %>
	                            <tr>
	                                <% if (ta.getBoardType().equals("익명")) {%>
	                                <td><%=ta.getBoardNo() %></td>
	                                <td><%=ta.getBoardType() %></td>
	                                <td><%=ta.getBoardTitle() %></td>
									<%} %>
	                            </tr>
                            <% } %>
                                <div class="plusdiv" onclick="plusSearch()">+ 더보기</div>
                        <% } %>
                </tbody>
        </table>
    </div>
    <div id="div2">
        <h4 class="h04">바디프로필</h4>
        <table class="tableQnA" border="1" id="tableQnA">
                <thead>
                    <tr>
                     	<th width="60" id="thTitle">글번호</th>
                    	<th width="60" id="thTitle">게시판</th>
                        <th width="250" id="thTitle">제목</th>
                    </tr>
                </thead>
                <tbody>
                    <% if(list.isEmpty()) { %>
                            <tr>
                                <td colspan="3" id="textMsg">조회된 게시글이 없습니다.</td>
                            </tr>
                        <% } else { %>
                            <% for(TotalAll ta : list) { %>
	                            <tr>
	                                <% if (ta.getBoardType().equals("바프")) {%>
	                                <td><%=ta.getBoardNo() %></td>
	                                <td><%=ta.getBoardType() %></td>
	                                <td><%=ta.getBoardTitle() %></td>
									<%} %>
	                            </tr>
                            <% } %>
                                <div class="plusdiv" onclick="plusSearch()">+ 더보기</div>
                        <% } %>
                </tbody>
        </table>
    </div>
    <br>
    <div id="div3">
        <h4 class="h04">챌린지</h4>
        <table class="tableQnA" border="1" id="tableQnA">
                <thead>
                    <tr>
                    	<th width="60" id="thTitle">글번호</th>
                    	<th width="60" id="thTitle">게시판</th>
                        <th width="250" id="thTitle">제목</th>
                    </tr>
                </thead>
                <tbody>
                    <% if(list.isEmpty()) { %>
                            <tr>
                                <td colspan="3" id="textMsg">조회된 게시글이 없습니다.</td>
                            </tr>
                        <% } else { %>
                            <% for(TotalAll ta : list) { %>
	                            <tr>
	                                <% if (ta.getBoardType().equals("챌린지")) {%>
	                                <td><%=ta.getBoardNo() %></td>
	                                <td><%=ta.getBoardType() %></td>
	                                <td><%=ta.getBoardTitle() %></td>
									<%} %>
	                            </tr>
                            <% } %>
                                <div class="plusdiv" onclick="plusSearch()">+ 더보기</div>
                        <% } %>
                </tbody>
        </table>
    </div>
    <div id="div4">
        <h4 class="h04">리뷰</h4>
        <table class="tableQnA" border="1" id="tableQnA">
                <thead>
                    <tr>
                    	<th width="60" id="thTitle">글번호</th>
                    	<th width="60" id="thTitle">게시판</th>
                        <th width="250" id="thTitle">제목</th>
                    </tr>
                </thead>
                <tbody>
                    <% if(list.isEmpty()) { %>
                            <tr>
                                <td colspan="3" id="textMsg">조회된 게시글이 없습니다.</td>
                            </tr>
                        <% } else { %>
                            <% for(TotalAll ta : list) { %>
	                            <tr>
	                                <% if (ta.getBoardType().equals("리뷰")) {%>
	                                <td><%=ta.getBoardNo() %></td>
	                                <td><%=ta.getBoardType() %></td>
	                                <td><%=ta.getBoardTitle() %></td>
									<%} %>
	                            </tr>
                            <% } %>
                                <div class="plusdiv" onclick="plusSearch()">+ 더보기</div>
                        <% } %>
                </tbody>
        </table>
    </div>
    <br>
    <div id="div5">
        <h4 class="h04">양도</h4>
        <table class="tableQnA" border="1" id="tableQnA">
                <thead>
                    <tr>
                    	<th width="60" id="thTitle">글번호</th>
                    	<th width="60" id="thTitle">게시판</th>
                        <th width="250" id="thTitle">제목</th>
                    </tr>
                </thead>
                <tbody>
                    <% if(list.isEmpty()) { %>
                            <tr>
                                <td colspan="3" id="textMsg">조회된 게시글이 없습니다.</td>
                            </tr>
                        <% } else { %>
                            <% for(TotalAll ta : list) { %>
	                            <tr>
	                                <% if (ta.getBoardType().equals("양도")) {%>
	                                <td><%=ta.getBoardNo() %></td>
	                                <td><%=ta.getBoardType() %></td>
	                                <td><%=ta.getBoardTitle() %></td>
									<%} %>
	                            </tr>
                            <% } %>
                                <div class="plusdiv" onclick="plusSearch()">+ 더보기</div>
                        <% } %>
                </tbody>
        </table>
    </div>
    <div id="div6">
        <h4 class="h04">구인</h4>
        <table class="tableQnA" border="1" id="tableQnA">
                <thead>
                    <tr>
                    	<th width="60" id="thTitle">글번호</th>
                    	<th width="60" id="thTitle">게시판</th>
                        <th width="250" id="thTitle">제목</th>
                    </tr>
                </thead>
                <tbody>
                    <% if(list.isEmpty()) { %>
                            <tr>
                                <td colspan="3" id="textMsg">조회된 게시글이 없습니다.</td>
                            </tr>
                        <% } else { %>
                            <% for(TotalAll ta : list) { %>
	                            <tr>
	                                <% if (ta.getBoardType().equals("구인")) {%>
	                                <td><%=ta.getBoardNo() %></td>
	                                <td><%=ta.getBoardType() %></td>
	                                <td><%=ta.getBoardTitle() %></td>
									<%} %>
	                            </tr>
                            <% } %>
                                <div class="plusdiv" onclick="plusSearch()">+ 더보기</div> 
                        <% } %>
                </tbody>
        </table>
    </div>
   
   <script>
	    	$(function(){
	    		$('.tableQnA>tbody>tr').click(function(){
	    			
	    			console.log($(this).children().eq(1).text());
	    			
	    			var addr = $(this).children().eq(1).text();	
	    			
	    			var click = $(this).children().eq(0).text();
	    			
	    			if(addr ==  '공지사항'){
	    				location.href = '<%=contextPath%>/=' + click;
	    			} else if(addr == '익명'){
	    				location.href = '<%=contextPath%>/detail.an?bno=' + click;
	    			} else if(addr == '바프'){
	    				location.href = '<%=contextPath%>/' + click;
	    			} else if(addr == '챌린지'){
	    				location.href = '<%=contextPath%>/challengedetail.cl?cpage=' + click;
	    			} else if(addr == '리뷰'){
	    				location.href = '<%=contextPath%>/=' + click;
	    			} else if(addr == '양도'){
	    				location.href = '<%=contextPath%>/=' + click;
	    			} else if(addr == '구인'){
		    			location.href = '<%=contextPath%>/detail.oo?opage=' + click;
	    			}
	    		});
	    	});
	    	
	    	
        </script>




   
   
</div>  
   <br><br>
   <%@ include file="../../common/footer.jsp" %>
   
   
</body>
</html>