package com.example.myplaylist

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed)
        val listBtn = findViewById<Button>(R.id.listBtn)
        val textAv = findViewById<TextView>(R.id.textAv)
        val  avBtn= findViewById<Button>(R.id.avBtn)
        val backBtn = findViewById<Button>(R.id.backBtn)

        val titles = intent.getStringArrayListExtra("titles") ?: arrayListOf()   // array list of all the categories from the main screen
        val artists = intent.getStringArrayListExtra("artists") ?: arrayListOf()
        val ratings = intent.getIntegerArrayListExtra("ratings") ?: arrayListOf()
        val comments = intent.getStringArrayListExtra("comments") ?: arrayListOf()

        val output = StringBuilder()
        for (i in titles.indices) {
            output.append("🎵 ${titles[i]} - ${artists[i]}\nRating: ${ratings[i]} | Comment: ${comments[i]}\n\n")  // shows  all the categories
        }

        listBtn .text = output.toString()

        avBtn.setOnClickListener {
            val avg = if (ratings.isNotEmpty()) ratings.sum().toDouble() / ratings.size else 0.0 // collecting and calculating the average
            textAv.text = "Average: %.2f".format(avg)
        }

        backBtn.setOnClickListener { //back to main
            finish()
        }
    }
}

