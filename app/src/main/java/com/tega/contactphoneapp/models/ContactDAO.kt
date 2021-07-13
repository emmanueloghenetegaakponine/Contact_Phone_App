package com.tega.contactphoneapp.models

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface ContactDAO {
    @Query("SELECT * FROM contact")
    fun getAllNotes() : List<Contact>

    @Query("SELECT * FROM contact WHERE id = :id")
    fun getNoteById(id: Int): Contact

    @Insert
    fun addNote(contact: Contact)

    @Delete
    fun deleteNote(contact: Contact)
}
