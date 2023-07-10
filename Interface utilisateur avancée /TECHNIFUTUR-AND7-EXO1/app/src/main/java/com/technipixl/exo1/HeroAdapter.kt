package com.technipixl.exo1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.technipixl.exo1.databinding.CellLayoutBinding

//En charge de gérer l'ensemble des cellules
class HeroAdapter(private var heroes: MutableList<Heroes>)
    :RecyclerView.Adapter<HeroViewHolder>() {
    private lateinit var binding: CellLayoutBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HeroViewHolder {
        //charge le layout de la cellule
        binding = CellLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return HeroViewHolder(binding)
    }


    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.bind(heroes[position])
    }

    //retourne le nbr d'élément à afficher
    override fun getItemCount(): Int {
        return heroes.size
    }
}