package com.leifeng.base.module.net;

import android.text.TextUtils;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.util.concurrent.TimeUnit.SECONDS;

public class RetrofitFactory {
    public static final int CONNECT_TIME_OUT = 30;
    public static final int CALL_TIME_OUT = 30;
    private static volatile RetrofitFactory INSTANCE = null;
    private Retrofit mRetrofit;
    private String baseUrl = "https://wjjshop.cnlive.com";

    private RetrofitFactory() {
        init();
    }

    public static RetrofitFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (RetrofitFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new RetrofitFactory();
                }
            }
        }
        return INSTANCE;
    }

    private void init() {
        if (TextUtils.isEmpty(baseUrl)) {
            throw new NullPointerException("统一基地址 baseUrl 不能为空");
        }
        // 初始化OkHttpClient
        OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIME_OUT, SECONDS)
                .callTimeout(CALL_TIME_OUT, SECONDS)
                .addInterceptor(new LogInterceptor()) // 添加日志拦截器
                .build();
        // 初始化Retrofit
        mRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)// 统一基地址
                .client(mOkHttpClient)// 请求客户端
                .addConverterFactory(GsonConverterFactory.create())// 数据转换器工厂
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())// 网络请求适配器工厂
                .build();

    }

    public <T> T create(Class<T> service) {
        return mRetrofit.create(service);
    }
}
