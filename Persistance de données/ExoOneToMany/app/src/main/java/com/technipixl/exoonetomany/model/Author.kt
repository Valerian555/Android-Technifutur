package com.technipixl.exoonetomany.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
data class Author(
    @PrimaryKey(autoGenerate = true)
    val authorId: Long = 0,
    val name: String
)



