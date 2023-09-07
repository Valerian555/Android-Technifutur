package com.technipixl.onetomany.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.technipixl.onetomany.dao.AuthorDao
import com.technipixl.onetomany.dao.BookDao
import com.technipixl.onetomany.models.Author
import com.technipixl.onetomany.models.Book

@Database(entities = [Author::class, Book::class], version = 1)
abstract class AuthorDatabase: RoomDatabase() {
    abstract fun authorDao(): AuthorDao
    abstract fun bookDao(): BookDao

    companion object {
        @Volatile
        private var sharedInstance: AuthorDatabase? = null

        fun getDb(context: Context) : AuthorDatabase {
            if (sharedInstance != null) return sharedInstance!!
            synchronized(this) {
                sharedInstance = Room
                    .databaseBuilder(context, AuthorDatabase::class.java, "author.db")
                    .fallbackToDestructiveMigration()
                    .build()
                return sharedInstance!!
            }
        }
    }
}