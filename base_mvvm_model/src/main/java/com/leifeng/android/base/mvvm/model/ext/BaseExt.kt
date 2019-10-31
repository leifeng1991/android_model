package com.leifeng.android.base.mvvm.model.ext

import com.leifeng.android.base.mvvm.model.net.BaseApi
import com.leifeng.android.base.mvvm.model.net.RetrofitFactory

internal val baseApi by lazy { RetrofitFactory.getInstance().create(BaseApi::class.java) }