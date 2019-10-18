package zlc.season.claritypotiondemo

import android.app.Application
import zlc.season.claritypotion.ClarityPotion

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        println(ClarityPotion.tryGetTopActivity())
    }
}