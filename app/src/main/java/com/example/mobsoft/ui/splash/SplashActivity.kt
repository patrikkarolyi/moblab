package com.example.mobsoft.ui.splash

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.mobsoft.R
import com.example.mobsoft.injector
import com.example.mobsoft.ui.list.ListActivity
import javax.inject.Inject

class SplashActivity : AppCompatActivity(), SplashScreen {

    @Inject
    lateinit var presenter: SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        injector.inject(this)
    }

    override fun onStart() {
        super.onStart()
        presenter.attachScreen(this)
        presenter.navigateToListActivity()
    }

    override fun onStop() {
        super.onStop()
        presenter.detachScreen()
    }

    override fun navigateToListActivity() {
        startActivity(Intent(this,ListActivity::class.java))
        finish()
    }
}