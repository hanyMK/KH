<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.admin.model.vo.MessageReport, com.kh.common.model.vo.PageInfo" %>
<%
	ArrayList<MessageReport> list = (ArrayList<MessageReport>)request.getAttribute("list");
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
<title>쪽지 신고 관리</title>

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
    #report{
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
 
    #tableReport{
        width: 800px;
        border: 2px solid gray;
        border-left: none;
        border-right: none;

    }
    #thTitle{
        text-align: center;
    }
    .tableReport>tbody>tr:hover{
        cursor: pointer;
        background-color: #C2E5F2;;
    }
   #textMsg{
      	pointer-events: none;
   }
    .actBtn{
        border-radius: 5px;
        color: #052159;
        background-color: #C2E5F2;
        border: 1px #C2E5F2;
    }


   #board-report, #reply-report, #message-report{
    border: none;
    border-radius: 10px;
    background-color: white;
    color: #052159;
    width: 100px;
    height: 50px;
    box-sizing: border-box;
    font-size: 20px;
   }

   #board-report:hover{
    background-color: #C2E5F2;
    color: #052159;
    cursor: pointer;
   }
   #reply-report:hover{
    background-color: #C2E5F2;
    color: #052159;
    cursor: pointer;
   }
   #message-report:hover{
    background-color: #C2E5F2;
    color: #052159;
    cursor: pointer;
   }

   #board-report:active{
    background-color: #C2E5F2;
    color: #052159;
   }
</style>



</head>
<body>
	<%@include file="../../common/menubar.jsp"%>

  <div id="wrap_12">
    <hr>
    <h2 id="thName">신고 관리</h2>
    <hr>
    
    <div id="report">
        <br>
        <div class="outer" align="center">
          <button id="board-report" >게시글</button>
          <button id="reply-report">덧글신고</button>
          <button id="message-report">쪽지신고</button>
        </div>
        <br>
        <table class="tableReport" border="1" id="tableReport">
            <thead>
                <tr>
                    <th width="100" id="thTitle">쪽지번호</th>
                    <th width="400" id="thTitle">유형</th>
                    <th width="100" id="thTitle">신고대상</th> 
                    <th width="200" id="thTitle">신고날짜</th>
                    <th width="100" id="thTitle">처리결과</th>
                </tr>
            </thead>
            <tbody>
                <% if(list.isEmpty()) { %>
                    <tr>
                        <td colspan="6" id="textMsg">신고된 쪽지가 없습니다.</td>
                    </tr>
                <% } else { %>
                  <%for(MessageReport mr : list){ %>
                    <tr align="center" >
         
                      <td ><%=mr.getMessageNo() %></td>
                      <td><%=mr.getMessageReason() %></td>
                      <td><%=mr.getMemberNo()%></td>
                      <td align="center"><%=mr.getMessageReport() %></td>
                      <td><%if(mr.getMessageStatusR().equals("Y  ")){ %>
                          처리완료
                        <%}else{ %>
                          대기
                        <%} %>
                      </td>
                    </tr>
                    <%} %>
                <% } %>
            </tbody>
        </table>
    
  
    <br><br>
        
        <div align="center" class="paging-area">
    
       <% if(currentPage != 1) {%>
           <button onclick="location.href='<%= contextPath %>/report.list?bPage=<%= currentPage - 1 %>'" class="actBtn">&lt;</button>
        <% } %>
  
     <% for(int i = startPage; i <= endPage; i++) {%>
        <% if(currentPage != i){ %>
           <button onclick="location.href='<%=contextPath %>/report.list?bPage=<%=i %>'" class="actBtn"><%=i %></button>
        <%} else { %>
              <button class="actBtn" disabled><%=i %></button>
              <%} %>
        <%} %>
        
        <% if(currentPage != maxPage) { %>
           <button onclick="location.href='<%=contextPath%>/report.list?bPage=<%=currentPage + 1%>'" class="actBtn">&gt;</button>
        <%} %>
    </div>
        
    </div>   
  </div>
  
  
  
  <!-- 끝 -->



<script>

    
    // $('#board-report').click(function(){
    // })
    $('#tableReport > tbody>tr ').on('click',  function(e){

      //this와 target의 차이.....
      
      var bno = $(this).children().eq(0).text();
      console.log(bno);
      location.href="<%= contextPath %>/messageReport.response?mno=" + bno;
      
    })
    $('#board-report').click(function(){
      location.href = "<%= contextPath %>/report.list?bPage=1";
    })

    $('#reply-report').click(function(){
      location.href = "<%= contextPath %>/replyReport.list?rPage=1";
    })
    $('#message-report').click(function(){
      location.href = "<%= contextPath %>/messageReport.list?mPage=1";
    })


  
 

</script>



 <%@include file="../../common/footer.jsp"%>


</body>
</html>