package com.leifeng.android.model

import android.support.design.widget.AppBarLayout
import android.support.design.widget.CoordinatorLayout
import android.support.v4.app.Fragment
import com.cnlive.module.base.ui.adapter.BaseFragmentPagerAdapter
import com.cnlive.module.base.utils.LogUtil
import com.leifeng.base.module.base.activity.BaseActivity
import com.leifeng.base.module.util.PixelUtil
import com.scwang.smartrefresh.layout.api.RefreshLayout
import kotlinx.android.synthetic.main.activity_test_foods_home.*

class TestFoodsHomeActivity : BaseActivity() {
    private lateinit var mAppBarLayout: AppBarLayout

    override fun getLayoutId(): Int {
        return R.layout.activity_test_foods_home
    }

    override fun initView() {
        mAppBarLayout = findViewById(R.id.mAppBarLayout)
//        mAppBarLayout.setExpanded(false)
      /*  mAppBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            LogUtil.e("=================verticalOffset$verticalOffset=====${appBarLayout.totalScrollRange}")
            val lp = mConstraintLayout.layoutParams as CoordinatorLayout.LayoutParams
            lp.setMargins(0,verticalOffset,0,0)
            mConstraintLayout.layoutParams = lp
        })*/
        (mSmartRefreshLayout as RefreshLayout).setHeaderInsetStart(500f)
        (mSmartRefreshLayout as RefreshLayout).setEnableRefresh(false)
        (mSmartRefreshLayout as RefreshLayout).setEnableLoadMore(false)
        (mSmartRefreshLayout as RefreshLayout).setEnableOverScrollBounce(true)
        (mSmartRefreshLayout as RefreshLayout).setEnableOverScrollDrag(true)
        val fragments = ArrayList<Fragment>()
        fragments.add(TestFoodsHomeFragment())
        fragments.add(TestFoodsHomeFragment())
        fragments.add(TestFoodsHomeFragment())
        val titles = ArrayList<String>()
        titles.add("一")
        titles.add("二")
        titles.add("三")

        val adapter = BaseFragmentPagerAdapter(supportFragmentManager, fragments, titles)
        mViewPager.adapter = adapter
        mTabLayout.setupWithViewPager(mViewPager)

    }

    override fun initListener() {
        /* mViewPager.layoutManager = LinearLayoutManager(applicationContext)
         val adapter = TestAdapter(R.layout.item_test, null)
         mViewPager.adapter = adapter

         val list = ArrayList<String>()
         for (i in 1..100) {
             list.add("")
         }
         adapter.replaceData(list)

         var y = 0
         mViewPager.addOnScrollListener(object : RecyclerView.OnScrollListener() {
             override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                 y += dy
                 LogUtil.e("=================onScrolled====$dy===$y===${y+ PixelUtil.dip2px
                 (applicationContext,290f)}")
                *//* val lp1 = mCollapsingToolbarLayout.layoutParams as AppBarLayout.LayoutParams
                lp1.setMargins(0,-y - PixelUtil.dip2px(applicationContext,290f),0,0)
                mCollapsingToolbarLayout.layoutParams = lp1*//*

//                mCollapsingToolbarLayout.top = -y - PixelUtil.dip2px(applicationContext,290f)

                val lp = mConstraintLayout.layoutParams as CoordinatorLayout.LayoutParams
                lp.setMargins(0,-y ,0,0)
                mConstraintLayout.layoutParams = lp
                val cha = PixelUtil.dip2px(applicationContext, 210f) - y
                var minHeight =  if (cha > PixelUtil.dip2px(applicationContext, 50f)) cha else
                    PixelUtil.dip2px(applicationContext, 50f)
                mCollapsingToolbarLayout.minimumHeight =  minHeight

                super.onScrolled(recyclerView, dx, dy)
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                LogUtil.e("=================onScrollStateChanged")
                super.onScrollStateChanged(recyclerView, newState)
            }
        })*/
    }

    override fun processingLogic() {
    }


}
