package zlc.season.claritypotiondemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import zlc.season.claritypotion.ClarityPotion.Companion.clarityPotion

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println(clarityPotion.cacheDir)
    }
}
