package com.sample.androidsvgglideexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.extensions.CacheImplementation
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.extensions.ContainerOptions

@ContainerOptions(cache = CacheImplementation.SPARSE_ARRAY)
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlideApp.with(this)
                .load("https://upload.wikimedia.org/wikipedia/sco/7/71/Pringles.svg" )
                .listener( Listener() )
                .placeholder(android.R.drawable.picture_frame)
                .error(android.R.drawable.dialog_frame)
                .into(imageView)

        // https://upload.wikimedia.org/wikipedia/commons/3/35/Tux.svg fails with
        // Invalid Layer Save Flag - only ALL_SAVE_FLAGS is allowed
        // https://github.com/BigBadaboom/androidsvg/issues/148
        // https://github.com/BigBadaboom/androidsvg/pull/144/commits/7819808598060bb0590e02ff5730e5ecbf7e1266
    }
}
