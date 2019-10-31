package com.leifeng.android.base.mvvm.model.net

import io.reactivex.Observable

object RequestManner {

    /**
     * 原始方法
     */
    fun <T> Request(observable: Observable<T>, observer: OnRequestListener<T>) {
        observable.compose(BaseSchedulers.compose()).subscribe(observer)
    }

    /**
     * 转换-返回RequestResultBean
     */
    fun <T> ConvertBeanRequest(observable: Observable<RequestResultBean<T>>, observer: OnRequestListener<RequestResultBean<T>>) {
        observable.compose(BaseConvertBeanSchedulers.compose()).subscribe(observer)
    }

    /**
     * 转换-返回RequestResultBean中data对应的
     */
    fun <T> ConvertDataRequest(observable: Observable<RequestResultBean<T>>, observer: OnRequestListener<T>) {
        observable.compose(BaseConvertDataSchedulers.compose()).subscribe(observer)
    }


}
