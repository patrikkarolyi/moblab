package hu.bme.mobsoft.marvelheroes.network.model.marvelapi

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MarvelComic(
    val id : Int? = null,
    val title : String? = null,
    val description : String? = null,
    val thumbnail : MarvelThumbnail? = null,
    val resourceURI : String? = null,
    val images : List<MarvelThumbnail>? = null
    ) : Parcelable
