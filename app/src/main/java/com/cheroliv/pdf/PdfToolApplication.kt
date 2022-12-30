package com.cheroliv.pdf

import android.app.Application
import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.context.startKoin
import org.koin.dsl.module


class PdfToolApplication : Application() {

    companion object {

        @Suppress("SpellCheckingInspection")
        const val LOGTAG = "foobar"
        @Suppress("unused")
        fun showToast(
            mainActivity: MainActivity,
            message: String
        ) = makeText(
            mainActivity,
            message,
            LENGTH_SHORT
        ).show()

    }
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@PdfToolApplication)
            modules(module { viewModelOf(::StorageViewModel) })
        }
    }
}