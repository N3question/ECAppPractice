<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="m-3">
			<ul class="d-flex">
				<li class="mx-2" style="list-style: none;">
					<a href="admin_create_item">商品新規作成</a>
				</li>
				<li class="mx-2" style="list-style: none;">
					<a href="admin_create_user">ユーザ新規作成</a>
				</li>
				<li class="mx-2" style="list-style: none;">
					<a href="#">通知一覧(件数表示)</a>
				</li>
				<li class="mx-2" style="list-style: none;">
					<a href="#">ユーザ削除一覧</a>
				</li>
				<li class="mx-2" style="list-style: none;">
					<a href="#">商品削除一覧</a>
				</li>
				<li class="mx-2" style="list-style: none;">' 'がログイン中</li>
				<li class="mx-2" style="list-style: none;">
					<a href="admin_logout">ログアウト</a>
				</li>
			</ul>
		</nav>
	</header>
	<main>
		<div class="container">
			<h2 class="mt-5">Admin index</h2>
			<%
				String filename = (String)request.getAttribute("filename");
			%>
			<% if (filename != null) { %>
			<h2>Uploaded File Paths</h2>
			<p>
				Image Path:<br>
				<img src="./image/<%= filename %>">
			</p>
			<% } %>
		</div>
	</main>
</body>
</html>