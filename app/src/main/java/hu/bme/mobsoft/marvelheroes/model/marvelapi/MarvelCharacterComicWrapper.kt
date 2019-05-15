package hu.bme.mobsoft.marvelheroes.model.marvelapi

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 *
 * @param id
 * @param name
 */

@Parcelize
data class MarvelCharacterComicWrapper (
    val available: Int? = null,
    val collectionURI: String? = null,
    val items: List<MarvelCharacterComic>? = null,
    val returned: Int? = null
) : Parcelable