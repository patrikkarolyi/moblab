package com.example.mobsoft.ui.splash

import com.example.mobsoft.ui.Presenter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashPresenter : Presenter<SplashScreen>() {

    val DELAY = 3000L


    fun navigateToListActivity(){
        launch {
            delay(DELAY)
            screen?.navigateToListActivity()
        }
    }


}
