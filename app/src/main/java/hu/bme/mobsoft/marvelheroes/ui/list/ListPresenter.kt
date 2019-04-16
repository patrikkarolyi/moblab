package hu.bme.mobsoft.marvelheroes.ui.list

import hu.bme.mobsoft.marvelheroes.interactor.marvel.CharacterInteractor
import hu.bme.mobsoft.marvelheroes.interactor.marvel.ComicInteractor
import hu.bme.mobsoft.marvelheroes.ui.Presenter
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListPresenter @Inject constructor(private val characterInteractor: CharacterInteractor, private val comicInteractor: ComicInteractor) : Presenter<ListScreen>() {

    fun getCharacters(){
        launch {
            val characters = characterInteractor.getCharacters()
            screen?.setCharacters(characters)
        }
    }

    fun getCharacter(){
        launch {
            val characters = characterInteractor.getCharacter(1011334)
            screen?.setCharacters(characters)
        }
    }

    fun getComic(){
        launch {
            val comics = comicInteractor.getComic(5589)
            screen?.setComics(comics)
        }
    }

    fun getRelatedComics(){
        launch {
            val comics = comicInteractor.getComicsOfCharacter(1011334)
            screen?.setComics(comics)
        }
    }
}