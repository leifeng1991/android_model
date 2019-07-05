package com.cnlive.module.base.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.NetworkInfo

import java.util.ArrayList

/**
 * 网络状态的管理者
 */
object NetStateManager {
    private val onNetStateChangeListeners = ArrayList<OnNetStateChangeListener>()
    private val mNetStateReceiver = object : BroadcastReceiver() {

        override fun onReceive(context: Context, intent: Intent) {
            if (isAvailable(context)) {
                // 网络可用
                notifyNetAvailable(true)
            } else {
                // 网络不用
                notifyNetAvailable(false)
            }
        }
    }

    /**
     * 通知所有的监听，当前的网络状态
     */
    private fun notifyNetAvailable(isAvailable: Boolean) {
        for (netStateChangeListener in onNetStateChangeListeners) {
            netStateChangeListener.onNetStateChange(isAvailable)
        }
    }

    /**
     * 判断当前网络是否可用，true为可用
     */
    @JvmStatic
    fun isAvailable(context: Context): Boolean {
        val mConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = mConnectivityManager.activeNetworkInfo
        return netInfo != null && netInfo.isAvailable
    }

    /**
     * 注册监听网络状态改变的广播
     */
    @JvmStatic
    fun registerNetStateReceiver(context: Context) {
        val filter = IntentFilter()
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION)
        context.registerReceiver(mNetStateReceiver, filter)
    }


    /***
     * 反注册监听网络状态改变的广播
     */
    @JvmStatic
    fun unregisterNetStateReceiver(context: Context) {
        context.unregisterReceiver(mNetStateReceiver)
    }

    /**
     * 增加某个监听到集合监听中
     */
    @JvmStatic
    fun addOnNetStateChangeListener(listener: OnNetStateChangeListener) {
        onNetStateChangeListeners.add(listener)
    }

    /**
     * 移除集合中某个监听
     */
    @JvmStatic
    fun removeOnNetStateChangeListener(listener: OnNetStateChangeListener) {
        onNetStateChangeListeners.remove(listener)
    }

    /**
     * 是否有集合中某个监听
     */
    @JvmStatic
    fun hasOnNetStateChangeListener(listener: OnNetStateChangeListener?): Boolean {
        return listener != null && onNetStateChangeListeners.contains(listener)
    }

    /**
     * 移除集合中所有的监听
     */
    @JvmStatic
    fun removeAllOnNetStateChangeListener() {
        onNetStateChangeListeners.clear()
    }

    interface OnNetStateChangeListener {
        /**
         * 网络状态改变
         *
         * @param isAvailable 网络是否可用，true为可用
         */
        fun onNetStateChange(isAvailable: Boolean)
    }
}
