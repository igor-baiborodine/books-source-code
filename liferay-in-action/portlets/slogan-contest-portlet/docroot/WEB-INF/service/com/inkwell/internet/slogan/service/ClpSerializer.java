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

package com.inkwell.internet.slogan.service;

import com.inkwell.internet.slogan.model.SloganClp;

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
	public static final String SERVLET_CONTEXT_NAME = "slogan-contest-portlet";

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(SloganClp.class.getName())) {
			SloganClp oldCplModel = (SloganClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.inkwell.internet.slogan.model.impl.SloganImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setUuid",
							new Class[] { String.class });

					String value0 = oldCplModel.getUuid();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setSloganId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getSloganId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setSloganDate",
							new Class[] { Date.class });

					Date value2 = oldCplModel.getSloganDate();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setSloganText",
							new Class[] { String.class });

					String value3 = oldCplModel.getSloganText();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setStatus",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getStatus());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setStatusByUserId",
							new Class[] { Long.TYPE });

					Long value5 = new Long(oldCplModel.getStatusByUserId());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setStatusByUserName",
							new Class[] { String.class });

					String value6 = oldCplModel.getStatusByUserName();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setStatusDate",
							new Class[] { Date.class });

					Date value7 = oldCplModel.getStatusDate();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value8 = new Long(oldCplModel.getCompanyId());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setGroupId",
							new Class[] { Long.TYPE });

					Long value9 = new Long(oldCplModel.getGroupId());

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setUserId",
							new Class[] { Long.TYPE });

					Long value10 = new Long(oldCplModel.getUserId());

					method10.invoke(newModel, value10);

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
					"com.inkwell.internet.slogan.model.impl.SloganImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					SloganClp newModel = new SloganClp();

					Method method0 = oldModelClass.getMethod("getUuid");

					String value0 = (String)method0.invoke(oldModel,
							(Object[])null);

					newModel.setUuid(value0);

					Method method1 = oldModelClass.getMethod("getSloganId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setSloganId(value1);

					Method method2 = oldModelClass.getMethod("getSloganDate");

					Date value2 = (Date)method2.invoke(oldModel, (Object[])null);

					newModel.setSloganDate(value2);

					Method method3 = oldModelClass.getMethod("getSloganText");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setSloganText(value3);

					Method method4 = oldModelClass.getMethod("getStatus");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setStatus(value4);

					Method method5 = oldModelClass.getMethod(
							"getStatusByUserId");

					Long value5 = (Long)method5.invoke(oldModel, (Object[])null);

					newModel.setStatusByUserId(value5);

					Method method6 = oldModelClass.getMethod(
							"getStatusByUserName");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setStatusByUserName(value6);

					Method method7 = oldModelClass.getMethod("getStatusDate");

					Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

					newModel.setStatusDate(value7);

					Method method8 = oldModelClass.getMethod("getCompanyId");

					Long value8 = (Long)method8.invoke(oldModel, (Object[])null);

					newModel.setCompanyId(value8);

					Method method9 = oldModelClass.getMethod("getGroupId");

					Long value9 = (Long)method9.invoke(oldModel, (Object[])null);

					newModel.setGroupId(value9);

					Method method10 = oldModelClass.getMethod("getUserId");

					Long value10 = (Long)method10.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value10);

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