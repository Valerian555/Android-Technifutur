package com.technipixl.exoonetomany.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.technipixl.exoonetomany.model.Author
import kotlinx.coroutines.flow.Flow

@Dao
interface AuthorDao {
    @Query("SELECT * FROM Author")
    fun getAllAuthors(): Flow<List<Author>>
    @Insert
    suspend fun insert(author: Author)
}