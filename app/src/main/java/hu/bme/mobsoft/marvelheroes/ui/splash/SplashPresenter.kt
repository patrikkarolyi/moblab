package hu.bme.mobsoft.marvelheroes.ui.splash

import hu.bme.mobsoft.marvelheroes.ui.Presenter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashPresenter : Presenter<SplashScreen>() {

    val DELAY = 3000L


    fun navigateToListActivity() {
        launch {
            delay(DELAY)
            screen?.navigateToListActivity()
        }
    }


}
