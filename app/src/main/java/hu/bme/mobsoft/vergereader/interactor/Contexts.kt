package hu.bme.mobsoft.vergereader.interactor

import kotlinx.coroutines.Dispatchers

object Contexts {
    val UI = Dispatchers.Main
    val NETWORK = Dispatchers.IO
}
