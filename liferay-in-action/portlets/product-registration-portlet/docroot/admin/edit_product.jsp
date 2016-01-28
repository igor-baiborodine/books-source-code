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

<%
PRProduct product = (PRProduct) request.getAttribute("product");
%>

<portlet:renderURL var="cancelURL">
  <portlet:param name="jspPage" value="/admin/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="updateProduct" var="updateProductURL" />

<h2>Edit A Product</h2>

<aui:form
    name="fm"
    action="<%= updateProductURL.toString() %>"
    method="post">

  <aui:fieldset>

    <aui:input
        name="resourcePrimKey"
        value="<%= product.getProductId() %>"
        type="hidden"
    />
    <aui:input
        name="productName"
        value="<%= product.getProductName() %>"
        size="45"
    />
    <aui:input
        name="productSerial"
        value="<%= product.getSerialNumber() %>"
        size="45"
    />

    <aui:button-row>

      <aui:button type="submit"/>
      <aui:button
          type="cancel"
          value="Cancel"
          onClick="<%= cancelURL.toString() %>"
    />

    </aui:button-row>

  </aui:fieldset>

</aui:form>