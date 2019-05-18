package hu.bme.mobsoft.marvelheroes.ui.list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import hu.bme.mobsoft.marvelheroes.R
import hu.bme.mobsoft.marvelheroes.ui.list.adapter.ListPagerAdapter
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        listViewPager.adapter = ListPagerAdapter(baseContext!!, supportFragmentManager!!)
        listSlidingTabs.setupWithViewPager(listViewPager)
    }



}