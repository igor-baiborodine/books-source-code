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
 * This class is a wrapper for {@link PRRegistration}.
 * </p>
 *
 * @author    Rich Sezov
 * @see       PRRegistration
 * @generated
 */
public class PRRegistrationWrapper implements PRRegistration {
	public PRRegistrationWrapper(PRRegistration prRegistration) {
		_prRegistration = prRegistration;
	}

	public long getPrimaryKey() {
		return _prRegistration.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_prRegistration.setPrimaryKey(pk);
	}

	public long getRegistrationId() {
		return _prRegistration.getRegistrationId();
	}

	public void setRegistrationId(long registrationId) {
		_prRegistration.setRegistrationId(registrationId);
	}

	public long getPrUserId() {
		return _prRegistration.getPrUserId();
	}

	public void setPrUserId(long prUserId) {
		_prRegistration.setPrUserId(prUserId);
	}

	public java.lang.String getPrUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _prRegistration.getPrUserUuid();
	}

	public void setPrUserUuid(java.lang.String prUserUuid) {
		_prRegistration.setPrUserUuid(prUserUuid);
	}

	public java.util.Date getDatePurchased() {
		return _prRegistration.getDatePurchased();
	}

	public void setDatePurchased(java.util.Date datePurchased) {
		_prRegistration.setDatePurchased(datePurchased);
	}

	public java.lang.String getHowHear() {
		return _prRegistration.getHowHear();
	}

	public void setHowHear(java.lang.String howHear) {
		_prRegistration.setHowHear(howHear);
	}

	public java.lang.String getWherePurchased() {
		return _prRegistration.getWherePurchased();
	}

	public void setWherePurchased(java.lang.String wherePurchased) {
		_prRegistration.setWherePurchased(wherePurchased);
	}

	public java.lang.String getSerialNumber() {
		return _prRegistration.getSerialNumber();
	}

	public void setSerialNumber(java.lang.String serialNumber) {
		_prRegistration.setSerialNumber(serialNumber);
	}

	public long getProductId() {
		return _prRegistration.getProductId();
	}

	public void setProductId(long productId) {
		_prRegistration.setProductId(productId);
	}

	public long getCompanyId() {
		return _prRegistration.getCompanyId();
	}

	public void setCompanyId(long companyId) {
		_prRegistration.setCompanyId(companyId);
	}

	public long getGroupId() {
		return _prRegistration.getGroupId();
	}

	public void setGroupId(long groupId) {
		_prRegistration.setGroupId(groupId);
	}

	public com.inkwell.internet.productregistration.model.PRRegistration toEscapedModel() {
		return _prRegistration.toEscapedModel();
	}

	public boolean isNew() {
		return _prRegistration.isNew();
	}

	public void setNew(boolean n) {
		_prRegistration.setNew(n);
	}

	public boolean isCachedModel() {
		return _prRegistration.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_prRegistration.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _prRegistration.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_prRegistration.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _prRegistration.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _prRegistration.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_prRegistration.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _prRegistration.clone();
	}

	public int compareTo(
		com.inkwell.internet.productregistration.model.PRRegistration prRegistration) {
		return _prRegistration.compareTo(prRegistration);
	}

	public int hashCode() {
		return _prRegistration.hashCode();
	}

	public java.lang.String toString() {
		return _prRegistration.toString();
	}

	public java.lang.String toXmlString() {
		return _prRegistration.toXmlString();
	}

	public PRRegistration getWrappedPRRegistration() {
		return _prRegistration;
	}

	private PRRegistration _prRegistration;
}