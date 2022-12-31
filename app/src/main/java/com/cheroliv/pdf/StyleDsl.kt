package com.cheroliv.pdf

import android.content.Context
import android.content.res.Configuration.UI_MODE_NIGHT_MASK
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.graphics.Color.DKGRAY
import android.graphics.Typeface
import android.graphics.Typeface.MONOSPACE
import android.widget.TextView
import androidx.core.content.ContextCompat.getColor
import com.cheroliv.pdf.R.color.purple_200
@Suppress("MemberVisibilityCanBePrivate")
object StyleDsl {

    fun styleWith(
        textView: TextView,
        block: TextView.() -> Unit
    ): TextView = textView.apply { block(textView) }


    inline fun TextView.applyFont(applyStyle: () -> Typeface) {
        typeface = applyStyle()
    }

    inline fun TextView.changeFontSize(fontStyle: () -> Int) {
        textSize = fontStyle().toFloat()
    }

    inline fun TextView.applyColor(colorLambda: () -> Int) {
        setTextColor(colorLambda())
    }

    fun designInstructionMessage(textView: TextView, context: Context) {
        styleWith(textView) {
            applyFont { MONOSPACE }
            changeFontSize { 18 }
            applyColor {
                when (UI_MODE_NIGHT_YES) {
                    context
                        .resources
                        .configuration
                        .uiMode
                        .and(UI_MODE_NIGHT_MASK) -> getColor(context, purple_200)
                    else -> DKGRAY
                }
            }
        }
    }

}