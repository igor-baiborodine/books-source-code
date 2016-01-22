<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<portlet:renderURL var="showAddBookUrl">
	<portlet:param name="myaction" value="addBookForm" />
</portlet:renderURL>
<portlet:renderURL var="showUrl">
</portlet:renderURL>
<form:form name="catalogForm" method="post" action="${showAddBookUrl}">
	<c:if test="${not empty books}">
		<table border="1">
			<tr bgcolor="#99CCFF">
				<td valign="top"><b>Title</b></td>
				<td valign="top"><b>Author</b></td>
				<td valign="top"><b>ISBN Number</b></td>
				<td valign="top"><b>ACTION</b></td>
			</tr>
			<c:forEach var="book" items="${books}">
				<tr>
					<td valign="top"><c:out value="${book.name}" /></td>
					<td valign="top"><c:out value="${book.author}" /></td>
					<td valign="top"><c:out value="${book.isbnNumber}" /></td>
					<td align="center" valign="top" width="100px"><a
						href="
						<portlet:renderURL>
							<portlet:param name="myaction" value="editBookForm" />
							<portlet:param name="isbnNumber" value="${book.isbnNumber}" />
						</portlet:renderURL>					
					"><b>Edit</b></a>
					/
					<a href="
						<portlet:actionURL>
							<portlet:param name="myaction" value="removeBook" />
							<portlet:param name="isbnNumber" value="${book.isbnNumber}" />
						</portlet:actionURL>					
					" onclick="javascript: return confirmRemove()"><b>Remove</b></a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br></br>
	<table align="right">
		<tr>
			<td><input type="submit" value="Add Book" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
</form:form>
<br></br>