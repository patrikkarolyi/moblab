package hu.bme.mobsoft.marvelheroes.model.marvelapi

/**
 *
 * @param code
 * @param data;
 */
data class MarvelCharacterResponse(
    val code: Int? = null,
    val status: String? = null,
    val copyright: String? = null,
    val data: MarvelCharacterWrapper? = null
)