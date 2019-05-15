package hu.bme.mobsoft.marvelheroes.ui

import android.content.Context
import hu.bme.mobsoft.marvelheroes.ui.details.DetailsPresenter
import hu.bme.mobsoft.marvelheroes.ui.splash.SplashPresenter
import dagger.Module
import dagger.Provides
import hu.bme.mobsoft.marvelheroes.interactor.marvel.CharacterInteractor
import hu.bme.mobsoft.marvelheroes.interactor.marvel.ComicInteractor
import hu.bme.mobsoft.marvelheroes.ui.list.characters.CharactersPresenter
import hu.bme.mobsoft.marvelheroes.ui.list.comics.ComicsPresenter
import javax.inject.Singleton

@Module
class UIModule(private val context: Context) {

    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun splashPresenter() = SplashPresenter()

    @Provides
    @Singleton
    fun charactersPresenter(characterInteractor : CharacterInteractor) = CharactersPresenter(characterInteractor)

    @Provides
    @Singleton
    fun comicsPresenter(comicInteractor: ComicInteractor) = ComicsPresenter(comicInteractor)

    @Provides
    @Singleton
    fun detailsPresenter() = DetailsPresenter()

}