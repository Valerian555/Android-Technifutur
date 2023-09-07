package com.technipixl.exo4

import android.app.Application
import androidx.room.Room
import com.technipixl.exo4.database.AppDatabase

class MyApp : Application() {

    //5. Créer une instance pour toute l'app (pas oublier ajouter dans manifeste)
    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, AppDatabase::class.java, "my-database")
            .build()
    }
}