package hu.bme.mobsoft.marvelheroes.db

import android.arch.persistence.room.*
import hu.bme.mobsoft.marvelheroes.model.marvelapi.MarvelCharacter
import hu.bme.mobsoft.marvelheroes.model.marvelapi.MarvelComic

@Dao
interface ComicDAO {

    companion object {
        const val tableName = "marvel_comic_db"
    }

    @Query("SELECT * FROM $tableName")
    fun getAll(): List<MarvelComic>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(comics: List<MarvelComic>)

    @Update
    fun update(comic: MarvelComic)

    @Delete
    fun delete(comic: MarvelComic)
}