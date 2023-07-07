package com.technipixl.exobonus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.technipixl.exobonus.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        //Gérer la visibilité de la flèche
        val appBarConfiguration: AppBarConfiguration?
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.gamesFragment,
                R.id.moviesFragment
            )
        )


        val bottomNavigationView = binding.bottomNavigationView
        val navController = findNavController(R.id.navHostFragment)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)

        val toolbar = binding.toolbarContainer
        setSupportActionBar(toolbar)
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)


        //changement du texte de la toolbar en fonction du fragment
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when(destination.id){
                R.id.moviesFragment -> binding.toolbarTitle.text = "Movies"
                R.id.gamesFragment -> binding.toolbarTitle.text = "Games"
                R.id.listGamesFragment -> binding.toolbarTitle.text = "Categories"
                R.id.listMoviesFragment -> binding.toolbarTitle.text = "Categories"
                R.id.descriptionFragment -> binding.toolbarTitle.text = "Details"
                else -> binding.toolbarTitle.text = null
            }
        }
    }

    //gérer la flèche retour dans la toolbar
    override fun onSupportNavigateUp(): Boolean {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val  navController = navHostFragment.navController
        return navController.navigateUp()
    }
    }
