<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList, com.kh.member.model.vo.*, com.kh.common.model.vo.PageInfo" %>
<%
	ArrayList<MemberMessage> list = (ArrayList<MemberMessage>)request.getAttribute("list");
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
<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script> 
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed&display=swap" rel="stylesheet">
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <title>Bootstrap Example</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

<style>
	#wrap_2{
		width: 1200px;
		height: 800px;
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
	#writerM{
		margin-left: 17px;
	}
	#messageBtn{
		width: 160px;
		text-align: center;
		margin-top: 25px;
		font-size: large;
		color:#052159 ;
        background-color: #C2E5F2;
        border: 1px #C2E5F2;
		height: 30px;
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
	}
	#aMsg{
		font-weight: 500;
		font-size: large;
		color: #052159;
	}
	#aSMsg{
		font-weight: 500;
		font-size: large;
		color: #052159;
	}
	#pMName{
	    text-align: center;
	    font-size: 40px;
	    font-weight: 800;
	    margin-bottom: 20px;
	    color:#052159 ;
	    margin-top: 30px;
	}
	#tableMessage22{
		width: 800px;
		border: 2px solid gray;
		border-left: none;
		border-right: none;
	}
	#search2{
	    width: 410px;
	    left : 130px;
	    position: absolute;
	    margin-top: -3px;
	    border: 1px solid rgb(223,223,223);
	    background-color: #fff;
	    border-radius: 5px;
	    padding: 10px;
	    display: none;
	}
	#search2 > p{
	    background-color: #fff;
	    line-height: 30px;
	    height: 30px;
	    font-size: 14px;
	    text-align: left;
	    z-index: 8888;
	    cursor: pointer;
	}
	#search2 p > img{
	    width: 14px;
	    height: 14px;
	    margin-right: 16px;
	}
	#search2 > p:hover{
	    background-color: rgb(244, 244, 244);
	}
	#textMsg{
		text-alian: center;
		margin-left: 50px;
	}
	#textMsg{
		pointer-events: none;
	}
	.tableMessage>tbody>tr:hover{
        cursor: pointer;
        background-color: #C2E5F2;;
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
					<button type="button" id="messageBtn" class="actBtn" data-bs-toggle="modal" data-bs-target="#writeMessage" data-bs-whatever="@mdo" data-bs-target="#writeMessage" >쪽지쓰기</button><br><br>
					<a id="aMsg" href="<%=contextPath%>/message.me?msgpage=1">받은 쪽지함</a><br><br>
					<a id="aSMsg" href="<%=contextPath%>/messageSand.me?msgSpage=1">보낸 쪽지함</a>
				</div>
			</div>
			<div id="div_2" class="messageSand">
				<br>
				<hr>
					<h2 id="pMName">보낸 쪽지함</h2>
				<hr>
            		<br><br>
				<table class="tableMessage" border="1" id="tableMessage22">
					<thead>
						<tr>
							<th width="50" id="thTitle"></th>
							<th width="150" id="thTitle">받는사람</th>
							<th width="400" id="thTitle">제목</th> 
							<th width="150" id="thTitle">날짜</th>
						</tr>
					</thead>
					<tbody>
						<% if(list.isEmpty()) {%>
							<tr>
								<td colspan="6" id="textMsg">조회된  쪽지가 없습니다.</td>
							</tr>
						<% } else { %>
							<% for(MemberMessage msg : list) { %>
							<tr>
								<td><input type="hidden" name="messageNo" value="<%=msg.getMessageNo()%>"></td>
								<td><%=msg.getToNic() %></td>
								<td><%=msg.getMessageTitle() %></td>
								<td><%=msg.getMessageDate() %></td>
							</tr>
							<% } %>
						<% } %>
					</tbody>
				</table>
				
				<br><br>
            
	            <div align="center" class="paging-area">
	        
		        	<% if(currentPage != 1) {%>
		               <button onclick="location.href='<%= contextPath %>/messageSand.me?msgSpage=<%= currentPage - 1 %>'" class="actBtn">&lt;</button>
		         	<% } %>
		
					<% for(int i = startPage; i <= endPage; i++) {%>
						<% if(currentPage != i){ %>
							<button onclick="location.href='<%=contextPath %>/messageSand.me?msgSpage=<%=i %>'" class="actBtn"><%=i %></button>
						<%} else { %>
		            		<button class="actBtn" disabled><%=i %></button>
		           		 <%} %>
		            <%} %>
		            
		            <% if(currentPage != maxPage) { %>
		            	<button onclick="location.href='<%=contextPath%>/messageSand.me?msgSpage=<%=currentPage + 1%>'" class="actBtn">&gt;</button>
		            <%} %>
	       		</div>
	       		
			</div>
			<div id="div_3">
				<div id="div_4"></div>
			</div>
		</div>
		
	<script>

		$(function(){
			$('.tableMessage>tbody>tr').click(function(){
				location.href = '<%=contextPath%>/enrollSandDetail.ms?msgsdno=' + $(this).children().children().eq(0).val();
			});
		});

			
		
	
	
		function nickSearch(e){
			
	        console.log($(e).val());
	        
	        $.ajax({
	            url : 'msgNickSearch.me',
	            data : {
	                key : $(e).val()
	            },
	            success : function(list){
	                // console.log(list);
	                var searchList = '';
	                for(var i = 0; i < list.length; i++){
	                   if($(e).val() != ''){
	                        searchList += '<p>' + list[i].nickname + '</p>'
	                    }
	                }
	                console.log(searchList)
	                if($(e).val() == '' || list.length == 0){
	                    $('#search2').html('검색결과가 없습니다.');
	                }else{
	                    $('#search2').html(searchList);
	                }
		                $('#search2').css('display','block');


	                $('#search2 > p').click(function(){
	                    var searchChoice = $(this).text();
						console.log(searchChoice);
	                    $('#nickSendSearch').val(searchChoice);
	                    $('#search2').css('display','none');
	                });
	                
	                $('.sendTitle').click(function(){
	                    $('#search2').css('display','none');
	                })

	                $('.sendContent').click(function(){
	                    $('#search2').css('display','none');
	                })
	            },
	            error : function(){
	                console.log('닉네임 검색 실패');
	            }
	        });
		}

		

        
    
	</script>
<!--모달 쪽지 쓰기-->
    <!-- ================================== modal글쓰기 작성란 ========================================================================================================= -->


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
<!--모달 글쓰기 끝-->

	<br>
	<%@ include file="../common/footer.jsp" %>
</body>
</html>