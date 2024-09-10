package com.naufal.a541231158_latihan3_fragment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.naufal.a541231158_latihan3_fragment.databinding.ActivityFragmentBinding

class Fragment : AppCompatActivity() {
    private val binding: ActivityFragmentBinding by lazy {
        ActivityFragmentBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fragment)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setContentView(binding.root)
        val prodi = intent.getStringExtra(EXTRA_PRODI)
        binding.lblProdiSaya.text = "Prodi Saya Adalah $prodi"
    }
    companion object {
        const val EXTRA_PRODI = "extra_prodi"
    }
}