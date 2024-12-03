package com.ing3

import android.content.Intent
import android.content.pm.PackageManager
import android.net.InetAddresses
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        val tvSalutation: TextView = findViewById(R.id.tv_salutation)
        val btnGallery: Button = findViewById(R.id.button_gallery)
        val btnSubjects: Button = findViewById(R.id.button_subjects)
        val btnSendmail: Button = findViewById(R.id.button_sendmail)

        btnGallery.setOnClickListener{
            tvSalutation.setText("Welcome to Ing 3 Gallery")

            val intent = Intent(this, GalleryActivity::class.java)
            startActivity(intent)
        }

            btnSubjects.setOnClickListener{
            tvSalutation.setText("Welcome to Ing 3 Subjects")

            val intent = Intent(this,SubjectsActivity::class.java)
            startActivity(intent)
        }

        btnSendmail.setOnClickListener{
            sendEmail()
        }

    }

    fun sendEmail() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("hehe@gmail.com", "haha@gmail.com"))
        intent.putExtra(Intent.EXTRA_TEXT, "How are you")
        intent.putExtra(Intent.EXTRA_SUBJECT, "Salutations")

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

}