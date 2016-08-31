<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p><strong>${formData.name}님</strong>회원 가입을 완료했습니다.</p>
<p><a href="<c:url value='/main'/>">[첫 화면 이동]</a></p>
</body>
</html>