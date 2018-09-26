package com.sample.androidsvgglideexample

import android.graphics.drawable.Drawable
import android.util.Log
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException

import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

class Listener : RequestListener<Drawable> {

    companion object {
        const val TAG = "SvgListener"
    }

    override fun onResourceReady(resource: Drawable, model: Any, target: Target<Drawable>, dataSource: DataSource, isFirstResource: Boolean): Boolean {
        Log.d( TAG, "onResourceReady" )
        return false
    }

    override fun onLoadFailed(e: GlideException?, model: Any, target: Target<Drawable>, isFirstResource: Boolean): Boolean {
        Log.e( TAG, "onException", e )
        e?.logRootCauses( TAG )
        return false
    }
}