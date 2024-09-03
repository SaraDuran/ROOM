package com.example.diarioroom.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.diarioroom.model.Diario
import com.example.diarioroom.repository.DiarioRepository
import kotlinx.coroutines.launch

class DiarioViewModel(app: Application, private val diarioRepository: DiarioRepository): AndroidViewModel(app)  {

    fun addNote(note: Diario) =
        viewModelScope.launch {
            diarioRepository.insertNote(note)
        }

    fun deleteNote(note: Diario) =
        viewModelScope.launch {
            diarioRepository.deleteNote(note)
        }

    fun updateNote(note: Diario) =
        viewModelScope.launch {
            diarioRepository.updateNote(note)
        }

    fun getAllNotes() = diarioRepository.getAllNotes()

    fun searchNote(query: String?) =
        diarioRepository.searchNote(query)
}