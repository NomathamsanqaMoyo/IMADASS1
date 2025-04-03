package vcmsa.ci.myfirstapp


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Views from the layout
        val timeInput: EditText = findViewById(R.id.timeInput)
        val suggestButton: Button = findViewById(R.id.suggestButton)
        val mealSuggestion: TextView = findViewById(R.id.mealSuggestion)

        // Set an onClickListener for the button
        suggestButton.setOnClickListener {

            // Get the time input from the EditText
            val timeString = timeInput.text.toString()

            // Check if the input is a valid number
            if (timeString.isNotEmpty()) {
                val time = timeString.toInt()

                // Use 'if' statements to suggest meals based on time
                when {
                    time in 6..9 -> {
                        mealSuggestion.text = "Breakfast: How about some pancakes or scrambled eggs?"
                    }
                    time in 10..14 -> {
                        mealSuggestion.text = "Lunch: Maybe a sandwich or a salad?"
                    }
                    time in 15..18 -> {
                        mealSuggestion.text = "Snack: Grab a smoothie or some nuts!"
                    }
                    time in 19..21 -> {
                        mealSuggestion.text = "Dinner: A nice pasta or grilled chicken would be great."
                    }
                    else -> {
                        mealSuggestion.text = "Invalid time. Please enter a time between 0 and 23."
                    }
                }
            } else {
                // Show an error if the input is empty
                Toast.makeText(this, "Please enter a valid time!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}