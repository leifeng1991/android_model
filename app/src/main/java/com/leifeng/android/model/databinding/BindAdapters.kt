package com.leifeng.android.model.databinding

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.leifeng.android.model.MyImageView
import com.leifeng.base.module.glide.ImageLoader

object BindAdapters {

    @BindingAdapter(value = ["url","error"], requireAll = false)
    fun loadImage(imageView: ImageView, url: String) {
        ImageLoader.loadGifImageView(url, imageView)
    }

    @BindingAdapter("app:imageUrl")
    internal fun setImageUrl(imageView: ImageView, url: String) {
        ImageLoader.loadImageView(url, imageView)
    }
}
