package com.example.myplaylist

import android.os.Bundle
import android.widget.Button
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
        val txtAverage = findViewById<TextView>(R.id.txtAverage)
        val  = findViewById<Button>(R.id.btnAverage)
        val btnBack = findViewById<Button>(R.id.btnBack)

        val titles = intent.getStringArrayListExtra("titles") ?: arrayListOf()
        val artists = intent.getStringArrayListExtra("artists") ?: arrayListOf()
        val ratings = intent.getIntegerArrayListExtra("ratings") ?: arrayListOf()
        val comments = intent.getStringArrayListExtra("comments") ?: arrayListOf()

        val output = StringBuilder()
        for (i in titles.indices) {
            output.append("🎵 ${titles[i]} - ${artists[i]}\nRating: ${ratings[i]} | Comment: ${comments[i]}\n\n")
        }

        txtList.text = output.toString()

        btnAverage.setOnClickListener {
            val avg = if (ratings.isNotEmpty()) ratings.sum().toDouble() / ratings.size else 0.0
            txtAverage.text = "Average: %.2f".format(avg)
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}

