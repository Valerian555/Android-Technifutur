package com.technipixl.exo5

import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

//Fournis les fragments à afficher dans le viewPager
class GalleryPagerAdapter (activity: FragmentActivity): FragmentStateAdapter(activity) {
    private val fragments = mutableListOf<Fragment>()

    //Création des fragments et ajouter à la liste fragments en utilisant différentes images
    init {
        val resources = activity.resources
        val theme = activity.theme
        fragments.add(FirstFragment(ResourcesCompat.getDrawable(resources, R.drawable.pic1, theme)))
        fragments.add(FirstFragment(ResourcesCompat.getDrawable(resources, R.drawable.pic2, theme)))
        fragments.add(FirstFragment(ResourcesCompat.getDrawable(resources, R.drawable.pic3, theme)))
        fragments.add(FirstFragment(ResourcesCompat.getDrawable(resources, R.drawable.pic4, theme)))
        fragments.add(FirstFragment(ResourcesCompat.getDrawable(resources, R.drawable.pic5, theme)))
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