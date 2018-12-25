<%@page import="java.util.ArrayList"%>
<%@page import="BEAN.cau_hoi"%>
<%@page import="DAO.cauhoi"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu</title>
<meta name="description" content="overview &amp; stats" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="Style/css/bootstrap.min.css" />
<link rel="stylesheet" href="Style/css/font-awesome.min.css" />


<!-- page specific plugin styles -->
<link rel="stylesheet" href="Style/js/jquery-ui.custom.min.css" />
<link rel="stylesheet" href="Style/css/fullcalendar.min.css" />


<!-- text fonts -->
<link rel="stylesheet" href="Style/css/fonts.googleapis.com.css" />

<!-- ace styles -->
<link rel="stylesheet" href="Style/css/ace.min.css"
	class="ace-main-stylesheet" id="main-ace-style" />

<link rel="stylesheet" href="Style/css/ace-skins.min.css" />
<link rel="stylesheet" href="Style/css/ace-rtl.min.css" />

<!-- ace settings handler -->
<script src="../Style/js/ace-extra.min.js"></script>

<link rel="stylesheet " href="Style/css/template.css" type="text/css ">

<script src="Style/js/jquery-2.1.4.min.js"></script>

<script src="Style/js/bootstrap.min.js"></script>

<!-- ace scripts -->
<script src="Style/js/ace-elements.min.js"></script>
<script src="Style/js/ace.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="Style/css/backgroung_chinh.css" />

</head>
<body class="no-skin" style="font-size: 16px;">

	<div class="navbar">
		<div class="row">
			<div class="navbar-brand col-9"">
				<a href="#" style="font-size: 30px; color: white;">HOME PAGE
					QUESTION</a>
			</div>
			<form action="/ThiTracNghiem/View/DangXuat" method="post">
					<button  class="btn btn-outline-success my-2 my-sm-0" type="submit">
						Đăng xuất
					</button>
				</form>
		</div>
	</div>
	<a href="Insertquestion.jsp" style="font-size: 20px; color: blue;"
		class="fa fa-plus-square">Thêm câu hỏi</a>
	<div class="row">
		<div class="col-md-12">
			<div class="card">

				<div id="background">
					<p>Danh sách câu hỏi</p>
				</div>
				<br /> <br />
				<div class="card-body">
					<div class="table-responsive">

						<table class="table">
							<thead class=" text-primary">
								<tr>

									<th width="8%">Mã</th>
									<th>Câu hỏi</th>
									<th width="20%">Mức độ</th>
									<th width="20%">Đáp án</th>
									<th width="20%" class="mr-0">Tùy chọn</th>
								</tr>

							</thead>
							<%
								ArrayList<cau_hoi> ls1 = cauhoi.getListCauhoi();
								for (cau_hoi ch : ls1) {
							%>
							<tr>
								<td><%=ch.getCau_hoi_id()%></td>
								<td><b> <%=ch.getNoi_dung()%></b></td>
								<td><b> <%=ch.getLoai_cau_hoi_id()%></b></td>
								<td><b> <%=ch.getCau_tra_loi_dung()%></b></td>
								<br />

								<td><a
									href="${pageContext.request.contextPath}/Updatequestion?id=<%=ch.getCau_hoi_id()%>"
									class="btn btn-warning"><i class="fa fa-pencil"></i></a>
									
									
									 <a
									class="btn btn-danger"
									href="${pageContext.request.contextPath}/EditQuestion?command=delete&id=<%=ch.getCau_hoi_id()%>">
										<i class="fa fa-trash"></i></a>
										
								</td>
							</tr>
							<%
								}
							%>



						</table>




						<nav aria-label="Page navigation example">
						<ul class="pagination justify-content-center">
							<c:forEach var="i" begin="1" end="${numberPage}">
								<li class="page-item"><a class="page-link"
									href="${pageContext.request.contextPath}/ListQuestion?page=${i}">${i}</a>
								</li>
							</c:forEach>

						</ul>
						</nav>
					</div>
				</div>

			</div>
		</div>
	</div>



</body>
</html>