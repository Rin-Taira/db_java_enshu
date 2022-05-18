<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
  <h1>検索条件を入力してください</h1>
  <c:if test="${not empty msg}">
    <p>${msg}</p>
  </c:if>
  <form action="search" method="post">
    product_id: <input type="text" name="id"><br>
    <button type="submit">検索</button>
  </form>
</body>
</html>
