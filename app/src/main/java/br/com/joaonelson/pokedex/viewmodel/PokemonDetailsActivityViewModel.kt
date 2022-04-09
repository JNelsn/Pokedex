package br.com.joaonelson.pokedex.viewmodel

import androidx.lifecycle.*
import br.com.joaonelson.pokedex.database.entity.PokemonEntity
import br.com.joaonelson.pokedex.repository.PokemonRepository
import br.com.joaonelson.pokedex.repository.Resource
import kotlinx.coroutines.launch

class PokemonDetailsActivityViewModel(
    private val repository: PokemonRepository
) : ViewModel() {
    private val pokemonLiveData = MediatorLiveData<Resource<PokemonEntity?>>()

    fun getPokemonById(pokemonId: Int): LiveData<Resource<PokemonEntity?>> {

        pokemonLiveData.addSource(repository.getPokemonByIdOnDatabase(pokemonId)) {
            if (it != null) {
                pokemonLiveData.value = Resource(data = it)
            } else {
                viewModelScope.launch {
                    pokemonLiveData.value = repository.getPokemonByIdOnApi(pokemonId).value
                }
            }
        }
        return pokemonLiveData
    }

    fun changeFavorite(pokemonReferente: PokemonEntity) {
        viewModelScope.launch {
            repository.changeFavorite(pokemonReferente)
        }
    }

}
