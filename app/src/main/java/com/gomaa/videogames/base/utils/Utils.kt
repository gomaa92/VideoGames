package com.gomaa.videogames.base.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

class Utils {
    companion object {
        fun loadImage(context: Context, imageView: ImageView?, imageUlr: String?) {
            if (imageView != null)
                Glide.with(context).load(imageUlr).into(imageView)

        }
    }
}