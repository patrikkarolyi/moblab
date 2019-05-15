package hu.bme.mobsoft.marvelheroes.model.marvelapi

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 *
 * @param count
 * @param results
 */
@Parcelize
data class MarvelComicWrapper (
    val count: Int? = null,
    val total: Int? = null,
    val results: List<MarvelComic>? = null
) : Parcelable