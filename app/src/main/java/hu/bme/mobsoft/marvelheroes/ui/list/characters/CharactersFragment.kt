package hu.bme.mobsoft.marvelheroes.ui.list.characters

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hu.bme.mobsoft.marvelheroes.R
import hu.bme.mobsoft.marvelheroes.model.marvelapi.MarvelCharacter
import javax.inject.Inject
import android.support.v7.widget.GridLayoutManager
import hu.bme.mobsoft.marvelheroes.injector
import hu.bme.mobsoft.marvelheroes.ui.list.characters.details.CharacterDetailsFragment
import hu.bme.mobsoft.marvelheroes.ui.list.characters.adapter.CharacterAdapter
import hu.bme.mobsoft.marvelheroes.ui.list.characters.adapter.CharacterClickListener
import kotlinx.android.synthetic.main.fragment_recent.*
import android.support.v7.widget.RecyclerView




class CharactersFragment : Fragment() , CharactersScreen, CharacterClickListener {


    @Inject
    lateinit var presenter: CharactersPresenter
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
        presenter.getCharacters()

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

    private fun initRecyclerView() {
        contentRV.layoutManager = GridLayoutManager(context,3)
        contentRV.adapter = CharacterAdapter(mutableListOf(), this)
        contentRV.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1) && !isLoading) {
                    presenter.getCharacters(numOfItemsOnScreen)
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachScreen()
    }

    override fun setCharacters(characters: List<MarvelCharacter>) {
        numOfItemsOnScreen+=characters.size
        (contentRV.adapter as CharacterAdapter).addCharacters(characters)
    }

    override fun characterClicked(marvelCharacter: MarvelCharacter) {
        childFragmentManager.beginTransaction()
            .addToBackStack("details")
            .add(R.id.detailsContainer, CharacterDetailsFragment.newInstance(marvelCharacter = marvelCharacter))
            .commit()
    }

}