package hu.bme.mobsoft.marvelheroes.ui.list.comics

import hu.bme.mobsoft.marvelheroes.interactor.marvel.ComicInteractor
import hu.bme.mobsoft.marvelheroes.ui.Presenter
import kotlinx.coroutines.launch
import javax.inject.Inject

class ComicsPresenter @Inject constructor(private val comicInteractor: ComicInteractor) : Presenter<ComicsScreen>() {


    fun getComic() {
        launch {
            val comics = comicInteractor.getComic(5589)
            screen?.setComics(comics)
        }
    }

    fun getRelatedComics() {
        launch {
            val comics = comicInteractor.getComicsOfCharacter(1011334)
            screen?.setComics(comics)
        }
    }
}