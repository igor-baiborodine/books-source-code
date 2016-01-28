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

package com.inkwell.internet.productregistration.service;

/**
 * <p>
 * This class is a wrapper for {@link PRUserLocalService}.
 * </p>
 *
 * @author    Rich Sezov
 * @see       PRUserLocalService
 * @generated
 */
public class PRUserLocalServiceWrapper implements PRUserLocalService {
	public PRUserLocalServiceWrapper(PRUserLocalService prUserLocalService) {
		_prUserLocalService = prUserLocalService;
	}

	/**
	* Adds the p r user to the database. Also notifies the appropriate model listeners.
	*
	* @param prUser the p r user to add
	* @return the p r user that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRUser addPRUser(
		com.inkwell.internet.productregistration.model.PRUser prUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _prUserLocalService.addPRUser(prUser);
	}

	/**
	* Creates a new p r user with the primary key. Does not add the p r user to the database.
	*
	* @param prUserId the primary key for the new p r user
	* @return the new p r user
	*/
	public com.inkwell.internet.productregistration.model.PRUser createPRUser(
		long prUserId) {
		return _prUserLocalService.createPRUser(prUserId);
	}

	/**
	* Deletes the p r user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param prUserId the primary key of the p r user to delete
	* @throws PortalException if a p r user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deletePRUser(long prUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_prUserLocalService.deletePRUser(prUserId);
	}

	/**
	* Deletes the p r user from the database. Also notifies the appropriate model listeners.
	*
	* @param prUser the p r user to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deletePRUser(
		com.inkwell.internet.productregistration.model.PRUser prUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		_prUserLocalService.deletePRUser(prUser);
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
		return _prUserLocalService.dynamicQuery(dynamicQuery);
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
		return _prUserLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _prUserLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _prUserLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the p r user with the primary key.
	*
	* @param prUserId the primary key of the p r user to get
	* @return the p r user
	* @throws PortalException if a p r user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRUser getPRUser(
		long prUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _prUserLocalService.getPRUser(prUserId);
	}

	/**
	* Gets a range of all the p r users.
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
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> getPRUsers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _prUserLocalService.getPRUsers(start, end);
	}

	/**
	* Gets the number of p r users.
	*
	* @return the number of p r users
	* @throws SystemException if a system exception occurred
	*/
	public int getPRUsersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _prUserLocalService.getPRUsersCount();
	}

	/**
	* Updates the p r user in the database. Also notifies the appropriate model listeners.
	*
	* @param prUser the p r user to update
	* @return the p r user that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRUser updatePRUser(
		com.inkwell.internet.productregistration.model.PRUser prUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _prUserLocalService.updatePRUser(prUser);
	}

	/**
	* Updates the p r user in the database. Also notifies the appropriate model listeners.
	*
	* @param prUser the p r user to update
	* @param merge whether to merge the p r user with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the p r user that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRUser updatePRUser(
		com.inkwell.internet.productregistration.model.PRUser prUser,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _prUserLocalService.updatePRUser(prUser, merge);
	}

	/**
	* Adds a Registered User object to the database as a new record.
	*
	* @param user
	* @return
	* @throws SystemException
	*/
	public com.inkwell.internet.productregistration.model.PRUser addPRUser(
		com.inkwell.internet.productregistration.model.PRUser user, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _prUserLocalService.addPRUser(user, userId);
	}

	/**
	* Gets a Registered User object from a Liferay User primary key or null if
	* it wasn't found.
	*
	* @param groupId
	* @param userId
	* @return
	* @throws SystemException
	*/
	public com.inkwell.internet.productregistration.model.PRUser getPRUser(
		long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _prUserLocalService.getPRUser(groupId, userId);
	}

	public PRUserLocalService getWrappedPRUserLocalService() {
		return _prUserLocalService;
	}

	private PRUserLocalService _prUserLocalService;
}