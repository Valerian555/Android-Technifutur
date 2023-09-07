package com.technipixl.exo4.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.technipixl.exo4.dao.GenreDao
import com.technipixl.exo4.dao.MovieDao
import com.technipixl.exo4.dao.MovieGenreDao
import com.technipixl.exo4.models.Genre
import com.technipixl.exo4.models.Movie
import com.technipixl.exo4.models.MovieGenre


/* 4. Définis votre base de données Room, indique quelles entités (tables)
elle comprend et fournit des méthodes pour obtenir les DAO associés à ces
entités.*/
@Database(entities = [Movie::class, Genre::class, MovieGenre::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun genreDao(): GenreDao
    abstract fun movieGenreDao(): MovieGenreDao
}