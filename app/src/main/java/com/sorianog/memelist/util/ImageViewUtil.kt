package com.sorianog.memelist.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sorianog.memelist.R
import java.net.URI

fun ImageView.loadImage(uri: String?) {
    val options = RequestOptions()
        .placeholder(R.drawable.ic_image_placeholder)
        .centerCrop()
        .error(R.drawable.ic_broken_image_black_24dp)

    Glide.with(this.context)
        .setDefaultRequestOptions(options)
        .load(uri)
        .into(this)
}