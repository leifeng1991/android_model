package com.leifeng.base.module.base.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

abstract class BaseAdapter<T>(layoutResId: Int, data: List<T>?) : BaseQuickAdapter<T, BaseViewHolder>(layoutResId, data) {

    override fun convert(holder: BaseViewHolder?, item: T) {
        convert(holder, holder?.layoutPosition?.minus(headerLayoutCount),item)
    }

    abstract fun convert(holder: BaseViewHolder?, position: Int?, item: T)
}
