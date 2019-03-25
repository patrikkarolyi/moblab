package com.example.mobsoft

import com.example.mobsoft.ui.UIModule
import com.example.mobsoft.ui.main.MainActivity
import com.example.mobsoft.ui.splash.SplashFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class])//, NetworkModule::class, InteractorModule::class])
interface VergeReaderApplicationComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(splashFragment: SplashFragment)
}