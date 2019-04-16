package hu.bme.mobsoft.marvelheroes.network.model.marvelapi

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MarvelCharacterComic (
    val resourceURI: String? = null,
    val name: String? = null
) : Parcelable
