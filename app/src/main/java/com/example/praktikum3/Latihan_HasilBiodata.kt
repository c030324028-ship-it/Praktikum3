package com.example.praktikum3

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.praktikum3.databinding.ActivityLatihanHasilBiodataBinding

class Latihan_HasilBiodata : AppCompatActivity() {
    private lateinit var binding: ActivityLatihanHasilBiodataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_latihan_hasil_biodata)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = ActivityLatihanHasilBiodataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mahasiswa = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("MAHASISWA", Mahasiswa::class.java)
        }
        else {
            @SuppressWarnings("DEPRECATION")
            intent.getParcelableExtra<Mahasiswa>("MAHASISWA")
        }

        binding.tvNama.text = "Nama\t: ${mahasiswa?.nama}"
        binding.tvNIM.text = "NIM\t\t: ${mahasiswa?.nim}"
        binding.tvNilai.text = "Nilai\t\t: ${mahasiswa?.nilai}"
        binding.tvGrade.text = "Grade: ${mahasiswa?.grade}"

        // Bonus: warna grade dinamis
        binding.tvGrade.setTextColor(
            when (mahasiswa?.grade) {
                "A" -> 0xFF4CAF50.toInt() // hijau
                "B" -> 0xFF2196F3.toInt() // biru
                "C" -> 0xFFFF9800.toInt() // orange
                else -> 0xFFF44336.toInt() // merah
            }
        )
    }
}