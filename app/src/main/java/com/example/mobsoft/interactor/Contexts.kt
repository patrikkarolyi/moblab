package com.example.mobsoft.interactor

import kotlinx.coroutines.Dispatchers

object Contexts {
    val UI = Dispatchers.Main
    val NETWORK = Dispatchers.IO
}
