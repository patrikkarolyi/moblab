package com.example.mobsoft

import com.example.mobsoft.ui.UIModule
import com.example.mobsoft.ui.details.DetailsActivity
import com.example.mobsoft.ui.list.ListActivity
import com.example.mobsoft.ui.splash.SplashActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class])//, NetworkModule::class, InteractorModule::class])
interface VergeReaderApplicationComponent {

    fun inject(splashActivity: SplashActivity)
    fun inject(listActivity: ListActivity)
    fun inject(detailsActivity: DetailsActivity)
}