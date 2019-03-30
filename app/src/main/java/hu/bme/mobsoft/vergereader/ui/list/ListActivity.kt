package hu.bme.mobsoft.vergereader.ui.list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import hu.bme.mobsoft.vergereader.R
import hu.bme.mobsoft.vergereader.injector
import hu.bme.mobsoft.vergereader.ui.list.adapaters.ListPagerAdapter
import kotlinx.android.synthetic.main.activity_list.*
import javax.inject.Inject

class ListActivity : AppCompatActivity(), ListScreen {

    @Inject
    lateinit var presenter: ListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
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

    override fun onResume() {
        super.onResume()
        listViewPager.adapter =
            ListPagerAdapter(baseContext!!, supportFragmentManager!!)
        listSlidingTabs.setupWithViewPager(listViewPager)

    }
}