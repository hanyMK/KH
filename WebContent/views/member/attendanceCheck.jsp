<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.member.model.vo.*" %>
<%
	ArrayList<AttendanceCheck> attList = (ArrayList<AttendanceCheck>)session.getAttribute("attList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출석체크 페이지</title> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>  

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
    button{
        color:#052159 ;
        background-color: #C2E5F2;
        border: 1px #C2E5F2;
    }

    #already{
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

    .sec_cal {
    width: 360px;
    margin: 0 auto;
    font-family: "NotoSansR";
}

.sec_cal .cal_nav {
    display: flex;
    justify-content: center;
    align-items: center;
    font-weight: 700;
    font-size: 48px;
    line-height: 78px;
}

.sec_cal .cal_nav .year-month {
    width: 300px;
    text-align: center;
    line-height: 1;
}

.sec_cal .cal_nav .nav {
    display: flex;
    border: 1px solid #333333;
    border-radius: 5px;
}

.sec_cal .cal_nav .go-prev,
.sec_cal .cal_nav .go-next {
    display: block;
    width: 50px;
    height: 78px;
    font-size: 0;
    display: flex;
    justify-content: center;
    align-items: center;
}

.sec_cal .cal_nav .go-prev::before,
.sec_cal .cal_nav .go-next::before {
    content: "";
    display: block;
    width: 20px;
    height: 20px;
    border: 3px solid #000;
    border-width: 3px 3px 0 0;
    transition: border 0.1s;
}

.sec_cal .cal_nav .go-prev:hover::before,
.sec_cal .cal_nav .go-next:hover::before {
    border-color: #ed2a61;
}

.sec_cal .cal_nav .go-prev::before {
    transform: rotate(-135deg);
}

.sec_cal .cal_nav .go-next::before {
    transform: rotate(45deg);
}

.sec_cal .cal_wrap {
    padding-top: 40px;
    position: relative;
    margin: 0 auto;
}

.sec_cal .cal_wrap .days {
    display: flex;
    margin-bottom: 20px;
    padding-bottom: 20px;
    border-bottom: 1px solid #ddd;
}

.sec_cal .cal_wrap::after {
    top: 368px;
}

.sec_cal .cal_wrap .day {
    display:flex;
    align-items: center;
    justify-content: center;
    width: calc(100% / 7);
    text-align: left;
    color: #999;
    font-size: 12px;
    text-align: center;
    border-radius:5px
}

.current.today {background: rgb(242 242 242);}

.sec_cal .cal_wrap .dates {
    display: flex;
    flex-flow: wrap;
    height: 290px;
}

.sec_cal .cal_wrap .day:nth-child(7n -1) {
    color: #3c6ffa;
}

.sec_cal .cal_wrap .day:nth-child(7n) {
    color: #ed2a61;
}

.sec_cal .cal_wrap .day.disable {
    color: #ddd;
}

#already{
    display: none;
}
</style>
</head>

<body>

<%@ include file="../common/menubar.jsp" %>

<div id="outer_010">
    <div>
        <div>
            <br>
            <hr>

            <h2 id="actH2" align="center">출석체크</h2>
            <hr> <br><br>

                <table id="attendance" align="center">

                    <tr>
                        <td><%= loginUser.getNickname() %> 님, 반갑습니다.</td>
                    </tr>
                    <tr>
                        <td id="attCount"></td>
                    </tr>
                    <tr>
                        <td>오늘도 No Sweat과 함께 건강한 하루 보내세요!</td>
                    </tr>
                    <tr>
                        <td height="30"></td>
                    </tr>
                        <tr>
                            <td><button class="actBtn" id="todayattCheck" onclick="todaychk();">오늘 출석 체크 하기!</button></td>
                            <td class="actBtn" id="already">오늘 출석체크가 완료 되었습니다.</td>
                            <td></td>
                        </tr>                   
                    </table>   

                    <br><br>
<div class="sec_cal">
    <div class="cal_nav">
      <a href="javascript:;" class="nav-btn go-prev">prev</a>
      <div class="year-month"></div>
      <a href="javascript:;" class="nav-btn go-next">next</a>
    </div>
    <div class="cal_wrap">
      <div class="days">
        <div class="day">MON</div>
        <div class="day">TUE</div>
        <div class="day">WED</div>
        <div class="day">THU</div>
        <div class="day">FRI</div>
        <div class="day">SAT</div>
        <div class="day">SUN</div>
      </div>
      <div class="dates"></div>
    </div>
  </div>

  <script>
    $(document).ready(function() {
    calendarInit();

    $.ajax({
            		url:'attcheckcount.me',
            		success : function(result){
                        $('#attCount').html('총 ' + result.count+'번 출석 하셨네요~');
                            if(result.todaychk > 0) {
                                $('#todayattCheck').css('display', 'none');
                                $('#already').css('display', 'inline');
                            }
                        }
            })
    });


    function todaychk(){

        $.ajax({
            		url:'todayattcheck',
            		success : function(result){
                        if(result == 'S'){
                            alert("오늘 출석체크 완료! 출석 포인트가 지급 되었습니다!")
                                $.ajax({
                                url:'attcheckcount.me',
                                success : function(result){
                                    $('#attCount').html('총 ' + result.count+'번 출석 하셨네요~');  
                                        if(result.todaychk > 0) {
                                            $('#todayattCheck').css('display', 'none');
                                            $('#already').css('display', 'inline');
                                        }                                  
                        }
            })


                        } 
                        if(result == 'F'){
                            alert("출석체크가 실패 하였습니다. 다시 시도해주세요!")
                        }                                             
            				}
            			})
    }
    
/*
    달력 렌더링 할 때 필요한 정보 목록 

    현재 월(초기값 : 현재 시간)
    금월 마지막일 날짜와 요일
    전월 마지막일 날짜와 요일
*/

function calendarInit() {

    // 날짜 정보 가져오기
    var date = new Date(); // 현재 날짜(로컬 기준) 가져오기
    var utc = date.getTime() + (date.getTimezoneOffset() * 60 * 1000); // uct 표준시 도출
    var kstGap = 9 * 60 * 60 * 1000; // 한국 kst 기준시간 더하기
    var today = new Date(utc + kstGap); // 한국 시간으로 date 객체 만들기(오늘)
  
    var thisMonth = new Date(today.getFullYear(), today.getMonth(), today.getDate());
    // 달력에서 표기하는 날짜 객체
  
    
    var currentYear = thisMonth.getFullYear(); // 달력에서 표기하는 연
    var currentMonth = thisMonth.getMonth(); // 달력에서 표기하는 월
    var currentDate = thisMonth.getDate(); // 달력에서 표기하는 일

    // kst 기준 현재시간
    // console.log(thisMonth);

    // 캘린더 렌더링
    renderCalender(thisMonth);

    function renderCalender(thisMonth) {

        // 렌더링을 위한 데이터 정리
        currentYear = thisMonth.getFullYear();
        currentMonth = thisMonth.getMonth();
        currentDate = thisMonth.getDate();

        // 이전 달의 마지막 날 날짜와 요일 구하기
        var startDay = new Date(currentYear, currentMonth, 0);
        var prevDate = startDay.getDate();
        var prevDay = startDay.getDay();

        // 이번 달의 마지막날 날짜와 요일 구하기
        var endDay = new Date(currentYear, currentMonth + 1, 0);
        var nextDate = endDay.getDate();
        var nextDay = endDay.getDay();

        // console.log(prevDate, prevDay, nextDate, nextDay);

        // 현재 월 표기
        $('.year-month').text(currentYear + '.' + (currentMonth + 1));

        // 렌더링 html 요소 생성
        calendar = document.querySelector('.dates')
        calendar.innerHTML = '';
        
        // 지난달
        for (var i = prevDate - prevDay + 1; i <= prevDate; i++) {
            calendar.innerHTML = calendar.innerHTML + '<div class="day prev disable">' + i + '</div>'
        }
        // 이번달
        for (var i = 1; i <= nextDate; i++) {
            calendar.innerHTML = calendar.innerHTML + '<div class="day current">' + i + '</div>'
        }
        // 다음달
        for (var i = 1; i <= (7 - nextDay == 7 ? 0 : 7 - nextDay); i++) {
            calendar.innerHTML = calendar.innerHTML + '<div class="day next disable">' + i + '</div>'
        }

        // 오늘 날짜 표기
        if (today.getMonth() == currentMonth) {
            todayDate = today.getDate();
            var currentMonthDate = document.querySelectorAll('.dates .current');
            currentMonthDate[todayDate -1].classList.add('today');
        }
    }

    // 이전달로 이동
    $('.go-prev').on('click', function() {
        thisMonth = new Date(currentYear, currentMonth - 1, 1);
        renderCalender(thisMonth);
    });

    // 다음달로 이동
    $('.go-next').on('click', function() {
        thisMonth = new Date(currentYear, currentMonth + 1, 1);
        renderCalender(thisMonth); 
    });

   // calendar.innerHTML = calendar.innerHTML + '<div class="day current" data-date='+i+'>' + i + '</div>'
}
  </script>

  
<br><br><br>

<%@ include file="../common/footer.jsp" %>

</body>
</html>