package hu.bme.mobsoft.marvelheroes.db.typeconverters

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import hu.bme.mobsoft.marvelheroes.model.marvelapi.MarvelThumbnail

class ThumbnailConverter {

    @TypeConverter
    fun thumbnailToJson( thumbnail : MarvelThumbnail?): String {
        val gson = Gson()
        val type = object : TypeToken<MarvelThumbnail>() {}.type
        return gson.toJson(thumbnail, type)
    }

    @TypeConverter
    fun thumbnailFromJson(thumbnailJson: String?): MarvelThumbnail? {
        val gson = Gson()
        val type = object : TypeToken<MarvelThumbnail>() {}.type
        return gson.fromJson(thumbnailJson, type)
    }

    @TypeConverter
    fun thumbnailsToJson( thumbnail : List<MarvelThumbnail>?): String {
        val gson = Gson()
        val type = object : TypeToken<List<MarvelThumbnail>>() {}.type
        return gson.toJson(thumbnail, type)
    }

    @TypeConverter
    fun thumbnailsFromJson(thumbnailJson: String?): List<MarvelThumbnail>? {
        val gson = Gson()
        val type = object : TypeToken<List<MarvelThumbnail>>() {}.type
        return gson.fromJson(thumbnailJson, type)
    }
}