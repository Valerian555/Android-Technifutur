package com.technipixl.tabletdev

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.technipixl.tabletdev.databinding.ItemCellBinding

class VersionAdapter(private val versions: MutableList<Version>,
                     private val onItemClick: (Version) -> Unit)
    : RecyclerView.Adapter<VersionViewHolder>() {
    private lateinit var binding: ItemCellBinding

    //responsable de la création de chaque cellule dans la recyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VersionViewHolder {
        return VersionViewHolder(
            ItemCellBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onItemClick
        )
    }

    override fun onBindViewHolder(holder: VersionViewHolder, position: Int) {
        holder.setup(versions[position])
    }

    //retourne le nbr d'élément à afficher
    override fun getItemCount(): Int {
        return versions.size
    }
}