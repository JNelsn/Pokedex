package br.com.joaonelson.pokedex.model.pokemonInformation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OtherImages(
    val front_default : String
) : Parcelable
