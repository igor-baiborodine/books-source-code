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

package com.inkwell.internet.slogan.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * The utility for the slogan local service. This utility wraps {@link com.inkwell.internet.slogan.service.impl.SloganLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.inkwell.internet.slogan.service.impl.SloganLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Rich Sezov
 * @see SloganLocalService
 * @see com.inkwell.internet.slogan.service.base.SloganLocalServiceBaseImpl
 * @see com.inkwell.internet.slogan.service.impl.SloganLocalServiceImpl
 * @generated
 */
public class SloganLocalServiceUtil {
	/**
	* Adds the slogan to the database. Also notifies the appropriate model listeners.
	*
	* @param slogan the slogan to add
	* @return the slogan that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.slogan.model.Slogan addSlogan(
		com.inkwell.internet.slogan.model.Slogan slogan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSlogan(slogan);
	}

	/**
	* Creates a new slogan with the primary key. Does not add the slogan to the database.
	*
	* @param sloganId the primary key for the new slogan
	* @return the new slogan
	*/
	public static com.inkwell.internet.slogan.model.Slogan createSlogan(
		long sloganId) {
		return getService().createSlogan(sloganId);
	}

	/**
	* Deletes the slogan with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sloganId the primary key of the slogan to delete
	* @throws PortalException if a slogan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteSlogan(long sloganId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteSlogan(sloganId);
	}

	/**
	* Deletes the slogan from the database. Also notifies the appropriate model listeners.
	*
	* @param slogan the slogan to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteSlogan(
		com.inkwell.internet.slogan.model.Slogan slogan)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteSlogan(slogan);
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
	* Gets the slogan with the primary key.
	*
	* @param sloganId the primary key of the slogan to get
	* @return the slogan
	* @throws PortalException if a slogan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.slogan.model.Slogan getSlogan(
		long sloganId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSlogan(sloganId);
	}

	/**
	* Gets the slogan with the UUID and group id.
	*
	* @param uuid the UUID of slogan to get
	* @param groupId the group id of the slogan to get
	* @return the slogan
	* @throws PortalException if a slogan with the UUID and group id could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.slogan.model.Slogan getSloganByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSloganByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Gets a range of all the slogans.
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
	public static java.util.List<com.inkwell.internet.slogan.model.Slogan> getSlogans(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSlogans(start, end);
	}

	/**
	* Gets the number of slogans.
	*
	* @return the number of slogans
	* @throws SystemException if a system exception occurred
	*/
	public static int getSlogansCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSlogansCount();
	}

	/**
	* Updates the slogan in the database. Also notifies the appropriate model listeners.
	*
	* @param slogan the slogan to update
	* @return the slogan that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.slogan.model.Slogan updateSlogan(
		com.inkwell.internet.slogan.model.Slogan slogan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSlogan(slogan);
	}

	/**
	* Updates the slogan in the database. Also notifies the appropriate model listeners.
	*
	* @param slogan the slogan to update
	* @param merge whether to merge the slogan with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the slogan that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.slogan.model.Slogan updateSlogan(
		com.inkwell.internet.slogan.model.Slogan slogan, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSlogan(slogan, merge);
	}

	/**
	* Gets all slogans by group ID.
	*
	* @param groupId
	* @return
	* @throws SystemException
	*/
	public static java.util.List<com.inkwell.internet.slogan.model.Slogan> getSlogans(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSlogans(groupId);
	}

	public static java.util.List<com.inkwell.internet.slogan.model.Slogan> getSlogans(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSlogans(groupId, status, start, end, obc);
	}

	public static java.util.List<com.inkwell.internet.slogan.model.Slogan> getSlogans(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSlogans(groupId, status, start, end);
	}

	public static java.util.List<com.inkwell.internet.slogan.model.Slogan> getCompanySlogans(
		long companyId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCompanySlogans(companyId, status, start, end);
	}

	/**
	* Adds a new slogan to the database.
	*
	* @param newSlogan
	* @param userId
	* @return
	* @throws SystemException
	* @throws PortalException
	*/
	public static com.inkwell.internet.slogan.model.Slogan addSlogan(
		com.inkwell.internet.slogan.model.Slogan newSlogan, long userId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addSlogan(newSlogan, userId, serviceContext);
	}

	public static com.inkwell.internet.slogan.model.Slogan updateStatus(
		long userId, long resourcePrimKey, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateStatus(userId, resourcePrimKey, status, serviceContext);
	}

	public static int getSlogansCount(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSlogansCount(groupId, status);
	}

	public static void clearService() {
		_service = null;
	}

	public static SloganLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					SloganLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new SloganLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(SloganLocalService service) {
		_service = service;
	}

	private static SloganLocalService _service;
}