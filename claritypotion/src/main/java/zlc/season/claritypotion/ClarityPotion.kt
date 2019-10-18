package zlc.season.claritypotion

import android.annotation.SuppressLint
import android.app.Application
import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.net.Uri

@SuppressLint("StaticFieldLeak")
class ClarityPotion : ContentProvider() {

    companion object {
        lateinit var clarityPotion: Context

        lateinit var healingSalve: Application

        private val activityTracker = ActivityTracker()

        fun tryGetTopActivity() = activityTracker.tryGetTopActivity()
    }

    override fun onCreate(): Boolean {
        clarityPotion = context!!
        healingSalve = clarityPotion.applicationContext as Application

        activityTracker.beginTracking(healingSalve)
        return true
    }

    override fun query(
        uri: Uri, strings: Array<String>?, s: String?, strings1: Array<String>?,
        s1: String?
    ): Cursor? {
        return null
    }

    override fun getType(uri: Uri): String? {
        return null
    }

    override fun insert(uri: Uri, contentValues: ContentValues?): Uri? {
        return null
    }

    override fun delete(uri: Uri, s: String?, strings: Array<String>?): Int {
        return 0
    }

    override fun update(
        uri: Uri,
        contentValues: ContentValues?,
        s: String?,
        strings: Array<String>?
    ): Int {
        return 0
    }
}