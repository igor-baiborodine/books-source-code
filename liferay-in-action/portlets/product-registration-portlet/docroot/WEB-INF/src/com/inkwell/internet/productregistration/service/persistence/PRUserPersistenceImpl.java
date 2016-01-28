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

import com.inkwell.internet.productregistration.NoSuchUserException;
import com.inkwell.internet.productregistration.model.PRUser;
import com.inkwell.internet.productregistration.model.impl.PRUserImpl;
import com.inkwell.internet.productregistration.model.impl.PRUserModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQuery;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQueryFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.RowMapper;
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
 * The persistence implementation for the p r user service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link PRUserUtil} to access the p r user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Rich Sezov
 * @see PRUserPersistence
 * @see PRUserUtil
 * @generated
 */
public class PRUserPersistenceImpl extends BasePersistenceImpl<PRUser>
	implements PRUserPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = PRUserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_G_LN = new FinderPath(PRUserModelImpl.ENTITY_CACHE_ENABLED,
			PRUserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByG_LN",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_G_LN = new FinderPath(PRUserModelImpl.ENTITY_CACHE_ENABLED,
			PRUserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByG_LN",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_G_E = new FinderPath(PRUserModelImpl.ENTITY_CACHE_ENABLED,
			PRUserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByG_E",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_G_E = new FinderPath(PRUserModelImpl.ENTITY_CACHE_ENABLED,
			PRUserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByG_E",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_G_U = new FinderPath(PRUserModelImpl.ENTITY_CACHE_ENABLED,
			PRUserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByG_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_G_U = new FinderPath(PRUserModelImpl.ENTITY_CACHE_ENABLED,
			PRUserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByG_U",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(PRUserModelImpl.ENTITY_CACHE_ENABLED,
			PRUserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PRUserModelImpl.ENTITY_CACHE_ENABLED,
			PRUserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the p r user in the entity cache if it is enabled.
	 *
	 * @param prUser the p r user to cache
	 */
	public void cacheResult(PRUser prUser) {
		EntityCacheUtil.putResult(PRUserModelImpl.ENTITY_CACHE_ENABLED,
			PRUserImpl.class, prUser.getPrimaryKey(), prUser);
	}

	/**
	 * Caches the p r users in the entity cache if it is enabled.
	 *
	 * @param prUsers the p r users to cache
	 */
	public void cacheResult(List<PRUser> prUsers) {
		for (PRUser prUser : prUsers) {
			if (EntityCacheUtil.getResult(
						PRUserModelImpl.ENTITY_CACHE_ENABLED, PRUserImpl.class,
						prUser.getPrimaryKey(), this) == null) {
				cacheResult(prUser);
			}
		}
	}

	/**
	 * Clears the cache for all p r users.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(PRUserImpl.class.getName());
		EntityCacheUtil.clearCache(PRUserImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the p r user.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(PRUser prUser) {
		EntityCacheUtil.removeResult(PRUserModelImpl.ENTITY_CACHE_ENABLED,
			PRUserImpl.class, prUser.getPrimaryKey());
	}

	/**
	 * Creates a new p r user with the primary key. Does not add the p r user to the database.
	 *
	 * @param prUserId the primary key for the new p r user
	 * @return the new p r user
	 */
	public PRUser create(long prUserId) {
		PRUser prUser = new PRUserImpl();

		prUser.setNew(true);
		prUser.setPrimaryKey(prUserId);

		return prUser;
	}

	/**
	 * Removes the p r user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the p r user to remove
	 * @return the p r user that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a p r user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRUser remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the p r user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param prUserId the primary key of the p r user to remove
	 * @return the p r user that was removed
	 * @throws com.inkwell.internet.productregistration.NoSuchUserException if a p r user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRUser remove(long prUserId)
		throws NoSuchUserException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PRUser prUser = (PRUser)session.get(PRUserImpl.class,
					new Long(prUserId));

			if (prUser == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + prUserId);
				}

				throw new NoSuchUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					prUserId);
			}

			return remove(prUser);
		}
		catch (NoSuchUserException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PRUser removeImpl(PRUser prUser) throws SystemException {
		prUser = toUnwrappedModel(prUser);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, prUser);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(PRUserModelImpl.ENTITY_CACHE_ENABLED,
			PRUserImpl.class, prUser.getPrimaryKey());

		return prUser;
	}

	public PRUser updateImpl(
		com.inkwell.internet.productregistration.model.PRUser prUser,
		boolean merge) throws SystemException {
		prUser = toUnwrappedModel(prUser);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, prUser, merge);

			prUser.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(PRUserModelImpl.ENTITY_CACHE_ENABLED,
			PRUserImpl.class, prUser.getPrimaryKey(), prUser);

		return prUser;
	}

	protected PRUser toUnwrappedModel(PRUser prUser) {
		if (prUser instanceof PRUserImpl) {
			return prUser;
		}

		PRUserImpl prUserImpl = new PRUserImpl();

		prUserImpl.setNew(prUser.isNew());
		prUserImpl.setPrimaryKey(prUser.getPrimaryKey());

		prUserImpl.setPrUserId(prUser.getPrUserId());
		prUserImpl.setFirstName(prUser.getFirstName());
		prUserImpl.setLastName(prUser.getLastName());
		prUserImpl.setAddress1(prUser.getAddress1());
		prUserImpl.setAddress2(prUser.getAddress2());
		prUserImpl.setCity(prUser.getCity());
		prUserImpl.setState(prUser.getState());
		prUserImpl.setPostalCode(prUser.getPostalCode());
		prUserImpl.setCountry(prUser.getCountry());
		prUserImpl.setPhoneNumber(prUser.getPhoneNumber());
		prUserImpl.setEmail(prUser.getEmail());
		prUserImpl.setBirthDate(prUser.getBirthDate());
		prUserImpl.setMale(prUser.isMale());
		prUserImpl.setUserId(prUser.getUserId());
		prUserImpl.setCompanyId(prUser.getCompanyId());
		prUserImpl.setGroupId(prUser.getGroupId());

		return prUserImpl;
	}

	/**
	 * Finds the p r user with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the p r user to find
	 * @return the p r user
	 * @throws com.liferay.portal.NoSuchModelException if a p r user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the p r user with the primary key or throws a {@link com.inkwell.internet.productregistration.NoSuchUserException} if it could not be found.
	 *
	 * @param prUserId the primary key of the p r user to find
	 * @return the p r user
	 * @throws com.inkwell.internet.productregistration.NoSuchUserException if a p r user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRUser findByPrimaryKey(long prUserId)
		throws NoSuchUserException, SystemException {
		PRUser prUser = fetchByPrimaryKey(prUserId);

		if (prUser == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + prUserId);
			}

			throw new NoSuchUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				prUserId);
		}

		return prUser;
	}

	/**
	 * Finds the p r user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the p r user to find
	 * @return the p r user, or <code>null</code> if a p r user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRUser fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the p r user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param prUserId the primary key of the p r user to find
	 * @return the p r user, or <code>null</code> if a p r user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PRUser fetchByPrimaryKey(long prUserId) throws SystemException {
		PRUser prUser = (PRUser)EntityCacheUtil.getResult(PRUserModelImpl.ENTITY_CACHE_ENABLED,
				PRUserImpl.class, prUserId, this);

		if (prUser == null) {
			Session session = null;

			try {
				session = openSession();

				prUser = (PRUser)session.get(PRUserImpl.class,
						new Long(prUserId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (prUser != null) {
					cacheResult(prUser);
				}

				closeSession(session);
			}
		}

		return prUser;
	}

	/**
	 * Finds all the p r users where groupId = &#63; and lastName = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param lastName the last name to search with
	 * @return the matching p r users
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRUser> findByG_LN(long groupId, String lastName)
		throws SystemException {
		return findByG_LN(groupId, lastName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<PRUser> findByG_LN(long groupId, String lastName, int start,
		int end) throws SystemException {
		return findByG_LN(groupId, lastName, start, end, null);
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
	public List<PRUser> findByG_LN(long groupId, String lastName, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, lastName,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<PRUser> list = (List<PRUser>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_G_LN,
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

			query.append(_SQL_SELECT_PRUSER_WHERE);

			query.append(_FINDER_COLUMN_G_LN_GROUPID_2);

			if (lastName == null) {
				query.append(_FINDER_COLUMN_G_LN_LASTNAME_1);
			}
			else {
				if (lastName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_LN_LASTNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_G_LN_LASTNAME_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PRUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (lastName != null) {
					qPos.add(lastName);
				}

				list = (List<PRUser>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_G_LN,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_G_LN,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public PRUser findByG_LN_First(long groupId, String lastName,
		OrderByComparator orderByComparator)
		throws NoSuchUserException, SystemException {
		List<PRUser> list = findByG_LN(groupId, lastName, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", lastName=");
			msg.append(lastName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public PRUser findByG_LN_Last(long groupId, String lastName,
		OrderByComparator orderByComparator)
		throws NoSuchUserException, SystemException {
		int count = countByG_LN(groupId, lastName);

		List<PRUser> list = findByG_LN(groupId, lastName, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", lastName=");
			msg.append(lastName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public PRUser[] findByG_LN_PrevAndNext(long prUserId, long groupId,
		String lastName, OrderByComparator orderByComparator)
		throws NoSuchUserException, SystemException {
		PRUser prUser = findByPrimaryKey(prUserId);

		Session session = null;

		try {
			session = openSession();

			PRUser[] array = new PRUserImpl[3];

			array[0] = getByG_LN_PrevAndNext(session, prUser, groupId,
					lastName, orderByComparator, true);

			array[1] = prUser;

			array[2] = getByG_LN_PrevAndNext(session, prUser, groupId,
					lastName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PRUser getByG_LN_PrevAndNext(Session session, PRUser prUser,
		long groupId, String lastName, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRUSER_WHERE);

		query.append(_FINDER_COLUMN_G_LN_GROUPID_2);

		if (lastName == null) {
			query.append(_FINDER_COLUMN_G_LN_LASTNAME_1);
		}
		else {
			if (lastName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_LN_LASTNAME_3);
			}
			else {
				query.append(_FINDER_COLUMN_G_LN_LASTNAME_2);
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
			query.append(PRUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (lastName != null) {
			qPos.add(lastName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(prUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PRUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Filters by the user's permissions and finds all the p r users where groupId = &#63; and lastName = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param lastName the last name to search with
	 * @return the matching p r users that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRUser> filterFindByG_LN(long groupId, String lastName)
		throws SystemException {
		return filterFindByG_LN(groupId, lastName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<PRUser> filterFindByG_LN(long groupId, String lastName,
		int start, int end) throws SystemException {
		return filterFindByG_LN(groupId, lastName, start, end, null);
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
	public List<PRUser> filterFindByG_LN(long groupId, String lastName,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_LN(groupId, lastName, start, end, orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_PRUSER_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PRUSER_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_LN_GROUPID_2);

		if (lastName == null) {
			query.append(_FINDER_COLUMN_G_LN_LASTNAME_1);
		}
		else {
			if (lastName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_LN_LASTNAME_3);
			}
			else {
				query.append(_FINDER_COLUMN_G_LN_LASTNAME_2);
			}
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PRUSER_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(PRUserModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PRUserModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PRUser.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, PRUserImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, PRUserImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (lastName != null) {
				qPos.add(lastName);
			}

			return (List<PRUser>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Finds all the p r users where groupId = &#63; and email = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param email the email to search with
	 * @return the matching p r users
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRUser> findByG_E(long groupId, String email)
		throws SystemException {
		return findByG_E(groupId, email, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	public List<PRUser> findByG_E(long groupId, String email, int start, int end)
		throws SystemException {
		return findByG_E(groupId, email, start, end, null);
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
	public List<PRUser> findByG_E(long groupId, String email, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, email,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<PRUser> list = (List<PRUser>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_G_E,
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

			query.append(_SQL_SELECT_PRUSER_WHERE);

			query.append(_FINDER_COLUMN_G_E_GROUPID_2);

			if (email == null) {
				query.append(_FINDER_COLUMN_G_E_EMAIL_1);
			}
			else {
				if (email.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_E_EMAIL_3);
				}
				else {
					query.append(_FINDER_COLUMN_G_E_EMAIL_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PRUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (email != null) {
					qPos.add(email);
				}

				list = (List<PRUser>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_G_E,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_G_E,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public PRUser findByG_E_First(long groupId, String email,
		OrderByComparator orderByComparator)
		throws NoSuchUserException, SystemException {
		List<PRUser> list = findByG_E(groupId, email, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", email=");
			msg.append(email);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public PRUser findByG_E_Last(long groupId, String email,
		OrderByComparator orderByComparator)
		throws NoSuchUserException, SystemException {
		int count = countByG_E(groupId, email);

		List<PRUser> list = findByG_E(groupId, email, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", email=");
			msg.append(email);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public PRUser[] findByG_E_PrevAndNext(long prUserId, long groupId,
		String email, OrderByComparator orderByComparator)
		throws NoSuchUserException, SystemException {
		PRUser prUser = findByPrimaryKey(prUserId);

		Session session = null;

		try {
			session = openSession();

			PRUser[] array = new PRUserImpl[3];

			array[0] = getByG_E_PrevAndNext(session, prUser, groupId, email,
					orderByComparator, true);

			array[1] = prUser;

			array[2] = getByG_E_PrevAndNext(session, prUser, groupId, email,
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

	protected PRUser getByG_E_PrevAndNext(Session session, PRUser prUser,
		long groupId, String email, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRUSER_WHERE);

		query.append(_FINDER_COLUMN_G_E_GROUPID_2);

		if (email == null) {
			query.append(_FINDER_COLUMN_G_E_EMAIL_1);
		}
		else {
			if (email.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_E_EMAIL_3);
			}
			else {
				query.append(_FINDER_COLUMN_G_E_EMAIL_2);
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
			query.append(PRUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (email != null) {
			qPos.add(email);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(prUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PRUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Filters by the user's permissions and finds all the p r users where groupId = &#63; and email = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param email the email to search with
	 * @return the matching p r users that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRUser> filterFindByG_E(long groupId, String email)
		throws SystemException {
		return filterFindByG_E(groupId, email, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<PRUser> filterFindByG_E(long groupId, String email, int start,
		int end) throws SystemException {
		return filterFindByG_E(groupId, email, start, end, null);
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
	public List<PRUser> filterFindByG_E(long groupId, String email, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_E(groupId, email, start, end, orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_PRUSER_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PRUSER_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_E_GROUPID_2);

		if (email == null) {
			query.append(_FINDER_COLUMN_G_E_EMAIL_1);
		}
		else {
			if (email.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_E_EMAIL_3);
			}
			else {
				query.append(_FINDER_COLUMN_G_E_EMAIL_2);
			}
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PRUSER_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(PRUserModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PRUserModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PRUser.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, PRUserImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, PRUserImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (email != null) {
				qPos.add(email);
			}

			return (List<PRUser>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Finds all the p r users where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param userId the user id to search with
	 * @return the matching p r users
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRUser> findByG_U(long groupId, long userId)
		throws SystemException {
		return findByG_U(groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	public List<PRUser> findByG_U(long groupId, long userId, int start, int end)
		throws SystemException {
		return findByG_U(groupId, userId, start, end, null);
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
	public List<PRUser> findByG_U(long groupId, long userId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, userId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<PRUser> list = (List<PRUser>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_G_U,
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

			query.append(_SQL_SELECT_PRUSER_WHERE);

			query.append(_FINDER_COLUMN_G_U_GROUPID_2);

			query.append(_FINDER_COLUMN_G_U_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PRUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

				list = (List<PRUser>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_G_U,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_G_U,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public PRUser findByG_U_First(long groupId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchUserException, SystemException {
		List<PRUser> list = findByG_U(groupId, userId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public PRUser findByG_U_Last(long groupId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchUserException, SystemException {
		int count = countByG_U(groupId, userId);

		List<PRUser> list = findByG_U(groupId, userId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public PRUser[] findByG_U_PrevAndNext(long prUserId, long groupId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchUserException, SystemException {
		PRUser prUser = findByPrimaryKey(prUserId);

		Session session = null;

		try {
			session = openSession();

			PRUser[] array = new PRUserImpl[3];

			array[0] = getByG_U_PrevAndNext(session, prUser, groupId, userId,
					orderByComparator, true);

			array[1] = prUser;

			array[2] = getByG_U_PrevAndNext(session, prUser, groupId, userId,
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

	protected PRUser getByG_U_PrevAndNext(Session session, PRUser prUser,
		long groupId, long userId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRUSER_WHERE);

		query.append(_FINDER_COLUMN_G_U_GROUPID_2);

		query.append(_FINDER_COLUMN_G_U_USERID_2);

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
			query.append(PRUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(prUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PRUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Filters by the user's permissions and finds all the p r users where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param userId the user id to search with
	 * @return the matching p r users that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRUser> filterFindByG_U(long groupId, long userId)
		throws SystemException {
		return filterFindByG_U(groupId, userId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<PRUser> filterFindByG_U(long groupId, long userId, int start,
		int end) throws SystemException {
		return filterFindByG_U(groupId, userId, start, end, null);
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
	public List<PRUser> filterFindByG_U(long groupId, long userId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_U(groupId, userId, start, end, orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_PRUSER_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PRUSER_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_U_GROUPID_2);

		query.append(_FINDER_COLUMN_G_U_USERID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PRUSER_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(PRUserModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PRUserModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PRUser.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, PRUserImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, PRUserImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(userId);

			return (List<PRUser>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Finds all the p r users.
	 *
	 * @return the p r users
	 * @throws SystemException if a system exception occurred
	 */
	public List<PRUser> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<PRUser> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	public List<PRUser> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<PRUser> list = (List<PRUser>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PRUSER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PRUSER.concat(PRUserModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<PRUser>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<PRUser>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the p r users where groupId = &#63; and lastName = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @param lastName the last name to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_LN(long groupId, String lastName)
		throws SystemException {
		for (PRUser prUser : findByG_LN(groupId, lastName)) {
			remove(prUser);
		}
	}

	/**
	 * Removes all the p r users where groupId = &#63; and email = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @param email the email to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_E(long groupId, String email)
		throws SystemException {
		for (PRUser prUser : findByG_E(groupId, email)) {
			remove(prUser);
		}
	}

	/**
	 * Removes all the p r users where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @param userId the user id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_U(long groupId, long userId)
		throws SystemException {
		for (PRUser prUser : findByG_U(groupId, userId)) {
			remove(prUser);
		}
	}

	/**
	 * Removes all the p r users from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (PRUser prUser : findAll()) {
			remove(prUser);
		}
	}

	/**
	 * Counts all the p r users where groupId = &#63; and lastName = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param lastName the last name to search with
	 * @return the number of matching p r users
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_LN(long groupId, String lastName)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, lastName };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_LN,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PRUSER_WHERE);

			query.append(_FINDER_COLUMN_G_LN_GROUPID_2);

			if (lastName == null) {
				query.append(_FINDER_COLUMN_G_LN_LASTNAME_1);
			}
			else {
				if (lastName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_LN_LASTNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_G_LN_LASTNAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (lastName != null) {
					qPos.add(lastName);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_LN,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Filters by the user's permissions and counts all the p r users where groupId = &#63; and lastName = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param lastName the last name to search with
	 * @return the number of matching p r users that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByG_LN(long groupId, String lastName)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_LN(groupId, lastName);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_PRUSER_WHERE);

		query.append(_FINDER_COLUMN_G_LN_GROUPID_2);

		if (lastName == null) {
			query.append(_FINDER_COLUMN_G_LN_LASTNAME_1);
		}
		else {
			if (lastName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_LN_LASTNAME_3);
			}
			else {
				query.append(_FINDER_COLUMN_G_LN_LASTNAME_2);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PRUser.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (lastName != null) {
				qPos.add(lastName);
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
	 * Counts all the p r users where groupId = &#63; and email = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param email the email to search with
	 * @return the number of matching p r users
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_E(long groupId, String email) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, email };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_E,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PRUSER_WHERE);

			query.append(_FINDER_COLUMN_G_E_GROUPID_2);

			if (email == null) {
				query.append(_FINDER_COLUMN_G_E_EMAIL_1);
			}
			else {
				if (email.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_E_EMAIL_3);
				}
				else {
					query.append(_FINDER_COLUMN_G_E_EMAIL_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (email != null) {
					qPos.add(email);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_E, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Filters by the user's permissions and counts all the p r users where groupId = &#63; and email = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param email the email to search with
	 * @return the number of matching p r users that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByG_E(long groupId, String email)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_E(groupId, email);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_PRUSER_WHERE);

		query.append(_FINDER_COLUMN_G_E_GROUPID_2);

		if (email == null) {
			query.append(_FINDER_COLUMN_G_E_EMAIL_1);
		}
		else {
			if (email.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_E_EMAIL_3);
			}
			else {
				query.append(_FINDER_COLUMN_G_E_EMAIL_2);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PRUser.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (email != null) {
				qPos.add(email);
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
	 * Counts all the p r users where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param userId the user id to search with
	 * @return the number of matching p r users
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_U(long groupId, long userId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_U,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PRUSER_WHERE);

			query.append(_FINDER_COLUMN_G_U_GROUPID_2);

			query.append(_FINDER_COLUMN_G_U_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_U, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Filters by the user's permissions and counts all the p r users where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param userId the user id to search with
	 * @return the number of matching p r users that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByG_U(long groupId, long userId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_U(groupId, userId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_PRUSER_WHERE);

		query.append(_FINDER_COLUMN_G_U_GROUPID_2);

		query.append(_FINDER_COLUMN_G_U_USERID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PRUser.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(userId);

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
	 * Counts all the p r users.
	 *
	 * @return the number of p r users
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

				Query q = session.createQuery(_SQL_COUNT_PRUSER);

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
	 * Gets all the p r registrations associated with the p r user.
	 *
	 * @param pk the primary key of the p r user to get the associated p r registrations for
	 * @return the p r registrations associated with the p r user
	 * @throws SystemException if a system exception occurred
	 */
	public List<com.inkwell.internet.productregistration.model.PRRegistration> getPRRegistrations(
		long pk) throws SystemException {
		return getPRRegistrations(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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
	public List<com.inkwell.internet.productregistration.model.PRRegistration> getPRRegistrations(
		long pk, int start, int end) throws SystemException {
		return getPRRegistrations(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_PRREGISTRATIONS = new FinderPath(com.inkwell.internet.productregistration.model.impl.PRRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			com.inkwell.internet.productregistration.model.impl.PRRegistrationModelImpl.FINDER_CACHE_ENABLED,
			com.inkwell.internet.productregistration.service.persistence.PRRegistrationPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getPRRegistrations",
			new String[] {
				Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

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
	public List<com.inkwell.internet.productregistration.model.PRRegistration> getPRRegistrations(
		long pk, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<com.inkwell.internet.productregistration.model.PRRegistration> list =
			(List<com.inkwell.internet.productregistration.model.PRRegistration>)FinderCacheUtil.getResult(FINDER_PATH_GET_PRREGISTRATIONS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				String sql = null;

				if (orderByComparator != null) {
					sql = _SQL_GETPRREGISTRATIONS.concat(ORDER_BY_CLAUSE)
												 .concat(orderByComparator.getOrderBy());
				}
				else {
					sql = _SQL_GETPRREGISTRATIONS;
				}

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("PR_PRRegistration",
					com.inkwell.internet.productregistration.model.impl.PRRegistrationImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<com.inkwell.internet.productregistration.model.PRRegistration>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_GET_PRREGISTRATIONS,
						finderArgs);
				}
				else {
					prRegistrationPersistence.cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_GET_PRREGISTRATIONS,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_PRREGISTRATIONS_SIZE = new FinderPath(com.inkwell.internet.productregistration.model.impl.PRRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			com.inkwell.internet.productregistration.model.impl.PRRegistrationModelImpl.FINDER_CACHE_ENABLED,
			com.inkwell.internet.productregistration.service.persistence.PRRegistrationPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getPRRegistrationsSize", new String[] { Long.class.getName() });

	/**
	 * Gets the number of p r registrations associated with the p r user.
	 *
	 * @param pk the primary key of the p r user to get the number of associated p r registrations for
	 * @return the number of p r registrations associated with the p r user
	 * @throws SystemException if a system exception occurred
	 */
	public int getPRRegistrationsSize(long pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_PRREGISTRATIONS_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETPRREGISTRATIONSSIZE);

				q.addScalar(COUNT_COLUMN_NAME,
					com.liferay.portal.kernel.dao.orm.Type.LONG);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_GET_PRREGISTRATIONS_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_PRREGISTRATION = new FinderPath(com.inkwell.internet.productregistration.model.impl.PRRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			com.inkwell.internet.productregistration.model.impl.PRRegistrationModelImpl.FINDER_CACHE_ENABLED,
			com.inkwell.internet.productregistration.service.persistence.PRRegistrationPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsPRRegistration",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Determines if the p r registration is associated with the p r user.
	 *
	 * @param pk the primary key of the p r user
	 * @param prRegistrationPK the primary key of the p r registration
	 * @return <code>true</code> if the p r registration is associated with the p r user; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsPRRegistration(long pk, long prRegistrationPK)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, prRegistrationPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_PRREGISTRATION,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsPRRegistration.contains(pk,
							prRegistrationPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_PRREGISTRATION,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	/**
	 * Determines if the p r user has any p r registrations associated with it.
	 *
	 * @param pk the primary key of the p r user to check for associations with p r registrations
	 * @return <code>true</code> if the p r user has any p r registrations associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsPRRegistrations(long pk) throws SystemException {
		if (getPRRegistrationsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Initializes the p r user persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.inkwell.internet.productregistration.model.PRUser")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PRUser>> listenersList = new ArrayList<ModelListener<PRUser>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PRUser>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsPRRegistration = new ContainsPRRegistration(this);
	}

	public void destroy() {
		EntityCacheUtil.removeCache(PRUserImpl.class.getName());
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
	protected ContainsPRRegistration containsPRRegistration;

	protected class ContainsPRRegistration {
		protected ContainsPRRegistration(PRUserPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSPRREGISTRATION,
					new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
					RowMapper.COUNT);
		}

		protected boolean contains(long prUserId, long registrationId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						new Long(prUserId), new Long(registrationId)
					});

			if (results.size() > 0) {
				Integer count = results.get(0);

				if (count.intValue() > 0) {
					return true;
				}
			}

			return false;
		}

		private MappingSqlQuery<Integer> _mappingSqlQuery;
	}

	private static final String _SQL_SELECT_PRUSER = "SELECT prUser FROM PRUser prUser";
	private static final String _SQL_SELECT_PRUSER_WHERE = "SELECT prUser FROM PRUser prUser WHERE ";
	private static final String _SQL_COUNT_PRUSER = "SELECT COUNT(prUser) FROM PRUser prUser";
	private static final String _SQL_COUNT_PRUSER_WHERE = "SELECT COUNT(prUser) FROM PRUser prUser WHERE ";
	private static final String _SQL_GETPRREGISTRATIONS = "SELECT {PR_PRRegistration.*} FROM PR_PRRegistration INNER JOIN PR_PRUser ON (PR_PRUser.prUserId = PR_PRRegistration.prUserId) WHERE (PR_PRUser.prUserId = ?)";
	private static final String _SQL_GETPRREGISTRATIONSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM PR_PRRegistration WHERE prUserId = ?";
	private static final String _SQL_CONTAINSPRREGISTRATION = "SELECT COUNT(*) AS COUNT_VALUE FROM PR_PRRegistration WHERE prUserId = ? AND registrationId = ?";
	private static final String _FINDER_COLUMN_G_LN_GROUPID_2 = "prUser.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_LN_LASTNAME_1 = "prUser.lastName IS NULL";
	private static final String _FINDER_COLUMN_G_LN_LASTNAME_2 = "prUser.lastName = ?";
	private static final String _FINDER_COLUMN_G_LN_LASTNAME_3 = "(prUser.lastName IS NULL OR prUser.lastName = ?)";
	private static final String _FINDER_COLUMN_G_E_GROUPID_2 = "prUser.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_E_EMAIL_1 = "prUser.email IS NULL";
	private static final String _FINDER_COLUMN_G_E_EMAIL_2 = "prUser.email = ?";
	private static final String _FINDER_COLUMN_G_E_EMAIL_3 = "(prUser.email IS NULL OR prUser.email = ?)";
	private static final String _FINDER_COLUMN_G_U_GROUPID_2 = "prUser.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_U_USERID_2 = "prUser.userId = ?";
	private static final String _FILTER_SQL_SELECT_PRUSER_WHERE = "SELECT DISTINCT {prUser.*} FROM PR_PRUser prUser WHERE ";
	private static final String _FILTER_SQL_SELECT_PRUSER_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {PR_PRUser.*} FROM (SELECT DISTINCT prUser.prUserId FROM PR_PRUser prUser WHERE ";
	private static final String _FILTER_SQL_SELECT_PRUSER_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN PR_PRUser ON TEMP_TABLE.prUserId = PR_PRUser.prUserId";
	private static final String _FILTER_SQL_COUNT_PRUSER_WHERE = "SELECT COUNT(DISTINCT prUser.prUserId) AS COUNT_VALUE FROM PR_PRUser prUser WHERE ";
	private static final String _FILTER_COLUMN_PK = "prUser.prUserId";
	private static final String _FILTER_COLUMN_USERID = "prUser.userId";
	private static final String _FILTER_ENTITY_ALIAS = "prUser";
	private static final String _FILTER_ENTITY_TABLE = "PR_PRUser";
	private static final String _ORDER_BY_ENTITY_ALIAS = "prUser.";
	private static final String _ORDER_BY_ENTITY_TABLE = "PR_PRUser.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PRUser exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PRUser exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(PRUserPersistenceImpl.class);
}