package com.example.notes.Adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.notes.Base.NotesRealization.Notes
import com.example.notes.Base.NotesRealization.ViewModelDataNotes
import com.example.notes.R
import com.example.notes.activity.EditNote
import com.example.notes.activity.MainActivity
import kotlinx.android.synthetic.main.user_note.view.*

class NotesRecycleAdapter(list: List<Notes>, private var callbeck: Callback) : RecyclerView.Adapter<NotesRecycleAdapter.UserAdapter>() {

    private var notes: List<Notes> = list
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    public fun setList(list: List<Notes>) {
        notes = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.user_note, parent ,false)
        return UserAdapter(inflate, callbeck)
    }

    override fun onBindViewHolder(holder: UserAdapter, position: Int) {

        holder.itemView.setOnClickListener{ view ->
            callbeck.passResultCallback(notes.get(position))
        }

        holder.item.text = notes.get(position).nameNotes
        holder.clickNameNotes(notes.get(position))
        holder.clickDeleteNotes(notes.get(position))
        holder.clickEditNotes(notes.get(position))
    }

    override fun getItemCount(): Int = notes.size

    inner class UserAdapter(val view: View, callbeck: Callback) : RecyclerView.ViewHolder(view){
        var item: TextView = view.findViewById(R.id.nameNotes)
        var deleteNote: Button = view.findViewById(R.id.deleteNote)
        var editNote: Button = view.findViewById(R.id.editNote)
        var callbeckView = callbeck
        private val KEY_ID = "getId"


        fun clickNameNotes(notes: Notes){
            item.setOnClickListener { noteView ->
                createActivity(notes)
            }
        }

        fun clickDeleteNotes(notes: Notes){
            deleteNote.setOnClickListener { deleteView ->
                callbeckView.passResultCallback(notes)
            }
        }

        fun clickEditNotes(notes: Notes){
            editNote.setOnClickListener{ noteView  ->
                createActivity(notes)
            }
        }

        private fun createActivity(notes: Notes){
            var intent = Intent(view.context, EditNote::class.java)
            intent.putExtra(KEY_ID, notes.id)
            view.context.startActivity(intent)
        }

    }

    interface Callback{
        fun passResultCallback(notes: Notes)
    }

}

