package hu.bme.mobsoft.marvelheroes.interactor.marvel

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import hu.bme.mobsoft.marvelheroes.db.MarvelRoomDatabase
import hu.bme.mobsoft.marvelheroes.interactor.Contexts
import hu.bme.mobsoft.marvelheroes.model.marvelapi.MarvelCharacter
import hu.bme.mobsoft.marvelheroes.model.marvelapi.MarvelCharacterResponse
import hu.bme.mobsoft.marvelheroes.network.NetworkConfig
import hu.bme.mobsoft.marvelheroes.network.api.CharacterApi
import kotlinx.coroutines.withContext
import javax.inject.Inject


class CharacterInteractor @Inject constructor(private var characterApi: CharacterApi, val context: Context) {


    suspend fun getCharacters(offset: Int): List<MarvelCharacter> = withContext(Contexts.IO) {
        when {
            !checkInternetConnection() -> {
                print("NONET")
                MarvelRoomDatabase.getInstance(context).getCharacters()
            }
            else -> {
                print("NET")
                val timestamp = 1555350390
                val apikey_public = NetworkConfig.APIKEY_PUBLIC
                val apikey_private = NetworkConfig.APIKEY_PRIVATE
                val hash = "a4c7f2c7ea5315021a7d7ad61e58d5e6" //timestamp.toString() + apikey_private + apikey_public
                val response: MarvelCharacterResponse? =
                    characterApi.getCharacters(21, offset, timestamp, hash, apikey_public).execute().body()
                response?.data?.results!!
            }
        }
    }

    suspend fun getCharacter(characterId: Int): List<MarvelCharacter> = withContext(Contexts.IO) {
        val timestamp = 1555350390
        val apikey_public = NetworkConfig.APIKEY_PUBLIC
        val apikey_private = NetworkConfig.APIKEY_PRIVATE
        val hash = "a4c7f2c7ea5315021a7d7ad61e58d5e6" //timestamp.toString() + apikey_private + apikey_public
        val response: MarvelCharacterResponse? =
            characterApi.getCharacter(characterId, timestamp, hash, apikey_public).execute().body()
        response?.data?.results!!

    }

    suspend fun saveCharacters(characters: List<MarvelCharacter>) = withContext(Contexts.IO) {
        if(checkInternetConnection()){
            MarvelRoomDatabase.getInstance(context).saveCharacters(characters)
        }
    }

    private fun checkInternetConnection(): Boolean {
        val info = (context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo
        return info != null && info.isConnected
    }

}