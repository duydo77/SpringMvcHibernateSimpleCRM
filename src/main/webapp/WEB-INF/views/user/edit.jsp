<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Chỉnh sửa thông tin thành viên</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href='<spring:url value="/resources/css/bootstrap.min.css"/>'>
<link rel="stylesheet"
	href='<spring:url value="/resources/css/style.css"/>'>
</head>

<body>

	<div class="d-flex justify-content-between">
		<!-- SIDE BAR -->
		<div id="side-bar">
			<div class="logo">ADMIN PAGE</div>
			<ul class="list-group rounded-0">
				<li class="dashboard">DASHBOARD</li>
				<li>
					<a href="user-list.html">
						<i class="fa fa-user mr-2"></i>
						Quản lý thành viên
					</a>
				</li>
				<li>
					<a href="role-list.html">
						<i class="fa fa-book mr-2"></i>
						Quản lý quyền
					</a>
				</li>
				<li>
					<a href="#">
						<i class="fa fa-cogs mr-2"></i>
						Cấu hình hệ thống
					</a>
				</li>
				<li>
					<a href="#">
						<i class="fa fa-slack mr-2"></i>
						Thông tin khác
					</a>
				</li>
			</ul>
		</div>

		<div id="admin-wrapper">
			<!-- HEADER -->
			<nav class="navbar navbar-expand-sm navbar-light bg-light w-100">
				<a class="navbar-brand" href="#">
					<i class="fa fa-align-justify"></i>
				</a>
				<button class="navbar-toggler d-lg-none" type="button"
					data-toggle="collapse" data-target="#collapsibleNavId"
					aria-controls="collapsibleNavId" aria-expanded="false"
					aria-label="Toggle navigation"></button>
				<div class="collapse navbar-collapse" id="collapsibleNavId">
					<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="#" id="dropdownId"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false"> Cybersoft </a>
							<div class="dropdown-menu dropdown-menu-right"
								aria-labelledby="dropdownId">
								<a class="dropdown-item" href="">Thông tin cá nhân</a>
								<a class="dropdown-item" href="#">Cài đặt</a>
								<a class="dropdown-item" href="#">Thoát</a>
							</div>
						</li>
					</ul>
				</div>
			</nav>

			<!-- CONTENT -->
			<section id="admin-content" class="p-3">
				<h3 class="mb-4">Chỉnh sửa thông tin thành viên</h3>
				<p>${ message }</p>
				<form method="post" action="<%=request.getContextPath()%>/user/edit">
					<div class="row">
						<div class="col-md-6">

							<div class="form-group">
								<label>Id</label>
								<input type="text" name="id" value="${ dto.id }" readonly
									class="form-control" placeholder="id" />
							</div>
							<div class="form-group">
								<label>Email</label>
								<input type="text" name="email" value="${ dto.email }"
									class="form-control" placeholder="email" />
							</div>
							<div class="form-group">
								<label>Mật khẩu</label>
								<input type="password" name="password" class="form-control"
									placeholder="password" />
							</div>
							<div class="form-group">
								<label>Họ tên</label>
								<input type="text" name="fullname" value="${ dto.fullname }"
									class="form-control" placeholder="fullname" />
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label>Chức vụ</label>
								<select class="form-control" name="roleId">
									<c:forEach items="${ roleDtos }" var="item">
										<option value="${ item.id }"
											${ dto.roleId == item.id?'selected':'' }>${ item.description }</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label>Avatar</label>
								<input type="text" name="avatar" value="${ dto.avatar }"
									class="form-control" placeholder="avatar" />
							</div>
						</div>
						<div class="col-12 mt-3">
							<button type="submit" class="btn btn-success">Lưu lại</button>
							<a class="btn btn-secondary"
								href="<%=request.getContextPath()%>/user">Quay lại</a>
						</div>
					</div>
				</form>
			</section>
		</div>
	</div>
	<script src="<spring:url value="/resources/js/jquery.slim.min.js"/>"></script>
	<script src="<spring:url value="/resources/js/popper.min.js"/>"></script>
	<script src="<spring:url value="/resources/js/bootstrap.min.js"/>"></script>
</body>

</html>