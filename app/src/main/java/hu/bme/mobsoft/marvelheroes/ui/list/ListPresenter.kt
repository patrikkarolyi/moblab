package hu.bme.mobsoft.marvelheroes.ui.list

import hu.bme.mobsoft.marvelheroes.interactor.articles.ArticleInteractor
import hu.bme.mobsoft.marvelheroes.ui.Presenter
import javax.inject.Inject

class ListPresenter @Inject constructor(private val articleInteractor: ArticleInteractor) : Presenter<ListScreen>() {

}