package hu.bme.mobsoft.marvelheroes.ui.list.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import hu.bme.mobsoft.marvelheroes.R
import hu.bme.mobsoft.marvelheroes.model.marvelapi.MarvelComic
import kotlinx.android.synthetic.main.item_character.view.*

class ComicAdapter(private val comics: List<MarvelComic>) :RecyclerView.Adapter<ComicAdapter.ComicViewHolder>() {


    inner class ComicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val iv: ImageView = itemView.characterIV
        val tv: TextView = itemView.characterTV
    }

    override fun onBindViewHolder(vh: ComicViewHolder, pos: Int) {
        comics[pos].thumbnail?.let {
            val queryUrl = it.path?.toHTTPS() + "/portrait_xlarge." + it.extension
            Glide.with(vh.itemView.context).load(queryUrl).into(vh.iv)
        }

        vh.tv.text = comics[pos].title

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder {
        return ComicViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false))

    }

    override fun getItemCount() = comics.size


}

private fun String.toHTTPS(): String {
    return this.replaceFirst("http", "https")
}