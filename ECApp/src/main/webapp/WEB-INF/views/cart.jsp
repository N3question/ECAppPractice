<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.CartBeans, bean.ItemBeans, java.util.ArrayList, java.text.NumberFormat, bean.PublicUserBeans"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
	<main>
		<div class="container">
			<h4 class="mt-5">Your Cart</h4>
			<div class="d-flex">
			<% 
			ArrayList<CartBeans> cartList = (ArrayList<CartBeans>) session.getAttribute("cartList");
			PublicUserBeans sessionUserInfo = (PublicUserBeans) session.getAttribute("PUBeans");
			int loginUserId = sessionUserInfo.getUserId();
			%>
			<% if (cartList != null) { %>
				<% for (CartBeans beans : cartList) { %>
					<% if (loginUserId == beans.getUserId()) { %>
						<div class="card" style="width: 120px;">
							<img src="..." class="card-img-top" alt="...">
							<div class="card-body">
								<h5 class="card-title">Card Title</h5>
								<p>item id : <%= beans.getItemId() %></p>
								<p>user id : <%= beans.getUserId() %></p>
								<p>quantity : <%= beans.getQuantity() %></p>
							</div>
							<form action="map_remove" method="post">
								<% for (int i = 0; i < cartList.size(); i++) { %>
									<input type="hidden" name="index_num" value="<%= i %>">
								<% } %>
								<button type="submit" class="btn-close btn-sm border" aria-label="Close"></button>
							</form>
						</div>
					<% } %>
				<% } %>
			<% } %>
			</div>
			<%-- <form action="cart" method="post">
			    <!-- TODO サーブレットにsessionから値を取得する記述をかく -->
				<% 
				HttpSession session = request.getSession();
				PublicUserBeans sessionUserInfo = (PublicUserBeans) session.getAttribute("PUBeans"); 
				%>
				<input type="hidden" name="user_id" value="<%= sessionUserInfo.getUserId() %>"> 
				<input type="hidden" name="order_status_id" value="1">
				<input type="hidden" name="read_flag" value="false"> 
				<input type="submit" class="btn btn-success" value="Purchase">
			</form> --%>
		<a href="index">Back</a>
		</div>
	</main>
</body>
</html>