package com.leifeng.android.base.mvvm.model.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import java.lang.reflect.ParameterizedType

abstract class BaseActivity<V : ViewDataBinding, VM : BaseViewModel> : RxAppCompatActivity() {
    private lateinit var mViewDataBinding: V
    protected var mViewModel: VM? = null
    private var mViewModelId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewDataBinding = DataBindingUtil.setContentView(this, layoutId())
        mViewModel = initViewModel()
        initListener()
        processingLogic()
    }

    override fun onDestroy() {
        super.onDestroy()
        mViewDataBinding.unbind()
    }

    /**
     * 返回布局id
     */
    abstract fun layoutId(): Int

    /**
     * 初始化ViewModel的id
     *
     * @return BR的id
     */
//    abstract fun initVariableId(): Int

    /**
     * 初始化ViewModel
     */
    abstract fun initViewModel(): VM?

    /**
     * 初始化相关监听事件
     */
    abstract fun initListener()

    abstract fun processingLogic()

    /**
     * 创建ViewModel
     */
    private fun <T : ViewModel> createViewModel(cls: Class<T>): T {
        return ViewModelProviders.of(this).get(cls)
    }
}
