package br.com.joaonelson.pokedex.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.joaonelson.pokedex.R
import br.com.joaonelson.pokedex.adapter.RecyclerAdapterMain
import br.com.joaonelson.pokedex.database.AppDatabase
import br.com.joaonelson.pokedex.database.entity.PokemonEntity
import br.com.joaonelson.pokedex.repository.PokemonRepository
import br.com.joaonelson.pokedex.util.POKEMON_CHAVE
import br.com.joaonelson.pokedex.viewmodel.PokemonFavoriteListActivityViewModel
import br.com.joaonelson.pokedex.viewmodel.factory.PokemonFavoriteListActivityViewModelFactory
import kotlinx.android.synthetic.main.activity_pokemon_favorite_list.*


class PokemonFavoriteListActivity : AppCompatActivity() {

    private val adapter by lazy {
        RecyclerAdapterMain(context = this)
    }
    private val layoutManager by lazy {
        LinearLayoutManager(this)
    }

    private val viewModel by lazy {
        val repository = PokemonRepository(AppDatabase.getInstance(this).pokemonDAO)
        val factory = PokemonFavoriteListActivityViewModelFactory(repository)
        ViewModelProvider(this, factory)
            .get(PokemonFavoriteListActivityViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_favorite_list)
        startConfig()
        loadFavorites()

        materialAppBar.setNavigationOnClickListener {
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        loadFavorites()
    }

    private fun startConfig() {
        recycleView_main.layoutManager = layoutManager
        recycleView_main.adapter = adapter
        adapter.onItemClicked = ::openPokemonDetails
    }

    private fun openPokemonDetails(pokemonId: PokemonEntity) {
        val intent = Intent(this, PokemonDetailsActivity::class.java)
        intent.putExtra(POKEMON_CHAVE, pokemonId.id)
        startActivity(intent)
    }

    private fun loadFavorites() {
        viewModel.loadOnlyFavorites().observe(this, {listPokemons ->
            listPokemons?.let{
                adapter.update(it)
            }
        })
    }
}