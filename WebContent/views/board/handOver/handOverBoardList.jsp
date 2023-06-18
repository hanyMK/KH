<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.board.handOver.model.vo.*, com.kh.common.model.vo.PageInfo" %>
<%
	ArrayList<HandOver> list = (ArrayList<HandOver>)request.getAttribute("list");
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
    <title>양도 게시판 리스트</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <title>Bootstrap Example</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<style>



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
    #handover{
        width: 800px;
        height: 600px;
        /*border: 1px solid black;*/
        margin: auto;
    }
    #hoName{
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
    #tableho{
        width: 800px;
        border: 2px solid gray;
        border-left: none;
        border-right: none;

    }
    #thTitle{
        text-align: center;
    }
    .tableho>tbody>tr:hover{
        cursor: pointer;
        background-color: #C2E5F2;;
    }
    #textMsg{
      pointer-events: none;
   }

   #textarea{
    height: 500px;
   }

   


/*===================기존 스타일==============*/
    /* #wrap-over{
        margin : auto;
        width : 800px;
        height : 100%;
    }
     */


    #modal{
        color:#052159 ;
        background-color: #C2E5F2;
        border: 1px #C2E5F2;
    }
    

    /* --------해시태그 style---------------------------------------- */


    #div-tag> ul {
    padding: 16px 0;
    }

    #div-tag> ul li {
    display: inline-block;
    margin: 0 5px;
    font-size: 14px;
    letter-spacing: -.5px;
    }

    #div-tag> form {
    padding-top: 16px;
    }

    #div-tag> ul li.tag-item {
    padding: 4px 8px;
    background-color: #C2E5F2;
    color: #052159;
    }

    .tag-item:hover {
    background-color: #8db7ee;
    color: #fff;
    }

    .del-btn {
    font-size: 12px;
    font-weight: bold;
    cursor: pointer;
    margin-left: 8px;
    }

    #div-tag{
        display: none;
        
    }
   
    #textMsg{
      pointer-events: none;
   }
 





    /*---------사진첨부 스타일--------*/
   
    .modal_form{
        margin: auto;
        margin-bottom: 20px;
        border: none;
    }

  /*------사진 첨부----------------*/
  .poto_zone{
        background-color: skyblue;
        border: 1px solid black;
        display: inline-block;
        width: 180px;
        height: 180px;
       
       }
       #poto-area{
        margin-top: 20px;
       }
  
    tbody>tr:hover{
        background-color: #8db7ee;
    }
  
    #textMsg{
    pointer-events: none;
    }
    #handover{
        width: 800px;
    }
  
/*게시글 수정 삭제, 모달버튼*/
.actBtn{
        color:#052159 ;
        background-color: #C2E5F2;
        border: 1px #C2E5F2;
        height: 30px;
        border-radius: 5px;
        
        }
    .actBtn1{
        background-color: rgb(54, 54, 71);
        color: white;
        height: 30px;
        border-radius: 5px;
      }
      
      /*모달 사진 스타일*/
              .poto_zone{
            background-color: skyblue;
            display: inline-block;
            width: 180px;
            height: 180px;
        }
        .poto-area{
            margin-top: 20px;
         
        }
       
        .poto-area>div{
            margin-top: 5px;
            border-radius: 10px;
            display:inline-table;
        }




</style>
</head>
<body>
	<%@ include file="../../common/menubar.jsp" %>


    <!-- 시작 -->

    
    <div id="wrap_12">
        <hr>
        <h2 id="hoName">양도 게시판</h2>
        <hr>
        
        <div id="handover">
            <br>
            <% if(loginUser != null) { %>
                <button id="modal" style="margin-left:700px; type="button" class="actBtn" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo"
                data-bs-target="#exampleModal" >글쓰기</button>
                <br>
            <% } %>
            <br>
            <table class="tableho" border="1" id="tableho">
                <thead>
                    <tr>
                       <th width="100" id="thTitle">글번호</th>
                        <th width="100" id="thTitle">카테고리</th>
                        <th width="400" id="thTitle">제목</th>
                        <th width="100" id="thTitle">작성자</th> 
                        <th width="200" id="thTitle">작성일</th>
                        <th width="100" id="thTitle">조회수</th>
                    </tr>
                </thead>
                <tbody>
                    <% if(list.isEmpty()) { %>
                        <tr>
                            <td colspan="6" id="textMsg">조회된 게시글이 없습니다.</td>
                        </tr>
                    <% } else { %>
                        <% for(HandOver ho : list){ %>
                            <tr class="list">
                                <td class="list" class="bno"><%=ho.getBoardNo()%></td>
                                <!--<input type="hidden" class="list" name="boardNo" value="<%=ho.getBoardNo()%>">-->
                                <td class="categoryTag"><%= ho.getCategory() %></td>
                                <td class="list"><%= ho.getBoardTitle() %></td>
                                <td class="list"><%= ho.getNickName() %></td>
                                <td class="list"><%= ho.getCreateDate() %></td>
                                <td class="list"><%= ho.getBoardCount() %></td>
                                
                            </tr>
                            <%} %>
                    <% } %>
                </tbody>
            </table>

        <br><br>
            
        <div  align="center" class="paging-area">

  
            <%if(currentPage !=1){%>
            <button class="actBtn" onclick="location.href='<%=contextPath%>/handOver.list?hpage=<%=currentPage-1%>'">&lt;</button>
			<%}%>
            <%for(int i = startPage; i<= endPage; i++){%>
                <%if(currentPage != i){ %>
                <button class="actBtn" onclick="location.href='<%=contextPath%>/handOver.list?hpage=<%=i%>'"><%=i%></button>
                <%}else{ %>
                    <button class="actBtn" disabled><%=i%></button>
                <%}%>
            <%}%>

            <%if(currentPage != maxPage &&maxPage !=0){%>
            <button class="actBtn" onclick="location.href='<%=contextPath%>/handOver.list?hpage=<%=currentPage +1%>'">&gt;</button>
			 <%} %>

        </div>
            
        </div>   
   </div>



    <!-- 끝 -->

    <!-- modal -->

    <div class="modal fade" id="exampleModal" tabindex="-1" data-bs-backdrop="static" data-bs-keyboard="false" aria-labelledby="exampleModalLabel" aria-hidden="true" >
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">양도 게시판 글쓰기</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
              
                <div class="modal-body" >
                    <form action="<%= contextPath %>/handover.insert" method="post" enctype="multipart/form-data">
                        <% if(loginUser != null) { %>

                        <input type="hidden" name="userNo" value="<%= loginUser.getMemberNo() %>">

                        <% } %>

                        <div class="category">
                          <!-- 카테고리(주제를 선택해주세요) -->
                            <select name="category" id="category" class="modal_form" required>
                                <option value="" >주제를 선택해주세요</option>
                                <option value="회원권">회원권</option>
                                <option value="운동기구">운동기구</option>
                                <option value="식품">식품</option>
                            </select>
                          <!-- 바디프로필과 익명은 카테고리를 hidden에 담아서 들구감 -->
                        </div>
                        
                        <br>
                    <div class="title">
                      
                        <input type="text" id="title_div" placeholder="글 제목" maxlength=20 style="width:100%" 
                               name="title" class="modal_form" required>
      
                    </div>
                    <div id="div-tag">   
                        <div id="div-tag" style="display: flex;">
                          <input type="text" id="tag" size="20" placeholder="태그를 입력후 스페이스바를 눌러주세요" style="width:100%; margin: 10px;">
                        </div>
                        <ul id="tag-list">
                          <input type="hidden" name="tagState" value="no">
                        </ul>
                    </div>
      
                    <div class="content" >
                        <textarea style="resize: none; width: 100%; height: 100%"  placeholder="주제에 맞지 않는 글로 판단되어 다른 유저로부터 일정수 이상 신고를 받는 경우 자동으로 숨김처리 될 수 있습니다."
                        id="textarea" name="content" class="modal_form" required></textarea>
                    </div>
                    <div>
                    <p>*양도하실 물건의 사진을 반드시 1장이상 첨부해주세요</p>
                    </div>
                   
    <script>
//---------------------------------------------------------------------------------
//------------------------- 해시태그 등록 부분------------------------------------
//---------------------------------------------------------------------------------

        
        $(function(){
            
            
            var tag = {};
            var counter = 0;

            // 태그를 추가한다.
            function addTag(value) {
            tag[counter] = value; // 태그를 Object 안에 추가
            counter++; // counter 증가 삭제를 위한 del-btn 의 고유 id 가 된다.
            }

            //input태그 안에 값을 넣어서 넘긴다
            var $tagBtn = $('#tag-btn');
            
            $('#tag')
            .on('keyup', function (e) {
                var self = $(this);
                console.log('keypress');
                
                
                // input 에 focus 되있을 때 엔터 및 스페이스바 입력시 구동
                if ( e.keyCode == 32) {
                //console.log($('#tag-btn').click );
                
                var tagValue = self.val().trim(); // 값 가져오기

                // 값이 없으면 동작 안합니다.
                if (tagValue !== "") {

                    // 같은 태그가 있는지 검사한다. 있다면 해당값이 array 로 return 된다.
                    var result = Object.values(tag).filter(function (word) {
                        return word === tagValue;
                    })
        
                    // 해시태그가 중복되었는지 확인
                        if (result.length == 0) { 
                            
                            $("#tag-list").append('<li class="tag-item"> <input type="hidden" name="hashT" value="'+ (tagValue.trim()) +'">' + tagValue + '<span class="del-btn" idx="'+counter+'">x</span></li>');
                            addTag(tagValue);
                            self.val("");
                            $("#tag-list").children('input[name=tagState]').val('yes');
                            console.log($("#tag-list").children('input[name=tagState]').val());
                        } else {
                            alert("태그값이 중복됩니다.");
                        }
                    }
                        e.preventDefault(); // SpaceBar 시 빈공간이 생기지 않도록 방지
                }
            });

            
            // 삭제 버튼
            // 삭제 버튼은 비동기적 생성이므로 document 최초 생성시가 아닌 검색을 통해 이벤트를 구현시킨다.
            $(document)
            .on("click", ".del-btn", function (e) {
            var index = $(this)
            .attr("idx");
            tag[index] = "";
            $(this)
                .parent()
                .remove();
                });
            })
            //enter키 입력 방지    
            $('input[type="text"]').keydown(function() {
            if (event.keyCode === 13) {
                event.preventDefault();
            }
});
      
                
    </script>
                           
                                  
                                  
                            <div>
                                
                               
                                <hr>
                                <input type="button" name="poto" value="사진첨부" class="actBtn" id="poto-none" onclick="onOff();">
                            
                                <input type="button" name="hashTag" value="해시태그" class="actBtn">
                
                            </div>
                
                    <script>
                    $(function(){
                        $('[name=hashTag]').click(function(){
                            if($('#div-tag').css('display')== 'none'){
    
                            $('#div-tag').css('display', 'inline');
                            }else{
                            $('#div-tag').css('display', 'none')
                            }
                            
                            
                        });
    
                    });
                    
    
    
                    </script>

                  
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
                  
                        //클릭시 게시글보기로 이동
                        $(function(){
                            $('#tableho>tbody>tr').click(function(){
                                var $hno = $(this).children().eq(0).text();
                                console.log($hno);

                                location.href = '<%=contextPath%>/detail.ho?hno=' + $hno;
                            })
                           
                            
                        });
                            </script>

    
    <%@ include file="../../common/footer.jsp" %>
</body>
</html>