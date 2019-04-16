package hu.bme.mobsoft.marvelheroes.interactor.marvel

import hu.bme.mobsoft.marvelheroes.interactor.Contexts
import hu.bme.mobsoft.marvelheroes.network.NetworkConfig
import hu.bme.mobsoft.marvelheroes.network.api.CharacterApi
import hu.bme.mobsoft.marvelheroes.network.model.MarvelCharacterResponse
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharacterInteractor @Inject constructor(private var characterApi: CharacterApi) {

    suspend fun getArticles() = withContext(Contexts.IO) {
        listOf("a", "b", "c")
    }

    suspend fun getCharacters() = withContext(Contexts.IO) {
        val timestamp = 1555350390
        val apikey_public = NetworkConfig.APIKEY_PUBLIC
        val apikey_private = NetworkConfig.APIKEY_PRIVATE
        val hash = "a4c7f2c7ea5315021a7d7ad61e58d5e6" //timestamp.toString() + apikey_private + apikey_public
        val response : MarvelCharacterResponse? = characterApi.getHeroes(timestamp,hash,apikey_public).execute().body()
        val characters = response?.data?.results
        characters
    }


}