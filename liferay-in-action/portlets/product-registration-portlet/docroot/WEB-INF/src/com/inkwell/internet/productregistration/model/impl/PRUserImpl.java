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

package com.inkwell.internet.productregistration.model.impl;

import com.inkwell.internet.productregistration.model.PRUser;

/**
 * <a href="PRUserImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Rich Sezov
 */
public class PRUserImpl extends PRUserModelImpl implements PRUser {

    public PRUserImpl() {
    }

    public String getGender() {

        return gender;
    }


    public void setGender(String gender) {

        this.gender = gender;
    }

    String gender;
}
