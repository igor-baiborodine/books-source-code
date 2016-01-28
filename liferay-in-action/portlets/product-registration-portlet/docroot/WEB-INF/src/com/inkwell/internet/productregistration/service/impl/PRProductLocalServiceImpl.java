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

package com.inkwell.internet.productregistration.service.impl;

import java.util.List;

import com.inkwell.internet.productregistration.NoSuchProductException;
import com.inkwell.internet.productregistration.model.PRProduct;
import com.inkwell.internet.productregistration.service.base.PRProductLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;

/**
 * <a href="PRProductLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Rich Sezov
 */
public class PRProductLocalServiceImpl extends PRProductLocalServiceBaseImpl {

    /**
     * Adds a new product to the database.
     *
     * @param productName
     * @param productSerial
     * @return
     * @throws com.liferay.portal.kernel.exception.SystemException
     */
    public PRProduct addProduct(PRProduct newProduct, long userId)
        throws SystemException, PortalException {

        PRProduct product =
            prProductPersistence.create(
                counterLocalService.increment(PRProduct.class.getName()));

        product.setProductName(newProduct.getProductName());
        product.setSerialNumber(newProduct.getSerialNumber());
        product.setCompanyId(newProduct.getCompanyId());
        product.setGroupId(newProduct.getGroupId());

        resourceLocalService.addResources(
            newProduct.getCompanyId(), newProduct.getGroupId(), userId,
            PRProduct.class.getName(), product.getPrimaryKey(), false,
            true, true);

        return prProductPersistence.update(product, false);
    }

    /**
     * Retrieves all of the products from the database.
     *
     * @return
     * @throws com.liferay.portal.kernel.exception.SystemException
     */
    public List<PRProduct> getAllProducts(long groupId)
        throws SystemException {

        List<PRProduct> products =
            prProductPersistence.findByGroupId(groupId);
        return products;
    }

    /**
     * Removes the specified product from the database.
     *
     * @param productId
     * @throws com.inkwell.internet.portlets.prodreg.sb.NoSuchProductException
     * @throws com.liferay.portal.kernel.exception.SystemException
     * @throws com.liferay.portal.kernel.exception.PortalException
     */
    public void deleteProduct(long productId)
        throws NoSuchProductException, SystemException, PortalException {

        PRProduct product = prProductPersistence.findByPrimaryKey(productId);
        deleteProduct(product);
    }

    /**
     * Removes the specified product from the database.
     *
     * @param product
     * @throws com.liferay.portal.kernel.exception.PortalException
     * @throws com.liferay.portal.kernel.exception.SystemException
     */
    public void deleteProduct(PRProduct product)
        throws PortalException, SystemException {

        resourceLocalService.deleteResource(
            product.getCompanyId(), PRProduct.class.getName(),
            ResourceConstants.SCOPE_INDIVIDUAL, product.getPrimaryKey());
        prProductPersistence.remove(product);
    }
}
