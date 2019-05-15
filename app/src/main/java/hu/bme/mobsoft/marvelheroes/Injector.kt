package hu.bme.mobsoft.marvelheroes

import android.app.Activity
import android.support.v4.app.Fragment

val Activity.injector: MarvelHeroesApplicationComponent
    get() {
        return (this.applicationContext as MarvelHeroesApplication).injector
    }

val Fragment.injector: MarvelHeroesApplicationComponent
    get() {
        return (this.context!!.applicationContext as MarvelHeroesApplication).injector
    }