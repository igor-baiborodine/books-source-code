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

import com.inkwell.internet.productregistration.NoSuchRegistrationException;
import com.inkwell.internet.productregistration.model.PRRegistration;
import com.inkwell.internet.productregistration.model.impl.PRRegistrationImpl;
import com.inkwell.internet.productregistration.model.impl.PRRegistrationModelImpl;

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
import com.liferay.portal.kernel.util.CalendarUtil;
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

import com.liferay.portlet.social.service.persistence.SocialActivityPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the p r registration service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link PRRegistrationUtil} to access the p r registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Rich Sezov
 * @see PRRegistrationPersistence
 * @see PRRegistrationUtil
 * @generated
 */
public class PRRegistrationPersistenceImpl extends BasePersistenceImpl<PRRegistration>
	implements PRRegistrationPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = PRRegistrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_GROUPID = new FinderPath(PRRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PRRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(PRRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PRRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByGroupId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_G_RU = new FinderPath(PRRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PRRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByG_RU",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_G_RU = new FinderPath(PRRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PRRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByG_RU",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_G_DP = new FinderPath(PRRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PRRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByG_DP",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_G_DP = new FinderPath(PRRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PRRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByG_DP",
			new String[] { Long.class.getName(), Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_G_SN = new FinderPath(PRRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PRRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByG_SN",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_G_SN = new FinderPath(PRRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PRRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByG_SN",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(PRRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PRRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PRRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PRRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	/**
	 * Caches the p r registration in the entity cache if it is enabled.
	 *
	 * @param prRegistration the p r registration to cache
	 */
	public void cacheResult(PRRegistration prRegistration) {
		EntityCacheUtil.putResult(PRRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PRRegistrationImpl.class, prRegistration.getPrimaryKey(),
			prRegistration);
	}

	/**
	 * Caches the p r registrations in the entity cache if it is enabled.
	 *
	 * @param prRegistrations the p r registrations to cache
	 */
	public void cacheResult(List<PRRegistration> prRegistrations) {
		for (PRRegistration prRegistration : prRegistrations) {
			if (EntityCacheUtil.getResult(
						PRRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						PRRegistrationImpl.class,
						prRegistration.getPrimaryKey(), this) == null) {
				cacheResult(prRegistration);
			}
		}
	}

	/**
	 * Clears the cache for all p r registrations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(PRRegistrationImpl.class.getName());
		EntityCacheUtil.clearCache(PRRegistrationImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the p r registration.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(PRRegistration prRegistration) {
		EntityCacheUtil.removeResult(PRRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PRRegistrationImpl.class, prRegistration.getPrimaryKey());
	}

	/**
	 * Creates a new p r registration with the primary key. Does not add the p r registration to the database.
	 *
	 * @param registrationId the primary key for the new p r registration
	 * @return the new p r registration
	 */
	public PRRegistration create(long registrationId) {
		PRRegistration prRegistration = new PRRegistrationImpl();

		prRegistration.setNew(true);
		prRegistration.setPrimaryKey(registrationId);

		return prRegistration;
	}

	/**
	 * Removes the p r registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the p r registration to remove
	 * @return the p r registration that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a p r registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRRegistration remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the p r registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param registrationId the primary key of the p r registration to remove
	 * @return the p r registration that was removed
	 * @throws com.inkwell.internet.productregistration.NoSuchRegistrationException if a p r registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRRegistration remove(long registrationId)
		throws NoSuchRegistrationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PRRegistration prRegistration = (PRRegistration)session.get(PRRegistrationImpl.class,
					new Long(registrationId));

			if (prRegistration == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
						registrationId);
				}

				throw new NoSuchRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					registrationId);
			}

			return remove(prRegistration);
		}
		catch (NoSuchRegistrationException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PRRegistration removeImpl(PRRegistration prRegistration)
		throws SystemException {
		prRegistration = toUnwrappedModel(prRegistration);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, prRegistration);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(PRRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PRRegistrationImpl.class, prRegistration.getPrimaryKey());

		return prRegistration;
	}

	public PRRegistration updateImpl(
		com.inkwell.internet.productregistration.model.PRRegistration prRegistration,
		boolean merge) throws SystemException {
		prRegistration = toUnwrappedModel(prRegistration);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, prRegistration, merge);

			prRegistration.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(PRRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PRRegistrationImpl.class, prRegistration.getPrimaryKey(),
			prRegistration);

		return prRegistration;
	}

	protected PRRegistration toUnwrappedModel(PRRegistration prRegistration) {
		if (prRegistration instanceof PRRegistrationImpl) {
			return prRegistration;
		}

		PRRegistrationImpl prRegistrationImpl = new PRRegistrationImpl();

		prRegistrationImpl.setNew(prRegistration.isNew());
		prRegistrationImpl.setPrimaryKey(prRegistration.getPrimaryKey());

		prRegistrationImpl.setRegistrationId(prRegistration.getRegistrationId());
		prRegistrationImpl.setPrUserId(prRegistration.getPrUserId());
		prRegistrationImpl.setDatePurchased(prRegistration.getDatePurchased());
		prRegistrationImpl.setHowHear(prRegistration.getHowHear());
		prRegistrationImpl.setWherePurchased(prRegistration.getWherePurchased());
		prRegistrationImpl.setSerialNumber(prRegistration.getSerialNumber());
		prRegistrationImpl.setProductId(prRegistration.getProductId());
		prRegistrationImpl.setCompanyId(prRegistration.getCompanyId());
		prRegistrationImpl.setGroupId(prRegistration.getGroupId());

		return prRegistrationImpl;
	}

	/**
	 * Finds the p r registration with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the p r registration to find
	 * @return the p r registration
	 * @throws com.liferay.portal.NoSuchModelException if a p r registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRRegistration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the p r registration with the primary key or throws a {@link com.inkwell.internet.productregistration.NoSuchRegistrationException} if it could not be found.
	 *
	 * @param registrationId the primary key of the p r registration to find
	 * @return the p r registration
	 * @throws com.inkwell.internet.productregistration.NoSuchRegistrationException if a p r registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRRegistration findByPrimaryKey(long registrationId)
		throws NoSuchRegistrationException, SystemException {
		PRRegistration prRegistration = fetchByPrimaryKey(registrationId);

		if (prRegistration == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + registrationId);
			}

			throw new NoSuchRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				registrationId);
		}

		return prRegistration;
	}

	/**
	 * Finds the p r registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the p r registration to find
	 * @return the p r registration, or <code>null</code> if a p r registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRRegistration fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the p r registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param registrationId the primary key of the p r registration to find
	 * @return the p r registration, or <code>null</code> if a p r registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRRegistration fetchByPrimaryKey(long registrationId)
		throws SystemException {
		PRRegistration prRegistration = (PRRegistration)EntityCacheUtil.getResult(PRRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				PRRegistrationImpl.class, registrationId, this);

		if (prRegistration == null) {
			Session session = null;

			try {
				session = openSession();

				prRegistration = (PRRegistration)session.get(PRRegistrationImpl.class,
						new Long(registrationId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (prRegistration != null) {
					cacheResult(prRegistration);
				}

				closeSession(session);
			}
		}

		return prRegistration;
	}

	/**
	 * Finds all the p r registrations where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the matching p r registrations
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRRegistration> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the p r registrations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of p r registrations to return
	 * @param end the upper bound of the range of p r registrations to return (not inclusive)
	 * @return the range of matching p r registrations
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRRegistration> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the p r registrations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of p r registrations to return
	 * @param end the upper bound of the range of p r registrations to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching p r registrations
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRRegistration> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<PRRegistration> list = (List<PRRegistration>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_GROUPID,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_PRREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<PRRegistration>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Finds the first p r registration in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching p r registration
	 * @throws com.inkwell.internet.productregistration.NoSuchRegistrationException if a matching p r registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRRegistration findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchRegistrationException, SystemException {
		List<PRRegistration> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRegistrationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last p r registration in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching p r registration
	 * @throws com.inkwell.internet.productregistration.NoSuchRegistrationException if a matching p r registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRRegistration findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchRegistrationException, SystemException {
		int count = countByGroupId(groupId);

		List<PRRegistration> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRegistrationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the p r registrations before and after the current p r registration in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param registrationId the primary key of the current p r registration
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next p r registration
	 * @throws com.inkwell.internet.productregistration.NoSuchRegistrationException if a p r registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRRegistration[] findByGroupId_PrevAndNext(long registrationId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchRegistrationException, SystemException {
		PRRegistration prRegistration = findByPrimaryKey(registrationId);

		Session session = null;

		try {
			session = openSession();

			PRRegistration[] array = new PRRegistrationImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, prRegistration,
					groupId, orderByComparator, true);

			array[1] = prRegistration;

			array[2] = getByGroupId_PrevAndNext(session, prRegistration,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PRRegistration getByGroupId_PrevAndNext(Session session,
		PRRegistration prRegistration, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRREGISTRATION_WHERE);

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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(prRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PRRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Filters by the user's permissions and finds all the p r registrations where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the matching p r registrations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRRegistration> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Filters by the user's permissions and finds a range of all the p r registrations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of p r registrations to return
	 * @param end the upper bound of the range of p r registrations to return (not inclusive)
	 * @return the range of matching p r registrations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRRegistration> filterFindByGroupId(long groupId, int start,
		int end) throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Filters by the user's permissions and finds an ordered range of all the p r registrations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of p r registrations to return
	 * @param end the upper bound of the range of p r registrations to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching p r registrations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRRegistration> filterFindByGroupId(long groupId, int start,
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
			query = new StringBundler(2);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PRREGISTRATION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PRREGISTRATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PRREGISTRATION_NO_INLINE_DISTINCT_WHERE_2);
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

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PRRegistration.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, PRRegistrationImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, PRRegistrationImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<PRRegistration>)QueryUtil.list(q, getDialect(), start,
				end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Finds all the p r registrations where groupId = &#63; and prUserId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param prUserId the pr user id to search with
	 * @return the matching p r registrations
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRRegistration> findByG_RU(long groupId, long prUserId)
		throws SystemException {
		return findByG_RU(groupId, prUserId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the p r registrations where groupId = &#63; and prUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param prUserId the pr user id to search with
	 * @param start the lower bound of the range of p r registrations to return
	 * @param end the upper bound of the range of p r registrations to return (not inclusive)
	 * @return the range of matching p r registrations
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRRegistration> findByG_RU(long groupId, long prUserId,
		int start, int end) throws SystemException {
		return findByG_RU(groupId, prUserId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the p r registrations where groupId = &#63; and prUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param prUserId the pr user id to search with
	 * @param start the lower bound of the range of p r registrations to return
	 * @param end the upper bound of the range of p r registrations to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching p r registrations
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRRegistration> findByG_RU(long groupId, long prUserId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, prUserId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<PRRegistration> list = (List<PRRegistration>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_G_RU,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PRREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_G_RU_GROUPID_2);

			query.append(_FINDER_COLUMN_G_RU_PRUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(prUserId);

				list = (List<PRRegistration>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_G_RU,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_G_RU,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first p r registration in the ordered set where groupId = &#63; and prUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param prUserId the pr user id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching p r registration
	 * @throws com.inkwell.internet.productregistration.NoSuchRegistrationException if a matching p r registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRRegistration findByG_RU_First(long groupId, long prUserId,
		OrderByComparator orderByComparator)
		throws NoSuchRegistrationException, SystemException {
		List<PRRegistration> list = findByG_RU(groupId, prUserId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", prUserId=");
			msg.append(prUserId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRegistrationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last p r registration in the ordered set where groupId = &#63; and prUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param prUserId the pr user id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching p r registration
	 * @throws com.inkwell.internet.productregistration.NoSuchRegistrationException if a matching p r registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRRegistration findByG_RU_Last(long groupId, long prUserId,
		OrderByComparator orderByComparator)
		throws NoSuchRegistrationException, SystemException {
		int count = countByG_RU(groupId, prUserId);

		List<PRRegistration> list = findByG_RU(groupId, prUserId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", prUserId=");
			msg.append(prUserId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRegistrationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the p r registrations before and after the current p r registration in the ordered set where groupId = &#63; and prUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param registrationId the primary key of the current p r registration
	 * @param groupId the group id to search with
	 * @param prUserId the pr user id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next p r registration
	 * @throws com.inkwell.internet.productregistration.NoSuchRegistrationException if a p r registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRRegistration[] findByG_RU_PrevAndNext(long registrationId,
		long groupId, long prUserId, OrderByComparator orderByComparator)
		throws NoSuchRegistrationException, SystemException {
		PRRegistration prRegistration = findByPrimaryKey(registrationId);

		Session session = null;

		try {
			session = openSession();

			PRRegistration[] array = new PRRegistrationImpl[3];

			array[0] = getByG_RU_PrevAndNext(session, prRegistration, groupId,
					prUserId, orderByComparator, true);

			array[1] = prRegistration;

			array[2] = getByG_RU_PrevAndNext(session, prRegistration, groupId,
					prUserId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PRRegistration getByG_RU_PrevAndNext(Session session,
		PRRegistration prRegistration, long groupId, long prUserId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_G_RU_GROUPID_2);

		query.append(_FINDER_COLUMN_G_RU_PRUSERID_2);

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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(prUserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(prRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PRRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Filters by the user's permissions and finds all the p r registrations where groupId = &#63; and prUserId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param prUserId the pr user id to search with
	 * @return the matching p r registrations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRRegistration> filterFindByG_RU(long groupId, long prUserId)
		throws SystemException {
		return filterFindByG_RU(groupId, prUserId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Filters by the user's permissions and finds a range of all the p r registrations where groupId = &#63; and prUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param prUserId the pr user id to search with
	 * @param start the lower bound of the range of p r registrations to return
	 * @param end the upper bound of the range of p r registrations to return (not inclusive)
	 * @return the range of matching p r registrations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRRegistration> filterFindByG_RU(long groupId, long prUserId,
		int start, int end) throws SystemException {
		return filterFindByG_RU(groupId, prUserId, start, end, null);
	}

	/**
	 * Filters by the user's permissions and finds an ordered range of all the p r registrations where groupId = &#63; and prUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param prUserId the pr user id to search with
	 * @param start the lower bound of the range of p r registrations to return
	 * @param end the upper bound of the range of p r registrations to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching p r registrations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRRegistration> filterFindByG_RU(long groupId, long prUserId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_RU(groupId, prUserId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PRREGISTRATION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PRREGISTRATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_RU_GROUPID_2);

		query.append(_FINDER_COLUMN_G_RU_PRUSERID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PRREGISTRATION_NO_INLINE_DISTINCT_WHERE_2);
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

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PRRegistration.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, PRRegistrationImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, PRRegistrationImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(prUserId);

			return (List<PRRegistration>)QueryUtil.list(q, getDialect(), start,
				end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Finds all the p r registrations where groupId = &#63; and datePurchased = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param datePurchased the date purchased to search with
	 * @return the matching p r registrations
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRRegistration> findByG_DP(long groupId, Date datePurchased)
		throws SystemException {
		return findByG_DP(groupId, datePurchased, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the p r registrations where groupId = &#63; and datePurchased = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param datePurchased the date purchased to search with
	 * @param start the lower bound of the range of p r registrations to return
	 * @param end the upper bound of the range of p r registrations to return (not inclusive)
	 * @return the range of matching p r registrations
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRRegistration> findByG_DP(long groupId, Date datePurchased,
		int start, int end) throws SystemException {
		return findByG_DP(groupId, datePurchased, start, end, null);
	}

	/**
	 * Finds an ordered range of all the p r registrations where groupId = &#63; and datePurchased = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param datePurchased the date purchased to search with
	 * @param start the lower bound of the range of p r registrations to return
	 * @param end the upper bound of the range of p r registrations to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching p r registrations
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRRegistration> findByG_DP(long groupId, Date datePurchased,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, datePurchased,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<PRRegistration> list = (List<PRRegistration>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_G_DP,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PRREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_G_DP_GROUPID_2);

			if (datePurchased == null) {
				query.append(_FINDER_COLUMN_G_DP_DATEPURCHASED_1);
			}
			else {
				query.append(_FINDER_COLUMN_G_DP_DATEPURCHASED_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (datePurchased != null) {
					qPos.add(CalendarUtil.getTimestamp(datePurchased));
				}

				list = (List<PRRegistration>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_G_DP,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_G_DP,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first p r registration in the ordered set where groupId = &#63; and datePurchased = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param datePurchased the date purchased to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching p r registration
	 * @throws com.inkwell.internet.productregistration.NoSuchRegistrationException if a matching p r registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRRegistration findByG_DP_First(long groupId, Date datePurchased,
		OrderByComparator orderByComparator)
		throws NoSuchRegistrationException, SystemException {
		List<PRRegistration> list = findByG_DP(groupId, datePurchased, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", datePurchased=");
			msg.append(datePurchased);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRegistrationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last p r registration in the ordered set where groupId = &#63; and datePurchased = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param datePurchased the date purchased to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching p r registration
	 * @throws com.inkwell.internet.productregistration.NoSuchRegistrationException if a matching p r registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRRegistration findByG_DP_Last(long groupId, Date datePurchased,
		OrderByComparator orderByComparator)
		throws NoSuchRegistrationException, SystemException {
		int count = countByG_DP(groupId, datePurchased);

		List<PRRegistration> list = findByG_DP(groupId, datePurchased,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", datePurchased=");
			msg.append(datePurchased);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRegistrationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the p r registrations before and after the current p r registration in the ordered set where groupId = &#63; and datePurchased = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param registrationId the primary key of the current p r registration
	 * @param groupId the group id to search with
	 * @param datePurchased the date purchased to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next p r registration
	 * @throws com.inkwell.internet.productregistration.NoSuchRegistrationException if a p r registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRRegistration[] findByG_DP_PrevAndNext(long registrationId,
		long groupId, Date datePurchased, OrderByComparator orderByComparator)
		throws NoSuchRegistrationException, SystemException {
		PRRegistration prRegistration = findByPrimaryKey(registrationId);

		Session session = null;

		try {
			session = openSession();

			PRRegistration[] array = new PRRegistrationImpl[3];

			array[0] = getByG_DP_PrevAndNext(session, prRegistration, groupId,
					datePurchased, orderByComparator, true);

			array[1] = prRegistration;

			array[2] = getByG_DP_PrevAndNext(session, prRegistration, groupId,
					datePurchased, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PRRegistration getByG_DP_PrevAndNext(Session session,
		PRRegistration prRegistration, long groupId, Date datePurchased,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_G_DP_GROUPID_2);

		if (datePurchased == null) {
			query.append(_FINDER_COLUMN_G_DP_DATEPURCHASED_1);
		}
		else {
			query.append(_FINDER_COLUMN_G_DP_DATEPURCHASED_2);
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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (datePurchased != null) {
			qPos.add(CalendarUtil.getTimestamp(datePurchased));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(prRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PRRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Filters by the user's permissions and finds all the p r registrations where groupId = &#63; and datePurchased = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param datePurchased the date purchased to search with
	 * @return the matching p r registrations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRRegistration> filterFindByG_DP(long groupId,
		Date datePurchased) throws SystemException {
		return filterFindByG_DP(groupId, datePurchased, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Filters by the user's permissions and finds a range of all the p r registrations where groupId = &#63; and datePurchased = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param datePurchased the date purchased to search with
	 * @param start the lower bound of the range of p r registrations to return
	 * @param end the upper bound of the range of p r registrations to return (not inclusive)
	 * @return the range of matching p r registrations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRRegistration> filterFindByG_DP(long groupId,
		Date datePurchased, int start, int end) throws SystemException {
		return filterFindByG_DP(groupId, datePurchased, start, end, null);
	}

	/**
	 * Filters by the user's permissions and finds an ordered range of all the p r registrations where groupId = &#63; and datePurchased = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param datePurchased the date purchased to search with
	 * @param start the lower bound of the range of p r registrations to return
	 * @param end the upper bound of the range of p r registrations to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching p r registrations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRRegistration> filterFindByG_DP(long groupId,
		Date datePurchased, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_DP(groupId, datePurchased, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PRREGISTRATION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PRREGISTRATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_DP_GROUPID_2);

		if (datePurchased == null) {
			query.append(_FINDER_COLUMN_G_DP_DATEPURCHASED_1);
		}
		else {
			query.append(_FINDER_COLUMN_G_DP_DATEPURCHASED_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PRREGISTRATION_NO_INLINE_DISTINCT_WHERE_2);
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

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PRRegistration.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, PRRegistrationImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, PRRegistrationImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (datePurchased != null) {
				qPos.add(CalendarUtil.getTimestamp(datePurchased));
			}

			return (List<PRRegistration>)QueryUtil.list(q, getDialect(), start,
				end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Finds all the p r registrations where groupId = &#63; and serialNumber = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param serialNumber the serial number to search with
	 * @return the matching p r registrations
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRRegistration> findByG_SN(long groupId, String serialNumber)
		throws SystemException {
		return findByG_SN(groupId, serialNumber, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the p r registrations where groupId = &#63; and serialNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param serialNumber the serial number to search with
	 * @param start the lower bound of the range of p r registrations to return
	 * @param end the upper bound of the range of p r registrations to return (not inclusive)
	 * @return the range of matching p r registrations
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRRegistration> findByG_SN(long groupId, String serialNumber,
		int start, int end) throws SystemException {
		return findByG_SN(groupId, serialNumber, start, end, null);
	}

	/**
	 * Finds an ordered range of all the p r registrations where groupId = &#63; and serialNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param serialNumber the serial number to search with
	 * @param start the lower bound of the range of p r registrations to return
	 * @param end the upper bound of the range of p r registrations to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching p r registrations
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRRegistration> findByG_SN(long groupId, String serialNumber,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, serialNumber,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<PRRegistration> list = (List<PRRegistration>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_G_SN,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PRREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_G_SN_GROUPID_2);

			if (serialNumber == null) {
				query.append(_FINDER_COLUMN_G_SN_SERIALNUMBER_1);
			}
			else {
				if (serialNumber.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_SN_SERIALNUMBER_3);
				}
				else {
					query.append(_FINDER_COLUMN_G_SN_SERIALNUMBER_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (serialNumber != null) {
					qPos.add(serialNumber);
				}

				list = (List<PRRegistration>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_G_SN,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_G_SN,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first p r registration in the ordered set where groupId = &#63; and serialNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param serialNumber the serial number to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching p r registration
	 * @throws com.inkwell.internet.productregistration.NoSuchRegistrationException if a matching p r registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRRegistration findByG_SN_First(long groupId, String serialNumber,
		OrderByComparator orderByComparator)
		throws NoSuchRegistrationException, SystemException {
		List<PRRegistration> list = findByG_SN(groupId, serialNumber, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", serialNumber=");
			msg.append(serialNumber);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRegistrationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last p r registration in the ordered set where groupId = &#63; and serialNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param serialNumber the serial number to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching p r registration
	 * @throws com.inkwell.internet.productregistration.NoSuchRegistrationException if a matching p r registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRRegistration findByG_SN_Last(long groupId, String serialNumber,
		OrderByComparator orderByComparator)
		throws NoSuchRegistrationException, SystemException {
		int count = countByG_SN(groupId, serialNumber);

		List<PRRegistration> list = findByG_SN(groupId, serialNumber,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", serialNumber=");
			msg.append(serialNumber);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRegistrationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the p r registrations before and after the current p r registration in the ordered set where groupId = &#63; and serialNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param registrationId the primary key of the current p r registration
	 * @param groupId the group id to search with
	 * @param serialNumber the serial number to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next p r registration
	 * @throws com.inkwell.internet.productregistration.NoSuchRegistrationException if a p r registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRRegistration[] findByG_SN_PrevAndNext(long registrationId,
		long groupId, String serialNumber, OrderByComparator orderByComparator)
		throws NoSuchRegistrationException, SystemException {
		PRRegistration prRegistration = findByPrimaryKey(registrationId);

		Session session = null;

		try {
			session = openSession();

			PRRegistration[] array = new PRRegistrationImpl[3];

			array[0] = getByG_SN_PrevAndNext(session, prRegistration, groupId,
					serialNumber, orderByComparator, true);

			array[1] = prRegistration;

			array[2] = getByG_SN_PrevAndNext(session, prRegistration, groupId,
					serialNumber, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PRRegistration getByG_SN_PrevAndNext(Session session,
		PRRegistration prRegistration, long groupId, String serialNumber,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_G_SN_GROUPID_2);

		if (serialNumber == null) {
			query.append(_FINDER_COLUMN_G_SN_SERIALNUMBER_1);
		}
		else {
			if (serialNumber.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_SN_SERIALNUMBER_3);
			}
			else {
				query.append(_FINDER_COLUMN_G_SN_SERIALNUMBER_2);
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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (serialNumber != null) {
			qPos.add(serialNumber);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(prRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PRRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Filters by the user's permissions and finds all the p r registrations where groupId = &#63; and serialNumber = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param serialNumber the serial number to search with
	 * @return the matching p r registrations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRRegistration> filterFindByG_SN(long groupId,
		String serialNumber) throws SystemException {
		return filterFindByG_SN(groupId, serialNumber, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Filters by the user's permissions and finds a range of all the p r registrations where groupId = &#63; and serialNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param serialNumber the serial number to search with
	 * @param start the lower bound of the range of p r registrations to return
	 * @param end the upper bound of the range of p r registrations to return (not inclusive)
	 * @return the range of matching p r registrations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRRegistration> filterFindByG_SN(long groupId,
		String serialNumber, int start, int end) throws SystemException {
		return filterFindByG_SN(groupId, serialNumber, start, end, null);
	}

	/**
	 * Filters by the user's permissions and finds an ordered range of all the p r registrations where groupId = &#63; and serialNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param serialNumber the serial number to search with
	 * @param start the lower bound of the range of p r registrations to return
	 * @param end the upper bound of the range of p r registrations to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching p r registrations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRRegistration> filterFindByG_SN(long groupId,
		String serialNumber, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_SN(groupId, serialNumber, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PRREGISTRATION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PRREGISTRATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_SN_GROUPID_2);

		if (serialNumber == null) {
			query.append(_FINDER_COLUMN_G_SN_SERIALNUMBER_1);
		}
		else {
			if (serialNumber.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_SN_SERIALNUMBER_3);
			}
			else {
				query.append(_FINDER_COLUMN_G_SN_SERIALNUMBER_2);
			}
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PRREGISTRATION_NO_INLINE_DISTINCT_WHERE_2);
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

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PRRegistration.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, PRRegistrationImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, PRRegistrationImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (serialNumber != null) {
				qPos.add(serialNumber);
			}

			return (List<PRRegistration>)QueryUtil.list(q, getDialect(), start,
				end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Finds all the p r registrations.
	 *
	 * @return the p r registrations
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRRegistration> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the p r registrations.
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
	public List<PRRegistration> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the p r registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of p r registrations to return
	 * @param end the upper bound of the range of p r registrations to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of p r registrations
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRRegistration> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<PRRegistration> list = (List<PRRegistration>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PRREGISTRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PRREGISTRATION;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<PRRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<PRRegistration>)QueryUtil.list(q,
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
	 * Removes all the p r registrations where groupId = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (PRRegistration prRegistration : findByGroupId(groupId)) {
			remove(prRegistration);
		}
	}

	/**
	 * Removes all the p r registrations where groupId = &#63; and prUserId = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @param prUserId the pr user id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_RU(long groupId, long prUserId)
		throws SystemException {
		for (PRRegistration prRegistration : findByG_RU(groupId, prUserId)) {
			remove(prRegistration);
		}
	}

	/**
	 * Removes all the p r registrations where groupId = &#63; and datePurchased = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @param datePurchased the date purchased to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_DP(long groupId, Date datePurchased)
		throws SystemException {
		for (PRRegistration prRegistration : findByG_DP(groupId, datePurchased)) {
			remove(prRegistration);
		}
	}

	/**
	 * Removes all the p r registrations where groupId = &#63; and serialNumber = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @param serialNumber the serial number to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_SN(long groupId, String serialNumber)
		throws SystemException {
		for (PRRegistration prRegistration : findByG_SN(groupId, serialNumber)) {
			remove(prRegistration);
		}
	}

	/**
	 * Removes all the p r registrations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (PRRegistration prRegistration : findAll()) {
			remove(prRegistration);
		}
	}

	/**
	 * Counts all the p r registrations where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the number of matching p r registrations
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PRREGISTRATION_WHERE);

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
	 * Filters by the user's permissions and counts all the p r registrations where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the number of matching p r registrations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_PRREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PRRegistration.class.getName(), _FILTER_COLUMN_PK,
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
	 * Counts all the p r registrations where groupId = &#63; and prUserId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param prUserId the pr user id to search with
	 * @return the number of matching p r registrations
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_RU(long groupId, long prUserId)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, prUserId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_RU,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PRREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_G_RU_GROUPID_2);

			query.append(_FINDER_COLUMN_G_RU_PRUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(prUserId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_RU,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Filters by the user's permissions and counts all the p r registrations where groupId = &#63; and prUserId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param prUserId the pr user id to search with
	 * @return the number of matching p r registrations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByG_RU(long groupId, long prUserId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_RU(groupId, prUserId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_PRREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_G_RU_GROUPID_2);

		query.append(_FINDER_COLUMN_G_RU_PRUSERID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PRRegistration.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(prUserId);

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
	 * Counts all the p r registrations where groupId = &#63; and datePurchased = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param datePurchased the date purchased to search with
	 * @return the number of matching p r registrations
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_DP(long groupId, Date datePurchased)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, datePurchased };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_DP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PRREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_G_DP_GROUPID_2);

			if (datePurchased == null) {
				query.append(_FINDER_COLUMN_G_DP_DATEPURCHASED_1);
			}
			else {
				query.append(_FINDER_COLUMN_G_DP_DATEPURCHASED_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (datePurchased != null) {
					qPos.add(CalendarUtil.getTimestamp(datePurchased));
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_DP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Filters by the user's permissions and counts all the p r registrations where groupId = &#63; and datePurchased = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param datePurchased the date purchased to search with
	 * @return the number of matching p r registrations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByG_DP(long groupId, Date datePurchased)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_DP(groupId, datePurchased);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_PRREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_G_DP_GROUPID_2);

		if (datePurchased == null) {
			query.append(_FINDER_COLUMN_G_DP_DATEPURCHASED_1);
		}
		else {
			query.append(_FINDER_COLUMN_G_DP_DATEPURCHASED_2);
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PRRegistration.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (datePurchased != null) {
				qPos.add(CalendarUtil.getTimestamp(datePurchased));
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
	 * Counts all the p r registrations where groupId = &#63; and serialNumber = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param serialNumber the serial number to search with
	 * @return the number of matching p r registrations
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_SN(long groupId, String serialNumber)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, serialNumber };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_SN,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PRREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_G_SN_GROUPID_2);

			if (serialNumber == null) {
				query.append(_FINDER_COLUMN_G_SN_SERIALNUMBER_1);
			}
			else {
				if (serialNumber.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_SN_SERIALNUMBER_3);
				}
				else {
					query.append(_FINDER_COLUMN_G_SN_SERIALNUMBER_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (serialNumber != null) {
					qPos.add(serialNumber);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_SN,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Filters by the user's permissions and counts all the p r registrations where groupId = &#63; and serialNumber = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param serialNumber the serial number to search with
	 * @return the number of matching p r registrations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByG_SN(long groupId, String serialNumber)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_SN(groupId, serialNumber);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_PRREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_G_SN_GROUPID_2);

		if (serialNumber == null) {
			query.append(_FINDER_COLUMN_G_SN_SERIALNUMBER_1);
		}
		else {
			if (serialNumber.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_SN_SERIALNUMBER_3);
			}
			else {
				query.append(_FINDER_COLUMN_G_SN_SERIALNUMBER_2);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PRRegistration.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (serialNumber != null) {
				qPos.add(serialNumber);
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
	 * Counts all the p r registrations.
	 *
	 * @return the number of p r registrations
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

				Query q = session.createQuery(_SQL_COUNT_PRREGISTRATION);

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
	 * Initializes the p r registration persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.inkwell.internet.productregistration.model.PRRegistration")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PRRegistration>> listenersList = new ArrayList<ModelListener<PRRegistration>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PRRegistration>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PRRegistrationImpl.class.getName());
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
	@BeanReference(type = SocialActivityPersistence.class)
	protected SocialActivityPersistence socialActivityPersistence;
	private static final String _SQL_SELECT_PRREGISTRATION = "SELECT prRegistration FROM PRRegistration prRegistration";
	private static final String _SQL_SELECT_PRREGISTRATION_WHERE = "SELECT prRegistration FROM PRRegistration prRegistration WHERE ";
	private static final String _SQL_COUNT_PRREGISTRATION = "SELECT COUNT(prRegistration) FROM PRRegistration prRegistration";
	private static final String _SQL_COUNT_PRREGISTRATION_WHERE = "SELECT COUNT(prRegistration) FROM PRRegistration prRegistration WHERE ";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "prRegistration.groupId = ?";
	private static final String _FINDER_COLUMN_G_RU_GROUPID_2 = "prRegistration.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_RU_PRUSERID_2 = "prRegistration.prUserId = ?";
	private static final String _FINDER_COLUMN_G_DP_GROUPID_2 = "prRegistration.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_DP_DATEPURCHASED_1 = "prRegistration.datePurchased IS NULL";
	private static final String _FINDER_COLUMN_G_DP_DATEPURCHASED_2 = "prRegistration.datePurchased = ?";
	private static final String _FINDER_COLUMN_G_SN_GROUPID_2 = "prRegistration.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_SN_SERIALNUMBER_1 = "prRegistration.serialNumber IS NULL";
	private static final String _FINDER_COLUMN_G_SN_SERIALNUMBER_2 = "prRegistration.serialNumber = ?";
	private static final String _FINDER_COLUMN_G_SN_SERIALNUMBER_3 = "(prRegistration.serialNumber IS NULL OR prRegistration.serialNumber = ?)";
	private static final String _FILTER_SQL_SELECT_PRREGISTRATION_WHERE = "SELECT DISTINCT {prRegistration.*} FROM PR_PRRegistration prRegistration WHERE ";
	private static final String _FILTER_SQL_SELECT_PRREGISTRATION_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {PR_PRRegistration.*} FROM (SELECT DISTINCT prRegistration.registrationId FROM PR_PRRegistration prRegistration WHERE ";
	private static final String _FILTER_SQL_SELECT_PRREGISTRATION_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN PR_PRRegistration ON TEMP_TABLE.registrationId = PR_PRRegistration.registrationId";
	private static final String _FILTER_SQL_COUNT_PRREGISTRATION_WHERE = "SELECT COUNT(DISTINCT prRegistration.registrationId) AS COUNT_VALUE FROM PR_PRRegistration prRegistration WHERE ";
	private static final String _FILTER_COLUMN_PK = "prRegistration.registrationId";
	private static final String _FILTER_COLUMN_USERID = null;
	private static final String _FILTER_ENTITY_ALIAS = "prRegistration";
	private static final String _FILTER_ENTITY_TABLE = "PR_PRRegistration";
	private static final String _ORDER_BY_ENTITY_ALIAS = "prRegistration.";
	private static final String _ORDER_BY_ENTITY_TABLE = "PR_PRRegistration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PRRegistration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PRRegistration exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(PRRegistrationPersistenceImpl.class);
}