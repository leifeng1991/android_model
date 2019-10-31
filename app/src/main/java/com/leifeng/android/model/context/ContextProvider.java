package com.leifeng.android.model.context;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ContentProvider;
import android.content.Context;

public class ContextProvider {

    @SuppressLint("StaticFieldLeak")
    private static volatile ContextProvider instance;

    private Context mContext;

    private ContextProvider(Context mContext) {
        this.mContext = mContext;
    }

    public static ContextProvider get(){
        if (null == instance){
            synchronized (ContentProvider.class){
                if (null == instance){
                    Context context = ApplicationContextProvider.mContext;
                    if (null == context){
                        throw new  IllegalStateException("context == null");
                    }
                    instance = new ContextProvider(context);
                }
            }
        }

        return instance;
    }

    /**
     * 获取上下文
     */
    public Context getContext() {
        return mContext;
    }

    public Application getApplication() {
        return (Application) mContext.getApplicationContext();
    }
}
