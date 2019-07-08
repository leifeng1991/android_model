package com.cnlive.module.base.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.ViewGroup

/**
 * 描述:适用于页面比较多，销毁以前的Fragment以释放内存
 *
 * @author zhangrq
 *         2018/9/5 17:15
 */
open class BaseFragmentStatePagerAdapter(fm: FragmentManager, private var fragmentList: List<Fragment>?) : FragmentStatePagerAdapter(fm) {
    private var titleList: List<String>? = null

    constructor(fm: FragmentManager, fragments: List<Fragment>?, titleList: List<String>?) : this(fm, fragments) {
        this.titleList = titleList
    }

    override fun getItem(position: Int): Fragment? {
        return fragmentList?.get(position)
    }

    override fun getCount(): Int {
        return fragmentList?.size ?: 0
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return if (titleList != null && position < titleList!!.size) titleList!![position] else null
    }

    override fun finishUpdate(container: ViewGroup) {
        try {
            super.finishUpdate(container)
        } catch (e: NullPointerException) {
            e.printStackTrace()
        }
    }

}
