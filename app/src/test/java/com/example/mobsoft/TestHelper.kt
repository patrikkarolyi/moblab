package com.example.mobsoft


import hu.bme.mobsoft.marvelheroes.MarvelHeroesApplication
import org.robolectric.RuntimeEnvironment
import org.robolectric.shadows.ShadowLog


val testInjector: TestComponent
    get() {
        ShadowLog.stream = System.out
        val application = RuntimeEnvironment.application as MarvelHeroesApplication


        val component = DaggerTestComponent.builder().testModule(TestModule(application.applicationContext)).build()
        application.injector = component
        return component
    }