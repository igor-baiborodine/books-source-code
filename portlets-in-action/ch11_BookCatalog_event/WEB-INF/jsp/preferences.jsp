<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html" isELIgnored="false" import="chapter11.code.listing.utils.Constants"%>

<portlet:defineObjects/>

<portlet:actionURL var="savePrefUrl" name="savePreferences"/>
<div class="bookCatalogPortlet_ch10">
<form name="<portlet:namespace/>preferencesForm" method="POST" action="${savePrefUrl}">
<%
	java.util.List catList = java.util.Arrays.asList(portletPreferences.getValues("category", new String[] {"-99"})); 
%>
<table>
	<tr>
		<td colspan="2">
			<c:forEach var="error" items="${errorMessages}">
				<c:out value="${error}"/>
			</c:forEach>
		</td>
	</tr>
	<tr>
		<td><b>Preferred Category</b></td>
		<td>
			<select name="<portlet:namespace/>prefCategory" multiple="multiple">
				<option value="java" <%=catList.contains("java") ? "selected" : ""%>>Java</option>
				<option value=".net" <%=catList.contains(".net") ? "selected" : ""%>>.NET</option>
				<option value="mobile" <%=catList.contains("mobile") ? "selected" : ""%>>Mobile Technology</option>
				<option value="softwareEng" <%=catList.contains("softwareEng") ? "selected" : ""%>>Software Engineering</option>
			</select>
		</td>
		<td>
			<a href='<portlet:actionURL name="resetPreference">
				<portlet:param name="prefName" value="category"/>
			</portlet:actionURL>
			'><b>Reset</b></a>
		</td>
	</tr>
	<tr>
		<td><b>Search Type</b></td>
		<td>
			<select name="<portlet:namespace/>searchType">
				<option value="-1">--SELECT--</option>
				<option value="<%= Constants.CASE_SENSITIVE%>" <%=portletPreferences.getValue("searchType", "-99").equalsIgnoreCase("sensitive") ? "selected" : ""%>>Case-Sensitive</option>
				<option value="<%= Constants.CASE_INSENSITIVE%>" <%=portletPreferences.getValue("searchType", "-99").equalsIgnoreCase("insensitive") ? "selected" : ""%>>Case-Insensitive</option>
			</select>
		</td>
		<td>
			<a href='<portlet:actionURL name="resetPreference">
				<portlet:param name="prefName" value="searchType"/>
			</portlet:actionURL>
			'><b>Reset</b></a>
		</td>
	</tr>
	<tr>
		<td><b>Maximum number of books to show</b></td>
		<td>
			<select name="<portlet:namespace/>maxNumOfBooks">
				<option value="1000" <%=portletPreferences.getValue("maxNumOfBooks", "-99").equalsIgnoreCase("1000") ? "selected" : ""%>>1000</option>
				<option value="5" <%=portletPreferences.getValue("maxNumOfBooks", "-99").equalsIgnoreCase("5") ? "selected" : ""%>>5</option>
				<option value="10" <%=portletPreferences.getValue("maxNumOfBooks", "-99").equalsIgnoreCase("10") ? "selected" : ""%>>10</option>
			</select>
		</td>
		<td>
			<a href='<portlet:actionURL name="resetPreference">
				<portlet:param name="prefName" value="maxNumber"/>
			</portlet:actionURL>
			'><b>Reset</b></a>
		</td>
	</tr>
	<tr>
		<td><b>Greetings Message</b></td>
		<td>
			${portletPreferencesValues.greetingMessage[0]}<i>&lt;username&gt;</i>'
		</td>
		<td>
		</td>
	</tr>
	<tr>
		<td><b>Preferred Book ISBN Number</b></td>
		<td>
			<input type="text" name="<portlet:namespace/>prefBookISBN" maxlength="13"></input>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:forEach var="prefIsbn" items="${portletPreferencesValues.prefBookISBN}">
			    <c:out value="${prefIsbn}"/> &nbsp; &nbsp;
			</c:forEach>
		</td>	
		<td>
			<a href='<portlet:actionURL name="resetPreference">
				<portlet:param name="prefName" value="prefBookISBN"/>
			</portlet:actionURL>
			'><b>Reset</b></a>
		</td>
	</tr>
</table>
<br/>
<table align="center">
	<tr>
		<td><input type="submit" value="Save"></td>
	</tr>
</table>
</form>
</div>