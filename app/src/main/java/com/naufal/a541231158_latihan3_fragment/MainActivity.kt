package com.naufal.a541231158_latihan3_fragment

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.naufal.a541231158_latihan3_fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private fun setupPermissions() {
        val permission = ContextCompat.checkSelfPermission(
            this,
            android.Manifest.permission.CALL_PHONE
        )
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.CALL_PHONE),
                CALL_REQUEST_CODE
            )
        }
    }
    companion object{
        const val CALL_REQUEST_CODE = 100
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setContentView(binding.root)
        setupPermissions()
        binding.apply {
            btnProdi.setOnClickListener {
                val namaProdi = inputProdi.text.toString()
                if (namaProdi.isEmpty()) {
                    inputProdi.error = "Prodi Tidak Boleh Kosong"
                    return@setOnClickListener
                }

                btnCallBrowser.setOnClickListener{
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse("http://smktelkom-pwt.sch.id/")
                    startActivity(intent)
                }
                btnCallCamera.setOnClickListener{
                    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivity(intent)
                }
                btnCallPhone.setOnClickListener{
                    val phoneNumber = inputPhoneNumber.getText()
                    if (phoneNumber.isEmpty()) {
                        inputPhoneNumber.error = "Nomor Telpon Tidak Boleh Kosong"
                        return@setOnClickListener
                    }
                    val intent = Intent(Intent.ACTION_CALL)
                    intent.data = Uri.parse("tel:" + phoneNumber)
                    startActivity(intent)
                }
                val moveWithDataIntent = Intent(this@MainActivity, Fragment::class.java)
                moveWithDataIntent.putExtra(Fragment.EXTRA_PRODI, namaProdi)
                startActivity(moveWithDataIntent)
            }
        }
    }
}