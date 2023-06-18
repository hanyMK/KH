<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호찾기</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script> 
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed&display=swap" rel="stylesheet">

<style>
#wrap{
    margin : auto;
    width : 1200px;
    height : 600px;
    font-family: 'Roboto Condensed', sans-serif;
}

#profile{
    width: 700px;
    height: 400px;
    border-radius: 5px;
    border: 0.5px rgb(81, 80, 80) solid;
    margin: auto;
}
#profile_1{
    margin: auto;
    margin-top: 50px;
    margin-bottom: 40px;
    padding: 16px;
}
#btn{
    width : 310px;
    margin: auto;
    
}
button{
    color:#052159 ;
    background-color: #C2E5F2;
    border: 1px #C2E5F2;
    height: 40px;
}
#h2{
    text-align: center;
    font-weight: 1000;
    margin-bottom: 40px;
    margin-top: 40px;
    color:#052159 ;
}
#id1{
    width: 350px;
    height: 40px;
}
#tdName{
    text-align: center;
    font-size: 23px;
    font-weight: 800;
    margin-bottom: 40px;
    color:#052159 ;
}
#findBtn{
	margin-left: 55px;
}
#trEmail{
    margin-top: 40px;
}
#trId{
    margin-bottom: 40px;
}
#findUpdateBtn{
	display : none;
}
#email1{
	width: 350px;
    height: 40px;
}
.actBtn{
	border-radius: 5px;
	margin-left: 10px;
}

</style>
</head>

<body>

    <%@ include file="../common/menubar.jsp" %>

    <div id="wrap" border="1">
		<br><hr>
        <h1 id="h2">비밀번호 찾기</h1>
        <hr>

		<br><br>
        <div id="profile">
    
            <table id="profile_1">
                <tr id="trId">
                    <td colspan="3" id="tdName">비밀번호 찾기</td>
                    <td></td>
                </tr>
                <br><br>
                <tr id="trId">
                    <td>아이디</td>
                    <td>
                    	<input type="text" name="id1" id="id1" maxlength="50" required>

                    </td>
                    <td><button type="button" class="actBtn" id="checkId" onclick="idCheck_1()">중복 확인</button><br>
                </tr>
                <tr id="trEmail">
                    <td>이메일</td>
                    <td>
                    	<input type="email"  name="email1" id="email1" maxlength="50" required>
                    </td>
                    <td><button type="button" class="actBtn" id="emailCheck" onclick="emailCheck_1()">중복 확인</button><br>
                </tr>
                
                
            </table>
            <div id="btn">
                <button class="actBtn" id="findBtn" onclick="return checkPwd_2()">비밀번호 찾기</button>
                <button class="actBtn" id="findUpdateBtn" data-toggle="modal" data-id="id1" data-target="#changePwdMember">비밀번호 수정</button>
            </div>
            <br><br><br><br><br>

        </div>
        <script>
	        	var flag = 0;
	        	var chk = 0;
	        	
	        	function idCheck_1(){
	            	
	            	var $id = $('#id1').val();
	            	console.log($id)
	            	
	            	$.ajax({
	            		url: 'idCheck.me',
	            		data : {checkId : $id},
	            		success : function(result){
	            			console.log(result);
		    				if($id == ''){
		    					alert('아이디 인증을 해주세요');
		    					flag = 0;
		    				} else {
	    						if(result == 'Yes'){
	    							alert('가입된 아이디가 없습니다.');
	    							flag = 0;
		    					} else{
			    					if(result == 'No'){
			    						alert('아이디 인증에 성공했습니다.');
			    						flag = 1;
		    						}
		    					}
		    				}
		    			}
	            	});
	            }
	        	
				function emailCheck_1(){
            		var $email1 = $('#email1').val();
            		//console.log($email1);
            		
            	$.ajax({
            		url : 'emailCheck.me',
            		data : {emailCheck : $email1},
            		success : function(result){
            			console.log(result);
	    				if($email1 == ''){
	    					alert('이메일 인증을 해주세요');
	    					chk = 0;
	    				} else {
    						if(result == 'Yes'){
    							alert('가입된 아이디가 없습니다.');
    							chk = 0;
	    					} else{
		    					if(result == 'No'){
		    						alert('이메일 인증에 성공했습니다.');
		    						chk = 1;
	    						}
	    					}
	    				}
	    			}
	    		});
	    	}  
	      
	        
	        function checkPwd_2(){
	        	
	        	var $id = $('#id1').val();
	        	var $email1 = $('#email1').val();
	        	
	        	if($id == '' || flag == 0){
	        		alert('아이디 중복확인을 해주세요.');
	        		return false;
	        	} else if($email1 == '' || flag == 0){
	        		alert('이메일 중복확인을 해주세요.');
	        		return false;
	        	} else{
	        		if(flag != 0){      			
			        	$.ajax({ 
			        		url : 'findPwd.me',
			        		data : {email1 : $email1,
			        				id : $id},
			        		success : function(result){
				        			console.log(result);
				       				console.log(flag);
				       				console.log(chk);
			        			if(result == 'No' && flag != 0 && chk != 0){
				       				alert('정보조회에 성공했습니다.');
				       				if($('#findUpdateBtn').css('display', 'none')){
				       					$('#findUpdateBtn').css('display','inline');}
			        			} else {
				       				 if(result == 'Yes' && flag == 0 && chk == 0){
										alert('아이디와 이메일이 일치하지 않습니다.');
										return false;
				       			 		}
			        				}
			        			}
			        		});
	        			}
        			}
       			}
	        
	        
	        function validateFindPwd(){
	        	if($('input[name=checkPwdMember]').val() != $('input[name=updatePwdMember]').val()){
	        		alert('비밀번호가 일치하지 않습니다.');
	        		return false;
	        	}else{    	        	
	        		alert('비밀번호가 변경되었습니다.');
	        		return true;
	        	}
	        }
	        
	        $(function () {
	            $('#findUpdateBtn').click(function (e) {
	            	var id1111 = $('#id1').val();
	        		$('#id11').val(id1111); 
	            });
	        })


        </script>
        <br><br><br>
        
<!-- 비밀번호 변경 모달 창 -->
    <div class="modal" id="changePwdMember">
        <div class="modal-dialog">
            <div class="modal-content">
                
                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">비밀번호 변경</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                
                <!-- Modal body -->
                <div class="modal-body">
                    <form action="<%=contextPath%>/pwdFindUpdate.me" method="post">

                        <div class="form-group">
                            <label for="updatePwd">변경할 비밀번호 : </label>
                            <input type="password" class="form-control" required id="updatePwdMember" placeholder="변경할 비밀번호를 입력해주세요." name="updatePwdMember">
                        </div>

                        <div class="form-group">
                            <label for="updatePwd">변경할 비밀번호 확인 : </label>
                            <input type="password" class="form-control" required placeholder="변경할 비밀번호를 다시 입력해주세요" name="checkPwdMember">
                            
                            <input type="hidden" name="id11" id="id11">
                         	
                        </div>

                        <button id="btnCenter" type="submit" class="btn btn-primary" onclick="return validateFindPwd()">비밀번호 변경</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    </div>
    
	<br><br>
	<%@ include file="../common/footer.jsp" %>
</body>
</html>