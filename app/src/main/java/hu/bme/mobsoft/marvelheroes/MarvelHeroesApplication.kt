package hu.bme.mobsoft.marvelheroes

import android.app.Application
import hu.bme.mobsoft.marvelheroes.ui.UIModule

class MarvelHeroesApplication : Application() {

    lateinit var injector: MarvelHeroesApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerMarvelHeroesApplicationComponent.builder().uIModule(UIModule(this)).build()
    }

}