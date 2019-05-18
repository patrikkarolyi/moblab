package hu.bme.mobsoft.marvelheroes.network.api

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


import hu.bme.mobsoft.marvelheroes.model.marvelapi.MarvelComicResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ComicApi {

    /**
     * Get a comic
     *
     * @param ts
     * @param hash
     * @param apikey
     * @param comicId ID of comic to return
     * @return void
     */

    @GET("comics/{comicId}")
    fun getComic(
        @Path("comicId") comicId: Int,
        @Query("ts") ts: Int,
        @Query("hash") hash: String,
        @Query("apikey") apikey: String
    ): Call<MarvelComicResponse>

    /**
     * Get a comics
     *
     * @param ts
     * @param hash
     * @param apikey
     * @param comicId ID of comic to return
     * @return void
     */

    @GET("comics")
    fun getComics(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
        @Query("ts") ts: Int,
        @Query("hash") hash: String,
        @Query("apikey") apikey: String
    ): Call<MarvelComicResponse>

    /**
     * Get hero related marvelComics
     *
     * @param ts
     * @param hash
     * @param apikey
     * @param characterId ID of hero
     * @return void
     */

    @GET("characters/{characterId}/comics")
    fun getRelatedComics(
        @Path("characterId") characterId : Int,
        @Query("ts") ts: Int,
        @Query("hash") hash: String,
        @Query("apikey") apikey: String
    ): Call<MarvelComicResponse>

}
