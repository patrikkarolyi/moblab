package hu.bme.mobsoft.marvelheroes.db

import android.arch.persistence.room.*
import hu.bme.mobsoft.marvelheroes.model.marvelapi.MarvelCharacter


@Dao
interface CharacterDAO {

    companion object {
        const val tableName = "marvel_character_db"
    }

    @Query("SELECT * FROM $tableName")
    fun getAll(): List<MarvelCharacter>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(characters: List<MarvelCharacter>)

    @Update
    fun update(character: MarvelCharacter)

    @Delete
    fun delete(character: MarvelCharacter)
}