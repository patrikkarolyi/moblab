package hu.bme.mobsoft.marvelheroes.ui.list

import hu.bme.mobsoft.marvelheroes.network.model.Hero
import hu.bme.mobsoft.marvelheroes.network.model.MarvelCharacter

interface ListScreen {
    fun setCharacters(characters: List<MarvelCharacter>?)

}