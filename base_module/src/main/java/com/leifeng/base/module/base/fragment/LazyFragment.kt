package com.leifeng.base.module.base.fragment

import android.os.Bundle


abstract class LazyFragment : ResuseViewFragment() {

    // 是否初始化过布局
    private var isViewInitiated: Boolean = false
    // 当前界面是否可见
    private var isVisibleToUser: Boolean = false
    // 是否加载过数据
    open var isDataInitiated: Boolean = false

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        isViewInitiated = true
        prepareLoadData()
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        this.isVisibleToUser = isVisibleToUser
        if (isVisibleToUser){
            prepareLoadData()
        }
    }

    open fun prepareLoadData(){
        if (isViewInitiated && isVisibleToUser && !isDataInitiated){
            onLazyLoad()
            isDataInitiated = true
        }
    }

    /**
     * 数据加载
     */
    abstract fun onLazyLoad()
}
