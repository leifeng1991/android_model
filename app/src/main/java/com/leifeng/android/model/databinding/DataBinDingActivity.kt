

package com.leifeng.android.model.databinding

import android.databinding.*
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.cnlive.module.base.utils.ToastManager
import com.leifeng.android.model.R
import com.leifeng.android.model.context.ContextProvider
import com.leifeng.android.model.lifecycle.MyObserver
import java.util.concurrent.atomic.AtomicBoolean

class DataBinDingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mDataBinding = DataBindingUtil.setContentView<ActivityDatabindingBinding>(this, R.layout.activity_databinding)
//        ImageLoader.loadImageView("http://pic26.nipic.com/20121221/9252150_142515375000_2.jpg", mDataBinding.mImageView)
//        GlideApp.with(this).load("http://pic26.nipic.com/20121221/9252150_142515375000_2.jpg").error(R.mipmap.ic_launcher).into(mDataBinding.mImageView)
        mDataBinding.mLoginButton.setOnClickListener {
            /****************************************************/

//            val user = User("张三","000000")
//            user.imageUrl = "http://pic26.nipic.com/20121221/9252150_142515375000_2.jpg"
            /**********************************************************/
//            val user = ObservableArrayMap<String,String>()
//            user["imageUrl"] = "http://pic26.nipic.com/20121221/9252150_142515375000_2.jpg"
//            user["name"] = "小明"
//            user["password"] = "000000"
            /****************************************************/
            val user = ObservableArrayList<String>()
            user.add("http://pic26.nipic.com/20121221/9252150_142515375000_2.jpg")
            user.add("我的名字叫张三")
            mDataBinding.user = user
        }

        if (null == ContextProvider.get().context){
            ToastManager.showShortToast("0")
        }else{
            ToastManager.showShortToast("1")
        }

        AtomicBoolean(false)

    }

}
