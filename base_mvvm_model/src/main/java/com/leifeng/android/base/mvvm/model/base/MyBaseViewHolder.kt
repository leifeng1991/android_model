package com.leifeng.android.base.mvvm.model.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.view.View

import com.chad.library.adapter.base.BaseViewHolder
import com.leifeng.android.base.mvvm.model.BR

class MyBaseViewHolder(view: View) : BaseViewHolder(view) {

    internal var mViewDataBinding: ViewDataBinding? = null

    init {
        mViewDataBinding = DataBindingUtil.bind(view)
    }
}
