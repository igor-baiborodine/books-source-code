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

package com.inkwell.internet.productregistration.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * The utility for the p r registration local service. This utility wraps {@link com.inkwell.internet.productregistration.service.impl.PRRegistrationLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.inkwell.internet.productregistration.service.impl.PRRegistrationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Rich Sezov
 * @see PRRegistrationLocalService
 * @see com.inkwell.internet.productregistration.service.base.PRRegistrationLocalServiceBaseImpl
 * @see com.inkwell.internet.productregistration.service.impl.PRRegistrationLocalServiceImpl
 * @generated
 */
public class PRRegistrationLocalServiceUtil {
	/**
	* Adds the p r registration to the database. Also notifies the appropriate model listeners.
	*
	* @param prRegistration the p r registration to add
	* @return the p r registration that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRRegistration addPRRegistration(
		com.inkwell.internet.productregistration.model.PRRegistration prRegistration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addPRRegistration(prRegistration);
	}

	/**
	* Creates a new p r registration with the primary key. Does not add the p r registration to the database.
	*
	* @param registrationId the primary key for the new p r registration
	* @return the new p r registration
	*/
	public static com.inkwell.internet.productregistration.model.PRRegistration createPRRegistration(
		long registrationId) {
		return getService().createPRRegistration(registrationId);
	}

	/**
	* Deletes the p r registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param registrationId the primary key of the p r registration to delete
	* @throws PortalException if a p r registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deletePRRegistration(long registrationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deletePRRegistration(registrationId);
	}

	/**
	* Deletes the p r registration from the database. Also notifies the appropriate model listeners.
	*
	* @param prRegistration the p r registration to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deletePRRegistration(
		com.inkwell.internet.productregistration.model.PRRegistration prRegistration)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deletePRRegistration(prRegistration);
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
	* Gets the p r registration with the primary key.
	*
	* @param registrationId the primary key of the p r registration to get
	* @return the p r registration
	* @throws PortalException if a p r registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRRegistration getPRRegistration(
		long registrationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPRRegistration(registrationId);
	}

	/**
	* Gets a range of all the p r registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of p r registrations to return
	* @param end the upper bound of the range of p r registrations to return (not inclusive)
	* @return the range of p r registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> getPRRegistrations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPRRegistrations(start, end);
	}

	/**
	* Gets the number of p r registrations.
	*
	* @return the number of p r registrations
	* @throws SystemException if a system exception occurred
	*/
	public static int getPRRegistrationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPRRegistrationsCount();
	}

	/**
	* Updates the p r registration in the database. Also notifies the appropriate model listeners.
	*
	* @param prRegistration the p r registration to update
	* @return the p r registration that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRRegistration updatePRRegistration(
		com.inkwell.internet.productregistration.model.PRRegistration prRegistration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePRRegistration(prRegistration);
	}

	/**
	* Updates the p r registration in the database. Also notifies the appropriate model listeners.
	*
	* @param prRegistration the p r registration to update
	* @param merge whether to merge the p r registration with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the p r registration that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRRegistration updatePRRegistration(
		com.inkwell.internet.productregistration.model.PRRegistration prRegistration,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePRRegistration(prRegistration, merge);
	}

	/**
	* Adds a newly created registration to the database.
	*
	* @param reg
	* @return
	* @throws SystemException
	*/
	public static com.inkwell.internet.productregistration.model.PRRegistration addRegistration(
		com.inkwell.internet.productregistration.model.PRRegistration reg)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addRegistration(reg);
	}

	/**
	* Gets all registrations out of the database.
	*
	* @return
	* @throws SystemException
	*/
	public static java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> getAllRegistrations(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllRegistrations(groupId);
	}

	public static void clearService() {
		_service = null;
	}

	public static PRRegistrationLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					PRRegistrationLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new PRRegistrationLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(PRRegistrationLocalService service) {
		_service = service;
	}

	private static PRRegistrationLocalService _service;
}