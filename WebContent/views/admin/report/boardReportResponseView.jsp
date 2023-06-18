<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList, com.kh.board.anonymous.model.vo.SelectAll,com.kh.common.model.vo.*, com.kh.admin.model.vo.Report" %>

    <%
      
            ArrayList<SelectAll> a = (ArrayList<SelectAll>)request.getAttribute("a");
            Report b = (Report)request.getAttribute("b");
    
    
    %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 신고 응답화면</title>


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

      /* border : 1px solid black; */
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
        <h2 id="thName">게시글 신고 관리</h2>
        <hr>
	<table>
    <thead>
        
          <tr>
              <td>게시글 번호 : <%=b.getBoardNo() %> &emsp;&emsp;</td>
              <td>신고대상 : <%=b.getMemberId()%>&emsp;&emsp;</td>
              <td align="center">신고 날짜 : <%=b.getReportDate() %>&emsp;&emsp;</td>
              <td id="status">
       
                			  대기
              
              </td>
          </tr>
          
          <!-- //게시판 타입으로 게시판 이름 지정 -->
          
            <tr>
          
                <th class="boardType" colspan="6"><strong>게시판 ></strong>></th>                    

            </tr>

            <script>
              $(function(){
                var boardType = '<%=b.getBoardType()%>';
                console.log(boardType);
               switch(boardType){
                case 'B    ': $('.outer .boardType').children().before('익명'); break;
                case 'C    ': $('.outer .boardType').children().before('바디프로필'); break;
                case 'D    ': $('.outer .boardType').children().before('챌린지'); break;
                case 'E    ': $('.outer .boardType').children().before('리뷰'); break;
                case 'F    ': $('.outer .boardType').children().before('양도'); break;
                case 'G    ': $('.outer .boardType').children().before('구인'); break;
               }
              })
              

            </script>
            
    </thead>
        </table>

    <tbody>

        <table class="an_3" cellspacing="1" style="width:100%; background-color:#fff; font-family:Verdana, Geneva, '나눔고딕', NanumGothic, ng, '맑은 고딕', 'Malgun Gothic', '돋움', Dotum, AppleGothic, sans-serif;font-size:11px; padding:10px; border-spacing:0; letter-spacing:-1px; text-align:left; border-top:1px solid #eee; font-size: 12px;">
          <thead>
          
            <tr>
                <td colspan="6">카테고리 : <%= a.get(0).getCategory() %></td>
            </tr> 

            <tr>
                <th colspan="6" style="padding-left: 20px;">
                  
                        게시글 제목 :   <%=a.get(0).getBoardTitle() %>| 게시글 번호 <%= a.get(0).getBoardNo()%>
                </th>
                    
            </tr>
            <tr id="nickName_area" style="padding-left: 20px;">
               
                <td style="padding-left: 20px; ">
                        닉네임 : <%=b.getMemberId() %><br>
                       <span style="font-size: 12px;"><%=a.get(0).getCreateDate() %>| 조회수 <%=a.get(0).getBoardCount()%></span> 
                </td>
            </tr>
        </thead>
        <tbody>
            
          <%if(a.get(0).getFileNo()>0){%>
            <tr>
                <td class="content" colspan="5" align="center" >
                    <table>
                    <tr class="upload_poto" >
                        <% for(int i = 0; i < a.size(); i++) {%>
                        <td>
                        <%if(a.get(i).getFileLevel() ==0){ %>
                        <img src="<%=contextPath%>/<%=a.get(i).getFilePath() %>" width="180" height="200"  >
                        <% } else{%>
                       
                        <img src="<%=contextPath%>/<%=a.get(i).getFilePath() %>" width="180" height="200">
                        <% } %>
                        </td>
                    <%}%> 
                    </tr>
                    </table>
                    
                    
                    
                </td>
                <%}%> 
            </tr>
            <tr id="content_area1">
                <td class="content" colspan="6" align="center">

                  <%=a.get(0).getBoardContent() %>

                </td>
            <tr>

                

                <td colspan="6" id="hashtagShow"  style="color: #1d9bf0;">
                </td>
            </tr>

            <!-- ================================================== -->
                
                 
      
                
            </table>
            <div class="report" align="center">
             
                <br><br>
                <button id="cancell" onclick="return cancellReport();">신고 취소</button>
                <button id="accept" onclick="return acceptReport();">신고 처리 완료</button>
                <button class="accept" onclick="back11();">목록으로 돌아가기</button>
                <br><br>
                
            </div>
            
        </div>
            
            <%@include file="../../common/footer.jsp"%>


            <script>
             //--------------------------------------------------------------------------
            //---------------------------신고 취소 및 신고 승인 창-------------------
            //--------------------------------------------------------------------------
            
            
            function back11(){
                location.href ="http://localhost:8002/nosweat/report.list?bPage=1";
              }
            	
              function cancellReport(){
                $.ajax({
                  url: 'cancellReport.bo',
                  data: {bno:  <%=b.getBoardNo() %>},
                  success: function(result){
                    console.log(result);
                    if(result !=''){
                      
                   
                      alert(result);
               
                      location.href = 'http://localhost:8002/nosweat/report.list?bPage=1';
                    }

                  },
                  error: function(){
                    console.log('실패');
                  }
                });
                
              
              };


              function acceptReport(){
                console.log($('#status').text());
                $.ajax({
                  url: 'acceptReport.bo',
                  data: {bno:  <%=b.getBoardNo() %>,
                          mno : <%=b.getMemberNo() %>},
                  success: function(result){
                    console.log(result);
                    alert(result);
                    
                  
                    if(result != ' '){
                      
                      location.href = 'http://localhost:8002/nosweat/boardReport.response?bno=' + '<%=b.getBoardNo() %>';
                      $('#status').text('처리완료');
                    
                      
                      
                    }
                    
                    
                  },
                  error: function(){
                    console.log('실패');
                  }
                  
                });
                
              
              }

              if('<%=b.getBoardStatus()%>' =='Y  '){
                $('#cancell').css('display', 'none');
                $('#accept').css('display', 'none');

              }
              
              
              
              </script>

</body>
</html>