package zlc.season.claritypotion


import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.os.Looper
import java.lang.ref.WeakReference

class ActivityTracker {
    private val activities = mutableListOf<WeakReference<Activity>>()

    private val lifecycleCallbacks = object : ActivityLifecycleCallbacksAdapter() {
        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
            add(activity)
        }

        override fun onActivityDestroyed(activity: Activity) {
            remove(activity)
        }
    }

    fun beginTracking(application: Application) {
        application.registerActivityLifecycleCallbacks(lifecycleCallbacks)
    }

    fun endTracking(application: Application) {
        application.unregisterActivityLifecycleCallbacks(lifecycleCallbacks)
    }

    fun tryGetTopActivity(): Activity? {
        activities.reversed().forEach {
            val activity = it.get()
            if (activity != null) {
                return activity
            }
        }
        return null
    }

    private fun add(activity: Activity) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            activities.add(WeakReference(activity))
        } else {
            throw IllegalStateException("Must in Main Thread!")
        }
    }

    private fun remove(activity: Activity) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            removeFromWeakList(activities, activity)
        } else {
            throw IllegalStateException("Must in Main Thread!")
        }
    }

    private fun <T> removeFromWeakList(
        list: MutableList<WeakReference<T>>, needle: T
    ) {
        var i = 0
        val n = list.size
        while (i < n) {
            val hay = list[i].get()
            if (hay === needle) {
                list.removeAt(i)
            }
            i++
        }
    }
}
