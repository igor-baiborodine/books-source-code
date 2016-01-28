<%
/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
%>

<%@include file="/init.jsp" %>

<p><img src="<%=renderResponse.encodeURL(renderRequest.getContextPath()) + "/images/inkwell-pen-logo.jpg"%>" border="0" /></p>

<p><a href='<portlet:actionURL name="editDisplayRegistrations" />'><liferay-ui:message key="display-registrations" /> </a></p>

<liferay-ui:success key="productSaved" message="product-saved-successfully" />
<liferay-ui:success key="productDeleted" message="productDeleted" />
<liferay-ui:success key="productUpdated" message="productUpdated" />
<liferay-ui:error key="fields-required" message="fields-required" />
<liferay-ui:error key="error-deleting" message="error-deleting" />
<liferay-ui:error key="error-updating" message="error-updating" />

<%--
<c:if test='<%= PortletPermissionUtil.contains(permissionChecker, portletDisplay.getId(), "ADD_PRODUCT") %>'>
--%>

  <portlet:actionURL name="addProduct" var="addProductURL"/>

  <aui:form name="fm" action="<%= addProductURL.toString() %>" method="post">

    <aui:fieldset>

      <aui:input name="productName" size="45" />
      <aui:input name="productSerial" size="45" />

      <aui:button-row>
        <aui:button type="submit" />
      </aui:button-row>

    </aui:fieldset>

  </aui:form>

  <liferay-ui:search-container
      emptyResultsMessage="there-are-no-products"
      delta="5">

    <liferay-ui:search-container-results>
    <%
    List<PRProduct> tempResults = ActionUtil.getProducts(renderRequest);

    results = ListUtil.subList(
        tempResults, searchContainer.getStart(), searchContainer.getEnd());
    total = tempResults.size();

    pageContext.setAttribute("results", results);
    pageContext.setAttribute("total", total);
    %>
    </liferay-ui:search-container-results>

    <liferay-ui:search-container-row
        className="com.inkwell.internet.productregistration.model.PRProduct"
        keyProperty="productId"
        modelVar="product">

      <liferay-ui:search-container-column-text
          name="product-name"
          property="productName" />
      <liferay-ui:search-container-column-text
          name="product-serial"
          property="serialNumber" />
      <liferay-ui:search-container-column-jsp
          path="/admin/admin_actions.jsp"
          align="right" />

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator />

  </liferay-ui:search-container>

<%--
</c:if>
--%>
