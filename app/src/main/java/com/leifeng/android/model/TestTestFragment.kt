package com.leifeng.android.model

import android.support.v7.widget.LinearLayoutManager
import com.leifeng.base.module.base.fragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_test.*

class TestTestFragment : BaseFragment() {

    override fun getLayoutId(): Int {
        return R.layout.fragment_test
    }

    override fun initView() {
        mRecyclerView.layoutManager = LinearLayoutManager(activity!!.applicationContext)
        val adapter = TestAdapter(R.layout.item_test,null)
        mRecyclerView.adapter = adapter
        adapter.addHeaderView(layoutInflater.inflate(R.layout.layout_header,null))

        val list = ArrayList<String>()
        for(i in 1..100){
            list.add("")
        }
        adapter.replaceData(list)
    }

    override fun initListener() {

    }

    override fun processingLogic() {

    }
}
