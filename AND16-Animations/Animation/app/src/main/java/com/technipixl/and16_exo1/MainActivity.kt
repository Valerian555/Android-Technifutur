package com.technipixl.and16_exo1

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.BounceInterpolator
import com.technipixl.and16_exo1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    val animation = AnimationUtils.loadAnimation(
        this,
        R.anim.scaleanim
    ).apply {
        repeatCount = Animation.INFINITE
    }

        val animator = ObjectAnimator

        animation.interpolator = BounceInterpolator()

        binding.menuButton?.startAnimation(animation)
    }
}