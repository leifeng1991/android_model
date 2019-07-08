package com.leifeng.android.model

import com.chad.library.adapter.base.BaseViewHolder
import com.leifeng.base.module.base.adapter.BaseAdapter

class TestAdapter(layoutResId: Int, data: List<String>?) : BaseAdapter<String>(layoutResId, data) {

    override fun convert(holder: BaseViewHolder?, position: Int?, item: String) {
        holder!!.setText(R.id.mTextView, "" + position!!)
    }
}
