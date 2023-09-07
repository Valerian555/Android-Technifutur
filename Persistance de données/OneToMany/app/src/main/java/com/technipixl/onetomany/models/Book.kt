package com.technipixl.onetomany.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Book(
    @PrimaryKey(autoGenerate = true)
    var bookId: Long = 0,
    var name: String,
    var authorOfBookId: Long
)
