package com.example.kiemtra_laptrinhungdungdidong_2174802010762


import android.graphics.Color
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtEmail    = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin    = findViewById(R.id.btnLogin)
        tvStatus    = findViewById(R.id.tvStatus)

        btnLogin.setOnClickListener { dangNhap() }
    }

    private fun dangNhap() {
        val email = edtEmail.text.toString().trim()
        val matKhau = edtPassword.text.toString()

        when {
            email.isEmpty() && matKhau.isEmpty() ->
                baoLoi("Lỗi: Vui lòng nhập Email và Mật khẩu!")

            email.isEmpty() ->
                baoLoi("Lỗi: Email không được để trống!")

            matKhau.isEmpty() ->
                baoLoi("Lỗi: Mật khẩu không được để trống!")

            !Patterns.EMAIL_ADDRESS.matcher(email).matches() ->
                baoLoi("Lỗi: Email sai định dạng!")

            matKhau.length < 6 ->
                baoLoi("Lỗi: Mật khẩu phải có ít nhất 6 ký tự!")

            else -> {
                tvStatus.setTextColor(Color.parseColor("#2E7D32"))
                tvStatus.text = "Xác thực thành công!"
                val intent = Intent(this, ProfileActivity::class.java)
                intent.putExtra("EXTRA_EMAIL", email)
                startActivity(intent)
            }
        }
    }

    private fun baoLoi(noiDung: String) {
        tvStatus.setTextColor(Color.RED)
        tvStatus.text = noiDung
    }
}