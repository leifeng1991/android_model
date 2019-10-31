package com.leifeng.android.model.list

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.util.DiffUtil
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.leifeng.android.model.R
import com.leifeng.android.model.databinding.User
import kotlinx.android.synthetic.main.activity_test_recyler_view.*

class TestRecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_recyler_view)
        val mRecyclerView = findViewById<RecyclerView>(R.id.mRecyclerView)
        mRecyclerView.layoutManager = LinearLayoutManager(baseContext)
        mRecyclerView.itemAnimator = null
        val list = ArrayList<User>()
        val newList = ArrayList<User>()
        for (i in 1..100) {
            val user = User("第" + i + "条", "密码$i")
            list.add(user)
            newList.add(user)
        }
        val mTestRecyclerAdapter = TestRecyclerAdapter(this, list)
        mRecyclerView.adapter = mTestRecyclerAdapter

        mUpDateButton.setOnClickListener {
            val user = User("我是新增的", "密码新增的")
            list[1] = user
//            newList[1].name = "我的名字变化了"
//            list.removeAt(1)
            mTestRecyclerAdapter.updateList(list)
        }
    }
}
