<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 창</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>  
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>  
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
    .outer_01{
    	width : 1200px;
    	height : 450px;
    	margin : auto;
    }
    #wrap{
        width : 800px;
        height : 300px;
        margin : auto;
    }
    #login>thead tr, td{
        padding : 8px;
    }
    button{
        color:#052159 ;
        background-color: #C2E5F2;
        border: 1px #C2E5F2;
    }
	#actH2{
        text-align: center;
	    font-weight: 1000;
	    margin-bottom: 40px;
	    margin-top: 40px;
	    color:#052159 ;
    }
	#loginSubmit{
		border-radius: 5px;
	}
</style>

</head>
<body>

<%@ include file="../common/menubar.jsp" %>
<br>
<div class="outer_01">
	    <br><hr>
	        <h2 id="actH2" align="center"><b>로그인</b></h2>
        <hr>
		<br><br>
	<div align="center"  id="wrap">
	       
	    <table id="login" align="center">    
	        <form action="/nosweat/login.me" method="post">
	            
	                <tr>
	                    <th>아이디</th>
	                    <td colspan="2"><input type="text" name="userId" required></td>
	                    <td rowspan="2"><button type="submit" id="loginSubmit">로그인</button></td>
	                </tr>
	                <tr>
	                    <th>비밀번호</th>
	                    <td colspan="2"><input type="password" name="userPwd" required></td>
	                    <td></td>
	                </tr>
	                <tr>
	                    <td> <input type="checkbox"> 아이디 저장 </td>
	                  
	                    <td><input type="checkbox"> 로그인 상태 유지</td>
	                </tr>
	                <tr>
		                <td><a href="<%=contextPath%>/findId.do">아이디 찾기</a></td>
		                <td><a href="<%=contextPath%>/findPwd.do">비밀번호 찾기</a></td>
		                <td><a href="<%=contextPath%>/enrollForm.me">회원가입</a></td>
	                </tr>
	            
	        </form>
	    </table>
	  
	</div>
</div>
	    <br>
	
	    <%@ include file="../common/footer.jsp" %>
</body>
</html>