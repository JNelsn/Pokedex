package br.com.joaonelson.pokedex.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.joaonelson.pokedex.repository.PokemonRepository
import br.com.joaonelson.pokedex.viewmodel.PokemonFavoriteListActivityViewModel

class PokemonFavoriteListActivityViewModelFactory(
    private val repository: PokemonRepository
) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PokemonFavoriteListActivityViewModel(repository) as T
    }

}
