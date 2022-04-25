package com.example.notes.Base.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notes.Base.NotesRealization.Notes

@Dao
interface DaoCommand {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveBaseNotes(notes: Notes)

    @Delete
    fun deleteBaseNotes(notes: Notes)

    @Query("SELECT * FROM notes")
    fun getAllNotes(): LiveData<List<Notes>>

    @Query("SELECT * FROM notes WHERE id =:myId")
    fun getNotesById(myId: Long): LiveData<Notes>

    @Query("UPDATE notes SET description = :newDescription WHERE id = :idNotes")
    fun updateDescription(idNotes: Long, newDescription: String)

}