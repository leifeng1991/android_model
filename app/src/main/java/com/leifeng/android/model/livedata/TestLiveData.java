package com.leifeng.android.model.livedata;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class TestLiveData extends AndroidViewModel {
    private MutableLiveData<List<String>> list;

    public TestLiveData(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<String>> getList() {
        return list;
    }
}
