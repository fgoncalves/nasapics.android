package com.github.fgoncalves.foundation.commons

import android.graphics.drawable.ColorDrawable
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull

@BindingAdapter("url")
fun ImageView.loadUrl(
    url: String?,
) {
    if (url.isNullOrBlank()) {
        setImageDrawable(null)
        return
    }

    val httpsUrl = url.forceHttps()

    if (httpsUrl == null) {
        setImageDrawable(null)
        return
    }

    Picasso.get()
        .load(httpsUrl)
        .placeholder(ColorDrawable(ContextCompat.getColor(context, R.color.placeholder)))
        .into(this)
}

private fun String.forceHttps() =
    toHttpUrlOrNull()?.newBuilder()
        ?.scheme("https")
        ?.build()
        ?.toString()
