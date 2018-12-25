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
            	var content1 = '<hr><a style="text-decoration: none; color: green; font-weight: 700;" href="TaoDeThi.jsp">Thêm đề thi</a><br>'
                	var content2 = '<a style="text-decoration: none; color: green; font-weight: 700;" href="ChinhSuaDe.jsp">Danh sách đề thi</a><br>'
                	var content3 = '<a style="text-decoration: none; color: green; font-weight: 700;" href="">Gán đề thi</a>'
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
            	var content1 = '<hr><a style="text-decoration: none; color: green; font-weight: 700;" href="">Thêm hàng hóa</a><br>'
            	var content2 = '<a style="text-decoration: none; color: green; font-weight: 700;" href="">Thêm loại hàng hóa</a><br>'
            	var content3 = '<a style="text-decoration: none; color: green; font-weight: 700;" href="">Danh sách hàng hóa</a>'
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
            <h4 style="color:green;">Xem danh sách đề thi</h4>
        </div>
        <hr>
        <table>
        	<tr>
        		<th>Mã đề thi</th>
        		<th>Tên đề thi</th>
        		<th>Số lượng câu hỏi</th>
        	</tr>
        	<c:forEach items="${danhSachDe }" var="de">
        		<tr>
        			<th>${de.maDeThi }</th>
        			<th>${de.tenDeThi }</th>
        			<th>${de.soLuongCauHoi }</th>
        		</tr>
        	</c:forEach>
        </table>
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