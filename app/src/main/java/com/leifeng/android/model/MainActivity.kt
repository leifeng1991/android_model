

package com.leifeng.android.model

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.leifeng.base.module.glide.ImageLoader
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ImageLoader.loadCircleImageView("http://p0.so.qhimgs1.com/sdr/400__/t012a87acbc1b1389ac.jpg",mImageView)
    }
}
