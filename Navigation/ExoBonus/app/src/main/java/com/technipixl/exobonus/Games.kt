package com.technipixl.exobonus

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Games(val name:String, val description: String, val type: TypeOfGames): Parcelable {

}

enum class TypeOfGames() {
    PLATEFORME,
    HORREUR,
    RPG,
    MMORPG
}