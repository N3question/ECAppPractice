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
	<main>
		<div class="container">
			<h2 class="mt-5">ユーザ新規作成</h2>
			<form action="admin_create_user" method="post">
				<table>
					<tr>
						<td><label>名前</label></td>
						<td><input type="text" name="user_name"></td>
					</tr>
					<tr>
						<td><label>パスワード</label></td>
						<td><input type="text" name="password"></td>
					</tr>
					<tr>
						<td><label>郵便番号</label></td>
						<td>
							<input type="text" name="postal_code" pattern="\d{3}-?\d{4}">
						</td>
					</tr>
					<tr>
						<td><label>住所</label></td>
						<td><input type="text" name="address"></td>
					</tr>
				</table>
				<input type="submit" value="submit" class="btn btn-success">
			</form>
			<a href="admin_index">back</a>
		</div>
	</main>
</body>
</html>