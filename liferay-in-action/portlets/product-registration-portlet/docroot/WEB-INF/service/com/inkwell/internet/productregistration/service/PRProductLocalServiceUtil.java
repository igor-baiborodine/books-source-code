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
 * The utility for the p r product local service. This utility wraps {@link com.inkwell.internet.productregistration.service.impl.PRProductLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.inkwell.internet.productregistration.service.impl.PRProductLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Rich Sezov
 * @see PRProductLocalService
 * @see com.inkwell.internet.productregistration.service.base.PRProductLocalServiceBaseImpl
 * @see com.inkwell.internet.productregistration.service.impl.PRProductLocalServiceImpl
 * @generated
 */
public class PRProductLocalServiceUtil {
	/**
	* Adds the p r product to the database. Also notifies the appropriate model listeners.
	*
	* @param prProduct the p r product to add
	* @return the p r product that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRProduct addPRProduct(
		com.inkwell.internet.productregistration.model.PRProduct prProduct)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addPRProduct(prProduct);
	}

	/**
	* Creates a new p r product with the primary key. Does not add the p r product to the database.
	*
	* @param productId the primary key for the new p r product
	* @return the new p r product
	*/
	public static com.inkwell.internet.productregistration.model.PRProduct createPRProduct(
		long productId) {
		return getService().createPRProduct(productId);
	}

	/**
	* Deletes the p r product with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param productId the primary key of the p r product to delete
	* @throws PortalException if a p r product with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deletePRProduct(long productId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deletePRProduct(productId);
	}

	/**
	* Deletes the p r product from the database. Also notifies the appropriate model listeners.
	*
	* @param prProduct the p r product to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deletePRProduct(
		com.inkwell.internet.productregistration.model.PRProduct prProduct)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deletePRProduct(prProduct);
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
	* Gets the p r product with the primary key.
	*
	* @param productId the primary key of the p r product to get
	* @return the p r product
	* @throws PortalException if a p r product with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRProduct getPRProduct(
		long productId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPRProduct(productId);
	}

	/**
	* Gets a range of all the p r products.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of p r products to return
	* @param end the upper bound of the range of p r products to return (not inclusive)
	* @return the range of p r products
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.inkwell.internet.productregistration.model.PRProduct> getPRProducts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPRProducts(start, end);
	}

	/**
	* Gets the number of p r products.
	*
	* @return the number of p r products
	* @throws SystemException if a system exception occurred
	*/
	public static int getPRProductsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPRProductsCount();
	}

	/**
	* Updates the p r product in the database. Also notifies the appropriate model listeners.
	*
	* @param prProduct the p r product to update
	* @return the p r product that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRProduct updatePRProduct(
		com.inkwell.internet.productregistration.model.PRProduct prProduct)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePRProduct(prProduct);
	}

	/**
	* Updates the p r product in the database. Also notifies the appropriate model listeners.
	*
	* @param prProduct the p r product to update
	* @param merge whether to merge the p r product with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the p r product that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRProduct updatePRProduct(
		com.inkwell.internet.productregistration.model.PRProduct prProduct,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePRProduct(prProduct, merge);
	}

	/**
	* Adds a new product to the database.
	*
	* @param productName
	* @param productSerial
	* @return
	* @throws com.liferay.portal.kernel.exception.SystemException
	*/
	public static com.inkwell.internet.productregistration.model.PRProduct addProduct(
		com.inkwell.internet.productregistration.model.PRProduct newProduct,
		long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addProduct(newProduct, userId);
	}

	/**
	* Retrieves all of the products from the database.
	*
	* @return
	* @throws com.liferay.portal.kernel.exception.SystemException
	*/
	public static java.util.List<com.inkwell.internet.productregistration.model.PRProduct> getAllProducts(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllProducts(groupId);
	}

	/**
	* Removes the specified product from the database.
	*
	* @param productId
	* @throws com.inkwell.internet.portlets.prodreg.sb.NoSuchProductException
	* @throws com.liferay.portal.kernel.exception.SystemException
	* @throws com.liferay.portal.kernel.exception.PortalException
	*/
	public static void deleteProduct(long productId)
		throws com.inkwell.internet.productregistration.NoSuchProductException,
			com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteProduct(productId);
	}

	/**
	* Removes the specified product from the database.
	*
	* @param product
	* @throws com.liferay.portal.kernel.exception.PortalException
	* @throws com.liferay.portal.kernel.exception.SystemException
	*/
	public static void deleteProduct(
		com.inkwell.internet.productregistration.model.PRProduct product)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteProduct(product);
	}

	public static void clearService() {
		_service = null;
	}

	public static PRProductLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					PRProductLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new PRProductLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(PRProductLocalService service) {
		_service = service;
	}

	private static PRProductLocalService _service;
}