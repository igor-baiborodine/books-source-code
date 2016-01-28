<%--
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
--%>

<%@include file="/html/init.jsp"%>

<%
Slogan slogan = (Slogan) request.getAttribute(WebKeys.SLOGAN_ENTRY);
%>

<h1><%= slogan.getSloganText() %></h1>

<liferay-ui:ratings className="<%= Slogan.class.getName() %>"
    classPK="<%= slogan.getSloganId() %>" type="stars" />

<liferay-ui:panel-container extended="<%= false %>"
    id="sloganCommentsPanelContainer" persistState="<%= true %>">

  <liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>"
      id="sloganCommentsPanel" persistState="<%= true %>"
      title='<%= LanguageUtil.get(pageContext, "comments") %>'>

    <portlet:actionURL name="invokeTaglibDiscussion" var="discussionURL" />

    <liferay-ui:discussion className="<%= Slogan.class.getName() %>"
        classPK="<%= slogan.getSloganId() %>"
        formAction="<%= discussionURL %>" formName="fm2"
        ratingsEnabled="<%= true %>" redirect="<%= currentURL %>"
        subject="<%= slogan.getSloganText() %>"
        userId="<%= slogan.getUserId() %>" />

  </liferay-ui:panel>

</liferay-ui:panel-container>
