package com.cnlive.module.base.utils

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

/**
 * 输入法的工具类
 *
 * @author zhangrq
 */
object InputMethodUtils {

    /**
     * 获取输入法Manager
     */
    private fun getInputMethodManager(context: Context) = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

    /**
     * 隐藏Activity页面的软键盘
     *
     * @param activity Activity
     */
    fun hideInputMethod(activity: Activity): Boolean {
        val view = activity.window.peekDecorView()
        return view != null && getInputMethodManager(activity).hideSoftInputFromWindow(view.windowToken, 0)
    }

    /**
     * 让EditText失去焦点并隐藏软键盘
     *
     * @param context 上下文
     * @param edit    EditText
     */
    fun hideInputMethod(context: Context, edit: EditText): Boolean {
        edit.clearFocus()
        return getInputMethodManager(context).hideSoftInputFromWindow(edit.windowToken, 0)
    }


    /**
     * 让EditText获取焦点并显示软键盘
     *
     * @param context 上下文
     * @param edit    EditText
     */
    fun showInputMethod(context: Context, edit: EditText): Boolean {
        edit.isFocusable = true
        edit.isFocusableInTouchMode = true
        edit.requestFocus()
        return getInputMethodManager(context).showSoftInput(edit, 0)
    }

    /**
     * 让EditText获取焦点并切换软键盘
     *
     * @param context 上下文
     * @param edit    EditText
     */
    fun toggleSoftInput(context: Context, edit: EditText) {
        edit.isFocusable = true
        edit.isFocusableInTouchMode = true
        edit.requestFocus()
        getInputMethodManager(context).toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
    }
}
