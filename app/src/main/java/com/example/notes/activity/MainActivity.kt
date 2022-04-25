package com.example.notes.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.Adapter.NotesRecycleAdapter
import com.example.notes.Base.NotesRealization.ViewModelDataNotes
import com.example.notes.Base.NotesRealization.Notes
import com.example.notes.R

class MainActivity : AppCompatActivity(), NotesRecycleAdapter.Callback {

    private lateinit var noteAdapter: NotesRecycleAdapter
    private lateinit var recycle: RecyclerView
    private lateinit var viewModel: ViewModelDataNotes
    private var listNotes = ArrayList<Notes>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        dataCheck()

    }


    private fun init(){
        recycle = findViewById(R.id.recyclerLinerNotes)
        viewModel = ViewModelProvider(this).get(ViewModelDataNotes::class.java)
        viewModel.initBase()
        noteAdapter = NotesRecycleAdapter(listNotes, this)
        recycle.layoutManager = LinearLayoutManager(applicationContext)
        recycle.adapter = noteAdapter
    }

    private fun dataCheck(){
        viewModel.allNotes().observe(this, Observer {
                listNotes -> noteAdapter.setList(listNotes)
        })
    }

    fun addNotes(view: View) {
        startActivity(Intent(applicationContext, AddNote::class.java))
    }

    override fun passResultCallback(notes: Notes) {
        viewModel.deleteNotes(notes)
    }


}