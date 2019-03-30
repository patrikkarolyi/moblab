package com.example.mobsoft.ui.list.adapaters

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.PagerAdapter
import com.example.mobsoft.R
import com.example.mobsoft.ui.list.favorite.FavoriteFragment
import com.example.mobsoft.ui.list.recent.RecentFragment

class ListPagerAdapter(private val context: Context,
                       fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private val fragments: ArrayList<Fragment> = ArrayList()

    init {
        fragments.add(RecentFragment())
        fragments.add(FavoriteFragment())
    }

    override fun getPageTitle(pos: Int): CharSequence? {
        return when(pos){
            0 -> context.getString(R.string.list_recent)
            1 -> context.getString(R.string.list_favorite)
            else -> throw IllegalArgumentException()
        }
    }

    override fun getItem(pos: Int): Fragment {
        return fragments[pos]
    }

    override fun getItemPosition(any: Any): Int {
        return PagerAdapter.POSITION_NONE
    }

    override fun getCount(): Int {
        return 2
    }
}
