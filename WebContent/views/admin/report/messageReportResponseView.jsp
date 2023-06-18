<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.admin.model.vo.MessageReport, com.kh.common.model.vo.*, com.kh.member.model.vo.MemberMessage" %>

<%
  
	ArrayList<MemberMessage> list = (ArrayList<MemberMessage>)request.getAttribute("mms");
    MessageReport mr = (MessageReport)request.getAttribute("mr");


%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쪽지 신고 응답화면</title>


<style>

  .outer{
      width: 800px;  
      margin: auto;
      margin-top: 5px;
  }
  .list-area{
      text-align: center;
  }

  .list-area > tbody >tr:hover{
      cursor: pointer;
      background-color: crimson;
  }

  .outer table{
      padding-bottom: 500px;
    
  }

  .outer table, tr, th, td{
          height: 50px;
  }


  .contentA{
      height: 100px;
  }

  .report >a{
    margin: 10px;
  }

  .an_3{
      margin-top: 20px;
      padding-left: 5px;
      border: 1px solid black;
      
      
  }

  #cancell{
      color:#052159 ;
      background-color: #C2E5F2;
      border: 1px #C2E5F2;
      border-radius: 5px;
      color: #052159;
   }
   #accept{
      color:#052159 ;
      background-color: #C2E5F2;
      border: 1px #C2E5F2;
      border-radius: 5px;
      color: #052159;
      margin-left: 8px;
   }

   .accept{
      color:#052159 ;
      background-color: #C2E5F2;
      border: 1px #C2E5F2;
      border-radius: 5px;
      color: #052159;
      margin-left: 8px;
    }
 
   #thName{
      text-align: center;
      font-weight: 1000;
      margin-bottom: 40px;
      margin-top: 40px;
      color:#052159 ;
    }
 
</style>
</head>
<body>


	<%@include file="../../common/menubar.jsp"%>


	
	<div class="outer">
        <hr>
        <h2 id="thName">쪽지 신고 관리</h2>
        <hr>

    <thead>
        
          <tr>
              <td>쪽지 번호 : <%=mr.getMessageNo() %> &emsp;&emsp;</td>
              <td>신고대상 : <%=mr.getMemberNo()%>&emsp;&emsp;</td>
              <td align="center">신고 날짜 : <%=mr.getMessageReport() %>&emsp;&emsp;</td>
              <td id="status">
                <%if(mr.getMessageStatusR().equals("Y  ")){ %>
                  처리완료
                <%}else{ %>
                  대기
                <%} %>
              </td>
          </tr>

    </thead>

    <tbody>
        <table class="an_3" cellspacing="1" style="width:100%; background-color:#fff; font-family:Verdana, Geneva, '나눔고딕', NanumGothic, ng, '맑은 고딕', 'Malgun Gothic', '돋움', Dotum, AppleGothic, sans-serif;font-size:11px; padding:10px; border-spacing:0; letter-spacing:-1px; text-align:left; border-top:1px solid #eee; font-size: 12px;">
          <thead>
            <tr>
                <th colspan="6" style="padding-left: 20px;">
                  
                        쪽지 제목 :   <%=list.get(0).getMessageTitle() %>| 쪽지 번호 <%= list.get(0).getMessageNo()%>
                </th>        
            </tr>
            <tr id="nickName_area" style="padding-left: 20px;">
                <td style="padding-left: 20px; ">
                        닉네임 : <%=list.get(0).getFromNic() %><br>
                       <span style="font-size: 12px;"><%=list.get(0).getMessageDate() %></span> 
                </td>
            </tr>
          </thead>
          <tbody>
            <tr id="content_area1">
                <td class="content" colspan="6" align="center">

                  <%=list.get(0).getMessageContent() %>

                </td>
            </tr>
          </tbody>

            <!-- ================================================== -->
        </table>
    </tbody>
            <div class="report" align="center">
                <br><br>
                  <button id="cancell" onclick="return cancellReport();">신고 취소</button>
                  <button id="accept" onclick="return acceptReport();">신고 처리 완료</button>
                  <button class="accept" onclick="back11();">목록으로 돌아가기</button>
                <br><br>  	
            </div>            
</div>
<br><br>
            
          <%@include file="../../common/footer.jsp"%>


            <script>

            //---------------------------신고 취소 및 신고 승인 창-------------------
              function back11(){
                location.href ="http://localhost:8002/nosweat/messageReport.list?mPage=1";
              }
            	
              function cancellReport(){
                $.ajax({
                  url: 'messageCancel.ms',
                  data: {mno:  <%=mr.getMessageNo() %>},
                  success: function(result){
                    console.log(result);
                    if(result !=''){
                      
                   
                      alert(result);
                      $('#accept').off('click');
                      location.href = 'http://localhost:8002/nosweat/report.list?bPage=1';
                    }

                  },
                  error: function(){
                    console.log('실패');
                  }
                });
                
                $('#cancell').attr('onclick', '').unbind('click');
              };


              function acceptReport(){
                console.log($('#status').text());
                $.ajax({
                  url: 'acceptMessageReport.ms',
                  data: {bno:  <%=mr.getMessageNo() %>,
                         mno : '<%=list.get(0).getFromNic() %>'},
                  success: function(result){
	                    console.log(result);
	                    alert(result);
	                    
	                  
	                    if(result){
	                      	$('#status').text('처리완료');
	                       	$('#accept').removeAttr('onclick');
	                       //$('#accept').off('onclick')
	                    }
                  },
                  error: function(){
                    console.log('실패');
                  }
                  
                });

              }
			            if('<%=mr.getMessageStatusR()%>' == 'Y  '){
			                $('#cancell').css('display', 'none');
			                $('#accept').css('display', 'none');
			            }

              
              
              </script>

</body>
</html>