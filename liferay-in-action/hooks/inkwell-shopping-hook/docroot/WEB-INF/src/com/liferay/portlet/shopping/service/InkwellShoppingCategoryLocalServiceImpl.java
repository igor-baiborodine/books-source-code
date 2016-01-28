/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.portlet.shopping.service;

import com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage;
import com.inkwell.internet.shopping.sb.service.ShoppingCategoryImageLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.shopping.model.ShoppingCategory;

/**
 * This class overrides key methods from Liferay's shopping cart in order to
 * provide images for shopping categories.
 *
 * @author Rich Sezov
 */
public class InkwellShoppingCategoryLocalServiceImpl
    extends ShoppingCategoryLocalServiceWrapper {

    /**
     * Constructor takes the implementation that was injected by Spring into the
     * super class.
     *
     * @param shoppingCategoryLocalService
     */
    public InkwellShoppingCategoryLocalServiceImpl(
        ShoppingCategoryLocalService shoppingCategoryLocalService) {

        super(shoppingCategoryLocalService);
    }

    /**
     * This method overrides the default service. It gets the custom attribute
     * and inserts it into the database using the custom service.
     *
     * @param userId
     * @param parentCategoryId
     * @param name
     * @param description
     * @param serviceContext
     * @return
     * @throws PortalException
     * @throws SystemException
     */
    @Override
    public ShoppingCategory addCategory(
            long userId, long parentCategoryId, String name,
            String description, ServiceContext serviceContext)
        throws PortalException, SystemException {

        String imageUrl =
            (String) serviceContext.getExpandoBridgeAttributes().get(
                "image-url");

        ShoppingCategory shoppingCategory = super.addCategory(
            userId, parentCategoryId, name, description, serviceContext);

        ShoppingCategoryImageLocalServiceUtil.addShoppingCategoryImage(
            shoppingCategory.getCategoryId(), imageUrl);

        return shoppingCategory;
    }

    /**
     * Updates a category, including the category image.
     *
     * @param categoryId
     * @param parentCategoryId
     * @param name
     * @param description
     * @param mergeWithParentCategory
     * @param serviceContext
     * @return
     * @throws PortalException
     * @throws SystemException
     */
    @Override
    public ShoppingCategory updateCategory(
            long categoryId, long parentCategoryId, String name,
            String description, boolean mergeWithParentCategory,
            ServiceContext serviceContext)
        throws PortalException, SystemException {

        String imageUrl =
            (String) serviceContext.getExpandoBridgeAttributes().get(
                "image-url");

        ShoppingCategoryImage image =
            ShoppingCategoryImageLocalServiceUtil.
                getShoppingCategoryImageByCategory(categoryId);

        if (image == null) {
            ShoppingCategoryImageLocalServiceUtil.addShoppingCategoryImage(
                categoryId, imageUrl);
        }
        else {
            image.setImageUrl(imageUrl);
            ShoppingCategoryImageLocalServiceUtil.updateImage(image);
        }

        ShoppingCategory shoppingCategory = super.updateCategory(
            categoryId, parentCategoryId, name, description,
            mergeWithParentCategory, serviceContext);

        return shoppingCategory;
    }

    /**
     * Deletes the images associated with the category before deleting the
     * category.
     *
     * @param categoryId
     * @throws PortalException
     * @throws SystemException
     */
    @Override
    public void deleteCategory(long categoryId)
        throws PortalException, SystemException {

        ShoppingCategoryImageLocalServiceUtil.deleteImages(categoryId);

        super.deleteCategory(categoryId);
    }

    /**
     * Deletes the images associated with the category before deleting the
     * category.
     *
     * @param category
     * @throws PortalException
     * @throws SystemException
     */
    @Override
    public void deleteCategory(ShoppingCategory category)
        throws PortalException, SystemException {

        this.deleteCategory(category.getCategoryId());
    }

}
