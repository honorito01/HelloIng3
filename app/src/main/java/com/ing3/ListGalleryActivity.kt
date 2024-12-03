package com.ing3

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListGalleryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_gallery)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imageView: ImageView = findViewById(R.id.imageView2)
        val textView: TextView = findViewById(R.id.textView_G)
        val btnNext: Button = findViewById(R.id.btn_next)
        val btnBack: Button = findViewById(R.id.btn_back)

        val ids: Array<Int> = arrayOf(
            R.drawable.maurice,
            R.drawable.eric,
            R.drawable.fred,
            R.drawable.saly,
            R.drawable.cabrel,
            R.drawable.marina,
            R.drawable.christian,
            R.drawable.doguy,
            R.drawable.eveline,
            R.drawable.janvier,
            R.drawable.larry,
            R.drawable.ted,
            R.drawable.karen,
            R.drawable.serge,
            R.drawable.theodore
        )

        var counter = 0

        val length = ids.size
        var currentImage = counter + 1

        imageView.setImageResource(ids[0])

        btnNext.setOnClickListener {
            counter++
            if (counter >= length) {
                counter = 0
                currentImage = 0
            }
            imageView.setImageResource(ids[counter])
            currentImage++
        }

        btnBack.setOnClickListener {
            counter--
            if (counter < 0) {
                counter = length - 1
                currentImage = 0
            }
            imageView.setImageResource(ids[counter])
            currentImage--
        }

    }
}