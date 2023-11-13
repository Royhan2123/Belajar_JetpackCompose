package com.example.weatherapi.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.weatherapi.data.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes_tbl")
    fun getNotes(): Flow<List<Note>>

    @Query("SELECT * FROM notes_tbl where id =:id")
    fun getNotesById(id: String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNote(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateNote(note: Note)

    @Query("DELETE FROM notes_tbl")
    fun deleteAll()

    @Delete
    fun deleteNote(note: Note)

}
