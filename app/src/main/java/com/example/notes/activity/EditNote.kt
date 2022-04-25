package com.example.notes.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.notes.Base.NotesRealization.ViewModelDataNotes
import com.example.notes.R

class EditNote : AppCompatActivity() {

    private var myId: Long = 0
    private val KEY_EXTRA = "getId"
    private lateinit var description: String
    private lateinit var viewModel: ViewModelDataNotes
    private lateinit var text: EditText
    private lateinit var nameNote: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_note)

        init()

        myId = intent.getLongExtra(KEY_EXTRA, 0)

        viewModel.getNoteById(myId).observe(this, Observer { note ->
            description = note.description
            text.setText(note.description)
            nameNote.text = note.nameNotes
        })

    }

    fun init(){
        nameNote = findViewById(R.id.nameNote)
        text = findViewById(R.id.myDescription)
        viewModel = ViewModelProvider(this).get(ViewModelDataNotes::class.java)
        viewModel.initBase()
    }

    fun backMain(view: View) {
        startActivity(Intent(applicationContext, MainActivity::class.java))
    }

    fun save(view: View) {
        description = text.text.toString()
        viewModel.updateDescription(myId, description)
    }
}