package hu.bme.mobsoft.marvelheroes.network.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 *
 * @param id
 * @param name
 */

@Parcelize
data class MarvelComicWrapper (
    val available: Int? = null,
    val collectionURI: String? = null,
    val items: List<MarvelComic>? = null,
    val returned: Int? = null
) : Parcelable