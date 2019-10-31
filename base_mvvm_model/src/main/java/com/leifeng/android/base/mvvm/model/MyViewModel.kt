package com.leifeng.android.base.mvvm.model

import android.app.Application
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData
import com.leifeng.android.base.mvvm.model.base.BaseViewModel
import com.leifeng.android.base.mvvm.model.ext.baseApi
import com.leifeng.android.base.mvvm.model.net.OnRequestListener
import com.leifeng.android.base.mvvm.model.net.RequestManner

class MyViewModel(application: Application) : BaseViewModel(application) {
    private val mDynamicDataBeanMediatorLiveData: MutableLiveData<DynamicDataBean> = MutableLiveData()

    fun getNetData() {
        RequestManner.ConvertDataRequest(baseApi.shopUserDynamicList("10522084", "10515294", "1"),
            object : OnRequestListener<DynamicDataBean>(this) {
                override fun onSuccess(bean: DynamicDataBean?) {
                    // 同步
                    mDynamicDataBeanMediatorLiveData.value = bean
                    // 异步
//                    mDynamicDataBeanMediatorLiveData.postValue(bean)
                }

            })
    }

    fun getDynamicList(): MutableLiveData<DynamicDataBean> {
        return mDynamicDataBeanMediatorLiveData
    }
}
