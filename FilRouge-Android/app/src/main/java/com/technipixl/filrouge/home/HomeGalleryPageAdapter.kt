package com.technipixl.filrouge.home

import android.content.Context
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.technipixl.filrouge.R

class HomeGalleryPageAdapter (private val context: Context,
                              fragmentManager: FragmentManager,
                              behavior: Int,
                              private val fragments: MutableList<Fragment>): FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    //Création des fragments et ajouter à la liste fragments en utilisant différentes images
    init {
        fragments.add(HomeImageFragment(R.drawable.wolf, "J'ai une faim de loup!"))
        fragments.add(HomeImageFragment(R.drawable.`fun`, "J'ai besoin de rire!"))
        fragments.add(HomeImageFragment(R.drawable.run, "Il faut que je bouge!"))
    }

    //permet de savoir le nbr d'élément à affichr
    override fun getCount(): Int {
        return fragments.size
    }

    //créer le fragment à la position spécifiée dans le ViewPager.
    //Renvoie le fragment correspondant à cette position dans la liste fragments.
    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }
}