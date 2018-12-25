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
				      <li><a href="ClassList">Class</a></li>
				      <li><a href="Logout">Logout</a></li>
				    </ul>
				  </div>
            		</div>
	          
		</c:if>
        </div>
    </div>
    <br>
        <div class="container">
        	<h4>Danh sach lop cua ban: </h4>
        	
        	<c:forEach var="cl" items="${listClass}">
        		<div class="card" style="width: 18rem;">
  				<div class="card-body">
    					<h5 class="card-title"style="color: #3498db">${cl.className}</h5>
  				</div>
			</div>
        	</c:forEach>
        	
        
        	
 		</div>

	<footer class="page-footer font-small blue">
	
	    <div class="footer-copyright text-center py-3">© 2018 Copyright:
	        <a href="#"> LTW sáng thứ 7</a>
	    </div>
	
	</footer>
</div>
</body>
</html>