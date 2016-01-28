<%--
/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

<%@ include file="/html/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

String keywords = ParamUtil.getString(request, "keywords");
%>

<liferay-portlet:renderURL varImpl="searchURL">
  <portlet:param name="jspPage" value="/html/search.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="fm">
  <liferay-portlet:renderURLParams varImpl="searchURL" />
  <aui:input name="redirect" type="hidden" value="<%= redirect %>" />

  <liferay-ui:header
      backURL="<%= redirect %>"
      title="search"
  />

  <%
  PortletURL portletURL = renderResponse.createRenderURL();

  portletURL.setParameter("jspPage", "/html/search.jsp");
  portletURL.setParameter("redirect", redirect);
  portletURL.setParameter("keywords", keywords);

  List<String> headerNames = new ArrayList<String>();

  headerNames.add("#");
  headerNames.add("slogan");
  headerNames.add("score");

  SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, headerNames, LanguageUtil.format(pageContext, "no-entries-were-found-that-matched-the-keywords-x", "<strong>" + HtmlUtil.escape(keywords) + "</strong>"));

  try {
      Indexer indexer = IndexerRegistryUtil.getIndexer(Slogan.class);

      SearchContext searchContext = SearchContextFactory.getInstance(request);

      searchContext.setEnd(searchContainer.getEnd());
      searchContext.setKeywords(keywords);
      searchContext.setStart(searchContainer.getStart());

      Hits results = indexer.search(searchContext);

      int total = results.getLength();

      searchContainer.setTotal(total);

      List resultRows = searchContainer.getResultRows();

      for (int i = 0; i < results.getDocs().length; i++) {
          Document doc = results.doc(i);

          ResultRow row = new ResultRow(doc, i, i);

          // Position

          row.addText(searchContainer.getStart() + i + 1 + StringPool.PERIOD);

          // Slogan

          long sloganId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));

          Slogan slogan = null;

          try {
              slogan = SloganLocalServiceUtil.getSlogan(sloganId);

              slogan = slogan.toEscapedModel();
          }
          catch (Exception e) {
              if (_log.isWarnEnabled()) {
                  _log.warn("Slogan search index is stale and contains entry " + sloganId);
              }

              continue;
          }

          PortletURL rowURL = renderResponse.createRenderURL();

          rowURL.setParameter("jspPage", "/html/view_slogan.jsp");
          rowURL.setParameter("redirect", currentURL);
          rowURL.setParameter("resourcePrimKey", String.valueOf(slogan.getSloganId()));

          row.addText(slogan.getSloganText(), rowURL);

          // Score

          row.addScore(results.score(i));

          // Add result row

          resultRows.add(row);
      }
      %>

  <span class="aui-search-bar">
    <aui:input inlineField="<%= true %>" label="" name="keywords" size="30" title="search-entries" type="text" value="<%= keywords %>" />

    <aui:button type="submit" value="search" />
  </span>

  <br /><br />

  <liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />

  <%
  }
  catch (Exception e) {
      _log.error(e.getMessage());
  }
  %>
</aui:form>

<%
if (Validator.isNotNull(keywords)) {
    PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(pageContext, "search") + ": " + keywords, currentURL);
}
%>

<%!
private static Log _log = LogFactoryUtil.getLog("slogan_contest.docroot.html.search_jsp");
%>
