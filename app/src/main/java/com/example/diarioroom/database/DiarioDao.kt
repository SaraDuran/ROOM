package com.example.diarioroom.database
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.diarioroom.model.Diario

@Dao
interface DiarioDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(diario: Diario)

    @Update
    suspend fun updateNote(diario: Diario)

    @Delete
    suspend fun deleteNote(diario: Diario)

    @Query("SELECT * FROM NOTES ORDER BY id DESC")
    fun getAllNotes(): LiveData<List<Diario>>

    @Query("SELECT * FROM NOTES WHERE noteTitle LIKE :query OR noteDesc LIKE :query")
    fun searchNote(query: String?): LiveData<List<Diario>>
}