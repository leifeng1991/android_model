package com.cnlive.module.base.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.ViewGroup

/**
 * 描述:适用于页面比较少，会把每一个Fragment保存在内存中，不用重新创建，所以用户体验比较好
 *
 * @author zhangrq
 *         2018/9/5 17:15
 */
class BaseFragmentPagerAdapter(fm: FragmentManager, private val fragmentList: List<Fragment>?) : FragmentPagerAdapter(fm) {
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
