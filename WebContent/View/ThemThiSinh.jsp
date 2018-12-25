<%@ page language="java" contentType="text/html; charset=UTF-8"
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
          
          <script language="JavaScript">
							function toggle(source) {
	  							checkboxes = document.getElementsByName('nguoi_dung_id');
	  							for(var i=0, n=checkboxes.length;i<n;i++) {
	    							checkboxes[i].checked = source.checked;
	  							}
						}
		</script>  

</head>
<body>
    <div>
        <div class="navbar">
            <div class="row">
                <div class="navbar-brand col-9"> <a href="#">sth here</a></div>
            </div>
            <div class="col-1">
				<form action="DangXuat" method="post">
					<button  class="btn btn-outline-success my-2 my-sm-0" type="submit">
						Đăng xuất
					</button>
				</form>

		</div>
        </div>

        <div class="content">
            <div class="container">
            <br><br><br>
            <h1>Danh sách các thí sinh có thể thêm vào ${ tenlphoc}</h1>
            <form action="ThemThiSinhServlet">
            	<table class="table">
  					<thead class="thead-light">
    					<tr>
    						<th scope="col"><input style="margin: 0 0 0 30%"  type="checkbox" onClick="toggle(this)"></input></th>
      						<th scope="col">ID Thí Sinh</th>
      						<th scope="col">Username</th>
      						<th scope="col">Password</th>
    					</tr>
  					</thead>
  				<tbody> 				
  					<c:forEach items="${danhsachts}" var="entry">
  						<c:if test="${entry.ten_loai_nguoi_dung.equals(malophoc) == false ||entry.ten_loai_nguoi_dung == null}"> 
  							<tr>
  								<td><input style="margin: 0 0 0 30%" type="checkbox" name="nguoi_dung_id" value="${entry.nguoi_dung_id}"></input> </td> 						
  								<td>${entry.nguoi_dung_id }</td>
  								<td>${entry.username }</td>
  								<td>${entry.password }</td>
  							</tr>
  						</c:if>
  					</c:forEach>					
            	</tbody>
				</table>
				<input type="hidden" name ="tenlophoc" value="${tenlophoc}">
				<div class="form-row col-md-12">
					<div class="form-group col-md-1"></div>
					
					<button type="submit" class="btn btn-success col-md-1" name="tennut" value ="them">Thêm</button>
					<div class="form-group col-md-3" ></div>
					
					<div class="form-group col-md-3" ></div>
					
					<button type="submit" class="btn btn-danger col-md-1" name="tennut" value ="huy">Hủy</button>
				
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