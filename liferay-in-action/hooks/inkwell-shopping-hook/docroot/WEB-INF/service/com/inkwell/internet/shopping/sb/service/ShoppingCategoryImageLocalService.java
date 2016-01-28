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

import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The interface for the shopping category image local service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link ShoppingCategoryImageLocalServiceUtil} to access the shopping category image local service. Add custom service methods to {@link com.inkwell.internet.shopping.sb.service.impl.ShoppingCategoryImageLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Rich Sezov
 * @see ShoppingCategoryImageLocalServiceUtil
 * @see com.inkwell.internet.shopping.sb.service.base.ShoppingCategoryImageLocalServiceBaseImpl
 * @see com.inkwell.internet.shopping.sb.service.impl.ShoppingCategoryImageLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ShoppingCategoryImageLocalService {
	/**
	* Adds the shopping category image to the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingCategoryImage the shopping category image to add
	* @return the shopping category image that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage addShoppingCategoryImage(
		com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage shoppingCategoryImage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new shopping category image with the primary key. Does not add the shopping category image to the database.
	*
	* @param imageId the primary key for the new shopping category image
	* @return the new shopping category image
	*/
	public com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage createShoppingCategoryImage(
		long imageId);

	/**
	* Deletes the shopping category image with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param imageId the primary key of the shopping category image to delete
	* @throws PortalException if a shopping category image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteShoppingCategoryImage(long imageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the shopping category image from the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingCategoryImage the shopping category image to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteShoppingCategoryImage(
		com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage shoppingCategoryImage)
		throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

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
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the shopping category image with the primary key.
	*
	* @param imageId the primary key of the shopping category image to get
	* @return the shopping category image
	* @throws PortalException if a shopping category image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage getShoppingCategoryImage(
		long imageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage> getShoppingCategoryImages(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the number of shopping category images.
	*
	* @return the number of shopping category images
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getShoppingCategoryImagesCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the shopping category image in the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingCategoryImage the shopping category image to update
	* @return the shopping category image that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage updateShoppingCategoryImage(
		com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage shoppingCategoryImage)
		throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets images by the shopping category to which they are linked.
	*
	* @param categoryId
	* @return List of images
	* @throws SystemException
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage getShoppingCategoryImageByCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the whole collection of images resulting from the query.
	*
	* @param categoryId
	* @return
	* @throws SystemException
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage> getShoppingCategoryImagesByCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates an image object in the database.
	*
	* @param image
	* @return
	* @throws SystemException
	*/
	public com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage updateImage(
		com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage image)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* This method can be called to remove an image associated with a
	* ShoppingCategory.
	*
	* @param categoryId
	* @throws SystemException
	*/
	public void deleteImage(long imageId)
		throws com.inkwell.internet.shopping.sb.NoSuchShoppingCategoryImageException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* When a shopping category is deleted, this method can be called to remove all the
	* images that are linked to it.
	*
	* @param categoryId
	* @throws SystemException
	*/
	public void deleteImages(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an empty ShoppingCategoryImage, thereby hiding
	* the implementation from the JSP layer of the app.
	*
	* @return ShoppingCategoryImage
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage getEmptyImage();
}