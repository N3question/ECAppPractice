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
			<h2 class="mt-5">管理者ログイン</h2>
			<form action="admin_login" method="post">
				<table>
					<tr>
						<td><label>名前</label></td>
						<td><input type="text" name="admin_name"></td>
					</tr>
					<tr>
						<td><label>パスワード</label></td>
						<td><input type="text" name="admin_password"></td>
					</tr>
				</table>
				<input type="submit" value="submit" class="btn btn-info">
			</form>
			<a href="index">back</a>
		</div>
	</main>
</body>
</html>