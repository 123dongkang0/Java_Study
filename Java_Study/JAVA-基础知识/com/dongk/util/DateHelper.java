package com.dongk.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateHelper {

	public DateHelper() {
	}

	public static Date currentDate() {
		return new Date();
	}

	/**
	 * �õ���ȥ��δ��N�������
	 */
	public static Date getCustomDay(boolean isBefore, int days) {

		Date t = null;
		if (isBefore) {
			t = new Date(new Date().getTime() - (long) days * 24 * 3600 * 1000);
		} else {
			t = new Date(new Date().getTime() + (long) days * 24 * 3600 * 1000);
		}
		return t;
	}

	/**
	 * �õ�����ʱ��Ĳ�ֵ(��)
	 */
	public static int getGapDaysBetween(Date d1, Date d2) {

		long d1m = d1.getTime();
		long d2m = d2.getTime();
		long dayGap = 0L;

		if (d1m > d2m) {
			dayGap = d1m - d2m;
		} else {
			dayGap = d2m - d1m;
		}

		long returnDays = dayGap / ((long) (24 * 3600 * 1000));

		return (int) returnDays;
	}

	/**
	 * �õ�ĳһ���ȥ��δ��N��������ַ���
	 */
	public static String getCustomDay(boolean isBefore, Date date, int days,
			String format) {

		Date t = null;
		if (isBefore) {
			t = new Date(date.getTime() - (long) days * 24 * 3600 * 1000);
		} else {
			t = new Date(date.getTime() + (long) days * 24 * 3600 * 1000);
		}
		if (format == null)
			format = "yyyy-MM-dd";
		return getDateFormatStr(format, t);
	}

	/**
	 * �õ�ĳһ���ȥ��δ��N��������ַ���
	 */
	public static String getCustomDay(boolean isBefore, String date, int days, String format) {

		Date t = null;
		try {
			if (isBefore) {
				t = new Date(strToFormattedDate(date, format).getTime()
						- (long) days * 24 * 3600 * 1000);
			} else {
				t = new Date(strToFormattedDate(date, format).getTime()
						+ (long) days * 24 * 3600 * 1000);
			}
		} catch (Exception e) {

		}
		if (t == null) {
			return "";
		} else {
			if (format == null)
				format = "yyyy-MM-dd";
			return getDateFormatStr(format, t);
		}
	}

	/**
	 * ����ת��Ϊ�ַ���
	 */
	public static String getDateFormatStr(String format, Date dateToFormat) {
		if (format == null || dateToFormat == null) {
			return null;
		}
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String dateString = formatter.format(dateToFormat);
		return dateString;
	}

	public static String getDateFormatStr(String format, Date dateToFormat,
			Locale locale) {
		if (format == null || dateToFormat == null) {
			return null;
		}
		SimpleDateFormat formatter = new SimpleDateFormat(format, locale);
		String dateString = formatter.format(dateToFormat);

		return dateString;
	}

	/**
	 * �ַ���ת��Ϊ������
	 */
	public static Date strToFormattedDate(String yearMonth, String format)
			throws Exception {
		if (yearMonth == null || yearMonth.length() == 0) {
			return null;
		}
		SimpleDateFormat dateFormatter = new SimpleDateFormat(format);
		Date rt = null;
		rt = dateFormatter.parse(yearMonth);
		return rt;
	}


}
