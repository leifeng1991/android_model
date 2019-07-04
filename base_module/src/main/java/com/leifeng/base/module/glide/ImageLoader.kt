package com.leifeng.base.module.glide

import android.graphics.Bitmap
import android.widget.ImageView
import com.bumptech.glide.load.Transformation
import jp.wasabeef.glide.transformations.CropCircleTransformation

object ImageLoader {

    /**
     * 加载网络图片
     * @param imageUrl  网络图片地址
     * @param imageView 目标view
     */
    @JvmStatic
    @JvmOverloads
    fun loadImageView(imageUrl: String?, imageView: ImageView?, defaultImageRes: Int = -1) {
        loadOriginalImageView(imageUrl, imageView, defaultImageRes)

    }

    /**
     * 加载网络圆形图片
     * @param imageUrl  网络图片地址
     * @param imageView 目标view
     */
    @JvmStatic
    @JvmOverloads
    fun loadCircleImageView(imageUrl: String?, imageView: ImageView?, defaultImageRes: Int = -1) {
        loadOriginalImageView(imageUrl, imageView, defaultImageRes, false, CropCircleTransformation())
    }

    /**
     * 加载gif网络图片
     * @param imageUrl  网络图片地址
     * @param imageView 目标view
     */
    @JvmStatic
    @JvmOverloads
    fun loadGifImageView(imageUrl: String?, imageView: ImageView?, defaultImageRes: Int = -1) {
        loadOriginalImageView(imageUrl, imageView, defaultImageRes, true)
    }

    /**
     * 加载gif网络图片
     * @param any             图片地址
     * @param imageView       目标view
     * @param defaultImageRes 默认图片
     * @param isGif           是否gif图
     * @param transformation  对图片进行转换（圆形、模糊等）
     */
    @JvmStatic
    @JvmOverloads
    private fun loadOriginalImageView(any: Any?, imageView: ImageView?, defaultImageRes: Int = -1, isGif: Boolean = false, transformation: Transformation<Bitmap>? = null) {
        if (imageView == null || imageView.context == null) return
        val request = GlideApp.with(imageView.context)
        request.apply {
            if (isGif)
            // 设置gif图
                asGif()
            load(any).apply {
                val isHasDefaultImage = defaultImageRes != -1 && defaultImageRes != 0
                if (isHasDefaultImage) {
                    // 设置占位图
                    placeholder(defaultImageRes)
                }
                if (isHasDefaultImage) {
                    // 设置加载错误时显示的图片
                    error(defaultImageRes)
                }
                if (isHasDefaultImage) {
                    //
                    fallback(defaultImageRes)
                }
                if (transformation != null)
                    transform(transformation)
                into(imageView)
            }
        }

    }
}