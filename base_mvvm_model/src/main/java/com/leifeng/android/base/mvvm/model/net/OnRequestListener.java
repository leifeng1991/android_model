package com.leifeng.android.base.mvvm.model.net;

import android.net.ParseException;
import android.util.Log;
import com.cnlive.module.base.utils.ToastManager;
import com.google.gson.JsonParseException;
import com.leifeng.android.base.mvvm.model.base.BaseViewModel;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.json.JSONException;
import retrofit2.HttpException;

import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;

public abstract class OnRequestListener<T> implements Observer<T> {
    private BaseViewModel v;

    public OnRequestListener(BaseViewModel v) {
        this.v = v;
    }

    @Override
    public void onSubscribe(Disposable d) {
        v.addSubscribe(d);
        Log.e("=================", "onSubscribe");
    }

    @Override
    public void onNext(T t) {
        Log.e("=================", "onNext");
        onSuccess(t);
    }

    @Override
    public void onError(Throwable t) {
        Log.e("=================", t.getMessage());
        String code = "-1";
        String message = t.getMessage();
        if (t instanceof HttpException) {
            // http错误
            Log.e("=================", "http错误");
        } else if (t instanceof ConnectException || t instanceof UnknownHostException) {
            // 连接错误
            Log.e("=================", "连接错误");
            message = "网络连接错误";
        } else if (t instanceof InterruptedIOException) {
            // 连接超时
            Log.e("=================", "连接超时");
            message = "网络连接超时";
        } else if (t instanceof JsonParseException || t instanceof JSONException || t instanceof ParseException) {
            // 解析错误
            Log.e("=================", "解析错误");
            message = "json解析错误";
        } else if (t instanceof ServerException) {
            // 服务器错误
            Log.e("=================", "服务器错误");
            ServerException s = (ServerException) t;
            code = s.getCode();
            message = s.getMessage();
        } else {
            // 未知错误
            Log.e("=================", "未知错误");
            message = "未知错误";
        }
        Log.e("=================", "onError");
        onFailed(code, message);
    }

    @Override
    public void onComplete() {
        Log.e("=================", "onComplete");
    }

    public void onFailed(String code, String message) {
        // 错误提示
        ToastManager.showShortToast(message);
    }

    protected abstract void onSuccess(T bean);
}
