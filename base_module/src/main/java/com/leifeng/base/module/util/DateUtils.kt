package com.cnlive.module.base.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * 描述:和时间相关的工具类
 */
@Suppress("unused")
object DateUtils {

    /**
     * @return 格式： MM-dd HH:mm
     */
    fun getMonthDayHourMinute(timeInMillis: Long): String {
        return getSimpleDateFormatFormat(timeInMillis, "MM-dd HH:mm")
    }

    /**
     * @return 格式：yyyy-MM-dd HH:mm
     */
    @JvmStatic
    fun getYearMonthDayHourMinute(timeInMillis: Long): String {
        return getSimpleDateFormatFormat(timeInMillis, "yyyy-MM-dd HH:mm")
    }

    /**
     * @return 格式：yyyy-MM-dd HH:mm:ss
     */
    @JvmStatic
    fun getYearMonthDayHourMinuteSeconds(timeInMillis: Long): String {
        return getSimpleDateFormatFormat(timeInMillis, "yyyy-MM-dd HH:mm:ss")
    }

    /**
     * 获取 SimpleDateFormat.format()
     *
     * @param timeInMillis 时间
     * @param pattern      格式
     */
    @JvmStatic
    fun getSimpleDateFormatFormat(timeInMillis: Long, pattern: String): String {
        //设置时间值
        return SimpleDateFormat(pattern, Locale.CHINA).format(timeInMillis)
    }

    /**
     * 将时间字符串转换为时间值（毫秒）
     */
    fun getTimeInMillis(source: String, pattern: String): Long {
        return try {
            SimpleDateFormat(pattern, Locale.CHINA).parse(source).time
        } catch (e: ParseException) {
            e.printStackTrace()
            0
        }
    }

    @JvmStatic
    fun getYearMonthDayHourMinute2(timeInMillis: Long): String {
        //设置时间值
        return getSimpleDateFormatFormat(timeInMillis, "yyyy.MM.dd HH:mm")
    }

    /**
     * 获取时间戳timeInMillis的年月日
     *
     * @param timeInMillis 毫秒的时间戳
     * @return 返回格式为：XX年XX月XX日
     */
    @JvmStatic
    fun getYearMonthDay(timeInMillis: Long): String {
        //设置时间值
        return getSimpleDateFormatFormat(timeInMillis, "yyyy年MM月dd日")
    }

    @JvmStatic
    fun getYearMonthDay(timeInMillis: Long, pattern: String): String {
        //设置时间值
        return SimpleDateFormat(pattern).format(Date(timeInMillis))
    }

    @JvmStatic
    fun getYearMonthDay2(timeInMillis: Long): String {
        //设置时间值
        return getSimpleDateFormatFormat(timeInMillis, "yyyy.MM.dd")
    }
}
