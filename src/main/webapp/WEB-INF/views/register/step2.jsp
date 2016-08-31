<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원 정보 입력</h2>
<form action="step3" method="post">
<p>
	<label>이메일:<br>
	<input type="text" name="email" id="email" value="${registerRequest.email}">
	</label>
</p>
<p>
	<label>이름:<br>
	<input type="text" name="name" id="name" value="${registerRequest.name}">
	</label>
</p>
<p>
	<label>비밀번호:<br>
	<input type="password" name="password" id="password">
	</label>
</p>
<p>
	<label>비밀번호 확인:<br>
	<input type="password" name="confirmPassword" id="confirmPassword">
	</label>
</p>
<input type="submit" value="가입 완료">
</form>
</body>
</html>