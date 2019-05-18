package com.example.mobsoft

import com.example.mobsoft.test.CharacterTest
import dagger.Component
import hu.bme.mobsoft.marvelheroes.MarvelHeroesApplicationComponent
import hu.bme.mobsoft.marvelheroes.interactor.InteractorModule
import hu.bme.mobsoft.marvelheroes.network.NetworkModule
import hu.bme.mobsoft.marvelheroes.ui.UIModule
import javax.inject.Singleton

@Singleton
@Component(modules = [TestModule::class,UIModule::class, InteractorModule::class, NetworkModule::class])
interface TestComponent : MarvelHeroesApplicationComponent {

    fun inject(characterTest: CharacterTest)
}