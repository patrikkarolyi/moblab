package hu.bme.mobsoft.marvelheroes.ui.list.comics

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import hu.bme.mobsoft.marvelheroes.R
import hu.bme.mobsoft.marvelheroes.injector
import hu.bme.mobsoft.marvelheroes.model.marvelapi.MarvelComic
import hu.bme.mobsoft.marvelheroes.ui.list.adapters.CharacterAdapter
import hu.bme.mobsoft.marvelheroes.ui.list.adapters.ComicAdapter
import kotlinx.android.synthetic.main.fragment_recent.*
import javax.inject.Inject

class ComicsFragment : Fragment(), ComicsScreen {

    @Inject
    lateinit var presenter: ComicsPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return View.inflate(activity, R.layout.fragment_recent, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        injector.inject(this)
        presenter.attachScreen(this)
        presenter.getComic()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachScreen()
    }

    override fun setComics(comics: List<MarvelComic>) {
        contentRV.layoutManager = GridLayoutManager(context,2)
        contentRV.adapter = ComicAdapter(comics)
    }
}