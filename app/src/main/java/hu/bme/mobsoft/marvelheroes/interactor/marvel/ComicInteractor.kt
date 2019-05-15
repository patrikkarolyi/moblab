package hu.bme.mobsoft.marvelheroes.interactor.marvel

import hu.bme.mobsoft.marvelheroes.interactor.Contexts
import hu.bme.mobsoft.marvelheroes.network.NetworkConfig
import hu.bme.mobsoft.marvelheroes.network.api.ComicApi
import hu.bme.mobsoft.marvelheroes.model.marvelapi.MarvelComic
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ComicInteractor @Inject constructor(private var comicApi: ComicApi) {

    ///TODO error handling
    ///TODO calculate hash

    suspend fun getComic(comicId : Int) : List<MarvelComic>  = withContext(Contexts.IO) {
        val timestamp = 1555350390
        val apikey_public = NetworkConfig.APIKEY_PUBLIC
        val apikey_private = NetworkConfig.APIKEY_PRIVATE
        val hash = "a4c7f2c7ea5315021a7d7ad61e58d5e6" //timestamp.toString() + apikey_private + apikey_public
        val response = comicApi.getComic(comicId,timestamp,hash,apikey_public).execute().body()
        response?.data?.results!!
    }

    suspend fun getComicsOfCharacter(characterId : Int) : List<MarvelComic> = withContext(Contexts.IO) {
        val timestamp = 1555350390
        val apikey_public = NetworkConfig.APIKEY_PUBLIC
        val apikey_private = NetworkConfig.APIKEY_PRIVATE
        val hash = "a4c7f2c7ea5315021a7d7ad61e58d5e6"
        val response = comicApi.getRelatedComics(characterId,timestamp,hash,apikey_public).execute().body()
        response?.data?.results!!

    }

}