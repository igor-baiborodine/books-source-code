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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * The utility for the p r user local service. This utility wraps {@link com.inkwell.internet.productregistration.service.impl.PRUserLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.inkwell.internet.productregistration.service.impl.PRUserLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Rich Sezov
 * @see PRUserLocalService
 * @see com.inkwell.internet.productregistration.service.base.PRUserLocalServiceBaseImpl
 * @see com.inkwell.internet.productregistration.service.impl.PRUserLocalServiceImpl
 * @generated
 */
public class PRUserLocalServiceUtil {
	/**
	* Adds the p r user to the database. Also notifies the appropriate model listeners.
	*
	* @param prUser the p r user to add
	* @return the p r user that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRUser addPRUser(
		com.inkwell.internet.productregistration.model.PRUser prUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addPRUser(prUser);
	}

	/**
	* Creates a new p r user with the primary key. Does not add the p r user to the database.
	*
	* @param prUserId the primary key for the new p r user
	* @return the new p r user
	*/
	public static com.inkwell.internet.productregistration.model.PRUser createPRUser(
		long prUserId) {
		return getService().createPRUser(prUserId);
	}

	/**
	* Deletes the p r user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param prUserId the primary key of the p r user to delete
	* @throws PortalException if a p r user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deletePRUser(long prUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deletePRUser(prUserId);
	}

	/**
	* Deletes the p r user from the database. Also notifies the appropriate model listeners.
	*
	* @param prUser the p r user to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deletePRUser(
		com.inkwell.internet.productregistration.model.PRUser prUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deletePRUser(prUser);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the p r user with the primary key.
	*
	* @param prUserId the primary key of the p r user to get
	* @return the p r user
	* @throws PortalException if a p r user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRUser getPRUser(
		long prUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPRUser(prUserId);
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
	public static java.util.List<com.inkwell.internet.productregistration.model.PRUser> getPRUsers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPRUsers(start, end);
	}

	/**
	* Gets the number of p r users.
	*
	* @return the number of p r users
	* @throws SystemException if a system exception occurred
	*/
	public static int getPRUsersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPRUsersCount();
	}

	/**
	* Updates the p r user in the database. Also notifies the appropriate model listeners.
	*
	* @param prUser the p r user to update
	* @return the p r user that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRUser updatePRUser(
		com.inkwell.internet.productregistration.model.PRUser prUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePRUser(prUser);
	}

	/**
	* Updates the p r user in the database. Also notifies the appropriate model listeners.
	*
	* @param prUser the p r user to update
	* @param merge whether to merge the p r user with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the p r user that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRUser updatePRUser(
		com.inkwell.internet.productregistration.model.PRUser prUser,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePRUser(prUser, merge);
	}

	/**
	* Adds a Registered User object to the database as a new record.
	*
	* @param user
	* @return
	* @throws SystemException
	*/
	public static com.inkwell.internet.productregistration.model.PRUser addPRUser(
		com.inkwell.internet.productregistration.model.PRUser user, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addPRUser(user, userId);
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
	public static com.inkwell.internet.productregistration.model.PRUser getPRUser(
		long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPRUser(groupId, userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static PRUserLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					PRUserLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new PRUserLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(PRUserLocalService service) {
		_service = service;
	}

	private static PRUserLocalService _service;
}