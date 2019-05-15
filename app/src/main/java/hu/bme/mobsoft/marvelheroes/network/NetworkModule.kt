package hu.bme.mobsoft.marvelheroes.network

import dagger.Module
import dagger.Provides
import hu.bme.mobsoft.marvelheroes.network.api.CharacterApi
import hu.bme.mobsoft.marvelheroes.network.api.ComicApi
import hu.bme.mobsoft.marvelheroes.network.api.HeroApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }


    @Provides
    @Singleton
    fun provideCharactersApi(client: OkHttpClient): CharacterApi {
        val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl(NetworkConfig.API_ENDPOINT_ADDRESS)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(CharacterApi::class.java)
    }

    @Provides
    @Singleton
    fun provideComicsApi(client: OkHttpClient): ComicApi{
        val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl(NetworkConfig.API_ENDPOINT_ADDRESS)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ComicApi::class.java)
    }

    @Provides
    @Singleton
    fun provideHeroApi(client: OkHttpClient): HeroApi {
        val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl(NetworkConfig.API_ENDPOINT_HERO_ADDRESS)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(HeroApi::class.java)
    }
}