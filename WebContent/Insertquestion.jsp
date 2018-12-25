<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page import="java.sql.*"%>
<%
	ResultSet resultset = null;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert Question</title>

<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet">
<meta name="description" content="overviewque &amp; stats" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

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
<script src="Style/js/ace-extra.min.js"></script>

<link rel="stylesheet " href="Style/css/template.css" type="text/css ">

<script src="Style/js/jquery-2.1.4.min.js"></script>

<script src="Style/js/bootstrap.min.js"></script>

<!-- ace scripts -->
<script src="Style/js/ace-elements.min.js"></script>
<script src="Style/js/ace.min.js"></script>
<script src="Style/js/jquery.min.js"></script>

<script type="text/javascript"
	src="//code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript"
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

</head>

<body class="no-skin" style="font-size: 14px;">
	<div class="navbar">
		<div class="row">
			<div class="navbar-brand col-9"">
				<a href="Homepage.jsp" style="font-size: 30px; color: white;">HOME
					PAGE QUESTION</a>
			</div>
		</div>
	</div>
	<div id="navbar" class="navbar navbar-default          ace-save-state">


		<div class="main-container ace-save-state" id="main-container">
			<script type="text/javascript">
				try {
					ace.settings.loadState('main-container')
				} catch (e) {
				}
			</script>

			<!-- DYNAMIC CREATING TEXTAREA -->
			




			<div class="main-content">
				<div class="main-content-inner">


					<div class="page-content">
						<!-- /.ace-settings-container -->


						<div class="page-header">
							<h1>Thêm câu hỏi</h1>
						</div>

						<div class="row">
							<div class="col-md-6">
								<div class="well-block">
									<div class="well-title">
										<h2 align="left">Thêm câu hỏi</h2>
									</div>
									<form method="POST" action="InsertQuestion"
										id="addquestion" name="addquestion"
										>
										<!-- Form start -->
										<div class="row">
											<!-- Select Basic -->
											<div class="col-md-12">
												<div class="form-group">
													<label class="control-label" for="appointmentfor">Mức
														độ</label> <br>
													<%
														String url = "jdbc:mysql://localhost:3306/web";
														String username = "root";
														String password = "211162";
														try {
															Class.forName("com.mysql.jdbc.Driver");
															Connection connection = DriverManager.getConnection(url, username, password);

															Statement statement = connection.createStatement();

															resultset = statement.executeQuery("select * from loai_cau_hoi");
													%>
													
													<select id="mucdo1id" name="mucdoid" 
														style="border: 1px solid #00ffc1">
														<%
															while (resultset.next()) {
														%>
														<option selected value="<%=resultset.getString(1)%>">
															<%=resultset.getString(2)%>
														</option>
														<%
															}
														%>
													</select>

													<%
														} catch (Exception e) {
															out.println("wrong entry  " + e);
														}
													%>

												</div>
											</div>
											<!-- Select Basic -->

											<div class="col-md-12">
												<div class="form-group">
													<label class="control-label" for="name">Mã câu hỏi
														câu hỏi</label> <input id="idcauhoi" name="idcauhoi" type="text"
														placeholder="Content" class="form-control input-md">
												</div>
											</div>

                                            <div class="col-md-12">
												<div class="form-group">
													<label class="control-label" for="name">Nhập mức độ
														</label> <input id="idcauhoi" name="mucdo" type="text"
														placeholder="Content" class="form-control input-md">
												</div>
											</div>
											
											<div class="col-md-12">
												<div class="form-group">
													<label class="control-label" for="name">Nội dung
														câu hỏi</label> <input id=noidungcauhoi" name="noidungcauhoi"
														type="text" placeholder="Content"
														class="form-control input-md">
												</div>
											</div>
											<div class="col-md-12">
												<input name="dapana" type="text" placeholder="dap an a">
												<input type="radio" name="da" value="A">
											</div>
											<div class="col-md-12">
												<input name="dapanb" type="text" placeholder="dap an b">
												<input type="radio" name="da" value="B">
											</div>
											<div class="col-md-12">
												<input name="dapanc" type="text" placeholder="dap an c">
												<input type="radio" name="da" value="C">
											</div>
											<div class="col-md-12">
												<input name="dapand" type="text" placeholder="dap an d">
												<input type="radio" name="da" value="D">
											</div>
										</div>
										<input type="submit" value="ADD" id="insert" name="insert"
											class=" btn-info" />
									</form>
								</div>

								<!-- form end -->


							</div>

							<div class="col-md-6">
								<div class="well-block">
									<div class="well-title">
										<h2 align="left">Import File Excel</h2>
									</div>
									<div class="">
										<form method="POST" action="UploadQuestion?pageid=1"
											enctype="multipart/form-data">

											File to upload <input type="file" name="file"> <br>
											Mức độ <br>

											<%
												try {
													//Class.forName("com.mysql.jdbc.Driver").newInstance();
													Class.forName("com.mysql.jdbc.Driver");
													Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/web", "root","211162");
													Statement statement = connection.createStatement();

													resultset = statement.executeQuery("select * from loai_cau_hoi");
											%>

											<select id="questiontypeid2" name="questiontypeid2"
												style="border: 1px solid #00ffc1">
												<%
													while (resultset.next()) {
												%>
												<option selected value="<%=resultset.getString(1)%>">
													<%=resultset.getString(2)%>
												</option>
												<%
													}
												%>
											</select>

											<%
												} catch (Exception e) {
													out.println("wrong entry" + e);
												}
											%>
											<br> <br> <input type="submit" value="IMPORT"
												id="import" name="import" class=" btn-info">
										</form>
									</div>
									<!-- form end -->
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
			<!-- /.page-header -->

		</div>
		<!-- /.page-content -->
	</div>


	<!-- /.main-content -->



	<a href="#" id="btn-scroll-up"
		class="btn-scroll-up btn btn-sm btn-inverse"> <i
		class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
	</a>
	<!-- /.main-container -->
</body>

</html>