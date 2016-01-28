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

package com.inkwell.internet.shopping.sb.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author Rich Sezov
 */
public class ShoppingCategoryImageLocalServiceClp
	implements ShoppingCategoryImageLocalService {
	public ShoppingCategoryImageLocalServiceClp(
		ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addShoppingCategoryImageMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addShoppingCategoryImage",
				com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage.class);

		_createShoppingCategoryImageMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"createShoppingCategoryImage", long.class);

		_deleteShoppingCategoryImageMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteShoppingCategoryImage", long.class);

		_deleteShoppingCategoryImageMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteShoppingCategoryImage",
				com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage.class);

		_dynamicQueryMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class);

		_dynamicQueryMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class,
				int.class, int.class);

		_dynamicQueryMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class,
				int.class, int.class,
				com.liferay.portal.kernel.util.OrderByComparator.class);

		_dynamicQueryCountMethodKey7 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQueryCount",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class);

		_getShoppingCategoryImageMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"getShoppingCategoryImage", long.class);

		_getShoppingCategoryImagesMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getShoppingCategoryImages", int.class, int.class);

		_getShoppingCategoryImagesCountMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getShoppingCategoryImagesCount");

		_updateShoppingCategoryImageMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateShoppingCategoryImage",
				com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage.class);

		_updateShoppingCategoryImageMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateShoppingCategoryImage",
				com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage.class,
				boolean.class);

		_addShoppingCategoryImageMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"addShoppingCategoryImage", long.class, java.lang.String.class);

		_getShoppingCategoryImageByCategoryMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"getShoppingCategoryImageByCategory", long.class);

		_getShoppingCategoryImagesByCategoryMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"getShoppingCategoryImagesByCategory", long.class);

		_updateImageMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateImage",
				com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage.class);

		_deleteImageMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteImage", long.class);

		_deleteImagesMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteImages", long.class);

		_getEmptyImageMethodKey19 = new MethodKey(_classLoaderProxy.getClassName(),
				"getEmptyImage");
	}

	public com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage addShoppingCategoryImage(
		com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage shoppingCategoryImage)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addShoppingCategoryImageMethodKey0,
				shoppingCategoryImage);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage)ClpSerializer.translateOutput(returnObj);
	}

	public com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage createShoppingCategoryImage(
		long imageId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createShoppingCategoryImageMethodKey1,
				imageId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteShoppingCategoryImage(long imageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteShoppingCategoryImageMethodKey2,
				imageId);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void deleteShoppingCategoryImage(
		com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage shoppingCategoryImage)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteShoppingCategoryImageMethodKey3,
				shoppingCategoryImage);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey4,
				dynamicQuery);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey5,
				dynamicQuery, start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey6,
				dynamicQuery, start, end, orderByComparator);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryCountMethodKey7,
				dynamicQuery);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	public com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage getShoppingCategoryImage(
		long imageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getShoppingCategoryImageMethodKey8,
				imageId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage> getShoppingCategoryImages(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getShoppingCategoryImagesMethodKey9,
				start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage>)ClpSerializer.translateOutput(returnObj);
	}

	public int getShoppingCategoryImagesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getShoppingCategoryImagesCountMethodKey10);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage updateShoppingCategoryImage(
		com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage shoppingCategoryImage)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateShoppingCategoryImageMethodKey11,
				shoppingCategoryImage);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage)ClpSerializer.translateOutput(returnObj);
	}

	public com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage updateShoppingCategoryImage(
		com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage shoppingCategoryImage,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateShoppingCategoryImageMethodKey12,
				shoppingCategoryImage, merge);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage)ClpSerializer.translateOutput(returnObj);
	}

	public com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage addShoppingCategoryImage(
		long categoryId, java.lang.String url)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addShoppingCategoryImageMethodKey13,
				categoryId, url);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage)ClpSerializer.translateOutput(returnObj);
	}

	public com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage getShoppingCategoryImageByCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getShoppingCategoryImageByCategoryMethodKey14,
				categoryId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage> getShoppingCategoryImagesByCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getShoppingCategoryImagesByCategoryMethodKey15,
				categoryId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage>)ClpSerializer.translateOutput(returnObj);
	}

	public com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage updateImage(
		com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage image)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateImageMethodKey16,
				image);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteImage(long imageId)
		throws com.inkwell.internet.shopping.sb.NoSuchShoppingCategoryImageException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteImageMethodKey17,
				imageId);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.inkwell.internet.shopping.sb.NoSuchShoppingCategoryImageException) {
				throw (com.inkwell.internet.shopping.sb.NoSuchShoppingCategoryImageException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void deleteImages(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteImagesMethodKey18,
				categoryId);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage getEmptyImage() {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getEmptyImageMethodKey19);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addShoppingCategoryImageMethodKey0;
	private MethodKey _createShoppingCategoryImageMethodKey1;
	private MethodKey _deleteShoppingCategoryImageMethodKey2;
	private MethodKey _deleteShoppingCategoryImageMethodKey3;
	private MethodKey _dynamicQueryMethodKey4;
	private MethodKey _dynamicQueryMethodKey5;
	private MethodKey _dynamicQueryMethodKey6;
	private MethodKey _dynamicQueryCountMethodKey7;
	private MethodKey _getShoppingCategoryImageMethodKey8;
	private MethodKey _getShoppingCategoryImagesMethodKey9;
	private MethodKey _getShoppingCategoryImagesCountMethodKey10;
	private MethodKey _updateShoppingCategoryImageMethodKey11;
	private MethodKey _updateShoppingCategoryImageMethodKey12;
	private MethodKey _addShoppingCategoryImageMethodKey13;
	private MethodKey _getShoppingCategoryImageByCategoryMethodKey14;
	private MethodKey _getShoppingCategoryImagesByCategoryMethodKey15;
	private MethodKey _updateImageMethodKey16;
	private MethodKey _deleteImageMethodKey17;
	private MethodKey _deleteImagesMethodKey18;
	private MethodKey _getEmptyImageMethodKey19;
}