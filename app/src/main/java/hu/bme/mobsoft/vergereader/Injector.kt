package hu.bme.mobsoft.vergereader

import android.app.Activity
import android.support.v4.app.Fragment
import hu.bme.mobsoft.vergereader.VergeReaderApplication
import hu.bme.mobsoft.vergereader.VergeReaderApplicationComponent

val Activity.injector: VergeReaderApplicationComponent
    get() {
        return (this.applicationContext as VergeReaderApplication).injector
    }

val Fragment.injector: VergeReaderApplicationComponent
    get() {
        return (this.context!!.applicationContext as VergeReaderApplication).injector
    }