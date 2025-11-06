package ro.pub.cs.systems.eim.colocviu1_1

import android.R.id.input
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import ro.pub.cs.systems.eim.colocviu1_1.Constants.BTNS_PRESSED
import ro.pub.cs.systems.eim.colocviu1_1.Constants.MAIN_ACTIVIVTY_TAG
import ro.pub.cs.systems.eim.colocviu1_1.Constants.INSTRUCTIONS
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.I
import androidx.compose.ui.tooling.preview.Preview
import ro.pub.cs.systems.eim.colocviu1_1.ui.theme.Colocviu1_1Theme
import kotlin.jvm.java

class MainActivity : ComponentActivity() {
    private lateinit var inputText: TextView
    private var btnsPressed = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colocviu1_1_main)

        inputText = findViewById(R.id.text_pressed)

        val buttonNorth = findViewById<Button>(R.id.btn_north)
        buttonNorth.setOnClickListener {
            btnsPressed++
            if (inputText.text.isEmpty())
                inputText.append("north")
            else
                inputText.append(", north")
        }

        val buttonSouth = findViewById<Button>(R.id.btn_south)
        buttonSouth.setOnClickListener {
            btnsPressed++
            if (inputText.text.isEmpty())
                inputText.append("south")
            else
                inputText.append(", south")
        }

        val buttonEast = findViewById<Button>(R.id.btn_east)
        buttonEast.setOnClickListener {
            btnsPressed++
            if (inputText.text.isEmpty())
                inputText.append("east")
            else
                inputText.append(", east")
        }

        val buttonWest = findViewById<Button>(R.id.btn_west)
        buttonWest.setOnClickListener {
            btnsPressed++
            if (inputText.text.isEmpty())
                inputText.append("west")
            else
                inputText.append(", west")
        }

        val activityResultsLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                Toast.makeText(this, "The activity returned with result REGISTER", Toast.LENGTH_LONG).show()
            }
            else if (result.resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "The activity returned with result CANCELED", Toast.LENGTH_LONG).show()
            }
        }

        val navigateToSecondaryActivityButton = findViewById<Button>(R.id.btn_next)
        navigateToSecondaryActivityButton.setOnClickListener {
            val intent = Intent(this, Colocviu1_1SecondaryActivity::class.java)
            intent.putExtra(INSTRUCTIONS, inputText.text.toString())
            activityResultsLauncher.launch(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        Log.d(MAIN_ACTIVIVTY_TAG, "save : btnsPressed=$btnsPressed")

        outState.putInt(BTNS_PRESSED, btnsPressed)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState.containsKey(BTNS_PRESSED)) {
            btnsPressed = savedInstanceState.getInt(BTNS_PRESSED)
        }

        Log.d(MAIN_ACTIVIVTY_TAG, "restore : btnsPressed=$btnsPressed")
    }
}