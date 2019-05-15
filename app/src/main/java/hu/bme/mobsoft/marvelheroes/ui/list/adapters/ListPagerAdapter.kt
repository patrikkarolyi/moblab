package hu.bme.mobsoft.marvelheroes.ui.list.adapters

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.PagerAdapter
import hu.bme.mobsoft.marvelheroes.ui.list.comics.ComicsFragment
import hu.bme.mobsoft.marvelheroes.ui.list.characters.CharactersFragment
import hu.bme.mobsoft.marvelheroes.R

class ListPagerAdapter(
    private val context: Context,
    fm: FragmentManager
) : FragmentStatePagerAdapter(fm) {

    private val fragments: ArrayList<Fragment> = ArrayList()

    init {
        fragments.add(CharactersFragment())
        fragments.add(ComicsFragment())
    }

    override fun getPageTitle(pos: Int): CharSequence? {
        return when(pos){
            0 -> context.getString(R.string.list_characters)
            1 -> context.getString(R.string.list_comics)
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

