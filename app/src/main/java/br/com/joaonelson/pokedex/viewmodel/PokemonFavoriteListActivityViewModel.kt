package br.com.joaonelson.pokedex.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import br.com.joaonelson.pokedex.database.entity.PokemonEntity
import br.com.joaonelson.pokedex.repository.PokemonRepository

class PokemonFavoriteListActivityViewModel(
    private val repository: PokemonRepository
) : ViewModel() {

    fun loadOnlyFavorites(): LiveData<List<PokemonEntity>?> {
        return repository.getFavoritesPokemons()
    }

}
