<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html" isELIgnored="false"
	import="javax.portlet.*,chapter11.code.listing.utils.Constants"%>

<script type='text/javascript'>
  function <portlet:namespace/>confirmRemove() {
    return confirm("Do you want to save Book information?");
  }
</script>

<fmt:setLocale value="<%=request.getLocale()%>" />
<fmt:setBundle basename="content.Language-ext" />
<portlet:defineObjects />
<%
	PortletURL printModeUrl = renderResponse.createRenderURL();
	if (renderRequest.isPortletModeAllowed(new PortletMode("print"))) {
		printModeUrl.setPortletMode(new PortletMode("print"));
	}
	if (renderRequest.isWindowStateAllowed(new WindowState("pop_up"))) {
		printModeUrl.setWindowState(new WindowState("pop_up"));
	}
	PortletURL fullScreenUrl = renderResponse.createRenderURL();
	if(renderRequest.isWindowStateAllowed(WindowState.MAXIMIZED)) {
    	fullScreenUrl.setWindowState(WindowState.MAXIMIZED);
	}
	java.util.List prefIsbnList = java.util.Arrays.asList(portletPreferences.getValues("prefBookISBN", new String[] {"-99"}));
%>
<div class="bookCatalogPortlet_ch10">
<table align="right">
	<tr>
		<td><b>${portletPreferencesValues.greetingMessage[0]}</b></td>
		<td>&nbsp; &nbsp; <i><b><c:out
			value="${requestScope.firstName}" /></b></i></td>
		<td>&nbsp; <i><b><c:out value="${requestScope.lastName}" /></b></i></td>
	</tr>
</table>
<br/>
<table align="left">
	<tr>
		<td><a class="anchor" href="<%= printModeUrl%>"><b>&nbsp;<fmt:message
			key="label.print" />&nbsp;</b></td>
		<td><a class="anchor"
			href='<portlet:renderURL portletMode="help"/>'><b>&nbsp;<fmt:message
			key="label.help" />&nbsp;</b></td>
		<td><a class="anchor"
			href='<portlet:renderURL portletMode="edit"/>'><b>&nbsp;<fmt:message
			key="label.preferences" />&nbsp;</b></td>
		<td><b><a class="anchor"
			href='<portlet:actionURL name="resetAction"/>'> <c:if
			test="${myaction eq 'showSearchResults'}">
			<fmt:message key="label.reset" />
		</c:if></a> </b></td>
	</tr>
</table>
<br/>
<table align="right">
	<tr>
		<td><a class="anchor" href="<%=fullScreenUrl%>"><b><fmt:message
			key="label.fullScreen" /></b></td>
	</tr>
</table>
<form name="<portlet:namespace/>searchForm" method="post"
	action='<portlet:actionURL name="searchBookAction"/>'>
<br/>
<table border="0" align="left">
	<tr>
		<td><b><fmt:message key="label.book.name" /></b></td>
		<td><input type="text" name="<portlet:namespace/>bookNameSearchField" value="" /></td>
	</tr>
	<tr>
		<td><b><fmt:message key="label.author.name" /></b></td>
		<td><input type="text" name="<portlet:namespace/>authorNameSearchField" value="" /></td>
	</tr>
	<tr align="center">
		<td colspan="2"><input type="submit"
			value="<fmt:message key="label.search.button"/>"></td>
	</tr>
</table>
</form>
<form name="<portlet:namespace/>catalogForm" method="post"
	action='<portlet:renderURL>
          <portlet:param name="<%=Constants.MYACTION_PARAM%>" value="addBookForm"/> 
    </portlet:renderURL>' 
> 
<br/>
<table align="right">
	<tr>
		<td><a class="anchor" href='<portlet:renderURL>
          <portlet:param name="<%=Constants.MYACTION_PARAM%>" value="refreshResults"/> 
    </portlet:renderURL>'><b>&lt;
		<fmt:message key="label.refresh.search.result" /> &gt;</b></a></td>
	</tr>
</table>
<c:if test="${not empty books}">
	<table border="1" width="100%">
		<tr bgcolor="#99CCFF">
			<td valign="top"><b><fmt:message key="label.category" /></b></td>
			<td valign="top"><b><fmt:message key="label.name" /></b></td>
			<td valign="top"><b><fmt:message key="label.author" /></b></td>
			<td valign="top"><b><fmt:message key="label.isbnNumber" /></b></td>
			<td valign="top"><b><fmt:message key="label.toc" /></b></td>
			<td valign="top"><b><fmt:message key="label.action" /></b></td>
		</tr>
		<c:forEach var="book" items="${books}" end="${portletPreferencesValues.maxNumOfBooks[0]-1}">
		    <c:choose>
			    <c:when test="${book.preferredBook}">
			  		<tr style="background-color: yellow;">
			    </c:when>
			    <c:otherwise>
			    	<tr>
			    </c:otherwise>
		    </c:choose>
			<td valign="top" style="color: blue;"><b><i>
			<c:if test="${book.category eq \"java\"}">
				Java
			</c:if>
			<c:if test="${book.category eq \".net\"}">
				.NET
			</c:if>
			<c:if test="${book.category eq \"mobile\"}">
				Mobile Technology
			</c:if>
			<c:if test="${book.category eq \"softwareEng\"}">
				Software Engineering
			</c:if>
			</i></b></td>
			<td valign="top"><c:out value="${book.name}" /></td>
			<td valign="top"><c:out value="${book.author}" /></td>
			<td valign="top"><c:out value="${book.isbnNumber}" /></td>
			<td valign="top"><a class="anchor" href="#"
				onclick="window.alert('This feature is not implemented. Refer chapter 12 sample code');"><b>&nbsp;&nbsp;<fmt:message
				key="label.download" /></a>/<a class="anchor"
				href='
				<portlet:renderURL>
					<portlet:param name="<%=Constants.MYACTION_PARAM%>" value="uploadTocForm" />
					<portlet:param name="isbnNumber" value="${book.isbnNumber}" />
				</portlet:renderURL>
				'><fmt:message
				key="label.upload" /></a>&nbsp;&nbsp;</b></td>
			<td align="center" valign="top" width="100px"><a class="anchor"
				href='
						<portlet:actionURL name="removeBookAction">
							<portlet:param name="isbnNumber" value="${book.isbnNumber}" />
						</portlet:actionURL>					
					'
				onclick="javascript: return <portlet:namespace/>confirmRemove()"><b><fmt:message
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
</div>
<br></br>
<br></br>