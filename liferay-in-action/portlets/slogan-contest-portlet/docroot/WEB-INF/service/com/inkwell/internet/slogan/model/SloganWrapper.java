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

package com.inkwell.internet.slogan.model;

/**
 * <p>
 * This class is a wrapper for {@link Slogan}.
 * </p>
 *
 * @author    Rich Sezov
 * @see       Slogan
 * @generated
 */
public class SloganWrapper implements Slogan {
	public SloganWrapper(Slogan slogan) {
		_slogan = slogan;
	}

	public long getPrimaryKey() {
		return _slogan.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_slogan.setPrimaryKey(pk);
	}

	public java.lang.String getUuid() {
		return _slogan.getUuid();
	}

	public void setUuid(java.lang.String uuid) {
		_slogan.setUuid(uuid);
	}

	public long getSloganId() {
		return _slogan.getSloganId();
	}

	public void setSloganId(long sloganId) {
		_slogan.setSloganId(sloganId);
	}

	public java.util.Date getSloganDate() {
		return _slogan.getSloganDate();
	}

	public void setSloganDate(java.util.Date sloganDate) {
		_slogan.setSloganDate(sloganDate);
	}

	public java.lang.String getSloganText() {
		return _slogan.getSloganText();
	}

	public void setSloganText(java.lang.String sloganText) {
		_slogan.setSloganText(sloganText);
	}

	public int getStatus() {
		return _slogan.getStatus();
	}

	public void setStatus(int status) {
		_slogan.setStatus(status);
	}

	public long getStatusByUserId() {
		return _slogan.getStatusByUserId();
	}

	public void setStatusByUserId(long statusByUserId) {
		_slogan.setStatusByUserId(statusByUserId);
	}

	public java.lang.String getStatusByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _slogan.getStatusByUserUuid();
	}

	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_slogan.setStatusByUserUuid(statusByUserUuid);
	}

	public java.lang.String getStatusByUserName() {
		return _slogan.getStatusByUserName();
	}

	public void setStatusByUserName(java.lang.String statusByUserName) {
		_slogan.setStatusByUserName(statusByUserName);
	}

	public java.util.Date getStatusDate() {
		return _slogan.getStatusDate();
	}

	public void setStatusDate(java.util.Date statusDate) {
		_slogan.setStatusDate(statusDate);
	}

	public long getCompanyId() {
		return _slogan.getCompanyId();
	}

	public void setCompanyId(long companyId) {
		_slogan.setCompanyId(companyId);
	}

	public long getGroupId() {
		return _slogan.getGroupId();
	}

	public void setGroupId(long groupId) {
		_slogan.setGroupId(groupId);
	}

	public long getUserId() {
		return _slogan.getUserId();
	}

	public void setUserId(long userId) {
		_slogan.setUserId(userId);
	}

	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _slogan.getUserUuid();
	}

	public void setUserUuid(java.lang.String userUuid) {
		_slogan.setUserUuid(userUuid);
	}

	public boolean isApproved() {
		return _slogan.isApproved();
	}

	public boolean isDraft() {
		return _slogan.isDraft();
	}

	public boolean isExpired() {
		return _slogan.isExpired();
	}

	public boolean isPending() {
		return _slogan.isPending();
	}

	public com.inkwell.internet.slogan.model.Slogan toEscapedModel() {
		return _slogan.toEscapedModel();
	}

	public boolean isNew() {
		return _slogan.isNew();
	}

	public void setNew(boolean n) {
		_slogan.setNew(n);
	}

	public boolean isCachedModel() {
		return _slogan.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_slogan.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _slogan.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_slogan.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _slogan.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _slogan.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_slogan.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _slogan.clone();
	}

	public int compareTo(com.inkwell.internet.slogan.model.Slogan slogan) {
		return _slogan.compareTo(slogan);
	}

	public int hashCode() {
		return _slogan.hashCode();
	}

	public java.lang.String toString() {
		return _slogan.toString();
	}

	public java.lang.String toXmlString() {
		return _slogan.toXmlString();
	}

	public double getAverageScore() {
		return _slogan.getAverageScore();
	}

	public void setAverageScore(double averageScore) {
		_slogan.setAverageScore(averageScore);
	}

	public java.lang.String getSloganIdString() {
		return _slogan.getSloganIdString();
	}

	public void setSloganIdString(java.lang.String sloganIdString) {
		_slogan.setSloganIdString(sloganIdString);
	}

	public Slogan getWrappedSlogan() {
		return _slogan;
	}

	private Slogan _slogan;
}