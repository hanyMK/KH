<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.member.model.vo.*, com.kh.common.model.vo.*" %>
<%
	ArrayList<Member> memberList = (ArrayList<Member>)request.getAttribute("memberList");
	PageInfo pim = (PageInfo)request.getAttribute("pim");
	
	int currentPage = pim.getCurrentPage();
    int startPage = pim.getStartPage();
    int endPage = pim.getEndPage();
    int maxPage = pim.getMaxPage();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 조회</title>
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
    
    <h2 id="actH2" align="center">회원 정보 조회</h2>

    <hr>
    <br><br>
    <form action="<%=contextPath%>/adminMemSearch" method="post">
        <table id="memberlist" align="center">
            <tr>
                <td colspan="7">
                    <select id="search" name="search">
                        <option name="search" value="memberId">아이디</option>
                        <option name="search" value="nickname">닉네임</option>
                        <option name="search" value="report">누적신고수 높은순</option>
                    </select> : <input type="text" name="Skeyword" id="searchGo" onclick="noSearch();">
                    <button class="actBtn" type="submit">검색</button>
                </td>
            </tr>
            <tr>
                <th colspan="5" style="color:#052159;"><b></b></th>
                <th><button class="actBtn" onclick="updateMemType();">상태 변경</button></th>
                
            </tr>
            <tr>
                
            </tr>
            
            <tr height="20"></tr>
            <tr>
                <th>회원번호</th>
                <th width="100px;">아이디</th>
                <th>닉네임</th>
                <th width="250px;">활동정보<br>(가입일자/작성글 수/댓글 수/대댓글 수)</th>
                <th width="90px;">보유 포인트</th>
                <th width="90px;">누적신고 수</th>
                <th width="90px;">회원상태</th>
                <th>선택</th>
            </tr>
            <% if(memberList.isEmpty()){ %>
				<tr><td colspan="3">회원이 없습니다.</td></tr>
				<% } else { %>
					<% for(Member m : memberList) { %>
                        <tr>
                            <td><%= m.getMemberNo() %></td>
                            <td><%= m.getMemberId() %></td>
                            <td><%= m.getNickname() %></td>
				    <td>(<%= m.getEnrollDate() %> / <%=m.getBoardCount() %>/ <%= m.getReplyCount() %> / <%= m.getReReplyCount() %>)</td>
				    <td><%= m.getPointSum() %></td>
				    <td><%= m.getReportNo() %></td>
				    <td>
                        <select name="memType" id="memberType">
                            <% if(m.getMemberType().equals("A ")) { %>
                                <option value="A" selected="selected" disabled>일반 회원</option>
                                <option value="B">사업자 회원</option>
                                <option value="C">정지 회원</option>
                                <option value="D">관리자 회원</option>
                            </select> 
                            <% } else if(m.getMemberType().equals("B ")) { %>
                                <option value="A">일반 회원</option>
                                <option value="B" selected="selected" disabled>사업자 회원</option>
                                <option value="C">정지 회원</option>
                                <option value="D">관리자 회원</option>
                            </select> 
                            <% } else if(m.getMemberType().equals("C ")) { %> 
                                <option value="A">일반 회원</option>
                                <option value="B">사업자 회원</option>
                                <option value="C" selected="selected" disabled>정지 회원</option>
                                <option value="D">관리자 회원</option>
                            </select> 
                            <% } else {  %>
                                  <option value="A">일반 회원</option>
                                <option value="B">사업자 회원</option>
                                <option value="C" >정지 회원</option>
                                <option value="D" selected="selected" disabled>관리자 회원</option>
                            </select> 
                                        <% } %>
                                    </td>
                    <td><input type="checkbox" name="memberType" value="<%= m.getMemberNo() %>"></td>
                </tr>
            	<% } %>
                <% } %>
            </table>
        </form>
        <br><br>
        <div align="center" id="boardlistPage">
            <% if(currentPage != 1) { %>
                <button onclick="location.href='<%= contextPath %>/adminMemlist?mlcpage=<%= currentPage - 1 %>'" class="actBtn">&lt;</button>
                <% } %>
                <% for(int i = startPage; i <= endPage; i++) { %>
                    <% if(currentPage != i) { %>
                        <button onclick="location.href='<%= contextPath %>/adminMemlist?mlcpage=<%= i %>'" class="actBtn"><%= i %></button>
                        <% } else { %>
                            <button class="actBtn" disabled><%= i %></button>
                            <% } %>
                            <% } %>
                            
                <% if(currentPage != maxPage) { %>
                    <button onclick="location.href='<%= contextPath %>/adminMemlist?mlcpage=<%=currentPage + 1%>'" class="actBtn">&gt;</button>
                    <% } %>
                </div>

                <br><br><br>
                
                <script>
                    
                    function updateMemType(){
                        
                        
                        var checkbox = $("input[name=memberType]:checked");
                        var member = new Object();
                        
                        $('input:checkbox[name=memberType]:checked').each(function(){
                            if(confirm("회원의 상태를 변경하시겠습니까? ")){
                                
                                var memberType = checkbox.parent().parent().children().eq(6).children().val();
                                var memberNo = checkbox.val();
                                var member = {
                    memberType : memberType,
                    memberNo : memberNo
                }
               
                //console.log(member);
                        	console.log(member);
                            
                            $.ajax({
                                url:'adminMemTypeUpdate',
                                data: ({memberType : memberType, memberNo : memberNo}),
                                type: 'post',
                                success : function(result){
                                    if(result =='S'){
                              alert("회원 상태 변경이 완료 되었습니다.");
                              checkbox.prop('checked', false);
                              location.href=location.href;
                              
                            } else {
                                alert("회원 상태 변경이 실패 하였습니다.");
                            }
                        }
                    })

                } else {
                    alert("취소 되었습니다.")
                }
            })           
        }
        
        function noSearch(){

            var result = $('#search option:selected').val();
            console.log(result);
            if (result == 'report') {
                $('#searchGo').attr('readonly', true).val("검색 없이 조회 됩니다.").css('background-color','#C2E5F2');
                
            } else {
                $('#searchGo').removeAttr('readonly');
                $('#searchGo').css('background-color','white').val('').focus;
                
            }
            
        }
        </script>
</div>

<%@ include file="../common/footer.jsp" %>

</body>
</html>