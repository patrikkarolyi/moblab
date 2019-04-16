package hu.bme.mobsoft.marvelheroes.network.api

import hu.bme.mobsoft.marvelheroes.network.model.marvelapi.MarvelCharacterResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Marvel marvelComics
 * This is a home work
 *
 * OpenAPI spec version: 1.0.0
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

interface CharacterApi {

    /**
     * Get all characters
     *
     * @param ts
     * @param hash
     * @param apikey
     * @return MarvelCharacterResponse
     */

    @GET("characters")
    fun getHeroes(
        @Query("ts") ts: Int,
        @Query("hash") hash: String,
        @Query("apikey") apikey: String
        ): Call<MarvelCharacterResponse>

    /**
     * Get a character
     *
     * @param ts
     * @param hash
     * @param apikey
     * @param characterId ID of hero to return
     * @return void
     */

    @GET("characters/{characterId}")
    fun getHero(
        @Path("characterId") characterId : Int,
        @Query("ts") ts: Int,
        @Query("hash") hash: String,
        @Query("apikey") apikey: String
    ): Call<MarvelCharacterResponse>

}
