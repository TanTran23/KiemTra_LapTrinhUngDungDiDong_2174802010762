package com.example.kiemtra_laptrinhungdungdidong_2174802010762

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var tvEmail: TextView
    private lateinit var btnLogout: Button
    private lateinit var lvSkills: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // 3.2. Ánh xạ View bằng findViewById
        tvEmail   = findViewById(R.id.tvEmail)
        btnLogout = findViewById(R.id.btnLogout)
        lvSkills  = findViewById(R.id.lvSkills)

        // Nhận email từ LoginActivity (Câu 2)
        val email = intent.getStringExtra("EXTRA_EMAIL") ?: ""
        tvEmail.text = "Email: $email"

        btnLogout.setOnClickListener { finish() }

        // 3.3. Dữ liệu mảng môn học/kỹ năng
        val danhSachMon = arrayOf(
            "Lập trình Kotlin",
            "Thiết kế Layout XML",
            "Quản lý Git/GitHub",
            "Xử lý Intent",
            "Kiến trúc Android"
        )

        // 3.4. Gắn ArrayAdapter
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            danhSachMon
        )
        lvSkills.adapter = adapter

        // 3.5. Bắt sự kiện click từng item
        lvSkills.setOnItemClickListener { _, _, position, _ ->
            val monHoc = danhSachMon[position]
            Toast.makeText(this, "Bạn đã chọn: $monHoc", Toast.LENGTH_SHORT).show()
        }
    }
}
