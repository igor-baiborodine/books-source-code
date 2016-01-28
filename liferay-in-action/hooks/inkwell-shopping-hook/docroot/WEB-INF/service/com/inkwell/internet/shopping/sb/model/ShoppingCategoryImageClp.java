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

package com.inkwell.internet.shopping.sb.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author Rich Sezov
 */
public class ShoppingCategoryImageClp extends BaseModelImpl<ShoppingCategoryImage>
	implements ShoppingCategoryImage {
	public ShoppingCategoryImageClp() {
	}

	public long getPrimaryKey() {
		return _imageId;
	}

	public void setPrimaryKey(long pk) {
		setImageId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_imageId);
	}

	public long getImageId() {
		return _imageId;
	}

	public void setImageId(long imageId) {
		_imageId = imageId;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public String getImageUrl() {
		return _imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		_imageUrl = imageUrl;
	}

	public ShoppingCategoryImage toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (ShoppingCategoryImage)Proxy.newProxyInstance(ShoppingCategoryImage.class.getClassLoader(),
				new Class[] { ShoppingCategoryImage.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		ShoppingCategoryImageClp clone = new ShoppingCategoryImageClp();

		clone.setImageId(getImageId());
		clone.setCategoryId(getCategoryId());
		clone.setImageUrl(getImageUrl());

		return clone;
	}

	public int compareTo(ShoppingCategoryImage shoppingCategoryImage) {
		int value = 0;

		value = getImageUrl().compareTo(shoppingCategoryImage.getImageUrl());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ShoppingCategoryImageClp shoppingCategoryImage = null;

		try {
			shoppingCategoryImage = (ShoppingCategoryImageClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = shoppingCategoryImage.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{imageId=");
		sb.append(getImageId());
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append(", imageUrl=");
		sb.append(getImageUrl());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append(
			"com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>imageId</column-name><column-value><![CDATA[");
		sb.append(getImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageUrl</column-name><column-value><![CDATA[");
		sb.append(getImageUrl());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _imageId;
	private long _categoryId;
	private String _imageUrl;
}