package hu.bme.mobsoft.marvelheroes

import dagger.Component
import hu.bme.mobsoft.marvelheroes.interactor.InteractorModule
import hu.bme.mobsoft.marvelheroes.network.NetworkModule
import hu.bme.mobsoft.marvelheroes.ui.UIModule
import hu.bme.mobsoft.marvelheroes.ui.details.DetailsFragment
import hu.bme.mobsoft.marvelheroes.ui.list.characters.CharactersFragment
import hu.bme.mobsoft.marvelheroes.ui.list.comics.ComicsFragment
import hu.bme.mobsoft.marvelheroes.ui.splash.SplashActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, InteractorModule::class, NetworkModule::class])
interface MarvelHeroesApplicationComponent {

    fun inject(splashActivity: SplashActivity)
    fun inject(detailsFragment: DetailsFragment)

    fun inject(charactersFragment: CharactersFragment)
    fun inject(comicsFragment: ComicsFragment)
}