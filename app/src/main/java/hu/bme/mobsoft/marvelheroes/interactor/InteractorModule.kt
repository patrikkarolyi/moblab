package hu.bme.mobsoft.marvelheroes.interactor

import dagger.Module
import dagger.Provides
import hu.bme.mobsoft.marvelheroes.interactor.articles.ArticleInteractor
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideArticlesInteractor() = ArticleInteractor()
}