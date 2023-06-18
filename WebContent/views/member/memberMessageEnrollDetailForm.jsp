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
		height: 30px;
	}
	.actBtn{
        color:#052159 ;
        background-color: #C2E5F2;
        border: 1px #C2E5F2;
		border-radius: 5px;
		height: 30px;
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
		pointer-events: none;
	}
	#imgAlert{
		margin-right: 0;
		cursor: pointer;
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
					<a id="aMsg" href="<%=contextPath%>/messageSand.me?msgSpage=1">보낸 쪽지함</a>
				</div>
			</div>
			<div id="div_2">
				<br><hr>
					<h2 id="pMName">받은 쪽지</h2>
            	<hr>
					<br><br>
				<table id="detail-area">
	                <tr id="thTitle">
	                	
	                    <th>제목</th>
	                    <td colspan="4"><%=msg.getMessageTitle()%></td>
	                    <td><img src="resources/common_upfiles/alert.png" alt="" width="25" height="25" id="imgAlert" data-bs-toggle="modal" data-bs-target="#writeAlert" data-bs-whatever="@mdo" data-bs-target="#writeAlert" ></td>
	                </tr>
	                <tr>
	                    <th>보낸사람</th>
	                    <td id="sandTd"><%=msg.getFromNic()%></td>
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
						<button type="button" id="messageAnswerBtn" class="actBtn" data-bs-toggle="modal" data-bs-target="#AnswerMessage" data-bs-whatever="@mdo" data-bs-target="#AnswerMessage" onclick="userNic()">답장하기</button>
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

			function userNic(){
				$('#nickSendSearch').val($('#sandTd').text());
			}
			
			function nickSearch(e){
				
		        console.log($(e).val());
		        
		        $.ajax({
		            url : 'msgNickSearch.me',
		            data : {
		                key : $(e).val()
		            },
		            success : function(list){
		                console.log(list);
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

			function backall(){
				location.href = "<%=contextPath%>/message.me?msgpage=1";
			}
		
		</script>

<!--모달 쪽지답장 쓰기-->
    <!-- ================================== modal글쓰기 작성란 ========================================================================================================= -->

	<div class="modal fade" id="AnswerMessage" tabindex="-1" data-bs-backdrop="static" data-bs-keyboard="false" aria-labelledby="exampleModalLabel" aria-hidden="true" >
		<div class="modal-dialog modal-lg">
		  	<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="exampleModalLabel">답장하기</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
			  			  
			  	<div class="modal-body" >
					<form action="<%= contextPath %>/messageAnswer.do" method="post">
					  
						<input type="hidden" name="userNo" value="<%= loginUser.getMemberNo() %>">
											
						<div id="writerM" alian="center">					  
							발 신 : <input type="text" id="nickSand" name="msgSand"  maxlength=20 style="width:670px; height: 40px;" value="<%= loginUser.getNickname() %>" class="modal_form" readonly>	  
						</div>
						<div id="writerM" alian="center">
							수 신 : <input type="text" id="nickSendSearch"  maxlength=20 value="" name="msgSendAnswer" style="width:670px; height: 40px;" readonly>
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

<!-- 신고모달 시작  -->

	<div class="modal fade" id="writeAlert" style="width:400px; margin-left:100px;" tabindex="-1" data-bs-backdrop="static" data-bs-keyboard="false" aria-labelledby="exampleModalLabel" aria-hidden="true" >
		<div class="modal-dialog modal-lg">
		  	<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="exampleModalLabel">쪽지 신고하기</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
			  			  
			  	<div class="modal-body" >
					<form action="<%= contextPath %>/msgInsert.me" method="post">
					  
						<%if(loginUser != null){%>
                  <input type="hidden" class="id123" style="border : none;" name="userNo" value="<%= msg.getMessageNo() %>">
                  <%}%>
              <div class="title">
                쪽지 제목 : <input type="text" class="id123" style="border : none;" name="MessageTitle_1" value="<%=msg.getMessageTitle() %>">
             </div>
              <div class="">
                쪽지 작성자 : <input type="text" class="id123" style="border : none;" name="attacker" id="reportAttacker" value="<%=msg.getFromNic()%>" readonly>
                <input type="hidden" class="id123" name="msgNo" value="<%=msg.getMessageNo()%>">
             
              </div>
                <hr>
             
                <table id="reprot-form" align="center" style="margin-left: auto; margin-right: auto;" style="width:400px; height: 500px;">
                    <tr>
                        <td>
                            <input class="form-check-input" type="radio" name="report" id="report1" value="주제와 맞지 않는 글" checked>
                            <label class="form-check-label" for="report1">
                            주제와 맞지 않는 글
                            </label>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            <input class="form-check-input" type="radio" name="report" id="report2" value="욕설/ 비히발언">
                            <label class="form-check-label" for="report2">
                                욕설/ 비하발언
                            </label>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            <input class="form-check-input" type="radio" name="report" id="report3" value="특정인 비방">
                            <label class="form-check-label" for="report3">
                                특정인 비방
                            </label>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            <input class="form-check-input" type="radio" name="report" id="report4" value="개인 사생활 침해">
                            <label class="form-check-label" for="report4">
                                개인 사생활 침해
                            </label>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            <input class="form-check-input" type="radio" name="report" id="report5" value="19+ 만남/ 유도">
                            <label class="form-check-label" for="report5">
                                19+ 만남/ 유도
                            </label>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            <input class="form-check-input" type="radio" name="report" id="report6" value="음란성">
                            <label class="form-check-label" for="report6">
                                음란성
                            </label>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            <input class="form-check-input" type="radio" name="report" id="report7" value="홍보성 컨텐츠">
                            <label class="form-check-label" for="report9">
                                불법촬영물 등 유통, 신고, 삭제 요청
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input class="form-check-input" type="radio" name="report" id="report8" value="게시글 / 댓글 도배">
                            <label class="form-check-label" for="report8">
                                게시글 / 댓글 도배
                            </label>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            <input class="form-check-input" type="radio" name="report" id="report9" value="홍보성 컨텐츠">
                            <label class="form-check-label" for="report9">
                                홍보성 컨텐츠
                            </label>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            <input class="form-check-input" type="radio" name="report" id="report10" value="기타">
                            <label class="form-check-label" for="report10">
                                기타
                            </label>
                        </td>

                    </tr>

                    <!-- <tr>
                        <td>
                            <textarea name="reason" style="resize: none; width: 200;" cols="40" rows="2" placeholder="신고사유 설명이 필요하신 경우 작성해주세요"></textarea>
                        </td>
                    </tr> -->
                </table>
               <hr style="clear:both">


              <div class="modal-footer">
                  <button type="submit" class="btn btn-primary" id="submit">등록</button>
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
              </div>
					</form>
				</div>
			</div>
		</div>
	</div>

<!-- 신고모달 끝 -->
	<br>
	<%@ include file="../common/footer.jsp" %>
</body>
</html>