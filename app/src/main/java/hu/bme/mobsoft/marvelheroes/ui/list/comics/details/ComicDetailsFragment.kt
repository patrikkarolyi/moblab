package hu.bme.mobsoft.marvelheroes.ui.list.comics.details

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import hu.bme.mobsoft.marvelheroes.R
import hu.bme.mobsoft.marvelheroes.model.marvelapi.MarvelComic
import hu.bme.mobsoft.marvelheroes.utils.AspectRatio
import hu.bme.mobsoft.marvelheroes.utils.ImageSize
import hu.bme.mobsoft.marvelheroes.utils.imageUrl
import kotlinx.android.synthetic.main.fragment_character_details.*

class ComicDetailsFragment : Fragment() {

    private val comics by lazy { arguments!![COMIC] as MarvelComic }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return View.inflate(activity, R.layout.fragment_character_details, null)
    }


    override fun onStart() {
        super.onStart()

        cancelBtn.setOnClickListener {
            parentFragment?.childFragmentManager?.popBackStackImmediate()
        }

        detailsName.text = comics.title

        val queryUrl = comics.thumbnail?.imageUrl(AspectRatio.Landscape, ImageSize.Amazing)
        Glide.with(context!!).load(queryUrl).into(detailsImage)

        detailsContent.text = comics.description
    }


    companion object {
        const val COMIC = "COMIC"

        fun newInstance(marvelComic: MarvelComic): ComicDetailsFragment {
            return ComicDetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(COMIC, marvelComic)
                }
            }
        }
    }


}