package hu.bme.mobsoft.vergereader.ui.list

import hu.bme.mobsoft.vergereader.interactor.articles.ArticleInteractor
import hu.bme.mobsoft.vergereader.ui.Presenter
import javax.inject.Inject

class ListPresenter @Inject constructor(private val articleInteractor: ArticleInteractor) : Presenter<ListScreen>() {

}