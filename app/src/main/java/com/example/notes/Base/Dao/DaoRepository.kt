package com.example.notes.Base.Dao

import androidx.lifecycle.LiveData
import com.example.notes.Base.NotesRealization.Notes

interface DaoRepository {
    val allNotes: LiveData<List<Notes>>
    fun notesById(id: Long): LiveData<Notes>
    fun saveBaseNotes(notes: Notes, onSuccess:() -> Unit )
    fun deleteBaseNotes(notes: Notes, onSuccess: () -> Unit)
    fun updateDescription(idNotes: Long, newDescription: String, onSuccess: () -> Unit)
}