package hu.bme.mobsoft.vergereader

import dagger.Component
import hu.bme.mobsoft.vergereader.interactor.InteractorModule
import hu.bme.mobsoft.vergereader.ui.UIModule
import hu.bme.mobsoft.vergereader.ui.details.DetailsActivity
import hu.bme.mobsoft.vergereader.ui.list.ListActivity
import hu.bme.mobsoft.vergereader.ui.splash.SplashActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, InteractorModule::class])//, NetworkModule::class, ])
interface VergeReaderApplicationComponent {

    fun inject(splashActivity: SplashActivity)
    fun inject(listActivity: ListActivity)
    fun inject(detailsActivity: DetailsActivity)
}