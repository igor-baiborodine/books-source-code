<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<portlet:actionURL var="addBookActionUrl">
	<portlet:param name="myaction" value="addBook" />
</portlet:actionURL>
<portlet:renderURL var="homeUrl">
</portlet:renderURL>

<form name="addBookForm" method="post"
	action="${addBookActionUrl}">
	<table>
		<tr align="left">
			<a href="${homeUrl}">Home</a>
		</tr>
	</table>
	<table>
		<tr>
			<td>Name:<font style="color: #C11B17;">*</font></td>
			<td><input type="text" name="name" value='<c:out value="${requestScope.book.name}"/>'/></td>
			<td><font style="color: #C11B17;"><c:out value="${requestScope.errors.name}"/></font></td>
		</tr>
		<tr>
			<td>Author:<font style="color: #C11B17;">*</font></td>
			<td><input type="text" name="author" value='<c:out value="${requestScope.book.author}"/>'/></td>
			<td><font style="color: #C11B17;"><c:out value="${requestScope.errors.author}"/></font></td>
		</tr>
		<tr>
			<td>ISBN:<font style="color: #C11B17;">*</font></td>
			<td><input type="text" name="isbnNumber" value='<c:out value="${requestScope.book.isbnNumber}"/>'/></td>
			<td><font style="color: #C11B17;"><c:out value="${requestScope.errors.isbnNumber}"/></font></td>
		</tr>
	</table>
	<table align="right">
		<tr>
			<td><input type="submit" value="Add Book" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
</form>
<br></br><br></br><br></br><br></br>