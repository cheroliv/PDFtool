package com.cheroliv.pdf

import android.os.Build.VERSION_CODES.R
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.cheroliv.pdf.Logs.logs
import com.cheroliv.pdf.StyleDsl.designInstructionMessage
import com.cheroliv.pdf.databinding.ActivityMainBinding.inflate
import org.koin.androidx.viewmodel.ext.android.getViewModel


class MainActivity : AppCompatActivity() {

    @RequiresApi(R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        launchHomeScreen(layoutInflater, getViewModel())
    }

    @RequiresApi(R)
    private fun launchHomeScreen(
        layoutInflater: LayoutInflater,
        storageViewModel: StorageViewModel
    ) = apply {
        supportActionBar?.hide()
        inflate(layoutInflater).apply {
            setContentView(root)
            designInstructionMessage(selectFileLabelId, this@MainActivity)
        }
        logs()
    }

}

