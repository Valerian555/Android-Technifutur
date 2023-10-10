package com.technipixl.tabletdev

import androidx.recyclerview.widget.RecyclerView
import com.technipixl.tabletdev.databinding.ItemCellBinding

class VersionViewHolder(private var binding: ItemCellBinding,
                        private val onItemClick: (Version) -> Unit) :
    RecyclerView.ViewHolder(binding.root) {

    fun setup(version: Version) {
        binding.versionName.text = version.name

        binding.container.setOnClickListener {
            onItemClick(version)
        }
    }
}