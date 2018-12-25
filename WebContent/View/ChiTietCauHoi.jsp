<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Website thi trắc nghiệm</title>
<link rel="stylesheet" href="../Style/css/bootstrap.min.css">
    <script src="../Style/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../Style/css/quiz.css">
    <!--<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/solid.css"-->
    <!--integrity="sha384-rdyFrfAIC05c5ph7BKz3l5NG5yEottvO/DQ0dCrwD8gzeQDjYBHNr1ucUpQuljos" crossorigin="anonymous">-->
    <!--<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/regular.css"-->
    <!--integrity="sha384-z3ccjLyn+akM2DtvRQCXJwvT5bGZsspS4uptQKNXNg778nyzvdMqiGcqHVGiAUyY" crossorigin="anonymous">-->
    <!--<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/brands.css"-->
    <!--integrity="sha384-QT2Z8ljl3UupqMtQNmPyhSPO/d5qbrzWmFxJqmY7tqoTuT2YrQLEqzvVOP2cT5XW" crossorigin="anonymous">-->
    <!--<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/fontawesome.css"-->
    <!--integrity="sha384-u5J7JghGz0qUrmEsWzBQkfvc8nK3fUT7DCaQzNQ+q4oEXhGSx+P2OqjWsfIRB8QT" crossorigin="anonymous">-->
    <script>
    	function setInput(buttonId)
    	{
    		var answerId = "answer_";
    		var count = 1;
    		var answer = document.getElementById(answerId + count.toString());		
    		while(answer != null)
    		{
    			if(answer.checked == true)
    			{
    				document.getElementById("input_for_btn_"+buttonId).value = answer.value;
    			}
    			count ++;
    			answer = document.getElementById(answerId + count.toString());
    		}
    	}
    </script>
</head>
<body>
    <div class="navbar">
        <div class="row">
            <div class="navbar-brand col-9"> <a href="#">sth here</a></div>
        </div>
    </div>

    <div class="container">
        <div class="row quiz-field">
            <div class="col-3 exam-info">
                <div class="countdown">
                
                </div>
                <hr>
                <div class="question-number row">
                    <c:forEach var="i" begin="1" end="${baiThi.soLuongCauHoi }">
                    	<form action="ChiTietCauHoi" method="post">
                    		<input type="hidden" id="input_for_btn_${i }" name="chosen_answer" value="test">
                    		<input type="hidden" name="previous_question" value="${baiThi.cauHoiHienTai }">
							<button id="${i}" onclick="setInput(this.id)" type="submit" style="margin: 5px;" class="col-11 text-center btn btn-primary" name="current_question" value="${i }">Cau ${i }</button>
						</form>
					</c:forEach>
                </div>
                <hr>
				<form action="XacNhanKetThucBai.jsp" method="post">
					<button type="submit" class="exam-submit text-center btn btn-primary">Nộp bài</button>
				</form>

            </div>
            <div class="col-8 exam-question">
               <div class="question">
                   <h4>Câu ${baiThi.cauHoiHienTai }:</h4>
                   <p>${questionDetail.chiTiet }</p>
                   <form action="ChiTietCauHoi" method="post">
                   	   <% int count = 1; //use for naming radio's id%>
                       <c:forEach items="${questionDetail.cauTraLoiEntries }" var="answerEntry">
							<c:if test="${answerEntry.maCauTraLoi == questionDetail.cauTraLoiDaChon.maCauTraLoi }">
								<div class="radio">
									<input type="radio" id="answer_<%=count%>" name="chosen_answer" checked="true" value="${answerEntry.maCauTraLoi }"><label>${answerEntry.chiTiet }</label><br>
								</div>
							</c:if>
							<div class="radio">	
								<input type="radio" id="answer_<%=count%>" name="chosen_answer" value="${answerEntry.maCauTraLoi }"><label>${answerEntry.chiTiet }</label><br>
							</div>
							<%count++; %>
						</c:forEach>
					   <input type="hidden" name="previous_question" value="${baiThi.cauHoiHienTai }">
					   <div class="direct-button row justify-content-between">
                       		<button type="submit" class="col-2 align-self-start text-center btn btn-primary" name="current_question" value="${baiThi.cauHoiHienTai - 1 }">Trước</button>
                       		<button type="submit" class="col-2 align-self-end text-center btn btn-primary" name="current_question" value="${baiThi.cauHoiHienTai + 1 }">Sau</button>
                       </div>
                   </form>
                    
               </div>
            </div>
        </div>
    </div>

    <footer class="page-footer font-small blue">

    <div class="footer-copyright text-center py-3">© 2018 Copyright:
        <a href="#"> LTW sáng thứ 7</a>
    </div>

    </footer>
    
    <script type="text/javascript">
  // properties
  var count = 0;
  var counter = null;

  window.onload = function() {
    initCounter();
  };

  function initCounter() {
    // get count from localStorage, or set to initial value of 3600
    count = getLocalStorage('count') || 10; //Edit value here
/*    count = ${exam.duration}; */
    counter = setInterval(timer, 1000); //1000 will  run it every 1 second
  }

  function setLocalStorage(key, val) {
    if (window.localStorage) {
      window.localStorage.setItem(key, val);
    }
    return val;
  }

  function getLocalStorage(key) {
    return window.localStorage ? window.localStorage.getItem(key) : '';
  }
  function deleteLocalStorage(key){
	  return localStorage.removeItem(key);
  }
  function timer() {
    count = setLocalStorage('count', count - 1);
    if (count == -1) {
      clearInterval(counter);
      deleteLocalStorage('count');
      return;
    }

    var seconds = count % 60;
    var minutes = Math.floor(count / 60);
    var hours = Math.floor(minutes / 60);
    minutes %= 60;
    hours %= 60;

    document.getElementById("timer").innerHTML = hours +  ":"  + minutes +  ":"   + seconds;
  }
 </script>
</body>
</html>