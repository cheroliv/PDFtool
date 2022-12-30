package com.cheroliv.pdf

import android.content.res.Configuration.UI_MODE_NIGHT_MASK
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.graphics.Color.DKGRAY
import android.graphics.Typeface.MONOSPACE
import android.widget.TextView
import androidx.core.content.ContextCompat.getColor
import com.cheroliv.pdf.R.color.purple_200
import com.cheroliv.pdf.StyleDsl.applyColor
import com.cheroliv.pdf.StyleDsl.applyFont
import com.cheroliv.pdf.StyleDsl.changeFontSize
import com.cheroliv.pdf.StyleDsl.styleWith

fun designInstructionMessage(textView: TextView) {
    styleWith(textView) {
        applyFont { MONOSPACE }
        changeFontSize { 18 }
        applyColor {
            if (context
                    .resources
                    .configuration
                    .uiMode
                    .and(UI_MODE_NIGHT_MASK) == UI_MODE_NIGHT_YES
            ) getColor(
                context,
                purple_200
            )
            else DKGRAY
        }
    }
}