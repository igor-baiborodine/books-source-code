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
 * This class is a wrapper for {@link PRProduct}.
 * </p>
 *
 * @author    Rich Sezov
 * @see       PRProduct
 * @generated
 */
public class PRProductWrapper implements PRProduct {
	public PRProductWrapper(PRProduct prProduct) {
		_prProduct = prProduct;
	}

	public long getPrimaryKey() {
		return _prProduct.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_prProduct.setPrimaryKey(pk);
	}

	public long getProductId() {
		return _prProduct.getProductId();
	}

	public void setProductId(long productId) {
		_prProduct.setProductId(productId);
	}

	public java.lang.String getProductName() {
		return _prProduct.getProductName();
	}

	public void setProductName(java.lang.String productName) {
		_prProduct.setProductName(productName);
	}

	public java.lang.String getSerialNumber() {
		return _prProduct.getSerialNumber();
	}

	public void setSerialNumber(java.lang.String serialNumber) {
		_prProduct.setSerialNumber(serialNumber);
	}

	public long getCompanyId() {
		return _prProduct.getCompanyId();
	}

	public void setCompanyId(long companyId) {
		_prProduct.setCompanyId(companyId);
	}

	public long getGroupId() {
		return _prProduct.getGroupId();
	}

	public void setGroupId(long groupId) {
		_prProduct.setGroupId(groupId);
	}

	public com.inkwell.internet.productregistration.model.PRProduct toEscapedModel() {
		return _prProduct.toEscapedModel();
	}

	public boolean isNew() {
		return _prProduct.isNew();
	}

	public void setNew(boolean n) {
		_prProduct.setNew(n);
	}

	public boolean isCachedModel() {
		return _prProduct.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_prProduct.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _prProduct.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_prProduct.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _prProduct.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _prProduct.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_prProduct.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _prProduct.clone();
	}

	public int compareTo(
		com.inkwell.internet.productregistration.model.PRProduct prProduct) {
		return _prProduct.compareTo(prProduct);
	}

	public int hashCode() {
		return _prProduct.hashCode();
	}

	public java.lang.String toString() {
		return _prProduct.toString();
	}

	public java.lang.String toXmlString() {
		return _prProduct.toXmlString();
	}

	public PRProduct getWrappedPRProduct() {
		return _prProduct;
	}

	private PRProduct _prProduct;
}