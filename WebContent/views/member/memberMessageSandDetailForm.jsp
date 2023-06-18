<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.kh.member.model.vo.*"%>
<%
    MemberMessage msg = (MemberMessage)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <title>Bootstrap Example</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script> 
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed&display=swap" rel="stylesheet">
<style>
#wrap_2{
		width: 1200px;
		height: 700px;
		margin: auto;
	}
	#div_1{
		width: 198px;
		height: 800px;
		float: left;
	}

	#div_2{
		width: 800px;
		height: 800px;
		float: left;
	}
	#div_3{
		width: 198px;
		height: 800px;
		float: left;		
	}
	#div_4{
		height: 200px;
		
	}
	#div_5{
		height: 300px;
		text-align: center;
		
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
    #pMName{
        text-align: center;
        font-size: 40px;
        font-weight: 800;
        margin-bottom: 20px;
        color:#052159 ;
        margin-top: 30px;
    }
    
    #messageBtn{
		width: 160px;
		text-align: center;
		margin-top: 25px;
		font-size: large;
	}
	.actBtn{
        color:#052159 ;
        background-color: #C2E5F2;
        border: 1px #C2E5F2;
		height: 30px;
		border-radius: 5px;
    }
	.actBtn1{
      	background-color: rgb(54, 54, 71);
      	color: white;
      	height: 30px;
		border-radius: 5px;
		height: 30px;
   }
	#aMsg{
		font-weight: 500;
		font-size: large;
		color: #052159;
	}
	a{
		text-decoration: none;
	}
</style>
</head>
<body>
	
	<%@ include file="../common/menubar.jsp" %>
		
		<div id="wrap_2">
			<div id="div_1">
				<div id="div_5">
					<button type="button" class="actBtn" id="messageBtn" data-bs-toggle="modal" data-bs-target="#writeMessage" data-bs-whatever="@mdo" data-bs-target="#writeMessage" >쪽지쓰기</button><br><br>
					<a id="aMsg" href="<%=contextPath%>/message.me?msgpage=1">받은 쪽지함</a><br><br>
					<a id="aMsg" href="<%=contextPath%>/messageSand.me?msgSpage=1">보낸 쪽지함</a>
				</div>
			</div>
			<div id="div_2">
				<br>
				<hr>
					<h2 id="pMName">보낸 쪽지</h2>
				<hr>
            		<br><br>
				<table id="detail-area">
	                <tr id="thTitle">
	                    <th>제목</th>
	                    <td colspan="3"><%=msg.getMessageTitle()%></td>
	                </tr>
	                <tr>
	                    <th>받은사람</th>
	                    <td><%=msg.getToNic()%></td>
	                    <th>작성일</th>
	                    <td><%=msg.getMessageDate() %></td>
	                </tr>
	                <tr>
	                    <th>내용</th>
	                    <td colspan="3">
	                        <p style="height:300px"><%=msg.getMessageContent()%></p>
	                    </td>
	                </tr>               
            	</table>
           		<br>
            
            	<div align="center">
					<form action="<%=contextPath%>/deleteMessage.me">
						<input type="hidden" name="messageNoo" value="<%=msg.getMessageNo()%>">
						<button type="submit" class="actBtn">삭제하기</button>
						<button type="button" class="actBtn" onclick="backall();" >목록으로</button>
					</form>
	        	</div>
		
			</div>
			<div id="div_3">
				<div id="div_4"></div>
			</div>
		</div>

		<script>

			function backall(){
				location.href = "<%=contextPath%>/messageSand.me?msgSpage=1";
			}
		</script>

		<!-- 쪽지쓰기 선택했을때 모달창  -->
	<div class="modal fade" id="writeMessage" tabindex="-1" data-bs-backdrop="static" data-bs-keyboard="false" aria-labelledby="exampleModalLabel" aria-hidden="true" >
		<div class="modal-dialog modal-lg">
		  	<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="exampleModalLabel">쪽지쓰기</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
			  			  
			  	<div class="modal-body" >
					<form action="<%= contextPath %>/messageAnswer.do" method="post">
					  
						<input type="hidden" name="userNo" value="<%= loginUser.getMemberNo() %>">
											
						<div id="writerM" alian="center">					  
							발 신 : <input type="text" id="nickSand" name="msgSand"  maxlength=20 style="width:670px; height: 40px;" value="<%= loginUser.getNickname() %>" class="modal_form" readonly>	  
						</div>
						<div id="writerM" alian="center">
							수 신 : <input type="text" id="nickSendSearch"  maxlength=20 value="" name="msgSendAnswer" style="width:670px; height: 40px;" onkeyup="nickSearch(this);">
						</div>
						<div id="search2">
                        	<p></p>
                    	</div>	
                    	<div id="writerM" alian="center">
                    		제 목 : <input type="text" id="msg_title" name="msgTitle" class="sendTitle" style="width:670px; height: 40px;">                      	
                    	</div>
						<br>
						<div class="content" >
							<textarea style="resize: none; width: 763px; height: 300px;"  placeholder="자유롭게 쪽지를 주고받으세요."
							id="textarea" name="magContent" class="sendContent" required></textarea>
						</div> 
						<div>
							<hr>
							<button type="submit" class="actBtn" id="submit">보내기</button>
                    		<button type="button" class="actBtn1" data-bs-dismiss="modal">닫기</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
<!--모달 쪽지쓰기 끝-->
	<br>
	<%@ include file="../common/footer.jsp" %>
</body>
</html>