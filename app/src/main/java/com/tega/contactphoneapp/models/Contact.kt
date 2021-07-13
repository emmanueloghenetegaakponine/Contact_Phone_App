package com.tega.contactphoneapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val content: String,


)
