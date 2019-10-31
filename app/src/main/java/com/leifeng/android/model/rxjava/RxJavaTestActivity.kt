package com.leifeng.android.model.rxjava

import android.annotation.SuppressLint
import com.leifeng.android.model.R
import com.leifeng.base.module.base.activity.BaseActivity
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit


class RxJavaTestActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_main_list
    }

    override fun initView() {
        create()
    }

    override fun initListener() {

    }

    override fun processingLogic() {
    }

    @SuppressLint("CheckResult")
    private fun create() {
        Observable.create(ObservableOnSubscribe<Int> {
            it.onNext(1)
            it.onNext(2)
            it.onNext(3)

        }).subscribe(object : Observer<Int> {
            override fun onComplete() {

            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: Int) {
            }

            override fun onError(e: Throwable) {
            }
        })
    }

    private fun just(){
        Observable.just(1,2,3).subscribe(object : Observer<Int>{
            override fun onComplete() {

            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: Int) {
            }

            override fun onError(e: Throwable) {
            }
        })
    }

    private fun fromArray(){
        val list = arrayOf(1,2,3)
        Observable.fromArray(*list).subscribe(object : Observer<Int>{
            override fun onComplete() {

            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: Int) {
            }

            override fun onError(e: Throwable) {
            }
        })
    }

    private fun fromIterable(){
        val list = listOf(1,2,3)
        Observable.fromIterable(list).subscribe(object : Observer<Int>{
            override fun onComplete() {

            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: Int) {
            }

            override fun onError(e: Throwable) {
            }
        })
    }

    private fun timer(){
        Observable.timer(2, TimeUnit.SECONDS).subscribe(object : Observer<Long>{
            override fun onComplete() {

            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: Long) {
            }

            override fun onError(e: Throwable) {
            }
        })
    }

    private fun interval(){
        Observable.interval(2,1, TimeUnit.SECONDS).subscribe(object : Observer<Long>{
            override fun onComplete() {

            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: Long) {
            }

            override fun onError(e: Throwable) {
            }
        })
    }

    private fun intervalRange(){
        Observable.intervalRange(2,10,2,1, TimeUnit.SECONDS).subscribe(object : Observer<Long>{
            override fun onComplete() {

            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: Long) {
            }

            override fun onError(e: Throwable) {
            }
        })
    }

    private fun range(){
        Observable.range(2,10).subscribe(object : Observer<Int>{
            override fun onComplete() {

            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: Int) {
            }

            override fun onError(e: Throwable) {
            }
        })
    }

    private fun map(){
    }
}
