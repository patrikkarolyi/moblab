package hu.bme.mobsoft.vergereader.ui.details

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import hu.bme.mobsoft.vergereader.R
import hu.bme.mobsoft.vergereader.injector
import javax.inject.Inject

class DetailsActivity : AppCompatActivity(), DetailsScreen {

    @Inject
    lateinit var presenter: DetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injector.inject(this)
    }

    override fun onStart() {
        super.onStart()
        presenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.detachScreen()
    }
}