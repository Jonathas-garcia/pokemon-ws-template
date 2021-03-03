package br.com.heiderlopes.pokemonwstemplate.view.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.heiderlopes.pokemonwstemplate.repository.PokemonRepository

class SplashViewModel(
    val pokemonRepository: PokemonRepository
) : ViewModel() {

    val responseData: MutableLiveData<String> = MutableLiveData()

    fun checkHealth() {
        pokemonRepository.checkHealth(
            onComplete = {
                responseData.value = ""
            },
            onError = {
                responseData.value = it?.message
            }
        )
    }

}