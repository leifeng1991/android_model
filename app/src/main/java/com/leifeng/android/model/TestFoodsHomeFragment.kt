package com.leifeng.android.model

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.cnlive.module.base.utils.LogUtil
import com.leifeng.base.module.base.fragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_test_foods_home.*

class TestFoodsHomeFragment : BaseFragment() {

    override fun getLayoutId(): Int {
        return R.layout.fragment_test_foods_home
    }

    override fun initView() {
        mLeftRecyclerView.layoutManager = LinearLayoutManager(context!!)
        val adapter = TestAdapter(R.layout.item_test, null)
        mLeftRecyclerView.adapter = adapter

        val list = ArrayList<String>()
        for (i in 1..20) {
            list.add("")
        }
        adapter.replaceData(list)


        mRightRecyclerView.layoutManager = LinearLayoutManager(activity!!.applicationContext)
        val rightAdapter = TestAdapter(R.layout.item_test, null)
        mRightRecyclerView.adapter = rightAdapter

        val rightLists = ArrayList<String>()
        for (i in 1..100) {
            rightLists.add("")
        }
        rightAdapter.replaceData(rightLists)
    }

    override fun initListener() {
        mLeftRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                LogUtil.e("+++++++++++++++++++onScrolled()")
                super.onScrolled(recyclerView, dx, dy)
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }
        })

        mRightRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                LogUtil.e("+++++++++++++++++++onScrolled()")
                super.onScrolled(recyclerView, dx, dy)
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }
        })
    }

    override fun processingLogic() {

    }
}
