package com.sample.androidsvgglideexample

import android.graphics.drawable.PictureDrawable
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.caverock.androidsvg.SVG
import com.bumptech.glide.load.resource.file.FileToStreamDecoder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.StreamEncoder
import java.io.InputStream
import com.bumptech.glide.load.engine.DiskCacheStrategy

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>( R.id.imageView )

        val requestBuilder = Glide.with(this)
                .using(Glide.buildStreamModelLoader<Uri>(Uri::class.java, this), InputStream::class.java)
                .from(Uri::class.java)
                .`as`(SVG::class.java)
                .transcode(SvgDrawableTranscoder(), PictureDrawable::class.java)
                .sourceEncoder(StreamEncoder())
                .placeholder(android.R.drawable.picture_frame)
                .error(android.R.drawable.dialog_frame)
                .cacheDecoder(FileToStreamDecoder<SVG>(SvgDecoder()))
                .decoder(SvgDecoder())
                .listener( Listener() )


        val uri = Uri.parse( "https://upload.wikimedia.org/wikipedia/sco/7/71/Pringles.svg" )

        requestBuilder
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                // SVG cannot be serialized so it's not worth to cache it
                .load(uri)
                .into(imageView)
    }
}