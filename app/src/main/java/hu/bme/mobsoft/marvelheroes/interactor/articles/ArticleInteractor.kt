package hu.bme.mobsoft.marvelheroes.interactor.articles

import hu.bme.mobsoft.marvelheroes.interactor.Contexts
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ArticleInteractor @Inject constructor() {

    suspend fun getArticles() = withContext(Contexts.IO) {
        listOf("a", "b", "c")
    }
}