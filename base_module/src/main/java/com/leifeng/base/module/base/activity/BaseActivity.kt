package com.leifeng.base.module.base.activity

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = applicationContext
        init()
    }

    open fun init(){
        loadViewLayout()
        initView()
        initListener()
        processingLogic()
    }

    abstract fun loadViewLayout()
    abstract fun initView()
    abstract fun initListener()
    abstract fun processingLogic()

}