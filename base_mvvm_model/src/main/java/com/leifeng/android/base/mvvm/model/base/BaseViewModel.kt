package com.leifeng.android.base.mvvm.model.base

import android.app.Application
import android.arch.lifecycle.*
import com.leifeng.android.base.mvvm.model.util.LogUtil
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {

    // 管理RxJava，主要针对RxJava异步操作造成的内存泄漏
    private var mCompositeDisposable: CompositeDisposable? = null

    fun addSubscribe(disposable: Disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = CompositeDisposable()
        }
        mCompositeDisposable!!.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        LogUtil.e("=================================BaseViewModel")
        if (mCompositeDisposable != null) {
            // clear all the subscription
            mCompositeDisposable!!.clear()
            mCompositeDisposable = null
        }
    }


}
