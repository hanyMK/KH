<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.member.model.vo.*, com.kh.common.model.vo.PageInfo" %>
<%
	
	ArrayList<Alarm> blist = (ArrayList<Alarm>)session.getAttribute("blist");
	ArrayList<Alarm> myBList = (ArrayList<Alarm>)session.getAttribute("myBList");
	PageInfo pib =(PageInfo)session.getAttribute("pib");

    int currentPage = pib.getCurrentPage();
    int startPage = pib.getStartPage();
    int endPage = pib.getEndPage();
    int maxPage = pib.getMaxPage();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 게시글 확인 페이지</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>  
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>  
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
    #outer_010{
        width: 1200px;
        text-align: center;
        margin: auto;
        height: 100%;
    }
    #wrap{
        margin : auto;
        width : 600px;
    }
    #login>thead tr, td{
        padding : 8px;
    }
    button{
        color:#052159 ;
        background-color: #C2E5F2;
        border: 1px #C2E5F2;
    }
    #boardlistdiv{
        margin: auto;
    }
    #boardlist>tbody>tr :hover{
        cursor: pointer;
        background-color: #C2E5F2;
    }
    #gomypage{
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
    .actBtn{
        border-radius: 5px;
        color: #052159;
    }
   
</style>

</head>
<body>

<%@ include file="../common/menubar.jsp" %>
<br>
<div id="outer_010">
    <hr>
        <h2 id="actH2" align="center"><b>내가 작성한 글 </b></h2>
    <hr>

    <div align="center"  id="wrap">

        <div id="myalarm">

        </div>

        <div id="mylist">
            <div id="boardlistouterdiv">

            <div id="boardlistdiv">
                <table id="boardlist" align="center">
                    <thead>
                        <tr>
                            <th></th>
                            <th width="80">No</th>
                            <th width="300">제목</th>
                            <th width="200">작성일</th>
                        </tr>
                    <% if(myBList.isEmpty()) { %>
                        <tr><td colspan="3">작성한 글이 없습니다.</td></tr>
                    </thead>
                    <% } else { %>
                        <% for(Alarm a : myBList) { %>
                    <tbody>
                        <tr>
                            <td><input type="hidden" value="<%= a.getBoardType() %>"></td>
                            <td><%= a.getBoardNo() %></td>
                            <td><%= a.getBoardTitle() %></td>
                            <td><%= a.getCreateDateb() %></td>
                        </tr>
                    </tbody>
                        <% } %>
                    <% } %>
                    
                </table>
            </div>
            </div>
        
            
            <% if(myBList.isEmpty()){} else { %>
            <br><br>
            <div align="center" id="boardlistPage">
                <% if(currentPage != 1) { %>
                        <button onclick="location.href='<%= contextPath %>/myboardList?bcpage=<%= currentPage - 1 %>'" class="actBtn">&lt;</button>
                    <% } %>
                    <% for(int i = startPage; i <= endPage; i++) { %>
                        <% if(currentPage != i) { %>
                            <button onclick="location.href='<%= contextPath %>/myboardList?bcpage=<%= i %>'" class="actBtn"><%= i %></button>
                        <% } else { %>
                            <button class="actBtn" disabled><%= i %></button>
                        <% } %>
                    <% } %>
                    
                    <% if(currentPage != maxPage) { %>
                    <button onclick="location.href='<%= contextPath %>/myboardlist?bcpage=<%=currentPage + 1%>'" class="actBtn">&gt;</button>
                    <% } %>
            </div>
        </div>
            <% } %>
            <br><br>
            
            <button id="gomypage" onclick="gomypage();">내 활동정보로 돌아가기</button>
            <br>
        
<script>
    function gomypage(){       
        location.href="<%=contextPath%>/mypage.me"   
    }
            
    $(function(){
        $('#boardlist>tbody>tr').click(function(){
            var $ono = $(this).children().eq(1).text();
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
            
<br><br>
</div></div>
<br><br>

<%@ include file="../common/footer.jsp" %>

</body>
</html>