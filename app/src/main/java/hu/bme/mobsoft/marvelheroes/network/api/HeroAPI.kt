package hu.bme.mobsoft.marvelheroes.network.api

import hu.bme.mobsoft.marvelheroes.network.model.Hero
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface HeroApi {

    /**
     * Get a hero
     *
     * @param heroId ID of comic to return
     * @return void
     */

    @GET("{heroId}")
    fun getHero(
        @Path("heroId") heroId: Int
    ): Call<Hero>

}