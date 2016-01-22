<%@include file="include.jsp"%>

<fmt:setLocale value="<%=request.getLocale()%>" />
<fmt:setBundle basename="content.Language-ext" />

<c:if test="${not empty books}">
	<table border="1">
		<tr bgcolor="#99CCFF">
			<td valign="top"><b><fmt:message key="label.name" /></b></td>
			<td valign="top"><b><fmt:message key="label.author" /></b></td>
			<td valign="top"><b><fmt:message key="label.isbnNumber" /></b></td>
			<td valign="top"><b><fmt:message key="label.toc" /></b></td>
			<td valign="top"><b><fmt:message key="label.action" /></b></td>
		</tr>
		<c:forEach var="book" items="${books}">
			<portlet:resourceURL var="uploadToCFormUrl" id="uploadToCForm">
				<portlet:param name="isbnNumber" value="${book.isbnNumber}" />
			</portlet:resourceURL>
			<portlet:resourceURL var="removeBookUrl" id="removeBook">
				<portlet:param name="isbnNumber" value="${book.isbnNumber}" />
			</portlet:resourceURL>
					
			<td valign="top"><c:out value="${book.name}" /></td>
			<td valign="top"><c:out value="${book.author}" /></td>
			<td valign="top"><c:out value="${book.isbnNumber}" /></td>
			<td valign="top"><a 
				href='
				<portlet:resourceURL id="downloadToC">
					<portlet:param name="fileName" value="${book.isbnNumber}${book.tocFileExtension}" />
				</portlet:resourceURL>
			'>
			<b><fmt:message
				key="label.download" /></b></a>/<a href='#' onclick="<portlet:namespace/>showUploadToCForm('${uploadToCFormUrl}');"><b><fmt:message
				key="label.upload" /></b></a></td>
			<td align="center" valign="top" width="100px"><a 
				href='#'
				onclick="<portlet:namespace/>removeBook('${removeBookUrl}');"><b><fmt:message
				key="label.remove" /></b></a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<br/>
<table align="right">
	<tr>
		<td><b><a href="#" onclick="<portlet:namespace/>showAddBookTab();">Add Book</a></b></td>
	</tr>
</table>