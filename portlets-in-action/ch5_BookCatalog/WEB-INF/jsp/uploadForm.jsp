<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html" isELIgnored="false"%>

<form name="uploadTocForm" method="post" action="${uploadTocActionUrl}">
<table>
	<tr>
		<a class="anchor" href="${homeUrl}"><b>HOME</b></a>
	</tr>
</table>
<table>
	<tr>
		<td><b>E-book URL:</b><font style="color: #C11B17;"></font></td>
		<td colspan="2"><input type="text" name="tocDownloadUrl" /></td>
	</tr>
	<tr align="center">
		<td colspan="2"><input type="submit" value="Save" /></td>
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
<br></br>
<br></br>