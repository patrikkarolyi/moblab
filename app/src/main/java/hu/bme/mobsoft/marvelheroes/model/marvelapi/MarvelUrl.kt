package hu.bme.mobsoft.marvelheroes.model.marvelapi

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MarvelUrl(
    val type: String? = null,
    val url: String? = null
) : Parcelable
