<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setLocale value="<%=request.getLocale()%>"/>
<fmt:setBundle basename="content.Language-ext"/>

<table>
  <tr>
  	<td>
  		<fmt:message key="help.message"/>
  	</td>
  </tr>
</table>