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

package com.inkwell.internet.slogan.search;

import com.inkwell.internet.slogan.model.Slogan;
import com.inkwell.internet.slogan.service.SloganLocalServiceUtil;
import com.inkwell.internet.slogan.util.WebKeys;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.DocumentImpl;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletURL;

/**
 * @author Rich Sezov
 */
public class SloganIndexer extends BaseIndexer {

    public static final String[] CLASS_NAMES = {
        Slogan.class.getName()
    };

    public static final String PORTLET_ID = WebKeys.SLOGAN_PORTLET_ID;

    public String[] getClassNames() {

        return CLASS_NAMES;
    }

    public Summary getSummary(
        Document document, String snippet, PortletURL portletURL) {

        String title = document.get(Field.TITLE);

        String content = snippet;

        if (Validator.isNull(snippet)) {
            content = document.get(Field.DESCRIPTION);

            if (Validator.isNull(content)) {
                content = StringUtil.shorten(
                    document.get(Field.CONTENT), 200);
            }
        }

        String resourcePrimKey = document.get(Field.ENTRY_CLASS_PK);

        portletURL.setParameter("jspPage", "/admin/view_slogan.jsp");
        portletURL.setParameter("resourcePrimKey", resourcePrimKey);

        return new Summary(title, content, portletURL);

    }

    @Override
    protected void doDelete(Object obj)
        throws Exception {

        Slogan slogan = (Slogan) obj;
        Document document = new DocumentImpl();

        document.addUID(PORTLET_ID, slogan.getPrimaryKey());

        SearchEngineUtil.deleteDocument(
            slogan.getCompanyId(), document.get(Field.UID));

    }

    @Override
    protected Document doGetDocument(Object obj)
        throws Exception {

        Slogan slogan = (Slogan) obj;
        long companyId = slogan.getCompanyId();
        long groupId = getParentGroupId(slogan.getGroupId());
        long scopeGroupId = slogan.getGroupId();
        long userId = slogan.getUserId();
        long resourcePrimKey = slogan.getPrimaryKey();
        String title = slogan.getSloganText();
        String content = slogan.getSloganText();
        String description = slogan.getSloganText();
        Date modifiedDate = slogan.getSloganDate();

       long[] assetCategoryIds = AssetCategoryLocalServiceUtil.getCategoryIds(
            Slogan.class.getName(), resourcePrimKey);
       
       List<AssetCategory> categories = AssetCategoryLocalServiceUtil.getCategories(
    		    Slogan.class.getName(), resourcePrimKey);

       String[] assetCategoryNames = StringUtil.split(ListUtil.toString(categories, "name"));
       
       // EE lets you do this quicker: 
       
       // String[] assetCategoryNames =
       //     AssetCategoryLocalServiceUtil.getCategoryNames(
       //         Slogan.class.getName(), resourcePrimKey);
       
       String[] assetTagNames = AssetTagLocalServiceUtil.getTagNames(
            Slogan.class.getName(), resourcePrimKey);

        Document document = new DocumentImpl();

        document.addUID(PORTLET_ID, resourcePrimKey);

        document.addModifiedDate(modifiedDate);

        document.addKeyword(Field.COMPANY_ID, companyId);
        document.addKeyword(Field.PORTLET_ID, PORTLET_ID);
        document.addKeyword(Field.GROUP_ID, groupId);
        document.addKeyword(Field.SCOPE_GROUP_ID, scopeGroupId);
        document.addKeyword(Field.USER_ID, userId);
        document.addText(Field.TITLE, title);
        document.addText(Field.CONTENT, content);
        document.addText(Field.DESCRIPTION, description);
        document.addKeyword(Field.ASSET_CATEGORY_IDS, assetCategoryIds);
        document.addKeyword("assetCategoryNames", assetCategoryNames);
        //document.addKeyword(Field.ASSET_CATEGORY_NAMES, assetCategoryNames);
        document.addKeyword(Field.ASSET_TAG_NAMES, assetTagNames);

        document.addKeyword(
            Field.ENTRY_CLASS_NAME, Slogan.class.getName());
        document.addKeyword(Field.ENTRY_CLASS_PK, resourcePrimKey);

        return document;
    }

    @Override
    protected void doReindex(Object obj)
        throws Exception {

        Slogan slogan = (Slogan) obj;
        SearchEngineUtil.updateDocument(
            slogan.getCompanyId(), getDocument(slogan));

    }

    @Override
    protected void doReindex(String className, long classPK)
        throws Exception {

        Slogan slogan = SloganLocalServiceUtil.getSlogan(classPK);

        doReindex(slogan);

    }

    @Override
    protected void doReindex(String[] ids)
        throws Exception {

        long companyId = GetterUtil.getLong(ids[0]);
        reIndexSlogans(companyId);

    }

    protected void reIndexSlogans(long companyId)
        throws Exception {

        int count = SloganLocalServiceUtil.getSlogansCount();
        int pages = count / Indexer.DEFAULT_INTERVAL;
        for (int i = 0; i <= pages; i++) {
            int start = (i * Indexer.DEFAULT_INTERVAL);
            int end = start + Indexer.DEFAULT_INTERVAL;

            reIndexSlogans(companyId, start, end);
        }
    }

    protected void reIndexSlogans(long companyId, int start, int end)
        throws Exception {

        List<Slogan> slogans =
            SloganLocalServiceUtil.getCompanySlogans(
                companyId, WorkflowConstants.STATUS_APPROVED, start,
                end);

        if (slogans.isEmpty()) {
            return;
        }

        Collection<Document> documents = new ArrayList<Document>();

        for (Slogan slogan : slogans) {
            Document document = getDocument(slogan);

            documents.add(document);
        }

        SearchEngineUtil.updateDocuments(companyId, documents);
    }

    @Override
    protected String getPortletId(SearchContext searchContext) {

        return PORTLET_ID;
    }

}
