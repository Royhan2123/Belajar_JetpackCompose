package com.example.latihanviewmodel.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDatabaseDao {

    @Query("SELECT * FROM table_note")
    fun getNotes(): List<Note>

    @Query("SELECT * FROM table_note where id =:id")
    suspend fun getNotesById(id:String):Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Note)

    @Query("DELETE FROM table_note")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteNote(note: Note)
}
