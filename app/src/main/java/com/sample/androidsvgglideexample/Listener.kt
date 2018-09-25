package com.sample.androidsvgglideexample

import android.graphics.drawable.PictureDrawable
import android.util.Log

import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

/**
 * @param <T> not used, here to prevent unchecked warnings at usage
</T> */
class Listener<T> : RequestListener<T, PictureDrawable> {

    companion object {
        const val TAG = "SvgListener"
    }

    override fun onException(e: Exception, model: T, target: Target<PictureDrawable>, isFirstResource: Boolean): Boolean {
        Log.e( TAG, "onException", e )
        return false
    }

    override fun onResourceReady(resource: PictureDrawable, model: T, target: Target<PictureDrawable>,
                                 isFromMemoryCache: Boolean, isFirstResource: Boolean): Boolean {
        Log.e( TAG, "onResourceReady" )
        return false
    }
}