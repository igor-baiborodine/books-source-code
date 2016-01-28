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

package com.inkwell.internet.productregistration.service.persistence;

import com.inkwell.internet.productregistration.model.PRUser;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the p r user service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link PRUserUtil} to access the p r user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Rich Sezov
 * @see PRUserPersistenceImpl
 * @see PRUserUtil
 * @generated
 */
public interface PRUserPersistence extends BasePersistence<PRUser> {
	/**
	* Caches the p r user in the entity cache if it is enabled.
	*
	* @param prUser the p r user to cache
	*/
	public void cacheResult(
		com.inkwell.internet.productregistration.model.PRUser prUser);

	/**
	* Caches the p r users in the entity cache if it is enabled.
	*
	* @param prUsers the p r users to cache
	*/
	public void cacheResult(
		java.util.List<com.inkwell.internet.productregistration.model.PRUser> prUsers);

	/**
	* Creates a new p r user with the primary key. Does not add the p r user to the database.
	*
	* @param prUserId the primary key for the new p r user
	* @return the new p r user
	*/
	public com.inkwell.internet.productregistration.model.PRUser create(
		long prUserId);

	/**
	* Removes the p r user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param prUserId the primary key of the p r user to remove
	* @return the p r user that was removed
	* @throws com.inkwell.internet.productregistration.NoSuchUserException if a p r user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRUser remove(
		long prUserId)
		throws com.inkwell.internet.productregistration.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.inkwell.internet.productregistration.model.PRUser updateImpl(
		com.inkwell.internet.productregistration.model.PRUser prUser,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the p r user with the primary key or throws a {@link com.inkwell.internet.productregistration.NoSuchUserException} if it could not be found.
	*
	* @param prUserId the primary key of the p r user to find
	* @return the p r user
	* @throws com.inkwell.internet.productregistration.NoSuchUserException if a p r user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRUser findByPrimaryKey(
		long prUserId)
		throws com.inkwell.internet.productregistration.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the p r user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param prUserId the primary key of the p r user to find
	* @return the p r user, or <code>null</code> if a p r user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRUser fetchByPrimaryKey(
		long prUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the p r users where groupId = &#63; and lastName = &#63;.
	*
	* @param groupId the group id to search with
	* @param lastName the last name to search with
	* @return the matching p r users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> findByG_LN(
		long groupId, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the p r users where groupId = &#63; and lastName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param lastName the last name to search with
	* @param start the lower bound of the range of p r users to return
	* @param end the upper bound of the range of p r users to return (not inclusive)
	* @return the range of matching p r users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> findByG_LN(
		long groupId, java.lang.String lastName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the p r users where groupId = &#63; and lastName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param lastName the last name to search with
	* @param start the lower bound of the range of p r users to return
	* @param end the upper bound of the range of p r users to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching p r users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> findByG_LN(
		long groupId, java.lang.String lastName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first p r user in the ordered set where groupId = &#63; and lastName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param lastName the last name to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching p r user
	* @throws com.inkwell.internet.productregistration.NoSuchUserException if a matching p r user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRUser findByG_LN_First(
		long groupId, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last p r user in the ordered set where groupId = &#63; and lastName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param lastName the last name to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching p r user
	* @throws com.inkwell.internet.productregistration.NoSuchUserException if a matching p r user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRUser findByG_LN_Last(
		long groupId, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the p r users before and after the current p r user in the ordered set where groupId = &#63; and lastName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param prUserId the primary key of the current p r user
	* @param groupId the group id to search with
	* @param lastName the last name to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next p r user
	* @throws com.inkwell.internet.productregistration.NoSuchUserException if a p r user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRUser[] findByG_LN_PrevAndNext(
		long prUserId, long groupId, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds all the p r users where groupId = &#63; and lastName = &#63;.
	*
	* @param groupId the group id to search with
	* @param lastName the last name to search with
	* @return the matching p r users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> filterFindByG_LN(
		long groupId, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds a range of all the p r users where groupId = &#63; and lastName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param lastName the last name to search with
	* @param start the lower bound of the range of p r users to return
	* @param end the upper bound of the range of p r users to return (not inclusive)
	* @return the range of matching p r users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> filterFindByG_LN(
		long groupId, java.lang.String lastName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds an ordered range of all the p r users where groupId = &#63; and lastName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param lastName the last name to search with
	* @param start the lower bound of the range of p r users to return
	* @param end the upper bound of the range of p r users to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching p r users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> filterFindByG_LN(
		long groupId, java.lang.String lastName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the p r users where groupId = &#63; and email = &#63;.
	*
	* @param groupId the group id to search with
	* @param email the email to search with
	* @return the matching p r users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> findByG_E(
		long groupId, java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the p r users where groupId = &#63; and email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param email the email to search with
	* @param start the lower bound of the range of p r users to return
	* @param end the upper bound of the range of p r users to return (not inclusive)
	* @return the range of matching p r users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> findByG_E(
		long groupId, java.lang.String email, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the p r users where groupId = &#63; and email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param email the email to search with
	* @param start the lower bound of the range of p r users to return
	* @param end the upper bound of the range of p r users to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching p r users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> findByG_E(
		long groupId, java.lang.String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first p r user in the ordered set where groupId = &#63; and email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param email the email to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching p r user
	* @throws com.inkwell.internet.productregistration.NoSuchUserException if a matching p r user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRUser findByG_E_First(
		long groupId, java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last p r user in the ordered set where groupId = &#63; and email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param email the email to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching p r user
	* @throws com.inkwell.internet.productregistration.NoSuchUserException if a matching p r user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRUser findByG_E_Last(
		long groupId, java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the p r users before and after the current p r user in the ordered set where groupId = &#63; and email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param prUserId the primary key of the current p r user
	* @param groupId the group id to search with
	* @param email the email to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next p r user
	* @throws com.inkwell.internet.productregistration.NoSuchUserException if a p r user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRUser[] findByG_E_PrevAndNext(
		long prUserId, long groupId, java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds all the p r users where groupId = &#63; and email = &#63;.
	*
	* @param groupId the group id to search with
	* @param email the email to search with
	* @return the matching p r users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> filterFindByG_E(
		long groupId, java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds a range of all the p r users where groupId = &#63; and email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param email the email to search with
	* @param start the lower bound of the range of p r users to return
	* @param end the upper bound of the range of p r users to return (not inclusive)
	* @return the range of matching p r users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> filterFindByG_E(
		long groupId, java.lang.String email, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds an ordered range of all the p r users where groupId = &#63; and email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param email the email to search with
	* @param start the lower bound of the range of p r users to return
	* @param end the upper bound of the range of p r users to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching p r users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> filterFindByG_E(
		long groupId, java.lang.String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the p r users where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @return the matching p r users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> findByG_U(
		long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the p r users where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param start the lower bound of the range of p r users to return
	* @param end the upper bound of the range of p r users to return (not inclusive)
	* @return the range of matching p r users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> findByG_U(
		long groupId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the p r users where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param start the lower bound of the range of p r users to return
	* @param end the upper bound of the range of p r users to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching p r users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> findByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first p r user in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching p r user
	* @throws com.inkwell.internet.productregistration.NoSuchUserException if a matching p r user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRUser findByG_U_First(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last p r user in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching p r user
	* @throws com.inkwell.internet.productregistration.NoSuchUserException if a matching p r user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRUser findByG_U_Last(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the p r users before and after the current p r user in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param prUserId the primary key of the current p r user
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next p r user
	* @throws com.inkwell.internet.productregistration.NoSuchUserException if a p r user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRUser[] findByG_U_PrevAndNext(
		long prUserId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds all the p r users where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @return the matching p r users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> filterFindByG_U(
		long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds a range of all the p r users where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param start the lower bound of the range of p r users to return
	* @param end the upper bound of the range of p r users to return (not inclusive)
	* @return the range of matching p r users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> filterFindByG_U(
		long groupId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds an ordered range of all the p r users where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param start the lower bound of the range of p r users to return
	* @param end the upper bound of the range of p r users to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching p r users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> filterFindByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the p r users.
	*
	* @return the p r users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the p r users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of p r users to return
	* @param end the upper bound of the range of p r users to return (not inclusive)
	* @return the range of p r users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the p r users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of p r users to return
	* @param end the upper bound of the range of p r users to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of p r users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the p r users where groupId = &#63; and lastName = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param lastName the last name to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_LN(long groupId, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the p r users where groupId = &#63; and email = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param email the email to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_E(long groupId, java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the p r users where groupId = &#63; and userId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_U(long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the p r users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the p r users where groupId = &#63; and lastName = &#63;.
	*
	* @param groupId the group id to search with
	* @param lastName the last name to search with
	* @return the number of matching p r users
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_LN(long groupId, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and counts all the p r users where groupId = &#63; and lastName = &#63;.
	*
	* @param groupId the group id to search with
	* @param lastName the last name to search with
	* @return the number of matching p r users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_LN(long groupId, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the p r users where groupId = &#63; and email = &#63;.
	*
	* @param groupId the group id to search with
	* @param email the email to search with
	* @return the number of matching p r users
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_E(long groupId, java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and counts all the p r users where groupId = &#63; and email = &#63;.
	*
	* @param groupId the group id to search with
	* @param email the email to search with
	* @return the number of matching p r users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_E(long groupId, java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the p r users where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @return the number of matching p r users
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_U(long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and counts all the p r users where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @return the number of matching p r users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_U(long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the p r users.
	*
	* @return the number of p r users
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets all the p r registrations associated with the p r user.
	*
	* @param pk the primary key of the p r user to get the associated p r registrations for
	* @return the p r registrations associated with the p r user
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> getPRRegistrations(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets a range of all the p r registrations associated with the p r user.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the p r user to get the associated p r registrations for
	* @param start the lower bound of the range of p r users to return
	* @param end the upper bound of the range of p r users to return (not inclusive)
	* @return the range of p r registrations associated with the p r user
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> getPRRegistrations(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets an ordered range of all the p r registrations associated with the p r user.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the p r user to get the associated p r registrations for
	* @param start the lower bound of the range of p r users to return
	* @param end the upper bound of the range of p r users to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of p r registrations associated with the p r user
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> getPRRegistrations(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the number of p r registrations associated with the p r user.
	*
	* @param pk the primary key of the p r user to get the number of associated p r registrations for
	* @return the number of p r registrations associated with the p r user
	* @throws SystemException if a system exception occurred
	*/
	public int getPRRegistrationsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Determines if the p r registration is associated with the p r user.
	*
	* @param pk the primary key of the p r user
	* @param prRegistrationPK the primary key of the p r registration
	* @return <code>true</code> if the p r registration is associated with the p r user; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsPRRegistration(long pk, long prRegistrationPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Determines if the p r user has any p r registrations associated with it.
	*
	* @param pk the primary key of the p r user to check for associations with p r registrations
	* @return <code>true</code> if the p r user has any p r registrations associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsPRRegistrations(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;
}