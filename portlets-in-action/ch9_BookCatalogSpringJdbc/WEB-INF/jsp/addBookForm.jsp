<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html" isELIgnored="false"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>

<div class="bookCatalogPortlet_ch6">
<form name="<portlet:namespace/>addBookForm" method="post" action='<portlet:actionURL name="addBookAction"/>' enctype="application/x-www-form-urlencoded">
<table>
	<tr>
		<td><a class="anchor" href='<portlet:renderURL portletMode="view"/>'><b>HOME</b></a></td>
	</tr>
	<tr>
		<td><font style="color: #C11B17;"><c:out
			value="${requestScope.errors.global}" /></font></td>
	</tr>
</table>
<table>
	<tr>
		<td><b>Name:</b><font style="color: #C11B17;">*</font></td>
		<td><input type="text" name="<portlet:namespace/>name"
			value='<c:out value="${requestScope.book.name}"/>' /></td>
		<td><font style="color: #C11B17;"><c:out
			value="${requestScope.errors.name}" /></font></td>
	</tr>
	<tr>
		<td><b>Author:</b><font style="color: #C11B17;">*</font></td>
		<td><input type="text" name="<portlet:namespace/>author"
			value='<c:out value="${requestScope.book.author}"/>' /></td>
		<td><font style="color: #C11B17;"><c:out
			value="${requestScope.errors.author}" /></font></td>
	</tr>
	<tr>
		<td><b>ISBN:</b><font style="color: #C11B17;">*</font></td>
		<td><input type="text" name="<portlet:namespace/>isbnNumber"
			value='<c:out value="${requestScope.book.isbnNumber}"/>' /></td>
		<td><font style="color: #C11B17;"><c:out
			value="${requestScope.errors.isbnNumber}" /></font></td>
	</tr>
	<tr align="center">
		<td colspan="2"><input type="submit" value="Add Book" /></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
</table>
<table align="right">
	<tr>
		<td><b>Powered by:</b> <i>${portalInfo}</i></td>
	</tr>
</table>
</form>
</div>
<br></br>
<br></br>