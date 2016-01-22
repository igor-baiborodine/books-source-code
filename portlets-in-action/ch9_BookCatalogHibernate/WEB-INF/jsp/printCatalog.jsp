<%@include file="include.jsp"%>

<portlet:defineObjects/>

<c:if test="${not empty books}">
	<table border="1">
		<tr bgcolor="#99CCFF">
			<td valign="top"><b>Name</b></td>
			<td valign="top"><b>Author</b></td>
			<td valign="top"><b>ISBN Number</b></td>
		</tr>
		<c:forEach var="book" items="${books}">
			<tr>
				<td valign="top"><c:out value="${book.name}" /></td>
				<td valign="top"><c:out value="${book.author}" /></td>
				<td valign="top"><c:out value="${book.isbnNumber}" /></td>
		</c:forEach>
	</table>
</c:if> <br></br>
<br></br>
<br></br>