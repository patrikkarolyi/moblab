package hu.bme.mobsoft.marvelheroes.db.typeconverters

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import hu.bme.mobsoft.marvelheroes.model.marvelapi.MarvelUrl

class UrlsConverter {

    @TypeConverter
    fun urlsToJson( urls : List<MarvelUrl>?): String {
        if (urls == null) { return "" }
        val gson = Gson()
        val type = object : TypeToken<List<MarvelUrl>>() {}.type
        return gson.toJson(urls, type)
    }

    @TypeConverter
    fun urlsFromJson(urlsJson: String?): List<MarvelUrl>? {
        if (urlsJson == "") {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<MarvelUrl>>() {}.type
        return gson.fromJson(urlsJson, type)
    }
}