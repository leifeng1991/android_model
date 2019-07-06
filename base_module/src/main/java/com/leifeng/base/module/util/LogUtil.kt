package com.cnlive.module.base.utils

import android.util.Log


/**
 * 描述: Log的封装类
 */
object LogUtil {

    private var isLogOpen = true// 是否打印log
    private const val TAG = "Base"

    @JvmStatic
    fun init(isLogOpen: Boolean) {
        this.isLogOpen = isLogOpen
    }

    @JvmStatic
    fun v(msg: String) {
        if (isLogOpen) Log.v(TAG, msg)
    }

    @JvmStatic
    fun v(tag: String, msg: String) {
        if (isLogOpen) Log.v(tag, msg)
    }

    @JvmStatic
    fun d(msg: String) {
        if (isLogOpen) Log.d(TAG, msg)
    }

    @JvmStatic
    fun d(tag: String, msg: String) {
        if (isLogOpen) Log.d(tag, msg)
    }

    @JvmStatic
    fun i(msg: String) {
        if (isLogOpen) Log.i(TAG, msg)
    }

    @JvmStatic
    fun i(tag: String, msg: String) {
        if (isLogOpen) Log.i(tag, msg)
    }

    @JvmStatic
    fun w(msg: String) {
        if (isLogOpen) Log.w(TAG, msg)
    }

    @JvmStatic
    fun w(tag: String, msg: String) {
        if (isLogOpen) Log.w(tag, msg)
    }

    @JvmStatic
    fun e(msg: String) {
        if (isLogOpen) Log.e(TAG, msg)
    }

    @JvmStatic
    fun e(tr: Throwable) {
        if (isLogOpen) Log.e(TAG, "Exception", tr)
    }

    @JvmStatic
    fun e(tag: String, msg: String) {
        if (isLogOpen) Log.e(tag, msg)
    }

}
