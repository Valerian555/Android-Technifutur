package com.technipixl.exo4.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.technipixl.exo4.models.Movie
import com.technipixl.exo4.models.MovieGenre
import com.technipixl.exo4.models.MovieWithGenre

//3. Créer les méthodes utilisées par l'app pour intéragir avec les données de la table MovieGenre

//3.1 Méthode pour la table MovieGenre
@Dao
interface MovieDao {
    //Permet de rechercher un film dans la base de données en utilisant son id
    @Query("SELECT * FROM movie WHERE movieId = :movieId LIMIT 1")
    fun findById(movieId: Long): LiveData<Movie>

    //Permet de récupérer les films et ses genres correspondants
    @Query("SELECT * FROM movie WHERE movieId = :movieId LIMIT 1")
    fun findBookWithGenreById(movieId: Long): LiveData<MovieWithGenre>

    //Permet d'insérer un nouvel objet Movie dans la base de données
    @Insert(onConflict = OnConflictStrategy .NONE)
    suspend fun insert(movie: Movie): Long

    //Permer de récupérer tous les films de db, elle renvoie une liste
    @Query("SELECT * FROM movie")
    fun getAll(): LiveData<List<Movie>>

    //Permet de supprimer un film de la db en utilisant un objet Movie comme argument.
    @Query("DELETE FROM movie WHERE movieId = :movieId")
    suspend fun delete(movieId: Long)
}