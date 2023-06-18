<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import="java.util.ArrayList, com.kh.board.anonymous.model.vo.SelectAll,com.kh.common.model.vo.*" %>
    <%
      ArrayList<SelectAll> tagSerchList = (ArrayList<SelectAll>)request.getAttribute("tagSerchList");
      PageInfo pi = (PageInfo)request.getAttribute("pi");
      String hashContent = (String)request.getAttribute("hashContent");





      // 페이징바를 만들 때 필요한 변수들 미리 셋팅
      int currentPage = pi.getCurrentPage();
      int startPage = pi.getStartPage();
      int endPage = pi.getEndPage();
      int maxPage = pi.getMaxPage();



    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>해시태그 검색 결과</title>

<style>
    .outer{
        width: 1000px;
        margin: auto;
        /* background-color: ; */
        margin-top: 5px;
        color: #052159;
    }

    .list-area{
        text-align: center;
        border: 1px solid #052159;
    }

    .list-area>tbody>tr:hover{
        cursor: pointer;
        background-color: #8db7ee;
    }
</style>
</head>
<body>

 <%@ include file="../common/menubar.jsp" %>

    <div class="outer" id="body">
        <br>
        <h2 align="center"><strong style="font-size: 50pxpx;">#<%=hashContent %></strong> 검색 결과</h2>
        <br>



        <table class="list-area" align="center" >
            <thead>
                <tr>

                    <th width="80">카테고리</th>
                    <th width="300">제목</th>
                    <th width="100">작성자</th>
                    <th width="50">조회수</th>
                    <th width="100">작성일</th>
                </tr>
            </thead>
              <tbody>
                <!--게시글 출력 : 게시글이 있는지 없는지 판단해서-->
                <!--  isEmpty() -->
                <% if(tagSerchList.isEmpty()) { %>
                <tr>
                    <td colspan="6">조회된 게시글이 없습니다.</td>
                </tr>
				<% } else { %>
                <!--반복 값을 순차적으로 접근해서 뽑아오기-->
                <%for(SelectAll list : tagSerchList){%>
               
                    <a href="">

                        <tr class="searchTag" >
                            <input type="hidden" name="boardNo" value="<%=list.getBoardNo()%>">
                            <input type="hidden" name="type" value="<%=list.getBoardType() %>">
                            <td class="category" width="80"><%=list.getCategory() %></td>
                            <td  width="300"><%=list.getBoardTitle() %></td>
                            <td width="100"><%=list.getNickName() %></td>
                            <td width="50"><%=list.getBoardCount() %></td>
                            <td width="200"><%=list.getCreateDate() %></td>
                        </tr>
                    </a>
               
                <% } %>
				<% } %>

            </tbody>

        </table>

        <script>
        	$(function(){
            
                $('.searchTag ').click(function(){
                    
                var bno = $(this).children('input[name=boardNo]').val();
                var type = $('input[name=type]').val();

                
                //console.log($('.list-area>tbody tr'));

                switch(type){
                    case  'B    ': location.href = "<%=contextPath%>/detail.an?bno=" + bno; break;
                    case  'C    ': location.href ="<%=contextPath%>/detail.by?bno=" + bno; break;
                    case  'D    ': location.href = "<%=contextPath%>/detail.by?bno=" + bno; break;
                    case  'E    ': location.href ="<%=contextPath%>/detail.by?bno=" + bno; break;
                    case  'F    ': location.href ="<%=contextPath%>/detail.ho?hno=" + bno; break;
                }
                console.log(type);
                console.log(bno);
            });
       
        	});

        </script>

        <br><br>

        <div align="center" class="paging-area">


            <%if(currentPage !=1){%>
            <button onclick="location.href='<%=contextPath%>/searchTag.hs?cpage=<%=currentPage-1%>'">&lt;</button>
			<%}%>
            <%for(int i = startPage; i<= endPage; i++){%>
                <%if(currentPage != i){ %>
                <button onclick="location.href='<%=contextPath%>/searchTag.hs?cpage=<%=i%>'"><%=i%></button>
                <%}else{ %>
                    <button disabled><%=i%></button>
                <%}%>
            <%}%>

            <%if(currentPage != maxPage ){%>
            <button onclick="location.href='<%=contextPath%>/searchTag.hs?cpage=<%=currentPage +1%>'">&gt;</button>
			 <%}%>

        </div>

        <br><br><br>
    </div>






</body>
</html>