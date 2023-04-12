<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
//セッションスコープに保存されたユーザ情報を取得
//User loginUser = (User) session.getAttribute("loginUser");
//アプリケーションスコープに保存されたつぶやきリストを取得
//List<TextData>textdataList=(List<TextData>)request.getAttribute("textdataList");
//リクエストスコープに保存されたエラーメッセージを取得
//String errorMsg = (String) request.getAttribute("errorMsg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Draft Notes public</title>
<link rel="stylesheet" href="css/main.css">
<link
	href="https://fonts.googleapis.com/css2?family=Alkatra&display=swap"
	rel="stylesheet">
</head>
<body>
	<h1>Draft Notes public </h1>
	<p>
		<c:out value="${loginUser.name}" />

	</p>

	<ul class="inline">
		<li><a href="/DraftNotes/Logout"><div class="button">ログアウト</div></a></li>
		<li><a href="/DraftNotes/Main"><div class="button">更新</div></a></li>

	</ul>


	<form action="/DraftNotes/Main" method="post">

		<textarea name="text"></textarea>



		<br>
		<label class="selectbox-003"> <select name="example">
				<option value="指定なし">指定なし</option>
				<option value="科目A">科目A</option>
				<option value="科目B">科目B</option>
				<option value="科目C">科目C</option>
				<option value="科目D">科目D</option>
				<option value="科目E">科目E</option>
		</select>
		</label> 
		<input type="submit" value="投稿する" class="button">
	</form>
	<div class="timeline">
		<c:if test="${not empty errorMsg}">
			<p>${errorMsg}</p>
		</c:if>

		<c:forEach var="textdata" items="${textdataList}">
			<p>
				<c:out value="${textdata.userName}" />
				：
				<c:out value="${textdata.text}" />
			</p>
		</c:forEach>
	</div>

</body>
<jsp:include page="/footer.jsp" />
</html>