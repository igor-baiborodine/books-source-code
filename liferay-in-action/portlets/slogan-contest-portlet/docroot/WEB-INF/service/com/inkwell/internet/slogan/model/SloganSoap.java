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

package com.inkwell.internet.slogan.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * This class is used by
 * {@link com.inkwell.internet.slogan.service.http.SloganServiceSoap}.
 * </p>
 *
 * @author    Rich Sezov
 * @see       com.inkwell.internet.slogan.service.http.SloganServiceSoap
 * @generated
 */
public class SloganSoap implements Serializable {
	public static SloganSoap toSoapModel(Slogan model) {
		SloganSoap soapModel = new SloganSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSloganId(model.getSloganId());
		soapModel.setSloganDate(model.getSloganDate());
		soapModel.setSloganText(model.getSloganText());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static SloganSoap[] toSoapModels(Slogan[] models) {
		SloganSoap[] soapModels = new SloganSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SloganSoap[][] toSoapModels(Slogan[][] models) {
		SloganSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SloganSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SloganSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SloganSoap[] toSoapModels(List<Slogan> models) {
		List<SloganSoap> soapModels = new ArrayList<SloganSoap>(models.size());

		for (Slogan model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SloganSoap[soapModels.size()]);
	}

	public SloganSoap() {
	}

	public long getPrimaryKey() {
		return _sloganId;
	}

	public void setPrimaryKey(long pk) {
		setSloganId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSloganId() {
		return _sloganId;
	}

	public void setSloganId(long sloganId) {
		_sloganId = sloganId;
	}

	public Date getSloganDate() {
		return _sloganDate;
	}

	public void setSloganDate(Date sloganDate) {
		_sloganDate = sloganDate;
	}

	public String getSloganText() {
		return _sloganText;
	}

	public void setSloganText(String sloganText) {
		_sloganText = sloganText;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
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

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	private String _uuid;
	private long _sloganId;
	private Date _sloganDate;
	private String _sloganText;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private long _companyId;
	private long _groupId;
	private long _userId;
}