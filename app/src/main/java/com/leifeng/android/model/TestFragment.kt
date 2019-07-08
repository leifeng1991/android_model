package com.leifeng.android.model

import android.support.v4.app.Fragment
import com.cnlive.module.base.ui.adapter.BaseFragmentPagerAdapter
import com.leifeng.base.module.base.fragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_test_test.*

class TestFragment : BaseFragment() {

    override fun getLayoutId(): Int {
        return R.layout.fragment_test_test
    }

    override fun initView() {
        val fragments = ArrayList<Fragment>()
        fragments.add(TestTestFragment())
        fragments.add(TestTestFragment())
        fragments.add(TestTestFragment())
        val titles = ArrayList<String>()
        titles.add("一")
        titles.add("二")
        titles.add("三")

        val adapter = BaseFragmentPagerAdapter(childFragmentManager,fragments,titles)
        mViewPager.adapter = adapter
        mTabLayout.setupWithViewPager(mViewPager)
    }

    override fun initListener() {

    }

    override fun processingLogic() {

    }
}
