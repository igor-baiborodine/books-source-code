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

package com.inkwell.internet.productregistration.service;

import com.inkwell.internet.productregistration.model.PRProductClp;
import com.inkwell.internet.productregistration.model.PRRegistrationClp;
import com.inkwell.internet.productregistration.model.PRUserClp;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModel;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static final String SERVLET_CONTEXT_NAME = "product-registration-portlet";

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(PRProductClp.class.getName())) {
			PRProductClp oldCplModel = (PRProductClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.inkwell.internet.productregistration.model.impl.PRProductImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setProductId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getProductId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setProductName",
							new Class[] { String.class });

					String value1 = oldCplModel.getProductName();

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setSerialNumber",
							new Class[] { String.class });

					String value2 = oldCplModel.getSerialNumber();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value3 = new Long(oldCplModel.getCompanyId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setGroupId",
							new Class[] { Long.TYPE });

					Long value4 = new Long(oldCplModel.getGroupId());

					method4.invoke(newModel, value4);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(PRUserClp.class.getName())) {
			PRUserClp oldCplModel = (PRUserClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.inkwell.internet.productregistration.model.impl.PRUserImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setPrUserId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getPrUserId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setFirstName",
							new Class[] { String.class });

					String value1 = oldCplModel.getFirstName();

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setLastName",
							new Class[] { String.class });

					String value2 = oldCplModel.getLastName();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setAddress1",
							new Class[] { String.class });

					String value3 = oldCplModel.getAddress1();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setAddress2",
							new Class[] { String.class });

					String value4 = oldCplModel.getAddress2();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setCity",
							new Class[] { String.class });

					String value5 = oldCplModel.getCity();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setState",
							new Class[] { String.class });

					String value6 = oldCplModel.getState();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setPostalCode",
							new Class[] { String.class });

					String value7 = oldCplModel.getPostalCode();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setCountry",
							new Class[] { String.class });

					String value8 = oldCplModel.getCountry();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setPhoneNumber",
							new Class[] { String.class });

					String value9 = oldCplModel.getPhoneNumber();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setEmail",
							new Class[] { String.class });

					String value10 = oldCplModel.getEmail();

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setBirthDate",
							new Class[] { Date.class });

					Date value11 = oldCplModel.getBirthDate();

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setMale",
							new Class[] { Boolean.TYPE });

					Boolean value12 = new Boolean(oldCplModel.getMale());

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setUserId",
							new Class[] { Long.TYPE });

					Long value13 = new Long(oldCplModel.getUserId());

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value14 = new Long(oldCplModel.getCompanyId());

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setGroupId",
							new Class[] { Long.TYPE });

					Long value15 = new Long(oldCplModel.getGroupId());

					method15.invoke(newModel, value15);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(PRRegistrationClp.class.getName())) {
			PRRegistrationClp oldCplModel = (PRRegistrationClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.inkwell.internet.productregistration.model.impl.PRRegistrationImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setRegistrationId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getRegistrationId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setPrUserId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getPrUserId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setDatePurchased",
							new Class[] { Date.class });

					Date value2 = oldCplModel.getDatePurchased();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setHowHear",
							new Class[] { String.class });

					String value3 = oldCplModel.getHowHear();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setWherePurchased",
							new Class[] { String.class });

					String value4 = oldCplModel.getWherePurchased();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setSerialNumber",
							new Class[] { String.class });

					String value5 = oldCplModel.getSerialNumber();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setProductId",
							new Class[] { Long.TYPE });

					Long value6 = new Long(oldCplModel.getProductId());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value7 = new Long(oldCplModel.getCompanyId());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setGroupId",
							new Class[] { Long.TYPE });

					Long value8 = new Long(oldCplModel.getGroupId());

					method8.invoke(newModel, value8);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.inkwell.internet.productregistration.model.impl.PRProductImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					PRProductClp newModel = new PRProductClp();

					Method method0 = oldModelClass.getMethod("getProductId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setProductId(value0);

					Method method1 = oldModelClass.getMethod("getProductName");

					String value1 = (String)method1.invoke(oldModel,
							(Object[])null);

					newModel.setProductName(value1);

					Method method2 = oldModelClass.getMethod("getSerialNumber");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setSerialNumber(value2);

					Method method3 = oldModelClass.getMethod("getCompanyId");

					Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

					newModel.setCompanyId(value3);

					Method method4 = oldModelClass.getMethod("getGroupId");

					Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

					newModel.setGroupId(value4);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"com.inkwell.internet.productregistration.model.impl.PRUserImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					PRUserClp newModel = new PRUserClp();

					Method method0 = oldModelClass.getMethod("getPrUserId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setPrUserId(value0);

					Method method1 = oldModelClass.getMethod("getFirstName");

					String value1 = (String)method1.invoke(oldModel,
							(Object[])null);

					newModel.setFirstName(value1);

					Method method2 = oldModelClass.getMethod("getLastName");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setLastName(value2);

					Method method3 = oldModelClass.getMethod("getAddress1");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setAddress1(value3);

					Method method4 = oldModelClass.getMethod("getAddress2");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setAddress2(value4);

					Method method5 = oldModelClass.getMethod("getCity");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setCity(value5);

					Method method6 = oldModelClass.getMethod("getState");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setState(value6);

					Method method7 = oldModelClass.getMethod("getPostalCode");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setPostalCode(value7);

					Method method8 = oldModelClass.getMethod("getCountry");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setCountry(value8);

					Method method9 = oldModelClass.getMethod("getPhoneNumber");

					String value9 = (String)method9.invoke(oldModel,
							(Object[])null);

					newModel.setPhoneNumber(value9);

					Method method10 = oldModelClass.getMethod("getEmail");

					String value10 = (String)method10.invoke(oldModel,
							(Object[])null);

					newModel.setEmail(value10);

					Method method11 = oldModelClass.getMethod("getBirthDate");

					Date value11 = (Date)method11.invoke(oldModel,
							(Object[])null);

					newModel.setBirthDate(value11);

					Method method12 = oldModelClass.getMethod("getMale");

					Boolean value12 = (Boolean)method12.invoke(oldModel,
							(Object[])null);

					newModel.setMale(value12);

					Method method13 = oldModelClass.getMethod("getUserId");

					Long value13 = (Long)method13.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value13);

					Method method14 = oldModelClass.getMethod("getCompanyId");

					Long value14 = (Long)method14.invoke(oldModel,
							(Object[])null);

					newModel.setCompanyId(value14);

					Method method15 = oldModelClass.getMethod("getGroupId");

					Long value15 = (Long)method15.invoke(oldModel,
							(Object[])null);

					newModel.setGroupId(value15);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"com.inkwell.internet.productregistration.model.impl.PRRegistrationImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					PRRegistrationClp newModel = new PRRegistrationClp();

					Method method0 = oldModelClass.getMethod(
							"getRegistrationId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setRegistrationId(value0);

					Method method1 = oldModelClass.getMethod("getPrUserId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setPrUserId(value1);

					Method method2 = oldModelClass.getMethod("getDatePurchased");

					Date value2 = (Date)method2.invoke(oldModel, (Object[])null);

					newModel.setDatePurchased(value2);

					Method method3 = oldModelClass.getMethod("getHowHear");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setHowHear(value3);

					Method method4 = oldModelClass.getMethod(
							"getWherePurchased");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setWherePurchased(value4);

					Method method5 = oldModelClass.getMethod("getSerialNumber");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setSerialNumber(value5);

					Method method6 = oldModelClass.getMethod("getProductId");

					Long value6 = (Long)method6.invoke(oldModel, (Object[])null);

					newModel.setProductId(value6);

					Method method7 = oldModelClass.getMethod("getCompanyId");

					Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

					newModel.setCompanyId(value7);

					Method method8 = oldModelClass.getMethod("getGroupId");

					Long value8 = (Long)method8.invoke(oldModel, (Object[])null);

					newModel.setGroupId(value8);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
}