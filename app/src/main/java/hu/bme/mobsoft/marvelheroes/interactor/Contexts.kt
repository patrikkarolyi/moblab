package hu.bme.mobsoft.marvelheroes.interactor

import kotlinx.coroutines.Dispatchers

object Contexts {
    val UI = Dispatchers.Main
    val IO = Dispatchers.IO
}