package br.com.joaonelson.pokedex.api.service

import br.com.joaonelson.pokedex.model.pokemonInformation.Pokemon
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApiService {

    @GET("pokemon/{id}")
    suspend fun getPokemonById(@Path("id") id: Int): Response<Pokemon?>

    @GET("pokemon/{nameOrId}")
    suspend fun getPokemonByNameOrId(@Path("nameOrId") nameOrId: String): Response<Pokemon?>
}