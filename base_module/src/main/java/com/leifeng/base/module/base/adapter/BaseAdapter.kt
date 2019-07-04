package com.leifeng.base.module.base.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

class BaseAdapter<T>(layoutResId: Int, data: List<T>?) : BaseQuickAdapter<T, BaseViewHolder>(layoutResId, data) {

    override fun convert(holder: BaseViewHolder?, item: T) {
    }

}
