package com.cheroliv.pdf

import android.os.Build.VERSION_CODES.R
import android.os.Environment
import android.util.Log.i
import androidx.annotation.RequiresApi
import java.io.File

object Logs{
    private const val LOG_TAG = "foobar"

    @RequiresApi(R)
    internal fun logs(){

        i(
            LOG_TAG, "getStorageDirectory().listFiles()?.size: ${
                Environment.getStorageDirectory().listFiles()?.size
            }"
        )

        i(
            LOG_TAG, "getExternalStorageDirectory().listFiles()?.size: ${
                Environment.getExternalStorageDirectory()
                    .listFiles()
                    ?.size
                    .toString()
            }"
        )

        i(LOG_TAG, "getExternalStorageDirectory().listFiles() is directory: ${
            Environment.getExternalStorageDirectory()
                .listFiles()
                ?.filter { it.isDirectory }
                ?.map { (it as File).name }
                ?.reduce { acc, name -> "$acc, $name" }
                .toString()
        }")

        i(LOG_TAG, "getStorageDirectory().listFiles(): ${
            Environment.getStorageDirectory()
                .listFiles()
                ?.map { (it as File).name }
                ?.reduce { acc, name -> "$acc, $name" }
                .toString()
        }")

        i(
            LOG_TAG, "getExternalStorageDirectory().path: ${
                Environment.getExternalStorageDirectory().path
            }"
        )

        i(
            LOG_TAG, "getExternalStorageDirectory().isFile: ${
                Environment.getExternalStorageDirectory().isFile
            }"
        )

        i(
            LOG_TAG, "getExternalStorageDirectory().isDirectory: ${
                Environment.getExternalStorageDirectory().isDirectory
            }"
        )
        //getStorageDirectory().listFiles(): emulated, enc_emulated, self
    }}