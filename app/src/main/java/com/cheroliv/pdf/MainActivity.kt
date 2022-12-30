package com.cheroliv.pdf

import android.content.res.Configuration.UI_MODE_NIGHT_MASK
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.graphics.Color.DKGRAY
import android.graphics.Typeface.MONOSPACE
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getColor
import com.cheroliv.pdf.R.color.purple_200
import com.cheroliv.pdf.StyleDsl.applyColor
import com.cheroliv.pdf.StyleDsl.applyFont
import com.cheroliv.pdf.StyleDsl.changeFontSize
import com.cheroliv.pdf.StyleDsl.styleWith
import com.cheroliv.pdf.databinding.ActivityMainBinding.inflate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        launchHomeScreen(layoutInflater)
    }

    private fun launchHomeScreen(
        layoutInflater: LayoutInflater
    ) = apply {
        supportActionBar?.hide()
        inflate(layoutInflater).apply {
            setContentView(root)
            designInstructionMessage(selectFileLabelId)
        }
    }

    private fun designInstructionMessage(textView: TextView) {
        styleWith(textView) {
            applyFont { MONOSPACE }
            changeFontSize { 18 }
            applyColor {
                when (UI_MODE_NIGHT_YES) {
                    context
                        .resources
                        .configuration
                        .uiMode
                        .and(UI_MODE_NIGHT_MASK) -> getColor(
                        context,
                        purple_200
                    )
                    else -> DKGRAY
                }
            }
        }
    }
}