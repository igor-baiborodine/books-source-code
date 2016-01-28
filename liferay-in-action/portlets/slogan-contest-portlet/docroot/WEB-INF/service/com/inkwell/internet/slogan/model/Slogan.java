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

package com.inkwell.internet.slogan.model;

/**
 * The model interface for the Slogan service. Represents a row in the &quot;Slogan_Slogan&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Never modify this interface directly. Add methods to {@link com.inkwell.internet.slogan.model.impl.SloganImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. All methods that expect a slogan model instance should use the {@link Slogan} interface instead.
 * </p>
 *
 * @author Rich Sezov
 * @see SloganModel
 * @see com.inkwell.internet.slogan.model.impl.SloganImpl
 * @see com.inkwell.internet.slogan.model.impl.SloganModelImpl
 * @generated
 */
public interface Slogan extends SloganModel {
	public double getAverageScore();

	public void setAverageScore(double averageScore);

	public java.lang.String getSloganIdString();

	public void setSloganIdString(java.lang.String sloganIdString);
}