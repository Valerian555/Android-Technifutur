package com.technipixl.exoonetomany.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.technipixl.exoonetomany.dao.AuthorDao
import com.technipixl.exoonetomany.dao.AuthorWithBooksDao
import com.technipixl.exoonetomany.dao.BookDao
import com.technipixl.exoonetomany.model.Author
import com.technipixl.exoonetomany.model.AuthorWithBooks
import com.technipixl.exoonetomany.model.Book

@Database(entities = [Author::class, Book::class], version = 1)
 abstract class AuthorDatabase: RoomDatabase() {
  abstract fun authorDao(): AuthorDao
  abstract fun bookDao(): BookDao
}