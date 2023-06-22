package com.example.youtubeparccer.core.utlis

import android.widget.ImageView

fun ImageView.loadImage(url: String){
    Glide.with(this).load(url).into(this)
}