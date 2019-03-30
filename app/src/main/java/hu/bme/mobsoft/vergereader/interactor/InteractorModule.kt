package hu.bme.mobsoft.vergereader.interactor

import dagger.Module
import dagger.Provides
import hu.bme.mobsoft.vergereader.interactor.articles.ArticleInteractor
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideArticlesInteractor() = ArticleInteractor()
}