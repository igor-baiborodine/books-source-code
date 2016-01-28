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

<%@include file = "/html/init.jsp" %>

<portlet:renderURL var="addSloganURL">
  <portlet:param name="jspPage" value="/html/edit_slogan.jsp" />
</portlet:renderURL>

<c:if test='<%= PortletPermissionUtil.contains(permissionChecker, portletDisplay.getId(), "ADD_SLOGAN") %>'>
  <input type="button" value="<liferay-ui:message key="add-slogan" />" onClick="location.href = '<%= addSloganURL.toString() %>';" />
</c:if>

<%
String tabs1 = ParamUtil.getString(request, "tabs1", "by-rating");

String tabs1Values = "by-rating,by-date";

PortletURL tabsURL = renderResponse.createRenderURL();
tabsURL.setParameter("jspPage", "/html/view.jsp");
tabsURL.setParameter("tabs1", tabs1);

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("tabs1", tabs1);

%>

<liferay-portlet:renderURL varImpl="searchURL">
  <portlet:param name="jspPage" value="/html/search.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="fm0">
  <liferay-portlet:renderURLParams varImpl="searchURL" />
  <aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
  <aui:input name="groupId" type="hidden" value="<%= String.valueOf(scopeGroupId) %>" />

  <div class="portlet-toolbar search-form">
    <span class="aui-search-bar">
       <aui:input inlineField="<%= true %>" label="" name="keywords" size="30" title="search-entries" type="text" />

       <aui:button type="submit" value="search" />
    </span>
  </div>
</aui:form>


<aui:form action="<%= tabsURL %>" method="get" name="fm1" onSubmit="submitForm(this); return false;">
<liferay-portlet:renderURLParams varImpl="tabsURL" />

<liferay-ui:tabs
    names="<%= tabs1Values %>"
    tabsValues="<%= tabs1Values %>"
    portletURL="<%= tabsURL %>"
/>

<c:choose>
  <c:when test='<%= tabs1.equals("by-rating") %>'>
    <liferay-ui:search-container emptyResultsMessage="there-are-no-slogans" delta="20" iteratorURL="<%= iteratorURL %>">
      <liferay-ui:search-container-results>
      <%
      results = ActionUtil.getSlogans(renderRequest, searchContainer.getStart(), searchContainer.getEnd());
      total = ActionUtil.getSlogansCount(renderRequest);

      pageContext.setAttribute("results", results);
      pageContext.setAttribute("total", total);
      %>
      </liferay-ui:search-container-results>

      <liferay-ui:search-container-row
          className="com.inkwell.internet.slogan.model.Slogan"
          keyProperty="sloganId"
          modelVar="slogan">

        <portlet:renderURL windowState="maximized" var="rowURL">
          <portlet:param name="jspPage" value="/html/view_slogan.jsp" />
          <portlet:param name="resourcePrimKey" value="<%= String.valueOf(slogan.getSloganId()) %>" />
        </portlet:renderURL>

        <liferay-ui:search-container-column-text name="rating">
          <liferay-ui:ratings-score
              score="<%= slogan.getAverageScore() %>" />
        </liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text
            href="<%= rowURL %>"
            name="slogan-text"
            property="sloganText"
            orderable="<%= true %>"
        />
        <liferay-ui:search-container-column-jsp
            path="/html/slogan_actions.jsp"
            align="right"
        />

      </liferay-ui:search-container-row>

      <liferay-ui:search-iterator />

    </liferay-ui:search-container>
  </c:when>

  <c:when test='<%= tabs1.equals("by-date") %>'>
    <liferay-ui:search-container emptyResultsMessage="there-are-no-slogans" delta="20" iteratorURL="<%= iteratorURL %>">
      <liferay-ui:search-container-results>
      <%
      //List<Slogan> tempResults = ActionUtil.getSlogans(renderRequest);

      results = ActionUtil.getSlogans(renderRequest, searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
      total = ActionUtil.getSlogansCount(renderRequest);

      pageContext.setAttribute("results", results);
      pageContext.setAttribute("total", total);
      %>
      </liferay-ui:search-container-results>

      <liferay-ui:search-container-row
          className="com.inkwell.internet.slogan.model.Slogan"
          keyProperty="sloganId"
          modelVar="slogan">

        <portlet:renderURL windowState="maximized" var="rowURL">
          <portlet:param name="jspPage" value="/html/view_slogan.jsp" />
          <portlet:param name="resourcePrimKey" value="<%= String.valueOf(slogan.getSloganId()) %>" />
          <portlet:param name="redirect" value="<%= currentURL %>" />
        </portlet:renderURL>

        <liferay-ui:search-container-column-text
            name="slogan-date"
            property="sloganDate"
            orderable="<%= true %>" />

        <liferay-ui:search-container-column-text
            href="<%= rowURL %>"
            name="slogan-text"
            property="sloganText"
            orderable="<%= true %>" />

        <liferay-ui:search-container-column-jsp
            path="/html/slogan_actions.jsp"
            align="right" />

      </liferay-ui:search-container-row>

      <liferay-ui:search-iterator />

    </liferay-ui:search-container>

  </c:when>
</c:choose>
</aui:form>

