package com.cheroliv.pdf

import android.view.LayoutInflater
import com.cheroliv.pdf.databinding.ActivityMainBinding.inflate

fun MainActivity.launchHomeScreen(
    layoutInflater: LayoutInflater
): MainActivity = apply {
    supportActionBar?.hide()
    inflate(layoutInflater).apply {
        setContentView(root)
        designInstructionMessage(selectFileLabelId)
    }
}


