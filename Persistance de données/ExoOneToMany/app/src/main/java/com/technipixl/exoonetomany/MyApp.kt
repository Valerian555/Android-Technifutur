package com.technipixl.exoonetomany

import android.app.Application
import androidx.room.Room
import com.technipixl.exoonetomany.database.AuthorDatabase

class MyApp: Application() {

    companion object {
        lateinit var database: AuthorDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, AuthorDatabase::class.java, "my-database")
            .build()
    }
}
