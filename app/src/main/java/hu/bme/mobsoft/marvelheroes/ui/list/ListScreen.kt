package hu.bme.mobsoft.marvelheroes.ui.list

import hu.bme.mobsoft.marvelheroes.model.marvelapi.MarvelCharacter
import hu.bme.mobsoft.marvelheroes.model.marvelapi.MarvelComic

interface ListScreen {
    fun setCharacters(characters: List<MarvelCharacter>)
    fun setComics(comics: List<MarvelComic>)

}