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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the shopping category image service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link ShoppingCategoryImageUtil} to access the shopping category image persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Rich Sezov
 * @see ShoppingCategoryImagePersistenceImpl
 * @see ShoppingCategoryImageUtil
 * @generated
 */
public interface ShoppingCategoryImagePersistence extends BasePersistence<ShoppingCategoryImage> {
	/**
	* Caches the shopping category image in the entity cache if it is enabled.
	*
	* @param shoppingCategoryImage the shopping category image to cache
	*/
	public void cacheResult(
		com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage shoppingCategoryImage);

	/**
	* Caches the shopping category images in the entity cache if it is enabled.
	*
	* @param shoppingCategoryImages the shopping category images to cache
	*/
	public void cacheResult(
		java.util.List<com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage> shoppingCategoryImages);

	/**
	* Creates a new shopping category image with the primary key. Does not add the shopping category image to the database.
	*
	* @param imageId the primary key for the new shopping category image
	* @return the new shopping category image
	*/
	public com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage create(
		long imageId);

	/**
	* Removes the shopping category image with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param imageId the primary key of the shopping category image to remove
	* @return the shopping category image that was removed
	* @throws com.inkwell.internet.shopping.sb.NoSuchShoppingCategoryImageException if a shopping category image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage remove(
		long imageId)
		throws com.inkwell.internet.shopping.sb.NoSuchShoppingCategoryImageException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage updateImpl(
		com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage shoppingCategoryImage,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the shopping category image with the primary key or throws a {@link com.inkwell.internet.shopping.sb.NoSuchShoppingCategoryImageException} if it could not be found.
	*
	* @param imageId the primary key of the shopping category image to find
	* @return the shopping category image
	* @throws com.inkwell.internet.shopping.sb.NoSuchShoppingCategoryImageException if a shopping category image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage findByPrimaryKey(
		long imageId)
		throws com.inkwell.internet.shopping.sb.NoSuchShoppingCategoryImageException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the shopping category image with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param imageId the primary key of the shopping category image to find
	* @return the shopping category image, or <code>null</code> if a shopping category image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage fetchByPrimaryKey(
		long imageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the shopping category images where categoryId = &#63;.
	*
	* @param categoryId the category id to search with
	* @return the matching shopping category images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage> findByCategoryId(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage> findByCategoryId(
		long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage> findByCategoryId(
		long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage findByCategoryId_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.shopping.sb.NoSuchShoppingCategoryImageException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage findByCategoryId_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.shopping.sb.NoSuchShoppingCategoryImageException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage[] findByCategoryId_PrevAndNext(
		long imageId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.shopping.sb.NoSuchShoppingCategoryImageException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the shopping category images.
	*
	* @return the shopping category images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the shopping category images where categoryId = &#63; from the database.
	*
	* @param categoryId the category id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategoryId(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the shopping category images from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the shopping category images where categoryId = &#63;.
	*
	* @param categoryId the category id to search with
	* @return the number of matching shopping category images
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategoryId(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the shopping category images.
	*
	* @return the number of shopping category images
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}