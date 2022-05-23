package com.app.tugaypamuk.movieapp.common

import android.content.Context
import android.graphics.Color
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.app.tugaypamuk.movieapp.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/**
 *
 */

fun placeHolderProgressbar(context: Context) : CircularProgressDrawable{
    return CircularProgressDrawable(context).apply {
        strokeWidth = 5f
        centerRadius = 25f
        setColorSchemeColors(Color.RED,Color.YELLOW,Color.BLUE)

        start()
    }
}
fun ImageView.downloadImageFromUrl(url : String?,progressDrawable: CircularProgressDrawable){
    val options = RequestOptions()
        .placeholder(progressDrawable)
        .error(R.drawable.no_img)
    Glide
        .with(context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)
}

@BindingAdapter("downloadImageFromUrl")
fun downloadImage(view: ImageView,url: String?){
    view.downloadImageFromUrl(url, placeHolderProgressbar(view.context))
}