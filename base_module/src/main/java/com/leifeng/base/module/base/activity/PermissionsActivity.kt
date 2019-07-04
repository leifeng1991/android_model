package com.leifeng.base.module.base.activity

import android.annotation.SuppressLint
import com.tbruyelle.rxpermissions2.RxPermissions


abstract class PermissionsActivity : BaseActivity() {
    open var rxPermissions: RxPermissions? = null

    /**
     * 请求权限
     * @param ps 相应权限
     */
    @SuppressLint("CheckResult")
    fun requestPermissions(vararg ps: String) {
        if (rxPermissions == null) {
            rxPermissions = RxPermissions(this)
        }
        if (ps.isNotEmpty()) {
            rxPermissions!!.request(*ps).subscribe { granted ->
                if (granted) {
                    // 权限请求成功
                    onRequestPermissionsSuccess()
                } else {
                    // 权限请求失败
                    onRequestPermissionsDenied()
                }
            }
        }
    }

    /*@SuppressLint("CheckResult")
    fun clickViewRequest(vararg ps: String){
        if (rxPermissions == null) {
            rxPermissions = RxPermissions(this)
        }
        if (ps.isNotEmpty()) {
            rxPermissions?.requestEach(*ps)?.subscribe { // will emit 2 Permission objects
                    permission ->
                when {
                    permission.granted -> // 所有权限全部请求成功
                        onRequestPermissionsSuccess()
                    permission.shouldShowRequestPermissionRationale -> {
                        // Denied permission without ask never again
                    }
                    else -> // 权限请求失败
                        onRequestPermissionsDenied()
                }
            }
        }

    }*/

    /**
     * 权限请求成功
     */
    abstract fun onRequestPermissionsSuccess()

    /**
     * 权限请求失败
     */
    abstract fun onRequestPermissionsDenied()
}