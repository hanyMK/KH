<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.board.offer.model.vo.OfferBoard, com.kh.common.model.vo.PageInfo" %>
<%
	ArrayList<OfferBoard> list = (ArrayList<OfferBoard>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>구인 게시판 리스트</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">  
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>  
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>  
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
    /*===공통스타일=====*/

    *{
       list-style: none;
       text-decoration: none;
    }
    #wrap_12{
        width: 1200px;
       height: 600px;
        text-align: center;
        margin: auto;
    }
    #offer{
        width: 800px;
        height: 600px;
        /*border: 1px solid black;*/
        margin: auto;
    }
    #ofName{
      text-align: center;
      font-weight: 1000;
      margin-bottom: 40px;
      margin-top: 40px;
      color:#052159 ;
    }

    #exampleModal{
        float: right;
        margin-right: 20px;
    }
    #tableof{
        width: 800px;
        border: 2px solid gray;
        border-left: none;
        border-right: none;

    }
    #thTitle{
        text-align: center;
    }
    .tableof>tbody>tr:hover{
        cursor: pointer;
        background-color: #C2E5F2;;
    }
    #textMsg{
      pointer-events: none;
   }



    /*===기존스타일===*/
    #wrap{
        margin : auto;
        width : 800px;
        height : 100%;
    }
    .list{
        padding : 6px;
    }
    .category{
        padding : 3px;
        width : 10px;
    }
    .categoryTag{
        font-size: 5px;
    }

    
    .content{
        margin-bottom: 20px;
        height: 500px;
    }
    #input-file{
        display: none;
    }
    .modal_form{
        margin: auto;
        margin-bottom: 20px;
        border: none;
    }
    .poto_zone{
        background-color: skyblue;
        border: 1px solid black;
        display: inline-block;
        width: 180px;
        height: 180px;
        
       
    }
    .poto-area{
        margin-top: 20px;
        display : none;
    }
    tbody>tr:hover{
        background-color: #8db7ee;
    }
    #vote-area{
        display : none;
    }
     .vote-area{
          width:500px;
         margin-left: 150px;
      }
      #vote-title{
          font-size: 20px;
          color: #052159;
          background-color: #C2E5F2;
      }
      .voteType{
          padding-bottom: 5px;
          padding-top: 5px;
      }
      .voteType>div{
          display:inline;
          padding-left: 10px;
      }
      .vote-count222{
          text-align: right;
      }
         .actBtn{
        color:#052159 ;
        background-color: #C2E5F2;
        border: 1px #C2E5F2;
        height: 30px;
        border-radius: 5px;
    }
    .actBtn:hover{
        background-color: #8db7ee;
    }
    .actBtn1{
        background-color: rgb(54, 54, 71);
        color: white;
        height: 30px;
        }
        

       
</style>
</head>
<body>
   <%@ include file="../../common/menubar.jsp" %>

    <div id="wrap_12">
        <hr>
        <h2 id="ofName">구인 게시판</h2>
        <hr>
    
    <br>
    <div align="center"  id="wrap">
        
        <!-- 타입에 빈문자열 들어가있는 상태이므로 equals()메소드 사용시 빈문자열 추가 -->
        <% if(loginUser != null && loginUser.getMemberType().equals("B ")){ %>
            <button style="margin-left:75%;" type="button" class="actBtn" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo"
            data-bs-target="#exampleModal" >글쓰기</button>
            <% } %>   
            <table id="tableof" align="center" class="tableof">
                <thead>
                <hr>
                <tr>
                    <th class="list">번호</th>
                    <th class="categoryTag"></th>
                    <th class="list">제목</th>
                    <th class="list">작성자</th>
                    <th class="list">작성일</th>
                    <th class="list">마감일자</th>
                    <th class="list">조회수</th>
                </tr>
            </thead>
            <tbody>
        <% if(list.isEmpty()) { %>
            	<!-- 게시글이 없을 때 -->
                <tr>
                    <td id="textMsg" align="center" colspan="6">게시글이 존재하지 않습니다.</td>
                </tr>
		<% } else { %>
				<!-- 게시글이 있을 때 -->
                <% for(OfferBoard oB : list){ %>
                <tr class="list">
                    <td class="list" id="bno"><%=oB.getBoardNo()%></td>
                    <!--<input type="hidden" class="list" name="boardNo" value="<%=oB.getBoardNo()%>">-->
                    <td class="categoryTag"><%= oB.getCategory() %></td>
                    <td class="list"><%= oB.getBoardTitle() %></td>
                    <td class="list"><%= oB.getNickName() %></td>
                    <td class="list"><%= oB.getCreateDate() %></td>
                    <td class="list"><%= oB.getClosingDate() %></td>
                    <td class="list"><%= oB.getBoardCount() %></td>
                    
                </tr>
                <%} %>
        <% } %>
            </tbody>
        </table>

        <hr>

        <div align="center" class="page-area">
            <%if(currentPage !=1){%>
                <button class="btn btn-sm btn-info" onclick="location.href='<%=contextPath%>/offerList.oo?opage=<%=currentPage-1%>'">&lt;</button>
                <%}%>
                <%for(int i = startPage; i<= endPage; i++){%>
                    <%if(currentPage != i){ %>
                    <button class="btn btn-sm btn-info" onclick="location.href='<%=contextPath%>/offerList.oo?opage=<%= i %>'"><%=i%></button>
                    <%}else{ %>
                        <button class="btn btn-sm btn-info" disabled><%=i%></button>
                    <%}%>
                <%}%>
    
                <%if(currentPage != maxPage &&maxPage !=0){%>
                <button class="btn btn-sm btn-info" onclick="location.href='<%=contextPath%>/offerList.oo?opage=<%=currentPage +1%>'">&gt;</button>
                 <%} %>
    
        </div>

        <br>
        <br>
    </div>
    </div>
    <!-- modal -->

    <div class="modal fade" id="exampleModal" tabindex="-1" data-bs-backdrop="static" data-bs-keyboard="false" aria-labelledby="exampleModalLabel" aria-hidden="true" >
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">구인 게시판 글쓰기</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
              
                <div class="modal-body" >
                    <form action="<%= contextPath %>/insertOffer.oo" method="post" enctype="multipart/form-data">
                        <% if(loginUser != null) { %>

                        <input type="hidden" name="userNo" value="<%= loginUser.getMemberNo() %>">

                        <% } %>

                        <div class="category">
                          <!-- 카테고리(주제를 선택해주세요) -->
                            <select name="category" id="category" class="modal_form" required>
                                <option value="" >주제를 선택해주세요</option>
                                <option value="아르바이트">아르바이트</option>
                                <option value="사원모집">사원모집</option>
                                <option value="광고">광고</option>
                            </select>
                          <!-- 바디프로필과 익명은 카테고리를 hidden에 담아서 들구감 -->
                        </div>
                        <div class="closingDate">
                            마감일자<input type="text" name="closingDate" class="modal-form" required placeholder="(-, ., / 특수문자를 제외하여 숫자만 입력해주세요 예시- 20231230)" style="width:100%;">
                        </div>
                        <br>
                    <div class="title">
                      
                        <input type="text" id="title_div" placeholder="글 제목" maxlength=20 style="width:100%" 
                               name="title" class="modal_form" required>
      
                    </div>
      
                    <div class="content" >
                        <textarea style="resize: none; width: 100%; height: 100%"  placeholder="주제에 맞지 않는 글로 판단되어 다른 유저로부터 일정수 이상 신고를 받는 경우 자동으로 숨김처리 될 수 있습니다."
                                  id="textarea" name="content" class="modal_form" required></textarea>
                    </div>
                      
                    <div>
                        <hr>
                        <input type="button" name="poto" value="사진첨부" class="actBtn" id="poto-none" onclick="onOff();">
 
                        
                    </div>
                  
                    <!-- 여기는 사진첨부하면 미리보기해주는 곳 -->
                 
                    <div class="poto-area" align="center">
                        <div class="poto_zone" id="poto1">대표 이미지
                          <input type="file" name="file1" required>
                        </div>
                        <div class="poto_zone" id="poto2">2번 이미지
                          <input type="file" name="file2">
                        </div>
                        <div class="poto_zone" id="poto3">3번 이미지
                          <input type="file" name="file3">
                        </div>
                        <div class="poto_zone" id="poto4">4번 이미지
                          <input type="file" name="file4">
                        </div>
                    </div>

                    <hr>
      
                    <div class="modal-footer">
                       
                        <button type="submit" class="actBtn" id="submit">등록</button>
                        <button type="button" class="actBtn1" data-bs-dismiss="modal">닫기</button>
                    </div>

                    </form>
      
                </div>

            </div>

        </div>

    </div>
                    <script>
                        function onOff(){
                            
                            var $onOff = $('.poto-area');
                            
                            if($onOff.css('display') == 'none'){
                                $onOff.css('display','inline');
                            }
                            else{
                                $onOff.css('display','none');
                            }
                        }

                        $(function(){
                            $('#tableof>tbody>tr').click(function(){
                                var $ono = $(this).children().eq(0).text();

                               
                                location.href = '<%=contextPath%>/detail.oo?opage=' + $ono;
                            })
                        })

                    </script>

    
    <%@ include file="../../common/footer.jsp" %>
</body>
</html>