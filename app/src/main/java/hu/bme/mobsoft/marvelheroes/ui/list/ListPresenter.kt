package hu.bme.mobsoft.marvelheroes.ui.list

import hu.bme.mobsoft.marvelheroes.interactor.marvel.CharacterInteractor
import hu.bme.mobsoft.marvelheroes.network.model.Hero
import hu.bme.mobsoft.marvelheroes.ui.Presenter
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListPresenter @Inject constructor(private val characterInteractor: CharacterInteractor) : Presenter<ListScreen>() {

    fun getCharacters(){
        launch {
            val characters = characterInteractor.getCharacters()
            screen?.setCharacters(characters)
        }
    }


}