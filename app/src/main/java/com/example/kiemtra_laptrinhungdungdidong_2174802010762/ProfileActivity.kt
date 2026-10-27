package com.example.kiemtra_laptrinhungdungdidong_2174802010762

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var tvEmail: TextView
    private lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        tvEmail   = findViewById(R.id.tvEmail)
        btnLogout = findViewById(R.id.btnLogout)

        val email = intent.getStringExtra("EXTRA_EMAIL") ?: ""
        tvEmail.text = "Email: $email"

        btnLogout.setOnClickListener { finish() }
    }
}