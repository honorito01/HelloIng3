package com.ing3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GalleryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_gallery)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnConsulter: Button = findViewById(R.id.button_consulter)
        val btnAjouter: Button = findViewById(R.id.button_ajouter)

        btnConsulter.setOnClickListener{
            val intent = Intent(this,ListGalleryActivity::class.java)
            startActivity(intent)
        }

        btnAjouter.setOnClickListener{
            val intent = Intent(this,AddGalleryActivity::class.java)
            startActivity(intent)
        }


    }
}