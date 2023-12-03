<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.ItemBeans, java.util.ArrayList, java.text.NumberFormat, bean.PublicUserBeans, java.util.Map, java.util.HashMap"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
	<% PublicUserBeans sessionUserInfo = (PublicUserBeans) session.getAttribute("PUBeans"); %>
	<header style="border-bottom: 1px lightgray solid;">
		<nav class="p-3 d-flex justify-content-between">
			<ul class="d-flex mb-0 p-0">
				<li class="mx-2" style="list-style: none;">
					<a href="index" class="btn btn-sm btn-outline-dark">Index</a>
				</li>
				<% if(sessionUserInfo != null) { %>
				<li class="mx-2" style="list-style: none;">
					<a href="#" class="btn btn-sm btn-outline-dark">My page</a>
				</li>
				<% } %>
				<% if (sessionUserInfo == null) { %>
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
			<% if(sessionUserInfo != null) { %>
				<ul class="d-flex mb-0 p-0">
					<li class="mx-2 small" style="list-style: none; height:30px; line-height:30px;"><%= sessionUserInfo.getUserName() %> is currently logged in.</li>
					<% ArrayList<HashMap<Integer, Integer>> cartList = (ArrayList<HashMap<Integer, Integer>>) session.getAttribute("cartList"); %>
					<li class="mx-2" style="list-style: none;">
						<a href="cart">
						<button type="button" class="btn btn-sm btn-outline-dark position-relative">
							Cart 
							<% if (cartList != null && cartList.size() > 99) { %>
								<span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
										99+ <span class="visually-hidden">unread messages</span>
								</span>
							<% } else if(cartList != null && cartList.size() > 0) { %>
								<span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
									<%= cartList.size() %> <span class="visually-hidden">unread messages</span>
								</span>
							<% } %>
						</button>
				</a>
					</li>
					<li class="mx-2" style="list-style: none;">
						<a href="user_logout" class="btn btn-sm btn-outline-danger">Logout</a>
					</li>
				</ul>
			<% } %>
		</nav>
	</header>
	<main>
		<div class="container my-4">
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
						<% if(sessionUserInfo != null) { %>
							<form action="index" method="post">
								<input type="hidden" name="item_id" value="<%= beans.getItemId() %>">
								<input type="hidden" name="user_id" value="<%= sessionUserInfo.getUserId() %>">
								<select name="quantity" class="form-control mb-3">
									<option hidden>0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
								</select> 
								<input type="submit" class="btn btn-primary w-100" value="Add to cart">
							</form>
						<% } %>
					</div>
				</div>
				<% } %>
			</div>
		</div>
	</main>
</body>
</html>