package com.example.notes.Base.Dao

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.notes.Base.NotesRealization.Notes
import com.example.notes.Base.NotesRealization.ViewModelDataNotes

class RealizationDaoInterface(private val daoCommand: DaoCommand) : DaoRepository {

    override val allNotes: LiveData<List<Notes>>
    get() = daoCommand.getAllNotes()

    override fun notesById(id: Long): LiveData<Notes> {
        return daoCommand.getNotesById(id)
    }

    override fun saveBaseNotes(notes: Notes, onSuccess: () -> Unit) {
        daoCommand.saveBaseNotes(notes)
        onSuccess()
    }

    override fun deleteBaseNotes(notes: Notes, onSuccess: () -> Unit) {
        daoCommand.deleteBaseNotes(notes)
        onSuccess()
    }

    override fun updateDescription(idNotes: Long, newDescription: String, onSuccess: () -> Unit) {
        daoCommand.updateDescription(idNotes, newDescription)
        onSuccess()
    }


}