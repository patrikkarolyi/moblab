package hu.bme.mobsoft.marvelheroes.interactor

import android.content.Context
import dagger.Module
import dagger.Provides
import hu.bme.mobsoft.marvelheroes.interactor.hero.HeroInteractor
import hu.bme.mobsoft.marvelheroes.interactor.marvel.CharacterInteractor
import hu.bme.mobsoft.marvelheroes.interactor.marvel.ComicInteractor
import hu.bme.mobsoft.marvelheroes.network.api.CharacterApi
import hu.bme.mobsoft.marvelheroes.network.api.ComicApi
import hu.bme.mobsoft.marvelheroes.network.api.HeroApi
import javax.inject.Singleton

@Module
class InteractorModule {

    @Provides
    @Singleton
    fun provideCharacterInteractor(characterApi: CharacterApi,context: Context) = CharacterInteractor(characterApi,context)

    @Provides
    @Singleton
    fun provideComicInteractor(comicApi: ComicApi,context: Context) = ComicInteractor(comicApi,context)

    @Provides
    @Singleton
    fun provideHeroInteractor(heroApi: HeroApi) = HeroInteractor(heroApi)
}