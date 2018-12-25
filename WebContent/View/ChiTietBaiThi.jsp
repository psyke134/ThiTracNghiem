<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Website thi trắc nghiệm</title>
	<link rel="stylesheet" href="../Style/css/bootstrap.min.css">
    <script src="../Style/css/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../Style/css/exam-detail.css">
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
        <!--<a href="#">Back</a>-->
        <br>
        <div class="detail-field">
            <form action="ChiTietCauHoi" method="post">
                <div class="form-group">
                    <p>Tên bài kiểm tra: ${baiThi.tenBaiThi }</p>
                </div>
                <div class="form-group">
                    <p>Số lượng câu hỏi: ${baiThi.soLuongCauHoi } câu</p>
                </div>
                <div class="form-group">
                    <p>Ngày kiểm tra: ${baiThi.ngayThi.getDay() }-${baiThi.ngayThi.getMonth() }-${baiThi.ngayThi.getYear() }</p>
                </div>
                <div class="form-group">
                    <p>Thời gian bắt đầu: ${baiThi.thoiGianBatDau }</p>
                </div>
                <div class="form-group">
                    <p>Thời lượng: ${baiThi.thoiLuong.getHours() } giờ ${baiThi.thoiLuong.getMinutes() } phút</p>
                </div>

                <hr>
                <div class="row">
                	<input type="hidden" name="thoiLuong" value="${thoiLuong }">
                  <button type="submit" class="col-md-5 text-center btn btn-primary">Vào thi</button>
                    <button type="submit" class="col-md-5 text-center btn btn-secondary">Trở về</button>
                </div>
            </form>
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