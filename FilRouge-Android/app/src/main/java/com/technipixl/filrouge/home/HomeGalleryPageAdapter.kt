package com.technipixl.filrouge

import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomeGalleryPageAdapter (activity: FragmentActivity): FragmentStateAdapter(activity) {
    private val fragments = mutableListOf<Fragment>()

    //Création des fragments et ajouter à la liste fragments en utilisant différentes images
    init {
        fragments.add(HomeImageFragment(R.drawable.wolf.toDrawable(), "dddd"))
        fragments.add(HomeImageFragment(R.drawable.`fun`.toDrawable(), "dddfddd"))
        fragments.add(HomeImageFragment(R.drawable.run.toDrawable(), "dddfddd"))
    }

    //permet de savoir le nbr d'élément à affichr
    override fun getItemCount(): Int {
        return fragments.size
    }

    //créer le fragment à la position spécifiée dans le ViewPager.
    //Renvoie le fragment correspondant à cette position dans la liste fragments.
    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}