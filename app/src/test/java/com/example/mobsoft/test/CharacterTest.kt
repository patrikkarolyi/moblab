package com.example.mobsoft.test

import com.example.mobsoft.testInjector
import hu.bme.mobsoft.marvelheroes.model.marvelapi.MarvelCharacter
import hu.bme.mobsoft.marvelheroes.ui.list.characters.CharactersPresenter
import hu.bme.mobsoft.marvelheroes.ui.list.characters.CharactersScreen
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
class CharacterTest {
    @Inject
    lateinit var charactersPresenter: CharactersPresenter

    private lateinit var charactersScreencreen: CharactersScreen

    inline fun <reified T : Any> mock(): T = Mockito.mock(T::class.java)!!
    inline fun <reified T : Any> argumentCaptor(): ArgumentCaptor<T> = ArgumentCaptor.forClass(T::class.java)

    @Before
    @Throws(Exception::class)
    fun setup() {
        testInjector.inject(this)
        charactersScreencreen = mock()
        charactersPresenter.attachScreen(charactersScreencreen)
    }

    @Test
    fun testArtists() {
        charactersPresenter.getCharacters()

        val list = argumentCaptor<MutableList<MarvelCharacter>>()
        verify(charactersScreencreen).setCharacters(list.capture())
        assert(list.value.size > 0)
    }

    @After
    fun tearDown() {
        charactersPresenter.detachScreen()
    }
}