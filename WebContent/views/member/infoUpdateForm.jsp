<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보수정</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script> 
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed&display=swap" rel="stylesheet">

<style>
#wrap_11{
    margin : auto;
    width : 1200px;
    height : 500px;
    font-family: 'Roboto Condensed', sans-serif;
}

#profile{
    width: 700px;
    height: 430px;
    border: 1px black solid;
    border-radius: 30px;
    margin: auto;
}
#profile_1{
    margin: auto;
    margin-top: 50px;
    margin-bottom: 40px;
    padding: 16px;
    color: #052159;
}
#btn{
    width : 310px;
    margin: auto;
    
}
.infoBtn{
    color:#052159 ;
    background-color: #C2E5F2;
    border: 1px #C2E5F2;
    height: 30px;
    border-radius: 5px;

}
#h2{
    text-align: center;
    font-weight: 1000;
    margin-bottom: 40px;
    margin-top: 40px;
    color:#052159 ;
}
#inputhh{
    width: 350px;
    height: 40px;
    border: none;
    border-bottom: solid 1px black;
}
#inputhh1{
    width: 430px;
    height: 40px;
    border: none;
    border-bottom: solid 1px black;
}
#nickname1{
    width: 269px;
}
#tdName{
    text-align: center;
    font-size: 23px;
    font-weight: 800;
    margin-bottom: 20px;
    color:#052159 ;
}
.hidden{
    display: none;
    font-size: 15px;
    }
.hidden1{
    display: none;
}

</style>
</head>
<body>
    <%@ include file="../common/menubar.jsp" %>
    <% 
        int memberNo = loginUser.getMemberNo();
        String memberId = loginUser.getMemberId(); 
        String memberPwd = loginUser.getMemberPwd();
        String email = loginUser.getEmail();
        String nicknameCheck = loginUser.getNickname();
    %>
    
	<br>
    
    <div id="wrap_11" border="1">
        <hr>
        <h2 id="h2">정보수정</h2>
        <hr>

        <br><br>
        <div id="profile">
            <form action="<%= contextPath %>/updateNick.me" method="post">
                <table id="profile_1">
                    <tr>
                        <td colspan="3" id="tdName">프로필</td>
                    </tr>
                    <tr>
                        <td>아이디</td>
                        <td><input type="text" id="inputhh1" name="userId" value="<%=memberId %>" maxlength="12" readonly required></td>
                    </tr>
                    <tr>
                        <td>비밀번호</td>
                        <td><input type="password" id="inputhh1" name="userPwd" maxlength="25"
                            placeholder="기존 비밀번호를 입력해주세요." required>
                    </tr>
                    <tr>
                        <td>비밀번호확인</td>
                        <td><input type="password" id="inputhh1" name="chkPwd" maxlength="25" required></td>
                    </tr>
                    <tr>
                        <td>이메일</td>
                        <td><input type="email" id="inputhh1" name="email" value="<%=email%>" maxlength="40" readonly></td>
                    </tr>
                    <tr>
                        <td>닉네임</td>
                        <td colspan="2">
                            <input type="text" id="inputhh" id="nickname1" name="nicknameCheck" value="<%=nicknameCheck%>" maxlength="20" required>
                            <button type="button" class="infoBtn" onclick="nicknameCheck_1();">중복확인</button><br>
                        </td>
                    </tr>
                    
                </table>
                <div id="btn">
                    <button type="button" class="infoBtn" data-toggle="modal" data-target="#deleteMember">회원탈퇴</button>
                    <button type="submit" class="infoBtn" onclick="return checkNname()">수정하기</button>
                    <button type="button" class="infoBtn" data-toggle="modal" data-target="#updatePwdMember">비밀번호 수정하기</button>
                </div>
                <br><br><br><br><br>
            </form>
        </div>
        <br><br><br>
    </div>
    
 <!-- 탈퇴 창 -->
    <div class="modal" id="deleteMember">
        <div class="modal-dialog">
            <div class="modal-content">
            
                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">회원 탈퇴</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                
                <!-- Modal body -->
                <div class="modal-body">
                    <form action="<%=contextPath%>/delete.me" method="post">
                    
                        <!-- 현재 비밀번호 -->
                        <div class="form-group">
                        <label for="memberPwd">현재 비밀번호 : </label>
                        <input type="password" class="form-control" required id="memberPwd" placeholder="현재 비밀번호를 입력해주세요" name="memberPwd">
                        </div>
                        <button id="btnCenter" type="submit" class="btn btn-primary" onclick="return deleteMember()">회원탈퇴</button>
                    </form>
    <script>
    // 탈퇴 스크립트		
    function deleteMember(){
        if($('input[name=memberPwd]').val() == ''){
            alert("비밀번호를 입력해주세요");
            return false;
        } else{
            if("<%=((Member)session.getAttribute("loginUser")).getMemberPwd()%>" != $('input[name=memberPwd]').val()){
                alert("비밀번호가 틀렸습니다.");
                return false;
            } else {
                var deleteStr = prompt('탈퇴를 하시려면 "탈퇴하겠습니다"를 정확히 입력해주세요.');
                                                
                if(deleteStr == '탈퇴하겠습니다'){
                    alert("탈퇴가 완료되었습니다. 감사합니다.")
                    return true;	
                } else {
                    alert("잘못입력했습니다.");
                    return false;
                }
            }
        }
    }
    </script>
                </div>
            </div>
        </div>
	</div>

        

<!-- 비밀번호 변경 모달 창 -->
    <div class="modal" id="updatePwdMember">
        <div class="modal-dialog">
            <div class="modal-content">
                
                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">비밀번호 변경</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                
                <!-- Modal body -->
                <div class="modal-body">
                    <form action="<%=contextPath%>/updatePwd.me" method="post">
                    
                        <!-- 현재 비밀번호, 변경할  비밀번호, 변경할 비밀번호 재입력  -->
                        <div class="form-group">
                            <label for="userPwd">현재 비밀번호 : </label>
                            <input type="password" class="form-control" required id="memberPwd1" placeholder="현재 비밀번호를 입력해주세요." name="memberPwd1">
                        </div>

                        <div class="form-group">
                            <label for="updatePwd">변경할 비밀번호 : </label>
                            <input type="password" class="form-control" required id="updatePwd" placeholder="변경할 비밀번호를 입력해주세요." name="updatePwd">
                        </div>

                        <div class="form-group">
                            <label for="updatePwd">변경할 비밀번호 확인 : </label>
                            <input type="password" class="form-control" required placeholder="변경할 비밀번호를 다시 입력해주세요" name="checkPwd">
                        </div>
                        <button id="btnCenter" type="submit" class="btn btn-primary" onclick="return validatePwd()">비밀번호 변경</button>
                    </form>
                </div>
            </div>
        </div>
    </div>


<script>
function validatePwd(){

	regExp = /^[a-zA-Z\d]{3,11}$/;
	
	if($('input[name=memberPwd1]').val() == ''){
        alert("비밀번호를 입력해주세요");
        return false;
    } else{
	    if("<%=((Member)session.getAttribute("loginUser")).getMemberPwd()%>" != $('input[name=memberPwd1]').val()){
	        alert('현재 비밀번호가 틀렸습니다.');
	        $('input[name=memberPwd1]').focus();
	        return false;
	    } else{
	    	if(!regExp.test(updatePwd.value)){
	    		alert('4 ~ 12자 사이로 입력해주세요');
	    		return false;
	    	} else{
		        if($('#updatePwd').val() != $('input[name=checkPwd]').val()){
		            alert('비밀번호를 동일하게 입력해주세요');
		            $('input[name=updatePwd]').focus();
		            return false;
		        } else{
		            alert('비밀번호 수정이 완료되었습니다.');
		            return true;
		        }
	    	}
	    }  	
    }
};

var flag = 0;

function nicknameCheck_1(){
	
	var $nickname1 =$('#nickname1').val();
	//console.log($nickname1);
	
	$.ajax({
		url : 'nicknameCheck.me',
		data : {nicknameCheck : $nickname1},
		success : function(result){
			//console.log(result);
			if($nickname1 == ''){
				alert('닉네임 중복확인을 해주세요.');
				flag = 0;
			} else {
				if(result == 'Yes'){
					alert('사용가능한 닉네임입니다.');
					flag = 1;
				} else{
					if(result == 'No'){
						alert('이미 가입된 닉네임입니다.');
						$('#nickname1').val('').focus();
						flag = 0;
					}
				}
			}
		}
	})
}

function checkNname(){
	if($('input[name=userPwd]').val() == ''){
		alert('비밀번호를 입력해주세요.');
		return false;
	} else {
		if("<%=((Member)session.getAttribute("loginUser")).getMemberPwd()%>" != $('input[name=userPwd]').val()){
			alert('현재 비밀번호가 잘못입력되었습니다.');
			return false;
		}else{
			if($('input[name=userPwd]').val() != $('input[name=chkPwd]').val()){
				alert('비밀번호를 동일하게 입력해주세요.');
				return false;
			} else {
				if($('#nickname1').val() == '' || flag == 0){
	        		alert('닉네임 중복확인을 해주세요.');
	        		return false;
	        	} else{
	        		if(flag != 0){ 
	        		alert('정보수정에 성공했습니다.');
       				return true;
	        		}
        		}
			}
		}
	}
}
</script>
    <br><br><br><br><br>

    <%@ include file="../common/footer.jsp" %>

</body>
</html>