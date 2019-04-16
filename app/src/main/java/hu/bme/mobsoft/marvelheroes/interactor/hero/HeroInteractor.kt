package hu.bme.mobsoft.marvelheroes.interactor.hero

import hu.bme.mobsoft.marvelheroes.interactor.Contexts
import hu.bme.mobsoft.marvelheroes.network.api.HeroApi
import hu.bme.mobsoft.marvelheroes.network.model.Hero
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HeroInteractor @Inject constructor(private var heroApi: HeroApi) {

    suspend fun getHero(heroId: Int): Hero = withContext(Contexts.IO) {
        heroApi.getHero(heroId = heroId).execute().body()!!
    }

}