package hu.bme.mobsoft.marvelheroes.network.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MarvelThumbnail(
    val path : String? = null,
    val extension : String? = null
) : Parcelable
