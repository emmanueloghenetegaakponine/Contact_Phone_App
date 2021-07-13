package com.tega.contactphoneapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tega.contactphoneapp.models.Contact
import com.tega.contactphoneapp.models.ContactDatabase

class MainActivityViewModel : ViewModel() {

    val notesLiveData = MutableLiveData<List<Contact>>()

    fun getNotes(database: ContactDatabase){
        notesLiveData.postValue(database.noteDao().getAllNotes())
    }

    fun addNote(database: ContactDatabase, contact: Contact){
        database.noteDao().addNote(contact)
        getNotes(database)
    }

}