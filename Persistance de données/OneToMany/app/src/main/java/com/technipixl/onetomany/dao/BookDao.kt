package com.technipixl.onetomany.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.technipixl.onetomany.models.Author
import com.technipixl.onetomany.models.Book
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {
    @Query("SELECT * FROM book WHERE bookID = :bookId LIMIT 1")
    fun findById(bookId: Long): Flow<Book>

    @Insert
    suspend fun insert(book: Book): Long

    @Query("SELECT * FROM book")
    fun getAll(): Flow<List<Book>>

    @Query("DELETE FROM book WHERE bookId = :bookId")
    suspend fun deleteBook(bookId: Long)
}