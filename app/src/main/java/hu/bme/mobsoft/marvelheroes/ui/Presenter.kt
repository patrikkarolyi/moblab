package hu.bme.mobsoft.marvelheroes.ui

import hu.bme.mobsoft.marvelheroes.interactor.Contexts
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class Presenter<S> : CoroutineScope {

    protected var screen: S? = null
    protected var job: Job? = null


    override val coroutineContext: CoroutineContext
        get() {
            if (job == null) throw UninitializedPropertyAccessException("Presenter is not attached!")
            else return Contexts.UI + job!!
        }


    open fun attachScreen(screen: S) {
        this.screen = screen
        job = Job()
    }

    open fun detachScreen() {
        this.screen = null
        job?.cancel()
    }

}