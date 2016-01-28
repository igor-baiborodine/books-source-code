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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the p r user service. This utility wraps {@link PRUserPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
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
 * @see PRUserPersistence
 * @see PRUserPersistenceImpl
 * @generated
 */
public class PRUserUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(PRUser prUser) {
		getPersistence().clearCache(prUser);
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
	public static List<PRUser> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PRUser> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PRUser> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static PRUser remove(PRUser prUser) throws SystemException {
		return getPersistence().remove(prUser);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static PRUser update(PRUser prUser, boolean merge)
		throws SystemException {
		return getPersistence().update(prUser, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static PRUser update(PRUser prUser, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(prUser, merge, serviceContext);
	}

	/**
	* Caches the p r user in the entity cache if it is enabled.
	*
	* @param prUser the p r user to cache
	*/
	public static void cacheResult(
		com.inkwell.internet.productregistration.model.PRUser prUser) {
		getPersistence().cacheResult(prUser);
	}

	/**
	* Caches the p r users in the entity cache if it is enabled.
	*
	* @param prUsers the p r users to cache
	*/
	public static void cacheResult(
		java.util.List<com.inkwell.internet.productregistration.model.PRUser> prUsers) {
		getPersistence().cacheResult(prUsers);
	}

	/**
	* Creates a new p r user with the primary key. Does not add the p r user to the database.
	*
	* @param prUserId the primary key for the new p r user
	* @return the new p r user
	*/
	public static com.inkwell.internet.productregistration.model.PRUser create(
		long prUserId) {
		return getPersistence().create(prUserId);
	}

	/**
	* Removes the p r user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param prUserId the primary key of the p r user to remove
	* @return the p r user that was removed
	* @throws com.inkwell.internet.productregistration.NoSuchUserException if a p r user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRUser remove(
		long prUserId)
		throws com.inkwell.internet.productregistration.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(prUserId);
	}

	public static com.inkwell.internet.productregistration.model.PRUser updateImpl(
		com.inkwell.internet.productregistration.model.PRUser prUser,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(prUser, merge);
	}

	/**
	* Finds the p r user with the primary key or throws a {@link com.inkwell.internet.productregistration.NoSuchUserException} if it could not be found.
	*
	* @param prUserId the primary key of the p r user to find
	* @return the p r user
	* @throws com.inkwell.internet.productregistration.NoSuchUserException if a p r user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRUser findByPrimaryKey(
		long prUserId)
		throws com.inkwell.internet.productregistration.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(prUserId);
	}

	/**
	* Finds the p r user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param prUserId the primary key of the p r user to find
	* @return the p r user, or <code>null</code> if a p r user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRUser fetchByPrimaryKey(
		long prUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(prUserId);
	}

	/**
	* Finds all the p r users where groupId = &#63; and lastName = &#63;.
	*
	* @param groupId the group id to search with
	* @param lastName the last name to search with
	* @return the matching p r users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.inkwell.internet.productregistration.model.PRUser> findByG_LN(
		long groupId, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_LN(groupId, lastName);
	}

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
	public static java.util.List<com.inkwell.internet.productregistration.model.PRUser> findByG_LN(
		long groupId, java.lang.String lastName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_LN(groupId, lastName, start, end);
	}

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
	public static java.util.List<com.inkwell.internet.productregistration.model.PRUser> findByG_LN(
		long groupId, java.lang.String lastName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_LN(groupId, lastName, start, end, orderByComparator);
	}

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
	public static com.inkwell.internet.productregistration.model.PRUser findByG_LN_First(
		long groupId, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_LN_First(groupId, lastName, orderByComparator);
	}

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
	public static com.inkwell.internet.productregistration.model.PRUser findByG_LN_Last(
		long groupId, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_LN_Last(groupId, lastName, orderByComparator);
	}

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
	public static com.inkwell.internet.productregistration.model.PRUser[] findByG_LN_PrevAndNext(
		long prUserId, long groupId, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_LN_PrevAndNext(prUserId, groupId, lastName,
			orderByComparator);
	}

	/**
	* Filters by the user's permissions and finds all the p r users where groupId = &#63; and lastName = &#63;.
	*
	* @param groupId the group id to search with
	* @param lastName the last name to search with
	* @return the matching p r users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.inkwell.internet.productregistration.model.PRUser> filterFindByG_LN(
		long groupId, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_LN(groupId, lastName);
	}

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
	public static java.util.List<com.inkwell.internet.productregistration.model.PRUser> filterFindByG_LN(
		long groupId, java.lang.String lastName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_LN(groupId, lastName, start, end);
	}

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
	public static java.util.List<com.inkwell.internet.productregistration.model.PRUser> filterFindByG_LN(
		long groupId, java.lang.String lastName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_LN(groupId, lastName, start, end,
			orderByComparator);
	}

	/**
	* Finds all the p r users where groupId = &#63; and email = &#63;.
	*
	* @param groupId the group id to search with
	* @param email the email to search with
	* @return the matching p r users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.inkwell.internet.productregistration.model.PRUser> findByG_E(
		long groupId, java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_E(groupId, email);
	}

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
	public static java.util.List<com.inkwell.internet.productregistration.model.PRUser> findByG_E(
		long groupId, java.lang.String email, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_E(groupId, email, start, end);
	}

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
	public static java.util.List<com.inkwell.internet.productregistration.model.PRUser> findByG_E(
		long groupId, java.lang.String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_E(groupId, email, start, end, orderByComparator);
	}

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
	public static com.inkwell.internet.productregistration.model.PRUser findByG_E_First(
		long groupId, java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_E_First(groupId, email, orderByComparator);
	}

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
	public static com.inkwell.internet.productregistration.model.PRUser findByG_E_Last(
		long groupId, java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_E_Last(groupId, email, orderByComparator);
	}

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
	public static com.inkwell.internet.productregistration.model.PRUser[] findByG_E_PrevAndNext(
		long prUserId, long groupId, java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_E_PrevAndNext(prUserId, groupId, email,
			orderByComparator);
	}

	/**
	* Filters by the user's permissions and finds all the p r users where groupId = &#63; and email = &#63;.
	*
	* @param groupId the group id to search with
	* @param email the email to search with
	* @return the matching p r users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.inkwell.internet.productregistration.model.PRUser> filterFindByG_E(
		long groupId, java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_E(groupId, email);
	}

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
	public static java.util.List<com.inkwell.internet.productregistration.model.PRUser> filterFindByG_E(
		long groupId, java.lang.String email, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_E(groupId, email, start, end);
	}

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
	public static java.util.List<com.inkwell.internet.productregistration.model.PRUser> filterFindByG_E(
		long groupId, java.lang.String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_E(groupId, email, start, end,
			orderByComparator);
	}

	/**
	* Finds all the p r users where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @return the matching p r users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.inkwell.internet.productregistration.model.PRUser> findByG_U(
		long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_U(groupId, userId);
	}

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
	public static java.util.List<com.inkwell.internet.productregistration.model.PRUser> findByG_U(
		long groupId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_U(groupId, userId, start, end);
	}

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
	public static java.util.List<com.inkwell.internet.productregistration.model.PRUser> findByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_U(groupId, userId, start, end, orderByComparator);
	}

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
	public static com.inkwell.internet.productregistration.model.PRUser findByG_U_First(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_U_First(groupId, userId, orderByComparator);
	}

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
	public static com.inkwell.internet.productregistration.model.PRUser findByG_U_Last(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_U_Last(groupId, userId, orderByComparator);
	}

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
	public static com.inkwell.internet.productregistration.model.PRUser[] findByG_U_PrevAndNext(
		long prUserId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_U_PrevAndNext(prUserId, groupId, userId,
			orderByComparator);
	}

	/**
	* Filters by the user's permissions and finds all the p r users where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @return the matching p r users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.inkwell.internet.productregistration.model.PRUser> filterFindByG_U(
		long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_U(groupId, userId);
	}

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
	public static java.util.List<com.inkwell.internet.productregistration.model.PRUser> filterFindByG_U(
		long groupId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_U(groupId, userId, start, end);
	}

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
	public static java.util.List<com.inkwell.internet.productregistration.model.PRUser> filterFindByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_U(groupId, userId, start, end,
			orderByComparator);
	}

	/**
	* Finds all the p r users.
	*
	* @return the p r users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.inkwell.internet.productregistration.model.PRUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.inkwell.internet.productregistration.model.PRUser> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.inkwell.internet.productregistration.model.PRUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the p r users where groupId = &#63; and lastName = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param lastName the last name to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_LN(long groupId, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_LN(groupId, lastName);
	}

	/**
	* Removes all the p r users where groupId = &#63; and email = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param email the email to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_E(long groupId, java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_E(groupId, email);
	}

	/**
	* Removes all the p r users where groupId = &#63; and userId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_U(long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_U(groupId, userId);
	}

	/**
	* Removes all the p r users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the p r users where groupId = &#63; and lastName = &#63;.
	*
	* @param groupId the group id to search with
	* @param lastName the last name to search with
	* @return the number of matching p r users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_LN(long groupId, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_LN(groupId, lastName);
	}

	/**
	* Filters by the user's permissions and counts all the p r users where groupId = &#63; and lastName = &#63;.
	*
	* @param groupId the group id to search with
	* @param lastName the last name to search with
	* @return the number of matching p r users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_LN(long groupId, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_LN(groupId, lastName);
	}

	/**
	* Counts all the p r users where groupId = &#63; and email = &#63;.
	*
	* @param groupId the group id to search with
	* @param email the email to search with
	* @return the number of matching p r users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_E(long groupId, java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_E(groupId, email);
	}

	/**
	* Filters by the user's permissions and counts all the p r users where groupId = &#63; and email = &#63;.
	*
	* @param groupId the group id to search with
	* @param email the email to search with
	* @return the number of matching p r users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_E(long groupId, java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_E(groupId, email);
	}

	/**
	* Counts all the p r users where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @return the number of matching p r users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_U(long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_U(groupId, userId);
	}

	/**
	* Filters by the user's permissions and counts all the p r users where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @return the number of matching p r users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_U(long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_U(groupId, userId);
	}

	/**
	* Counts all the p r users.
	*
	* @return the number of p r users
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	/**
	* Gets all the p r registrations associated with the p r user.
	*
	* @param pk the primary key of the p r user to get the associated p r registrations for
	* @return the p r registrations associated with the p r user
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> getPRRegistrations(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getPRRegistrations(pk);
	}

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
	public static java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> getPRRegistrations(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getPRRegistrations(pk, start, end);
	}

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
	public static java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> getPRRegistrations(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .getPRRegistrations(pk, start, end, orderByComparator);
	}

	/**
	* Gets the number of p r registrations associated with the p r user.
	*
	* @param pk the primary key of the p r user to get the number of associated p r registrations for
	* @return the number of p r registrations associated with the p r user
	* @throws SystemException if a system exception occurred
	*/
	public static int getPRRegistrationsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getPRRegistrationsSize(pk);
	}

	/**
	* Determines if the p r registration is associated with the p r user.
	*
	* @param pk the primary key of the p r user
	* @param prRegistrationPK the primary key of the p r registration
	* @return <code>true</code> if the p r registration is associated with the p r user; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsPRRegistration(long pk, long prRegistrationPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsPRRegistration(pk, prRegistrationPK);
	}

	/**
	* Determines if the p r user has any p r registrations associated with it.
	*
	* @param pk the primary key of the p r user to check for associations with p r registrations
	* @return <code>true</code> if the p r user has any p r registrations associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsPRRegistrations(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsPRRegistrations(pk);
	}

	public static PRUserPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PRUserPersistence)PortletBeanLocatorUtil.locate(com.inkwell.internet.productregistration.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					PRUserPersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(PRUserPersistence persistence) {
		_persistence = persistence;
	}

	private static PRUserPersistence _persistence;
}