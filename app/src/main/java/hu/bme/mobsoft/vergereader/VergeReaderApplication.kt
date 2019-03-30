package hu.bme.mobsoft.vergereader

import android.app.Application
import hu.bme.mobsoft.vergereader.ui.UIModule

class VergeReaderApplication : Application(){

    lateinit var injector: VergeReaderApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerVergeReaderApplicationComponent.builder().uIModule(UIModule(this)).build()
    }

}