package hu.bme.mobsoft.marvelheroes.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import hu.bme.mobsoft.marvelheroes.interactor.Contexts
import hu.bme.mobsoft.marvelheroes.model.marvelapi.MarvelCharacter
import hu.bme.mobsoft.marvelheroes.model.marvelapi.MarvelComic
import kotlinx.coroutines.withContext


@Database(entities = [MarvelCharacter::class, MarvelComic::class], version = 1)
abstract class MarvelRoomDatabase : RoomDatabase() {

    abstract fun characterDAO(): CharacterDAO

    suspend fun saveCharacters(characters: List<MarvelCharacter>) = withContext(Contexts.IO) { characterDAO().insertAll(characters) }

    suspend fun updateCharacter(character: MarvelCharacter) = withContext(Contexts.IO) { characterDAO().update(character) }

    suspend fun deleteCharacter(character: MarvelCharacter) = withContext(Contexts.IO) { characterDAO().delete(character) }

    abstract fun comicDAO(): ComicDAO

    suspend fun saveComics(comics: List<MarvelComic>) = withContext(Contexts.IO) { comicDAO().insertAll(comics) }

    suspend fun updateComic(comic: MarvelComic) = withContext(Contexts.IO) { comicDAO().update(comic) }

    suspend fun deleteComic(comic: MarvelComic) = withContext(Contexts.IO) { comicDAO().delete(comic) }

    companion object {
        private var INSTANCE: MarvelRoomDatabase? = null
        @JvmStatic
        fun getInstance(context: Context): MarvelRoomDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext,
                    MarvelRoomDatabase::class.java,"location_db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE!!
        }
    }


}


