<%
/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
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

<jsp:useBean id="regUser" type="com.inkwell.internet.productregistration.model.PRUser" scope="request" />
<jsp:useBean id="registration" type="com.inkwell.internet.productregistration.model.PRRegistration" scope="request" />

<p><b><liferay-ui:message key="first-name" /></b></p>
<p><%= regUser.getFirstName() %></p>

<p><b><liferay-ui:message key="last-name" /></b></p>
<p><%= regUser.getLastName() %></p>

<p><b><liferay-ui:message key="address1" /></b></p>
<p><%= regUser.getAddress1() %></p>

<p><b><liferay-ui:message key="address2" /></b></p>
<p><%= regUser.getAddress2() %></p>

<p><b><liferay-ui:message key="city" /></b></p>
<p><%= regUser.getCity() %></p>

<p><b><liferay-ui:message key="state" /></b></p>
<p><%= regUser.getState() %></p>

<p><b><liferay-ui:message key="postal-code" /></b></p>
<p><%= regUser.getPostalCode() %></p>

<p><b><liferay-ui:message key="country" /></b></p>
<p><%= regUser.getCountry() %></p>

<p><b><liferay-ui:message key="email-address" /></b></p>
<p><%= regUser.getEmail() %></p>

<p><b><liferay-ui:message key="phone-number" /></b></p>
<p><%= regUser.getPhoneNumber() %></p>

<p><b><liferay-ui:message key="date-of-birth" /></b></p>
<p><%= regUser.getBirthDate() %></p>

<p><b><liferay-ui:message key="gender" /></b></p>
<p>

<%
boolean gender = regUser.getMale();
if (gender==true) {
%>
  Male
<%
}
else {
%>
  Female
<%
}
%>

</p>

<p><b><liferay-ui:message key="date-purchased" /></b></p>
<p><%= registration.getDatePurchased() %></p>

<p><b><liferay-ui:message key="how-hear" /></b></p>
<p><%= registration.getHowHear() %></p>

<p><b><liferay-ui:message key="where-purchase" /></b></p>
<p><%= registration.getWherePurchased() %></p>

<p><b><liferay-ui:message key="product-serial-number" /></b></p>
<p><%= registration.getSerialNumber() %></p>

<p><b><liferay-ui:message key="product-type" /></b></p>
<p>
<%
PRProduct product = PRProductLocalServiceUtil.getPRProduct(registration.getProductId());
%>
  <%= product.getProductName() %>
</p>
