package com.technipixl.preparationtestperso

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//parcelable permet d'envoyer une classe en argument
@Parcelize
class Person(val firstName: String, val lastName: String): Parcelable {
}