package cn.sharing.platform.utils;

import org.apache.commons.lang3.time.DateUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类 Created by Terence on 2017/3/31.
 */
public class DateUtil {
	public static final String DATE_PATTERN_14 = "yyyyMMddHHmmss";

	public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static final String DAY_FORMAT = "yyyy-MM-dd";
	
	public static final String MONTH_FORMAT = "yyyy-MM";

	public static final String DAY_FORMAT1 = "yyyy/MM/dd";

	public static final String DATE_PATTERN_ZONE = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

	/**
	 * 日期格式：yyyyMMdd
	 */
	public static final String DATE_PATTERN_8 = "yyyyMMdd";

	public static Date format(String time) {
		Date date = null;
		try {
			date = DateUtils.parseDate(time, DATE_PATTERN_14);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return date;
	}

	/**
	 * 获取当前日期
	 * 
	 * @param pattern
	 * @return
	 */
	public static String getCurrentDateByPattern(String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);// 设置日期格式
		return df.format(new Date());

	}

	public static Date getDateByPattern(String time, String pattern) {
		Date date = null;
		if (StringUtils.isNotBlank(time)) {
			try {
				date = DateUtils.parseDate(time, pattern);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return date;
	}

	public static Date addMonths(Date time, Integer month) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cd = Calendar.getInstance();
			cd.setTime(time);
			cd.add(Calendar.MONTH, month);
			return getDateByPattern(sdf.format(cd.getTime()), DAY_FORMAT);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return date;
	}

	public static Date addDays(Date time, Integer day) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cd = Calendar.getInstance();
			cd.setTime(time);
			cd.add(Calendar.DATE, day);
			return getDateByPattern(sdf.format(cd.getTime()), DAY_FORMAT);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return date;
	}

	public static Date addWeeks(Date time, Integer weeks) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cd = Calendar.getInstance();
			cd.setTime(time);
			cd.add(Calendar.WEEK_OF_YEAR, weeks);
			return getDateByPattern(sdf.format(cd.getTime()), DAY_FORMAT);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return date;
	}

	/**
	 * 格式化日期
	 *
	 * @param date
	 * @param pattern
	 *            日期格式
	 * @return
	 */
	public static String format(Date date, String pattern) {
		return date == null ? "" : new SimpleDateFormat(pattern).format(date);
	}

	/**
	 * 获取今天日期
	 *
	 * @return 日期String
	 */
	public static String getTodayStr() {
		return dateToString(new Date(), DATE_PATTERN_8);
	}

	/**
	 * date类型转换为String类型
	 *
	 * @param date
	 * @param formatType
	 * @return
	 */
	public static String dateToString(Date date, String formatType) {
		if (null == date) {
			return StringUtils.EMPTY;
		}
		return new SimpleDateFormat(formatType).format(date);
	}

	/**
	 * 获取指定日期(取整)
	 * 
	 * @param day
	 *            与今天所相差的天数,正数表示往后数,负数表示往前数
	 * @return 日期(凌晨)
	 */
	public static Date getDate(Integer day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, day);
		setTimeToMidnight(cal);
		return cal.getTime();
	}

	/**
	 * 时间取整
	 * 
	 * @param calendar
	 */
	public static void setTimeToMidnight(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
	}

	/**
	 * 计算传入日期与现在相差的天数
	 * 
	 * @param date
	 * @return
	 */
	public static int daysFromNow(Date date) {
		Calendar cNow = Calendar.getInstance();
		Calendar cReturnDate = Calendar.getInstance();
		cNow.setTime(new Date());
		cReturnDate.setTime(date);
		setTimeToMidnight(cNow);
		setTimeToMidnight(cReturnDate);
		long todayMs = cNow.getTimeInMillis();
		long returnMs = cReturnDate.getTimeInMillis();
		long intervalMs = todayMs - returnMs;
		return millisecondsToDays(intervalMs);
	}

	public static int getIntervalDays(Date fDate, Date oDate) {

		if (null == fDate || null == oDate) {

			return -1;

		}

		long intervalMilli = oDate.getTime() - fDate.getTime();

		return (int) (intervalMilli / (24 * 60 * 60 * 1000));

	}

	/**
	 * 毫秒转为天数
	 * 
	 * @param intervalMs
	 * @return
	 */
	public static int millisecondsToDays(long intervalMs) {
		return (int) (intervalMs / (1000 * 86400));
	}

	/**
	 * 把日期转化成00时00分00秒
	 * 
	 * @param time
	 * @param day
	 * @return
	 */
	public static Date toZeroTimeDays(Date time) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cd = Calendar.getInstance();
			cd.setTime(time);
			return getDateByPattern(sdf.format(cd.getTime().getTime()) + " 00:00:00", DEFAULT_FORMAT);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return date;
	}

	/**
	 * 把日期转化成23时59分59秒
	 * 
	 * @param time
	 * @param day
	 * @return
	 */
	public static Date toEndTimeDays(Date time) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cd = Calendar.getInstance();
			cd.setTime(time);
			return getDateByPattern(sdf.format(cd.getTime().getTime()) + " 23:59:59", DEFAULT_FORMAT);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 获取当月第一天
	 * @return
	 */
	public static Date getCurrenMonthFirstDay(){
		Calendar cale = Calendar.getInstance();  
        cale.add(Calendar.MONTH, 0);  
        cale.set(Calendar.DAY_OF_MONTH, 1);  
        Date date =cale.getTime();
        
        return date;
	}
	
	public static Date getMonthFirstDay(Date date){
		Calendar cale = Calendar.getInstance();
		cale.setTime(date);
		cale.set(Calendar.DAY_OF_MONTH, 1);  
		return cale.getTime();
	}
	
	/**
	 * 根据传入日期获取一周的日期区间
	 * @param date
	 * @return
	 */
	public static Date getEndDayOfWeek(Date date){
		
		Calendar cale = Calendar.getInstance();
		cale.setTime(date);
		int day = cale.get(Calendar.DAY_OF_WEEK);
		cale.add(Calendar.DATE, cale.getFirstDayOfWeek()-day);
		Date firstDayOfWeek = cale.getTime();
		Date endDate = DateUtil.addDays(firstDayOfWeek, 6);
		
        return endDate;
	}
	
	/**
	 * 根据传入日期获取一周的日期区间
	 * @param date
	 * @return
	 */
	public static Date getFirstDayOfWeek(Date date){
		
		Calendar cale = Calendar.getInstance();
		cale.setTime(date);
		int day = cale.get(Calendar.DAY_OF_WEEK);
		cale.add(Calendar.DATE, cale.getFirstDayOfWeek()-day);
		Date firstDayOfWeek = cale.getTime();
		
		
        return firstDayOfWeek;
	}

	public static Date dateStringToDateAll(String date) {
		Date d = null;
		try{
			DateFormat dateFormat = new SimpleDateFormat(DateUtil.DAY_FORMAT);
			d = dateFormat.parse(date);
		}catch ( ParseException e){
			try{
				DateFormat dateFormat = new SimpleDateFormat(DateUtil.DAY_FORMAT1);
				d = dateFormat.parse(date);
			}catch ( ParseException ee){

			}
		}
		return  d;
	}

}
