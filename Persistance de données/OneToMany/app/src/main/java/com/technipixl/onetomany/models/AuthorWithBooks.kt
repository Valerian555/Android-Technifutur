package com.technipixl.onetomany.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation


data class AuthorWithBooks(
    @Embedded val author: Author,
    @Relation(
        parentColumn = "authorId",
        entityColumn = "authorOfBookId"
    )
    val books: List<Book>
)
