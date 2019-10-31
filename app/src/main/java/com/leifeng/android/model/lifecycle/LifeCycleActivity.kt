package com.leifeng.android.model.lifecycle

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.leifeng.android.model.R

class LifeCycleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
        lifecycle.addObserver(MyObserver())
    }

}
