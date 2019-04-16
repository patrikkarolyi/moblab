package hu.bme.mobsoft.marvelheroes.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Update
import hu.bme.mobsoft.marvelheroes.network.model.marvelapi.MarvelComic

@Dao
interface ComicDAO {

    @Insert
    fun insertAll(comics: List<MarvelComic>)

    @Update
    fun update(comic: MarvelComic)

    @Delete
    fun delete(comic: MarvelComic)
}