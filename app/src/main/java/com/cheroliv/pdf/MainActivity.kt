package com.cheroliv.pdf

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.cheroliv.pdf.StorageViewModel.Companion.logs
import com.cheroliv.pdf.StyleDsl.designInstructionMessage
import com.cheroliv.pdf.databinding.ActivityMainBinding.inflate
import org.koin.androidx.viewmodel.ext.android.getViewModel


class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        launchHomeScreen(layoutInflater, getViewModel())
    }

    @RequiresApi(Build.VERSION_CODES.R)
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
//        getExternalStorageDirectory().listFiles().
    }

}

