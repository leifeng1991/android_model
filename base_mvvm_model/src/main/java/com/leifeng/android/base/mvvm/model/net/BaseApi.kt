package com.leifeng.android.base.mvvm.model.net

import com.leifeng.android.base.mvvm.model.DynamicDataBean
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface BaseApi{
    /**
     * 达人主页动态列表
     *
     * @param uid  用户id
     * @param id   达人id
     * @param page 页数，默认1
     * uid = 10522084）（id = 10515294）（page = 1
     */
    @FormUrlEncoded
    @POST("https://wjjshop.cnlive.com/Api/Dynamic/shopUserDynamicList")
    abstract fun shopUserDynamicList(@Field("uid") uid: String, @Field("id") id: String, @Field("page") page: String): Observable<RequestResultBean<DynamicDataBean>>
}
