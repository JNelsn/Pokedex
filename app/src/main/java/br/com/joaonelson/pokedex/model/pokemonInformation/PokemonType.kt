package br.com.joaonelson.pokedex.model.pokemonInformation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PokemonType (
    val slot : Int,
    val type : TypeInformations
    ) : Parcelable