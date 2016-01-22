<%@include file="include.jsp"%>

<form name="<portlet:namespace/>addBookForm" method="post">
<table>
	<tr>
		<td><b>Title:</b><font style="color: #C11B17;">*</font></td>
		<td><input type="text" id="<portlet:namespace/>titleId"
			value='<c:out value="${requestScope.book.name}"/>' /></td>
		<td><font style="color: #C11B17;"><div id="<portlet:namespace/>titleErrorId"></div></font></td>
	</tr>
	<tr>
		<td><b>Author:</b><font style="color: #C11B17;">*</font></td>
		<td><input type="text" id="<portlet:namespace/>authorId"
			value='<c:out value="${requestScope.book.author}"/>' /></td>
		<td><font style="color: #C11B17;"><span id="<portlet:namespace/>authorErrorId"/></font></td>
	</tr>
	<tr>
		<td><b>ISBN:</b><font style="color: #C11B17;">*</font></td>
		<td><input type="text" id="<portlet:namespace/>isbnNumberId"
			value='<c:out value="${requestScope.book.isbnNumber}"/>' /></td>
		<td><font style="color: #C11B17;"><span id="<portlet:namespace/>isbnNumberErrorId"/></font></td>
	</tr>
	<tr align="right">
		<td colspan="2"><a href="#" onclick="<portlet:namespace/>addBook('<portlet:namespace/>titleId', '<portlet:namespace/>authorId', 
			'<portlet:namespace/>isbnNumberId', '<portlet:namespace/>titleErrorId', '<portlet:namespace/>authorErrorId', '<portlet:namespace/>isbnNumberErrorId');"><b>Save</b></a>
			<img id="<portlet:namespace/>imageId"
			src="<%= request.getContextPath() %>/images/loading.gif"
			style="visibility: hidden" /></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
</table>
</form>
<br></br>
<br></br>