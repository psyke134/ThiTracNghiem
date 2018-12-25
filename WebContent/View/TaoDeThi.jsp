<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="BEAN.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Web thương mại điện tử</title>
    <link rel="stylesheet" href="../Style/css/admin.css">
    <link rel="stylesheet" href="../Style/css/bootstrap.min.css">
    <script src="../Style/js/jquery-3.3.1.min.js"></script>
    <script src="../Style/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/login.css">
    <!--  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/solid.css"
          integrity="sha384-rdyFrfAIC05c5ph7BKz3l5NG5yEottvO/DQ0dCrwD8gzeQDjYBHNr1ucUpQuljos" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/regular.css"
          integrity="sha384-z3ccjLyn+akM2DtvRQCXJwvT5bGZsspS4uptQKNXNg778nyzvdMqiGcqHVGiAUyY" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/brands.css"
          integrity="sha384-QT2Z8ljl3UupqMtQNmPyhSPO/d5qbrzWmFxJqmY7tqoTuT2YrQLEqzvVOP2cT5XW" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/fontawesome.css"
          integrity="sha384-u5J7JghGz0qUrmEsWzBQkfvc8nK3fUT7DCaQzNQ+q4oEXhGSx+P2OqjWsfIRB8QT" crossorigin="anonymous">
          <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
    <script>
        var QLND_Displayed = false;
        function onQLNDClick()
        {
            if(QLND_Displayed == false)
            {
            	var content1 = '<hr><a style="text-decoration: none; color: green; font-weight: 700;" href="ThemNguoiDung.jsp">Thêm người dùng</a><br>'
            	var content2 = '<a style="text-decoration: none; color: green; font-weight: 700;" href="QuanLyNguoiDung">Danh sách người dùng</a>'
                document.getElementById("QLND").innerHTML = content1 + content2;
                QLND_Displayed = true;
            }
            else
            {
                document.getElementById("QLND").innerHTML = "";
                QLND_Displayed = false;
            }
        }
        var QLHH_Displayed = false;
        function onQLHHClick()
        {
            if(QLHH_Displayed == false)
            {
            	var content1 = '<hr><a style="text-decoration: none; color: green; font-weight: 700;" href="TaoDeThi.jsp">Thêm đề thi</a><br>'
            	var content2 = '<a style="text-decoration: none; color: green; font-weight: 700;" href="LayDanhSachDe">Danh sách đề thi</a><br>'
            	var content3 = '<a style="text-decoration: none; color: green; font-weight: 700;" href="">Gán đề thi</a>'
                document.getElementById("QLHH").innerHTML = content1 + content2 + content3;
                QLHH_Displayed = true;
            }
            else
            {
                document.getElementById("QLHH").innerHTML = "";
                QLHH_Displayed = false;
            }
        }
        
    </script>
    <c:if test="${resultMsg != null }">
    	<c:if test='${resultMsg.equals("thanh cong") }'>
	    	<script>
	    	function thongBao()
	    	{
	    		alert("Đã thêm đề thi thành công!");
	    	}
	    	</script>
    	</c:if>
    	<c:if test='${resultMsg.equals("that bai") }'>
	    	<script>
	    	function thongBao()
	    	{
	    		alert("Thêm đề thi không thành công, vui lòng thử lại!");
	    	}
	    	</script>
    	</c:if>
    </c:if>
</head>
<body onload="thongBao()">


<div class="navbar">
    <div class="nav-brand col-1">
        Quản lý đề
    </div>
		<div class="col-1">
			<c:if test="${username != null}">
				<form action="DangXuat" method="post">
					<button  class="btn btn-outline-success my-2 my-sm-0" type="submit">
						Đăng xuất
					</button>
				</form>

			</c:if>
			
			<c:if test="${username == null}">
				<form action="Login.jsp" method="post">
					<button  class="btn btn-outline-success my-2 my-sm-0" type="submit">
						Dang nhap
					</button>
				</form>
			</c:if>
		</div>
</div>
<div class="content-container">
    <div class="side-bar">
        <img src="../Style/img/noAvatar-1.png" height="100" width="100"></img>
        <h3>ADMIN</h3>
        <hr>
        <br>
        <a style="text-decoration: none; color: green; font-weight: 700;" href="TaoDeThi.jsp">Tạo đề thi</a><br>
        <a style="text-decoration: none; color: green; font-weight: 700;" href="LayDanhSachDe">Xem danh sách đề thi</a><br>
        <a style="text-decoration: none; color: green; font-weight: 700;" href="ThemDeThiVaoLop.jsp">Gán đề cho lớp</a>
    </div>
    <div class="data-container">
    	<div class="action-bar">
            <h3>QUẢN LÝ ĐỀ THI</h3><br>
            <h4 style="color:green;">Tạo đề thi</h4>
        </div>
        <hr>
        <form action="TaoDeThi" method="post">
        	<div class="form-group col-md-12">
        		<label for="deThiId">Mã đề thi:</label>
        		<input class="form-control mr-sm-2" placeholder="Mã đề thi" id="maDeThi" name="maDeThi">
        	</div>
        	<div class="form-group col-md-12">
        		<label for="tenDeThi">Tên đề thi:</label>
        		<input class="form-control mr-sm-2" placeholder="Tên đề thi" id="tenDeThi" name="tenDeThi">
        	</div>
        	<div class="form-group col-md-12">
        		<label for="thoiLuong">Thời lượng:</label>
        		<input class="form-control mr-sm-2" placeholder="Thời lượng(phút)" id="thoiLuong" name="thoiLuong">
        	</div>
        	<div class="form-group col-md-12">
        		<label>Thời gian bắt đầu:</label>
        	</div>
        	<div class="form-row col-md-12">
	        	<div class="form-group col-md-4">
	        		<input class="form-control mr-sm-2" placeholder="Giờ" id="gio" name="gio">
	        	</div>
	        	<div class="form-group col-md-4">
	        		<input class="form-control mr-sm-2" placeholder="Phút" id="phut" name="phut">
	        	</div>
        	</div>
        	<div class="form-group col-md-12">
        		<label>Ngày kiểm tra:</label>
        	</div>
        	<div class="form-row col-md-12">
	        	<div class="form-group col-md-4">
	        		<input class="form-control mr-sm-2" placeholder="Ngày" id="ngay" name="ngay">
	        	</div>
	        	<div class="form-group col-md-4">
	        		<input class="form-control mr-sm-2" placeholder="Tháng" id="thang" name="thang">
	        	</div>
	        	<div class="form-group col-md-4">
	        		<input class="form-control mr-sm-2" placeholder="Năm" id="nam" name="nam">
	        	</div>
        	</div>
        	<div class="form-group col-md-12">
        		<label>Số lượng câu hỏi:</label>
        	</div>
        	<div class="form-row col-md-12">
	        	<div class="form-group col-md-4">
	        		<input class="form-control mr-sm-2" placeholder="Loại dễ" id="loaiDe" name="loaiDe">
	        	</div>
	        	<div class="form-group col-md-4">
	        		<input class="form-control mr-sm-2" placeholder="Loại trung bình" id="loaiTrungBinh" name="loaiTrungBinh">
	        	</div>
	        	<div class="form-group col-md-4">
	        		<input class="form-control mr-sm-2" placeholder="Loại khó" id="loaiKho" name="loaiKho">
	        	</div>
        	</div>
        	<br><br>
        	<div class="form-row col-md-12">
        		<div class="form-group col-md-10">
        		</div>
        		<div class="form-group col-md-2">
        			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Tạo đề thi</button>
        		</div>
        	</div>
        </form>
    </div>
</div>
<!-- Modal thong bao -->

<!-- Modal thong bao -->


<!-- Footer -->
<footer class="page-footer font-small blue">

	
    <!-- Copyright -->
    <div class="footer-copyright text-center py-3">© 2018 Copyright:
        <a href="#"> LTW sáng thứ 7</a>
    </div>
    <!-- Copyright -->

</footer>
<!-- Footer -->

</body>
</html>