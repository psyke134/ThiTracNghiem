<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Web thi trắc nghiệm</title>
    <link rel="stylesheet" href="../Style/css/bootstrap.min.css">
    <script src="../Style/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../Style/css/index.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/solid.css"
          integrity="sha384-rdyFrfAIC05c5ph7BKz3l5NG5yEottvO/DQ0dCrwD8gzeQDjYBHNr1ucUpQuljos" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/regular.css"
          integrity="sha384-z3ccjLyn+akM2DtvRQCXJwvT5bGZsspS4uptQKNXNg778nyzvdMqiGcqHVGiAUyY" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/brands.css"
          integrity="sha384-QT2Z8ljl3UupqMtQNmPyhSPO/d5qbrzWmFxJqmY7tqoTuT2YrQLEqzvVOP2cT5XW" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/fontawesome.css"
          integrity="sha384-u5J7JghGz0qUrmEsWzBQkfvc8nK3fUT7DCaQzNQ+q4oEXhGSx+P2OqjWsfIRB8QT" crossorigin="anonymous">

</head>
<body>
    <div>
        <div class="navbar">
            <div class="row">
                <div class="navbar-brand col-9"> <a href="#">sth here</a></div>
            </div>
        </div>

        <div class="content">
            <div class="container">
            <br><br><br>
            <h2>Danh sách ${tenlophoc}</h2>
            <br>
            	
            	<table class="table">
  					<thead class="thead-dark">
    					<tr>
      						<th scope="col">ID Thí Sinh</th>
      						<th scope="col">Username</th>
      						<th scope="col">Password</th>
      						<th scope="col">Thao Tác</th>
    					</tr>
 					</thead>
  					<tbody>
  					
  						<c:forEach items="${thisinh}" var="entry">
  						<form action="XuLyChiTietLopHocServlet">
  							<tr>  								
  								<td>${entry.nguoi_dung_id}</td>
  								<td>${entry.username}</td>
  								<td>${entry.password}</td> 								 								
  								<td><button type="submit" class="btn btn-info" name = "tennut" value ="xoa" >Xóa</button></td>
  							</tr>
  							<input type="hidden" name = "mathisinh" value = "${entry.nguoi_dung_id}"></input>
  							<input type="hidden" name = "tenlophoc" value = "${tenlophoc}"></input> 
  						</form>
  						</c:forEach>  						
            	 	</tbody>
				</table>
				<form action="XuLyChiTietLopHocServlet">
				<div class="form-row col-md-12">
					<div class="form-group col-md-2"></div>
					
					<input type="hidden" name = "tenlophoc" value = "${tenlophoc}"></input> 
					
					<button type="submit" class="btn btn-success col-md-1" name = "tennut" value ="them" >Thêm</button>
					<div class="form-group col-md-6"></div>
					<button type="submit" class="btn btn-danger col-md-1" name = "tennut" value ="thoat" >Thoát</button>
				</div>
				</form>		
            </div>
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