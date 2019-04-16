package hu.bme.mobsoft.marvelheroes.network.model.marvelapi

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 *
 * @param code
 * @param data;
 */
@Parcelize
data class MarvelComicResponse(
    val code: Int? = null,
    val status: String? = null,
    val copyright: String? = null,
    val data: MarvelComicWrapper? = null
) : Parcelable