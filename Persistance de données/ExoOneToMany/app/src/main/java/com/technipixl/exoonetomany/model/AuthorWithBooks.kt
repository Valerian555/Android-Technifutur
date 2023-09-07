package com.technipixl.exoonetomany.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

data class AuthorWithBooks(
    @Embedded val author: Author,
    @Relation(
        parentColumn = "AuthorId" ,
        entityColumn = "AuthorOfBookId"
    )
    val books: List<Book>
)
