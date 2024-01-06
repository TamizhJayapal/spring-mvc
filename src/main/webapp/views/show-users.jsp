<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>List your user</h1>


<table class="table table-borderd">
			<thead>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Country</th>
				<th>Actions</th>
			</thead>
			<tbody>
				<c:forEach var="x" items="${users}">

					<tr>
						<td><c:out value="${x.id}" /></td>
						<td><c:out value="${x.name}" /></td>
						<td><c:out value="${x.email}" /></td>
						<td><c:out value="${x.country}" /></td>
						<td><a href="/edit-user?id=<c:out value='${x.id}' />">Edit</a>&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="/delete-user?id=<c:out value='${x.id}'/>">Delete</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<a href="/add-user">
			<button>Add User</button>
		</a>
		
</body>
</html>