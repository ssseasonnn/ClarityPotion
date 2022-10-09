package zlc.season.claritypotion

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.Context
import java.lang.ref.WeakReference

@SuppressLint("StaticFieldLeak")
object ClarityPotion {
    lateinit var context: Context
    lateinit var contextImpl: Context
    lateinit var application: Application

    internal val activityTracker = ActivityTracker()

    val activity: Activity?
        get() = activityTracker.tryGetCurrentActivity()

    val activityList: List<WeakReference<Activity>>
        get() = activityTracker.getActivityList()
}