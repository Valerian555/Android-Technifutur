package com.technipixl.exoonetomany.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.technipixl.exoonetomany.model.AuthorWithBooks
import com.technipixl.exoonetomany.model.Book
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {
    @Query("SELECT * FROM book")
    fun getAllBooks(): Flow<List<Book>>

    @Insert
    suspend fun insert(book: Book)


}