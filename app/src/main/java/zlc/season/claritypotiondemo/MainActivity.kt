package zlc.season.claritypotiondemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import zlc.season.claritypotion.ClarityPotion.Companion.clarityPotion
import zlc.season.claritypotion.ClarityPotion.Companion.currentActivity
import zlc.season.claritypotion.ClarityPotion.Companion.healingSalve

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println(clarityPotion.cacheDir)

        println(healingSalve)

        println(currentActivity())

        btn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
