package br.com.joaonelson.pokedex.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.joaonelson.pokedex.repository.PokemonRepository
import br.com.joaonelson.pokedex.viewmodel.PokemonListActivityViewModel

class PokemonListActivityViewModelFactory(
    private val repository: PokemonRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PokemonListActivityViewModel(repository) as T
    }
}