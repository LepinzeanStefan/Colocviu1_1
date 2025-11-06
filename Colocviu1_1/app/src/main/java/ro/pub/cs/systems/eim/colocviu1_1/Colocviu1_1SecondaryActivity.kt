package ro.pub.cs.systems.eim.colocviu1_1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.app.ComponentActivity

class Colocviu1_1SecondaryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colocviu1_1_secondary)

        val instDisplay = findViewById<TextView>(R.id.inst)
        val input = intent.getStringExtra(Constants.INSTRUCTIONS)

        instDisplay.append(input ?: "")


        val okButton = findViewById<Button>(R.id.register_button)
        okButton.setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }

        val cancelButton = findViewById<Button>(R.id.cancel_button)
        cancelButton.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
    }
}