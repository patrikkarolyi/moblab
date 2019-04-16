package hu.bme.mobsoft.marvelheroes.ui.list.recent

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import hu.bme.mobsoft.marvelheroes.R
import hu.bme.mobsoft.marvelheroes.network.model.marvelapi.MarvelCharacter
import hu.bme.mobsoft.marvelheroes.network.model.marvelapi.MarvelComic

class RecentFragment : Fragment() {

    private val heroes by lazy { arguments!![HEROES] as ArrayList<MarvelComic> }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return View.inflate(activity, R.layout.fragment_recent, null)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setView()
    }

    private fun setView() {
        heroes.forEach { Toast.makeText(context,it.title,Toast.LENGTH_SHORT).show()}

    }

    companion object {
        const val HEROES = "HEROES"

        fun newInstance(comics: List<MarvelComic>): RecentFragment {
            val bundle = Bundle().apply {
                putParcelableArrayList(HEROES,java.util.ArrayList(comics))
            }
            return RecentFragment().apply { arguments = bundle }
        }
    }

}