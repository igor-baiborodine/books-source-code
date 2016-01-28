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

import com.inkwell.internet.productregistration.NoSuchProductException;
import com.inkwell.internet.productregistration.model.PRProduct;
import com.inkwell.internet.productregistration.model.impl.PRProductImpl;
import com.inkwell.internet.productregistration.model.impl.PRProductModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the p r product service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link PRProductUtil} to access the p r product persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Rich Sezov
 * @see PRProductPersistence
 * @see PRProductUtil
 * @generated
 */
public class PRProductPersistenceImpl extends BasePersistenceImpl<PRProduct>
	implements PRProductPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = PRProductImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_G_PN = new FinderPath(PRProductModelImpl.ENTITY_CACHE_ENABLED,
			PRProductModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByG_PN",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_G_PN = new FinderPath(PRProductModelImpl.ENTITY_CACHE_ENABLED,
			PRProductModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByG_PN",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_GROUPID = new FinderPath(PRProductModelImpl.ENTITY_CACHE_ENABLED,
			PRProductModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(PRProductModelImpl.ENTITY_CACHE_ENABLED,
			PRProductModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByGroupId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_COMPANYID = new FinderPath(PRProductModelImpl.ENTITY_CACHE_ENABLED,
			PRProductModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(PRProductModelImpl.ENTITY_CACHE_ENABLED,
			PRProductModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByCompanyId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(PRProductModelImpl.ENTITY_CACHE_ENABLED,
			PRProductModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PRProductModelImpl.ENTITY_CACHE_ENABLED,
			PRProductModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the p r product in the entity cache if it is enabled.
	 *
	 * @param prProduct the p r product to cache
	 */
	public void cacheResult(PRProduct prProduct) {
		EntityCacheUtil.putResult(PRProductModelImpl.ENTITY_CACHE_ENABLED,
			PRProductImpl.class, prProduct.getPrimaryKey(), prProduct);
	}

	/**
	 * Caches the p r products in the entity cache if it is enabled.
	 *
	 * @param prProducts the p r products to cache
	 */
	public void cacheResult(List<PRProduct> prProducts) {
		for (PRProduct prProduct : prProducts) {
			if (EntityCacheUtil.getResult(
						PRProductModelImpl.ENTITY_CACHE_ENABLED,
						PRProductImpl.class, prProduct.getPrimaryKey(), this) == null) {
				cacheResult(prProduct);
			}
		}
	}

	/**
	 * Clears the cache for all p r products.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(PRProductImpl.class.getName());
		EntityCacheUtil.clearCache(PRProductImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the p r product.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(PRProduct prProduct) {
		EntityCacheUtil.removeResult(PRProductModelImpl.ENTITY_CACHE_ENABLED,
			PRProductImpl.class, prProduct.getPrimaryKey());
	}

	/**
	 * Creates a new p r product with the primary key. Does not add the p r product to the database.
	 *
	 * @param productId the primary key for the new p r product
	 * @return the new p r product
	 */
	public PRProduct create(long productId) {
		PRProduct prProduct = new PRProductImpl();

		prProduct.setNew(true);
		prProduct.setPrimaryKey(productId);

		return prProduct;
	}

	/**
	 * Removes the p r product with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the p r product to remove
	 * @return the p r product that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a p r product with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRProduct remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the p r product with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productId the primary key of the p r product to remove
	 * @return the p r product that was removed
	 * @throws com.inkwell.internet.productregistration.NoSuchProductException if a p r product with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRProduct remove(long productId)
		throws NoSuchProductException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PRProduct prProduct = (PRProduct)session.get(PRProductImpl.class,
					new Long(productId));

			if (prProduct == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + productId);
				}

				throw new NoSuchProductException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					productId);
			}

			return remove(prProduct);
		}
		catch (NoSuchProductException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PRProduct removeImpl(PRProduct prProduct)
		throws SystemException {
		prProduct = toUnwrappedModel(prProduct);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, prProduct);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(PRProductModelImpl.ENTITY_CACHE_ENABLED,
			PRProductImpl.class, prProduct.getPrimaryKey());

		return prProduct;
	}

	public PRProduct updateImpl(
		com.inkwell.internet.productregistration.model.PRProduct prProduct,
		boolean merge) throws SystemException {
		prProduct = toUnwrappedModel(prProduct);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, prProduct, merge);

			prProduct.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(PRProductModelImpl.ENTITY_CACHE_ENABLED,
			PRProductImpl.class, prProduct.getPrimaryKey(), prProduct);

		return prProduct;
	}

	protected PRProduct toUnwrappedModel(PRProduct prProduct) {
		if (prProduct instanceof PRProductImpl) {
			return prProduct;
		}

		PRProductImpl prProductImpl = new PRProductImpl();

		prProductImpl.setNew(prProduct.isNew());
		prProductImpl.setPrimaryKey(prProduct.getPrimaryKey());

		prProductImpl.setProductId(prProduct.getProductId());
		prProductImpl.setProductName(prProduct.getProductName());
		prProductImpl.setSerialNumber(prProduct.getSerialNumber());
		prProductImpl.setCompanyId(prProduct.getCompanyId());
		prProductImpl.setGroupId(prProduct.getGroupId());

		return prProductImpl;
	}

	/**
	 * Finds the p r product with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the p r product to find
	 * @return the p r product
	 * @throws com.liferay.portal.NoSuchModelException if a p r product with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRProduct findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the p r product with the primary key or throws a {@link com.inkwell.internet.productregistration.NoSuchProductException} if it could not be found.
	 *
	 * @param productId the primary key of the p r product to find
	 * @return the p r product
	 * @throws com.inkwell.internet.productregistration.NoSuchProductException if a p r product with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRProduct findByPrimaryKey(long productId)
		throws NoSuchProductException, SystemException {
		PRProduct prProduct = fetchByPrimaryKey(productId);

		if (prProduct == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + productId);
			}

			throw new NoSuchProductException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				productId);
		}

		return prProduct;
	}

	/**
	 * Finds the p r product with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the p r product to find
	 * @return the p r product, or <code>null</code> if a p r product with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRProduct fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the p r product with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productId the primary key of the p r product to find
	 * @return the p r product, or <code>null</code> if a p r product with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRProduct fetchByPrimaryKey(long productId)
		throws SystemException {
		PRProduct prProduct = (PRProduct)EntityCacheUtil.getResult(PRProductModelImpl.ENTITY_CACHE_ENABLED,
				PRProductImpl.class, productId, this);

		if (prProduct == null) {
			Session session = null;

			try {
				session = openSession();

				prProduct = (PRProduct)session.get(PRProductImpl.class,
						new Long(productId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (prProduct != null) {
					cacheResult(prProduct);
				}

				closeSession(session);
			}
		}

		return prProduct;
	}

	/**
	 * Finds all the p r products where groupId = &#63; and productName = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param productName the product name to search with
	 * @return the matching p r products
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRProduct> findByG_PN(long groupId, String productName)
		throws SystemException {
		return findByG_PN(groupId, productName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the p r products where groupId = &#63; and productName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param productName the product name to search with
	 * @param start the lower bound of the range of p r products to return
	 * @param end the upper bound of the range of p r products to return (not inclusive)
	 * @return the range of matching p r products
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRProduct> findByG_PN(long groupId, String productName,
		int start, int end) throws SystemException {
		return findByG_PN(groupId, productName, start, end, null);
	}

	/**
	 * Finds an ordered range of all the p r products where groupId = &#63; and productName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param productName the product name to search with
	 * @param start the lower bound of the range of p r products to return
	 * @param end the upper bound of the range of p r products to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching p r products
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRProduct> findByG_PN(long groupId, String productName,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, productName,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<PRProduct> list = (List<PRProduct>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_G_PN,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_PRPRODUCT_WHERE);

			query.append(_FINDER_COLUMN_G_PN_GROUPID_2);

			if (productName == null) {
				query.append(_FINDER_COLUMN_G_PN_PRODUCTNAME_1);
			}
			else {
				if (productName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_PN_PRODUCTNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_G_PN_PRODUCTNAME_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PRProductModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (productName != null) {
					qPos.add(productName);
				}

				list = (List<PRProduct>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_G_PN,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_G_PN,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first p r product in the ordered set where groupId = &#63; and productName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param productName the product name to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching p r product
	 * @throws com.inkwell.internet.productregistration.NoSuchProductException if a matching p r product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRProduct findByG_PN_First(long groupId, String productName,
		OrderByComparator orderByComparator)
		throws NoSuchProductException, SystemException {
		List<PRProduct> list = findByG_PN(groupId, productName, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", productName=");
			msg.append(productName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProductException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last p r product in the ordered set where groupId = &#63; and productName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param productName the product name to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching p r product
	 * @throws com.inkwell.internet.productregistration.NoSuchProductException if a matching p r product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRProduct findByG_PN_Last(long groupId, String productName,
		OrderByComparator orderByComparator)
		throws NoSuchProductException, SystemException {
		int count = countByG_PN(groupId, productName);

		List<PRProduct> list = findByG_PN(groupId, productName, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", productName=");
			msg.append(productName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProductException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the p r products before and after the current p r product in the ordered set where groupId = &#63; and productName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param productId the primary key of the current p r product
	 * @param groupId the group id to search with
	 * @param productName the product name to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next p r product
	 * @throws com.inkwell.internet.productregistration.NoSuchProductException if a p r product with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRProduct[] findByG_PN_PrevAndNext(long productId, long groupId,
		String productName, OrderByComparator orderByComparator)
		throws NoSuchProductException, SystemException {
		PRProduct prProduct = findByPrimaryKey(productId);

		Session session = null;

		try {
			session = openSession();

			PRProduct[] array = new PRProductImpl[3];

			array[0] = getByG_PN_PrevAndNext(session, prProduct, groupId,
					productName, orderByComparator, true);

			array[1] = prProduct;

			array[2] = getByG_PN_PrevAndNext(session, prProduct, groupId,
					productName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PRProduct getByG_PN_PrevAndNext(Session session,
		PRProduct prProduct, long groupId, String productName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRPRODUCT_WHERE);

		query.append(_FINDER_COLUMN_G_PN_GROUPID_2);

		if (productName == null) {
			query.append(_FINDER_COLUMN_G_PN_PRODUCTNAME_1);
		}
		else {
			if (productName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_PN_PRODUCTNAME_3);
			}
			else {
				query.append(_FINDER_COLUMN_G_PN_PRODUCTNAME_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(PRProductModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (productName != null) {
			qPos.add(productName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(prProduct);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PRProduct> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Filters by the user's permissions and finds all the p r products where groupId = &#63; and productName = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param productName the product name to search with
	 * @return the matching p r products that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRProduct> filterFindByG_PN(long groupId, String productName)
		throws SystemException {
		return filterFindByG_PN(groupId, productName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Filters by the user's permissions and finds a range of all the p r products where groupId = &#63; and productName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param productName the product name to search with
	 * @param start the lower bound of the range of p r products to return
	 * @param end the upper bound of the range of p r products to return (not inclusive)
	 * @return the range of matching p r products that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRProduct> filterFindByG_PN(long groupId, String productName,
		int start, int end) throws SystemException {
		return filterFindByG_PN(groupId, productName, start, end, null);
	}

	/**
	 * Filters by the user's permissions and finds an ordered range of all the p r products where groupId = &#63; and productName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param productName the product name to search with
	 * @param start the lower bound of the range of p r products to return
	 * @param end the upper bound of the range of p r products to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching p r products that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRProduct> filterFindByG_PN(long groupId, String productName,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_PN(groupId, productName, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PRPRODUCT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PRPRODUCT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_PN_GROUPID_2);

		if (productName == null) {
			query.append(_FINDER_COLUMN_G_PN_PRODUCTNAME_1);
		}
		else {
			if (productName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_PN_PRODUCTNAME_3);
			}
			else {
				query.append(_FINDER_COLUMN_G_PN_PRODUCTNAME_2);
			}
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PRPRODUCT_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator);
			}
		}

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(PRProductModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PRProductModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PRProduct.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, PRProductImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, PRProductImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (productName != null) {
				qPos.add(productName);
			}

			return (List<PRProduct>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Finds all the p r products where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the matching p r products
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRProduct> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the p r products where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of p r products to return
	 * @param end the upper bound of the range of p r products to return (not inclusive)
	 * @return the range of matching p r products
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRProduct> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the p r products where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of p r products to return
	 * @param end the upper bound of the range of p r products to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching p r products
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRProduct> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<PRProduct> list = (List<PRProduct>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_GROUPID,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PRPRODUCT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PRProductModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<PRProduct>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_GROUPID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_GROUPID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first p r product in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching p r product
	 * @throws com.inkwell.internet.productregistration.NoSuchProductException if a matching p r product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRProduct findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchProductException, SystemException {
		List<PRProduct> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProductException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last p r product in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching p r product
	 * @throws com.inkwell.internet.productregistration.NoSuchProductException if a matching p r product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRProduct findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchProductException, SystemException {
		int count = countByGroupId(groupId);

		List<PRProduct> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProductException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the p r products before and after the current p r product in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param productId the primary key of the current p r product
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next p r product
	 * @throws com.inkwell.internet.productregistration.NoSuchProductException if a p r product with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRProduct[] findByGroupId_PrevAndNext(long productId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchProductException, SystemException {
		PRProduct prProduct = findByPrimaryKey(productId);

		Session session = null;

		try {
			session = openSession();

			PRProduct[] array = new PRProductImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, prProduct, groupId,
					orderByComparator, true);

			array[1] = prProduct;

			array[2] = getByGroupId_PrevAndNext(session, prProduct, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PRProduct getByGroupId_PrevAndNext(Session session,
		PRProduct prProduct, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRPRODUCT_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(PRProductModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(prProduct);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PRProduct> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Filters by the user's permissions and finds all the p r products where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the matching p r products that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRProduct> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Filters by the user's permissions and finds a range of all the p r products where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of p r products to return
	 * @param end the upper bound of the range of p r products to return (not inclusive)
	 * @return the range of matching p r products that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRProduct> filterFindByGroupId(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Filters by the user's permissions and finds an ordered range of all the p r products where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of p r products to return
	 * @param end the upper bound of the range of p r products to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching p r products that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRProduct> filterFindByGroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PRPRODUCT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PRPRODUCT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PRPRODUCT_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator);
			}
		}

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(PRProductModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PRProductModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PRProduct.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, PRProductImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, PRProductImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<PRProduct>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Finds all the p r products where companyId = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @return the matching p r products
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRProduct> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Finds a range of all the p r products where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param start the lower bound of the range of p r products to return
	 * @param end the upper bound of the range of p r products to return (not inclusive)
	 * @return the range of matching p r products
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRProduct> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the p r products where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param start the lower bound of the range of p r products to return
	 * @param end the upper bound of the range of p r products to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching p r products
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRProduct> findByCompanyId(long companyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<PRProduct> list = (List<PRProduct>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_COMPANYID,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PRPRODUCT_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PRProductModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<PRProduct>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_COMPANYID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_COMPANYID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first p r product in the ordered set where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching p r product
	 * @throws com.inkwell.internet.productregistration.NoSuchProductException if a matching p r product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRProduct findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchProductException, SystemException {
		List<PRProduct> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProductException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last p r product in the ordered set where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching p r product
	 * @throws com.inkwell.internet.productregistration.NoSuchProductException if a matching p r product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRProduct findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchProductException, SystemException {
		int count = countByCompanyId(companyId);

		List<PRProduct> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchProductException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the p r products before and after the current p r product in the ordered set where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param productId the primary key of the current p r product
	 * @param companyId the company id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next p r product
	 * @throws com.inkwell.internet.productregistration.NoSuchProductException if a p r product with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRProduct[] findByCompanyId_PrevAndNext(long productId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchProductException, SystemException {
		PRProduct prProduct = findByPrimaryKey(productId);

		Session session = null;

		try {
			session = openSession();

			PRProduct[] array = new PRProductImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, prProduct,
					companyId, orderByComparator, true);

			array[1] = prProduct;

			array[2] = getByCompanyId_PrevAndNext(session, prProduct,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PRProduct getByCompanyId_PrevAndNext(Session session,
		PRProduct prProduct, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRPRODUCT_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(PRProductModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(prProduct);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PRProduct> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the p r products.
	 *
	 * @return the p r products
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRProduct> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the p r products.
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
	public List<PRProduct> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the p r products.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of p r products to return
	 * @param end the upper bound of the range of p r products to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of p r products
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRProduct> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<PRProduct> list = (List<PRProduct>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PRPRODUCT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PRPRODUCT.concat(PRProductModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<PRProduct>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<PRProduct>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_ALL,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs,
						list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the p r products where groupId = &#63; and productName = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @param productName the product name to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_PN(long groupId, String productName)
		throws SystemException {
		for (PRProduct prProduct : findByG_PN(groupId, productName)) {
			remove(prProduct);
		}
	}

	/**
	 * Removes all the p r products where groupId = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (PRProduct prProduct : findByGroupId(groupId)) {
			remove(prProduct);
		}
	}

	/**
	 * Removes all the p r products where companyId = &#63; from the database.
	 *
	 * @param companyId the company id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyId(long companyId) throws SystemException {
		for (PRProduct prProduct : findByCompanyId(companyId)) {
			remove(prProduct);
		}
	}

	/**
	 * Removes all the p r products from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (PRProduct prProduct : findAll()) {
			remove(prProduct);
		}
	}

	/**
	 * Counts all the p r products where groupId = &#63; and productName = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param productName the product name to search with
	 * @return the number of matching p r products
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_PN(long groupId, String productName)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, productName };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_PN,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PRPRODUCT_WHERE);

			query.append(_FINDER_COLUMN_G_PN_GROUPID_2);

			if (productName == null) {
				query.append(_FINDER_COLUMN_G_PN_PRODUCTNAME_1);
			}
			else {
				if (productName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_PN_PRODUCTNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_G_PN_PRODUCTNAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (productName != null) {
					qPos.add(productName);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_PN,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Filters by the user's permissions and counts all the p r products where groupId = &#63; and productName = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param productName the product name to search with
	 * @return the number of matching p r products that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByG_PN(long groupId, String productName)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_PN(groupId, productName);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_PRPRODUCT_WHERE);

		query.append(_FINDER_COLUMN_G_PN_GROUPID_2);

		if (productName == null) {
			query.append(_FINDER_COLUMN_G_PN_PRODUCTNAME_1);
		}
		else {
			if (productName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_PN_PRODUCTNAME_3);
			}
			else {
				query.append(_FINDER_COLUMN_G_PN_PRODUCTNAME_2);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PRProduct.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (productName != null) {
				qPos.add(productName);
			}

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Counts all the p r products where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the number of matching p r products
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PRPRODUCT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Filters by the user's permissions and counts all the p r products where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the number of matching p r products that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_PRPRODUCT_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PRProduct.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Counts all the p r products where companyId = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @return the number of matching p r products
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyId(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PRPRODUCT_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the p r products.
	 *
	 * @return the number of p r products
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PRPRODUCT);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the p r product persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.inkwell.internet.productregistration.model.PRProduct")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PRProduct>> listenersList = new ArrayList<ModelListener<PRProduct>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PRProduct>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(PRProductImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
	}

	@BeanReference(type = PRProductPersistence.class)
	protected PRProductPersistence prProductPersistence;
	@BeanReference(type = PRUserPersistence.class)
	protected PRUserPersistence prUserPersistence;
	@BeanReference(type = PRRegistrationPersistence.class)
	protected PRRegistrationPersistence prRegistrationPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_PRPRODUCT = "SELECT prProduct FROM PRProduct prProduct";
	private static final String _SQL_SELECT_PRPRODUCT_WHERE = "SELECT prProduct FROM PRProduct prProduct WHERE ";
	private static final String _SQL_COUNT_PRPRODUCT = "SELECT COUNT(prProduct) FROM PRProduct prProduct";
	private static final String _SQL_COUNT_PRPRODUCT_WHERE = "SELECT COUNT(prProduct) FROM PRProduct prProduct WHERE ";
	private static final String _FINDER_COLUMN_G_PN_GROUPID_2 = "prProduct.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_PN_PRODUCTNAME_1 = "prProduct.productName IS NULL";
	private static final String _FINDER_COLUMN_G_PN_PRODUCTNAME_2 = "prProduct.productName = ?";
	private static final String _FINDER_COLUMN_G_PN_PRODUCTNAME_3 = "(prProduct.productName IS NULL OR prProduct.productName = ?)";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "prProduct.groupId = ?";
	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "prProduct.companyId = ?";
	private static final String _FILTER_SQL_SELECT_PRPRODUCT_WHERE = "SELECT DISTINCT {prProduct.*} FROM PR_PRProduct prProduct WHERE ";
	private static final String _FILTER_SQL_SELECT_PRPRODUCT_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {PR_PRProduct.*} FROM (SELECT DISTINCT prProduct.productId FROM PR_PRProduct prProduct WHERE ";
	private static final String _FILTER_SQL_SELECT_PRPRODUCT_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN PR_PRProduct ON TEMP_TABLE.productId = PR_PRProduct.productId";
	private static final String _FILTER_SQL_COUNT_PRPRODUCT_WHERE = "SELECT COUNT(DISTINCT prProduct.productId) AS COUNT_VALUE FROM PR_PRProduct prProduct WHERE ";
	private static final String _FILTER_COLUMN_PK = "prProduct.productId";
	private static final String _FILTER_COLUMN_USERID = null;
	private static final String _FILTER_ENTITY_ALIAS = "prProduct";
	private static final String _FILTER_ENTITY_TABLE = "PR_PRProduct";
	private static final String _ORDER_BY_ENTITY_ALIAS = "prProduct.";
	private static final String _ORDER_BY_ENTITY_TABLE = "PR_PRProduct.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PRProduct exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PRProduct exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(PRProductPersistenceImpl.class);
}