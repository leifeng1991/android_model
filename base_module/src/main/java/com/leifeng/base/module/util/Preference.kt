package com.cnlive.module.base.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.text.TextUtils
import com.leifeng.base.module.base.App

@Suppress("unused")
/**
 * SharedPreferences工具类
 */
@SuppressLint("ApplySharedPref")
object Preference {
    private const val NAME = "SharedPref"
    private val sp: SharedPreferences by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        App.INSTANCE.getSharedPreferences(NAME, Context.MODE_PRIVATE)
    }

    /**
     * 存储-Boolean
     */
    fun putBoolean(key: String, value: Boolean) = put(key, value)

    /**
     * 存储-String
     */
    fun putString(key: String, value: String) = put(key, value)

    /**
     * 存储-Int
     */
    fun putInt(key: String, value: Int) = put(key, value)

    /**
     * 存储-Long
     */
    fun putLong(key: String, value: Long) = put(key, value)

    /**
     * 存储-Float
     */
    fun putFloat(key: String, value: Float) = put(key, value)

    /**
     * 获取-Boolean-默认false
     */
    fun getBoolean(key: String): Boolean = get(key, false)

    /**
     * 获取-Boolean
     */
    fun getBoolean(key: String, default: Boolean): Boolean = get(key, default)

    /**
     * 获取-String-默认""
     */
    fun getString(key: String): String = get(key, "")

    /**
     * 获取-String
     */
    fun getString(key: String, default: String): String = get(key, default)

    /**
     *  获取-Int-默认0
     */
    fun getInt(key: String): Int = get(key, 0)

    /**
     *  获取-Int
     */
    fun getInt(key: String, default: Int): Int = get(key, default)

    /**
     *  获取-Long-默认0
     */
    fun getLong(key: String): Long = get(key, 0)

    /**
     *  获取-Long
     */
    fun getLong(key: String, default: Long): Long = get(key, default)

    /**
     *  获取-Float-默认0
     */
    fun getFloat(key: String): Float = get(key, 0f)

    /**
     *  获取-Float
     */
    fun getFloat(key: String, default: Float): Float = get(key, default)

    private fun <T> put(key: String, value: T) = with(sp.edit()) {
        when (value) {
            is Long -> putLong(key, value)
            is String -> putString(key, value)
            is Int -> putInt(key, value)
            is Boolean -> putBoolean(key, value)
            is Float -> putFloat(key, value)
            else -> throw IllegalArgumentException("SharedPreferences can't be save this type")
        }.commit()
    }

    @Suppress("UNCHECKED_CAST")
    private fun <T> get(key: String, default: T): T = with(sp) {
        val res: Any = when (default) {
            is Long -> getLong(key, default)
            is String -> getString(key, default)
            is Int -> getInt(key, default)
            is Boolean -> getBoolean(key, default)
            is Float -> getFloat(key, default)
            else -> throw IllegalArgumentException("SharedPreferences can't be get this type")
        }
        return res as T
    }

    /**
     * 存储-Set<String>
     */
    fun putStringSet(key: String, value: Set<String>) {
        sp.edit().putStringSet(key, value).commit()
    }

    /**
     * 获取-Set<String>
     */
    fun getStringSet(key: String, defValues: Set<String>?): Set<String>? {
        return sp.getStringSet(key, defValues)
    }

    /**
     * 存储-List<String>
     */
    fun putStringList(key: String, value: List<String>) {
        sp.edit().putString(key, value.joinToString(",")).commit()
    }

    /**
     * 获取-Set<String>
     */
    fun getStringList(key: String): ArrayList<String> {
        val arrayList = ArrayList<String>()
        for (s in getString(key).split(",")) {
            if (!TextUtils.isEmpty(s))
                arrayList.add(s)
        }
        return arrayList
    }

    /**
     * 删除-key
     */
    fun remove(key: String) {
        sp.edit().remove(key).commit()
    }

    /**
     * 删除-All
     */
    fun clear() {
        sp.edit().clear().commit()
    }

    /**
     * 判断是否包含key
     */
    fun contains(key: String) = sp.contains(key)

}
