<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html" isELIgnored="false"%>

<form id="<portlet:namespace/>uploadToCFormId"
	name="<portlet:namespace/>uploadTocForm" method="post">

<table>
	<tr>
		<td><b>TOC:</b><font style="color: #C11B17;"></font></td>
		<td colspan="2"><input id="<portlet:namespace/>tocFileId"
			type="file" name="<portlet:namespace/>tocFile" onchange="<portlet:namespace/>uploadToCFile('<portlet:namespace/>tocFileId', <%= request.getAttribute("isbnNumber")%>);"/></td>
		<td valign="top"><img id="<portlet:namespace/>imageId"
			src="<%= request.getContextPath() %>/images/loading.gif"
			style="visibility: hidden" /></td>
	</tr>
	<tr>
		<td colspan="3">&nbsp;</td>
	</tr>
	<tr align="right">
		<td colspan="3" align="right"><b><a href='#' onclick="<portlet:namespace/>getBooks();">Let's Go
		Home</a></b></td>
	</tr>
</table>
</form>