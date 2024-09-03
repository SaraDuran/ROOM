package com.example.diarioroom.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "notes")
@Parcelize
data class Diario(
    @PrimaryKey(autoGenerate = true)
    val valid: Int,
    val noteTitle: String,
    val noteDesc: String
): Parcelable