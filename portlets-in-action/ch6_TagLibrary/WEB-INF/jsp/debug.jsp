<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html" isELIgnored="false"
	import="javax.portlet.PortletSession"%>

<fmt:setLocale value="<%=request.getLocale()%>" />
<fmt:setBundle basename="content.Language-ext" />

<portlet:defineObjects />

<table align="right" width="100%">
	<tr>
		<td colspan="2">
		<hr noshade />
		</td>
	</tr>
	<tr>
		<td colspan="2"><b><fmt:message key="label.debug" />:</b></td>
	</tr>
	<tr>
		<td>Value of <b>myaction</b> request attribute:
		${requestScope.myaction}</td>
		<td>Portlet mode of request: <%=renderRequest.getPortletMode()%>
		</td>
	</tr>
	<tr>
		<td>Window state of request: <%=renderRequest.getWindowState()%>
		</td>
		<td>Content Expiration time: <%=renderResponse.getCacheControl()
									.getExpirationTime()%> seconds</td>
	</tr>
	<tr>
		<td>uploadFolder init parameter value: <%=portletConfig.getInitParameter("uploadFolder")%>
		</td>
		<td><b>myaction</b> attribute value in PortletSession:
		${portletSessionScope.myaction}</td>
	</tr>
	<tr>
		<td>Search criteria stored in PortletSession: Book name - <%=portletSession.getAttribute("bookNameSearchField",
							PortletSession.APPLICATION_SCOPE)%>, 
							Author name - <%=session.getAttribute("authorNameSearchField")%></td>
	</tr>

</table>