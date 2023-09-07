package com.technipixl.exo4.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation

/*4. Cette classe représente la relation entre les films et les genres.
Cette classe est utilisée pour créer une table de jointure (table intermédiaire)
qui permet de lier les films aux genres auxquels ils appartiennent.*/
//relation Many To Many

@Entity(primaryKeys = ["movieId","genreId"])
data class MovieGenre(
    var movieId: Long,
    var genreId: Long
)

//Cette classe est utilisée pour obtenir des informations sur un film et les genres auxquels il appartient
data class MovieWithGenre(
    @Embedded
    val movie: Movie,
    @Relation(
        parentColumn = "movieId",
        entityColumn = "genreId",
        associateBy = Junction(MovieGenre::class)
    )
    val genres: List<Genre>
)

//Cette classe est utilisée pour obtenir des informations sur un genre et les films qui appartiennent à celui-ci.
data class GenreWithMovie(
    @Embedded
    val genre: Genre,
    @Relation(
        parentColumn = "genreId",
        entityColumn = "movieId",
        associateBy = Junction(MovieGenre::class)
    )
    val movies: List<Movie>
)