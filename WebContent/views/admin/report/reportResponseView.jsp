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
<title>신고게시판 응답 페이지</title>



<style>

    
	.outer{
        width: 800px;  
        margin: auto;
        background-color: #C2E5F2 ;
        color: black;
        margin-top: 5px;
        border: 1px solid  rgb(116, 116, 116);;
    }
    .list-area{
        text-align: center;
        border: 1px solid white;
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
        align-items: center;
    }
    .outer img{
      align-content: center;
      box-sizing: border-box;
      margin: 10px;
      
    }
    .actBtn{
        border-radius: 5px;
        color: #052159;
        background-color: #C2E5F2;
        border: 1px #C2E5F2;
    }

/* -----------------익명게시판 스타일------ */


    .an_3 tr{
    	border-bottom: 1px solid rgb(116, 116, 116);
    	border-right: 1px solid  rgb(116, 116, 116);
    	border-left: 1px solid  rgb(116, 116, 116);
    }
    .contentA{
        margin-bottom: 20px;
        height: 100px;
        font-weight: 800px;
        font-size: 30px;
       }

      .tbody th{
        padding-left: 20px;
        margin: auto;
      }
     .tbody td{
        padding-left: 20px;
        margin: auto;
      }

      #title_3{
        padding-left: 50px;
        margin: auto;
        font-size: 20px;
      }
      
      #photo_3> img{
        width: auto;
        height: 100px;
      }
      #info{
        font-size: 20px;
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
    <h2 id="thName">덧글 신고 관리</h2>
    <hr>
	
    <thead>
        <table>
          <tr>
              <td>게시글 번호 : <%=b.getBoardNo() %> &emsp;&emsp;</td>
              <td>신고대상 : <%=b.getMemberId()%>&emsp;&emsp;</td>
              <td align="center">신고 날짜 : <%=b.getReportDate() %>&emsp;&emsp;</td>
              <td id="status">대기</td>
          </tr>
          
          
                <th colspan="5">익명게시판 > </th>                    

            </tr>
            
        </table>
    </thead>

    <tbody>

        <table class="an_3" cellspacing="1" style="width:100%; background-color:#fff; font-family:Verdana, Geneva, '나눔고딕', NanumGothic, ng, '맑은 고딕', 'Malgun Gothic', '돋움', Dotum, AppleGothic, sans-serif;font-size:11px; padding:10px; border-spacing:0; letter-spacing:-1px; text-align:left; border-top:1px solid #eee; font-size: 12px;">
            
                
                    <tr >
                    <th id="title_3" colspan="6" >
                    <%=a.get(0).getBoardTitle() %>
                    
                    </th>
                    </tr>

                  <tr id="info">
                    <td ><img src="" alt="">익명사진</td>
                    <td>익명</td>
                    <td colspan="3">| <%=a.get(0).getCreateDate() %> </td>
                    <td><img>덧글 이모지 +  <%=a.get(0).getReplyCount() %>  </td>  
                    <td>조회수 | <%=a.get(0).getBoardCount()%> </td>              
                  </tr>
                 
       <%if(a.get(0).getFileNo()>0){%>
                      
                        
                    <tr id ="photo_3" align="center"  >
                         <td colspan="6"> 
                       <%for(int i = 0; i <a.size(); i++){%>                          
                       <%if(a.get(i).getFileLevel() ==0){ %>
                            <img width="150" height="200" src="<%=contextPath%>/<%=a.get(i).getFilePath() %>">
                       
                           <%}else{%>
                             <img width="150" height="200" src="<%=contextPath%>/<%=a.get(i).getFilePath() %>">
                               <%}%>
                    <%}%>
                        </td>
                    </tr>
       <%}%>
                
                <tr >
                <td id="content_3" class="contentA" colspan="6"   align="center" >
                <%=a.get(0).getBoardContent() %>
                </td>	      
                </tr>   
                
            
                <tr>
                <td id="hashtag" colspan="6" style="color: #1d9bf0;">
                  <!-- <form name="searchTag" action="searchTag.hs" method="post" > -->

                      <ul>
                          
                    </ul>
                <!-- </form> -->
                
                </td>
                </tr>
      
                
            </table>
            <div class="report" align="center">
              

              <button id="cancell" onclick="cancellReport();">신고 취소</button>
              <button id="accept" onclick="acceptReport();">신고 처리 완료</button>
            </div>
        </div>
            
            <%@include file="../../common/footerbar.jsp"%>


            <script>
             //--------------------------------------------------------------------------
            //---------------------------신고 취소 및 신고 승인 창-------------------
            //--------------------------------------------------------------------------
              function cancellReport(){
                $.ajax({
                  url: 'cancellReport.bo',
                  data: {bno:  <%=b.getBoardNo() %>},
                  success: function(result){
                    console.log(result);
                    if(result !=''){
                      
                      $('.report').children().eq(1).attr('onclick', '').unbind('click');
                      alert(result);
                      $('#accept').off('click');
                    }

                  },
                  error: function(){
                    console.log('실패');
                  }
                });

              };


              function acceptReport(){
                $.ajax({
                  url: 'acceptReport.bo',
                  data: {bno:  <%=b.getBoardNo() %>,
                          mno : <%=b.getMemberNo() %>},
                  success: function(result){
                    console.log(result);
                    alert(result);
                    if(result != ''){

                      
                      $('#status').text('처리완료');
                     //$('#accept').attr('onclick', '').unbind('click');
                     // $('#accept').removeAttr('onclick');
                    // $('#accept').off('onclick')
                    
                    $('#accept').off('click');
                      location.href = 'http://localhost:8002/nosweat/report.list?bPage=1';

                    }

                  },
                  error: function(){
                    console.log('실패');
                  }
                  
                });
              }

              
              </script>

</body>
</html>