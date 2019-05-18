package hu.bme.mobsoft.marvelheroes.ui.list.comics

import hu.bme.mobsoft.marvelheroes.interactor.marvel.ComicInteractor
import hu.bme.mobsoft.marvelheroes.ui.Presenter
import kotlinx.coroutines.launch
import javax.inject.Inject

class ComicsPresenter @Inject constructor(private val comicInteractor: ComicInteractor) : Presenter<ComicsScreen>() {


    fun getComics(offset : Int = 0) {
        launch {
            screen?.loading(true)
            val comics = comicInteractor.getComics(offset)
            screen?.setComics(comics)
            screen?.loading(false)
        }
    }

    fun getComic(comicId : Int) {
        launch {
            screen?.loading(true)
            val comics = comicInteractor.getComic(comicId) //5589
            screen?.setComics(comics)
            screen?.loading(false)
        }
    }

    fun getRelatedComics() {
        launch {
            screen?.loading(true)
            val comics = comicInteractor.getComicsOfCharacter(1011334)
            screen?.setComics(comics)
            screen?.loading(false)
        }
    }
}