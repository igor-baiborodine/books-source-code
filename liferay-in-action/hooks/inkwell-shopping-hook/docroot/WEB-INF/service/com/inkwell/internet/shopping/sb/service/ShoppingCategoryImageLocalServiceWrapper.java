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

/**
 * <p>
 * This class is a wrapper for {@link ShoppingCategoryImageLocalService}.
 * </p>
 *
 * @author    Rich Sezov
 * @see       ShoppingCategoryImageLocalService
 * @generated
 */
public class ShoppingCategoryImageLocalServiceWrapper
	implements ShoppingCategoryImageLocalService {
	public ShoppingCategoryImageLocalServiceWrapper(
		ShoppingCategoryImageLocalService shoppingCategoryImageLocalService) {
		_shoppingCategoryImageLocalService = shoppingCategoryImageLocalService;
	}

	/**
	* Adds the shopping category image to the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingCategoryImage the shopping category image to add
	* @return the shopping category image that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage addShoppingCategoryImage(
		com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage shoppingCategoryImage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryImageLocalService.addShoppingCategoryImage(shoppingCategoryImage);
	}

	/**
	* Creates a new shopping category image with the primary key. Does not add the shopping category image to the database.
	*
	* @param imageId the primary key for the new shopping category image
	* @return the new shopping category image
	*/
	public com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage createShoppingCategoryImage(
		long imageId) {
		return _shoppingCategoryImageLocalService.createShoppingCategoryImage(imageId);
	}

	/**
	* Deletes the shopping category image with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param imageId the primary key of the shopping category image to delete
	* @throws PortalException if a shopping category image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteShoppingCategoryImage(long imageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_shoppingCategoryImageLocalService.deleteShoppingCategoryImage(imageId);
	}

	/**
	* Deletes the shopping category image from the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingCategoryImage the shopping category image to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteShoppingCategoryImage(
		com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage shoppingCategoryImage)
		throws com.liferay.portal.kernel.exception.SystemException {
		_shoppingCategoryImageLocalService.deleteShoppingCategoryImage(shoppingCategoryImage);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryImageLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryImageLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryImageLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryImageLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the shopping category image with the primary key.
	*
	* @param imageId the primary key of the shopping category image to get
	* @return the shopping category image
	* @throws PortalException if a shopping category image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage getShoppingCategoryImage(
		long imageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryImageLocalService.getShoppingCategoryImage(imageId);
	}

	/**
	* Gets a range of all the shopping category images.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of shopping category images to return
	* @param end the upper bound of the range of shopping category images to return (not inclusive)
	* @return the range of shopping category images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage> getShoppingCategoryImages(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryImageLocalService.getShoppingCategoryImages(start,
			end);
	}

	/**
	* Gets the number of shopping category images.
	*
	* @return the number of shopping category images
	* @throws SystemException if a system exception occurred
	*/
	public int getShoppingCategoryImagesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryImageLocalService.getShoppingCategoryImagesCount();
	}

	/**
	* Updates the shopping category image in the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingCategoryImage the shopping category image to update
	* @return the shopping category image that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage updateShoppingCategoryImage(
		com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage shoppingCategoryImage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryImageLocalService.updateShoppingCategoryImage(shoppingCategoryImage);
	}

	/**
	* Updates the shopping category image in the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingCategoryImage the shopping category image to update
	* @param merge whether to merge the shopping category image with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the shopping category image that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage updateShoppingCategoryImage(
		com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage shoppingCategoryImage,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryImageLocalService.updateShoppingCategoryImage(shoppingCategoryImage,
			merge);
	}

	/**
	* Creates a new ShoppingCategoryImage in the database.
	*
	* @param categoryId
	* @param url
	* @return ShoppingCategoryImage
	* @throws com.liferay.portal.kernel.exception.SystemException
	*/
	public com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage addShoppingCategoryImage(
		long categoryId, java.lang.String url)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryImageLocalService.addShoppingCategoryImage(categoryId,
			url);
	}

	/**
	* Gets images by the shopping category to which they are linked.
	*
	* @param categoryId
	* @return List of images
	* @throws SystemException
	*/
	public com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage getShoppingCategoryImageByCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryImageLocalService.getShoppingCategoryImageByCategory(categoryId);
	}

	/**
	* Gets the whole collection of images resulting from the query.
	*
	* @param categoryId
	* @return
	* @throws SystemException
	*/
	public java.util.List<com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage> getShoppingCategoryImagesByCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryImageLocalService.getShoppingCategoryImagesByCategory(categoryId);
	}

	/**
	* Updates an image object in the database.
	*
	* @param image
	* @return
	* @throws SystemException
	*/
	public com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage updateImage(
		com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage image)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryImageLocalService.updateImage(image);
	}

	/**
	* This method can be called to remove an image associated with a
	* ShoppingCategory.
	*
	* @param categoryId
	* @throws SystemException
	*/
	public void deleteImage(long imageId)
		throws com.inkwell.internet.shopping.sb.NoSuchShoppingCategoryImageException,
			com.liferay.portal.kernel.exception.SystemException {
		_shoppingCategoryImageLocalService.deleteImage(imageId);
	}

	/**
	* When a shopping category is deleted, this method can be called to remove all the
	* images that are linked to it.
	*
	* @param categoryId
	* @throws SystemException
	*/
	public void deleteImages(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_shoppingCategoryImageLocalService.deleteImages(categoryId);
	}

	/**
	* Returns an empty ShoppingCategoryImage, thereby hiding
	* the implementation from the JSP layer of the app.
	*
	* @return ShoppingCategoryImage
	*/
	public com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage getEmptyImage() {
		return _shoppingCategoryImageLocalService.getEmptyImage();
	}

	public ShoppingCategoryImageLocalService getWrappedShoppingCategoryImageLocalService() {
		return _shoppingCategoryImageLocalService;
	}

	private ShoppingCategoryImageLocalService _shoppingCategoryImageLocalService;
}