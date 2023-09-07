package com.technipixl.exo4.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.technipixl.exo4.models.Genre


//3.1 Méthode pour la table Genre
@Dao
interface GenreDao {
    //Permet de rechercher un genre dans la db en utilisant son identifiant genreId
    @Query("SELECT * FROM genre WHERE genreId = :genreId LIMIT 1")
    fun findById(genreId: Long): LiveData<Genre>

    //Permet d'insérer un nouvel objet Genre dans la base de données
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(genre: Genre)

    //Permet de récupérer tous les genres de la db. Elle renvoie une liste d'objets Genre
    @Query("SELECT * FROM genre")
    fun getAll(): LiveData<List<Genre>>

    ////Permet de récupérer tous les genres de la db. Elle renvoie une liste d'objets Genre
    @Query("SELECT * FROM genre")
    suspend fun getAllGenre(): List<Genre>
}