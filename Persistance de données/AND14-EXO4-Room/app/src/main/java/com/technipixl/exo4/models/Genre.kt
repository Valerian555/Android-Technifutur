package com.technipixl.exo4.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//3. Modèle Genre
@Entity
data class Genre(
    @PrimaryKey(autoGenerate = true)
    val genreId: Long = 0,
    val name: String?,
)