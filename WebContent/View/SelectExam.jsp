<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script src="../Style/js/jquery-3.3.1.min.js"></script>
	<script src="../Style/js/bootstrap.min.js"></script>
	<script src="../Style/js/bootstrap.bundle.js"></script>
    <link rel="stylesheet" href="../Style/css/bootstrap.min.css">
    <link rel="stylesheet" href="../Style/css/choose-exam.css">
</head>
<body>
<div>
    <div class="navbar">
        <div class="row" style="width: 100%;">
            <div class="navbar-brand col-9"> <a href="#">sth here</a></div>
            <c:if test="${username != null}">
           		 <div class=col-1>
            			<!-- <p style="color: white; margin-top: 5px;"></p> -->
            			<div class="dropdown">
				    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Hello ${username}
				    <span class="caret"></span></button>
				    <ul class="dropdown-menu">
				      <li><a href="GetClass">Class</a></li>
				      <li><a href="Logout">Logout</a></li>
				    </ul>
				  </div>
            		</div>
	          
		</c:if>
        </div>
    </div>
    <br>
        <div class="container">
            <h4>Đang có:</h4>
	            <div class="row">
		            <c:forEach var="exam" items="${listExams}">
		                <div class="form-group col-3 exam-field">
		                    <div class="exam-title">
		                        <p class="form-group" href="#"><c:out value = "${exam.examName}"/></p>
		                    </div>
		                    <hr>
		                    <div class="exam-info">
		                        <div class="exam-duration row">
		                            <i class="fas fa-clock col-1"></i>
		                            <p class="exam-detail col-10"><c:out value = "${exam.duration.getHours()} giờ ${exam.duration.getMinutes()} phút"/></p>
		                        </div>
		
		                        <div class="exam-question row">
		                            <i class="fas fa-book col-1"></i>
		                            <p class="exam-detail col-10"><c:out value = "${exam.startDate}"/></p>
		                        </div>
		                        <form action="LayChiTietDeThi" method="post">
		                        	<input type="hidden" name="quiz_id" value="${exam.examId }">
		                        	<input type="hidden" name="candidate_id" value="${userId }">
		                        	<button type="submit" class="col-md-5 text-center btn btn-primary">Vào thi</button>
		                        </form>
		                    </div>
		                </div>
	            		</c:forEach>
             	</div>
             	
             	 <h4>Những bài đã hoàn thành:</h4>
	            <div class="row">
		            <c:forEach var="doneExam" items="${listDoneExams}">
		                <div class="form-group col-3 exam-field">
		                    <div class="exam-title">
		                        <p class="form-group" href="#"><c:out value = "${doneExam.examName}"/></p>
		                    </div>
		                    <hr>
		                    <div class="exam-info">
		                        <div class="exam-duration row">
		                            <i class="fas fa-clock col-1"></i>
		                            <p class="exam-detail col-10"><c:out value = "${doneExam.duration.getHours()} giờ ${doneExam.duration.getMinutes()} phút"/></p>
		                        </div>
		
		                        <div class="exam-question row">
		                            <i class="fas fa-book col-1"></i>
		                            <p class="exam-detail col-10"><c:out value = "${doneExam.startDate}"/></p>

		                        </div>
		                        
		                        <div class="exam-question row">
		                        	<i class="fas fa-book col-1"></i>
		                        	<p class="exam-detail col-10"><c:out value = "${doneExam.score}"/>điểm</p>
		                        </div>
		                    </div>
		                </div>
	            		</c:forEach>
             	</div>
     </div>

	<footer class="page-footer font-small blue">
	    <div class="footer-copyright text-center py-3">© 2018 Copyright:
	        <a href="#"> LTW sáng thứ 7</a>
	    </div>
	
	</footer>
</div>
</body>
</html>