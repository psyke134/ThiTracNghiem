<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>Website thi trắc nghiệm</title>
    <link rel="stylesheet" href="../Style/css/bootstrap.min.css">
    <script src="../Style/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../Style/css/index.css">
    <link rel="stylesheet" href="../Style/css/main.css">
    <!--<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/solid.css"-->
    <!--integrity="sha384-rdyFrfAIC05c5ph7BKz3l5NG5yEottvO/DQ0dCrwD8gzeQDjYBHNr1ucUpQuljos" crossorigin="anonymous">-->
    <!--<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/regular.css"-->
    <!--integrity="sha384-z3ccjLyn+akM2DtvRQCXJwvT5bGZsspS4uptQKNXNg778nyzvdMqiGcqHVGiAUyY" crossorigin="anonymous">-->
    <!--<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/brands.css"-->
    <!--integrity="sha384-QT2Z8ljl3UupqMtQNmPyhSPO/d5qbrzWmFxJqmY7tqoTuT2YrQLEqzvVOP2cT5XW" crossorigin="anonymous">-->
    <!--<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/fontawesome.css"-->
    <!--integrity="sha384-u5J7JghGz0qUrmEsWzBQkfvc8nK3fUT7DCaQzNQ+q4oEXhGSx+P2OqjWsfIRB8QT" crossorigin="anonymous">-->

</head>
<body>
<div>
	<div class="navbar">
        <div class="row">
            <div class="navbar-brand col-9"> <a href="#">sth here</a></div>
        </div>
    </div>
	
	<div class="container">
	<h1>Ket qua</h1>
	<p>tong so cau dung: ${soCauDung }/${tongSoCau }</p>
	<p>diem cua ban: ${diem }</p>
	<form action="SelectExam" method="post">
		<button type="submit" class="col-md-5 text-center btn btn-primary">Trở về trang chủ</button>
	</form>
	</div>
	
	<footer class="page-footer font-small blue">

        <div class="footer-copyright text-center py-3">© 2018 Copyright:
            <a href="#"> LTW sáng thứ 7</a>
        </div>

    </footer>
</div>
</body>
</html>