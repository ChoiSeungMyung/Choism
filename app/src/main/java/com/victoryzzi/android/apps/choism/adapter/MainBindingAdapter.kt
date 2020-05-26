package com.victoryzzi.android.apps.choism.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("bind_image")
fun bindImage(view: ImageView, url: String?) {
    url?.let{
        Glide.with(view)
            .load(url)
            .into(view)
    }
}
