<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:if test="${result > 0}">
	<script type="text/javascript">
		alert("게시글이 삭제 되었습니다");
		location.href="list.do?pageNum=${pageNum}";
	</script>
</c:if>
<c:if test="${result == 0}">
	<script type="text/javascript">
		alert("오류가 발생했습니다 다시 확인해주세요");
		history.back();
	</script>
</c:if>
<c:if test="${result < 0}">
	<script type="text/javascript">
		alert("암호가 다릅니다.");
		history.go(-1);
	</script>
</c:if>

</body>
</html>