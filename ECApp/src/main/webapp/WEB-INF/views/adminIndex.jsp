<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.ItemBeans, java.util.ArrayList, java.text.NumberFormat, bean.AdminBeans"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
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
		<div class="container my-4">
			<!-- <h2 class="mt-5">Item index (admin)</h2> -->
			<%
			ArrayList<ItemBeans> itemBeans = (ArrayList<ItemBeans>)request.getAttribute("itemBeans");
			%>
			<div class="d-flex justify-content-between flex-wrap">
				<% for (ItemBeans beans : itemBeans) { %>
				<div class="card mb-1" style="width: 220px;">
					<img src="./image/<%= beans.getFileName() %>" class="card-img-top"
						alt="none" style="height: 150px; object-fit: cover;">
					<div class="card-body">
						<h5 class="card-title"><%= beans.getItemName() %></h5>
						<% NumberFormat comFormat = NumberFormat.getNumberInstance(); %>
						<p class="card-text">￥ <%= comFormat.format(beans.getPrice()) %></p>
						<p class="card-text"><%= beans.getCategoryName() %></p>
						<% String status = beans.isSalesStatus()? "Now on sale" : "Sales are suspended"; %>
						<% if (status.equals("Now on sale")) { %>
						<p class="card-text" style="color:limegreen;"><%= status %></p>
						<% } else { %>
						<p class="card-text" style="color:gray;"><%= status %></p>
						<% } %>
						<a href="#" class="btn btn-primary w-100" style="border-radius: 40px;">Edit</a>
					</div>
				</div>
				<% } %>
			</div>
		</div>
	</main>
</body>
</html>