package hu.bme.mobsoft.marvelheroes.network.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MarvelComic (
    val resourceURI: String? = null,
    val name: String? = null
) : Parcelable
