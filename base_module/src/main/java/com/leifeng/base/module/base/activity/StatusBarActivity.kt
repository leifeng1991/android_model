package com.leifeng.base.module.base.activity

import com.jaeger.library.StatusBarUtil
import com.leifeng.base.module.R

abstract class StatusBarActivity : BaseActivity() {

    override fun init() {
        setStatusBar()
        super.init()
    }

    open fun setStatusBar(){
        StatusBarUtil.setColor(this, resources.getColor(R.color.colorStatusBar))
    }
}