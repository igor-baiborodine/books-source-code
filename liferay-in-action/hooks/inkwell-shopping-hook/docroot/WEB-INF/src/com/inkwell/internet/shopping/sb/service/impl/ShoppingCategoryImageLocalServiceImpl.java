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

package com.inkwell.internet.shopping.sb.service.impl;

import com.inkwell.internet.shopping.sb.NoSuchShoppingCategoryImageException;
import com.inkwell.internet.shopping.sb.model.ShoppingCategoryImage;
import com.inkwell.internet.shopping.sb.model.impl.ShoppingCategoryImageImpl;
import com.inkwell.internet.shopping.sb.service.base.ShoppingCategoryImageLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * <a href="ShoppingCategoryImageLocalServiceImpl.java.html"><b><i>View Source
 * </i></b></a>
 *
 * @author Rich Sezov
 */
public class ShoppingCategoryImageLocalServiceImpl
    extends ShoppingCategoryImageLocalServiceBaseImpl {

    /**
     * Creates a new ShoppingCategoryImage in the database.
     *
     * @param categoryId
     * @param url
     * @return ShoppingCategoryImage
     * @throws com.liferay.portal.kernel.exception.SystemException
     */
    public ShoppingCategoryImage addShoppingCategoryImage(
            long categoryId, String url)
        throws SystemException {

        ShoppingCategoryImage image =
            shoppingCategoryImagePersistence.create(
                counterLocalService.increment(
                    ShoppingCategoryImage.class.getName()));

        image.setCategoryId(categoryId);
        image.setImageUrl(url);

        return shoppingCategoryImagePersistence.update(image, false);
    }

    /**
     * Gets images by the shopping category to which they are linked.
     *
     * @param categoryId
     * @return List of images
     * @throws SystemException
     */
    public ShoppingCategoryImage getShoppingCategoryImageByCategory(
            long categoryId)
        throws SystemException {

        List<ShoppingCategoryImage> images =
            getShoppingCategoryImagesByCategory(categoryId);

        if (images.isEmpty()) {
            return getEmptyImage();
        }
        else {
            return images.get(0);
        }
    }

    /**
     * Gets the whole collection of images resulting from the query.
     *
     * @param categoryId
     * @return
     * @throws SystemException
     */
    public List<ShoppingCategoryImage> getShoppingCategoryImagesByCategory(
        long categoryId)
        throws SystemException {

        List<ShoppingCategoryImage> images =
            shoppingCategoryImagePersistence.findByCategoryId(categoryId);

        return images;
    }

    /**
     * Updates an image object in the database.
     *
     * @param image
     * @return
     * @throws SystemException
     */
    public ShoppingCategoryImage updateImage(ShoppingCategoryImage image)
        throws SystemException {

        image = shoppingCategoryImagePersistence.update(image, false);

        return image;
    }

    /**
     * This method can be called to remove an image associated with a
     * ShoppingCategory.
     *
     * @param categoryId
     * @throws SystemException
     */
    public void deleteImage(long imageId)
        throws NoSuchShoppingCategoryImageException, SystemException {

        shoppingCategoryImagePersistence.remove(imageId);
    }

    /**
     * When a shopping category is deleted, this method can be called to remove
     * all the images that are linked to it.
     *
     * @param categoryId
     * @throws SystemException
     */
    public void deleteImages(long categoryId)
        throws SystemException {

        shoppingCategoryImagePersistence.removeByCategoryId(categoryId);
    }

    /**
     * Returns an empty ShoppingCategoryImage, thereby hiding the implementation
     * from the JSP layer of the app.
     *
     * @return ShoppingCategoryImage
     */
    public ShoppingCategoryImage getEmptyImage() {

        ShoppingCategoryImage image = new ShoppingCategoryImageImpl();

        return image;
    }
}
