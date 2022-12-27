package com.cheroliv.pdf

import android.graphics.Typeface
import android.widget.TextView

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
}