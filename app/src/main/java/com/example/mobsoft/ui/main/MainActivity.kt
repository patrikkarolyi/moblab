package com.example.mobsoft.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.mobsoft.R
import com.example.mobsoft.injector
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainScreen {

    @Inject
    lateinit var presenter : MainPresenter

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
