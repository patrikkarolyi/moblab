package hu.bme.mobsoft.marvelheroes.network.model.heroapi

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Hero(

    val response: String,

    val name: String,

    val id: String,

    val work: String,

    val powerstats: String,

    val appearance: String,

    val image: String,

    val biography: String,

    val connections: String
) : Parcelable
