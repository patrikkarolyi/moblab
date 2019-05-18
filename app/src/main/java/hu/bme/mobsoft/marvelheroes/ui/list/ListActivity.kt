package hu.bme.mobsoft.marvelheroes.ui.list

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.view.ContextThemeWrapper
import hu.bme.mobsoft.marvelheroes.R
import hu.bme.mobsoft.marvelheroes.ui.list.adapter.ListPagerAdapter
import kotlinx.android.synthetic.main.activity_list.*
import com.crashlytics.android.Crashlytics
import com.google.firebase.analytics.FirebaseAnalytics
import io.fabric.sdk.android.Fabric



class ListActivity : AppCompatActivity() {

    private lateinit var firebaseAnalytics : FirebaseAnalytics


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fabric.with(this, Crashlytics())
        setContentView(R.layout.activity_list)
        firebaseAnalytics = FirebaseAnalytics.getInstance(this)
        listViewPager.adapter = ListPagerAdapter(baseContext!!, supportFragmentManager!!)
        listSlidingTabs.setupWithViewPager(listViewPager)


        val bundle  = Bundle().apply {
            putString(FirebaseAnalytics.Param.ITEM_NAME,"login")
        }
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.LOGIN,bundle)
    }

    override fun onBackPressed() {
        val builder = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme))
        builder.setCancelable(false)
        builder.setMessage(getString(R.string.quit_question))
        builder.setPositiveButton(getString(R.string.quit)) { dialog, _ ->
            dialog.cancel()
            super.onBackPressed()
        }
        builder.setNegativeButton(getString(R.string.cancel)) { dialog, _ ->
            dialog.cancel()
        }
        builder.show()
    }

}