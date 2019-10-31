package com.leifeng.android.base.mvvm.model.net;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

class BaseConvertBeanSchedulers {
    static <T> ObservableTransformer<RequestResultBean<T>, RequestResultBean<T>> compose() {
        return new ObservableTransformer<RequestResultBean<T>, RequestResultBean<T>>() {
            @Override
            public ObservableSource<RequestResultBean<T>> apply(Observable<RequestResultBean<T>> upstream) {
                return upstream.subscribeOn(Schedulers.io()).flatMap(new Function<RequestResultBean<T>, ObservableSource<RequestResultBean<T>>>() {
                    @Override
                    public ObservableSource<RequestResultBean<T>> apply(RequestResultBean<T> tRequestResultBean) throws Exception {
                        // 200成功
                        if (!"200".equals(tRequestResultBean.getCode()))
                            return Observable.error(new ServerException(tRequestResultBean.getCode(), tRequestResultBean.getMessage()));
                        // 其余失败
                        return Observable.just(tRequestResultBean);
                    }
                }).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
