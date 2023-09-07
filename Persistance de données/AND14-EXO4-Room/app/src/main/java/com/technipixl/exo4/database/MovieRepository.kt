package com.technipixl.exo4.database

import android.content.Context
import androidx.lifecycle.LiveData
import com.technipixl.exo4.MyApp
import com.technipixl.exo4.models.Genre
import com.technipixl.exo4.models.Movie
import com.technipixl.exo4.models.MovieGenre
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlin.io.path.CopyActionContext

class MovieRepository {

    //6. Initialiser la bd
    companion object {
        var moviesDatabase : AppDatabase? = null
        fun initializeDB(): AppDatabase{
            CoroutineScope(IO).launch {
                val genres = MyApp.database.genreDao().getAllGenre()
                if(genres.isNullOrEmpty()) {
                    MyApp.database.genreDao().insert(Genre(name = "Horror"))
                    MyApp.database.genreDao().insert(Genre(name = "Science Fiction"))
                    MyApp.database.genreDao().insert(Genre(name = "Fiction"))
                    MyApp.database.genreDao().insert(Genre(name = "Adventure"))
                    MyApp.database.genreDao().insert(Genre(name = "Mystery"))
                    MyApp.database.genreDao().insert(Genre(name = "Thriller"))
                    MyApp.database.genreDao().insert(Genre(name = "Drama"))
                    MyApp.database.genreDao().insert(Genre(name = "Fantasy"))
                    MyApp.database.genreDao().insert(Genre(name = "Western"))
                }
            }
            return MyApp.database
        }


        fun getAllMovies(): LiveData<List<Movie>> {
            if(MyApp.database == null) {
                MyApp.database = initializeDB()
            }
            return MyApp.database.movieDao().getAll()
        }

        fun insertBook(
            title: String,
            director: String,
            duration: Int,
            summary: String,
            selectedGenres: ArrayList<Genre>
        ) {
            CoroutineScope(IO).launch {
                val movie =
                    Movie(movieTitle = title, movieDirector = director, movieDuration = duration, movieSummary = summary)
                val movieId = MyApp.database.movieDao().insert(movie)
                selectedGenres.forEach {
                    val genreId = it.genreId
                    MyApp.database.movieGenreDao().insert(MovieGenre(movieId = movieId, genreId = genreId))
                }
            }
        }
    }
}