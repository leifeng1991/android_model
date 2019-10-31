package com.leifeng.android.base.mvvm.model

import android.arch.lifecycle.Observer
import android.os.Bundle
import com.bumptech.glide.Glide
import com.leifeng.android.base.mvvm.model.base.BaseActivity
import com.leifeng.android.base.mvvm.model.base.BaseViewModelFactory
import com.leifeng.android.base.mvvm.model.databinding.ActivityMainBinding
import com.leifeng.android.base.mvvm.model.util.LogUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<ActivityMainBinding, MyViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun initViewModel(): MyViewModel {
        return BaseViewModelFactory.getInstance(application).createViewModel(this,MyViewModel::class.java)
    }

    override fun initListener() {
        mViewModel?.getDynamicList()?.observe(this, Observer<DynamicDataBean> {
            LogUtil.e("====================")
        })

    }

    override fun processingLogic() {
        Glide.with(baseContext).load("http://pic26.nipic.com/20121221/9252150_142515375000_2.jpg").into(mImageView)
        mViewModel?.getNetData()
    }
}
