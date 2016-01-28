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

package com.inkwell.internet.productregistration.model;

/**
 * <p>
 * This class is a wrapper for {@link PRUser}.
 * </p>
 *
 * @author    Rich Sezov
 * @see       PRUser
 * @generated
 */
public class PRUserWrapper implements PRUser {
	public PRUserWrapper(PRUser prUser) {
		_prUser = prUser;
	}

	public long getPrimaryKey() {
		return _prUser.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_prUser.setPrimaryKey(pk);
	}

	public long getPrUserId() {
		return _prUser.getPrUserId();
	}

	public void setPrUserId(long prUserId) {
		_prUser.setPrUserId(prUserId);
	}

	public java.lang.String getPrUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _prUser.getPrUserUuid();
	}

	public void setPrUserUuid(java.lang.String prUserUuid) {
		_prUser.setPrUserUuid(prUserUuid);
	}

	public java.lang.String getFirstName() {
		return _prUser.getFirstName();
	}

	public void setFirstName(java.lang.String firstName) {
		_prUser.setFirstName(firstName);
	}

	public java.lang.String getLastName() {
		return _prUser.getLastName();
	}

	public void setLastName(java.lang.String lastName) {
		_prUser.setLastName(lastName);
	}

	public java.lang.String getAddress1() {
		return _prUser.getAddress1();
	}

	public void setAddress1(java.lang.String address1) {
		_prUser.setAddress1(address1);
	}

	public java.lang.String getAddress2() {
		return _prUser.getAddress2();
	}

	public void setAddress2(java.lang.String address2) {
		_prUser.setAddress2(address2);
	}

	public java.lang.String getCity() {
		return _prUser.getCity();
	}

	public void setCity(java.lang.String city) {
		_prUser.setCity(city);
	}

	public java.lang.String getState() {
		return _prUser.getState();
	}

	public void setState(java.lang.String state) {
		_prUser.setState(state);
	}

	public java.lang.String getPostalCode() {
		return _prUser.getPostalCode();
	}

	public void setPostalCode(java.lang.String postalCode) {
		_prUser.setPostalCode(postalCode);
	}

	public java.lang.String getCountry() {
		return _prUser.getCountry();
	}

	public void setCountry(java.lang.String country) {
		_prUser.setCountry(country);
	}

	public java.lang.String getPhoneNumber() {
		return _prUser.getPhoneNumber();
	}

	public void setPhoneNumber(java.lang.String phoneNumber) {
		_prUser.setPhoneNumber(phoneNumber);
	}

	public java.lang.String getEmail() {
		return _prUser.getEmail();
	}

	public void setEmail(java.lang.String email) {
		_prUser.setEmail(email);
	}

	public java.util.Date getBirthDate() {
		return _prUser.getBirthDate();
	}

	public void setBirthDate(java.util.Date birthDate) {
		_prUser.setBirthDate(birthDate);
	}

	public boolean getMale() {
		return _prUser.getMale();
	}

	public boolean isMale() {
		return _prUser.isMale();
	}

	public void setMale(boolean male) {
		_prUser.setMale(male);
	}

	public long getUserId() {
		return _prUser.getUserId();
	}

	public void setUserId(long userId) {
		_prUser.setUserId(userId);
	}

	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _prUser.getUserUuid();
	}

	public void setUserUuid(java.lang.String userUuid) {
		_prUser.setUserUuid(userUuid);
	}

	public long getCompanyId() {
		return _prUser.getCompanyId();
	}

	public void setCompanyId(long companyId) {
		_prUser.setCompanyId(companyId);
	}

	public long getGroupId() {
		return _prUser.getGroupId();
	}

	public void setGroupId(long groupId) {
		_prUser.setGroupId(groupId);
	}

	public com.inkwell.internet.productregistration.model.PRUser toEscapedModel() {
		return _prUser.toEscapedModel();
	}

	public boolean isNew() {
		return _prUser.isNew();
	}

	public void setNew(boolean n) {
		_prUser.setNew(n);
	}

	public boolean isCachedModel() {
		return _prUser.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_prUser.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _prUser.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_prUser.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _prUser.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _prUser.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_prUser.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _prUser.clone();
	}

	public int compareTo(
		com.inkwell.internet.productregistration.model.PRUser prUser) {
		return _prUser.compareTo(prUser);
	}

	public int hashCode() {
		return _prUser.hashCode();
	}

	public java.lang.String toString() {
		return _prUser.toString();
	}

	public java.lang.String toXmlString() {
		return _prUser.toXmlString();
	}

	public java.lang.String getGender() {
		return _prUser.getGender();
	}

	public void setGender(java.lang.String gender) {
		_prUser.setGender(gender);
	}

	public PRUser getWrappedPRUser() {
		return _prUser;
	}

	private PRUser _prUser;
}