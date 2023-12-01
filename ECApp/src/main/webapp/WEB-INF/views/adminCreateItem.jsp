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
			<h2 class="mt-5">商品新規作成</h2>
			<form action="admin_create_item" method="post"
				enctype="multipart/form-data">
				<table>
					<!-- <tr>
						<td><label>商品名</label></td>
						<td><input type="text" name="item_name"></td>
					</tr> -->
					<tr>
						<td><label>画像</label></td>
						<td><input type="file" name="image"></td>
					</tr>
					<!-- <tr>
						<td><label>値段</label></td>
						<td>
							<input type="number" name="price">
						</td>
					</tr> -->
					<!-- <tr>
						<td><label>カテゴリー</label></td>
						<td>
							<select name="category">
								<option value="1">カテゴリー１</option>
								<option value="2">カテゴリー２</option>
								<option value="3">カテゴリー３</option>
							</select>
						</td>
					</tr> -->
					<!-- <input type="hidden" name="sales_status" value="true"> -->
				</table>
				<input type="submit" value="submit" class="btn btn-success">
			</form>
			<a href="admin_index">back</a>
		</div>
	</main>
</body>
</html>