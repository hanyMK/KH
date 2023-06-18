<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.member.model.vo.*, com.kh.board.topten.model.vo.SelectAll"%>

<%
	ArrayList<SelectAll> list = (ArrayList<SelectAll>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유로운 운동 커뮤니티 NO Sweat!</title>

   <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<style>
   #wrap_2{
      width: 1200px;
      height: 800px;
      /* border: 1px solid black; */
      margin: auto;
   }
   #div_1{
      width: 198px;
      height: 800px;
      /* border: 1px solid black; */
      float: left;
   }

   #div_3{
      width: 205px;
      height: 800px;
      /* border: 1px solid black; */
      float: left;
      
   }
   #div_4{
      height: 300px;
      /* border: 1px solid black; */
      margin-left: 4px;
      color: #052159;
      font-weight: 600;
      
   }
   #div_5{
      height: 300px;
      margin-top: 60px;
      /* border: 1px solid black; */
   }
   #div_6{
      height: 400px;
      /* border: 1px solid black; */
      margin-left: 4px;
   }

   .myinfobtn{
      color:#052159 ;
      border: 1px #C2E5F2;
      border-radius: 3px;
      font-weight: 600;
      
   }

   #myinfo2{
      display: none;
   }
   
   .hidden11{
   	display: none;
   }

   .aId{
      font-weight: 700;
      color: #052159;
   }
   .aId11{
      font-weight: 700;
      color: #052159;
      margin-left: 30px;
   }
   .aId123{
      font-weight: 700;
      color: #052159;
      margin-left: 100px;
   }
   .toptenAtag{
      font-weight: 700;
      color: #052159;
   }
   #h511{
      font-weight: 600;
      color: #052159;
      margin-bottom: 15px;
      margin-left: 35px;
   }
   #noticeimg{
      margin-bottom: 10px;
   }

/* 익명 스타일 */
.outer{
        width: 780px;  
        margin: auto;
        /* background-color: #C2E5F2 ; */
        color: black;
        margin-top: 5px;
        /*border: 1px solid  rgb(116, 116, 116);*/
        font-size: 30px;  
        float: left;    
}
.list-area{
   text-align: center;
   border: 1px solid white;
}

.list-area > tbody >tr:hover{
   cursor: pointer;
   background-color: crimson;
}

.outer table{
padding-bottom: 500px;

}

.outer table, tr, th, td{

/* border : 1px solid black; */
   height: 50px;
   align-items: center;
}
.outer img{
align-content: center;
box-sizing: border-box;
margin: 10px;

}

/* -----------------익명게시판 스타일------------------- */

   .an_3{   
      width: 720px;
      padding: auto;
   }

   .an_3 td{
      padding: 10px;
      font-size: 20px;
   }
   .contentA{
      margin-bottom: 50px;
      height: 300px;
      font-weight: 900px;
      font-size: 20px;
      margin: 20px;
      border: none;
   }
   .outer h2{
      color:#052159 ;
      margin-top:20px ;
      padding-left: 40px;
   }

   .tbody th{  
      margin: auto;
      box-sizing: border-box;
   }     

   .title_3{
      padding-left: 50px;
      margin: auto;
      font-size: 30px;
      border-bottom: 1px solid gray;
   }
    
   #wrap-over h2{
      color:#052159 ;
   }
      #textMsg{
      pointer-events: none;
   }
   .vote{
    border-bottom:1px solid gray ;
   }

   #modal{
      font-size: small;
      font-weight: 800;
      width: 65px;
      height: 30px;
   }
   
   .heart_fafa{
      font-size: 50px;
   	  color : red;
        text-align: center;
      
   }

   
  

   /*-------------------위로 올리는 버튼----------------*/
/* layout */
html, body{height:100%;}
button{border:0;cursor:pointer;}
a{color:#000;text-decoration:none;line-height:1;}
/* style */
.box-shortcut{position:fixed;right:80px;top:50%;z-index:9000;}
.box-shortcut{border-radius:10px;background:#fff}
.box-shortcut .menu > li > a{display:block;padding:10px;box-sizing:border-box;}
.box-shortcut .menu > li > .on{background:#ed8b3b;}
.box-shortcut .menu > li:first-child > .on{border-radius:30px;}
.box-shortcut .btn-scroll-top{padding:10px;border-radius:30px;background:#C2E5F2;}
.box-shortcut .btn-scroll-top{color:#fff;}


   /*------------------------- 모달창(게시글 작성시)-------------------------------------
   --------------------------------------------------------------------------------- */
/*  모달창    */


        
    #modal{
    color:#052159 ;
    background-color: #C2E5F2;
    border: 1px #C2E5F2;
     }

       
    .content{
    margin-bottom: 20px;
    height: 500px;
    }
    #input-file{
    display: none;
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
    .img_3{
      width: auto;
      height: 200px;
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
       #poto-area{
        margin-top: 20px;
        display : none;
    }
   

    /*----스크롤 스타일----*/
    .wrap1 {
	  padding: 40px;
	  width: 800px;
	  margin: auto;
	  
	}
	.box {
	  padding: 0;
	  margin-top: 40px;
	  border: 1px solid #eee;
	  /* background-color: ghostwhite; */
	  box-sizing: border-box;
	  width: 720px;
	  border-radius: 20px;
	}
	.box:first-child {
	  margin-top: 0;
	}
	/* .box:nth-child(even) {
	  /* background-color: beige; 
	} */
	    

/*----투표스타일-------*/
#vote-area{
        display : none;
    }
    .contentt{
        border: 1px solid blue;
        background-color: #B3DAF2;
        width:1100px;
        height:200px;
        
        
    }
    .imgc{
        background-color:#8db7ee;
        display: inline;
        margin: auto;
        border: 1px solid red;        


    }
    .textcontent{
        border : 1px solid black;
        display : inline-block;
        width : 700px;
        height : 200px;
    }
    .textcontent:hover{
        background-color: #8db7ee;
    }
    /*==== 버튼 스타일 ======*/
    
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
         border-radius: 5px;
     }
     
     
     /*==투표스타일====*/
     
     .  #input-file{
        display: none;
    }
    .modal_form{
        margin: auto;
        margin-bottom: 20px;
        border: none;
    }
    .poto_zone{
        background-color: skyblue;
        display: inline-block;
        width: 180px;
        height: 180px;
    }
    .poto-area{
        margin-top: 20px;
        display : none;
    }
    .poto-area>div{
        margin-top: 5px;
        border-radius: 10px;
        display: inline-table;
    }
     
    
    .vote-area{
        display : none;
    }
    .boardContent{
        background-color: #B3DAF2;
        border-radius: 10px;
        width:790px;
        height:200px;
        margin:10px;
        box-shadow: 2px 2px 2px 2px grey;
    }
    .boardContent:hover{
        background-color: #8db7ee;
    }
    .contentimg{
        background-color:#8db7ee;
        text-align: center; 
        float :left; 
        display:inline-block;
    }
    .chat{
    width:50px;
    height:50px;
    }
</style>
</head>
<body>

    
    <%@ include file="views/common/menubar.jsp" %>

    
    <!-- 상단에는 메뉴바를 보이게 할 것 -->
   
    
   <div id="wrap_2" class="main">
      <div id="div_1" class="main">
         <div id="div_5" class="main">
         	
	         	<% if(loginUser!= null && loginUser.getMemberType().equals("D ")){ %>
	         	<ul>
	         		<li class="aId">회원정보관리
	         			<ul>
	         				<li><a class="aId" href="<%=contextPath%>/adminMemlist?mlcpage=1">전체회원 조회</a></li>
	         				<li><a class="aId" href="<%=contextPath%>/adminBmemList?bmlcpage=1">구인신청 회원</a></li>
	         			</ul>
	         		</li>
	         		<li><a class="aId" href="<%=contextPath%>/report.list?bPage=1">신고관리</a></li>
	         		<li><a class="aId" href="<%=contextPath%>/noticeblist?nbpage=1">공지사항/이벤트 관리</a></li>
	         	</ul>
	        
	         <% } else { %>
	         
	         	<br><br><br>
	         	<a class="aId11" href="<%=contextPath%>/noticeblist?nbpage=1">공지사항 / 이벤트 <img src="resources/common_upfiles/notice.png" id="noticeimg" height="30px" width="30px" alt=""></a>
	         
	         <% } %>
         </div>
         <div id="div_6"> 
         	<h5 id="h511">인기글 top10 <img src="resources/common_upfiles/fire.png" id="noticeimg" width="30px" height="30px" alt=""></h3>
               <div>
	                 <ul id="toptenList">
	
	                 </ul>
               </div>
               <div>
               		<a class="aId123" href="<%=contextPath%>/toptenList.li">더보기 +</a>		
               </div>
         </div>
      </div>
      <div id="div_2" class="outer">
         <thead>
            <%if(loginUser != null){ %>
               <button id="modal"type="button" style="margin-left:680px; margin-top: 40px;" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#boardWriteModal" data-bs-whatever="@mdo" data-bs-target="#boardWriteModal" align="right" >글쓰기</button>
               
               <%} %>
         </thead>     
         
         <script>
            //index에서 익명 게시글 작성하기 버튼
            $(function(){
               $('#modal').click(function(){
                  $('#boardWriteModal').modal('show');
               })




            })
         </script>
   
         <tbody id="table_3"> 
            <div class="wrap1">          
            </div>       
         </tbody>

         <div class="wrap">
            <div class="box-shortcut"> 
               <button class="btn-scroll-top" title="스크롤 이동" >▲</button>
            </div>
         </div>
      </div>

      <div id="div_3" class="main">
         <div id="div_4">
            <% if(loginUser == null) { %>

	        <% } else { %>
	            <br><br>
	            <%= loginUser.getNickname() %>님, <br> 오늘도 건강하세요! <br> <hr>
	            <button class = myinfobtn id="myinfo1bt" onclick="myinfo1();" style="background-color: #C2E5F2;">내 정보</button>
	            <button class = myinfobtn id="myinfo2bt" onclick="myinfo2();" style="background-color: white;">활동정보</button> <br>
              <table id="myinfo1" align="center" style="text-align: center;">
                <tr>
                    <td class="aId" id="myAlarmCount"></td>
                    <td rowspan="2"><a class="aId" href="<%=contextPath%>/message.me?msgpage=1">쪽지 |</a></td>
                    <td rowspan="2"><a class="aId" href="<%=contextPath%>/attcheck.me">출석체크</a></td>
                </tr>
              </table>


              <table id="myinfo2" align="center" style="text-align: center;">
                <tr>
                    <td><a class="aId" href="<%=contextPath%>/myboardList?bcpage=1">게시글 | </a></td>
                    <td><a class="aId" href="<%=contextPath%>/myreplyList?rcpage=1">댓글 | </a></td>
                    <td><a class="aId" href="<%=contextPath%>/mypoint.me?pcpage=1">포인트</a></td>
                </tr>
                <tr>
                    <td id="myBoardCount"></td>
                    <td id="myReplyCount"></td>
                    <td id="myPointCount"></td>
                </tr>
              </table>
              <hr>
            <% } %>
         </div>
        
      </div>
    </div>
            
            
<script>
    
   // 내 알림
   $(function(){
    	$.ajax({
			url : 'myinfo1',
			success : function(result){	
				$('#myAlarmCount').html('<a class="aId" href="<%=contextPath%>/mypage.me">새 알림 '+ result +' |  </a>');
			},
		});	
   });
   // 알림
   function myinfo1(){
      $('#myinfo1').css('display', 'inline');
      $('#myinfo2').css('display', 'none');
      $('#myinfo1bt').css('background-color', '#C2E5F2');
      $('#myinfo2bt').css('background-color', 'white');   
   }
   // 알림
   function myinfo2(){
      $('#myinfo2').css('display', 'inline');
      $('#myinfo1').css('display', 'none');
      $('#myinfo1bt').css('background-color', 'white');
      $('#myinfo2bt').css('background-color', '#C2E5F2');
   
    	$.ajax({
			url : 'myinfo2',
			success : function(result){	
				
				$('#myBoardCount').html(result.myInfo1 + '개');
				
				$('#myReplyCount').html(result.myInfo2 + '개');
				
				$('#myPointCount').html(result.myInfo3 + 'p');
	
				},
				error : function(){
					alert('내 활동정보 조회가 실패하였습니다.');	
				}
		});	
	}
    
   // 인기게시글 탑텐 
    $(function(){
        $.ajax({
            url : 'toptenIndex.tt',
            success : function(list){
                console.log(list);
                
                
                var num = 0;
                for(var i in list){
                	var ulTop = $('#toptenList');
                	var boardTitle1 = list[i].boardTitle;
                	var boardType1 = list[i].boardType;
                	var boardNo1 = list[i].boardNo;

                	var cpA = 'http://localhost:8002/nosweat/detail.noticeList?bno=' + boardNo1;
	                var cpB = 'http://localhost:8002/nosweat/detail.an?bno=' + boardNo1;
	                var cpC = 'http://localhost:8002/nosweat/bodyDetail.by?boardNo=' + boardNo1;
	                var cpD = 'http://localhost:8002/nosweat/challengedetail.cl?cpage=' + boardNo1;
	                var cpE = 'http://localhost:8002/nosweat/detailView.re?opag=' + boardNo1;
	                var cpF = 'http://localhost:8002/nosweat/detail.ho?hno=' + boardNo1;
	                var cpG = 'http://localhost:8002/nosweat/detail.oo?opage=' + boardNo1;
                	
	                num++;
               var div11 = (num) + '_ ' + '<div class="hidden11">' + boardNo1 + '</div>' + boardTitle1
               
               var maxLength = 40;
               
               if(div11.length > maxLength){
                  div11 =  div11.substr(0,maxLength) + "...";
                  ulTop.append('<li class="toptenListLi"><a class="toptenAtag" href="#">'+ div11 + '</a></li>');
               } 
               else {
                   ulTop.append('<li class="toptenListLi"><a class="toptenAtag" href="#">'+ div11 + '</a></li>');
               }
               
					
                	
                	switch(boardType1){
					case "공지사항" : $('.toptenAtag').eq(i).attr('href', cpA); break;
					case "익명" : $('.toptenAtag').eq(i).attr('href', cpB); break;
					case "바프" : $('.toptenAtag').eq(i).attr('href', cpC); break;
					case "챌린지" : $('.toptenAtag').eq(i).attr('href', cpD); break;
					case "리뷰" : $('.toptenAtag').eq(i).attr('href', cpE); break;
					case "양도" : $('.toptenAtag').eq(i).attr('href', cpF); break;
					case "구인" : $('.toptenAtag').eq(i).attr('href', cpG); break;

					}
					
                	console.log($('.toptenAtag').eq(i).html().length);
                }
            },
            error : function(){
                console.log('조회 실패');
            }
        });	
	})
</script>

<!-- 익명 메인 스크립트 -->
<script type="text/javascript">
   //------------------------- 페이징 처리 스크립트-------------------------------------
 
   //=====맨위로 올리기
   (function($){
   
      $.fn.quickMenu = function(){
      return this.each(function(){
         var idx = 0;
         var h = [];
         var $wrap = $(this);
         var $menu = $wrap.find(".menu");
         var $btn = $menu.children("li").children("a");
         var $btnScrollTop = $wrap.find(".btn-scroll-top");
         var $section = $(".section");
         var wrapH = $wrap.outerHeight();
         var wrapT = $wrap.position().top;
         var nowScroll = 0;
         var scrolling = true;
   
         function btnActive(num){
            $btn.not($btn.eq(num)).removeClass("on");
            $btn.eq(num).addClass("on");
         }
   
         function moveScroll(num){
            if(scrolling){
            scrolling = false;
            $("html, body").animate({scrollTop : num}, function(){scrolling = true});
            }
         }
            
         btnActive(idx);
   
         $wrap.css({"margin-top": -(wrapH / 2)});
         
         $btn.on("click", function(e){
            e.preventDefault();
            idx = $(this).parent().index();
            var conT = $section.eq(idx).offset().top;
   
            moveScroll(conT);
         });
         
         $btnScrollTop.on("click", function(e){
            e.preventDefault();
            
            moveScroll(0);
         });
         
         $(window).scroll(function(){
            
            nowScroll = $(this).scrollTop();
            
            $section.each(function(idx){
            h[idx] = $(this).offset().top
            
            if(nowScroll >= h[idx]){
               btnActive(idx);
            }
            });
         });   
      });
      }
      
   })(jQuery);
 
$(function(){
   $(".box-shortcut").quickMenu();
});
 
   var cpage = 1;
   var setT='';
   $(function(){
       scrollPage();
     
      $(window).scroll(function(){
       var $window = $(this);
       var scrollTop = $window.scrollTop();
       var windowHeight =$window.height();
       var documentHeight = $(document).height();
       console.log("scrollTop"+scrollTop);
       console.log("windowHeight"+windowHeight);
       console.log("documentHeight"+documentHeight);
       
       console.log("documentH: " + documentHeight +", scrolltop : " 
       +scrollTop +", wibdowH :"+ windowHeight + "\nscrollTop+windowHeight+50 :" +scrollTop+windowHeight+50 );
            if(scrollTop+windowHeight+10 >= documentHeight){
               cpage++ ;
               setT =  setTimeout(scrollPage(),2000);
            }
      })
      
      var result='';
      var file = '';
      var url ='';
      var boardNo='';
      var voteTitle='';
 
      function scrollPage(){
         $.ajax({
            url: 'scroll.an',
            type: 'get',
            data: {'cpage': cpage},
            success : function(list){
               console.log(cpage);
            if(list.length == 0 ){
            	
            	 scroll.
               result = 
                  '<div class="box">'
                   +'<tr>'
                   + '<td colspan="6">조회된 게시글이 없습니다</td>' 
                   +'</tr>'
                   +'</div>';
                 
                  $('.wrap1').after(result);
                  
                  clearTimeout(setT);
                  
                  
            }
               else if(list.length >0){    
                  for(var i in list){
                  
                     if(list[i].fileNo>0){
                     
                 
                     url= '<%=contextPath %>/'+list[i].filePath;
                     boradNo = '<%=contextPath %>/detail.an?bno='+list[i].boardNo;
                     console.log(url);
                     result =  
                           '<div class="box">'
                              +'<table class="an_3" cellspacing="1">'                       
                                 +'<tr>'  
                                       +'<th class="title_3" colspan="6">'
                                       + list[i].boardTitle
                                       +' <input type="hidden" name="boardNo" value="'+list[i].boardNo+'">'
                                       +'</th>'
                                 + '</tr>'
      
                                 +'<tr>'
                                       +'<td ><img width="50px" height="50px" src="resources/thumbnail_upFiles/NoSweat_20230512002355_38018.jpg" alt=""></td>'
                                       +'<td>익명</td>'
                                       +'<td colspan="3">| '+ list[i].createDate  +'</td>'
                                    +' <td class="reply_3"> <img  class="chat" src="resources/thumbnail_upFiles/NoSweat_20230512002355_77724.png">' +  list[i].replyCount   +'</td> '   
                                 +'</tr>'
                                    
         
                                 +'<tr align="center" >'
                                    + '<td colspan="6" class ="photo_3" >'  
                                       + '<img class="img_3" onclick="javascript:location.href=\''+boardNo+'\'" src="'+url+'">'
                                    +'</td>'
                                 +'</tr>'
                                    
                                 +'<tr>' 
                                    +' <td class="contentA" colspan="6" align="center">'
                                       + list[i].boardContent
                                       +' <input id="boardNo" type="hidden" name="boardNo" value="'+list[i].boardNo+'">'
                                    +'</td>'	
                                 +'</tr>'
      
                                 +'<tr>' 
                                       +' <td class="vote" colspan="6" align="center">'
                                       + list[i].voteTitle
                                       +' <input type="hidden" name="boardNo" value="'+list[i].boardNo+'">'
                                       +'</td>'
                                       +'</tr>' 
               
                                 +'<tr>'
                                       +'<td colspan="2"></td>'
                                       +'<td colspan="2" >'
                                          +'<span class="heart_fafa">' + '♡' + '</span>'
                                          +'<span>' + list[i].postLike + '</span>'
                                          
                                       +'</td>'
                                 
                                       +'<td colspan="2">'
                                       +'<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-share-fill" viewBox="0 0 16 16">'
                                       +'<path d="M11 2.5a2.5 2.5 0 1 1 .603 1.628l-6.718 3.12a2.499 2.499 0 0 1 0 1.504l6.718 3.12a2.5 2.5 0 1 1-.488.876l-6.718-3.12a2.5 2.5 0 1 1 0-3.256l6.718-3.12A2.5 2.5 0 0 1 11 2.5z"/>'
                                       +'</svg>'
                                       +'</td>'
                                 +'</tr>'
                              +'</table>'
                           +'</div>' ;
   
                              $('.wrap1').append(result);               
                     } else {
      
                     result = 
                           '<div class="box">'
                              +'<table class="an_3" cellspacing="1">'                       
                                 +'<tr>'  
                                       +'<th class="title_3" colspan="6">'
                                       + list[i].boardTitle
                                       +' <input type="hidden" name="boardNo" value="'+list[i].boardNo+'">'
                                       +'</th>'
                                 + '</tr>'
      
                                 +'<tr>'
                                    +'<td ><img width="50px" height="50px" src="resources/thumbnail_upFiles/NoSweat_20230512002355_38018.jpg" alt=""></td>'
                                    +'<td>익명</td>'
                                    +'<td colspan="3">| '+ list[i].createDate  +'</td>'
                                    +' <td class="reply_3"><img><img  class="chat" src="resources/thumbnail_upFiles/NoSweat_20230512002355_77724.png">' +  list[i].replyCount   +'</td> '   
                                 +'</tr>'   
         
                                 +'<tr>' 
                                       +' <td class="contentA" colspan="6" align="center">'
                                       + list[i].boardContent
                                       +' <input type="hidden" name="boardNo" value="'+list[i].boardNo+'">'
                                       +'</td>'
                                 +'</tr>' 	
                                       //투표
                                 +'<tr>' 
                                       +' <td class="vote" colspan="6" align="center">'
                                      
                                       + list[i].voteTitle
                                       +' <input type="hidden" name="boardNo" value="'+list[i].boardNo+'">'
                                       +'</td>'
                                 +'</tr>' 	    
         
                                 +'<tr>'
                                    +' <td colspan="2"></td>'
                                    +'<td colspan="2" >'
                                          +'<span class="heart_fafa">' + '♡' + '</span>'
                                          +'<span>' + list[i].postLike + '</span>'
                                          
                                    +'</td>'
                                    
                                    +'<td colspan="2">'
                                       +'<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-share-fill" viewBox="0 0 16 16">'
                                       +' <path d="M11 2.5a2.5 2.5 0 1 1 .603 1.628l-6.718 3.12a2.499 2.499 0 0 1 0 1.504l6.718 3.12a2.5 2.5 0 1 1-.488.876l-6.718-3.12a2.5 2.5 0 1 1 0-3.256l6.718-3.12A2.5 2.5 0 0 1 11 2.5z"/>'
                                       + '</svg>'
                                    +'</td>'
                                 +'</tr>'
                              +'</table>' 
                           +'</div>' ;
 
            $('.wrap1').append(result);
   
                     }
                  }   
               }                       
            },
            error : function(){
               console.log('실패 : ') 
            }
         });
      }
   });
</script>
  
<script>
   //------------------------- 상세 게시글 조회----------------------------------
   $(function(){
 
     $('.wrap1').on('click', '.title_3, .contentA',function(event){
       
       var bno = $(this).children(':hidden').val();
       console.log(bno);
       location.href = '<%=contextPath %>/detail.an?bno='+ bno;
       console.log(bno);
     });
   })
</script>
 
<script>
   //------------------------- 게시글 신고------------------------------------
   $(function(){
 
     $('.an_3').on('click', '.report', function(){
       var boaradNo = $(this).$('#boardNo').attr();
       console.log(boaradNo);
       $('input[name=userNo]').attr('value', boaradNo);
     });
   });
</script>
 
 
 <!----------글작성  모달 창 ------------------ -->
 
 <div class="modal fade" id="boardWriteModal" tabindex="-1" data-bs-backdrop="static" data-bs-keyboard="false" aria-labelledby="exampleModalLabel" aria-hidden="true" >
   <%@ page import="com.kh.member.model.vo.Member" %>
   <div class="modal-dialog modal-lg">
       <div class="modal-content">
         <div class="modal-header">
            <h1 class="modal-title fs-5" id="exampleModalLabel">익명 게시판 글쓰기</h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">x</button>
         </div>
   
   
         <div class="modal-body" >
            <form action="<%= contextPath %>/insert.an" method="post" enctype="multipart/form-data">
 
         <% if(loginUser != null) { %>
 
            <input type="hidden" name="userNo" value="<%= loginUser.getMemberNo() %>">
           
         <% } %>
            <input type="hidden" name="category" value="익명" >  
               <div class="title">
                  <input type="text" id="title_div" placeholder="글 제목" maxlength=20 style="width:100%" name="title" class="modal_form" required>
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
   //------------------------- 해시태그 등록 부분------------------------------------        
               
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
      id="textarea" name="content" class="modal_form" maxlength="100" required></textarea>
   
      <hr>
   </div>
   <div class="">
         
   </div>
      <span id="count">0</span> / 100

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
      <input type="button" name="vote" value="투표" class="actBtn" onclick="voteOnOff();">
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
                          <input type="file" name="file1" >
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
         
         
         <div class="vote-area" align="left">
         
                        <div style="font-weight:1000;">
                            투표제목 > <input type="text" name="voteTitle" placeholder="투표 제목을 입력해주세요." style="width:300px;">
                        </div>
                        <hr>
                        <div>
                            투표항목 > <input type="text" name="query1" placeholder="1. 항목을 입력해주세요" style="width:300px;">
                        </div>
                        <hr>
                        <div>
                            투표항목 > <input type="text" name="query2" placeholder="2. 항목을 입력해주세요" style="width:300px;">
                        </div>
                        <hr>
                        <div>
                            투표항목 > <input type="text" name="query3" placeholder="3. 항목을 입력해주세요" style="width:300px;">
                        </div>
                        <hr>
                        <div>
                            투표항목 > <input type="text" name="query4" placeholder="4. 항목을 입력해주세요" style="width:300px;">
                        </div>
                        <hr>
                        <div>
                            투표항목 > <input type="text" name="query5" placeholder="5. 항목을 입력해주세요" style="width:300px;">
                        </div>
                        <hr>
                        <div>
                            복수선택  <input type="checkbox" name="dupliYN">
                        </div>
                    </div>
 
            <div class="modal-footer">   
               <button type="submit" class="actBtn" onclick="return ask();">등록</button>
               <button type="button" class="actBtn1" onclick="modalClose()">닫기</button>
            </div>
         </form>

         </div>
      </div>
   </div>
</div>
   
 
<script>

	function modalClose() {
	    $('#boardWriteModal').modal('hide'); 
	    $('#boardWriteModal').hide();
	    $('.jquery-modal').hide();
	}

   function ask(){
      return confirm('익명게시판은 등록 후 수정이 불가능 합니다. 등록하시겠습니까?')   
   };

   function onOff(){                  
      var $onOff = $('.poto-area');
      
      if($onOff.css('display') == 'none'){
         $onOff.css('display','inline');
      }
      else{
         $onOff.css('display','none');
      }
   }

   //투표 목록 보이기
   function voteOnOff(){
      var $vote = $('.vote-area');

      if($vote.css('display') == 'none'){
         $vote.css('display', 'inline');
      }
      else{
            $vote.css('display', 'none');
      }
   }
</script>   

<br>

</body>
</html>