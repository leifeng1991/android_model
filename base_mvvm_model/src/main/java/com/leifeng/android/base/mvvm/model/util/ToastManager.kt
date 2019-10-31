package com.cnlive.module.base.utils

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.text.TextUtils
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import com.leifeng.android.base.mvvm.model.base.App

/**
 * 单例的吐司
 */
@SuppressLint("ShowToast")
object ToastManager {
    private var isToastOpen = false

    private val toast: Toast by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        val context = App.INSTANCE.applicationContext
        val toast = Toast.makeText(context, "", Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.CENTER, 0, 0)
        // 设置归原
        val tv = TextView(context)
        tv.setTextColor(Color.WHITE)
        val padding = dp2px(context, 10f)
        tv.setPadding(padding, padding, padding, padding)
        tv.background = getBackground(context)
        toast.view = tv
        toast
    }

    @JvmStatic
    fun init(isToastOpen: Boolean) {
        this.isToastOpen = isToastOpen
    }

    @JvmStatic
    fun showShortToast(message: String?) {
        setToastText(message)
        toast.duration = Toast.LENGTH_SHORT
        toast.show()
    }

    @JvmStatic
    fun showShortToast(resId: Int) {
        setToastText(resId)
        toast.duration = Toast.LENGTH_SHORT
        toast.show()
    }

    @JvmStatic
    fun showLongToast(message: String?) {
        setToastText(message)
        toast.duration = Toast.LENGTH_LONG
        toast.show()
    }

    @JvmStatic
    fun showLongToast(resId: Int) {
        setToastText(resId)
        toast.duration = Toast.LENGTH_LONG
        toast.show()
    }

    @JvmStatic
    fun showMsgToast(message: String?) {
        setToastText(if (TextUtils.isEmpty(message)) "服务器返回数据错误，请稍后再试" else message)
        toast.duration = Toast.LENGTH_SHORT
        toast.show()
    }

    /**
     * 展示错误提示
     */
    @Suppress("ConstantConditionIf")
    @JvmStatic
    fun showErrorToast(errorStr: String?) {
        var errorMessage = "对不起，获取数据错误！请检查网络或稍后再试！"
        if (isToastOpen) {
            // 测试的版本
            errorMessage = errorStr ?: ""
        }
        setToastText(errorMessage)
        toast.duration = Toast.LENGTH_SHORT
        toast.show()
    }

    @JvmStatic
    private fun setToastText(message: CharSequence?) {
        toast.apply {
            if (view is TextView) {
                (view as TextView).text = message
            }
        }
    }

    private fun setToastText(resId: Int) {
        toast.apply {
            setToastText(view.context.getText(resId))
        }
    }

    private fun getBackground(context: Context): Drawable {
        val roundRadius = dp2px(context, 8f) // 8dp 圆角半径
        val fillColor = Color.parseColor("#bb000000")//内部填充颜色
        val gd = GradientDrawable()//创建drawable
        gd.setColor(fillColor)
        gd.cornerRadius = roundRadius.toFloat()
        return gd
    }

    private fun dp2px(context: Context, dipValue: Float): Int {
        return (dipValue * context.resources.displayMetrics.density + 0.5f).toInt()
    }
}
