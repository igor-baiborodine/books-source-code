<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<portlet:actionURL var="addBookActionUrl">
	<portlet:param name="myaction" value="addBook" />
</portlet:actionURL>
<portlet:renderURL var="homeUrl">
	<portlet:param name="myaction" value="books" />
</portlet:renderURL>

<form:form name="addBookForm" commandName="book" method="post"
	action="${addBookActionUrl}">
	<table>
		<tr align="left">
			<a href="${homeUrl}">Home</a>
		</tr>
	</table>
	<table>
		<tr>
			<td>Title:<font style="color: #C11B17;">*</font></td>
			<td><form:input path="name" /></td>
			<td><font style="color: #C11B17;"><form:errors
				path="name" /></font></td>
		</tr>
		<tr>
			<td>Author:<font style="color: #C11B17;">*</font></td>
			<td><form:input path="author" /></td>
			<td><font style="color: #C11B17;"><form:errors
				path="author" /></font></td>
		</tr>
		<tr>
			<td>ISBN:<font style="color: #C11B17;">*</font></td>
			<td><form:input path="isbnNumber" /></td>
			<td><font style="color: #C11B17;"><form:errors
				path="isbnNumber" /></font></td>
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
</form:form>
<br></br>