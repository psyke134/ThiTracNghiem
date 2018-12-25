<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Web thi trắc nghiệm</title>
    <link rel="stylesheet" href="../Style/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
            <div class="col-7"></div>
            <form action="NguoiDungServlet" method="post">
      			<button class="btn btn-success" type="submit">Quản lý người dùng</button>
      		</form>
            <form action="DangXuat" method="post">
					<button  class="btn btn-outline-success my-2 my-sm-0" type="submit">
						Đăng xuất
					</button>
				</form>
		</div>
        </div>

        <div class="content">
            <br><br><br><br>
            <div class="container">
            	<div>
            		<div class="form-row col-md-12">
            		<div class="form-group col-md-4"></div>
            		<h2 style="color: blue">Danh Sách Lớp Học</h2>
            	</div>
  				<br>
  				
  				<div class="list-group">
  					<c:forEach items="${lophoc}" var="entry"> 
  					<form action="XuLyLopHocServlet">						
  							<div class="form-row col-md-12">
  							<button type ="submit" class="btn btn-info col-md-10 " name ="tennut" value="xemchitiet""><font size="5">${entry.ten_lop_hoc}</font></button>
  							<div class="form-group col-md-1"></div>
  						
  							<input type="hidden" name = "tenlophoc" value = "${entry.ten_lop_hoc}"></intput>
  							<button type="submit" class ="btn btn-danger col-md-1" name="tennut" value="xoa">Xóa</button>
  							</div>  												
  						<br>
  					</form>
  					</c:forEach>   			  				
  				</div>
  					<div class="form-row col-md-12">
  					<div class="form-group col-md-5"></div>
  					<button type="button" class ="btn btn-success col-md-1" data-toggle="modal" data-target="#myModal">Thêm</button>
  				
  				<form action="XuLyLopHocServlet">
  					<!-- phần thêm dữ liệu -->
  				
  		  			<div class="modal fade" id="myModal" role="dialog">
   						<div class="modal-dialog modal-sm">
      						<div class="modal-content">
        						<div class="modal-header">
          							<h4 class="modal-title">Thêm lớp Học</h4>
        						</div>
        						<div class="modal-body">
          							<!-- phần nhập dữ liệu -->
          							
          						 	<form>
          									<div>
          										<input type="hidden" name ="nguoidung_id" value="">
          									</div>										  											
  											<div>
  												<label for="exampleInputEmail3">tên lớp học</label>
  												<input type="text" class="form-control"  placeholder="tên lớp học" name ="ten_lop_hoc">
  											</div>
  											<br> 											
										</form> 
										
          								
          							<!-- phần nhập dữ liệu -->
        						</div>

        						<div class="modal-footer">
        						    <button type="submit" class="btn btn-default" name="tennut" value ="them">Lưu</button>
          							<button type="button" class="btn btn-default" data-dismiss="modal">Thoát</button>
        						</div>
      						</div>
    					</div>
  					</div>
  					
  				
  				<!-- phần thêm dữ liệu -->
  				
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
    </div>
</body>
</html>