package com.tbahlai.tumblrgallery.uikit.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.tbahlai.tumblrgallery.R

fun ImageView.loadFromUrl(
    url: String,
    capacity: Float = 0.8F,
    sizeMultiplier: Float = 0.8F,
) {
    Glide.with(context)
        .load(url)
        .error(R.drawable.ic_broken_image)
        .placeholder(R.drawable.ic_stub_image)
        .transition(DrawableTransitionOptions.withCrossFade())
        .sizeMultiplier(sizeMultiplier)
        .thumbnail(capacity)
        .into(this)
}