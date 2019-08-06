

package com.leifeng.android.model

import com.leifeng.base.module.base.activity.BaseActivity
import com.leifeng.base.module.glide.ImageLoader
import kotlinx.android.synthetic.main.activity_image_list.*

class ImageActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_image_list
    }

    override fun initView() {
       ImageLoader.loadImageView("https://p.ssl.qhimg.com/dmfd/210_259_/t01cabe2d0967540783.jpg",mImageView)

    }

    override fun initListener() {
    }

    override fun processingLogic() {
    }


}
