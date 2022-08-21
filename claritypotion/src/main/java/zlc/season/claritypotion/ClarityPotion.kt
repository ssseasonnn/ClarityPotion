package zlc.season.claritypotion

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.Context

@SuppressLint("StaticFieldLeak")
object ClarityPotion {
    lateinit var context: Context
    lateinit var contextImpl: Context
    lateinit var application: Application

    internal val activityTracker = ActivityTracker()

    val activity: Activity?
        get() = activityTracker.tryGetCurrentActivity()
}