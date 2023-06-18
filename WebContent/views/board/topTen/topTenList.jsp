<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList, com.kh.board.topten.model.vo.SelectAll" %>
<%
	ArrayList<SelectAll> list = (ArrayList<SelectAll>)request.getAttribute("list");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인기 게시글</title>

<style>
    *{
       list-style: none;
       text-decoration: none;
    }
    #wrap{
        width: 1200px;
    	height: 1900px;
        text-align: center;
        margin: auto;
    }
    #myQnA{
        width: 800px;
        height: 800px;
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
    }
    #tableQnA{
        width: 800px;
        border: 2px solid gray;
        border-left: none;
        border-right: none;

    }
    .thTitle{
        text-align: center;
        color: #052159;
        font-weight: 700;
    }
    .thTitle1{
        text-align: center;
        display : none;
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

<%@ include file="../../common/menubar.jsp" %>
	<br>
    <div id="wrap">
        <br><hr>
        <h2 id="thName">인기 급상승</h2>
        <hr>
        <br><br>
        <div id="myQnA">
            <br>
            <br>
            <table class="tableQnA" border="1" id="tableQnA">
                <thead>
                    <tr>
                    	<th width="100" class="thTitle">게시글 번호</th>
                    	<th width="1" class="thTitle1">타입</th>
                        <th width="360" class="thTitle">제목</th>
                        <th width="100" class="thTitle">작성자</th> 
                        <th width="70" class="thTitle">작성일</th>
                        <th width="60" class="thTitle">조회수</th>
                    </tr>
                </thead>
                <tbody>
                    <% if(list.isEmpty()) { %>
                        <tr>
                            <td colspan="6" id="textMsg">조회된 게시글이 없습니다.</td>
                        </tr>
                    <% } else { %>
                        <% for(SelectAll tt : list) { %>
                        <tr>
                        	<td><%=tt.getBoardNo() %></td>
                        	<td class="thTitle1"><%=tt.getBoardType() %></td>
                            <td><%=tt.getBoardTitle() %></td>
                            <td><%=tt.getNickName() %></td>
                            <td><%=tt.getCreateDate() %></td>
                            <td><%=tt.getBoardCount() %></td>
                        </tr>
                        <% } %>
                    <% } %>
                </tbody>
            </table>
        <script>
        $(function(){
            $('.tableQnA>tbody>tr').click(function(){
               
               console.log($(this).children().eq(1).text());
               
               var addr = $(this).children().eq(1).text();   
               
               var click = $(this).children().eq(0).text();
               
               if(addr ==  'A    '){
                  location.href = '<%=contextPath%>/detail.noticeList?bno=' + click;
               } else if(addr == 'B    '){
                  location.href = '<%=contextPath%>/detail.an?bno=' + click;
               } else if(addr == 'C    '){
                  location.href = '<%=contextPath%>/bodyDetail.by?boardNo=' + click;
               } else if(addr == 'D    '){
                  location.href = '<%=contextPath%>/challengedetail.cl?cpage=' + click;
               } else if(addr == 'E    '){
                  location.href = '<%=contextPath%>/detailView.re?opage=' + click;
               } else if(addr == 'F    '){
                  location.href = '<%=contextPath%>/detail.ho?hno=' + click;
               } else if(addr == 'G    '){
                  location.href = '<%=contextPath%>/detail.oo?opage=' + click;
               }
            });
         });
         
	    	
	    	
        </script>

        <br><br>
            
     
            
        </div>	
	</div>



<%@ include file="../../common/footer.jsp" %>

</body>
</html>