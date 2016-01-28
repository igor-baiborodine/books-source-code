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

package com.inkwell.internet.shopping.sb.service.persistence;

import com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the shopping category image service. This utility wraps {@link ShoppingCategoryImagePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Rich Sezov
 * @see ShoppingCategoryImagePersistence
 * @see ShoppingCategoryImagePersistenceImpl
 * @generated
 */
public class ShoppingCategoryImageUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(ShoppingCategoryImage shoppingCategoryImage) {
		getPersistence().clearCache(shoppingCategoryImage);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ShoppingCategoryImage> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ShoppingCategoryImage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ShoppingCategoryImage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static ShoppingCategoryImage remove(
		ShoppingCategoryImage shoppingCategoryImage) throws SystemException {
		return getPersistence().remove(shoppingCategoryImage);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ShoppingCategoryImage update(
		ShoppingCategoryImage shoppingCategoryImage, boolean merge)
		throws SystemException {
		return getPersistence().update(shoppingCategoryImage, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ShoppingCategoryImage update(
		ShoppingCategoryImage shoppingCategoryImage, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(shoppingCategoryImage, merge, serviceContext);
	}

	/**
	* Caches the shopping category image in the entity cache if it is enabled.
	*
	* @param shoppingCategoryImage the shopping category image to cache
	*/
	public static void cacheResult(
		com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage shoppingCategoryImage) {
		getPersistence().cacheResult(shoppingCategoryImage);
	}

	/**
	* Caches the shopping category images in the entity cache if it is enabled.
	*
	* @param shoppingCategoryImages the shopping category images to cache
	*/
	public static void cacheResult(
		java.util.List<com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage> shoppingCategoryImages) {
		getPersistence().cacheResult(shoppingCategoryImages);
	}

	/**
	* Creates a new shopping category image with the primary key. Does not add the shopping category image to the database.
	*
	* @param imageId the primary key for the new shopping category image
	* @return the new shopping category image
	*/
	public static com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage create(
		long imageId) {
		return getPersistence().create(imageId);
	}

	/**
	* Removes the shopping category image with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param imageId the primary key of the shopping category image to remove
	* @return the shopping category image that was removed
	* @throws com.inkwell.internet.shopping.sb.NoSuchShoppingCategoryImageException if a shopping category image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage remove(
		long imageId)
		throws com.inkwell.internet.shopping.sb.NoSuchShoppingCategoryImageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(imageId);
	}

	public static com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage updateImpl(
		com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage shoppingCategoryImage,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(shoppingCategoryImage, merge);
	}

	/**
	* Finds the shopping category image with the primary key or throws a {@link com.inkwell.internet.shopping.sb.NoSuchShoppingCategoryImageException} if it could not be found.
	*
	* @param imageId the primary key of the shopping category image to find
	* @return the shopping category image
	* @throws com.inkwell.internet.shopping.sb.NoSuchShoppingCategoryImageException if a shopping category image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage findByPrimaryKey(
		long imageId)
		throws com.inkwell.internet.shopping.sb.NoSuchShoppingCategoryImageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(imageId);
	}

	/**
	* Finds the shopping category image with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param imageId the primary key of the shopping category image to find
	* @return the shopping category image, or <code>null</code> if a shopping category image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage fetchByPrimaryKey(
		long imageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(imageId);
	}

	/**
	* Finds all the shopping category images where categoryId = &#63;.
	*
	* @param categoryId the category id to search with
	* @return the matching shopping category images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage> findByCategoryId(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategoryId(categoryId);
	}

	/**
	* Finds a range of all the shopping category images where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category id to search with
	* @param start the lower bound of the range of shopping category images to return
	* @param end the upper bound of the range of shopping category images to return (not inclusive)
	* @return the range of matching shopping category images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage> findByCategoryId(
		long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategoryId(categoryId, start, end);
	}

	/**
	* Finds an ordered range of all the shopping category images where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category id to search with
	* @param start the lower bound of the range of shopping category images to return
	* @param end the upper bound of the range of shopping category images to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching shopping category images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage> findByCategoryId(
		long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryId(categoryId, start, end, orderByComparator);
	}

	/**
	* Finds the first shopping category image in the ordered set where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching shopping category image
	* @throws com.inkwell.internet.shopping.sb.NoSuchShoppingCategoryImageException if a matching shopping category image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage findByCategoryId_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.shopping.sb.NoSuchShoppingCategoryImageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryId_First(categoryId, orderByComparator);
	}

	/**
	* Finds the last shopping category image in the ordered set where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching shopping category image
	* @throws com.inkwell.internet.shopping.sb.NoSuchShoppingCategoryImageException if a matching shopping category image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage findByCategoryId_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.shopping.sb.NoSuchShoppingCategoryImageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryId_Last(categoryId, orderByComparator);
	}

	/**
	* Finds the shopping category images before and after the current shopping category image in the ordered set where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param imageId the primary key of the current shopping category image
	* @param categoryId the category id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next shopping category image
	* @throws com.inkwell.internet.shopping.sb.NoSuchShoppingCategoryImageException if a shopping category image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage[] findByCategoryId_PrevAndNext(
		long imageId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.shopping.sb.NoSuchShoppingCategoryImageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryId_PrevAndNext(imageId, categoryId,
			orderByComparator);
	}

	/**
	* Finds all the shopping category images.
	*
	* @return the shopping category images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the shopping category images.
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
	public static java.util.List<com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the shopping category images.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of shopping category images to return
	* @param end the upper bound of the range of shopping category images to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of shopping category images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the shopping category images where categoryId = &#63; from the database.
	*
	* @param categoryId the category id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategoryId(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCategoryId(categoryId);
	}

	/**
	* Removes all the shopping category images from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the shopping category images where categoryId = &#63;.
	*
	* @param categoryId the category id to search with
	* @return the number of matching shopping category images
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategoryId(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCategoryId(categoryId);
	}

	/**
	* Counts all the shopping category images.
	*
	* @return the number of shopping category images
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ShoppingCategoryImagePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ShoppingCategoryImagePersistence)PortletBeanLocatorUtil.locate(com.inkwell.internet.shopping.sb.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					ShoppingCategoryImagePersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(ShoppingCategoryImagePersistence persistence) {
		_persistence = persistence;
	}

	private static ShoppingCategoryImagePersistence _persistence;
}