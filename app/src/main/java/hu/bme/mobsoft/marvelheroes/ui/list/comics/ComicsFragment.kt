package hu.bme.mobsoft.marvelheroes.ui.list.comics

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hu.bme.mobsoft.marvelheroes.R
import hu.bme.mobsoft.marvelheroes.injector
import hu.bme.mobsoft.marvelheroes.model.marvelapi.MarvelComic
import hu.bme.mobsoft.marvelheroes.ui.list.comics.adapter.ComicAdapter
import hu.bme.mobsoft.marvelheroes.ui.list.comics.adapter.ComicClickListener
import hu.bme.mobsoft.marvelheroes.ui.list.comics.details.ComicDetailsFragment
import kotlinx.android.synthetic.main.fragment_recent.*
import javax.inject.Inject

class ComicsFragment : Fragment(), ComicsScreen, ComicClickListener {

    @Inject
    lateinit var presenter: ComicsPresenter
    private var numOfItemsOnScreen = 0
    private var isLoading = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return View.inflate(activity, R.layout.fragment_recent, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        injector.inject(this)
        presenter.attachScreen(this)
        presenter.getComics()
    }

    private fun initRecyclerView() {
        contentRV.layoutManager = GridLayoutManager(context,2)
        contentRV.adapter = ComicAdapter(mutableListOf(), this)
        contentRV.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1) && !isLoading) {
                    presenter.getComics(numOfItemsOnScreen)
                }
            }
        })
    }

    override fun loading(loading: Boolean) {
        isLoading = loading
        when(loading){
            true -> {
                progressBar.visibility = View.VISIBLE
            }
            false->{
                progressBar.visibility = View.GONE
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachScreen()
    }

    override fun setComics(comics: List<MarvelComic>) {
        numOfItemsOnScreen+=comics.size
        (contentRV.adapter as ComicAdapter).addComic(comics)
    }

    override fun comicClicked(marvelComic: MarvelComic) {
        childFragmentManager.beginTransaction()
            .addToBackStack("details")
            .add(R.id.detailsContainer, ComicDetailsFragment.newInstance(marvelComic = marvelComic))
            .commit()
    }
}