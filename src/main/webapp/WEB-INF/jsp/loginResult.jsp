<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.User"%>

<%
//セッションスコープから情報を取得
User loginUser = (User) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Sawarabi+Gothic&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="css/loginResult.css">
<meta charset="UTF-8">
<title>Draft Notes</title>
</head>
<body>
	<div class="main">
		<h1>ログイン認証</h1>
		<%
		if (1==1) {
		%>
		<p>認証に成功しました</p>

		<a href="/DraftNotes/Main"><div class="button">投稿・一覧へ</div></a>

		<%
		} 
		%>
		
	</div>
</body>
</html>