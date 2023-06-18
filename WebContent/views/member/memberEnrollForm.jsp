<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 창</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>  
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>  
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
	.outer_01{
    	width : 1200px;
    	height : 100%;
    	margin : auto;
    }
    #wrap{
        margin : auto;
        width : 800px;
        height : 100%;
    }
    #memberEnroll>thead tr, td{
        padding : 8px;
    }
    button{
        color:#052159 ;
        background-color: #C2E5F2;
        border: 1px #C2E5F2;
    }
    
    :disabled{
        background-color: white;
    }

    .hidden{
        display: none;
        font-size: 10px;
        text-align: center;
    }

    .hidden1{
        display: none;
    }
    #actH2{
        text-align: center;
	    font-weight: 1000;
	    margin-bottom: 40px;
	    margin-top: 40px;
	    color:#052159 ;
    }
    .actBtn{
        border-radius: 5px;
        color: #052159;
    }

</style>

</head>
<body>

<%@ include file="../common/menubar.jsp" %>
<div>
<br>
<div class="outer_01">
<hr>
<h2 id="actH2" align="center"><b>회원가입</b></h2>
<hr>


<div align="center"  id="wrap">
    
   
    <table id="memberEnroll" align="center">
        
        
        
        <form action="/nosweat/insert.me" method="post" enctype="multipart/form-data">
            <table align="center">
                <tr>
                <td>아이디  <input type="checkbox" id="idcheck">
                    <td>
                        <input type="text" name="userId" maxlength="12" required id="id1">
                        <div id="idHidden1" class="hidden">이미 가입된 아이디입니다.</div>
                        <div id="idHidden2" class="hidden">아이디는 첫글자 영문,그 외 영문자/숫자로 4~12자로 입력해주세요.</div>
                       <div id="idHidden3" class="hidden">아이디 중복확인이 완료되었습니다.</div>
                       <div id="idHidden4" class="hidden">아이디 중복확인을 해주세요.</div>
                       
                    </td>
                    <td><button class="actBtn" type="button" onclick="idCheck_1();">중복확인</button>
                    </td>
                </tr>
                
                <tr>
                    <td>비밀번호</td>
                    <td>
                        <input type="password" name="userPwd" maxlength="12" required id="pwd">
                        <div id="pwdHidden1" class="hidden">비밀번호는 영문자/숫자로 4~12자로 입력해주세요.</div>
                    </td>
                    <td></td>
                </tr>
              
                <tr>
                    <td>비밀번호 확인</td>
                    <td>
                        <input type="password" maxlength="12" required id="pwdchk">
                        <div id="pwdHidden2" class="hidden">비밀번호가 일치하지 않습니다.</div>                  
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td>닉네임 <input type="checkbox" id="nicknamecheck"></td>
                    <td>
                        <input type="text" name="nickname" maxlength="10" required id="nickname1">
                        <div id="nicknameHidden1" class="hidden">이미 가입된 닉네임입니다.</div>
                        <div id="nicknameHidden2" class="hidden">닉네임 중복확인이 완료되었습니다.</div>
                        <div id="nicknameHidden3" class="hidden">닉네임 중복확인을 해주세요.</div>
                    </td>
                    <td><button class="actBtn" type="button" id="nickcheck"onclick="nicknameCheck_1();">중복확인</button></td>
                    <td></td>
                </tr>
                <tr>
                    <td>이메일 주소 <input type="checkbox" id="emailcheck"></td>
                    <td>
                        <input type="email" name="email" required id="email1" id="emailcheck">
                        <div id="emailHidden1" class="hidden">이미 가입된 이메일주소입니다.</div>
                        <div id="emailHidden2" class="hidden">이메일 중복확인이 완료되었습니다. 인증코드를 입력해주세요.</div> 
                        <div id="emailHidden3" class="hidden">이메일 중복확인 및 인증코드 확인을 해 주세요.</div>          
                    </td>
                    <td>
                        <button class="actBtn" type="button" id="emailCheck" onclick="emailCheck_1()">중복확인 및 인증코드 발송</button>
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td>인증코드</td>
                    <td><input type="text" name="emailChk"></td>
                    <td>
                        <button class="actBtn" type="button">인증 확인</button>
                        <div id="emailHidden4" class="hidden">인증번호가 일치하지 않습니다.</div>
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td>회원 구분</td>
                    <td><input type="radio" id="type1" name="type" value="A" checked="true">일반 회원</td>
                    <td><input type="radio" id="type2" name="type" value="B">사업자 회원(구인게시판 이용)</td>
                    <td></td>
                </tr>
                <tr>
                    <div>
                        <td class="hidden1" id="businessHidden1">사업자등록증</td>
                        <td class="hidden1" id="businessHidden2"><input type="file" name="upfile"></td>
                    </div>
                </tr>
                </div>
            </table>
            <br>

            <button class="actBtn" type="submit" id="gogo" onclick="return validate_1()" disabled>회원 가입 하기</button>
            <button class="actBtn" type="button" onclick="resetGo();">다시 작성하기</button>   
           
        </form>
        
        
        <!-- 정규표현식으로 유효성 검사 -->
       <script>

            var id = document.getElementById('id1');
            var idcheck = document.getElementById('idcheck');
            var pwd = document.getElementById('pwd');
            var pwdChk = document.getElementById('pwdchk');
            var nickname = document.getElementById('nickname');
            var nicknamecheck = document.getElementById('nicknamecheck');
            var email = document.getElementById('email');
            var emailcheck = document.getElementById('emailcheck');
            var type2 = document.getElementById('type2');
            var business1 = document.getElementById('businessHidden1');
            var business2 = document.getElementById('businessHidden2');
            var emailCheck = document.getElementById('emailcheck');
            
            //console.log($('#type1').prop('checked'));
            //console.log($('#type2').prop('checked'));

            function resetGo(){

                location.href = "<%=contextPath%>/enrollForm.me";


            }


            $(function(){
               
            
                $('#type2').on('change', function(){
                    if($(this).prop('checked')){
                        $('.hidden1').css('display','block');
                    }
                })
               
                
            });

                   
            function validate_1(){

                var regExp2 = /^[a-zA-Z\d]{4,11}$/;
                if(!regExp2.test(pwd.value)){
                    $('#pwdHidden1').css('display', 'block')
                   return false;
                }
                if($('#pwd').val() != $('#pwdchk').val()){
                    $('#pwdHidden2').css('display', 'block')
                   return false;
                }

                if($('#idcheck').prop('checked') && $('#nicknamecheck').prop('checked') && $('#emailcheck').prop('checked')){
                    $('#gogo').removeAttr('disabled');
                    }
                    return true;
                }
        
            
            
            function idCheck_1(){
               
               var $id = $('#id1');
               //console.log($id)
               
               
               $.ajax({
                  url: 'idCheck.me',
                  data : {checkId : $id.val()},
                  success : function(result){
                     
                     console.log(result);
                     
                     if(result == 'No'){
                        
                        $('#idHidden1').css('display', 'block');
                        if($('#idHidden3').css('display', 'block')){
                           $('#idHidden3').css('display', 'none');}   
                        $('#id1').val('').focus();
                        
                     } else {

                        if($('#id1').val() != ''){
                                
                                var regExp = /^[a-zA-Z][a-zA-Z0-9]{3,11}$/;
                                if(!regExp.test(id.value)){
                                    $('#idHidden2').css('display', 'block');
                                    if($('#idHidden3').css('display', 'block')){
                                        $('#idHidden3').css('display', 'none')
                                    }
                                }
                
                                else {

                                    if(confirm('해당 아이디를 사용하시겠습니까?')){
                                        $('#id1').attr('readonly', 'true')
                                        $('#idcheck').prop('checked', 'true')
                                        $('#idHidden3').css('display', 'block');                           
                                        $('#idHidden1').css('display', 'none');
                                        $('#idHidden2').css('display', 'none');
                                        if($('#idHidden4').css('display', 'block')){
                                            $('#idHidden4').css('display', 'none');
                                        } 
                                        if($('#idHidden1').css('display','block')){
                                            $('#idHidden1').css('display', 'none');
                                        }
                                        if($('#idcheck').prop('checked') && $('#nicknamecheck').prop('checked') && $('#emailcheck').prop('checked')){
                                                $('#gogo').removeAttr('disabled');
                                                }
                                    }  else {
                                       
                                       if($('#idcheck').prop('checked')){
                                          idcheck.checked = false;
                                          $('#id1').removeAttr('readonly')
                                          $('#idHidden3').css('display', 'none');
                                          $('#idHidden4').css('display', 'block');
                                          $('#id1').val('').focus();
                                       }
                                       else{
                                            $('#id1').val('').focus();
                                            $('#idHidden4').css('display', 'none');}
                                        }

                                }


                        }
                     }
                    }
               })
            }
        
            function nicknameCheck_1(){
               
               var $nickname1 =$('#nickname1').val();
               //console.log($nickname1);
               
               $.ajax({
                  url : 'nicknameCheck.me',
                  data : {nicknameCheck : $nickname1},
                  success : function(result){
                     console.log(result);
                     if(result == 'No'){
                        
                        $('#nicknameHidden1').css('display', 'block');
                        if($('#nicknameHidden2').css('display', 'block')){
                           $('#nicknameHidden2').css('display', 'none');
                        }
                        $('#nickname1').val('').focus();
                     } else {
                        if($('#nickname1').val() != ''){

                                if(confirm('해당 닉네임을 사용하시겠습니까?')){

                                    $('#nicknamecheck').prop('checked','true');
                                    $('#nickname1').attr('readonly', 'true');
                                    $('#nicknameHidden2').css('display','block');
                                    $('#nicknameHidden1').css('display','none');
                                    if($('#nicknameHidden3').css('display', 'block')){
                                        $('#nicknameHidden3').css('display', 'none');
                                        }
                                        if($('#idcheck').prop('checked') && $('#nicknamecheck').prop('checked') && $('#emailcheck').prop('checked')){
                                            $('#gogo').removeAttr('disabled');
                                            }
                                } else {
                                   
                                   if($('#nicknamecheck').prop('checked')){
                                      nicknamecheck.checked = false;
                                      $('#nickname1').attr('readonly', 'false');
                                      $('#nicknameHidden3').css('display', 'block');
                                      $('#nicknameHidden2').css('display', 'none');
                                      $('#nickname1').val('').focus();
                                   } else {
                                    $('#nickname1').val('').focus();
                                    $('#nicknameHidden3').css('display','block');
                                      
                                   }


                                }
                        }
                     }
                  }
               })
            }
               
               function emailCheck_1(){
                  
                  var $email1 = $('#email1').val();
                  //console.log($email1);
                  
               $.ajax({
                  url : 'emailCheck.me',
                  data : {emailCheck : $email1},
                  success : function(result){
                     console.log(result);
                        if(result == 'No'){
                           $('#emailHidden1').css('display', 'block');
                                if($('#emailHidden2').css('display', 'block')){
                                    $('#emailHidden2').css('display', 'none');
                                }
                           $('#email1').val('').focus();
                        } else {
                           if($email1 != ''){
                                    if(confirm('해당 이메일을 사용하시겠습니까?')){
                                        $('#emailcheck').prop('checked','true');
                                        $('#email1').attr('readonly', 'true')
                                        $('#emailHidden1').css('display', 'none');
                                        $('#emailHidden2').css('display', 'block');
                                        if($('#emailHidden3').css('display', 'block')){
                                            $('#emailHidden3').css('display', 'none');
                                            }
                                            if($('#idcheck').prop('checked') && $('#nicknamecheck').prop('checked') && $('#emailcheck').prop('checked')){
                                            $('#gogo').removeAttr('disabled');
                                            }
                                    } else {
                                       if($('#emailcheck').prop('checked')){
                                          emailcheck.checked = false;
                                          $('#email1').attr('readonly', 'false')
                                          $('#emailHidden3').css('display', 'block');
                                          $('#emailHidden2').css('display', 'none');
                                          $('#email1').val('').focus();
                                       } else {
                                        $('#email1').val('').focus();
                                        $('#emailHidden3').css('display', 'block');
                                       }
                                    }
                           }
                        }
                     }
                  })
               }
        </script>
        <br><br><br><br><br>
        </div>
        </div>
 
    <%@ include file="../common/footer.jsp" %>

</body>
</html>