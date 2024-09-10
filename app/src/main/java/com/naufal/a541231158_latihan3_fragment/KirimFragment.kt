package com.naufal.a541231158_latihan3_fragment

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class KirimFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_kirim_fragment)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.frame_container)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val mFragmentManager = supportFragmentManager
        val mFirstFragment = DataFragment()
        val fragment = mFragmentManager.findFragmentByTag(DataFragment::class.java.simpleName)
        if (fragment !is DataFragment) {
            Log.d("MyFlexibleFragment", "Fragment Name :" + DataFragment::class.java.simpleName)
            mFragmentManager
                .beginTransaction()
                .add(R.id.frame_container, mFirstFragment, DataFragment::class.java.simpleName)
                .commit()
        }
    }
}