package com.leifeng.base.module.base.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trello.rxlifecycle2.components.support.RxFragment


abstract class BaseFragment : RxFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        initView()
        initListener()
        processingLogic()
    }

    /**
     * 返回布局
     */
    abstract fun getLayoutId(): Int

    /**
     * 初始化相关控件
     */
    abstract fun initView()

    /**
     * 初始化相关监听事件
     */
    abstract fun initListener()

    abstract fun processingLogic()
}
