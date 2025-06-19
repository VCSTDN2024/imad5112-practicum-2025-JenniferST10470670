package com.example.myplaylist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

   // declared array list for playlist


    private val  songT= arrayListOf<String>()
    private val artists = arrayListOf<String>()
    private val rating = arrayListOf<Int>()
    private val comments = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val songT=findViewById<EditText>(R.id.songT)
        val artistN=findViewById<EditText>(R.id.artistN)
        val rating=findViewById<EditText>(R.id.rating)
        val comments=findViewById<EditText>(R.id.comments)

        val detailBtn=findViewById<Button>(R.id.detailBtn)
        val nextBtn=findViewById<Button>(R.id.nextBtn)
        val existBtn=findViewById<Button>(R.id.existBtn)

        detailBtn.setOnClickListener{  // if then statement to check statement that checks
                val title= songT.text.toString()
                val artists= artistN.text.toString()
                val rating =rating.text.toString()
                val comment= comments.text.toString()


            }

        if (title.isNotBlank() && artists.isNotEmpty() && rating != null && rating in 1..5) {

        }
        songT.add(title)
        artistN.add(artists)
        rating.ass(rating)
        comments.add(comments)
        Toast.makeText(this,songT)












        existBtn.setOnClickListener { // removed () and replaced with {}

            finishAffinity() // completely closes the app
        }

    }
}