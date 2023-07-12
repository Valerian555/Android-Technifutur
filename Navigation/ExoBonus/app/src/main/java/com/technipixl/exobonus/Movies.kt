package com.technipixl.exobonus

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Movies(val name: String, val description: String, val genre: MovieGenre): Parcelable {


}

enum class MovieGenre() {
    ACTION,
    THRILLER,
    FANTASTIQUE,
    HORREUR,
}

