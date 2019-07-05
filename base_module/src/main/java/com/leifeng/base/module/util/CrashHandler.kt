package com.cnlive.module.base.utils

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Environment
import android.os.Process
import android.support.v4.content.ContextCompat
import java.io.*
import java.net.UnknownHostException


/**
 * 描述: Log的封装类
 */
class CrashHandler constructor(private val context: Context, private var onCrashListener: OnCrashListener? = null) :
        Thread.UncaughtExceptionHandler {

    /**
     * 获取手机的信息
     */
    private val phoneInfo: String
        get() {
            val packageManager = context.packageManager
            try {
                val packageInfo = packageManager.getPackageInfo(context.packageName, PackageManager.GET_ACTIVITIES)
                return " versionName : " + packageInfo.versionName +
                        "\n versionCode : " + packageInfo.versionCode +
                        "\n OS  version : " + Build.VERSION.RELEASE +
                        "\n 制造商 : " + Build.MANUFACTURER +
                        "\n手机型号 : " + Build.MODEL +
                        "\n cpu架构 : " + Build.CPU_ABI + "  " + Build.CPU_ABI2
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return ""
        }

    init {
        Thread.setDefaultUncaughtExceptionHandler(this)
    }

    // 捕获异常
    override fun uncaughtException(thread: Thread, ex: Throwable) {
        // 打印异常信息
        ex.printStackTrace()
        // 本地保存异常信息
        val time = DateUtils.getYearMonthDayHourMinuteSeconds(System.currentTimeMillis())
        val phoneInfo = phoneInfo
        val cashMessage = time + "\n" + phoneInfo + ("\n" + getStackTraceString(ex))
        saveFile(cashMessage)
        // 设置捕获到异常
        if (onCrashListener != null)
            onCrashListener!!.onCrash(cashMessage)
        // 杀死进程
        Process.killProcess(Process.myPid())
    }

    /**
     * 保存文件
     */
    private fun saveFile(result: String) {
        var output: FileOutputStream? = null
        try {
            val dirFile = if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED
                    && ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                // 有sd卡，创建文件需要权限
                File(Environment.getExternalStorageDirectory(), "appLog")
            } else {
                // 无sd卡，创建文件不需要权限
                File(context.filesDir, "appLog")
            }
            if (!dirFile.exists()) dirFile.mkdir()// 不存在就创建
            output = FileOutputStream(File(dirFile, "log" + System.currentTimeMillis() + ".txt"), false)
            output.write(result.toByteArray())
            output.flush()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            try {
                output?.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }
    }

    /**
     * 创建目录文件
     */
    private fun createSDCardDir(newPath: String): Boolean {
        val file = File(newPath)
        // 若存在，直接返回，若不存在，则创建目录文件
        return file.exists() || file.mkdir()
    }

    /**
     * 获取异常信息
     */
    private fun getStackTraceString(tr: Throwable?): String {
        if (tr == null)
            return ""
        var t = tr
        while (t != null) {
            if (t is UnknownHostException) {
                return ""
            }
            t = t.cause
        }
        val sw = StringWriter()
        val pw = PrintWriter(sw)
        tr.printStackTrace(pw)
        pw.flush()
        return sw.toString()
    }

    interface OnCrashListener {
        fun onCrash(error: String)
    }
}