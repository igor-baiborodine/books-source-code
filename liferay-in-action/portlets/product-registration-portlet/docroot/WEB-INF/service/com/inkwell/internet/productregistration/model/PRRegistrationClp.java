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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author Rich Sezov
 */
public class PRRegistrationClp extends BaseModelImpl<PRRegistration>
	implements PRRegistration {
	public PRRegistrationClp() {
	}

	public long getPrimaryKey() {
		return _registrationId;
	}

	public void setPrimaryKey(long pk) {
		setRegistrationId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_registrationId);
	}

	public long getRegistrationId() {
		return _registrationId;
	}

	public void setRegistrationId(long registrationId) {
		_registrationId = registrationId;
	}

	public long getPrUserId() {
		return _prUserId;
	}

	public void setPrUserId(long prUserId) {
		_prUserId = prUserId;
	}

	public String getPrUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getPrUserId(), "uuid", _prUserUuid);
	}

	public void setPrUserUuid(String prUserUuid) {
		_prUserUuid = prUserUuid;
	}

	public Date getDatePurchased() {
		return _datePurchased;
	}

	public void setDatePurchased(Date datePurchased) {
		_datePurchased = datePurchased;
	}

	public String getHowHear() {
		return _howHear;
	}

	public void setHowHear(String howHear) {
		_howHear = howHear;
	}

	public String getWherePurchased() {
		return _wherePurchased;
	}

	public void setWherePurchased(String wherePurchased) {
		_wherePurchased = wherePurchased;
	}

	public String getSerialNumber() {
		return _serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		_serialNumber = serialNumber;
	}

	public long getProductId() {
		return _productId;
	}

	public void setProductId(long productId) {
		_productId = productId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public PRRegistration toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (PRRegistration)Proxy.newProxyInstance(PRRegistration.class.getClassLoader(),
				new Class[] { PRRegistration.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		PRRegistrationClp clone = new PRRegistrationClp();

		clone.setRegistrationId(getRegistrationId());
		clone.setPrUserId(getPrUserId());
		clone.setDatePurchased(getDatePurchased());
		clone.setHowHear(getHowHear());
		clone.setWherePurchased(getWherePurchased());
		clone.setSerialNumber(getSerialNumber());
		clone.setProductId(getProductId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());

		return clone;
	}

	public int compareTo(PRRegistration prRegistration) {
		long pk = prRegistration.getPrimaryKey();

		if (getPrimaryKey() < pk) {
			return -1;
		}
		else if (getPrimaryKey() > pk) {
			return 1;
		}
		else {
			return 0;
		}
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		PRRegistrationClp prRegistration = null;

		try {
			prRegistration = (PRRegistrationClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = prRegistration.getPrimaryKey();

		if (getPrimaryKey() == pk) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return (int)getPrimaryKey();
	}

	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{registrationId=");
		sb.append(getRegistrationId());
		sb.append(", prUserId=");
		sb.append(getPrUserId());
		sb.append(", datePurchased=");
		sb.append(getDatePurchased());
		sb.append(", howHear=");
		sb.append(getHowHear());
		sb.append(", wherePurchased=");
		sb.append(getWherePurchased());
		sb.append(", serialNumber=");
		sb.append(getSerialNumber());
		sb.append(", productId=");
		sb.append(getProductId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append(
			"com.inkwell.internet.productregistration.model.PRRegistration");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>registrationId</column-name><column-value><![CDATA[");
		sb.append(getRegistrationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>prUserId</column-name><column-value><![CDATA[");
		sb.append(getPrUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>datePurchased</column-name><column-value><![CDATA[");
		sb.append(getDatePurchased());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>howHear</column-name><column-value><![CDATA[");
		sb.append(getHowHear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>wherePurchased</column-name><column-value><![CDATA[");
		sb.append(getWherePurchased());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serialNumber</column-name><column-value><![CDATA[");
		sb.append(getSerialNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productId</column-name><column-value><![CDATA[");
		sb.append(getProductId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _registrationId;
	private long _prUserId;
	private String _prUserUuid;
	private Date _datePurchased;
	private String _howHear;
	private String _wherePurchased;
	private String _serialNumber;
	private long _productId;
	private long _companyId;
	private long _groupId;
}