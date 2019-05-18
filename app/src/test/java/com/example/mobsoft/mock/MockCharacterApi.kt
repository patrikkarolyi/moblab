package com.example.mobsoft.mock

import hu.bme.mobsoft.marvelheroes.model.marvelapi.MarvelCharacter
import hu.bme.mobsoft.marvelheroes.model.marvelapi.MarvelCharacterResponse
import hu.bme.mobsoft.marvelheroes.model.marvelapi.MarvelCharacterWrapper
import hu.bme.mobsoft.marvelheroes.network.api.CharacterApi
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class MockCharacterApi : CharacterApi {

    val character1 = MarvelCharacter(
        id = 1,
        name = "caharacter1",
        description = "desc",
        thumbnail = null,
        resourceURI = null,
        comics = null,
        urls = null
    )

    val character2 = MarvelCharacter(
        id = 2,
        name = "caharacter2",
        description = "desc",
        thumbnail = null,
        resourceURI = null,
        comics = null,
        urls = null
    )

    override fun getCharacter(characterId: Int, ts: Int, hash: String, apikey: String): Call<MarvelCharacterResponse> {

        val characters = listOf<MarvelCharacter>(character1)

        val marvelCharacterWrapper = MarvelCharacterWrapper(
            count = characters.size,
            total = 100000,
            results = characters
        )

        val marvelCharacterResponse = MarvelCharacterResponse(
            code = 123,
            status = "ok",
            copyright = "marvel",
            data = marvelCharacterWrapper
        )


        return object : Call<MarvelCharacterResponse> {
            @Throws(IOException::class)
            override fun execute(): Response<MarvelCharacterResponse> {
                return Response.success(marvelCharacterResponse)
            }

            override fun enqueue(callback: Callback<MarvelCharacterResponse>) {

            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<MarvelCharacterResponse> {
                return this
            }

            override fun request(): Request? {
                return null
            }
        }
    }

    override fun getCharacters(
        limit: Int,
        offset: Int,
        ts: Int,
        hash: String,
        apikey: String
    ): Call<MarvelCharacterResponse> {

        val characters = listOf<MarvelCharacter>(character1, character2)

        val marvelCharacterWrapper = MarvelCharacterWrapper(
            count = characters.size,
            total = 100000,
            results = characters
        )

        val marvelCharacterResponse = MarvelCharacterResponse(
            code = 123,
            status = "ok",
            copyright = "marvel",
            data = marvelCharacterWrapper
        )


        return object : Call<MarvelCharacterResponse> {
            @Throws(IOException::class)
            override fun execute(): Response<MarvelCharacterResponse> {
                return Response.success(marvelCharacterResponse)
            }

            override fun enqueue(callback: Callback<MarvelCharacterResponse>) {

            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<MarvelCharacterResponse> {
                return this
            }

            override fun request(): Request? {
                return null
            }
        }
    }


}