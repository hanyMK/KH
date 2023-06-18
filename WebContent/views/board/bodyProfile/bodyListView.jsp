<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.ArrayList, com.kh.board.bodyProfileBoard.model.vo.BodyBoard" %>
    <%
        
       ArrayList<BodyBoard> list = (ArrayList<BodyBoard>)request.getAttribute("list");
      

    %>
   
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>바디프로필 LIST</title>



    <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
        <title>Bootstrap Example</title>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    
    
     <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.2.0/css/all.min.css" integrity="sha512-6c4nX2tn5KbzeBJo9Ywpa0Gkt+mzCzJBrE1RB6fmpcsoN+b/w/euwIMuQKNyUoU/nToKN3a8SgNOtPrbW12fug==" crossorigin="anonymous" />
        
    ​



    <style>

/* 좋아요 하트 css */

.btn-like .heart-shape {
    display: inline;
    color: red;
    font-size: 23px;
}
.btn-like {
    border: none;
    background-color: inherit;
    
}




    #head-area{
        width: 100%;
        height: 80px;
    }
    #head-area2{
        margin: auto;
        width: 800px;
        height: 50px;
    }
   
    #writer_btn{
        margin-left: 85%;
        margin-top: 30px;
    }


   
   #outer_2{
    margin: auto;
    width: 800px;
   }

   #table{
    width: 30%;
    height: 30%;
    display: inline-block;
    margin-left: 20px;
    /* box-shadow: 1.5px 1.5px 1.5px 1.5px grey; */
    font-size: small;
    
   }
   tr{
    text-size-adjust: 20px;
   }

   #poto_img{
    width: 200px;
    height: 200px;
   }

   img:hover{
    cursor: pointer;
    opacity: 0.9;
    transition: transform 550ms ease-in-out;
    transform: scale(1.1);
   }
   

   
    
    .content{
        margin-bottom: 20px;
        height: 500px;
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
       
    }
    #poto-area{
        margin-top: 20px;
        display :
    }

    #title{
        width:130px ;
        height:20px;
        overflow: hidden;
        text-overflow: ellipsis; /* 넘어가는 건 ... 처리 */
        white-space  : nowrap; 

    }

    #title:hover {
        cursor:pointer;
        color: #052159;
    }

    

    
      /* ----------------------------------  */

      .poto-area{
        margin-top: 20px;
        display : none;
    }
    
    #vote-area{
        display : none;
    }

      /* ----------------------------------  */


      
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
    .img_3{
      width: auto;
      height: 200px;
    }

    
    /*모달버튼*/
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
      
    </style>






</head>
<body>

<%@ include file="../../common/menubar.jsp" %>

    
<div id="head-area">
    <div id="head-area2">
          <% if(loginUser != null){ %>
    <button type="button" class="actBtn" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo"
    data-bs-target="#exampleModal" id="writer_btn" >글쓰기</button>
    <% } %>   
    </div>
  
</div>





    <div class="outer">
        <div id="outer_2">
           
            
            
                                        <!-- xxxxxxxxxxxxxxxx  게시물이 없을 경우 xxxxxxxxxxxxxxxx x-->

            <% if(list.isEmpty()) {  %>
                <table>
                    <tbody >
                        <tr>
                            <th colspan="2" width="200px" height="200px" >
                                <div align="center"  class="board_body" >
                                    <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAPsAAADJCAMAAADSHrQyAAAAY1BMVEX///+VlZWPj4/j4+O0tLT7+/ucnJyfn5/b29uSkpKkpKSrq6uurq7m5uZmZmaWlpbz8/OIiIjs7Ox5eXlkZGRsbGzNzc2BgYF0dHTU1NRvb2+7u7ve3t7w8PDCwsKKiopcXFxuhZvhAAAELklEQVR4nO3b25KiOhQG4HBIICgHUQgg6rz/U85Kgt3OlNDs6mrdrPm/Kwtzwc9KApIoBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADAU3LBu8/tR8k23i2IW77xcxXqRaGq332OPyRSOviCVjwrX5dfRg+CsH33af6Eqerhc/fLouN3n+cPqF10rdvombzVfLNHrsNrlT//ulZ8s+e+6uVM9Ivi2+f9NDcbfaq65pjdT3PzHX4aD2fNL/uUTc91+MR3+HEM2WX301yQzDyyTVcmyEXKLns+DeY2f353m2bBUYieW/aPpzk981TjZzmKzq7u9dfP8KSMbFtu2Xdrogepa8ssexU+Sfr35QhH35hZ9shnV3N89sg35ph94Xep+wkT+i7PMnu50KBknj1ZaJDpz+zM7u/IvtCAeXb9D2dfXfd/ea5D9pec1ysg+0IDZPefMc+/5LxeAdkXGjxmb3m9o/4vz3W5vU7Msq+su1/AYLQGvT77/TU9n70Hq7N/sU67RWuz31fnGUVfmX2sta86q51Gq7Lra+KjRy87r1dYlT3wVQ9YVX1t9oDbNOeszs5rmnP8usxCg/JedWYdXny9LtP7suuS1zTn+LprtX9OhVN0flX/XIed2Tt87/AMqy4e5vF5DKc5776JaiE6u5vbh3r30b21fYjRbgB8bEDQesdxrN9d8iWckwMAAAAAAAAA/A/FqqyEONtliTExJptez1S7sxBXpXr6nCfKbTDJy+lvg73yDa/u7ySbfYsng6GhfOpE0bpuv+tM5Y5XByVF3DQZfW6bQdtj16Zxixd9YeJsuFX0vUo2nF2Ux+NOiISyx4P9y+Pg12Z89uFg6HPSGbdaVQadvRSyPF7oQpxSERfVG8/8+8qbogra7MqWPD/6/VNT9uxIXdvog627NLE2969ESn0gLi5vPffvKsNrEz1m37vDU5+/dqkQp7PLHnXpeaCwl8N9vXbz2W91Ec9mT81VpMVobPb2mPd2bnjMHlWXarsbrsqbMLe57EUdKnE1tcu+M1XenX32KI7jiMbEsevMdl/clzdJPTmbyV7tjcxK6bLfSn/UZu/DQ0HjvWn7vt9y3eU49LPZWyp9LGx2WVDNE2rj+rzsCwZz3U1Wh11STNnrP7NfquLc9S572jSnU9Pk03hPeWQXmQkKW1MauWP3eI8rLtIc6CZus8cDdXCa+UV1CyWX7BU9uJnCPrZdhcjsTC4+s4tk6IQb7+pAiauCap4N1KZ12Wmev2x2vMuQerpsml+USzfD0CQ+SmVKKfa/anp+S4Q8hjQY3J2tM1LUxjakobAvGhoI291QHdn/84+p3SFd9efzOFVRjhEN/lSKKrUjIRIydfeyiA6JCzXsc7oIqbXt51oAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA+K7fw2lApeR5FTgAAAAASUVORK5CYII=" alt="">
                                </div>
                            </th>
                        </tr>
    
                        <tr>
                            <th width="150px" class="board_body" >...</th>
                            <th>...</th>
                        
                        </tr>
                        <tr>
    
                            <th colspan="1"   class="board_body">...</th>
                            <th rowspan="2" "  class="board_body">...</th>
                            
                        
                        </tr>
                        <tr>
                            <th   class="board_body">...</th>
                        </tr>
    
                    </tbody>
                    
                </table>
            
                
                <% } else { %>
                                <!-- ooooooooooooooooooooooo 게시물이 있을 경우 oooooooooooooooooooooooo -->
                    
                    <% for(BodyBoard bb : list) { %>


            <table id="table">

                
            
            
                <tbody >
                    <tr class="click">
                        <input type="hidden" value="<%= bb.getBoardNo() %>" >
                            <th colspan="2" >
                                <div align="center"  class="board_body" >
                                    <img src="<%= bb.getTitleImg() %>" id="poto_img">
                                </div>
                            </th>
                    </tr>

                    <tr>
                        <th  width="135" colspan="2">
                           <span class="click" id="title">
                                <input type="hidden" value="<%= bb.getBoardNo() %>" >
                                    <%= bb.getBoardTitle() %>
                                    <span style="color: red;" id="replyCount">[<%= bb.getReplyCount()%>]</span>
                           </span>
                        </th>
                        
                    </tr>

                    <tr>
                        <td colspan id="writer"  class="board_body">
                            <!-- 닉네임 -->
                             <p >
                                <%= bb.getNickName() %>
                             </p>
                        </td>
                        <th rowspan="2" id="like"  class="board_body">
                            <input type="hidden" value="<%= bb.getBoardNo() %>" >

                                        <!-- 좋아요 버튼 하트 -->
                                    <!-- ♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥ -->
                                    <!-- ♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡ -->

                                <button type="button" class="btn-like" id="like_poto">


                                        <span class="heart-shape"></span> 
                                        <span class="like-count"></span> 

                                <script>

                               
                                </script>
            
            
                                </button> 
                  
                    </tr>

                        </th>
                    
                    </tr>

                    <tr>
                        <td id="date"  class="board_body">
                            <span style="color: gray; font-size: 12px;">
                                <%= bb.getCreateDate() %> | 조회 <%= bb.getBoardCount() %>
                            </span>
                        </td>   
                    </tr>

                </tbody>
                
            </table>
            <% } %>
            <% } %>
            
                
           
            
        </div>
           
    </div>
    <!-- ============================================= script ============================================================ -->
  


    <script> 


    
     // ================ 게시물 클릭하면 해당 번호의 게시물 이동 ==========================
     // 이미지와 제목을 눌렀을떄 해당 게시물의 번호(key)값을 가지고 번호에 맞는 게시물로 이동한다
            $(function(){
            $('.click').click(function(){
                var v = $(this).children().eq(0).val();
                //console.log(v);
                location.href ='<%= contextPath %>/bodyDetail.by?boardNo=' + v;
            })
        })
        

    
    
     // ========================= 좋아요 기능 LIST VIEW ===========================
       // <!-- ListView 좋아요 기능  -->
       // <!-- 로그인 이후 이용가능 if문 -->




    </script>


    
<!-- ================================== modal글쓰기 작성란 ========================================================================================================= -->



<div class="modal fade" id="exampleModal" tabindex="-1" data-bs-backdrop="static" data-bs-keyboard="false" aria-labelledby="exampleModalLabel" aria-hidden="true" >
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
          <div class="modal-header">
              <h1 class="modal-title fs-5" id="exampleModalLabel">바디프로필 게시판 글쓰기</h1>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          
          
          <div class="modal-body" >
              <form action="<%= contextPath %>/insertBody.by" method="post" enctype="multipart/form-data">
                  
                    <% if(loginUser != null){ %>
                  <input type="hidden" name="userNo" value="<%= loginUser.getMemberNo() %>">
                    <% } %>
                  <div class="category">
                      
                      
                      <!-- 카테고리(주제를 선택해주세요) -->
                    <!--   <select name="category" id="category" class="modal_form" >
                          
                          <option value="" >주제를 선택해주세요</option>
                          <option value="1">1</option>
                          <option value="2">2</option>
                          <option value="3">3</option>
                      </select> -->
  
                      <!-- 바디프로필과 익명은 카테고리를 hidden에 담아서 들구감 -->
                      <input type="hidden" name="hidden" value="바디프로필" id="category_hidden">
  
              </div>
             
  
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
                                              swal({
                                                  title: "태그값 중복",
                                                  text: "태그값이 중복되었습니다.",
                                                  icon: "error" //"info,success,warning,error" 중 택1
                                              });
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
        
                              //input[type=text] enter입력키 막기
                              $('input[type="text"]').keydown(function() {
                                  if (event.keyCode === 13) {
                                      event.preventDefault();
                                  }
                              });
        
        
        
        
                            })
        
                            
        
                      
        
                    </script>
                     
                      
                    
                
                        
          
                      <div class="content" >
                          <textarea style="resize: none; width: 100%; height: 100%"  placeholder="주제에 맞지 않는 글로 판단되어 다른 유저로부터 일정수 이상 신고를 받는 경우 자동으로 숨김처리 될 수 있습니다."
                          id="textarea" name="content" class="modal_form" maxlength="1000" required></textarea>
                        
                          <hr>
                        </div>
                        <div class="">
                          
                        </div>
                        <span id="count">0</span> / 1000
        
                      <script>
        
                        $(function(){
                          $('#textarea').keyup(function(){
                            $('#count').text($(this).val().length);
                          });
                        });
                      </script>
        
        

              
              <div>
                  
                 
                  <hr>
                  <input type="button" name="poto" value="사진첨부" class="actBtn" id="poto-none" onclick="onOff();">
                  <input type="button" name="vote" value="투표" class="actBtn" id="vote-none" onclick="voteOnOff();">
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
                  
              <div id="vote-area">
                <div>
                    투표제목 <input type="text" name="voteTitle">
                </div>
                <div>
                    투표항목<input type="text" name="query1">
                </div>
                <div>
                    투표항목<input type="text" name="query2">
                </div>
                <div>
                    투표항목<input type="text" name="query3">
                </div>
                <div>
                    투표항목<input type="text" name="query4">
                </div>
                <div>
                    투표항목<input type="text" name="query5">
                </div>
                
                <div>
                    복수선택<input type="checkbox" name="dupliYN">
                </div>
            </div>

            <hr>

            <div class="modal-footer">
                <button type="submit" class="actBtn" onclick="return ask();" id="submit">등록</button>
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

      

        function voteOnOff(){

            var $vote = $('#vote-area');

            if($vote.css('display') == 'none'){
                $vote.css('display', 'inline');
            }
            else{
                $vote.css('display', 'none');
            }
        }
    </script>
  
  
  
  <br><br>
  <%@ include file="../../common/footer.jsp" %>


  



 <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br> 
</body>
</html>