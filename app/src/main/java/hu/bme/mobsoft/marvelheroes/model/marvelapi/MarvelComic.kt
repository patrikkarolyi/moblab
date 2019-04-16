package hu.bme.mobsoft.marvelheroes.model.marvelapi

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class MarvelComic(
    @PrimaryKey(autoGenerate = false)
    val id : Int,
    @ColumnInfo(name = "title")
    val title : String? = null,
    @ColumnInfo(name = "description")
    val description : String? = null,
    @ColumnInfo(name = "thumbnail")
    val thumbnail : MarvelThumbnail? = null,
    @ColumnInfo(name = "resourceURI")
    val resourceURI : String? = null,
    @ColumnInfo(name = "images")
    val images : List<MarvelThumbnail>? = null
    ) : Parcelable
