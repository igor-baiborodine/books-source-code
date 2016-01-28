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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;

/**
 * @author Rich Sezov
 */
public class SloganFinderUtil {
	public static java.util.List<com.inkwell.internet.slogan.model.Slogan> findByRatingsStats(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByRatingsStats(groupId, status, start, end);
	}

	public static SloganFinder getFinder() {
		if (_finder == null) {
			_finder = (SloganFinder)PortletBeanLocatorUtil.locate(com.inkwell.internet.slogan.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					SloganFinder.class.getName());
		}

		return _finder;
	}

	public void setFinder(SloganFinder finder) {
		_finder = finder;
	}

	private static SloganFinder _finder;
}