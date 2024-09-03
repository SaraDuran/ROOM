package com.example.diarioroom.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.diarioroom.repository.DiarioRepository


class DiarioViewModelFactory (val app: Application, private val diarioRepository: DiarioRepository) : ViewModelProvider.Factory  {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DiarioViewModel(app, diarioRepository) as T
    }
}