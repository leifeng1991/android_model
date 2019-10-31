package com.leifeng.android.model

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.leifeng.base.module.base.activity.BaseActivity

class MainListActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_main_list
    }

    override fun initView() {
//        ImageLoader.loadImageView("MainListActivity",mImageView)
        val mImageView = findViewById<ImageView>(R.id.mImageView)
        Glide.with(baseContext).load("http://pic26.nipic.com/20121221/9252150_142515375000_2.jpg").error(R.mipmap.ic_launcher).into(mImageView)
    }

    override fun initListener() {
//        mRxJavaButton.setOnClickListener {
//            startActivity(Intent(applicationContext,RxJavaTestActivity::class.java))
//        }
    }

    override fun processingLogic() {
    }


}
