<%@include file="include.jsp"%>

<portlet:defineObjects/>
<table>
	<tr>
		<td><a class="anchor" href='<portlet:renderURL portletMode="view"/>'><b>HOME</b></a></td>
	</tr>
</table>
<table>
	<tr>
		<td>Error <c:out value="${exceptionMsg}" /></td>
	</tr>
</table>
<br></br>
<br></br>