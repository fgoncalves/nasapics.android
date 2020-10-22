package com.github.fgoncalves.features.rover

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.fgoncalves.features.rover.databinding.RoverPhotoListItemBinding
import com.github.fgoncalves.features.rover.domain.entities.RoverPhoto

class RoverPhotosAdapter : RecyclerView.Adapter<RoverPhotosAdapter.ViewHolder>() {
    var data: List<RoverPhoto> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            RoverPhotoListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class ViewHolder(
        private val binding: RoverPhotoListItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RoverPhoto) {
            binding.url = item.imageUrl
        }
    }
}
