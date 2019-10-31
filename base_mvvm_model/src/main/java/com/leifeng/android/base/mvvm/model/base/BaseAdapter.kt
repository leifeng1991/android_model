package com.leifeng.android.base.mvvm.model.base

import com.chad.library.adapter.base.BaseQuickAdapter

abstract class BaseAdapter<T>(layoutResId: Int, data: List<T>?) : BaseQuickAdapter<T, MyBaseViewHolder>(layoutResId, data) {

    override fun convert(helper: MyBaseViewHolder, item: T) {
        convert(helper,helper.layoutPosition - headerLayoutCount,item)
    }

    abstract fun convert(holder: MyBaseViewHolder, position: Int, item: T)

}
