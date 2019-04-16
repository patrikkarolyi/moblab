package hu.bme.mobsoft.marvelheroes.model.marvelapi

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class MarvelCharacter(
    @PrimaryKey(autoGenerate = false)
    val id : Int,
    @ColumnInfo(name = "name")
    val name : String? = null,
    @ColumnInfo(name = "description")
    val description : String? = null,
    @ColumnInfo(name = "thumbnail")
    val thumbnail : MarvelThumbnail? = null,
    @ColumnInfo(name = "resourceURI")
    val resourceURI : String? = null,
    @ColumnInfo(name = "comics")
    val comics : MarvelCharacterComicWrapper? = null,
    @ColumnInfo(name = "urls")
    val urls : List<MarvelUrl>? = null
    ) : Parcelable
