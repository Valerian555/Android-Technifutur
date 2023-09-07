package com.technipixl.onetomany.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Author(
    @PrimaryKey(autoGenerate = true)
    var authorId: Long = 0,
    var name: String
)
