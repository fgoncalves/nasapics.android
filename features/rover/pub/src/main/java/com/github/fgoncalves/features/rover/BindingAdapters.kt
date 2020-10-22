package com.github.fgoncalves.features.rover

import android.util.TypedValue
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.fgoncalves.features.rover.domain.entities.RoverPhoto

@BindingAdapter("photos")
fun RecyclerView.setPhotos(photos: List<RoverPhoto>?) {
    if (photos == null)
        return

    val photosAdapter = if (adapter == null)
        RoverPhotosAdapter()
    else
        adapter as RoverPhotosAdapter

    adapter = photosAdapter

    photosAdapter.data = photos
}

@BindingAdapter("itemMargin")
fun RecyclerView.setPhotos(margin: Int) {
    val px = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        margin.toFloat(),
        resources.displayMetrics
    )

    addItemDecoration(MarginDecorator(px.toInt()))
}
