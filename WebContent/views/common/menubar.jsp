<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.member.model.vo.Member" %>
<% 
    Member loginUser = (Member)session.getAttribute("loginUser");

   String alertMsg = (String)session.getAttribute("alertMsg");
   
   String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>menubar</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>  
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>  
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>



<style>
    *{
        list-style: none;
        text-decoration: none;
    }

   .login-area, #user-info{
        background-color: #C2E5F2;
      float : right;
        margin-right : 20px;
   }
   #Sbtn{
      background-color: white;
      color: white;
      height:27px;
      position:absolute;
      padding: none;
      border : none !important;
        margin-top: 17px;
        right: 92px;
   }
   #SearchInput{
        padding: none;
        border: none;
        position: absolute;
        right: 90px;
        border-radius: 5px;
        width:570px; 
        height:37px;
        margin-top: 15px;
      
   }
    #menuchange{
        margin-left: 15px;
        margin-top: 20px;
    }
    #searchdiv{
        position: relative;
        margin: 0 auto;
    }

    #user-info{
        position : relative;
    }

   #user-info a{
      text-decoration : none;
      color : #052159;
      font-size : 13px;
      font-weight: 800;
   }
    .nav-area{
        background-color: #C2E5F2;
        width : 1200px;
        height : 150px;
        margin : auto;
    }
    .menu{
        display : table-cell;
        width : 100px;
        height : 50px;
        margin : auto;
    }
    .menu a{
        text-decoration : none;
        color : #052159;
        font-size: 15px;
        font-weight: 800;
        display : block;
        line-height : 50px;
    }
    .menu a:hover{
        background-color: #9bd7ec;
    }
    #main-search>input{
        border : 1px;
    }
    #memnavi{
        list-style: none;
        margin: 0px;
        padding: 0px;
        height: 100%;
    }

    #memnavi:hover + #testmenu{
        display: block;
    }

    #memnavi > li{
        float : left;
        height: 100%;
        width: 100px;
        text-align: center;
    }

    #memnavi a{
        text-decoration: none;
        color: #052159;
        font-weight: 800;
        display: block; 
      line-height: 35px;
        font-size: 13px;
    }

    #memnavi a:hover{
        font-size : 15px;
        background-color: #9bd7ec;
    }

    #memnavi > li > ul {
        list-style: none;
        padding: 0px;
    }

    #memnavi > li > a:hover + ul{
        display: block; 
    }

    #memnavi > li > ul:hover{
        display : block; 
        }

    #memnavi > li > ul a{font-size: 13px;}
    #memnavi > li > ul a:hover{font-size: 15px;}


    #testmenu{
        position: absolute;
        top: 36px;
        right: 0;
        display: none;

    }

    #testmenu > li{
        width: 78px;
        text-align: center;
        margin-right: 10px;
        background-color: #C2E5F2;
        padding: 4px;
    }

    #testmenu a:hover{
        background-color: #9bd7ec;
    }
   #divF{
      float: left;
      width: 180px;
      /*border: 1px solid black;*/
   }
   #divS{
      float: left;
      width: 770px;
      height: 145px;
      margin: auto;
      /*border: 1px solid black;*/
   }
   #divT{
      float: left;
      width: 220px;
      margin-top:50px;
      /*border: 1px solid black;*/
   }
   #imgAlert{
      cursor:pointer;
        margin-left: 50px;

   }
   
   #hi{
      position: absolute;
   }
   #hashtagSearch{
       display: none;
    }

    </style>


</head>
<body>

   <!--<br clear="both">-->
   
    <div class="nav-area" align="center">
        <div id="main-searchWrap" style="margin:auto;">
           <div id="divF">
              <a href="/nosweat"><img src="resources/common_upfiles/logo.png" alt="" width="140" height="125" id="imgAlert"></a>
                      
           </div>
           <div id="divS">
           <br>
              <div>  
                  <form id="main-search" action="search.do" method="GET" >
                        <div id="searchdiv">
                            <input type="text" id="SearchInput" name="searchWord" required><button class="searchButton" id="Sbtn">
                                <img class="searchButtonImg" id="imgAlert" alt="Submit Form" width="25" height="27" src="resources/common_upfiles/search.png"/>
                            </button>
                        </div>
                   </form>                      
              </div>
                <br>
              <div id="hashtagSearch" >             
             
                </div>                       

            <script>
                $(function(){
                    //해시태그 검색기능
                    $('#SearchInput').before('<input type="hidden" name="cpage" value="1">');
                    $('#searchdiv').children('#SearchInput').keyup(function(e){
                        var tag = $(e.target).val();
                        console.log(tag);
                        if(tag.charAt(0) =='#'){
                            $('#main-search').attr('action','searchTag.hs');
                            console.log( $('#main-search').attr('action'));
                            $('#SearchInput').attr('name','hashtag');
                            console.log('이름 속성 '+  $('#SearchInput').attr('name') );


                            
                            var hashtagList = '';
                            $('#hashtagSearch').css('display', 'block');
                            
                            //console.log($('.hashtagSearch').css('display', 'block'));
                            console.log(tag); 

                     
                                  
                        }else if(tag ==''){
                            $('#hashtagSearch').css('display', 'none');
                            $('#SearchInput').val('');
                            $('#main-search').attr('action','search.do');
                        }
                        
                    });


                           //해시태그 검색 하기
                           $('#Sbtn').click(function(){
                        var hashtag = $('#SearchInput').val().slice(1).trim();
                        console.log('자른 해시태그 '+hashtag);
                        $('#SearchInput').val(hashtag);
                        //location.href='<%=contextPath%>/searchTag.hs?cpage=1&hashtag='+hashtag;
                    })

                });
              
            </script>
        
        
       



           <br>
              <div id="menuchange">
                    <div class="menu"><a href="<%= contextPath %>/list.by">바디프로필</a></div>
                    <div class="menu"><a href="<%=contextPath%>/challengeList.cl?cpage=1">챌린지</a></div>
                    <div class="menu"><a href="<%=contextPath%>/reviewList.re?opage=1">리뷰</a></div>
                    <div class="menu"><a href="<%=contextPath%>/handOver.list?hpage=1">양도</a></div>
                    <div class="menu"><a href="<%=contextPath%>/offerList.oo?opage=1">구인</a></div>
                    <div class="menu"><a href="<%=contextPath%>/toptenList.li">인기급상승</a></div>
              </div>
           </div>
           
            <div class="login-area" align="center" id="divT">
                 <!-- 사용자가 로그인 전 보게될 화면 -->
                 <% if(loginUser == null) { %>
                   <div id="user-info">       
                       <div align="center">
                            <a id="loginfont" href="/nosweat/loginForm.do">로 그 인  |  회 원 가 입</a>
                        </div>
                    </div>
                  <% } else { %>
                    <div id="user-info">        
                        <div align="center">
                            <ul id="memnavi">
                                <li><a href="<%=contextPath %>/logout.me">로그아웃</a></li>
                                <li id="testli"><a href="">마이페이지</a></li>
                            </ul>
                            <ul id="testmenu">
                                <li><a href="<%= contextPath%>/mypage.me">내 활동정보</a></li>
                                <li><a href="<%=contextPath%>/update.me">정보수정</a></li>
                                <li><a href="<%=contextPath%>/qna.me?cpage=1">문의하기</a></li>
                            </ul>
                        </div>
                   </div>
                <% } %>

           <script>
               $(function(){
                   $('#memnavi>#testli').mouseenter(function(){
                       $('#testmenu').css('display','block');
                   })
                   $('#testmenu').mouseleave(function(){
                       $('#testmenu').css('display','none');
                   })
               });
               
           
   
           </script>
       </div>
   </div>
   
            
      <script>
               
               var msg = '<%= alertMsg %>';
               
               if(msg != 'null'){
                  
                  alert(msg);
                  
                  <% session.removeAttribute("alertMsg"); %>
                } 
            </script>          
    </div>

</body>
</html>