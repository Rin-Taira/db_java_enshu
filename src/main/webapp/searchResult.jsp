<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>
<body>
  <h1>検索結果</h1>
  <p>データを取得しました。</p>
    product_id: <c:out value="${product.productId}" /><br>
    product_name: <c:out value="${product.productName}" /><br>
    price: <c:out value="${product.price}" /><br>
  <a href="top.jsp">戻る</a>
</body>
</html>
