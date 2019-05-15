package hu.bme.mobsoft.marvelheroes

import dagger.Component
import hu.bme.mobsoft.marvelheroes.interactor.InteractorModule
import hu.bme.mobsoft.marvelheroes.network.NetworkModule
import hu.bme.mobsoft.marvelheroes.ui.UIModule
import hu.bme.mobsoft.marvelheroes.ui.details.DetailsActivity
import hu.bme.mobsoft.marvelheroes.ui.list.ListActivity
import hu.bme.mobsoft.marvelheroes.ui.splash.SplashActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, InteractorModule::class, NetworkModule::class])
interface MarvelHeroesApplicationComponent {

    fun inject(splashActivity: SplashActivity)
    fun inject(listActivity: ListActivity)
    fun inject(detailsActivity: DetailsActivity)
}