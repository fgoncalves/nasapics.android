package com.github.fgoncalves.foundation.commons

import android.graphics.drawable.ColorDrawable
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("url")
fun ImageView.loadUrl(
    url: String?,
) {
    if (url.isNullOrBlank()) {
        setImageDrawable(null)
        return
    }

    Picasso.get()
        .load(url)
        .placeholder(ColorDrawable(ContextCompat.getColor(context, R.color.placeholder)))
        .into(this)
}
