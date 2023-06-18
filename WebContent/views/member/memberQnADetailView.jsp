<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.kh.member.model.vo.*"%>
<%
    MemberQnA q = (MemberQnA)request.getAttribute("q");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의사항 글 확인하기</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script> 
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed&display=swap" rel="stylesheet">

<style>
    *{
       list-style: none;
       text-decoration: none;
       font-family: 'Roboto Condensed', sans-serif;
    }
    #wrap_1{
        width: 1200px;
    	height: 900px;
        text-align: center;
    }
    #myQnADetail{
        width: 800px;
        height: 800px;

        margin: auto;
    }
    #pName{
        text-align: center;
        font-size: 40px;
        font-weight: 800;
        margin-bottom: 20px;
        color:#052159 ;
        margin-top: 30px;
    }
    #detail-area{
        border: 1px solid black;
        width: 600px;
        margin: auto;
        margin-top: 20px;
        margin-bottom: 20px;
    }
    #thTitle{
    	font-size: 20px;
        font-weight: 700;
    }
    tr{
    	border-bottom: 1px solid black;
    }
</style>

</head>
<body>
    <%@ include file="../common/menubar.jsp" %>
    <div class="wrap_1">
        <div id="myQnADetail">
            <p id="pName">문의사항</p>
            <table id="detail-area">
                <tr id="thTitle">
                    <th>제목</th>
                    <td colspan="3"><%=q.getQnaTitle()%></td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td><%=q.getMemberNo()%></td>
                    <th>작성일</th>
                    <td><%=q.getQnaDate() %></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td colspan="3">
                        <p style="height:300px"><%=q.getQnaContent()%></p>
                    </td>
                </tr>               
            </table>

            <div id="answer-area" align="center">
                <table>
                	<thead>
                		<tr>
		                   <th>답변</th>
		                   <td>
		                        <textarea id="QnAanswer" cols="60" rows="3" style="resize: none;" placeholder="추가 문의사항이 있으시면 새롭게 글을 남겨주세요. 감사합니다."></textarea>
		                   </td>
		                   <% if((loginUser.getMemberId()).equals("admin")){ %>
		                   <td><button onclick="insertAnswer();" >답변 등록</button></td>
		                   <% } %>
			           </tr>
			        </thead>
			        <tbody>
                        <tr>
                            <td style="width: 300px;"></td>
                            <td style="width: 100px;"></td>
                        </tr>
			        </tbody>
                </table>
            </div>
            <br>
            
            <div align="center">
                <a href="<%=contextPath%>/qna.me?cpage=1" class="btn btn-sm btn-info" id="back">목록으로</a>
            </div>
            <script>
	            $(function(){
	            	selectAnswerList()
	            	
	            	setInterval(selectAnswerList, 3000);
	            });
	            
	            function selectAnswerList(){
	                $.ajax({
	                    url : 'qlist.do',
	                    data : {qno : <%=q.getQuaNo()%>},
	                    success : function(list){
	                        console.log(list);
	                        
	                        let result = '';
	                        for(let i in list){
	                        	result += '<tr>'
	                        			+ '<td>' + list[i].qnaAnswerContent + '</td>'
	                        			+ '<td>' + list[i].qnaAnswerDate + '</td>'
	                        			+ '</tr>';
	                        };
	                        
	                        $('#answer-area tbody').html(result);
	                    },
	                    error : function(){
	                        console.log('실패');
	                    }
	                });
	            };
	            
                function insertAnswer(){
                	$.ajax({
                		url : 'qaInsert.do',
                		data : {
                			qno : <%=q.getQuaNo()%>,
                			answerContent : $('#QnAanswer').val()
                		},
                		type : 'post',
                		success : function(result){
                			console.log(result);
                			if(result > 0){
                				$('#QnAanswer').val('');
                				selectAnswerList();
                			}
                		},
                		error : function(){
                			console.log('실패');
                		}
                		
                	})
                };
            </script>
        </div>
    </div>
    <%@ include file="../common/footer.jsp" %>
</body>
</html>