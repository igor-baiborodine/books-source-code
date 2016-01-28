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

/**
 * <p>
 * This class is a wrapper for {@link ShoppingCategoryImage}.
 * </p>
 *
 * @author    Rich Sezov
 * @see       ShoppingCategoryImage
 * @generated
 */
public class ShoppingCategoryImageWrapper implements ShoppingCategoryImage {
	public ShoppingCategoryImageWrapper(
		ShoppingCategoryImage shoppingCategoryImage) {
		_shoppingCategoryImage = shoppingCategoryImage;
	}

	public long getPrimaryKey() {
		return _shoppingCategoryImage.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_shoppingCategoryImage.setPrimaryKey(pk);
	}

	public long getImageId() {
		return _shoppingCategoryImage.getImageId();
	}

	public void setImageId(long imageId) {
		_shoppingCategoryImage.setImageId(imageId);
	}

	public long getCategoryId() {
		return _shoppingCategoryImage.getCategoryId();
	}

	public void setCategoryId(long categoryId) {
		_shoppingCategoryImage.setCategoryId(categoryId);
	}

	public java.lang.String getImageUrl() {
		return _shoppingCategoryImage.getImageUrl();
	}

	public void setImageUrl(java.lang.String imageUrl) {
		_shoppingCategoryImage.setImageUrl(imageUrl);
	}

	public com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage toEscapedModel() {
		return _shoppingCategoryImage.toEscapedModel();
	}

	public boolean isNew() {
		return _shoppingCategoryImage.isNew();
	}

	public void setNew(boolean n) {
		_shoppingCategoryImage.setNew(n);
	}

	public boolean isCachedModel() {
		return _shoppingCategoryImage.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_shoppingCategoryImage.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _shoppingCategoryImage.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_shoppingCategoryImage.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _shoppingCategoryImage.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _shoppingCategoryImage.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_shoppingCategoryImage.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _shoppingCategoryImage.clone();
	}

	public int compareTo(
		com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage shoppingCategoryImage) {
		return _shoppingCategoryImage.compareTo(shoppingCategoryImage);
	}

	public int hashCode() {
		return _shoppingCategoryImage.hashCode();
	}

	public java.lang.String toString() {
		return _shoppingCategoryImage.toString();
	}

	public java.lang.String toXmlString() {
		return _shoppingCategoryImage.toXmlString();
	}

	public ShoppingCategoryImage getWrappedShoppingCategoryImage() {
		return _shoppingCategoryImage;
	}

	private ShoppingCategoryImage _shoppingCategoryImage;
}