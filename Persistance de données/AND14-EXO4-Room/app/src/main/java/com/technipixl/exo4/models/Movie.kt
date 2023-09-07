package com.technipixl.exo4.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//2 Créer les modèles qui serviront de table dans la base de données Room

//2.1 Modèle Movie
@Entity
data class Movie(
    @PrimaryKey(autoGenerate = true)
    val movieId: Long = 0,
    val movieTitle: String? = null,
    val movieDirector: String? = null,
    val movieDuration: Int? = null,
    val movieSummary: String? = null
)

