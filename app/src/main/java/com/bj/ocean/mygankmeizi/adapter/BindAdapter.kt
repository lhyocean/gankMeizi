package com.bj.ocean.mygankmeizi.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bj.ocean.mygankmeizi.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions

/**
 * Created by ocean on 2020-05-08
 * @describe:
 */
@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        Glide.with(view.context)
            .setDefaultRequestOptions(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC))
            .load(imageUrl)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(view)
    }
}