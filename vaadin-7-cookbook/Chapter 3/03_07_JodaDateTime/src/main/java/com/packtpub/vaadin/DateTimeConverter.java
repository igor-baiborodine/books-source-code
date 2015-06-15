package com.packtpub.vaadin;

import java.util.Date;
import java.util.Locale;

import org.joda.time.DateTime;

import com.vaadin.data.util.converter.Converter;
import com.vaadin.data.util.converter.Converter.ConversionException;

public class DateTimeConverter implements Converter<Date, DateTime> {

	@Override
	public DateTime convertToModel(Date value, Locale locale)
			throws ConversionException {
		return new DateTime(value);
	}

	@Override
	public Date convertToPresentation(DateTime value, Locale locale)
			throws ConversionException {
		Date date = value.toDate();
		return date;
	}

	@Override
	public Class<DateTime> getModelType() {
		return DateTime.class;
	}

	@Override
	public Class<Date> getPresentationType() {
		return Date.class;
	}
}