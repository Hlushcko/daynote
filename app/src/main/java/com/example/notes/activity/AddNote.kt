package com.example.notes.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.notes.Base.NotesRealization.Notes
import com.example.notes.Base.NotesRealization.ViewModelDataNotes
import com.example.notes.R
import kotlin.properties.Delegates

class AddNote : AppCompatActivity() {

    private lateinit var viewModel: ViewModelDataNotes
    private lateinit var text: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        init()
    }

    fun init(){
        text = findViewById(R.id.createNameNotes)
        viewModel = ViewModelProvider(this).get(ViewModelDataNotes::class.java)
        viewModel.initBase()
    }

    fun SaveBaseNewNote(view: View) {
        viewModel.addNotes(Notes(0, text.text.toString(), ""))
        Toast.makeText(this, "Note created: complete ", Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, MainActivity::class.java))
    }
}