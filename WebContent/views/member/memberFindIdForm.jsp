<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디찾기</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script> 
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed&display=swap" rel="stylesheet">

<style>
#wrap_111{
    margin : auto;
    width : 1200px;
    height : 600px;
    font-family: 'Roboto Condensed', sans-serif;
}

#profile{
    width: 700px;
    height: 350px;
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
    border-radius: 5px;
    
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
#email1{
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
.hidden{
    display: none;
    font-size: 10px;
    text-align: center;
}
#findBtn{
	margin-left: 100px;
    border-radius: 10px;
}
#trEmail{
    margin-top: 40px;
}
#trId{
    margin-bottom: 40px;
}
#emailCheck{
    border-radius: 10px;
    margin-left: 4px;
}

</style>
</head>

<body>

    <%@ include file="../common/menubar.jsp" %>

    <div id="wrap_111">
        <br><hr>
        <h2 id="h2">아이디찾기</h2>
        <hr>
        
        <br><br>
        <div id="profile">
    
            <table id="profile_1">
                <tr id="trId">
                    <td colspan="3" id="tdName">아이디찾기</td>
                    <td></td>
                </tr>
                <br><br>
                <tr id="trEmail">
                    <td>이메일</td>
                    <td>
                    	<input type="email" name="email1" id="email1" maxlength="50" required>

                    </td>
                    <td><button type="button" id="emailCheck" onclick="emailCheck_1()">중복 확인</button><br>
                </tr>
                
                
            </table>
            <div id="btn">
                <button id="findBtn" onclick="return checkId_2()">아이디찾기</button>
            </div>
            <br><br><br><br><br>

        </div>
        <script>
	        	var flag = 0;
	        	
				function emailCheck_1(){
            		var $email1 = $('#email1').val();
            		console.log($email1);
            		
            	$.ajax({
            		url : 'emailCheck.me',
            		data : {emailCheck : $email1},
            		success : function(result){
            			console.log(result);
	    				if($email1 == ''){
	    					alert('이메일 인증을 해주세요');
	    					flag = 0;
	    				} else {
    						if(result == 'Yes'){
    							alert('가입된 아이디가 없습니다.');
    							flag = 0;
	    					} else{
		    					if(result == 'No'){
		    						alert('이메일 인증에 성공했습니다.');
		    						flag = 1;
	    						}
	    					}
	    				}
	    			},
	    			error : function(){
	    				alert('실패');
	    			}
	    		});
	    	}  
	      
	        
	        function checkId_2(){
	        	
	        	var $email1 = $('#email1').val();
	        	
	        	if($email1 == '' || flag == 0){
	        		alert('이메일 중복확인을 해주세요.');
	        		return false;
	        	} else{
	        		if(flag != 0){      			
			        	$.ajax({ 
			        		url : 'findId.me',
			        		data : {email1 : $email1},
			        		success : function(result){
			        			console.log(result);
			        			if(result != 'Yes'){
			        				alert('회원님의 아이디는 ' + result + '입니다.');
			        			} else if(result == 'Yes'){
									alert('등록된 아이디가 없습니다.');	        				
			        			}
			        		}
			        	});
       				return true;
	        		}
        		}
	        	
	        }
	        
        </script>
        <br><br><br>
    </div>
    

	<%@ include file="../common/footer.jsp" %>
</body>
</html>