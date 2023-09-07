package com.technipixl.exo4.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.technipixl.exo4.models.MovieGenre


//3.3 Méthode pour la table MovieGenre
@Dao
interface MovieGenreDao {
    @Insert
    suspend fun insert(movie: MovieGenre)
    @Query("SELECT * FROM moviegenre")
    fun getAll(): LiveData<List<MovieGenre>>
}