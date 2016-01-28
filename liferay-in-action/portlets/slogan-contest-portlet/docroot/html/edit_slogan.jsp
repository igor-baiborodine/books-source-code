<%
/**
* Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
*
* This library is free software; you can redistribute it and/or modify it under
* the terms of the GNU Lesser General Public License as published by the Free
* Software Foundation; either version 2.1 of the License, or (at your option)
* any later version.
*
* This library is distributed in the hope that it will be useful, but WITHOUT
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
* FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
* details.
*/
%>

<%@include file="/html/init.jsp" %>

<portlet:renderURL windowState="normal" var="backURL">
  <portlet:param name="jspPage" value="/html/view.jsp"></portlet:param>
</portlet:renderURL>

<liferay-ui:header
    backURL="<%= backURL %>"
    title="Slogan Contest Entry"
/>

<%
Slogan slogan = (Slogan)request.getAttribute(WebKeys.SLOGAN_ENTRY);
String redirect = ParamUtil.getString(request, "redirect");

long resourcePrimKey = BeanParamUtil.getLong(slogan, request, "sloganId");
int status = BeanParamUtil.getInteger(slogan, request, "status", WorkflowConstants.STATUS_DRAFT);
%>

<portlet:actionURL name="updateSlogan" var="updateSloganURL">
  <portlet:param name="redirect" value="<%= redirect %>" />
</portlet:actionURL>

<portlet:renderURL var="cancelURL"><portlet:param name="jspPage" value="/html/view.jsp" /></portlet:renderURL>

<aui:form name="fm" action="<%= updateSloganURL.toString() %>" method="post">

  <aui:fieldset>

    <aui:model-context bean="<%= slogan %>" model="<%= Slogan.class %>" />

    <c:if test="<%= slogan != null %>">
      <aui:workflow-status id="<%= String.valueOf(resourcePrimKey) %>" status="<%= status %>" />
    </c:if>

    <aui:input name="sloganId" type="hidden" />

    <h1>Slogan Contest Entry</h1>

    <liferay-ui:error
        key="slogan-required"
        message="slogan-required" />

    <aui:input name="sloganText" first="true" autoFocus="true" size="45" />

    <aui:input name="categories" type="assetCategories" />

    <aui:input name="tags" type="assetTags" />

    <aui:button-row>

      <aui:button type="submit" />

      <aui:button
          type="cancel"
          value="Cancel"
          onClick="<%=cancelURL %>"
      />

    </aui:button-row>

  </aui:fieldset>

</aui:form>