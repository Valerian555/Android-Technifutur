package com.technipixl.exo1

import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.technipixl.exo1.databinding.CellLayoutBinding

//En charge de l'affichage d'une cellule, s'occupe d'afficher l'ui
class HeroViewHolder(private var viewBinding: CellLayoutBinding) :
    RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(hero: Heroes) {
            viewBinding.heroName.text = hero.realName
            viewBinding.realName.text = hero.realName

            //gére le click
            itemView.setOnClickListener {
                Toast.makeText(it.context, hero.description, Toast.LENGTH_SHORT).show()
            }
        }
}