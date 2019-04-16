package hu.bme.mobsoft.marvelheroes.db

import android.arch.persistence.room.*
import hu.bme.mobsoft.marvelheroes.model.marvelapi.MarvelCharacter


@Dao
interface CharacterDAO {

    @Insert
    fun insertAll(characters: List<MarvelCharacter>)

    @Update
    fun update(character: MarvelCharacter)

    @Delete
    fun delete(character: MarvelCharacter)
}