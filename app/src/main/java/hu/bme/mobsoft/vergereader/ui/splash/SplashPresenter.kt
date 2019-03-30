package hu.bme.mobsoft.vergereader.ui.splash

import hu.bme.mobsoft.vergereader.ui.Presenter
import hu.bme.mobsoft.vergereader.ui.splash.SplashScreen
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
