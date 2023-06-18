<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList, com.kh.board.anonymous.model.vo.SelectAll,com.kh.common.model.vo.*, com.kh.admin.model.vo.Report, com.kh.board.reply.model.vo.*" %>

    <%
    		ArrayList<SelectAll> a = (ArrayList<SelectAll>)request.getAttribute("a");
            Report r =  (Report)request.getAttribute("r");
            Reply reply =  (Reply)request.getAttribute("reply");
    
    %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>덧글 신고 관리</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
<title>Bootstrap Example</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
   <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

   

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

    .content{
        height: 100px;
    }
 
    .report >a{
    margin: 10px;
     }

    
    /* =============== reply ========================================== */


    #reply-area-all{
        border: 1px solid gray;
        width: 800px;
        height: auto;
        margin: auto;
        border-bottom-left-radius: 2%;
        border-bottom-right-radius: 2%;

        
    }
    #reply-area{
        border: 1px solid gray;
        width: 770px;
        height: 140px;
        margin: auto;
        margin-top: 20px;
        border-radius: 10px;
    }
    p{
        text-align: left;
        margin-left: 7px;
        
    }
    .textarea{
        width: 750px;
        margin: auto;
        margin-left: 7px;
        border: none;
    }
   
  
  

    /* 대댓글 대댓글 */

    .rereply_area_2{
        margin-left: 20%;
        width: 700px;
      
    }


    .an_3{
        margin-top: 20px;
        padding-left: 5px;
        border: 1px solid gray;
    }
    #date_area{
        height: 5px;
    }
    #content_area1{
        height: 500px;
    }

    /* 댓글 */

   


    .reply_header{
        margin-top: 20px;
        border: 1px solid gray;
    }
    .reply_footer{
        margin-bottom: 20px;
    }

    .span_class{
        margin-top: 20px;
       
        
    }

    .reply_area3{
        height: 30px;
    }

    #replyList_table{
        height: 500px;
        border: 1px solid black;
        
    }
    #replyList_table td{
        font-size: 30px;
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
   
    
    
    <!---- 컨텐츠 사진 1개 시작 ---->
    
   
	<div class="outer">
        <hr>
        <h2 id="thName">덧글 신고 관리</h2>
        <hr>
    
	
    <thead>
        <table>
          
         
          <tr>
              <td>덧글 번호 : <%=r.getReplyNo() %> &emsp;&emsp;</td>
              <td>신고대상 : <%=r.getMemberId()%>&emsp;&emsp;</td>
              <td align="center">신고 날짜 : <%=r.getReportDate() %>&emsp;&emsp;</td>
              <td id="status">
              	<%if(r.getBoardStatus().equals("Y  ")){ %>
                  		처리완료
                <%}else{ %>
                		  대기
                <%} %>
              </td>
          </tr>
          
          
                <th colspan="5">게시글 번호 : <%=a.get(0).getBoardNo() %>> </th>                    

            </tr>
            
        </table>
    </thead>

    <tbody>

        <table id="title_3">

            <tr >
                <th  colspan="6" >
                    게시글 제목 &emsp;:&emsp; <%=a.get(0).getBoardTitle() %>
                    
                </th>
            </tr>
            
            <tr id="info">
                <td ><img src="" alt=""></td>
                <td> <%=a.get(0).getCategory() %> </td>
                <td colspan="3">| <%=a.get(0).getCreateDate() %> </td>
                <td><img>덧글 이모지 +  <%=a.get(0).getReplyCount() %>  </td>  
                <td>조회수 | <%=a.get(0).getBoardCount()%> </td>              
            </tr>
            
        </table>
            
            <div>
                <table  align="center" width="800" id="replyList_table">
                    <tbody id="replyList_area">
                        
                        
                        <tr class="reply_area3">
                            
                            <td class="reply_header" style="font-size:20px; padding-left: 15px; ">
                                    
                             		   덧글 작성자 : <%=reply.getNickName()%>
                                    
                              </td>
                            </tr>
                            <tr>
                              <td class="reply_header" style="font-size:20px; padding-left: 15px;">
                                덧글 내용  : <%=reply.getReplyContent()%> 
                              </td>
                            </tr>
                            <tr>

                              <td class="reply_header" style=" font-size:small; padding-left:5%" >
                                작성일 :<%=reply.getReplyDate()%>  
                                
                              </td>
                            </tr>
                                  
                          
                        </tbody>
                    </table>        
                </div>       
                
                
      
                
            </table>
            <div class="report" align="center">
                <br><br>
                    <button id="cancell" onclick="cancellReport();">신고 취소</button>
                    <button id="accept" onclick="acceptReport();">신고 처리 완료</button>
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
                location.href ="http://localhost:8002/nosweat/replyReport.list?rPage=1";
              }
              function cancellReport(){
                $.ajax({
                  url: 'cancellReport.re',
                  data: {rno:  <%= r.getReplyNo()%>},
                  success: function(result){
                    console.log(result);
                    alert(result);

                  },
                  error: function(){
                    console.log('실패');
                  }
                });
                $('#cansell').removeAttr('onclick');
              };


              function acceptReport(){
                $.ajax({
                  url: 'acceptReport.re',
                  data: {rno:  <%=r.getReplyNo() %>,
                          mno : <%=r.getMemberNo() %>},
                  success: function(result){
                    console.log(result);
                    alert(result);
                    $('#status').text('처리완료');
                    location.href = 'http://localhost:8002/nosweat/replyReport.list?rPage=1';
                  },
                  error: function(){
                    console.log('실패');
                  }

                });

                $('#accept').removeAttr('onclick');
              }


              if('<%=r.getBoardStatus()%>' =='Y  '){
                $('#cancell').css('display', 'none');
                $('#accept').css('display', 'none');

              }
            </script>

</body>
</html>