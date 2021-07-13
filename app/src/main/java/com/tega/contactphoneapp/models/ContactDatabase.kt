package com.tega.contactphoneapp.models

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase: RoomDatabase() {
    abstract fun noteDao(): ContactDAO
}