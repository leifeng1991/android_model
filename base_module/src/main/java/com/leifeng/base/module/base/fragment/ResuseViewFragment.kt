package com.leifeng.base.module.base.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class ResuseViewFragment : BaseFragment() {

    private var isFirst = true// 是否是第一次执行
    open var rootView: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (rootView == null) {
            isFirst = true
            rootView = super.onCreateView(inflater, container, savedInstanceState)
        } else {
            isFirst = false
            val parent = rootView!!.parent
            if (parent != null && parent is ViewGroup) {
                parent.removeView(rootView)
            }
        }
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // BaseFragment的Fragment生命周期方法都要覆盖，在此判断是否不执行其生命周期
        // 第一次执行，走生命周期，否则不走生命周期，解决 initView()、initListener()、processingLogic()重复调用
        if (isFirst)// 不能用rootView==null判断，因为rootView始终不等于null
            super.onViewCreated(view, savedInstanceState)
    }


}
