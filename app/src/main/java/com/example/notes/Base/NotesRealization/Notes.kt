package com.example.notes.Base.NotesRealization

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity( tableName = "notes" )
data class Notes(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "name_notes") val nameNotes: String,
    val description: String
)