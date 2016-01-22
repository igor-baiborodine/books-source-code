<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html" isELIgnored="false"%>

<fmt:setLocale value="<%=request.getLocale()%>" />
<fmt:setBundle basename="content.Language-ext" />

<table align="right">
	<tr>
		<td><b><fmt:message key="label.hello" /></b></td>
		<td>&nbsp; &nbsp; <i><b><c:out
			value="${requestScope.firstName}" /></b></i></td>
		<td>&nbsp; <i><b><c:out value="${requestScope.lastName}" /></b></i></td>
	</tr>
</table>
<br/>
<table align="left">
	<tr>
		<td><a class="anchor" href="${printModeUrl}"><b>&nbsp;<fmt:message
			key="label.print" />&nbsp;</b></td>
		<td><a class="anchor" href="${helpUrl}"><b>&nbsp;<fmt:message
			key="label.help" />&nbsp;</b></td>
		<td><a class="anchor" href="${prefUrl}"><b>&nbsp;<fmt:message
			key="label.preferences" />&nbsp;</b></td>
		<td><b><a class="anchor" href="${resetActionUrl}">
			<c:if test="${myaction eq 'showSearchResults'}">
			    <fmt:message key="label.reset" />
		    </c:if></a>
		</b></td>
	</tr>
</table>
<br/>
<table align="right">
	<tr>
		<td><a class="anchor" href="${fullScreenUrl}"><b><fmt:message
			key="label.fullScreen" /></b></td>
	</tr>
</table>
<form name="searchForm" method="post" action="${searchBookActionUrl}">
<br/>
<table border="0" align="left">
	<tr>
		<td><b><fmt:message key="label.book.name" /></b></td>
		<td><input type="text" name="bookNameSearchField" value="" /></td>
	</tr>
	<tr>
		<td><b><fmt:message key="label.author.name" /></b></td>
		<td><input type="text" name="authorNameSearchField" value="" /></td>
	</tr>
	<tr align="center">
		<td colspan="2"><input type="submit"
			value="<fmt:message key="label.search.button"/>"></td>
	</tr>
</table>
</form>
<form name="catalogForm" method="post" action="${addBookFormUrl}">
<br/>
<table align="right">
	<tr>
		<td><a class="anchor" href="${refreshResultsUrl}"><b>&lt; <fmt:message
			key="label.refresh.search.result" /> &gt;</b></a></td>
	</tr>
</table>
<c:if test="${not empty books}">
	<table border="1" width="100%">
		<tr bgcolor="#99CCFF">
			<td valign="top"><b><fmt:message key="label.name" /></b></td>
			<td valign="top"><b><fmt:message key="label.author" /></b></td>
			<td valign="top"><b><fmt:message key="label.isbnNumber" /></b></td>
			<td valign="top"><b><fmt:message key="label.e-book" /></b></td>
			<td valign="top"><b><fmt:message key="label.action" /></b></td>
		</tr>
		<c:forEach var="book" items="${books}">
			<tr>
				<td valign="top"><c:out value="${book.name}" /></td>
				<td valign="top"><c:out value="${book.author}" /></td>
				<td valign="top"><c:out value="${book.isbnNumber}" /></td>
				<td valign="top"><a class="anchor" href="${book.downloadUrl}"><b>&nbsp;&nbsp;<fmt:message
					key="label.download" /></a>/<a class="anchor"
					href="
				<portlet:renderURL>
					<portlet:param name="myaction" value="uploadTocForm" />
					<portlet:param name="isbnNumber" value="${book.isbnNumber}" />
				</portlet:renderURL>
				"><fmt:message
					key="label.upload" /></a>&nbsp;&nbsp;</b></td>
				<td align="center" valign="top" width="100px"><a class="anchor"
					href="
						<portlet:actionURL>
							<portlet:param name="javax.portlet.action" value="removeBookAction" />
							<portlet:param name="isbnNumber" value="${book.isbnNumber}" />
						</portlet:actionURL>					
					"
					onclick="javascript: return confirmRemove()"><b><fmt:message
					key="label.remove" /></b></a></td>
			</tr>
		</c:forEach>
	</table>
</c:if> <br></br>
<table align="right">
	<tr>
		<td><input type="submit"
			value="<fmt:message key="label.add.book"/>" /></td>
	</tr>
</table>
<table align="right">
	<tr>
		<td><b><fmt:message key="label.powered.by" />:</b> <i>${portalInfo}</i></td>
	</tr>
</table>
</form>
<br></br>
<br></br>