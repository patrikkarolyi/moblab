package com.example.mobsoft

import android.app.Activity
import android.support.v4.app.Fragment

val Activity.injector: VergeReaderApplicationComponent
    get() {
        return (this.applicationContext as VergeReaderApplication).injector
    }

val Fragment.injector: VergeReaderApplicationComponent
    get() {
        return (this.context!!.applicationContext as VergeReaderApplication).injector
    }