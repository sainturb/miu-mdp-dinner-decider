package miu.edu.dinnerdecider

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val foods: MutableList<String> = mutableListOf("Hamburger", "Pizza", "Mexican", "American", "Chinese")
    private var selected = foods[0]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addButton = findViewById<Button>(R.id.addFood)
        addButton.setOnClickListener {
            addFood()
        }

        val decideButton = findViewById<Button>(R.id.decide)
        decideButton.setOnClickListener {
            pickOne()
        }
    }

    private fun addFood() {
        val input = findViewById<EditText>(R.id.addNewFood)
        if (input.text.isNotEmpty()) {
            val text = input.text.toString();
            foods.add(text)
            input.text.clear()
            val message = "The item \"" + text + "\" has been added to list. Length of list is now " + foods.size;
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun pickOne() {
        val number = Random.nextInt(foods.size)
        selected = foods[number]

        val name = findViewById<TextView>(R.id.name)
        name.text = selected
    }
}