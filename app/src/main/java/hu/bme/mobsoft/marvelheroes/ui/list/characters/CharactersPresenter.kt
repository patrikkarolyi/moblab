package hu.bme.mobsoft.marvelheroes.ui.list.characters

import hu.bme.mobsoft.marvelheroes.interactor.marvel.CharacterInteractor
import hu.bme.mobsoft.marvelheroes.ui.Presenter
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharactersPresenter @Inject constructor(private val characterInteractor: CharacterInteractor) :
    Presenter<CharactersScreen>() {

    fun getCharacters() {
        launch {
            val characters = characterInteractor.getCharacters()
            screen?.setCharacters(characters)
        }
    }

    fun getCharacter() {
        launch {
            val characters = characterInteractor.getCharacter(1011334)
            screen?.setCharacters(characters)
        }
    }

}