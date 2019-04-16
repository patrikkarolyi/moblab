package hu.bme.mobsoft.marvelheroes.network.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MarvelUrl(
    val type: String? = null,
    val url: String? = null
) : Parcelable
