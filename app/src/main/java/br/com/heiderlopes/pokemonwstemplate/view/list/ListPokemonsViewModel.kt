package br.com.heiderlopes.pokemonwstemplate.view.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.heiderlopes.pokemonwstemplate.model.Pokemon
import br.com.heiderlopes.pokemonwstemplate.repository.PokemonRepository

class ListPokemonsViewModel(
    val pokemonRepository: PokemonRepository
) : ViewModel() {

    val pokemons: MutableLiveData<List<Pokemon>> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val messageError: MutableLiveData<String> = MutableLiveData()

    fun getPokemons() {
        isLoading.value = true;
        pokemonRepository
            .getPokemons(150,
                "number,asc",
                onComplete = {
                    pokemons.value = it
                    isLoading.value = false
                    messageError.value = ""
                },
                onError = {
                    pokemons.value = emptyList()
                    isLoading.value = false
                    messageError.value = it?.message
                }
            )
    }

}
