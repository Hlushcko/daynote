package com.example.notes.Base.NotesRealization

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import com.example.notes.Base.Dao.DaoCommand
import com.example.notes.Base.Dao.DaoRepository
import com.example.notes.Base.Dao.RealizationDaoInterface
import com.example.notes.Base.RoomBase
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class ViewModelDataNotes(application: Application) : AndroidViewModel(application) {

    val context = application
    private lateinit var dao: DaoCommand
    private lateinit var repository: DaoRepository

    fun initBase(){
        dao = RoomBase.getInstance(context).getDaoBase()
        repository = RealizationDaoInterface(dao)
    }

    fun allNotes() : LiveData<List<Notes>>{
        return repository.allNotes
    }

    fun addNotes(notes: Notes){
        Observable
            .just(repository)
            .subscribeOn(Schedulers.io())
            .map { p -> p.saveBaseNotes(notes){} }
            .subscribe()
    }

    fun deleteNotes(notes: Notes){
        Observable
            .just(repository)
            .subscribeOn(Schedulers.io())
            .map { p -> p.deleteBaseNotes(notes){} }
            .subscribe()
    }

    fun getNoteById(id: Long) : LiveData<Notes>{
        return repository.notesById(id)
    }

    fun updateDescription(id: Long, description: String){
        Observable
            .just(repository)
            .subscribeOn(Schedulers.io())
            .map { p -> p.updateDescription(id, description){} }
            .subscribe()
    }

}
