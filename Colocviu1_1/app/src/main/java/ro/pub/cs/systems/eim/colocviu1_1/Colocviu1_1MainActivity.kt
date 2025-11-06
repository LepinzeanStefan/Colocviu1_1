package ro.pub.cs.systems.eim.colocviu1_1

import android.R.id.input
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import ro.pub.cs.systems.eim.colocviu1_1.Constants.BTNS_PRESSED
import ro.pub.cs.systems.eim.colocviu1_1.Constants.MAIN_ACTIVIVTY_TAG
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ro.pub.cs.systems.eim.colocviu1_1.ui.theme.Colocviu1_1Theme

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