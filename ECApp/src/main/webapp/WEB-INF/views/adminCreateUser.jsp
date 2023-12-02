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
		<nav class="p-3 d-flex justify-content-between">
			<ul class="d-flex mb-0 p-0">
				<li class="mx-2" style="list-style: none;">
					<a href="admin_create_item" class="btn btn-sm btn-outline-dark">Create Item</a>
				</li>
				<li class="mx-2" style="list-style: none;">
					<a href="admin_create_user" class="btn btn-sm btn-outline-dark">Create User</a>
				</li>
				<li class="mx-2" style="list-style: none;">
					<a href="admin_index" class="btn btn-sm btn-outline-dark">Item index</a>
				</li>
				<li class="mx-2" style="list-style: none;">
					<a href="#" class="btn btn-sm btn-outline-dark">User index</a>
				</li>
				<li class="mx-2" style="list-style: none;">
					<a href="#" class="btn btn-sm btn-outline-dark">User Deletion List</a>
				</li>
				<li class="mx-2" style="list-style: none;">
					<a href="#" class="btn btn-sm btn-outline-dark">Item Deletion List</a>
				</li>
				<li class="mx-2" style="list-style: none;">
					<button type="button" class="btn btn-sm btn-outline-dark position-relative">
						Notice
						<span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
							99+ 
							<span class="visually-hidden">unread messages</span>
						</span>
					</button>
				</li>
			</ul>
			<ul class="d-flex mb-0 p-0">
				<% AdminBeans adminInfo = (AdminBeans) session.getAttribute("adminBeans"); %>
				<li class="mx-2 small" style="list-style: none; height:30px; line-height:30px;"><%= adminInfo.getAdminName() %> is currently logged in.</li>
				<li class="mx-2" style="list-style: none;">
					<a href="admin_logout" class="btn btn-sm btn-outline-danger">Logout</a>
				</li>
			</ul>
		</nav>
	</header>
	<main>
		<div class="container">
			<h2 class="mt-5">Create User</h2>
			<form action="admin_create_user" method="post">
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
						<td><label>郵便番号</label></td>
						<td>
							<input type="text" name="postal_code" pattern="\d{3}-?\d{4}" class="form-control">
						</td>
					</tr>
					<tr>
						<td><label>住所</label></td>
						<td><input type="text" name="address" class="form-control"></td>
					</tr>
				</table>
				<input type="submit" value="submit" class="btn btn-success">
			</form>
			<a href="admin_index">back</a>
		</div>
	</main>
</body>
</html>