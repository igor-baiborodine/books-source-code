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

import com.inkwell.internet.slogan.NoSuchSloganException;
import com.inkwell.internet.slogan.model.Slogan;
import com.inkwell.internet.slogan.model.impl.SloganImpl;
import com.inkwell.internet.slogan.model.impl.SloganModelImpl;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.portlet.asset.service.persistence.AssetEntryPersistence;
import com.liferay.portlet.ratings.service.persistence.RatingsStatsPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the slogan service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link SloganUtil} to access the slogan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Rich Sezov
 * @see SloganPersistence
 * @see SloganUtil
 * @generated
 */
public class SloganPersistenceImpl extends BasePersistenceImpl<Slogan>
	implements SloganPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = SloganImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_UUID = new FinderPath(SloganModelImpl.ENTITY_CACHE_ENABLED,
			SloganModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(SloganModelImpl.ENTITY_CACHE_ENABLED,
			SloganModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByUuid", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(SloganModelImpl.ENTITY_CACHE_ENABLED,
			SloganModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(SloganModelImpl.ENTITY_CACHE_ENABLED,
			SloganModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_GROUPID = new FinderPath(SloganModelImpl.ENTITY_CACHE_ENABLED,
			SloganModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(SloganModelImpl.ENTITY_CACHE_ENABLED,
			SloganModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByGroupId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_COMPANYID = new FinderPath(SloganModelImpl.ENTITY_CACHE_ENABLED,
			SloganModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(SloganModelImpl.ENTITY_CACHE_ENABLED,
			SloganModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByCompanyId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_SLOGANTEXT = new FinderPath(SloganModelImpl.ENTITY_CACHE_ENABLED,
			SloganModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findBySloganText",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_SLOGANTEXT = new FinderPath(SloganModelImpl.ENTITY_CACHE_ENABLED,
			SloganModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countBySloganText", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_G_S = new FinderPath(SloganModelImpl.ENTITY_CACHE_ENABLED,
			SloganModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByG_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_G_S = new FinderPath(SloganModelImpl.ENTITY_CACHE_ENABLED,
			SloganModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByG_S",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(SloganModelImpl.ENTITY_CACHE_ENABLED,
			SloganModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SloganModelImpl.ENTITY_CACHE_ENABLED,
			SloganModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the slogan in the entity cache if it is enabled.
	 *
	 * @param slogan the slogan to cache
	 */
	public void cacheResult(Slogan slogan) {
		EntityCacheUtil.putResult(SloganModelImpl.ENTITY_CACHE_ENABLED,
			SloganImpl.class, slogan.getPrimaryKey(), slogan);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { slogan.getUuid(), new Long(slogan.getGroupId()) },
			slogan);
	}

	/**
	 * Caches the slogans in the entity cache if it is enabled.
	 *
	 * @param slogans the slogans to cache
	 */
	public void cacheResult(List<Slogan> slogans) {
		for (Slogan slogan : slogans) {
			if (EntityCacheUtil.getResult(
						SloganModelImpl.ENTITY_CACHE_ENABLED, SloganImpl.class,
						slogan.getPrimaryKey(), this) == null) {
				cacheResult(slogan);
			}
		}
	}

	/**
	 * Clears the cache for all slogans.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(SloganImpl.class.getName());
		EntityCacheUtil.clearCache(SloganImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the slogan.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(Slogan slogan) {
		EntityCacheUtil.removeResult(SloganModelImpl.ENTITY_CACHE_ENABLED,
			SloganImpl.class, slogan.getPrimaryKey());

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { slogan.getUuid(), new Long(slogan.getGroupId()) });
	}

	/**
	 * Creates a new slogan with the primary key. Does not add the slogan to the database.
	 *
	 * @param sloganId the primary key for the new slogan
	 * @return the new slogan
	 */
	public Slogan create(long sloganId) {
		Slogan slogan = new SloganImpl();

		slogan.setNew(true);
		slogan.setPrimaryKey(sloganId);

		String uuid = PortalUUIDUtil.generate();

		slogan.setUuid(uuid);

		return slogan;
	}

	/**
	 * Removes the slogan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the slogan to remove
	 * @return the slogan that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a slogan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Slogan remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the slogan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sloganId the primary key of the slogan to remove
	 * @return the slogan that was removed
	 * @throws com.inkwell.internet.slogan.NoSuchSloganException if a slogan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Slogan remove(long sloganId)
		throws NoSuchSloganException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Slogan slogan = (Slogan)session.get(SloganImpl.class,
					new Long(sloganId));

			if (slogan == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + sloganId);
				}

				throw new NoSuchSloganException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					sloganId);
			}

			return remove(slogan);
		}
		catch (NoSuchSloganException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Slogan removeImpl(Slogan slogan) throws SystemException {
		slogan = toUnwrappedModel(slogan);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, slogan);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		SloganModelImpl sloganModelImpl = (SloganModelImpl)slogan;

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				sloganModelImpl.getUuid(),
				new Long(sloganModelImpl.getGroupId())
			});

		EntityCacheUtil.removeResult(SloganModelImpl.ENTITY_CACHE_ENABLED,
			SloganImpl.class, slogan.getPrimaryKey());

		return slogan;
	}

	public Slogan updateImpl(com.inkwell.internet.slogan.model.Slogan slogan,
		boolean merge) throws SystemException {
		slogan = toUnwrappedModel(slogan);

		boolean isNew = slogan.isNew();

		SloganModelImpl sloganModelImpl = (SloganModelImpl)slogan;

		if (Validator.isNull(slogan.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			slogan.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, slogan, merge);

			slogan.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(SloganModelImpl.ENTITY_CACHE_ENABLED,
			SloganImpl.class, slogan.getPrimaryKey(), slogan);

		if (!isNew &&
				(!Validator.equals(slogan.getUuid(),
					sloganModelImpl.getOriginalUuid()) ||
				(slogan.getGroupId() != sloganModelImpl.getOriginalGroupId()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
				new Object[] {
					sloganModelImpl.getOriginalUuid(),
					new Long(sloganModelImpl.getOriginalGroupId())
				});
		}

		if (isNew ||
				(!Validator.equals(slogan.getUuid(),
					sloganModelImpl.getOriginalUuid()) ||
				(slogan.getGroupId() != sloganModelImpl.getOriginalGroupId()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
				new Object[] { slogan.getUuid(), new Long(slogan.getGroupId()) },
				slogan);
		}

		return slogan;
	}

	protected Slogan toUnwrappedModel(Slogan slogan) {
		if (slogan instanceof SloganImpl) {
			return slogan;
		}

		SloganImpl sloganImpl = new SloganImpl();

		sloganImpl.setNew(slogan.isNew());
		sloganImpl.setPrimaryKey(slogan.getPrimaryKey());

		sloganImpl.setUuid(slogan.getUuid());
		sloganImpl.setSloganId(slogan.getSloganId());
		sloganImpl.setSloganDate(slogan.getSloganDate());
		sloganImpl.setSloganText(slogan.getSloganText());
		sloganImpl.setStatus(slogan.getStatus());
		sloganImpl.setStatusByUserId(slogan.getStatusByUserId());
		sloganImpl.setStatusByUserName(slogan.getStatusByUserName());
		sloganImpl.setStatusDate(slogan.getStatusDate());
		sloganImpl.setCompanyId(slogan.getCompanyId());
		sloganImpl.setGroupId(slogan.getGroupId());
		sloganImpl.setUserId(slogan.getUserId());

		return sloganImpl;
	}

	/**
	 * Finds the slogan with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the slogan to find
	 * @return the slogan
	 * @throws com.liferay.portal.NoSuchModelException if a slogan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Slogan findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the slogan with the primary key or throws a {@link com.inkwell.internet.slogan.NoSuchSloganException} if it could not be found.
	 *
	 * @param sloganId the primary key of the slogan to find
	 * @return the slogan
	 * @throws com.inkwell.internet.slogan.NoSuchSloganException if a slogan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Slogan findByPrimaryKey(long sloganId)
		throws NoSuchSloganException, SystemException {
		Slogan slogan = fetchByPrimaryKey(sloganId);

		if (slogan == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + sloganId);
			}

			throw new NoSuchSloganException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				sloganId);
		}

		return slogan;
	}

	/**
	 * Finds the slogan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the slogan to find
	 * @return the slogan, or <code>null</code> if a slogan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Slogan fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the slogan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sloganId the primary key of the slogan to find
	 * @return the slogan, or <code>null</code> if a slogan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Slogan fetchByPrimaryKey(long sloganId) throws SystemException {
		Slogan slogan = (Slogan)EntityCacheUtil.getResult(SloganModelImpl.ENTITY_CACHE_ENABLED,
				SloganImpl.class, sloganId, this);

		if (slogan == null) {
			Session session = null;

			try {
				session = openSession();

				slogan = (Slogan)session.get(SloganImpl.class,
						new Long(sloganId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (slogan != null) {
					cacheResult(slogan);
				}

				closeSession(session);
			}
		}

		return slogan;
	}

	/**
	 * Finds all the slogans where uuid = &#63;.
	 *
	 * @param uuid the uuid to search with
	 * @return the matching slogans
	 * @throws SystemException if a system exception occurred
	 */
	public List<Slogan> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	public List<Slogan> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

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
	public List<Slogan> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				uuid,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Slogan> list = (List<Slogan>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_UUID,
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

			query.append(_SQL_SELECT_SLOGAN_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(SloganModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				list = (List<Slogan>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_UUID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_UUID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

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
	public Slogan findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSloganException, SystemException {
		List<Slogan> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSloganException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public Slogan findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSloganException, SystemException {
		int count = countByUuid(uuid);

		List<Slogan> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSloganException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public Slogan[] findByUuid_PrevAndNext(long sloganId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSloganException, SystemException {
		Slogan slogan = findByPrimaryKey(sloganId);

		Session session = null;

		try {
			session = openSession();

			Slogan[] array = new SloganImpl[3];

			array[0] = getByUuid_PrevAndNext(session, slogan, uuid,
					orderByComparator, true);

			array[1] = slogan;

			array[2] = getByUuid_PrevAndNext(session, slogan, uuid,
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

	protected Slogan getByUuid_PrevAndNext(Session session, Slogan slogan,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SLOGAN_WHERE);

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else {
			if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				query.append(_FINDER_COLUMN_UUID_UUID_2);
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
			query.append(SloganModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (uuid != null) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(slogan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Slogan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds the slogan where uuid = &#63; and groupId = &#63; or throws a {@link com.inkwell.internet.slogan.NoSuchSloganException} if it could not be found.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @return the matching slogan
	 * @throws com.inkwell.internet.slogan.NoSuchSloganException if a matching slogan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Slogan findByUUID_G(String uuid, long groupId)
		throws NoSuchSloganException, SystemException {
		Slogan slogan = fetchByUUID_G(uuid, groupId);

		if (slogan == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSloganException(msg.toString());
		}

		return slogan;
	}

	/**
	 * Finds the slogan where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @return the matching slogan, or <code>null</code> if a matching slogan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Slogan fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Finds the slogan where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @return the matching slogan, or <code>null</code> if a matching slogan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Slogan fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SLOGAN_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_G_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_G_UUID_2);
				}
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			query.append(SloganModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<Slogan> list = q.list();

				result = list;

				Slogan slogan = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					slogan = list.get(0);

					cacheResult(slogan);

					if ((slogan.getUuid() == null) ||
							!slogan.getUuid().equals(uuid) ||
							(slogan.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, slogan);
					}
				}

				return slogan;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (Slogan)result;
			}
		}
	}

	/**
	 * Finds all the slogans where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the matching slogans
	 * @throws SystemException if a system exception occurred
	 */
	public List<Slogan> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	public List<Slogan> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

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
	public List<Slogan> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Slogan> list = (List<Slogan>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_GROUPID,
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

			query.append(_SQL_SELECT_SLOGAN_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(SloganModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<Slogan>)QueryUtil.list(q, getDialect(), start, end);
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
	public Slogan findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchSloganException, SystemException {
		List<Slogan> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSloganException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public Slogan findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchSloganException, SystemException {
		int count = countByGroupId(groupId);

		List<Slogan> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSloganException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public Slogan[] findByGroupId_PrevAndNext(long sloganId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchSloganException, SystemException {
		Slogan slogan = findByPrimaryKey(sloganId);

		Session session = null;

		try {
			session = openSession();

			Slogan[] array = new SloganImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, slogan, groupId,
					orderByComparator, true);

			array[1] = slogan;

			array[2] = getByGroupId_PrevAndNext(session, slogan, groupId,
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

	protected Slogan getByGroupId_PrevAndNext(Session session, Slogan slogan,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SLOGAN_WHERE);

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
			query.append(SloganModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(slogan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Slogan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Filters by the user's permissions and finds all the slogans where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the matching slogans that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Slogan> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	public List<Slogan> filterFindByGroupId(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
	}

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
	public List<Slogan> filterFindByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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
			query.append(_FILTER_SQL_SELECT_SLOGAN_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_SLOGAN_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SLOGAN_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(SloganModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(SloganModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Slogan.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, SloganImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, SloganImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<Slogan>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Finds all the slogans where companyId = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @return the matching slogans
	 * @throws SystemException if a system exception occurred
	 */
	public List<Slogan> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	public List<Slogan> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

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
	public List<Slogan> findByCompanyId(long companyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Slogan> list = (List<Slogan>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_COMPANYID,
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

			query.append(_SQL_SELECT_SLOGAN_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(SloganModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<Slogan>)QueryUtil.list(q, getDialect(), start, end);
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
	public Slogan findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSloganException, SystemException {
		List<Slogan> list = findByCompanyId(companyId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSloganException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public Slogan findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSloganException, SystemException {
		int count = countByCompanyId(companyId);

		List<Slogan> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSloganException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public Slogan[] findByCompanyId_PrevAndNext(long sloganId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSloganException, SystemException {
		Slogan slogan = findByPrimaryKey(sloganId);

		Session session = null;

		try {
			session = openSession();

			Slogan[] array = new SloganImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, slogan, companyId,
					orderByComparator, true);

			array[1] = slogan;

			array[2] = getByCompanyId_PrevAndNext(session, slogan, companyId,
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

	protected Slogan getByCompanyId_PrevAndNext(Session session, Slogan slogan,
		long companyId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SLOGAN_WHERE);

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
			query.append(SloganModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(slogan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Slogan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the slogans where sloganText = &#63;.
	 *
	 * @param sloganText the slogan text to search with
	 * @return the matching slogans
	 * @throws SystemException if a system exception occurred
	 */
	public List<Slogan> findBySloganText(String sloganText)
		throws SystemException {
		return findBySloganText(sloganText, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	public List<Slogan> findBySloganText(String sloganText, int start, int end)
		throws SystemException {
		return findBySloganText(sloganText, start, end, null);
	}

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
	public List<Slogan> findBySloganText(String sloganText, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				sloganText,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Slogan> list = (List<Slogan>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_SLOGANTEXT,
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

			query.append(_SQL_SELECT_SLOGAN_WHERE);

			if (sloganText == null) {
				query.append(_FINDER_COLUMN_SLOGANTEXT_SLOGANTEXT_1);
			}
			else {
				if (sloganText.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_SLOGANTEXT_SLOGANTEXT_3);
				}
				else {
					query.append(_FINDER_COLUMN_SLOGANTEXT_SLOGANTEXT_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(SloganModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (sloganText != null) {
					qPos.add(sloganText);
				}

				list = (List<Slogan>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_SLOGANTEXT,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_SLOGANTEXT,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

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
	public Slogan findBySloganText_First(String sloganText,
		OrderByComparator orderByComparator)
		throws NoSuchSloganException, SystemException {
		List<Slogan> list = findBySloganText(sloganText, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("sloganText=");
			msg.append(sloganText);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSloganException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public Slogan findBySloganText_Last(String sloganText,
		OrderByComparator orderByComparator)
		throws NoSuchSloganException, SystemException {
		int count = countBySloganText(sloganText);

		List<Slogan> list = findBySloganText(sloganText, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("sloganText=");
			msg.append(sloganText);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSloganException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public Slogan[] findBySloganText_PrevAndNext(long sloganId,
		String sloganText, OrderByComparator orderByComparator)
		throws NoSuchSloganException, SystemException {
		Slogan slogan = findByPrimaryKey(sloganId);

		Session session = null;

		try {
			session = openSession();

			Slogan[] array = new SloganImpl[3];

			array[0] = getBySloganText_PrevAndNext(session, slogan, sloganText,
					orderByComparator, true);

			array[1] = slogan;

			array[2] = getBySloganText_PrevAndNext(session, slogan, sloganText,
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

	protected Slogan getBySloganText_PrevAndNext(Session session,
		Slogan slogan, String sloganText, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SLOGAN_WHERE);

		if (sloganText == null) {
			query.append(_FINDER_COLUMN_SLOGANTEXT_SLOGANTEXT_1);
		}
		else {
			if (sloganText.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SLOGANTEXT_SLOGANTEXT_3);
			}
			else {
				query.append(_FINDER_COLUMN_SLOGANTEXT_SLOGANTEXT_2);
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
			query.append(SloganModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (sloganText != null) {
			qPos.add(sloganText);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(slogan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Slogan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the slogans where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param status the status to search with
	 * @return the matching slogans
	 * @throws SystemException if a system exception occurred
	 */
	public List<Slogan> findByG_S(long groupId, int status)
		throws SystemException {
		return findByG_S(groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	public List<Slogan> findByG_S(long groupId, int status, int start, int end)
		throws SystemException {
		return findByG_S(groupId, status, start, end, null);
	}

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
	public List<Slogan> findByG_S(long groupId, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, status,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Slogan> list = (List<Slogan>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_G_S,
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

			query.append(_SQL_SELECT_SLOGAN_WHERE);

			query.append(_FINDER_COLUMN_G_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(SloganModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(status);

				list = (List<Slogan>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_G_S,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_G_S,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

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
	public Slogan findByG_S_First(long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchSloganException, SystemException {
		List<Slogan> list = findByG_S(groupId, status, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSloganException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public Slogan findByG_S_Last(long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchSloganException, SystemException {
		int count = countByG_S(groupId, status);

		List<Slogan> list = findByG_S(groupId, status, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSloganException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public Slogan[] findByG_S_PrevAndNext(long sloganId, long groupId,
		int status, OrderByComparator orderByComparator)
		throws NoSuchSloganException, SystemException {
		Slogan slogan = findByPrimaryKey(sloganId);

		Session session = null;

		try {
			session = openSession();

			Slogan[] array = new SloganImpl[3];

			array[0] = getByG_S_PrevAndNext(session, slogan, groupId, status,
					orderByComparator, true);

			array[1] = slogan;

			array[2] = getByG_S_PrevAndNext(session, slogan, groupId, status,
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

	protected Slogan getByG_S_PrevAndNext(Session session, Slogan slogan,
		long groupId, int status, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SLOGAN_WHERE);

		query.append(_FINDER_COLUMN_G_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_STATUS_2);

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
			query.append(SloganModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(slogan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Slogan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Filters by the user's permissions and finds all the slogans where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param status the status to search with
	 * @return the matching slogans that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Slogan> filterFindByG_S(long groupId, int status)
		throws SystemException {
		return filterFindByG_S(groupId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	public List<Slogan> filterFindByG_S(long groupId, int status, int start,
		int end) throws SystemException {
		return filterFindByG_S(groupId, status, start, end, null);
	}

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
	public List<Slogan> filterFindByG_S(long groupId, int status, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S(groupId, status, start, end, orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_SLOGAN_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_SLOGAN_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SLOGAN_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(SloganModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(SloganModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Slogan.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, SloganImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, SloganImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(status);

			return (List<Slogan>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Finds all the slogans.
	 *
	 * @return the slogans
	 * @throws SystemException if a system exception occurred
	 */
	public List<Slogan> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	public List<Slogan> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

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
	public List<Slogan> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Slogan> list = (List<Slogan>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SLOGAN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SLOGAN.concat(SloganModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Slogan>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Slogan>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the slogans where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUuid(String uuid) throws SystemException {
		for (Slogan slogan : findByUuid(uuid)) {
			remove(slogan);
		}
	}

	/**
	 * Removes the slogan where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUUID_G(String uuid, long groupId)
		throws NoSuchSloganException, SystemException {
		Slogan slogan = findByUUID_G(uuid, groupId);

		remove(slogan);
	}

	/**
	 * Removes all the slogans where groupId = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (Slogan slogan : findByGroupId(groupId)) {
			remove(slogan);
		}
	}

	/**
	 * Removes all the slogans where companyId = &#63; from the database.
	 *
	 * @param companyId the company id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyId(long companyId) throws SystemException {
		for (Slogan slogan : findByCompanyId(companyId)) {
			remove(slogan);
		}
	}

	/**
	 * Removes all the slogans where sloganText = &#63; from the database.
	 *
	 * @param sloganText the slogan text to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBySloganText(String sloganText) throws SystemException {
		for (Slogan slogan : findBySloganText(sloganText)) {
			remove(slogan);
		}
	}

	/**
	 * Removes all the slogans where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @param status the status to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_S(long groupId, int status) throws SystemException {
		for (Slogan slogan : findByG_S(groupId, status)) {
			remove(slogan);
		}
	}

	/**
	 * Removes all the slogans from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Slogan slogan : findAll()) {
			remove(slogan);
		}
	}

	/**
	 * Counts all the slogans where uuid = &#63;.
	 *
	 * @param uuid the uuid to search with
	 * @return the number of matching slogans
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUuid(String uuid) throws SystemException {
		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SLOGAN_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the slogans where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @return the number of matching slogans
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID_G,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SLOGAN_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_G_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_G_UUID_2);
				}
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the slogans where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the number of matching slogans
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SLOGAN_WHERE);

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
	 * Filters by the user's permissions and counts all the slogans where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the number of matching slogans that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_SLOGAN_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Slogan.class.getName(), _FILTER_COLUMN_PK,
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
	 * Counts all the slogans where companyId = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @return the number of matching slogans
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyId(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SLOGAN_WHERE);

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
	 * Counts all the slogans where sloganText = &#63;.
	 *
	 * @param sloganText the slogan text to search with
	 * @return the number of matching slogans
	 * @throws SystemException if a system exception occurred
	 */
	public int countBySloganText(String sloganText) throws SystemException {
		Object[] finderArgs = new Object[] { sloganText };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SLOGANTEXT,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SLOGAN_WHERE);

			if (sloganText == null) {
				query.append(_FINDER_COLUMN_SLOGANTEXT_SLOGANTEXT_1);
			}
			else {
				if (sloganText.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_SLOGANTEXT_SLOGANTEXT_3);
				}
				else {
					query.append(_FINDER_COLUMN_SLOGANTEXT_SLOGANTEXT_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (sloganText != null) {
					qPos.add(sloganText);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SLOGANTEXT,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the slogans where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param status the status to search with
	 * @return the number of matching slogans
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_S(long groupId, int status) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_S,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SLOGAN_WHERE);

			query.append(_FINDER_COLUMN_G_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(status);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_S, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Filters by the user's permissions and counts all the slogans where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param status the status to search with
	 * @return the number of matching slogans that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByG_S(long groupId, int status)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_S(groupId, status);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_SLOGAN_WHERE);

		query.append(_FINDER_COLUMN_G_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Slogan.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(status);

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
	 * Counts all the slogans.
	 *
	 * @return the number of slogans
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

				Query q = session.createQuery(_SQL_COUNT_SLOGAN);

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
	 * Initializes the slogan persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.inkwell.internet.slogan.model.Slogan")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Slogan>> listenersList = new ArrayList<ModelListener<Slogan>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Slogan>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SloganImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
	}

	@BeanReference(type = SloganPersistence.class)
	protected SloganPersistence sloganPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;
	@BeanReference(type = RatingsStatsPersistence.class)
	protected RatingsStatsPersistence ratingsStatsPersistence;
	private static final String _SQL_SELECT_SLOGAN = "SELECT slogan FROM Slogan slogan";
	private static final String _SQL_SELECT_SLOGAN_WHERE = "SELECT slogan FROM Slogan slogan WHERE ";
	private static final String _SQL_COUNT_SLOGAN = "SELECT COUNT(slogan) FROM Slogan slogan";
	private static final String _SQL_COUNT_SLOGAN_WHERE = "SELECT COUNT(slogan) FROM Slogan slogan WHERE ";
	private static final String _FINDER_COLUMN_UUID_UUID_1 = "slogan.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "slogan.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(slogan.uuid IS NULL OR slogan.uuid = ?)";
	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "slogan.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "slogan.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(slogan.uuid IS NULL OR slogan.uuid = ?) AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "slogan.groupId = ?";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "slogan.groupId = ?";
	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "slogan.companyId = ?";
	private static final String _FINDER_COLUMN_SLOGANTEXT_SLOGANTEXT_1 = "slogan.sloganText IS NULL";
	private static final String _FINDER_COLUMN_SLOGANTEXT_SLOGANTEXT_2 = "slogan.sloganText = ?";
	private static final String _FINDER_COLUMN_SLOGANTEXT_SLOGANTEXT_3 = "(slogan.sloganText IS NULL OR slogan.sloganText = ?)";
	private static final String _FINDER_COLUMN_G_S_GROUPID_2 = "slogan.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_S_STATUS_2 = "slogan.status = ?";
	private static final String _FILTER_SQL_SELECT_SLOGAN_WHERE = "SELECT DISTINCT {slogan.*} FROM Slogan_Slogan slogan WHERE ";
	private static final String _FILTER_SQL_SELECT_SLOGAN_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {Slogan_Slogan.*} FROM (SELECT DISTINCT slogan.sloganId FROM Slogan_Slogan slogan WHERE ";
	private static final String _FILTER_SQL_SELECT_SLOGAN_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN Slogan_Slogan ON TEMP_TABLE.sloganId = Slogan_Slogan.sloganId";
	private static final String _FILTER_SQL_COUNT_SLOGAN_WHERE = "SELECT COUNT(DISTINCT slogan.sloganId) AS COUNT_VALUE FROM Slogan_Slogan slogan WHERE ";
	private static final String _FILTER_COLUMN_PK = "slogan.sloganId";
	private static final String _FILTER_COLUMN_USERID = "slogan.userId";
	private static final String _FILTER_ENTITY_ALIAS = "slogan";
	private static final String _FILTER_ENTITY_TABLE = "Slogan_Slogan";
	private static final String _ORDER_BY_ENTITY_ALIAS = "slogan.";
	private static final String _ORDER_BY_ENTITY_TABLE = "Slogan_Slogan.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Slogan exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Slogan exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(SloganPersistenceImpl.class);
}