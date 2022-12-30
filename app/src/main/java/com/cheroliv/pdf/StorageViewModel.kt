package com.cheroliv.pdf

import android.os.Build
import android.os.Environment
import android.util.Log
import android.util.Log.i
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cheroliv.pdf.PdfToolApplication.Companion.LOGTAG
import java.io.File

@Suppress("unused")
class StorageViewModel : ViewModel() {
    private val _currentDirectory: MutableLiveData<File> = MutableLiveData()

    val currentDirectory: LiveData<File> = _currentDirectory

    private val _selectedFile: MutableLiveData<File> = MutableLiveData()
    val selectedFile: LiveData<File> = _selectedFile

    companion object {
        @RequiresApi(Build.VERSION_CODES.R)
        fun logs(){

            i(
                LOGTAG, "getStorageDirectory().listFiles()?.size: ${
                    Environment.getStorageDirectory().listFiles()?.size
                }"
            )

            i(
                LOGTAG, "getExternalStorageDirectory().listFiles()?.size: ${
                    Environment.getExternalStorageDirectory()
                        .listFiles()
                        ?.size
                        .toString()
                }"
            )

            i(LOGTAG, "getExternalStorageDirectory().listFiles() is directory: ${
                Environment.getExternalStorageDirectory()
                    .listFiles()
                    ?.filter { it.isDirectory }
                    ?.map { (it as File).name }
                    ?.reduce { acc, name -> "$acc, $name" }
                    .toString()
            }")

            i(LOGTAG, "getStorageDirectory().listFiles(): ${
                Environment.getStorageDirectory()
                    .listFiles()
                    ?.map { (it as File).name }
                    ?.reduce { acc, name -> "$acc, $name" }
                    .toString()
            }")

            i(
                LOGTAG, "getExternalStorageDirectory().path: ${
                    Environment.getExternalStorageDirectory().path
                }"
            )

            i(
                LOGTAG, "getExternalStorageDirectory().isFile: ${
                    Environment.getExternalStorageDirectory().isFile
                }"
            )

            i(
                LOGTAG, "getExternalStorageDirectory().isDirectory: ${
                    Environment.getExternalStorageDirectory().isDirectory
                }"
            )
            //getStorageDirectory().listFiles(): emulated, enc_emulated, self
        }}
}