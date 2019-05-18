package hu.bme.mobsoft.marvelheroes.ui.list.comics

import hu.bme.mobsoft.marvelheroes.model.marvelapi.MarvelComic

interface ComicsScreen {
    fun setComics(comics: List<MarvelComic>)
    fun loading(loading: Boolean)
}