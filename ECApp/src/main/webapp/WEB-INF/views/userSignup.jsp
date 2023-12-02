<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.ItemBeans, java.util.ArrayList, java.text.NumberFormat, bean.AdminBeans"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
	<header style="border-bottom: 1px lightgray solid;">
		<% AdminBeans adminInfo = (AdminBeans) session.getAttribute("adminBeans"); %>
		<nav class="p-3 d-flex justify-content-between">
			<ul class="d-flex mb-0 p-0">
				<li class="mx-2" style="list-style: none;">
					<a href="index" class="btn btn-sm btn-outline-dark">Index</a>
				</li>
				<% if(adminInfo == null) { %>
				<li class="mx-2" style="list-style: none;">
					<a href="admin_login" class="btn btn-sm btn-outline-dark">Admin Login</a>
				</li>
				<li class="mx-2" style="list-style: none;">
					<a href="user_login" class="btn btn-sm btn-outline-dark">User Login</a>
				</li>
				<li class="mx-2" style="list-style: none;">
					<a href="user_signup" class="btn btn-sm btn-outline-dark">Create User</a>
				</li>
				<% } %>
			</ul>
			<ul class="d-flex mb-0 p-0">
				<% if(adminInfo != null) { %>
				<li class="mx-2 small" style="list-style: none; height:30px; line-height:30px;"><%= adminInfo.getAdminName() %> is currently logged in.</li>
				<li class="mx-2" style="list-style: none;">
					<a href="cart" class="btn btn-sm btn-outline-dark">Cart</a>
				</li>
				<li class="mx-2" style="list-style: none;">
					<a href="#" class="btn btn-sm btn-outline-danger">Logout</a>
				</li>
				<% } %>
			</ul>
		</nav>
	</header>
	<main>
		<div class="container">
			<h4 class="mt-5">Create User</h4>
			<form action="user_signup" method="post">
				<table class="table table-borderless" style="width: 400px;">
					<tr>
						<td><label>名前</label></td>
						<td><input type="text" name="user_name" class="form-control"></td>
					</tr>
					<tr>
						<td><label>パスワード</label></td>
						<td><input type="text" name="password" class="form-control"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="submit" class="btn btn-success w-100">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</main>
</body>
</html>