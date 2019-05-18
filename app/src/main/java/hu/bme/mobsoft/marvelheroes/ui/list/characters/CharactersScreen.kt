package hu.bme.mobsoft.marvelheroes.ui.list.characters

import hu.bme.mobsoft.marvelheroes.model.marvelapi.MarvelCharacter

interface CharactersScreen {
    fun setCharacters(characters: List<MarvelCharacter>)
    fun loading(loading : Boolean)
}