package com.leifeng.base.module.base.activity

import android.content.Context
import android.os.Bundle
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

abstract class BaseActivity : RxAppCompatActivity() {
    open lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = applicationContext
        setContentView(getLayoutId())
        init()
    }

    open fun init(){
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