package com.cheroliv.pdf

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.io.File

@Suppress("unused")
class StorageViewModel : ViewModel() {
    private val _currentDirectory: MutableLiveData<File> = MutableLiveData()

    val currentDirectory: LiveData<File> = _currentDirectory

    private val _selectedFile: MutableLiveData<File> = MutableLiveData()
    val selectedFile: LiveData<File> = _selectedFile
}