package hu.bme.mobsoft.marvelheroes.network.model.marvelapi

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MarvelCharacter(
    val id : Int? = null,
    val name : String? = null,
    val description : String? = null,
    val thumbnail : MarvelThumbnail? = null,
    val resourceURI : String? = null,
    val comics : MarvelCharacterComicWrapper? = null,
    val urls : List<MarvelUrl>? = null
    ) : Parcelable
