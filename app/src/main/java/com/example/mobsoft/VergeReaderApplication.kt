package com.example.mobsoft

import android.app.Application
import com.example.mobsoft.ui.UIModule

class VergeReaderApplication : Application(){

    lateinit var injector: VergeReaderApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerVergeReaderApplicationComponent.builder().UIModule(UIModule(this)).build()
    }

}