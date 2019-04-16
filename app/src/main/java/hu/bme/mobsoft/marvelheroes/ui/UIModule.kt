package hu.bme.mobsoft.marvelheroes.ui

import android.content.Context
import hu.bme.mobsoft.marvelheroes.ui.details.DetailsPresenter
import hu.bme.mobsoft.marvelheroes.ui.list.ListPresenter
import hu.bme.mobsoft.marvelheroes.ui.splash.SplashPresenter
import dagger.Module
import dagger.Provides
import hu.bme.mobsoft.marvelheroes.interactor.articles.ArticleInteractor
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
    fun listPresenter(articleInteractor : ArticleInteractor) = ListPresenter(articleInteractor)

    @Provides
    @Singleton
    fun detailsPresenter() = DetailsPresenter()

}