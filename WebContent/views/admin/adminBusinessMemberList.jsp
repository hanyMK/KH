<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.member.model.vo.*, com.kh.common.model.vo.*" %>
<%
	ArrayList<MemberAttach> atList = (ArrayList<MemberAttach>)request.getAttribute("atList");
	PageInfo pibm = (PageInfo)request.getAttribute("pibm");
	
	int currentPage = pibm.getCurrentPage();
    int startPage = pibm.getStartPage();
    int endPage = pibm.getEndPage();
    int maxPage = pibm.getMaxPage();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사업자 회원 조회</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>  
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>  
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
    #wrap_12{
        width: 1200px;
        text-align: center;
        margin: auto;
    }
    #wrap{
        margin : auto;
        width : 800px;
        height : 100%;
    }
    button{
        color:#052159 ;
        background-color: #C2E5F2;
        border: 1px #C2E5F2;
    }
	
	table{

	text-align : center;
    font-size : 13px;
	
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
<div id="wrap_12">
    <br><hr>
    
    <h2 id="actH2" align="center">사업자 회원 정보 확인</h2>
    
    <hr>
    <br><br>
    <table id="businessmemberlist" align="center">
        
        <tr>
            <th colspan="6" style="color:#052159;"><b>상세내역</b></th>
            <th></th>
            <th><button class="actBtn" onclick="updateMemType();">사업자 회원으로 변경</button></th>
        </tr>
        
        <tr height="20"></tr>
        <tr>
            <th width="100px;">파일번호</th>
            <th>회원번호</th>
            <th>사업자등록증 확인</th>
            <th width="100px;">회원상태</th>
            <th>선택</th>
        </tr>
        <% if(atList.isEmpty()){ %>
            <tr><td colspan="3">회원이 없습니다.</td></tr>
            <% } else { %>
                <% for(MemberAttach m : atList) { %>
                    <tr>
                    <td><%= m.getFileNo() %></td>
                    <td><%= m.getMemberNo() %></td>
				    <td><button onclick="window.open('<%= contextPath %>/<%= m.getFilePath() %>/<%= m.getChangeName() %>')">이미지 확인</button></td>
				    <td>
                        <select name="memType" id="memberType">
                            <option value="A" selected="selected" disabled>일반 회원</option>
                            <option value="B">사업자 회원</option>
                        </select> 
                    </td>
                    <td><input type="checkbox" name="memberType" value="<%= m.getMemberNo() %>"></td>
                </tr>
            	<% } %>
                <% } %>
            </table>
            <br><br>
            <div align="center" id="boardlistPage">
                <% if(currentPage != 1) { %>
                    <button onclick="location.href='<%= contextPath %>/adminBmemList?bmlcpage=<%= currentPage - 1 %>'" class="actBtn">&lt;</button>
                    <% } %>
                    <% for(int i = startPage; i <= endPage; i++) { %>
                        <% if(currentPage != i) { %>
                            <button onclick="location.href='<%= contextPath %>/adminBmemList?bmlcpage=<%= i %>'" class="actBtn"><%= i %></button>
                            <% } else { %>
                                <button class="actBtn" disabled><%= i %></button>
                                <% } %>
                                <% } %>
                                
                                <% if(currentPage != maxPage) { %>
                                    <button onclick="location.href='<%= contextPath %>/adminBmemList?bmlcpage=<%=currentPage + 1%>'" class="actBtn">&gt;</button>
                                    <% } %>
                                </div>
                                
                                <br><br><br>
                                
                                <script>
                                    
                                    function updateMemType(){
                                        
                                        if(confirm("회원의 상태를 변경하시겠습니까? ")){
                                            
                                            var checkbox = $("input[name=memberType]:checked");
            var memberType = checkbox.parent().parent().children().eq(3).children().val();
            var memberNo = checkbox.val();
            
            $('input:checkbox[name=memberType]:checked').each(function(){
                var member = new Object();
                var member = {
                    memberType : memberType,
                    memberNo : memberNo
                }
                
                $.ajax({
                    url:'adminMemTypeUpdate',
                    data: ({memberType : memberType, memberNo : memberNo}),
                    type: 'post',
                        success : function(result){
                            if(result =='S'){
                                //console.log(memberId);
                                alert("회원 상태 변경이 완료 되었습니다.")
                              checkbox.prop('checked', false);
                              location.href=location.href;
                            } else {
                                alert("회원 상태 변경이 실패 하였습니다.");
                            }
                        }
                    })
                    
                })           
                } else {
                    alert("취소 되었습니다.")
                }
                
                //checkedList.push(memberList);
                //console.log(checkedList)
                
            }
            
            

            
            
            </script>
</div>

<%@ include file="../common/footer.jsp" %>

</body>
</html>