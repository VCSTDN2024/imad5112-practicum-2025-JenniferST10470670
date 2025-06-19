package com.example.myplaylist

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val titles = arrayListOf(
        "this is us ", "Never be the same ", "Style", "Low"   // declared array list for playlist
    )

    private val artists = arrayListOf(
        "Beyonce ", "Selena gomez ", "doja cat",
    )

    private val ratings = arrayListOf(5, 4, 5, 4)   // declared maximum rating

    private val comments = arrayListOf(
        "I really like the melody",
        "I'm so honored you shared this with me.",  // array list of songs for comments
        "Not my type of music",
        "Love the beats vibe."
    )





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        setContentView(R.layout.activity_main)

        val songT = findViewById<EditText>(R.id.songT)
        val  artistN = findViewById<EditText>(R.id.artistN)
        val rating = findViewById<EditText>(R.id.rating)
        val comments = findViewById<EditText>(R.id.comments)
        val addBtn = findViewById<Button>(R.id.addBtn)
        val detailBtn = findViewById<Button>(R.id.detailBtn)
        val existBtn = findViewById<Button>(R.id.existBtn)

        addBtn.setOnClickListener {
            val title = songT.text.toString()
            val artist = artistN.text.toString()
            val rating = rating.text.toString().toIntOrNull()
            val comment = comments.text.toString()

            if (title.isEmpty() || artist.isEmpty() || rating == null || rating !in 1..5 || comment.isEmpty()) { // if then statements for error handling
                Toast.makeText(this, " ensure the  filled is correctly.", Toast.LENGTH_SHORT).show()
            } else if (titles.size >= 8) {
                Toast.makeText(this, "you have reached the maximum", Toast.LENGTH_SHORT).show()
            } else {
                titles.add(title)
                artists.add(artist)  //
                ratings.add(rating)

                Toast.makeText(this, "Song added!", Toast.LENGTH_SHORT).show()

                songT.text.clear()
                artistN.text.clear()

            }
        }

        detailBtn .setOnClickListener { // adding functionality to the detail button
            val intent = Intent(this, DetailedActivity::class.java).apply {
                putStringArrayListExtra("titles", titles)
                putStringArrayListExtra("artists", artists)
                putIntegerArrayListExtra("ratings", ArrayList(ratings))

            }
            startActivity(intent)
        }

        existBtn.setOnClickListener {
            finish()
        }
    }
}














