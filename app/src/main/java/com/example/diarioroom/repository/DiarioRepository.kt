package com.example.diarioroom.repository

import com.example.diarioroom.database.DiarioDatabase
import com.example.diarioroom.model.Diario

class DiarioRepository(private val db: DiarioDatabase) {

    suspend fun insertNote(note: Diario) = db.getNoteDao().insertNote(note)
    suspend fun deleteNote(note: Diario) = db.getNoteDao().deleteNote(note)
    suspend fun updateNote(note: Diario) = db.getNoteDao().updateNote(note)

    fun getAllNotes() = db.getNoteDao().getAllNotes()
    fun searchNote(query: String?) = db.getNoteDao().searchNote(query)

}