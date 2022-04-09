package br.com.joaonelson.pokedex.api.webclient

import br.com.joaonelson.pokedex.api.RetroftInstance
import br.com.joaonelson.pokedex.api.service.PokeApiService

class PokemonWebClient(
    private val service: PokeApiService = RetroftInstance().pokeApiService
) {
    suspend fun findPokemonById(id: Int) = service.getPokemonById(id)
    suspend fun findPokemonByIdOrName(nameOrId: String) = service.getPokemonByNameOrId(nameOrId)
}