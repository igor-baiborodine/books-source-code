<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html" isELIgnored="false"%>

<div class="bookCatalogPortlet_ch10">
<form name="<portlet:namespace/>uploadTocForm" method="post" action='<portlet:actionURL name="uploadTocAction" copyCurrentRenderParameters="true"/>' enctype="multipart/form-data">
<table>
	<tr>
		<a class="anchor" href='<portlet:renderURL portletMode="view"/>'><b>HOME</b></a>
	</tr>
</table>
<table>
	<tr>
		<td><b>TOC:</b><font style="color: #C11B17;"></font></td>
		<td colspan="2"><input type="file" name="<portlet:namespace/>tocFile" /></td>
	</tr>
	<tr align="center">
		<td colspan="2"><input type="submit" value="Upload TOC" /></td>
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
</div>
<br></br>
<br></br>