package hu.bme.mobsoft.marvelheroes.ui.details

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import com.bumptech.glide.Glide
import hu.bme.mobsoft.marvelheroes.R
import hu.bme.mobsoft.marvelheroes.injector
import hu.bme.mobsoft.marvelheroes.model.marvelapi.MarvelCharacter
import hu.bme.mobsoft.marvelheroes.utils.AspectRatio
import hu.bme.mobsoft.marvelheroes.utils.ImageSize
import hu.bme.mobsoft.marvelheroes.utils.imageUrl
import kotlinx.android.synthetic.main.fragment_character_details.*
import javax.inject.Inject

class DetailsFragment : Fragment(), DetailsScreen {

    @Inject
    lateinit var presenter: DetailsPresenter
    private val character by lazy { arguments!![CHAR] as MarvelCharacter }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflate(activity, R.layout.fragment_character_details, null)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
    }

    override fun onStart() {
        super.onStart()
        presenter.attachScreen(this)

        cancelBtn.setOnClickListener {
            parentFragment?.childFragmentManager?.popBackStackImmediate()
        }

        detailsName.text = character.name

        val queryUrl = character.thumbnail?.imageUrl(AspectRatio.Landscape, ImageSize.Amazing)
        Glide.with(context!!).load(queryUrl).into(detailsImage)

        detailsContent.text = character.description
    }

    override fun onStop() {
        super.onStop()
        presenter.detachScreen()
    }

    companion object {
        const val CHAR = "CHAR"

        fun newInstance(marvelCharacter: MarvelCharacter): DetailsFragment {
            return DetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(CHAR, marvelCharacter)
                }
            }
        }
    }


}