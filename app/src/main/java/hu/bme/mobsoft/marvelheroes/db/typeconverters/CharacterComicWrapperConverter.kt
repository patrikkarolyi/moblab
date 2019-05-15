package hu.bme.mobsoft.marvelheroes.db.typeconverters

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import hu.bme.mobsoft.marvelheroes.model.marvelapi.MarvelCharacterComicWrapper

class CharacterComicWrapperConverter {

    @TypeConverter
    fun characterComicWrapperToJson(characterComicWrapper: MarvelCharacterComicWrapper?): String {
        val gson = Gson()
        val type = object : TypeToken<MarvelCharacterComicWrapper>() {}.type
        return gson.toJson(characterComicWrapper, type)
    }

    @TypeConverter
    fun characterComicWrapperFromJson(characterComicWrapperJson: String?): MarvelCharacterComicWrapper? {
        val gson = Gson()
        val type = object : TypeToken<MarvelCharacterComicWrapper>() {}.type
        return gson.fromJson(characterComicWrapperJson, type)
    }
}