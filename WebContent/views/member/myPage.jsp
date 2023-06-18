<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.member.model.vo.*, com.kh.common.model.vo.PageInfo" %>
<%
	ArrayList<Alarm> list1 = (ArrayList<Alarm>)session.getAttribute("list1");
	ArrayList<Alarm> list2 = (ArrayList<Alarm>)session.getAttribute("list2");
	ArrayList<Alarm> blist = (ArrayList<Alarm>)session.getAttribute("blist");
	ArrayList<Alarm> rlist = (ArrayList<Alarm>)session.getAttribute("rlist");
	ArrayList<Alarm> rrlist =(ArrayList<Alarm>)session.getAttribute("rrlist");
	ArrayList<Alarm> llist = (ArrayList<Alarm>)session.getAttribute("llist");
 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 활동정보 확인 페이지</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>  
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>  
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
    #outer_010{
        width: 1200px;
        text-align: center;
        margin: auto;
    }
    #wrap{
        margin : auto;
        width : 800px;
        height : 100%;
    }
    #login>thead tr, td{
        padding : 8px;
    }
    button{
        color:#052159 ;
        background-color: #C2E5F2;
        border: 1px #C2E5F2;
        border-radius: 40px;
    }
    
    #myalarm111111>tbody>tr :hover{
        cursor: pointer;
        background-color: #C2E5F2;
    }
    .actBtn{
        border-radius: 5px;
        color: #052159;
    }
    #actH2{
        text-align: center;
	    font-weight: 1000;
	    margin-bottom: 40px;
	    margin-top: 40px;
	    color:#052159 ;
    }
    .actTh{
        color: #052159; 
    }


</style>

</head>
<body>

<%@ include file="../common/menubar.jsp" %>
<br>
<div id="outer_010">
    <hr>
        <h2 align="center" id="actH2"><b>내 활동 정보</b></h2>
    <hr>

    <div align="center"  id="wrap"> 
        <div id="myalarm">

            <form action="<%= contextPath %>/myalarmchk.me" method="post">
                
                <table id="myalarm111111">
                    <tr>
                        <th class="actTh">새 알림 <%= list1.size() + list2.size() %> 건</th>
                        <td></td>
                        <td><button class="actBtn" type="button" id="refresh" onclick="window.location.reload();">새로 고침</button></td>
                        <td><button class="actBtn" type="submit" id="alarmcheck" onclick="alarmCheck();">확인 완료</button></td>
                    </tr>
                    <% if(list1.isEmpty() && list2.isEmpty()) { %>
                        <tr>
                            <td colspan="4">새 알람이 없습니다.</td>
                        </tr>
                    <% } else { if(list1.isEmpty()) { %>
                        
                        <%  for(Alarm a : list2) { %>
                            <tbody>
                            <tr>
                                <td><input type="hidden" name="rereplyBoardNo" value="<%= a.getBoardNo() %>"></td>
                                <td><input type="radio" name="rereplyalarm"></td>
                                <td colspan="3" class="mmm">댓글 [ <%= a.getReplyContent() %> ]에 새 댓글이 ( <%= a.getCountNewRereply() %> ) 이 달렸습니다.</td>
                                <td><input type="hidden" name="boardType" value="<%= a.getBoardType()%>"></td>
                                <input type="hidden" name="replyNo" value="<%= a.getReplyNo()%>">
                            </tr>
                        </tbody>
                    <% } %>
                    
                    <% } else if(list2.isEmpty()) {  %>
                        <% for(Alarm a : list1){ %>
                            <tbody>
                                <tr>
                                    <td><input type="hidden" name="boardNo" value="<%= a.getBoardNo()%>"></td>
                                    <td><input type="radio" name="replyalarm"></td>
                                    <td colspan="3" class="mmm">게시글 <%= a.getBoardTitle() %> 에 새 댓글이 ( <%= a.getCountNewReply() %> ) 이 달렸습니다.
                                    </td>
                                    <td><input type="hidden" name="boardType" value="<%= a.getBoardType()%>"></td>
                                    
                                </tr>
                            </tbody>
                        <% } %>
                        
                        <% } else { %>
                            
                            <%  for(Alarm a : list2) { %>
                                <tbody>
                                    <tr>
                                        <td><input type="hidden" name="rereplyBoardNo" value="<%= a.getBoardNo() %>"></td>
                                        <td><input type="radio" name="rereplyalarm"></td>
                                        <td colspan="3" class="mmm">댓글 [ <%= a.getReplyContent() %> ]에 새 댓글이 ( <%= a.getCountNewRereply() %> ) 이 달렸습니다.</td>
                                        <td><input type="hidden" name="boardType" value="<%= a.getBoardType()%>"></td>
                                        <td><input type="hidden" name="replyNo" value="<%= a.getReplyNo()%>"></td>
                                    </tr>
                                </tbody>
                            <% } %>
                            
                            <% for(Alarm a : list1){ %>
                                <tbody>
                                    <tr>
                                        <td><input type="hidden" name="boardNo" value="<%= a.getBoardNo()%>"></td>
                                        <td><input type="radio" name="replyalarm"></td>
                                        <td colspan="3" class="mmm">게시글 <%= a.getBoardTitle() %> 에 새 댓글이 ( <%= a.getCountNewReply() %> ) 이 달렸습니다.  </td>
                                        <td><input type="hidden" name="boardType" value="<%= a.getBoardType()%>"></td>
                                    </tr>
                                </tbody>
                            
                            <% } %>
                        <% } %>
                    <% } %>
                </table>
            </form>

        </div>

        <div id="mylist">
            
            <br>
            
            <button class="actBtn" id="boardlistgo" onclick="boardlist();">작성한 글 / <%= blist.size()%>개</button>
            <button class="actBtn" id="replylistgo" onclick="replylist();">작성한 댓글 / <%= rlist.size()%>개</button>
            <button class="actBtn" onclick="rereplylist();">작성한 대댓글 / <%= rrlist.size()%>개 </button>
            <button class="actBtn" id="likelistgo" onclick="likelist();">좋아요 한 글 / <%= llist.size() %>개</button>
            
            <br>
            
            
        </div>      
    </div>
</div>
    
    <script>

            function boardlist(){
            	
                location.href="<%= contextPath%>/myboardList?bcpage=1";

            }

            function replylist(){
            	
            	location.href="<%= contextPath%>/myreplyList?rcpage=1";
        
            }
            
            function rereplylist(){
            	
            	location.href="<%= contextPath%>/myrereplyList?rrcpage=1";
            }

            function likelist(){
   	
            	location.href="<%= contextPath%>/mylikeList?lcpage=1";
            }
            
            
            $(function(){
                $('#myalarm111111>tbody>tr>.mmm').click(function(){
                    var $ono = $(this).parent().children().eq(0).children().val();
                    var $type = $(this).parent().children().eq(3).children().val();
                    console.log($ono);
                    console.log($type);
                    if($type ==  'A    '){
                        location.href = '<%=contextPath%>/detail.noticeList?bno=' + $ono;
                    } else if($type == 'B    '){
                        location.href = '<%=contextPath%>/detail.an?bno=' + $ono;
                    } else if($type == 'C    '){
                        location.href = '<%=contextPath%>/bodyDetail.by?boardNo=' + $ono;
                    } else if($type == 'D    '){
                        location.href = '<%=contextPath%>/challengedetail.cl?cpage=' + $ono;
                    } else if($type == 'E    '){
                        location.href = '<%=contextPath%>/detailView.re?opage=' + $ono;
                    } else if($type == 'F    '){
                        location.href = '<%=contextPath%>/detail.ho?hno=' + $ono;
                    } else if($type == 'G    '){
                        location.href = '<%=contextPath%>/detail.oo?opage=' + $ono;
                    }

                })
                
            })
            
            
            
        </script>
        

    <br><br><br><br><br>

    <%@ include file="../common/footer.jsp" %>

</body>
</html>