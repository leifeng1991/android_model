package com.leifeng.android.base.mvvm.model


import java.io.Serializable
import java.util.*

/**
 * by Administrator on 2017/9/12.
 */

class DynamicDataBean : Serializable {
    var time: String? = null
    var list: List<DynamicListBean> = ArrayList()
}
