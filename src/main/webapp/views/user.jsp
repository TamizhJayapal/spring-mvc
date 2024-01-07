<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add User</title>
</head>
<body>
	<form:form method="post" modelAttribute="user">

		    <form:input type="hidden" path="id" />
				<form:input type="text" path="name" placeholder="Name" />
					<form:errors path="name" cssClass="text-warning" />

				<form:input type="text" path="email" placeholder="Email" />
					<form:errors path="email" cssClass="text-warning" />
		

				<form:input type="text" path="country" placeholder="Country" />
					<form:errors path="country" cssClass="text-warning" />
		
			<input type="submit" value="submit" />
	</form:form>
</body>
</html>