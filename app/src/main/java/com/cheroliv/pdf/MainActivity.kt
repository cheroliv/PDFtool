package com.cheroliv.pdf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cheroliv.pdf.databinding.ActivityMainBinding.inflate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inflate(layoutInflater).apply{
            setContentView(root)
        }
    }
}