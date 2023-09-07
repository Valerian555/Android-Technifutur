package com.technipixl.onetomany.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.technipixl.onetomany.models.Author
import com.technipixl.onetomany.models.AuthorWithBooks
import kotlinx.coroutines.flow.Flow

@Dao
interface AuthorDao {
    @Query("SELECT * FROM author WHERE authorId = :authorId LIMIT 1")
    fun findById(authorId: Long): Flow<Author>

    @Insert
    suspend fun insert(author: Author): Long

    @Query("SELECT * FROM author")
    fun getAll(): Flow<List<Author>>

    @Query("DELETE FROM author WHERE authorId = :authorId")
    suspend fun deleteAuthor(authorId: Long)

    @Transaction
    @Query("SELECT * FROM author WHERE authorId = :authorId")
    fun getAuthorsWithBooksById(authorId: Long): AuthorWithBooks

    @Transaction
    @Query("SELECT * FROM author")
    fun getAuthorsWithBooks(): List<AuthorWithBooks>

}