package zlc.season.claritypotiondemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import zlc.season.claritypotion.ClarityPotion

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println(ClarityPotion.context.cacheDir)

        println(ClarityPotion.application)

        println(ClarityPotion.activity)

        findViewById<View>(R.id.btn).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
