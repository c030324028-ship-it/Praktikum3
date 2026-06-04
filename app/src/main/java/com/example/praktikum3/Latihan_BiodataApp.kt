package com.example.praktikum3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Latihan_BiodataApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_latihan_biodata_app)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var etNama = findViewById<EditText>(R.id.editTextNama)
        var etNIM = findViewById<EditText>(R.id.editTextNIM)
        var etNilai = findViewById<EditText>(R.id.editTextNilai)
        var btnProses = findViewById<Button>(R.id.buttonProses)

        btnProses.setOnClickListener {
            val nama = etNama.text.toString()
            val nim = etNIM.text.toString()
            val nilaiStr = etNilai.text.toString()

            // Validasi input
            if (nama.isEmpty() || nim.isEmpty() || nilaiStr.isEmpty()) {
                Toast.makeText(this, "Semua field harus diisi!", Toast.LENGTH_SHORT).show()
            }
            else if ((nilaiStr.toInt() > 100 && nilaiStr.toInt() < 0))
            {
                Toast.makeText(this, "Nilai harus berupa angka diantara 0 sampai 100!", Toast.LENGTH_SHORT).show()
                etNilai.setText("")
            }
            else
            {
                val nilai = nilaiStr.toInt()

                // Hitung grade
                val grade = when {
                    nilai >= 85 -> "A"
                    nilai >= 70 -> "B"
                    nilai >= 60 -> "C"
                    nilai >= 30 -> "D"
                    else -> "E"
                }

                val intent = Intent(this@Latihan_BiodataApp, Latihan_HasilBiodata::class.java)

                val mahasiswa = Mahasiswa(nama, nim, nilai, grade)

                intent.putExtra("MAHASISWA", mahasiswa)

                startActivity(intent)

//                Toast.makeText(this, "Grade anda adalah " + grade, Toast.LENGTH_SHORT).show()
            }

        }
    }
}