package com.technipixl.exoonetomany.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.technipixl.exoonetomany.model.AuthorWithBooks

@Dao
interface AuthorWithBooksDao {
    @Transaction
    @Query("SELECT * FROM author")
    fun getAuthorWithBooks(): List<AuthorWithBooks>
}