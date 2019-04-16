package hu.bme.mobsoft.marvelheroes.ui.list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import hu.bme.mobsoft.marvelheroes.R
import hu.bme.mobsoft.marvelheroes.injector
import hu.bme.mobsoft.marvelheroes.network.model.marvelapi.MarvelCharacter
import hu.bme.mobsoft.marvelheroes.network.model.marvelapi.MarvelComic
import hu.bme.mobsoft.marvelheroes.ui.list.adapaters.ListPagerAdapter
import kotlinx.android.synthetic.main.activity_list.*
import javax.inject.Inject

class ListActivity : AppCompatActivity(), ListScreen {

    @Inject
    lateinit var presenter: ListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        injector.inject(this)
    }

    override fun onStart() {
        super.onStart()
        presenter.attachScreen(this)
        presenter.getRelatedComics()
    }

    override fun onStop() {
        super.onStop()
        presenter.detachScreen()
    }

    override fun setCharacters(characters: List<MarvelCharacter>) {

    }

    override fun setComics(comics: List<MarvelComic>) {
        listViewPager.adapter =
            ListPagerAdapter(baseContext!!, supportFragmentManager!!,comics)
        listSlidingTabs.setupWithViewPager(listViewPager)
    }
}