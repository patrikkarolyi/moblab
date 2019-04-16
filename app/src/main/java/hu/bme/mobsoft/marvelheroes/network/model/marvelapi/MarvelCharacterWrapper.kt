package hu.bme.mobsoft.marvelheroes.network.model.marvelapi

/**
 *
 * @param count
 * @param results
 */
data class MarvelCharacterWrapper (
    val count: Int? = null,
    val total: Int? = null,
    val results: List<MarvelCharacter>? = null
)