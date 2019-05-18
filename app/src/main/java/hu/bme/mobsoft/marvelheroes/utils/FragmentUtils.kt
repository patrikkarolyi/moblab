package hu.bme.mobsoft.marvelheroes.utils

import android.support.v4.app.Fragment
import hu.bme.mobsoft.marvelheroes.R

fun Fragment.add(f : Fragment){
    fragmentManager!!.beginTransaction()
        .add(R.id.detailsContainer, f)
        .commit()
}

fun Fragment.pop(){
    fragmentManager?.popBackStackImmediate()
}