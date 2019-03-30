package com.example.mobsoft.ui

import android.content.Context
import com.example.mobsoft.ui.details.DetailsPresenter
import com.example.mobsoft.ui.list.ListPresenter
import com.example.mobsoft.ui.splash.SplashPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UIModule(private val context: Context) {

    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun splashPresenter() = SplashPresenter()

    @Provides
    @Singleton
    fun listPresenter() = ListPresenter()

    @Provides
    @Singleton
    fun detailsPresenter() = DetailsPresenter()

}