

package com.leifeng.android.model

import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import com.cnlive.module.base.ui.adapter.BaseFragmentPagerAdapter
import com.leifeng.base.module.base.activity.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        val fragments = ArrayList<Fragment>()
        fragments.add(TestFragment())
        fragments.add(TestFragment())
        fragments.add(TestFragment())
        val titles = ArrayList<String>()
        titles.add("一")
        titles.add("二")
        titles.add("三")

        val adapter = BaseFragmentPagerAdapter(supportFragmentManager,fragments,titles)
        mViewPager.adapter = adapter
        mTabLayout.setupWithViewPager(mViewPager)

    }

    override fun initListener() {
    }

    override fun processingLogic() {
    }


}
