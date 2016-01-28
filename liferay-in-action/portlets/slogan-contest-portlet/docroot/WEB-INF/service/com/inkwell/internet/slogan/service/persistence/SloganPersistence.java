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

package com.inkwell.internet.slogan.service.persistence;

import com.inkwell.internet.slogan.model.Slogan;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the slogan service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link SloganUtil} to access the slogan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Rich Sezov
 * @see SloganPersistenceImpl
 * @see SloganUtil
 * @generated
 */
public interface SloganPersistence extends BasePersistence<Slogan> {
	/**
	* Caches the slogan in the entity cache if it is enabled.
	*
	* @param slogan the slogan to cache
	*/
	public void cacheResult(com.inkwell.internet.slogan.model.Slogan slogan);

	/**
	* Caches the slogans in the entity cache if it is enabled.
	*
	* @param slogans the slogans to cache
	*/
	public void cacheResult(
		java.util.List<com.inkwell.internet.slogan.model.Slogan> slogans);

	/**
	* Creates a new slogan with the primary key. Does not add the slogan to the database.
	*
	* @param sloganId the primary key for the new slogan
	* @return the new slogan
	*/
	public com.inkwell.internet.slogan.model.Slogan create(long sloganId);

	/**
	* Removes the slogan with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sloganId the primary key of the slogan to remove
	* @return the slogan that was removed
	* @throws com.inkwell.internet.slogan.NoSuchSloganException if a slogan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.slogan.model.Slogan remove(long sloganId)
		throws com.inkwell.internet.slogan.NoSuchSloganException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.inkwell.internet.slogan.model.Slogan updateImpl(
		com.inkwell.internet.slogan.model.Slogan slogan, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the slogan with the primary key or throws a {@link com.inkwell.internet.slogan.NoSuchSloganException} if it could not be found.
	*
	* @param sloganId the primary key of the slogan to find
	* @return the slogan
	* @throws com.inkwell.internet.slogan.NoSuchSloganException if a slogan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.slogan.model.Slogan findByPrimaryKey(
		long sloganId)
		throws com.inkwell.internet.slogan.NoSuchSloganException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the slogan with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param sloganId the primary key of the slogan to find
	* @return the slogan, or <code>null</code> if a slogan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.slogan.model.Slogan fetchByPrimaryKey(
		long sloganId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the slogans where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the matching slogans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.slogan.model.Slogan> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the slogans where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param start the lower bound of the range of slogans to return
	* @param end the upper bound of the range of slogans to return (not inclusive)
	* @return the range of matching slogans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.slogan.model.Slogan> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the slogans where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param start the lower bound of the range of slogans to return
	* @param end the upper bound of the range of slogans to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching slogans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.slogan.model.Slogan> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first slogan in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching slogan
	* @throws com.inkwell.internet.slogan.NoSuchSloganException if a matching slogan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.slogan.model.Slogan findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.slogan.NoSuchSloganException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last slogan in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching slogan
	* @throws com.inkwell.internet.slogan.NoSuchSloganException if a matching slogan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.slogan.model.Slogan findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.slogan.NoSuchSloganException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the slogans before and after the current slogan in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sloganId the primary key of the current slogan
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next slogan
	* @throws com.inkwell.internet.slogan.NoSuchSloganException if a slogan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.slogan.model.Slogan[] findByUuid_PrevAndNext(
		long sloganId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.slogan.NoSuchSloganException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the slogan where uuid = &#63; and groupId = &#63; or throws a {@link com.inkwell.internet.slogan.NoSuchSloganException} if it could not be found.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @return the matching slogan
	* @throws com.inkwell.internet.slogan.NoSuchSloganException if a matching slogan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.slogan.model.Slogan findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.inkwell.internet.slogan.NoSuchSloganException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the slogan where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @return the matching slogan, or <code>null</code> if a matching slogan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.slogan.model.Slogan fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the slogan where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @return the matching slogan, or <code>null</code> if a matching slogan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.slogan.model.Slogan fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the slogans where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching slogans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.slogan.model.Slogan> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the slogans where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of slogans to return
	* @param end the upper bound of the range of slogans to return (not inclusive)
	* @return the range of matching slogans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.slogan.model.Slogan> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the slogans where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of slogans to return
	* @param end the upper bound of the range of slogans to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching slogans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.slogan.model.Slogan> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first slogan in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching slogan
	* @throws com.inkwell.internet.slogan.NoSuchSloganException if a matching slogan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.slogan.model.Slogan findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.slogan.NoSuchSloganException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last slogan in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching slogan
	* @throws com.inkwell.internet.slogan.NoSuchSloganException if a matching slogan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.slogan.model.Slogan findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.slogan.NoSuchSloganException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the slogans before and after the current slogan in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sloganId the primary key of the current slogan
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next slogan
	* @throws com.inkwell.internet.slogan.NoSuchSloganException if a slogan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.slogan.model.Slogan[] findByGroupId_PrevAndNext(
		long sloganId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.slogan.NoSuchSloganException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds all the slogans where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching slogans that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.slogan.model.Slogan> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds a range of all the slogans where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of slogans to return
	* @param end the upper bound of the range of slogans to return (not inclusive)
	* @return the range of matching slogans that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.slogan.model.Slogan> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds an ordered range of all the slogans where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of slogans to return
	* @param end the upper bound of the range of slogans to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching slogans that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.slogan.model.Slogan> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the slogans where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the matching slogans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.slogan.model.Slogan> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the slogans where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of slogans to return
	* @param end the upper bound of the range of slogans to return (not inclusive)
	* @return the range of matching slogans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.slogan.model.Slogan> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the slogans where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of slogans to return
	* @param end the upper bound of the range of slogans to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching slogans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.slogan.model.Slogan> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first slogan in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching slogan
	* @throws com.inkwell.internet.slogan.NoSuchSloganException if a matching slogan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.slogan.model.Slogan findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.slogan.NoSuchSloganException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last slogan in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching slogan
	* @throws com.inkwell.internet.slogan.NoSuchSloganException if a matching slogan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.slogan.model.Slogan findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.slogan.NoSuchSloganException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the slogans before and after the current slogan in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sloganId the primary key of the current slogan
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next slogan
	* @throws com.inkwell.internet.slogan.NoSuchSloganException if a slogan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.slogan.model.Slogan[] findByCompanyId_PrevAndNext(
		long sloganId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.slogan.NoSuchSloganException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the slogans where sloganText = &#63;.
	*
	* @param sloganText the slogan text to search with
	* @return the matching slogans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.slogan.model.Slogan> findBySloganText(
		java.lang.String sloganText)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the slogans where sloganText = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sloganText the slogan text to search with
	* @param start the lower bound of the range of slogans to return
	* @param end the upper bound of the range of slogans to return (not inclusive)
	* @return the range of matching slogans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.slogan.model.Slogan> findBySloganText(
		java.lang.String sloganText, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the slogans where sloganText = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sloganText the slogan text to search with
	* @param start the lower bound of the range of slogans to return
	* @param end the upper bound of the range of slogans to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching slogans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.slogan.model.Slogan> findBySloganText(
		java.lang.String sloganText, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first slogan in the ordered set where sloganText = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sloganText the slogan text to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching slogan
	* @throws com.inkwell.internet.slogan.NoSuchSloganException if a matching slogan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.slogan.model.Slogan findBySloganText_First(
		java.lang.String sloganText,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.slogan.NoSuchSloganException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last slogan in the ordered set where sloganText = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sloganText the slogan text to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching slogan
	* @throws com.inkwell.internet.slogan.NoSuchSloganException if a matching slogan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.slogan.model.Slogan findBySloganText_Last(
		java.lang.String sloganText,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.slogan.NoSuchSloganException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the slogans before and after the current slogan in the ordered set where sloganText = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sloganId the primary key of the current slogan
	* @param sloganText the slogan text to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next slogan
	* @throws com.inkwell.internet.slogan.NoSuchSloganException if a slogan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.slogan.model.Slogan[] findBySloganText_PrevAndNext(
		long sloganId, java.lang.String sloganText,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.slogan.NoSuchSloganException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the slogans where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @return the matching slogans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.slogan.model.Slogan> findByG_S(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the slogans where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of slogans to return
	* @param end the upper bound of the range of slogans to return (not inclusive)
	* @return the range of matching slogans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.slogan.model.Slogan> findByG_S(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the slogans where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of slogans to return
	* @param end the upper bound of the range of slogans to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching slogans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.slogan.model.Slogan> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first slogan in the ordered set where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching slogan
	* @throws com.inkwell.internet.slogan.NoSuchSloganException if a matching slogan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.slogan.model.Slogan findByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.slogan.NoSuchSloganException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last slogan in the ordered set where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching slogan
	* @throws com.inkwell.internet.slogan.NoSuchSloganException if a matching slogan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.slogan.model.Slogan findByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.slogan.NoSuchSloganException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the slogans before and after the current slogan in the ordered set where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sloganId the primary key of the current slogan
	* @param groupId the group id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next slogan
	* @throws com.inkwell.internet.slogan.NoSuchSloganException if a slogan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.slogan.model.Slogan[] findByG_S_PrevAndNext(
		long sloganId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.slogan.NoSuchSloganException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds all the slogans where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @return the matching slogans that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.slogan.model.Slogan> filterFindByG_S(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds a range of all the slogans where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of slogans to return
	* @param end the upper bound of the range of slogans to return (not inclusive)
	* @return the range of matching slogans that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.slogan.model.Slogan> filterFindByG_S(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds an ordered range of all the slogans where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of slogans to return
	* @param end the upper bound of the range of slogans to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching slogans that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.slogan.model.Slogan> filterFindByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the slogans.
	*
	* @return the slogans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.slogan.model.Slogan> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the slogans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of slogans to return
	* @param end the upper bound of the range of slogans to return (not inclusive)
	* @return the range of slogans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.slogan.model.Slogan> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the slogans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of slogans to return
	* @param end the upper bound of the range of slogans to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of slogans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.slogan.model.Slogan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the slogans where uuid = &#63; from the database.
	*
	* @param uuid the uuid to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the slogan where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.inkwell.internet.slogan.NoSuchSloganException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the slogans where groupId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the slogans where companyId = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the slogans where sloganText = &#63; from the database.
	*
	* @param sloganText the slogan text to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySloganText(java.lang.String sloganText)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the slogans where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_S(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the slogans from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the slogans where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the number of matching slogans
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the slogans where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @return the number of matching slogans
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the slogans where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching slogans
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and counts all the slogans where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching slogans that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the slogans where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the number of matching slogans
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the slogans where sloganText = &#63;.
	*
	* @param sloganText the slogan text to search with
	* @return the number of matching slogans
	* @throws SystemException if a system exception occurred
	*/
	public int countBySloganText(java.lang.String sloganText)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the slogans where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @return the number of matching slogans
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_S(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and counts all the slogans where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @return the number of matching slogans that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_S(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the slogans.
	*
	* @return the number of slogans
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}