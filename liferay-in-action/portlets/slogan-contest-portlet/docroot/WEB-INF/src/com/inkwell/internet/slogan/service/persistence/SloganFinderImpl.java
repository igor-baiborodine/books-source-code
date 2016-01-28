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

import com.inkwell.internet.slogan.model.Slogan;
import com.inkwell.internet.slogan.model.impl.SloganImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rich Sezov
 */
public class SloganFinderImpl extends BasePersistenceImpl<Slogan>
    implements SloganFinder {

    public static String FIND_BY_RATINGSSTATS =
        SloganFinder.class.getName() + ".findByRatingsStats";

    public List<Slogan> findByRatingsStats(
            long groupId, int status, int start, int end)
        throws SystemException {

        long classNameId = PortalUtil.getClassNameId(
            "com.inkwell.internet.slogan.model.Slogan");

        Session session = null;

        try {
            session = openSession();

            String sql = CustomSQLUtil.get(FIND_BY_RATINGSSTATS);

            SQLQuery q = session.createSQLQuery(sql);

            q.addScalar("averageScore", Type.DOUBLE);
            q.addScalar("sloganId", Type.LONG);
            q.addScalar("sloganText", Type.STRING);

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(groupId);
            qPos.add(status);
            qPos.add(classNameId);

            List<Object[]> ratedSlogans =
                (List<Object[]>) QueryUtil.list(
                    q, getDialect(), start, end);

            List<Slogan> slogans = assembleSlogans(ratedSlogans);

            return slogans;
        }
        catch (Exception e) {
            throw new SystemException(e);
        }
        finally {
            closeSession(session);
        }
    }

    private List<Slogan> assembleSlogans(List<Object[]> ratedSlogans) {

        List<Slogan> slogans = new ArrayList();

        for (Object[] ratedSlogan : ratedSlogans) {
            SloganImpl slogan = new SloganImpl();

            slogan.setAverageScore((Double) ratedSlogan[0]);
            slogan.setSloganId((Long) ratedSlogan[1]);
            slogan.setSloganText((String) ratedSlogan[2]);

            slogans.add(slogan);
        }

        return slogans;
    }

}
