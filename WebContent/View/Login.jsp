<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="../Style/css/bootstrap.min.css">
    <script src="../Style/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../Style/css/login.css"> 
</head>
<body>
    <div class="background">
        <div class="row">
        <div class="col-4"> </div>
            <div class="login-form col-4">
                <form action='Login' method="post">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Tên đăng nhập</label>
                        <input name="txtUsername" class="form-control" aria-describedby="emailHelp" placeholder="Nhập tên đăng nhập">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Mật khẩu</label>
                        <input name="txtPassword" type="password" class="form-control" placeholder="Mật khẩu">
                    </div>
                    <button type="submit" class="btn btn-primary">Đăng nhập</button>
                </form>
            </div>
            <div class="col-4"> </div>
        </div>
    </div>
</body>
</html>