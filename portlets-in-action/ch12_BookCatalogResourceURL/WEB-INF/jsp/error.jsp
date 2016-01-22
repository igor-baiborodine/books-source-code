<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html" isELIgnored="false"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<table>
	<tr>
		<a class="anchor" href='<portlet:renderURL portletMode="view"/>'><b>HOME</b></a>
	</tr>
</table>
<table>
	<tr>
		<td>Error <c:out value="${exceptionMsg}" /></td>
	</tr>
</table>
