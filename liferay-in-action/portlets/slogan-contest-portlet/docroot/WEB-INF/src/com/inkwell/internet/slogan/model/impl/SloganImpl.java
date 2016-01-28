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

package com.inkwell.internet.slogan.model.impl;

import com.inkwell.internet.slogan.model.Slogan;

/**
 * The model implementation for the Slogan service. Represents a row in the &quot;Slogan_Slogan&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.inkwell.internet.slogan.model.Slogan} interface.
 * </p>
 *
 * <p>
 * Never reference this class directly. All methods that expect a slogan model instance should use the {@link Slogan} interface instead.
 * </p>
 */
public class SloganImpl extends SloganModelImpl implements Slogan {
    public SloganImpl() {
    }




    public double getAverageScore() {

        return averageScore;
    }




    public void setAverageScore(double averageScore) {

        this.averageScore = averageScore;
    }



    public String getSloganIdString() {

        return sloganIdString;
    }


    public void setSloganIdString(String sloganIdString) {

        this.sloganIdString = sloganIdString;
    }

    private String sloganIdString;
    private double averageScore;
}