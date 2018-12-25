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
          
    <c:if test ="${thongBao != null }">>
    	<script>
    		function thongBao()
    		{
    			alert('${thongBao}');
    		}
    	</script>
    </c:if>
    <script>
    	function layMaNguoiDung(nguoidung_id)
    	{
    		document.getElementById("nguoiDungId").value = nguoidung_id;
    	}
    </script>

</head>
<body onload="thongBao()">
    <div>
        <div class="navbar">
            <div class="row">
                <div class="navbar-brand col-9"> <a href="#">sth here</a></div>
            </div>
            <div class="col-7"></div>
            <form action="LopHocServlet" method="post">
      			<button class="btn btn-success" type="submit">Quản lý lớp học</button>
      		</form>
            <form action="DangXuat" method="post">
					<button  class="btn btn-outline-success my-2 my-sm-0" type="submit">
						Đăng xuất
					</button>
				</form>
        </div>

        <div class="content">
         	<div class="container">
            <br><br><br>
				<h1><p style="color: red">Quản Lý Người Dùng</p></h1>
				<br>
				<form action="XuLyServlet">
            		<table class="table">
  						<thead>
    						<tr>
    							<th scope="col"><input style="margin: 0 0 0 30%"  type="checkbox" onClick="toggle(this)"></input></th>
      							<th scope="col">Người dùng id</th>
      							<th scope="col">Tên loại người dùng</th>
      							<th scope="col">Username</th>
      							<th scope="col">Password</th>
      							<th scope="col">thao tác</th>
    						</tr>
  						</thead>
  						<tbody>
  					
  							<c:forEach items="${nguoidung}" var="entry">
  								<tr>
  									<td><input style="margin: 0 0 0 30%" type="checkbox" name="nguoi_dung_id" value="${entry.nguoi_dung_id}"></input> </td>
  									<td>${entry.nguoi_dung_id}</td>
  									<td>${entry.ten_loai_nguoi_dung}</td>
  									<td>${entry.username}</td>
  									<td>${entry.password}</td>
  									<td><button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal1" onClick="layMaNguoiDung('${entry.nguoi_dung_id}')">Sửa</button></td>
  								</tr>
  							</c:forEach>
  					
  						</tbody>
  						<script language="JavaScript">
							function toggle(source) {
	  							checkboxes = document.getElementsByName('nguoi_dung_id');
	  							for(var i=0, n=checkboxes.length;i<n;i++) {
	    							checkboxes[i].checked = source.checked;
	  							}
						}
						</script>    
					</table>
					<div class="form-row col-md-12">
					<div class="form-group col-md-1"></div>
					
					<button type="button" class="btn btn-success col-md-1" data-toggle="modal" data-target="#myModal">Thêm</button>
					<div class="form-group col-md-3" ></div>
					
					<div class="form-group col-md-3" ></div>
					
					<button type="submit" class="btn btn-danger col-md-1" name="tennut" value ="xoa">Xóa</button>
					</div>
					
			
				
					<!-- phần thêm dữ liệu -->
					<div class="modal fade" id="myModal" role="dialog">
   						<div class="modal-dialog modal-sm">
      						<div class="modal-content">
        						<div class="modal-header">
          							<h4 class="modal-title">Thêm Người Dùng</h4>
          							
        						</div>
        						<div class="modal-body">
          							<!-- phần nhập dữ liệu -->
          							
          								<form>
  											<div class="form-group">
    											<label for="exampleInputEmail1">Thêm Người Dùng Id</label>
    											<input type="text" class="form-control"  placeholder="thêm người dùng id" name ="themNguoiDungid">
    											<small id="nguoidunghelp" class="form-text text-muted">bắt buộc nhập người dùng id</small>
  											</div> 										  											
  											<div>
  												<label for="exampleInputEmail3">username</label>
  												<input type="text" class="form-control"  placeholder="thêm username" name ="username">
  											</div>
  											<div>
  												<label for="exampleInputEmail3">password</label>
  												<input type="text" class="form-control"  placeholder="thêm password" name ="password">
  											</div>
  											<div class="form-group form-check">
  												<label for="exampleInputEmail2">Chọn loại người dùng</label><br>
    											<input type="radio" class="form-check-input" name="loainguoidung" value="ND1">thí sinh</input><br>
    											<input type="radio" class="form-check-input" name="loainguoidung" value="ND2">quản lý thí sinh</input><br>
    											<input type="radio" class="form-check-input" name="loainguoidung" value="ND3">quản lý đề</input><br>
    											<input type="radio" class="form-check-input" name="loainguoidung" value="ND4">quản lý câu hỏi</input><br>
  											</div>
										</form>
          								
          							<!-- phần nhập dữ liệu -->
        						</div>
									
        						<div class="modal-footer">
        						    <button type="submit" class="btn btn-default" name="tennut" value ="them">Lưu</button>
          							<button type="button" class="btn btn-default" data-dismiss="modal">Thoát</button>
        						</div>
        	</form>					
      						</div>
      						
    					</div>
  					</div>
  				
  				<!-- phần thêm dữ liệu -->
  				
  				<!-- phần sửa dữ liệu -->
  				<form action="XuLyServlet">
  					<div class="modal fade" id="myModal1" role="dialog">
   						<div class="modal-dialog modal-sm">
      						<div class="modal-content">
        						<div class="modal-header">
          							<h4 class="modal-title">Sửa Người Dùng</h4>
        						</div>
        						<div class="modal-body">
          							<!-- phần nhập dữ liệu -->
          							
          								<!--  <form>-->
          									<div>
          										<input type="hidden" id="nguoiDungId" name="nguoidung_id" value="">
          									</div>										  											
  											<div>
  												<label for="exampleInputEmail3">username</label>
  												<input type="text" class="form-control"  placeholder="username" name ="username">
  											</div>
  											<div>
  												<label for="exampleInputEmail3">password</label>
  												<input type="text" class="form-control"  placeholder="password" name ="password">
  											</div>  											
										<!-- </form>-->
          								
          							<!-- phần nhập dữ liệu -->
        						</div>
        						<div class="modal-footer">        						
        						    <button type="submit" class="btn btn-default" name="tennut" value ="sua">Lưu</button>
          							<button type="button" class="btn btn-default" data-dismiss="modal">Thoát</button>
        						</div>
      						</div>
    					</div>
  					</div>
  				
				<!-- phần sửa dữ liệu -->
		
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