package hu.bme.mobsoft.marvelheroes.ui.list.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import hu.bme.mobsoft.marvelheroes.R
import hu.bme.mobsoft.marvelheroes.model.marvelapi.MarvelCharacter
import hu.bme.mobsoft.marvelheroes.utils.AspectRatio
import hu.bme.mobsoft.marvelheroes.utils.ImageSize
import hu.bme.mobsoft.marvelheroes.utils.imageUrl
import hu.bme.mobsoft.marvelheroes.utils.toHTTPS
import kotlinx.android.synthetic.main.item_character.view.*


class CharacterAdapter(private val characters: List<MarvelCharacter>,
                       private val listener: CharacterClickListener) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {


    inner class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val iv: ImageView = itemView.characterIV
        val tv: TextView = itemView.characterTV
    }

    override fun onBindViewHolder(vh: CharacterViewHolder, pos: Int) {
        characters[pos].thumbnail?.let {
            val queryUrl = it.imageUrl(AspectRatio.Standard,ImageSize.Medium)
            Glide.with(vh.itemView.context).load(queryUrl).into(vh.iv)
        }

        vh.tv.text = characters[pos].name

        vh.iv.setOnClickListener {
            listener.characterClicked(characters[pos])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false))

    }

    override fun getItemCount() = characters.size


}
interface CharacterClickListener{
    fun characterClicked(marvelCharacter: MarvelCharacter)
}



