package com.leifeng.android.base.mvvm.model.base;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;

public class BaseViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static BaseViewModelFactory INSTANCE = null;
    private final Application mApplication;

    private BaseViewModelFactory(Application mApplication) {
        this.mApplication = mApplication;
    }

    public static BaseViewModelFactory getInstance(Application mApplication){
        if (INSTANCE == null){
            synchronized (BaseViewModelFactory.class){
                if (INSTANCE == null){
                    INSTANCE = new BaseViewModelFactory(mApplication);
                }
            }
        }
        return INSTANCE;
    }


    /**
     * 创建ViewModel
     */
    public <T extends ViewModel> T createViewModel(FragmentActivity activity, Class<T> cls) {
        return ViewModelProviders.of(activity).get(cls);
    }
}
