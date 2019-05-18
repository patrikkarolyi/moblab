package hu.bme.mobsoft.marvelheroes.ui.list.characters

import hu.bme.mobsoft.marvelheroes.interactor.marvel.CharacterInteractor
import hu.bme.mobsoft.marvelheroes.ui.Presenter
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharactersPresenter @Inject constructor(private val characterInteractor: CharacterInteractor) :
    Presenter<CharactersScreen>() {

    fun getCharacters(offset: Int = 0) {
        launch {
            screen?.loading(true)
            val characters = characterInteractor.getCharacters(offset)
            screen?.setCharacters(characters)
            screen?.loading(false)
            characterInteractor.saveCharacters(characters)
        }
    }

    fun getCharacter() {
        launch {
            screen?.loading(true)
            val characters = characterInteractor.getCharacter(1011334)
            screen?.setCharacters(characters)
            screen?.loading(false)
        }
    }

}