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

package com.inkwell.internet.slogan.util;

import com.inkwell.internet.slogan.model.Slogan;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

/**
 * @author Rich Sezov
 */
public class SloganValidator {

    @SuppressWarnings("unchecked")
    public static boolean validateSlogan (Slogan slogan, List errors) {

        boolean valid = true;

        if (Validator.isNull(slogan.getSloganText())) {
            valid = false;
            errors.add("slogan-required");
        }

        return valid;
    }

}
