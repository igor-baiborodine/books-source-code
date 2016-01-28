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

<jsp:useBean
    id="regUser"
    type="com.inkwell.internet.productregistration.model.PRUser"
    scope="request" />

<jsp:useBean
    id="registration"
    type="com.inkwell.internet.productregistration.model.PRRegistration"
    scope="request" />

<%
Calendar now = CalendarFactoryUtil.getCalendar();
%>

<portlet:actionURL name="registerProduct" var="registerProductURL" />

<aui:form name="fm" action="<%= registerProductURL.toString() %>" method="post">

  <aui:fieldset>

    <liferay-ui:error
        key="firstname-required"
        message="firstname-required" />

    <aui:input
        type="text"
        name="firstName"
        value="<%= regUser.getFirstName() %>"
        size="25" />

    <liferay-ui:error
        key="lastname-required"
        message="lastname-required" />

    <aui:input name="lastName"
        type="text"
        value="<%= regUser.getLastName() %>"
        size="25" />

    <liferay-ui:error
        key="address-required"
        message="address-required" />

    <aui:input
        name="address1"
        type="text"
        value="<%= regUser.getAddress1() %>"
        size="40" />

    <aui:input
        name="address2"
        type="text"
        value="<%= regUser.getAddress2() %>"
        size="40" />

    <liferay-ui:error
        key="address-required"
        message="address-required" />

    <aui:input
        name="city"
        type="text"
        value="<%= regUser.getCity() %>"
        size="25" />

    <liferay-ui:error
        key="address-required"
        message="address-required" />

    <aui:input
        name="state"
        type="text"
        value="<%= regUser.getState() %>"
        size="25" />

    <liferay-ui:error
        key="address-required"
        message="address-required" />

    <aui:input
        name="postalCode"
        type="text"
        value="<%= regUser.getPostalCode() %>"
        size="10" />

    <liferay-ui:error
        key="address-required"
        message="address-required" />

    <aui:input
        name="country"
        type="text"
        value="<%= regUser.getCountry() %>"
        size="25" />

    <liferay-ui:error
        key="email-required"
        message="email-required" />

    <aui:input
        name="emailAddress"
        type="text"
        value="<%= regUser.getEmail() %>"
        size="25" />

    <liferay-ui:error
        key="phone-number-required"
        message="phone-number-required" />

    <aui:input
        name="phoneNumber"
        type="text"
        value="<%= regUser.getPhoneNumber() %>"
        size="15" />

    <liferay-ui:error
        key="birthdate-required"
        message="date-of-birth-required" />

    <%
    Calendar dob = CalendarFactoryUtil.getCalendar();
    dob.setTime(regUser.getBirthDate());
    %>

    <aui:input
        name="birthDate"
        model="<%= PRUser.class %>"
        bean="<%= regUser  %>"
        value="<%= dob %>" />

    <liferay-ui:error
        key="gender-required"
        message="gender-required" />

    <aui:select name="gender">
      <aui:option value="">
        <liferay-ui:message key="please-choose" />
      </aui:option>

      <c:choose>
        <c:when test="<%= regUser.getGender() != null %>">
          <c:choose>
            <c:when test='<%= regUser.getGender().equals("male") %>'>
              <aui:option value="male" selected="true">
                <liferay-ui:message key="male" />
              </aui:option>
            </c:when>
            <c:otherwise>
              <aui:option value="male">
                <liferay-ui:message key="male" />
              </aui:option>
            </c:otherwise>
          </c:choose>
          <c:choose>
            <c:when test='<%= regUser.getGender().equals("female") %>'>
              <aui:option value="female" selected="true">
                <liferay-ui:message key="female" />
              </aui:option>
            </c:when>
            <c:otherwise>
              <aui:option value="female">
                <liferay-ui:message key="female" />
              </aui:option>
            </c:otherwise>
          </c:choose>
        </c:when>
        <c:otherwise>
          <aui:option value="male">
            <liferay-ui:message key="male" />
          </aui:option>
          <aui:option value="female">
            <liferay-ui:message key="female" />
          </aui:option>
        </c:otherwise>
      </c:choose>
    </aui:select>

    <liferay-ui:error
        key="date-purchased-required"
        message="date-purchased-required" />

    <aui:input
        model="<%= PRRegistration.class %>"
        bean="<%= registration %>"
        name="datePurchased"
        value="<%= now %>" />

    <liferay-ui:error
        key="howhear-required"
        message="howhear-required" />

    <aui:select name="howHear">
      <aui:option value="">
        <liferay-ui:message key="please-choose" />
      </aui:option>
      <aui:option value="tv-advertisement">
        <liferay-ui:message key="tv-advertisement" />
      </aui:option>
      <aui:option value="radio-advertisement">
        <liferay-ui:message key="radio-advertisement" />
      </aui:option>
      <aui:option value="tv-news">
        <liferay-ui:message key="tv-news" />
      </aui:option>
      <aui:option value="magazine-article">
        <liferay-ui:message key="magazine-article" />
      </aui:option>
      <aui:option value="retail-store">
        <liferay-ui:message key="retail-store" />
      </aui:option>
      <aui:option value="friend-family-member">
        <liferay-ui:message key="friend-family-member" />
      </aui:option>
      <aui:option value="inkwell.com">
        <liferay-ui:message key="inkwell.com" />
      </aui:option>
      <aui:option value="other-web-site">
        <liferay-ui:message key="other-web-site" />
      </aui:option>
      <aui:option value="trade-show">
        <liferay-ui:message key="trade-show" />
      </aui:option>
      <aui:option value="home-shopping">
        <liferay-ui:message key="home-shopping" />
      </aui:option>
    </aui:select>

    <liferay-ui:error
        key="where-purchased-required"
        message="where-purchased-required" />

    <aui:select name="wherePurchase">
      <aui:option value="">
        <liferay-ui:message key="please-choose" />
      </aui:option>
      <aui:option value="retail-store">
        <liferay-ui:message key="retail-store" />
      </aui:option>
      <aui:option value="tv-shopping-network">
        <liferay-ui:message key="tv-shopping-network" />
      </aui:option>
      <aui:option value="gift">
        <liferay-ui:message key="gift" />
      </aui:option>
      <aui:option value="catalog">
        <liferay-ui:message key="catalog" />
      </aui:option>
      <aui:option value="online-retailer">
        <liferay-ui:message key="online-retailer" />
      </aui:option>
      <aui:option value="inkwell.com">
        <liferay-ui:message key="inkwell.com" />
      </aui:option>
      <aui:option value="other">
        <liferay-ui:message key="other" />
      </aui:option>
    </aui:select>

    <%
    List<PRProduct> products =
        PRProductLocalServiceUtil.getAllProducts(themeDisplay.getScopeGroupId());
    %>

    <aui:select name="productType">
      <aui:option value="-1">
        <liferay-ui:message key="please-choose" />
      </aui:option>
      <%
      for (int i = 0; i < products.size(); i++) {
      %>
      <aui:option value="<%= products.get(i).getProductId() %>">
        <%= products.get(i).getProductName() %>
      </aui:option>
      <%
      }
      %>
    </aui:select>

    <liferay-ui:error
        key="product-type-required"
        message="product-type-required" />

    <liferay-ui:error
        key="serial-number-required"
        message="serial-number-required" />

    <aui:input
        name="productSerialNumber"
        type="text"
        size="15" />

    <aui:button
        type="submit"
        value="Save"
        name="saveRegistration" />

    <portlet:renderURL var="cancelURL" windowState="normal">
      <portlet:param name="jspPage" value="/registration/view.jsp" />
    </portlet:renderURL>

    <aui:button
        type="cancel"
        value="Cancel"
        onClick="<%= cancelURL.toString() %>" />

  </aui:fieldset>

</aui:form>