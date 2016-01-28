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

import com.inkwell.internet.shopping.sb.NoSuchShoppingCategoryImageException;
import com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage;
import com.inkwell.internet.shopping.sb.model.impl.ShoppingCategoryImageImpl;
import com.inkwell.internet.shopping.sb.model.impl.ShoppingCategoryImageModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
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
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.portlet.expando.service.persistence.ExpandoRowPersistence;
import com.liferay.portlet.expando.service.persistence.ExpandoValuePersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the shopping category image service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link ShoppingCategoryImageUtil} to access the shopping category image persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Rich Sezov
 * @see ShoppingCategoryImagePersistence
 * @see ShoppingCategoryImageUtil
 * @generated
 */
public class ShoppingCategoryImagePersistenceImpl extends BasePersistenceImpl<ShoppingCategoryImage>
	implements ShoppingCategoryImagePersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ShoppingCategoryImageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_CATEGORYID = new FinderPath(ShoppingCategoryImageModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingCategoryImageModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByCategoryId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYID = new FinderPath(ShoppingCategoryImageModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingCategoryImageModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByCategoryId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ShoppingCategoryImageModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingCategoryImageModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ShoppingCategoryImageModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingCategoryImageModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	/**
	 * Caches the shopping category image in the entity cache if it is enabled.
	 *
	 * @param shoppingCategoryImage the shopping category image to cache
	 */
	public void cacheResult(ShoppingCategoryImage shoppingCategoryImage) {
		EntityCacheUtil.putResult(ShoppingCategoryImageModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingCategoryImageImpl.class,
			shoppingCategoryImage.getPrimaryKey(), shoppingCategoryImage);
	}

	/**
	 * Caches the shopping category images in the entity cache if it is enabled.
	 *
	 * @param shoppingCategoryImages the shopping category images to cache
	 */
	public void cacheResult(List<ShoppingCategoryImage> shoppingCategoryImages) {
		for (ShoppingCategoryImage shoppingCategoryImage : shoppingCategoryImages) {
			if (EntityCacheUtil.getResult(
						ShoppingCategoryImageModelImpl.ENTITY_CACHE_ENABLED,
						ShoppingCategoryImageImpl.class,
						shoppingCategoryImage.getPrimaryKey(), this) == null) {
				cacheResult(shoppingCategoryImage);
			}
		}
	}

	/**
	 * Clears the cache for all shopping category images.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(ShoppingCategoryImageImpl.class.getName());
		EntityCacheUtil.clearCache(ShoppingCategoryImageImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the shopping category image.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(ShoppingCategoryImage shoppingCategoryImage) {
		EntityCacheUtil.removeResult(ShoppingCategoryImageModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingCategoryImageImpl.class,
			shoppingCategoryImage.getPrimaryKey());
	}

	/**
	 * Creates a new shopping category image with the primary key. Does not add the shopping category image to the database.
	 *
	 * @param imageId the primary key for the new shopping category image
	 * @return the new shopping category image
	 */
	public ShoppingCategoryImage create(long imageId) {
		ShoppingCategoryImage shoppingCategoryImage = new ShoppingCategoryImageImpl();

		shoppingCategoryImage.setNew(true);
		shoppingCategoryImage.setPrimaryKey(imageId);

		return shoppingCategoryImage;
	}

	/**
	 * Removes the shopping category image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the shopping category image to remove
	 * @return the shopping category image that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a shopping category image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingCategoryImage remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the shopping category image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param imageId the primary key of the shopping category image to remove
	 * @return the shopping category image that was removed
	 * @throws com.inkwell.internet.shopping.sb.NoSuchShoppingCategoryImageException if a shopping category image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingCategoryImage remove(long imageId)
		throws NoSuchShoppingCategoryImageException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ShoppingCategoryImage shoppingCategoryImage = (ShoppingCategoryImage)session.get(ShoppingCategoryImageImpl.class,
					new Long(imageId));

			if (shoppingCategoryImage == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + imageId);
				}

				throw new NoSuchShoppingCategoryImageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					imageId);
			}

			return remove(shoppingCategoryImage);
		}
		catch (NoSuchShoppingCategoryImageException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ShoppingCategoryImage removeImpl(
		ShoppingCategoryImage shoppingCategoryImage) throws SystemException {
		shoppingCategoryImage = toUnwrappedModel(shoppingCategoryImage);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, shoppingCategoryImage);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ShoppingCategoryImageModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingCategoryImageImpl.class,
			shoppingCategoryImage.getPrimaryKey());

		return shoppingCategoryImage;
	}

	public ShoppingCategoryImage updateImpl(
		com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage shoppingCategoryImage,
		boolean merge) throws SystemException {
		shoppingCategoryImage = toUnwrappedModel(shoppingCategoryImage);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, shoppingCategoryImage, merge);

			shoppingCategoryImage.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ShoppingCategoryImageModelImpl.ENTITY_CACHE_ENABLED,
			ShoppingCategoryImageImpl.class,
			shoppingCategoryImage.getPrimaryKey(), shoppingCategoryImage);

		return shoppingCategoryImage;
	}

	protected ShoppingCategoryImage toUnwrappedModel(
		ShoppingCategoryImage shoppingCategoryImage) {
		if (shoppingCategoryImage instanceof ShoppingCategoryImageImpl) {
			return shoppingCategoryImage;
		}

		ShoppingCategoryImageImpl shoppingCategoryImageImpl = new ShoppingCategoryImageImpl();

		shoppingCategoryImageImpl.setNew(shoppingCategoryImage.isNew());
		shoppingCategoryImageImpl.setPrimaryKey(shoppingCategoryImage.getPrimaryKey());

		shoppingCategoryImageImpl.setImageId(shoppingCategoryImage.getImageId());
		shoppingCategoryImageImpl.setCategoryId(shoppingCategoryImage.getCategoryId());
		shoppingCategoryImageImpl.setImageUrl(shoppingCategoryImage.getImageUrl());

		return shoppingCategoryImageImpl;
	}

	/**
	 * Finds the shopping category image with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the shopping category image to find
	 * @return the shopping category image
	 * @throws com.liferay.portal.NoSuchModelException if a shopping category image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingCategoryImage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the shopping category image with the primary key or throws a {@link com.inkwell.internet.shopping.sb.NoSuchShoppingCategoryImageException} if it could not be found.
	 *
	 * @param imageId the primary key of the shopping category image to find
	 * @return the shopping category image
	 * @throws com.inkwell.internet.shopping.sb.NoSuchShoppingCategoryImageException if a shopping category image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingCategoryImage findByPrimaryKey(long imageId)
		throws NoSuchShoppingCategoryImageException, SystemException {
		ShoppingCategoryImage shoppingCategoryImage = fetchByPrimaryKey(imageId);

		if (shoppingCategoryImage == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + imageId);
			}

			throw new NoSuchShoppingCategoryImageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				imageId);
		}

		return shoppingCategoryImage;
	}

	/**
	 * Finds the shopping category image with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the shopping category image to find
	 * @return the shopping category image, or <code>null</code> if a shopping category image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingCategoryImage fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the shopping category image with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param imageId the primary key of the shopping category image to find
	 * @return the shopping category image, or <code>null</code> if a shopping category image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ShoppingCategoryImage fetchByPrimaryKey(long imageId)
		throws SystemException {
		ShoppingCategoryImage shoppingCategoryImage = (ShoppingCategoryImage)EntityCacheUtil.getResult(ShoppingCategoryImageModelImpl.ENTITY_CACHE_ENABLED,
				ShoppingCategoryImageImpl.class, imageId, this);

		if (shoppingCategoryImage == null) {
			Session session = null;

			try {
				session = openSession();

				shoppingCategoryImage = (ShoppingCategoryImage)session.get(ShoppingCategoryImageImpl.class,
						new Long(imageId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (shoppingCategoryImage != null) {
					cacheResult(shoppingCategoryImage);
				}

				closeSession(session);
			}
		}

		return shoppingCategoryImage;
	}

	/**
	 * Finds all the shopping category images where categoryId = &#63;.
	 *
	 * @param categoryId the category id to search with
	 * @return the matching shopping category images
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingCategoryImage> findByCategoryId(long categoryId)
		throws SystemException {
		return findByCategoryId(categoryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	public List<ShoppingCategoryImage> findByCategoryId(long categoryId,
		int start, int end) throws SystemException {
		return findByCategoryId(categoryId, start, end, null);
	}

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
	public List<ShoppingCategoryImage> findByCategoryId(long categoryId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				categoryId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ShoppingCategoryImage> list = (List<ShoppingCategoryImage>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CATEGORYID,
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

			query.append(_SQL_SELECT_SHOPPINGCATEGORYIMAGE_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ShoppingCategoryImageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				list = (List<ShoppingCategoryImage>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_CATEGORYID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CATEGORYID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

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
	public ShoppingCategoryImage findByCategoryId_First(long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchShoppingCategoryImageException, SystemException {
		List<ShoppingCategoryImage> list = findByCategoryId(categoryId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("categoryId=");
			msg.append(categoryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchShoppingCategoryImageException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public ShoppingCategoryImage findByCategoryId_Last(long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchShoppingCategoryImageException, SystemException {
		int count = countByCategoryId(categoryId);

		List<ShoppingCategoryImage> list = findByCategoryId(categoryId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("categoryId=");
			msg.append(categoryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchShoppingCategoryImageException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public ShoppingCategoryImage[] findByCategoryId_PrevAndNext(long imageId,
		long categoryId, OrderByComparator orderByComparator)
		throws NoSuchShoppingCategoryImageException, SystemException {
		ShoppingCategoryImage shoppingCategoryImage = findByPrimaryKey(imageId);

		Session session = null;

		try {
			session = openSession();

			ShoppingCategoryImage[] array = new ShoppingCategoryImageImpl[3];

			array[0] = getByCategoryId_PrevAndNext(session,
					shoppingCategoryImage, categoryId, orderByComparator, true);

			array[1] = shoppingCategoryImage;

			array[2] = getByCategoryId_PrevAndNext(session,
					shoppingCategoryImage, categoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ShoppingCategoryImage getByCategoryId_PrevAndNext(
		Session session, ShoppingCategoryImage shoppingCategoryImage,
		long categoryId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SHOPPINGCATEGORYIMAGE_WHERE);

		query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

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
			query.append(ShoppingCategoryImageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(shoppingCategoryImage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ShoppingCategoryImage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the shopping category images.
	 *
	 * @return the shopping category images
	 * @throws SystemException if a system exception occurred
	 */
	public List<ShoppingCategoryImage> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	public List<ShoppingCategoryImage> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	public List<ShoppingCategoryImage> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ShoppingCategoryImage> list = (List<ShoppingCategoryImage>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SHOPPINGCATEGORYIMAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SHOPPINGCATEGORYIMAGE.concat(ShoppingCategoryImageModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ShoppingCategoryImage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ShoppingCategoryImage>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the shopping category images where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCategoryId(long categoryId) throws SystemException {
		for (ShoppingCategoryImage shoppingCategoryImage : findByCategoryId(
				categoryId)) {
			remove(shoppingCategoryImage);
		}
	}

	/**
	 * Removes all the shopping category images from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ShoppingCategoryImage shoppingCategoryImage : findAll()) {
			remove(shoppingCategoryImage);
		}
	}

	/**
	 * Counts all the shopping category images where categoryId = &#63;.
	 *
	 * @param categoryId the category id to search with
	 * @return the number of matching shopping category images
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCategoryId(long categoryId) throws SystemException {
		Object[] finderArgs = new Object[] { categoryId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CATEGORYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SHOPPINGCATEGORYIMAGE_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CATEGORYID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the shopping category images.
	 *
	 * @return the number of shopping category images
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

				Query q = session.createQuery(_SQL_COUNT_SHOPPINGCATEGORYIMAGE);

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
	 * Initializes the shopping category image persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ShoppingCategoryImage>> listenersList = new ArrayList<ModelListener<ShoppingCategoryImage>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ShoppingCategoryImage>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ShoppingCategoryImageImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
	}

	@BeanReference(type = ShoppingCategoryImagePersistence.class)
	protected ShoppingCategoryImagePersistence shoppingCategoryImagePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = ExpandoRowPersistence.class)
	protected ExpandoRowPersistence expandoRowPersistence;
	@BeanReference(type = ExpandoValuePersistence.class)
	protected ExpandoValuePersistence expandoValuePersistence;
	private static final String _SQL_SELECT_SHOPPINGCATEGORYIMAGE = "SELECT shoppingCategoryImage FROM ShoppingCategoryImage shoppingCategoryImage";
	private static final String _SQL_SELECT_SHOPPINGCATEGORYIMAGE_WHERE = "SELECT shoppingCategoryImage FROM ShoppingCategoryImage shoppingCategoryImage WHERE ";
	private static final String _SQL_COUNT_SHOPPINGCATEGORYIMAGE = "SELECT COUNT(shoppingCategoryImage) FROM ShoppingCategoryImage shoppingCategoryImage";
	private static final String _SQL_COUNT_SHOPPINGCATEGORYIMAGE_WHERE = "SELECT COUNT(shoppingCategoryImage) FROM ShoppingCategoryImage shoppingCategoryImage WHERE ";
	private static final String _FINDER_COLUMN_CATEGORYID_CATEGORYID_2 = "shoppingCategoryImage.categoryId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "shoppingCategoryImage.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ShoppingCategoryImage exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ShoppingCategoryImage exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(ShoppingCategoryImagePersistenceImpl.class);
}