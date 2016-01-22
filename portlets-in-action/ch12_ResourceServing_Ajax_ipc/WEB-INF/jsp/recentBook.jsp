<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html" isELIgnored="false"
	import="javax.portlet.*,chapter12.code.listing.utils.Constants, chapter12.code.listing.domain.*"%>

<table border="1">
	<tr>
		<td bgcolor="#99CCFF"><b>Book Category</b></td>
		<td><c:out value="${book.category}" /></td>
	</tr>
	<tr>
		<td bgcolor="#99CCFF"><b>Book name: </b></td>
		<td><c:out value="${book.name}" /></td>
	</tr>
	<tr>
		<td bgcolor="#99CCFF"><b>Book author: </b></td>
		<td><c:out value="${book.author}" /></td>
	</tr>
	<tr>
		<td bgcolor="#99CCFF"><b>Book ISBN</b></td>
		<td><c:out value="${book.isbnNumber}" /></td>
	</tr>
</table>